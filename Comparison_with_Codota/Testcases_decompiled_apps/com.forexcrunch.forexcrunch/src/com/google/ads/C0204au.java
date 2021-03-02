package com.google.ads;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.ads.au */
public final class C0204au {

    /* renamed from: a */
    private final byte[] f367a;

    /* renamed from: b */
    private final int f368b;

    /* renamed from: c */
    private int f369c;

    /* renamed from: d */
    private int f370d = 0;

    /* renamed from: e */
    private final OutputStream f371e;

    private C0204au(OutputStream outputStream, byte[] bArr) {
        this.f371e = outputStream;
        this.f367a = bArr;
        this.f369c = 0;
        this.f368b = bArr.length;
    }

    /* renamed from: a */
    public static C0204au m116a(OutputStream outputStream) {
        return m117a(outputStream, 4096);
    }

    /* renamed from: a */
    public static C0204au m117a(OutputStream outputStream, int i) {
        return new C0204au(outputStream, new byte[i]);
    }

    /* renamed from: a */
    public void mo3352a(int i, long j) throws IOException {
        mo3351a(i, 0);
        mo3354a(j);
    }

    /* renamed from: a */
    public void mo3353a(int i, String str) throws IOException {
        mo3351a(i, 2);
        mo3355a(str);
    }

    /* renamed from: a */
    public void mo3354a(long j) throws IOException {
        mo3359b(j);
    }

    /* renamed from: a */
    public void mo3355a(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        mo3358b(bytes.length);
        mo3356a(bytes);
    }

    /* renamed from: b */
    private void m118b() throws IOException {
        if (this.f371e == null) {
            throw new C0205a();
        }
        this.f371e.write(this.f367a, 0, this.f369c);
        this.f369c = 0;
    }

    /* renamed from: a */
    public void mo3348a() throws IOException {
        if (this.f371e != null) {
            m118b();
        }
    }

    /* renamed from: com.google.ads.au$a */
    public static class C0205a extends IOException {
        C0205a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    /* renamed from: a */
    public void mo3349a(byte b) throws IOException {
        if (this.f369c == this.f368b) {
            m118b();
        }
        byte[] bArr = this.f367a;
        int i = this.f369c;
        this.f369c = i + 1;
        bArr[i] = b;
        this.f370d++;
    }

    /* renamed from: a */
    public void mo3350a(int i) throws IOException {
        mo3349a((byte) i);
    }

    /* renamed from: a */
    public void mo3356a(byte[] bArr) throws IOException {
        mo3357a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void mo3357a(byte[] bArr, int i, int i2) throws IOException {
        if (this.f368b - this.f369c >= i2) {
            System.arraycopy(bArr, i, this.f367a, this.f369c, i2);
            this.f369c += i2;
            this.f370d += i2;
            return;
        }
        int i3 = this.f368b - this.f369c;
        System.arraycopy(bArr, i, this.f367a, this.f369c, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.f369c = this.f368b;
        this.f370d = i3 + this.f370d;
        m118b();
        if (i5 <= this.f368b) {
            System.arraycopy(bArr, i4, this.f367a, 0, i5);
            this.f369c = i5;
        } else {
            this.f371e.write(bArr, i4, i5);
        }
        this.f370d += i5;
    }

    /* renamed from: a */
    public void mo3351a(int i, int i2) throws IOException {
        mo3358b(C0206av.m131a(i, i2));
    }

    /* renamed from: b */
    public void mo3358b(int i) throws IOException {
        while ((i & -128) != 0) {
            mo3350a((i & 127) | 128);
            i >>>= 7;
        }
        mo3350a(i);
    }

    /* renamed from: b */
    public void mo3359b(long j) throws IOException {
        while ((-128 & j) != 0) {
            mo3350a((((int) j) & 127) | 128);
            j >>>= 7;
        }
        mo3350a((int) j);
    }
}
