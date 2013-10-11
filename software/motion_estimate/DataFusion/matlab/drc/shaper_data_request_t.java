/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package drc;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class shaper_data_request_t implements lcm.lcm.LCMEncodable
{
    public String channel;
    public byte priority;
 
    public shaper_data_request_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x30903acfde7e3b26L;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(drc.shaper_data_request_t.class))
            return 0L;
 
        classes.add(drc.shaper_data_request_t.class);
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
        __strbuf = new char[this.channel.length()]; this.channel.getChars(0, this.channel.length(), __strbuf, 0); outs.writeInt(__strbuf.length+1); for (int _i = 0; _i < __strbuf.length; _i++) outs.write(__strbuf[_i]); outs.writeByte(0); 
 
        outs.writeByte(this.priority); 
 
    }
 
    public shaper_data_request_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public shaper_data_request_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static drc.shaper_data_request_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        drc.shaper_data_request_t o = new drc.shaper_data_request_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        char[] __strbuf = null;
        __strbuf = new char[ins.readInt()-1]; for (int _i = 0; _i < __strbuf.length; _i++) __strbuf[_i] = (char) (ins.readByte()&0xff); ins.readByte(); this.channel = new String(__strbuf);
 
        this.priority = ins.readByte();
 
    }
 
    public drc.shaper_data_request_t copy()
    {
        drc.shaper_data_request_t outobj = new drc.shaper_data_request_t();
        outobj.channel = this.channel;
 
        outobj.priority = this.priority;
 
        return outobj;
    }
 
}

