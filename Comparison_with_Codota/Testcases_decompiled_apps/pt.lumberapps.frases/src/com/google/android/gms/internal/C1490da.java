package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.da */
final class C1490da extends zzanh {
    C1490da() {
    }

    /* renamed from: a */
    public Number zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        try {
            return Long.valueOf(zzaom.nextLong());
        } catch (NumberFormatException e) {
            throw new zzane((Throwable) e);
        }
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Number number) {
        zzaoo.zza(number);
    }
}
