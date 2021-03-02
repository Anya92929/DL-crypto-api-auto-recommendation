package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.cr */
final class C1480cr extends zzanh {
    C1480cr() {
    }

    /* renamed from: a */
    public Boolean zzb(zzaom zzaom) {
        if (zzaom.mo7902b() != zzaon.NULL) {
            return zzaom.mo7902b() == zzaon.STRING ? Boolean.valueOf(Boolean.parseBoolean(zzaom.nextString())) : Boolean.valueOf(zzaom.nextBoolean());
        }
        zzaom.nextNull();
        return null;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Boolean bool) {
        if (bool == null) {
            zzaoo.mo7926l();
        } else {
            zzaoo.zzda(bool.booleanValue());
        }
    }
}
