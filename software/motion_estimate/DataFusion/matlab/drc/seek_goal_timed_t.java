/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package drc;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class seek_goal_timed_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public long timeout;
    public String robot_name;
    public byte type;
 
    public seek_goal_timed_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x8526b68f43640695L;
 
    public static final byte VISUAL_GLOBAL = (byte) 0;
    public static final byte VISUAL_RELATIVE = (byte) 1;

    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(drc.seek_goal_timed_t.class))
            return 0L;
 
        classes.add(drc.seek_goal_timed_t.class);
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
        char[] __strbuf = null;
        outs.writeLong(this.utime); 
 
        outs.writeLong(this.timeout); 
 
        __strbuf = new char[this.robot_name.length()]; this.robot_name.getChars(0, this.robot_name.length(), __strbuf, 0); outs.writeInt(__strbuf.length+1); for (int _i = 0; _i < __strbuf.length; _i++) outs.write(__strbuf[_i]); outs.writeByte(0); 
 
        outs.writeByte(this.type); 
 
    }
 
    public seek_goal_timed_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public seek_goal_timed_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static drc.seek_goal_timed_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        drc.seek_goal_timed_t o = new drc.seek_goal_timed_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        char[] __strbuf = null;
        this.utime = ins.readLong();
 
        this.timeout = ins.readLong();
 
        __strbuf = new char[ins.readInt()-1]; for (int _i = 0; _i < __strbuf.length; _i++) __strbuf[_i] = (char) (ins.readByte()&0xff); ins.readByte(); this.robot_name = new String(__strbuf);
 
        this.type = ins.readByte();
 
    }
 
    public drc.seek_goal_timed_t copy()
    {
        drc.seek_goal_timed_t outobj = new drc.seek_goal_timed_t();
        outobj.utime = this.utime;
 
        outobj.timeout = this.timeout;
 
        outobj.robot_name = this.robot_name;
 
        outobj.type = this.type;
 
        return outobj;
    }
 
}

