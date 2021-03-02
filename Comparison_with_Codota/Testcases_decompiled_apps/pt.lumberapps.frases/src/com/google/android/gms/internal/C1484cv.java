package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.cv */
final class C1484cv extends zzanh {
    C1484cv() {
    }

    /* renamed from: a */
    public Boolean zzb(zzaom zzaom) {
        if (zzaom.mo7902b() != zzaon.NULL) {
            return Boolean.valueOf(zzaom.nextString());
        }
        zzaom.nextNull();
        return null;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Boolean bool) {
        zzaoo.zzts(bool == null ? "null" : bool.toString());
    }
}
