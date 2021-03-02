package com.parse.codec.language;

import com.parse.codec.EncoderException;
import com.parse.codec.StringEncoder;

public abstract class AbstractCaverphone implements StringEncoder {
    public Object encode(Object source) throws EncoderException {
        if (source instanceof String) {
            return encode((String) source);
        }
        throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }

    public boolean isEncodeEqual(String str1, String str2) throws EncoderException {
        return encode(str1).equals(encode(str2));
    }
}
