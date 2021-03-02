package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzapv {

    /* renamed from: b */
    protected volatile int f5906b = -1;

    public static final zzapv zza(zzapv zzapv, byte[] bArr) {
        return zzb(zzapv, bArr, 0, bArr.length);
    }

    public static final void zza(zzapv zzapv, byte[] bArr, int i, int i2) {
        try {
            zzapo zzc = zzapo.zzc(bArr, i, i2);
            zzapv.zza(zzc);
            zzc.mo7988az();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final zzapv zzb(zzapv zzapv, byte[] bArr, int i, int i2) {
        try {
            zzapn zzb = zzapn.zzb(bArr, i, i2);
            zzapv.zzb(zzb);
            zzb.zzafo(0);
            return zzapv;
        } catch (zzapu e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] zzf(zzapv zzapv) {
        byte[] bArr = new byte[zzapv.mo8049aM()];
        zza(zzapv, bArr, 0, bArr.length);
        return bArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo7714a() {
        return 0;
    }

    /* renamed from: aB */
    public zzapv clone() {
        return (zzapv) super.clone();
    }

    /* renamed from: aL */
    public int mo8048aL() {
        if (this.f5906b < 0) {
            mo8049aM();
        }
        return this.f5906b;
    }

    /* renamed from: aM */
    public int mo8049aM() {
        int a = mo7714a();
        this.f5906b = a;
        return a;
    }

    public String toString() {
        return zzapw.zzg(this);
    }

    public void zza(zzapo zzapo) {
    }

    public abstract zzapv zzb(zzapn zzapn);
}
