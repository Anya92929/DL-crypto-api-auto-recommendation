package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.cx */
final class C1486cx extends zzanh {
    C1486cx() {
    }

    /* renamed from: a */
    public Number zzb(zzaom zzaom) {
        if (zzaom.mo7902b() == zzaon.NULL) {
            zzaom.nextNull();
            return null;
        }
        try {
            return Short.valueOf((short) zzaom.nextInt());
        } catch (NumberFormatException e) {
            throw new zzane((Throwable) e);
        }
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Number number) {
        zzaoo.zza(number);
    }
}
