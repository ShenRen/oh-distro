/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package drc;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class atlas_control_data_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public drc.atlas_command_t joints;
    public drc.atlas_behavior_stand_params_t stand_params;
    public drc.atlas_behavior_step_params_t step_params;
    public drc.atlas_behavior_walk_params_t walk_params;
    public drc.atlas_behavior_manipulate_params_t manipulate_params;
 
    public atlas_control_data_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x09d4695a954bdb17L;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(drc.atlas_control_data_t.class))
            return 0L;
 
        classes.add(drc.atlas_control_data_t.class);
        long hash = LCM_FINGERPRINT_BASE
             + drc.atlas_command_t._hashRecursive(classes)
             + drc.atlas_behavior_stand_params_t._hashRecursive(classes)
             + drc.atlas_behavior_step_params_t._hashRecursive(classes)
             + drc.atlas_behavior_walk_params_t._hashRecursive(classes)
             + drc.atlas_behavior_manipulate_params_t._hashRecursive(classes)
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
        outs.writeLong(this.utime); 
 
        this.joints._encodeRecursive(outs); 
 
        this.stand_params._encodeRecursive(outs); 
 
        this.step_params._encodeRecursive(outs); 
 
        this.walk_params._encodeRecursive(outs); 
 
        this.manipulate_params._encodeRecursive(outs); 
 
    }
 
    public atlas_control_data_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public atlas_control_data_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static drc.atlas_control_data_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        drc.atlas_control_data_t o = new drc.atlas_control_data_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.utime = ins.readLong();
 
        this.joints = drc.atlas_command_t._decodeRecursiveFactory(ins);
 
        this.stand_params = drc.atlas_behavior_stand_params_t._decodeRecursiveFactory(ins);
 
        this.step_params = drc.atlas_behavior_step_params_t._decodeRecursiveFactory(ins);
 
        this.walk_params = drc.atlas_behavior_walk_params_t._decodeRecursiveFactory(ins);
 
        this.manipulate_params = drc.atlas_behavior_manipulate_params_t._decodeRecursiveFactory(ins);
 
    }
 
    public drc.atlas_control_data_t copy()
    {
        drc.atlas_control_data_t outobj = new drc.atlas_control_data_t();
        outobj.utime = this.utime;
 
        outobj.joints = this.joints.copy();
 
        outobj.stand_params = this.stand_params.copy();
 
        outobj.step_params = this.step_params.copy();
 
        outobj.walk_params = this.walk_params.copy();
 
        outobj.manipulate_params = this.manipulate_params.copy();
 
        return outobj;
    }
 
}

