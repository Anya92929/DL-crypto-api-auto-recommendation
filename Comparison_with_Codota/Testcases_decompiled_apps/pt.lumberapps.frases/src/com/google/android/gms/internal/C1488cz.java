package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.cz */
final class C1488cz extends zzanh {
    C1488cz() {
    }

    /* renamed from: a */
    public Number zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        try {
            return Integer.valueOf(zzaom.nextInt());
        } catch (NumberFormatException e) {
            throw new zzane((Throwable) e);
        }
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Number number) {
        zzaoo.zza(number);
    }
}
