/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package drc;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class recovery_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public byte mode;
    public byte controller;
 
    public recovery_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0xc93398360359f8a7L;
 
    public static final byte MODE_PROJECTILE_READY = (byte) 0;
    public static final byte MODE_PROJECTILE_LEAP = (byte) 1;
    public static final byte MODE_FACEUP_TO_FACEDOWN = (byte) 2;
    public static final byte MODE_FACEDOWN_TO_FACEUP = (byte) 3;
    public static final byte MODE_FLAT_OUT = (byte) 4;
    public static final byte MODE_FLAT_OUT_SLOW = (byte) 5;
    public static final byte MODE_FLAT_OUT_KNEES_OUT = (byte) 6;
    public static final byte MODE_FACEUP_TO_FACEDOWN_NEW = (byte) 7;
    public static final byte MODE_CAR_WIGGLE = (byte) 8;
    public static final byte MODE_GENTLE_FALL = (byte) 9;
    public static final byte MODE_KNEE_RISE_SET = (byte) 10;
    public static final byte MODE_KNEE_RISE = (byte) 11;
    public static final byte MODE_KNEE_FINISH = (byte) 12;
    public static final byte MODE_CRAWL_SET = (byte) 20;
    public static final byte MODE_CRAWL = (byte) 21;
    public static final byte MODE_CRAWL_LEFT = (byte) 22;
    public static final byte MODE_CRAWL_LEFT_LARGE = (byte) 23;
    public static final byte MODE_CRAWL_RIGHT = (byte) 24;
    public static final byte MODE_CRAWL_RIGHT_LARGE = (byte) 25;
    public static final byte CONTROLLER_UNKNOWN = (byte) 0;
    public static final byte CONTROLLER_STANDING = (byte) 1;
    public static final byte CONTROLLER_WALKING = (byte) 2;
    public static final byte CONTROLLER_HARNESSED = (byte) 3;
    public static final byte CONTROLLER_QUASISTATIC = (byte) 4;
    public static final byte CONTROLLER_BRACING = (byte) 5;

    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(drc.recovery_t.class))
            return 0L;
 
        classes.add(drc.recovery_t.class);
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
 
        outs.writeByte(this.mode); 
 
        outs.writeByte(this.controller); 
 
    }
 
    public recovery_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public recovery_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static drc.recovery_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        drc.recovery_t o = new drc.recovery_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.utime = ins.readLong();
 
        this.mode = ins.readByte();
 
        this.controller = ins.readByte();
 
    }
 
    public drc.recovery_t copy()
    {
        drc.recovery_t outobj = new drc.recovery_t();
        outobj.utime = this.utime;
 
        outobj.mode = this.mode;
 
        outobj.controller = this.controller;
 
        return outobj;
    }
 
}

