/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package drc;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class atlas_power_hands_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public byte power_left;
    public byte power_right;
 
    public atlas_power_hands_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0xc84cf627e8792671L;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(drc.atlas_power_hands_t.class))
            return 0L;
 
        classes.add(drc.atlas_power_hands_t.class);
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
 
        outs.writeByte(this.power_left); 
 
        outs.writeByte(this.power_right); 
 
    }
 
    public atlas_power_hands_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public atlas_power_hands_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static drc.atlas_power_hands_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        drc.atlas_power_hands_t o = new drc.atlas_power_hands_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.utime = ins.readLong();
 
        this.power_left = ins.readByte();
 
        this.power_right = ins.readByte();
 
    }
 
    public drc.atlas_power_hands_t copy()
    {
        drc.atlas_power_hands_t outobj = new drc.atlas_power_hands_t();
        outobj.utime = this.utime;
 
        outobj.power_left = this.power_left;
 
        outobj.power_right = this.power_right;
 
        return outobj;
    }
 
}

