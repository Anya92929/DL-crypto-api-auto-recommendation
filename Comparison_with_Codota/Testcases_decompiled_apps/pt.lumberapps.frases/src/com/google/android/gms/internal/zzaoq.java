package com.google.android.gms.internal;

import android.support.p009v4.app.NotificationCompat;

public class zzaoq {

    /* renamed from: a */
    private final byte[] f5879a = new byte[NotificationCompat.FLAG_LOCAL_ONLY];

    /* renamed from: b */
    private int f5880b;

    /* renamed from: c */
    private int f5881c;

    public zzaoq(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.f5879a[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            b = (b + this.f5879a[i2] + bArr[i2 % bArr.length]) & 255;
            byte b2 = this.f5879a[i2];
            this.f5879a[i2] = this.f5879a[b];
            this.f5879a[b] = b2;
        }
        this.f5880b = 0;
        this.f5881c = 0;
    }

    public void zzax(byte[] bArr) {
        int i = this.f5880b;
        int i2 = this.f5881c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.f5879a[i]) & 255;
            byte b = this.f5879a[i];
            this.f5879a[i] = this.f5879a[i2];
            this.f5879a[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.f5879a[(this.f5879a[i] + this.f5879a[i2]) & 255]);
        }
        this.f5880b = i;
        this.f5881c = i2;
    }
}
