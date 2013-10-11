/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package drc;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class plan_collect_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public byte type;
    public int n_plan_samples;
    public double sample_period;
 
    public plan_collect_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0xa1c14955a13c3c62L;
 
    public static final byte LEFT_ARM = (byte) 0;
    public static final byte RIGHT_ARM = (byte) 1;
    public static final byte BOTH_ARMS = (byte) 2;

    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(drc.plan_collect_t.class))
            return 0L;
 
        classes.add(drc.plan_collect_t.class);
        long hash = LCM_FINGERPRINT_BASE
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
 
        outs.writeByte(this.type); 
 
        outs.writeInt(this.n_plan_samples); 
 
        outs.writeDouble(this.sample_period); 
 
    }
 
    public plan_collect_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public plan_collect_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static drc.plan_collect_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        drc.plan_collect_t o = new drc.plan_collect_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.utime = ins.readLong();
 
        this.type = ins.readByte();
 
        this.n_plan_samples = ins.readInt();
 
        this.sample_period = ins.readDouble();
 
    }
 
    public drc.plan_collect_t copy()
    {
        drc.plan_collect_t outobj = new drc.plan_collect_t();
        outobj.utime = this.utime;
 
        outobj.type = this.type;
 
        outobj.n_plan_samples = this.n_plan_samples;
 
        outobj.sample_period = this.sample_period;
 
        return outobj;
    }
 
}

