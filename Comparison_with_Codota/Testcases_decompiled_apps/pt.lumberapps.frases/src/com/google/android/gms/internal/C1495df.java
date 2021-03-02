package com.google.android.gms.internal;

import java.math.BigInteger;

/* renamed from: com.google.android.gms.internal.df */
final class C1495df extends zzanh {
    C1495df() {
    }

    /* renamed from: a */
    public BigInteger zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        try {
            return new BigInteger(zzaom.nextString());
        } catch (NumberFormatException e) {
            throw new zzane((Throwable) e);
        }
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, BigInteger bigInteger) {
        zzaoo.zza(bigInteger);
    }
}
