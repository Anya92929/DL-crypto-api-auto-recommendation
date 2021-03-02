package com.google.ads;

import android.support.p000v4.view.MotionEventCompat;

/* renamed from: com.google.ads.ar */
public class C0199ar {

    /* renamed from: a */
    private final byte[] f358a = new byte[256];

    /* renamed from: b */
    private int f359b;

    /* renamed from: c */
    private int f360c;

    public C0199ar(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.f358a[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            b = (b + this.f358a[i2] + bArr[i2 % bArr.length]) & 255;
            byte b2 = this.f358a[i2];
            this.f358a[i2] = this.f358a[b];
            this.f358a[b] = b2;
        }
        this.f359b = 0;
        this.f360c = 0;
    }

    /* renamed from: a */
    public void mo3345a(byte[] bArr) {
        int i = this.f359b;
        int i2 = this.f360c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.f358a[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.f358a[i];
            this.f358a[i] = this.f358a[i2];
            this.f358a[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.f358a[(this.f358a[i] + this.f358a[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.f359b = i;
        this.f360c = i2;
    }
}
