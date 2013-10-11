/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package drc;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class ee_cartesian_adjust_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public byte ee_type;
    public drc.vector_3d_t pos_delta;
    public drc.vector_3d_t rpy_delta;
 
    public ee_cartesian_adjust_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x868b2e6bd21735b7L;
 
    public static final byte LEFT_HAND = (byte) 0;
    public static final byte RIGHT_HAND = (byte) 1;

    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(drc.ee_cartesian_adjust_t.class))
            return 0L;
 
        classes.add(drc.ee_cartesian_adjust_t.class);
        long hash = LCM_FINGERPRINT_BASE
             + drc.vector_3d_t._hashRecursive(classes)
             + drc.vector_3d_t._hashRecursive(classes)
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
 
        outs.writeByte(this.ee_type); 
 
        this.pos_delta._encodeRecursive(outs); 
 
        this.rpy_delta._encodeRecursive(outs); 
 
    }
 
    public ee_cartesian_adjust_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public ee_cartesian_adjust_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static drc.ee_cartesian_adjust_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        drc.ee_cartesian_adjust_t o = new drc.ee_cartesian_adjust_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.utime = ins.readLong();
 
        this.ee_type = ins.readByte();
 
        this.pos_delta = drc.vector_3d_t._decodeRecursiveFactory(ins);
 
        this.rpy_delta = drc.vector_3d_t._decodeRecursiveFactory(ins);
 
    }
 
    public drc.ee_cartesian_adjust_t copy()
    {
        drc.ee_cartesian_adjust_t outobj = new drc.ee_cartesian_adjust_t();
        outobj.utime = this.utime;
 
        outobj.ee_type = this.ee_type;
 
        outobj.pos_delta = this.pos_delta.copy();
 
        outobj.rpy_delta = this.rpy_delta.copy();
 
        return outobj;
    }
 
}

