package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.gl */
public final class C0596gl {
    private final byte[] buffer;
    private int position;

    /* renamed from: ux */
    private final int f1531ux;

    /* renamed from: com.google.android.gms.internal.gl$a */
    public static class C0597a extends IOException {
        C0597a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private C0596gl(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.f1531ux = i + i2;
    }

    /* renamed from: a */
    public static C0596gl m1863a(byte[] bArr, int i, int i2) {
        return new C0596gl(bArr, i, i2);
    }

    /* renamed from: g */
    public static C0596gl m1864g(byte[] bArr) {
        return m1863a(bArr, 0, bArr.length);
    }

    /* renamed from: aD */
    public void mo5289aD(int i) throws IOException {
        mo5292b((byte) i);
    }

    /* renamed from: aE */
    public void mo5290aE(int i) throws IOException {
        while ((i & -128) != 0) {
            mo5289aD((i & 127) | 128);
            i >>>= 7;
        }
        mo5289aD(i);
    }

    /* renamed from: ab */
    public void mo5291ab(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        mo5290aE(bytes.length);
        mo5298h(bytes);
    }

    /* renamed from: b */
    public void mo5292b(byte b) throws IOException {
        if (this.position == this.f1531ux) {
            throw new C0597a(this.position, this.f1531ux);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    /* renamed from: b */
    public void mo5293b(int i, long j) throws IOException {
        mo5296d(i, 0);
        mo5299i(j);
    }

    /* renamed from: b */
    public void mo5294b(int i, String str) throws IOException {
        mo5296d(i, 2);
        mo5291ab(str);
    }

    /* renamed from: b */
    public void mo5295b(byte[] bArr, int i, int i2) throws IOException {
        if (this.f1531ux - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new C0597a(this.position, this.f1531ux);
    }

    /* renamed from: d */
    public void mo5296d(int i, int i2) throws IOException {
        mo5290aE(C0598gm.m1877e(i, i2));
    }

    /* renamed from: ec */
    public int mo5297ec() {
        return this.f1531ux - this.position;
    }

    /* renamed from: h */
    public void mo5298h(byte[] bArr) throws IOException {
        mo5295b(bArr, 0, bArr.length);
    }

    /* renamed from: i */
    public void mo5299i(long j) throws IOException {
        mo5300j(j);
    }

    /* renamed from: j */
    public void mo5300j(long j) throws IOException {
        while ((-128 & j) != 0) {
            mo5289aD((((int) j) & 127) | 128);
            j >>>= 7;
        }
        mo5289aD((int) j);
    }
}
