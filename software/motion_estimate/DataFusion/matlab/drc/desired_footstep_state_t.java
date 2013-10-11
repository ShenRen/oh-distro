/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package drc;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class desired_footstep_state_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public String robot_name;
    public String support_surface_name;
    public int unique_id;
    public short footstep_type;
    public drc.position_3d_t foot_pose;
    public int num_joints;
    public String joint_name[];
    public double joint_position[];
 
    public desired_footstep_state_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x49922ac03ee96ea3L;
 
    public static final short LEFT = (short) 0;
    public static final short RIGHT = (short) 1;

    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(drc.desired_footstep_state_t.class))
            return 0L;
 
        classes.add(drc.desired_footstep_state_t.class);
        long hash = LCM_FINGERPRINT_BASE
             + drc.position_3d_t._hashRecursive(classes)
            ;
        classes.remove(classes.size() - 1);
        return (hash<<1) + ((hash>>63)&1);
    }
 
    public void encode(DataOutput outs) throws IOException
    {
        outs.writeLong(LCM_FINGERPRINT);
        _encodeRecursive(outs);
    }
 
    public void _encodeRecursive(DataOutput outs) throws IOException
    {
        char[] __strbuf = null;
        outs.writeLong(this.utime); 
 
        __strbuf = new char[this.robot_name.length()]; this.robot_name.getChars(0, this.robot_name.length(), __strbuf, 0); outs.writeInt(__strbuf.length+1); for (int _i = 0; _i < __strbuf.length; _i++) outs.write(__strbuf[_i]); outs.writeByte(0); 
 
        __strbuf = new char[this.support_surface_name.length()]; this.support_surface_name.getChars(0, this.support_surface_name.length(), __strbuf, 0); outs.writeInt(__strbuf.length+1); for (int _i = 0; _i < __strbuf.length; _i++) outs.write(__strbuf[_i]); outs.writeByte(0); 
 
        outs.writeInt(this.unique_id); 
 
        outs.writeShort(this.footstep_type); 
 
        this.foot_pose._encodeRecursive(outs); 
 
        outs.writeInt(this.num_joints); 
 
        for (int a = 0; a < this.num_joints; a++) {
            __strbuf = new char[this.joint_name[a].length()]; this.joint_name[a].getChars(0, this.joint_name[a].length(), __strbuf, 0); outs.writeInt(__strbuf.length+1); for (int _i = 0; _i < __strbuf.length; _i++) outs.write(__strbuf[_i]); outs.writeByte(0); 
        }
 
        for (int a = 0; a < this.num_joints; a++) {
            outs.writeDouble(this.joint_position[a]); 
        }
 
    }
 
    public desired_footstep_state_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public desired_footstep_state_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static drc.desired_footstep_state_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        drc.desired_footstep_state_t o = new drc.desired_footstep_state_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        char[] __strbuf = null;
        this.utime = ins.readLong();
 
        __strbuf = new char[ins.readInt()-1]; for (int _i = 0; _i < __strbuf.length; _i++) __strbuf[_i] = (char) (ins.readByte()&0xff); ins.readByte(); this.robot_name = new String(__strbuf);
 
        __strbuf = new char[ins.readInt()-1]; for (int _i = 0; _i < __strbuf.length; _i++) __strbuf[_i] = (char) (ins.readByte()&0xff); ins.readByte(); this.support_surface_name = new String(__strbuf);
 
        this.unique_id = ins.readInt();
 
        this.footstep_type = ins.readShort();
 
        this.foot_pose = drc.position_3d_t._decodeRecursiveFactory(ins);
 
        this.num_joints = ins.readInt();
 
        this.joint_name = new String[(int) num_joints];
        for (int a = 0; a < this.num_joints; a++) {
            __strbuf = new char[ins.readInt()-1]; for (int _i = 0; _i < __strbuf.length; _i++) __strbuf[_i] = (char) (ins.readByte()&0xff); ins.readByte(); this.joint_name[a] = new String(__strbuf);
        }
 
        this.joint_position = new double[(int) num_joints];
        for (int a = 0; a < this.num_joints; a++) {
            this.joint_position[a] = ins.readDouble();
        }
 
    }
 
    public drc.desired_footstep_state_t copy()
    {
        drc.desired_footstep_state_t outobj = new drc.desired_footstep_state_t();
        outobj.utime = this.utime;
 
        outobj.robot_name = this.robot_name;
 
        outobj.support_surface_name = this.support_surface_name;
 
        outobj.unique_id = this.unique_id;
 
        outobj.footstep_type = this.footstep_type;
 
        outobj.foot_pose = this.foot_pose.copy();
 
        outobj.num_joints = this.num_joints;
 
        outobj.joint_name = new String[(int) num_joints];
        if (this.num_joints > 0)
            System.arraycopy(this.joint_name, 0, outobj.joint_name, 0, this.num_joints); 
        outobj.joint_position = new double[(int) num_joints];
        if (this.num_joints > 0)
            System.arraycopy(this.joint_position, 0, outobj.joint_position, 0, this.num_joints); 
        return outobj;
    }
 
}

