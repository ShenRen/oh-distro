classdef ZMPwalkingPlanner < DrakeSystem
% The input to the system is COM height, foot placement within a preview
% window, and current COM
% The output of the system is the COM trajectory and cost-to-go trajectory
    methods
        function obj = ZMPwalkingPlanner(window_size,max_contact_pts,dt,g)
            % @param window, the time breaks in the preview window
            % @param foot step, the foot step trajectory
            % @height, the COM height in the preview window
            tic
            obj = obj@DrakeSystem(0,...
                0,...
                2+window_size*(max_contact_pts*3+1),... % number of inputs are the current planar COM, the position of the contact points, and the com height
                3*window_size,...% number of outputs, com positions in the previe window
                true,...
                true);
            obj.window_size = window_size;
            obj.max_contact_pts = max_contact_pts;
            obj.dt = dt;
            obj.A = sparse([1 0 obj.dt 0;0 1 0 obj.dt;0 0 1 0;0 0 0 1]);
            obj.B = sparse([obj.dt^2/2 0;0 obj.dt^2/2;obj.dt 0;0 obj.dt]);
            obj.C = sparse([1 0 0 0;0 1 0 0]);
            obj.g = g;
            % M and N are for dense formulation of optimization
            obj.M = zeros(2*obj.window_size,4);
            obj.N = zeros(2*obj.window_size);
            obj.M(1:2,:) = obj.C;
            obj.N(1:2,:) = zeros(2,2*obj.window_size);
            for i = 2:obj.window_size
                obj.M((i-1)*2+(1:2),:) = obj.M((i-2)*2+(1:2),:)*obj.A;
                obj.N((i-1)*2+(1:2),1:2) = obj.M((i-2)*2+(1:2),:)*obj.B;
                obj.N((i-1)*2+(1:2),3:end) = obj.N((i-2)*2+(1:2),1:end-2);
            end
            toc
        end
        
        function com_pos = output(obj,t,~,u)
            % u = [current planar com, contact positions in the preview
            % window, active_contact_flag,com height in the preview window]
            profile on
            tic
            com_x0 = u(1);
            com_y0 = u(2);
            comdot_x0 = u(3);
            comdot_y0 = u(4);
            contact_pos = reshape(u(4+(1:obj.window_size*obj.max_contact_pts*3)),3,obj.max_contact_pts,obj.window_size);
            active_contact_flag = logical(reshape(u(4+obj.window_size*obj.max_contact_pts*3+...
                (1:obj.window_size*obj.max_contact_pts)),obj.max_contact_pts,obj.window_size));
%             num_active_contact = sum(active_contact_flag,1);
            z_com = reshape(u(4+obj.window_size*obj.max_contact_pts*4+(1:obj.window_size)),1,[]);
            t_breaks = linspace(t,t+obj.dt*(obj.window_size-1),obj.window_size);
            z_com_pp = spline(t_breaks,z_com);
            zddot_com = ppval(fnder(z_com_pp,2),t_breaks);
            % The followings are for the dense formulation
            % The decision variables are the weight of the convex support
            % polygon vertices, the com acceleration
            N = obj.N;
            support_vertices = cell(1,obj.window_size);
            convex_comb = cell(1,obj.window_size);
            support_center = zeros(2,obj.window_size);
            D_val = reshape(repmat(-z_com./(zddot_com+obj.g),2,1),[],1);
            N = N+diag(D_val);
%             active_contact_pos = contact_pos(1:2,reshape(active_contact_flag,1,[]));
%             support_vert_mat = mat2cell(active_contact_pos,2,num_active_contact);
%             support_vert_mat = blkdiag(support_vert_mat{:});
%             n_weights = sum(num_active_contact);
%             convex_comb_mat = mat2cell(ones(1,n_weights),1,num_active_contact);
%             convex_comb_mat = blkdiag(convex_comb_mat{:});
            % This for loop is ugly, try vectorize it later, or use sparse
            % formulation
            for i = 1:obj.window_size
%                 Di = -z_com(i)/(zddot_com(i)+obj.g)*eye(2);
%                 N((i-1)*2+(1:2),(i-1)*2+(1:2))  = obj.N((i-1)*2+(1:2),(i-1)*2+(1:2))+Di;
                active_contact_pos = contact_pos(:,active_contact_flag(:,i),i);
                support_vertices_ind_i = convhull(active_contact_pos(1,:),active_contact_pos(2,:));
                support_vertices{i} = active_contact_pos(1:2,support_vertices_ind_i);
                convex_comb{i} = ones(1,length(support_vertices_ind_i));
                support_center(:,i) = [mean(active_contact_pos(1,:));mean(active_contact_pos(2,:))];
            end
            x0y = obj.M*[com_x0;com_y0;comdot_x0;comdot_y0]; % This is the effect of initial com on preview com
            support_vert_mat = blkdiag(support_vertices{:});
            n_weights = size(support_vert_mat,2);
            convex_comb_mat = blkdiag(convex_comb{:});
            Aeq = [support_vert_mat -N;convex_comb_mat zeros(size(convex_comb_mat,1),2*obj.window_size)];
            beq = [x0y; ones(obj.window_size,1)];
            lb = [0.1*ones(n_weights,1);-inf(2*obj.window_size,1)];
            ub = inf(n_weights+2*obj.window_size,1);
            R_u = 0.1*eye(2*obj.window_size);
            H = 2*([zeros(2*obj.window_size,n_weights) eye(2*obj.window_size)]'...
                *(N'*N+R_u)*[zeros(2*obj.window_size,n_weights) eye(2*obj.window_size)]);
            f = (x0y-reshape(support_center,[],1))'*N*[zeros(2*obj.window_size,n_weights) eye(2*obj.window_size)];
            
            [sol,fval,exitflag] = cplexqp(H,f,[],[],Aeq,beq,lb,ub,[1/obj.max_contact_pts*ones(n_weights,1);zeros(2*obj.window_size,1)]);
            
            comddot_sol = reshape(sol(n_weights+(1:2*obj.window_size)),2,obj.window_size);
            com_sol = reshape(x0y+N*reshape(comddot_sol,[],1),2,obj.window_size);
            com_pos = com_sol(:,1);
            toc
            profile off
            profile viewer
        end
    end
    properties
        max_contact_pts;
        window_size;
        dt;
        A;
        B;
        C;
        g;
        M;
        N;
    end
end