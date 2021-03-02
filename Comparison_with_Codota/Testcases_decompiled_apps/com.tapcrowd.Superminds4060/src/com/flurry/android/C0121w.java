package com.flurry.android;

import java.io.DataInput;

/* renamed from: com.flurry.android.w */
final class C0121w extends C0097ak {

    /* renamed from: a */
    long f259a;

    /* renamed from: b */
    long f260b;

    /* renamed from: c */
    String f261c;

    /* renamed from: d */
    String f262d;

    /* renamed from: e */
    long f263e;

    /* renamed from: f */
    Long f264f;

    /* renamed from: g */
    byte[] f265g;

    /* renamed from: h */
    AdImage f266h;

    C0121w() {
    }

    C0121w(DataInput dataInput) {
        m176b(dataInput);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo3368a(DataInput dataInput) {
        m176b(dataInput);
    }

    /* renamed from: b */
    private void m176b(DataInput dataInput) {
        this.f259a = dataInput.readLong();
        this.f260b = dataInput.readLong();
        this.f262d = dataInput.readUTF();
        this.f261c = dataInput.readUTF();
        this.f263e = dataInput.readLong();
        this.f264f = Long.valueOf(dataInput.readLong());
        this.f265g = new byte[dataInput.readUnsignedByte()];
        dataInput.readFully(this.f265g);
    }

    public final String toString() {
        return "ad {id=" + this.f259a + ", name='" + this.f262d + "', cookie: '" + m175a(this.f265g) + "'}";
    }

    /* renamed from: a */
    private static String m175a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] >> 4) & 15;
            if (i2 < 10) {
                sb.append((char) (i2 + 48));
            } else {
                sb.append((char) ((i2 + 65) - 10));
            }
            byte b = bArr[i] & 15;
            if (b < 10) {
                sb.append((char) (b + 48));
            } else {
                sb.append((char) ((b + 65) - 10));
            }
        }
        return sb.toString();
    }
}
