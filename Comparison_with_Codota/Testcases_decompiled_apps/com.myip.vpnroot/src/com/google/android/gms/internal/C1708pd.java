package com.google.android.gms.internal;

import android.support.p000v4.view.MotionEventCompat;

/* renamed from: com.google.android.gms.internal.pd */
public class C1708pd {
    private final byte[] awl = new byte[256];
    private int awm;
    private int awn;

    public C1708pd(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.awl[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            b = (b + this.awl[i2] + bArr[i2 % bArr.length]) & 255;
            byte b2 = this.awl[i2];
            this.awl[i2] = this.awl[b];
            this.awl[b] = b2;
        }
        this.awm = 0;
        this.awn = 0;
    }

    /* renamed from: o */
    public void mo10017o(byte[] bArr) {
        int i = this.awm;
        int i2 = this.awn;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.awl[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.awl[i];
            this.awl[i] = this.awl[i2];
            this.awl[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.awl[(this.awl[i] + this.awl[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.awm = i;
        this.awn = i2;
    }
}
