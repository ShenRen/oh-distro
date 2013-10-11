/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package drc;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class atlas_behavior_step_params_t implements lcm.lcm.LCMEncodable
{
    public drc.atlas_step_data_t desired_step;
    public int use_relative_step_height;
    public int use_demo_walk;
 
    public atlas_behavior_step_params_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x064fb0fd7dd6c738L;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(drc.atlas_behavior_step_params_t.class))
            return 0L;
 
        classes.add(drc.atlas_behavior_step_params_t.class);
        long hash = LCM_FINGERPRINT_BASE
             + drc.atlas_step_data_t._hashRecursive(classes)
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
        this.desired_step._encodeRecursive(outs); 
 
        outs.writeInt(this.use_relative_step_height); 
 
        outs.writeInt(this.use_demo_walk); 
 
    }
 
    public atlas_behavior_step_params_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public atlas_behavior_step_params_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static drc.atlas_behavior_step_params_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        drc.atlas_behavior_step_params_t o = new drc.atlas_behavior_step_params_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.desired_step = drc.atlas_step_data_t._decodeRecursiveFactory(ins);
 
        this.use_relative_step_height = ins.readInt();
 
        this.use_demo_walk = ins.readInt();
 
    }
 
    public drc.atlas_behavior_step_params_t copy()
    {
        drc.atlas_behavior_step_params_t outobj = new drc.atlas_behavior_step_params_t();
        outobj.desired_step = this.desired_step.copy();
 
        outobj.use_relative_step_height = this.use_relative_step_height;
 
        outobj.use_demo_walk = this.use_demo_walk;
 
        return outobj;
    }
 
}

