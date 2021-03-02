package com.flurry.android;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

public class CrcMessageDigest extends MessageDigest {

    /* renamed from: a */
    private CRC32 f17a = new CRC32();

    public CrcMessageDigest() {
        super("CRC");
    }

    /* access modifiers changed from: protected */
    public void engineReset() {
        this.f17a.reset();
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) {
        this.f17a.update(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f17a.update(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public byte[] engineDigest() {
        long value = this.f17a.getValue();
        return new byte[]{(byte) ((int) ((-16777216 & value) >> 24)), (byte) ((int) ((16711680 & value) >> 16)), (byte) ((int) ((65280 & value) >> 8)), (byte) ((int) (value & 255))};
    }

    public byte[] getDigest() {
        return engineDigest();
    }

    public int getChecksum() {
        return ByteBuffer.wrap(engineDigest()).getInt();
    }
}
