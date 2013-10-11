/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package drc;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class precompute_request_t implements lcm.lcm.LCMEncodable
{
    public long utime;
    public String robot_name;
    public String response_channel;
    public int precompute_type;
    public int n_bytes;
    public byte matdata[];
 
    public precompute_request_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0xc251c9701df53343L;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(drc.precompute_request_t.class))
            return 0L;
 
        classes.add(drc.precompute_request_t.class);
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
 
        __strbuf = new char[this.robot_name.length()]; this.robot_name.getChars(0, this.robot_name.length(), __strbuf, 0); outs.writeInt(__strbuf.length+1); for (int _i = 0; _i < __strbuf.length; _i++) outs.write(__strbuf[_i]); outs.writeByte(0); 
 
        __strbuf = new char[this.response_channel.length()]; this.response_channel.getChars(0, this.response_channel.length(), __strbuf, 0); outs.writeInt(__strbuf.length+1); for (int _i = 0; _i < __strbuf.length; _i++) outs.write(__strbuf[_i]); outs.writeByte(0); 
 
        outs.writeInt(this.precompute_type); 
 
        outs.writeInt(this.n_bytes); 
 
        if (this.n_bytes > 0)
            outs.write(this.matdata, 0, n_bytes);
 
    }
 
    public precompute_request_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public precompute_request_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static drc.precompute_request_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        drc.precompute_request_t o = new drc.precompute_request_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        char[] __strbuf = null;
        this.utime = ins.readLong();
 
        __strbuf = new char[ins.readInt()-1]; for (int _i = 0; _i < __strbuf.length; _i++) __strbuf[_i] = (char) (ins.readByte()&0xff); ins.readByte(); this.robot_name = new String(__strbuf);
 
        __strbuf = new char[ins.readInt()-1]; for (int _i = 0; _i < __strbuf.length; _i++) __strbuf[_i] = (char) (ins.readByte()&0xff); ins.readByte(); this.response_channel = new String(__strbuf);
 
        this.precompute_type = ins.readInt();
 
        this.n_bytes = ins.readInt();
 
        this.matdata = new byte[(int) n_bytes];
        ins.readFully(this.matdata, 0, n_bytes); 
    }
 
    public drc.precompute_request_t copy()
    {
        drc.precompute_request_t outobj = new drc.precompute_request_t();
        outobj.utime = this.utime;
 
        outobj.robot_name = this.robot_name;
 
        outobj.response_channel = this.response_channel;
 
        outobj.precompute_type = this.precompute_type;
 
        outobj.n_bytes = this.n_bytes;
 
        outobj.matdata = new byte[(int) n_bytes];
        if (this.n_bytes > 0)
            System.arraycopy(this.matdata, 0, outobj.matdata, 0, this.n_bytes); 
        return outobj;
    }
 
}

