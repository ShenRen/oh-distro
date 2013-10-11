/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package drc;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class localize_reinitialize_cmd_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public double mean[];
    public double variance[];
 
    public localize_reinitialize_cmd_t()
    {
        mean = new double[3];
        variance = new double[3];
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x8b2b2c682707e3f5L;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(drc.localize_reinitialize_cmd_t.class))
            return 0L;
 
        classes.add(drc.localize_reinitialize_cmd_t.class);
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
 
        for (int a = 0; a < 3; a++) {
            outs.writeDouble(this.mean[a]); 
        }
 
        for (int a = 0; a < 3; a++) {
            outs.writeDouble(this.variance[a]); 
        }
 
    }
 
    public localize_reinitialize_cmd_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public localize_reinitialize_cmd_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static drc.localize_reinitialize_cmd_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        drc.localize_reinitialize_cmd_t o = new drc.localize_reinitialize_cmd_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.utime = ins.readLong();
 
        this.mean = new double[(int) 3];
        for (int a = 0; a < 3; a++) {
            this.mean[a] = ins.readDouble();
        }
 
        this.variance = new double[(int) 3];
        for (int a = 0; a < 3; a++) {
            this.variance[a] = ins.readDouble();
        }
 
    }
 
    public drc.localize_reinitialize_cmd_t copy()
    {
        drc.localize_reinitialize_cmd_t outobj = new drc.localize_reinitialize_cmd_t();
        outobj.utime = this.utime;
 
        outobj.mean = new double[(int) 3];
        System.arraycopy(this.mean, 0, outobj.mean, 0, 3); 
        outobj.variance = new double[(int) 3];
        System.arraycopy(this.variance, 0, outobj.variance, 0, 3); 
        return outobj;
    }
 
}

