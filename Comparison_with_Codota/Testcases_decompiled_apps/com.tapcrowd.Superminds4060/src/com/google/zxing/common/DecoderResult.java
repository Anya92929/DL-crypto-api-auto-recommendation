package com.google.zxing.common;

import java.util.List;

public final class DecoderResult {
    private final List<byte[]> byteSegments;
    private final String ecLevel;
    private final byte[] rawBytes;
    private final String text;

    public DecoderResult(byte[] rawBytes2, String text2, List<byte[]> byteSegments2, String ecLevel2) {
        this.rawBytes = rawBytes2;
        this.text = text2;
        this.byteSegments = byteSegments2;
        this.ecLevel = ecLevel2;
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public String getText() {
        return this.text;
    }

    public List<byte[]> getByteSegments() {
        return this.byteSegments;
    }

    public String getECLevel() {
        return this.ecLevel;
    }
}
