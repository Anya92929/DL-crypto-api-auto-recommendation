package com.parse.codec;

public interface Encoder {
    Object encode(Object obj) throws EncoderException;
}
