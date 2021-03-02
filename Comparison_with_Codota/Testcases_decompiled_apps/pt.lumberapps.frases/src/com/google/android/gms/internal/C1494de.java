package com.google.android.gms.internal;

import java.math.BigDecimal;

/* renamed from: com.google.android.gms.internal.de */
final class C1494de extends zzanh {
    C1494de() {
    }

    /* renamed from: a */
    public BigDecimal zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        try {
            return new BigDecimal(zzaom.nextString());
        } catch (NumberFormatException e) {
            throw new zzane((Throwable) e);
        }
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, BigDecimal bigDecimal) {
        zzaoo.zza(bigDecimal);
    }
}
