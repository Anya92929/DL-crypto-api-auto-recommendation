package com.google.android.gms.internal;

import android.support.p000v4.view.MotionEventCompat;
import com.flurry.android.Constants;

/* renamed from: com.google.android.gms.internal.gk */
public class C0595gk {

    /* renamed from: uu */
    private final byte[] f1528uu = new byte[256];

    /* renamed from: uv */
    private int f1529uv;

    /* renamed from: uw */
    private int f1530uw;

    public C0595gk(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.f1528uu[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            b = (b + this.f1528uu[i2] + bArr[i2 % bArr.length]) & Constants.UNKNOWN;
            byte b2 = this.f1528uu[i2];
            this.f1528uu[i2] = this.f1528uu[b];
            this.f1528uu[b] = b2;
        }
        this.f1529uv = 0;
        this.f1530uw = 0;
    }

    /* renamed from: f */
    public void mo5288f(byte[] bArr) {
        int i = this.f1529uv;
        int i2 = this.f1530uw;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.f1528uu[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.f1528uu[i];
            this.f1528uu[i] = this.f1528uu[i2];
            this.f1528uu[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.f1528uu[(this.f1528uu[i] + this.f1528uu[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.f1529uv = i;
        this.f1530uw = i2;
    }
}
