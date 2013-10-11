/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package drc;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class link_transform_t implements lcm.lcm.LCMEncodable
{
    public String link_name;
    public drc.transform_t tf;
 
    public link_transform_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x331198844bd43e3eL;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(drc.link_transform_t.class))
            return 0L;
 
        classes.add(drc.link_transform_t.class);
        long hash = LCM_FINGERPRINT_BASE
             + drc.transform_t._hashRecursive(classes)
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
        __strbuf = new char[this.link_name.length()]; this.link_name.getChars(0, this.link_name.length(), __strbuf, 0); outs.writeInt(__strbuf.length+1); for (int _i = 0; _i < __strbuf.length; _i++) outs.write(__strbuf[_i]); outs.writeByte(0); 
 
        this.tf._encodeRecursive(outs); 
 
    }
 
    public link_transform_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public link_transform_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static drc.link_transform_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        drc.link_transform_t o = new drc.link_transform_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        char[] __strbuf = null;
        __strbuf = new char[ins.readInt()-1]; for (int _i = 0; _i < __strbuf.length; _i++) __strbuf[_i] = (char) (ins.readByte()&0xff); ins.readByte(); this.link_name = new String(__strbuf);
 
        this.tf = drc.transform_t._decodeRecursiveFactory(ins);
 
    }
 
    public drc.link_transform_t copy()
    {
        drc.link_transform_t outobj = new drc.link_transform_t();
        outobj.link_name = this.link_name;
 
        outobj.tf = this.tf.copy();
 
        return outobj;
    }
 
}

