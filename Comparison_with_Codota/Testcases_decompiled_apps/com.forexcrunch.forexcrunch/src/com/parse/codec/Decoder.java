package com.parse.codec;

public interface Decoder {
    Object decode(Object obj) throws DecoderException;
}
