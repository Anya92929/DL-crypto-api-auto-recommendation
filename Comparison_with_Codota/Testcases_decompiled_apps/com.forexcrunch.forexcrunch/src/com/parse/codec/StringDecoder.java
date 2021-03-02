package com.parse.codec;

public interface StringDecoder extends Decoder {
    String decode(String str) throws DecoderException;
}
