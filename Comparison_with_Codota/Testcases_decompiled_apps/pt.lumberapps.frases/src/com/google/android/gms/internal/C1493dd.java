package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.dd */
final class C1493dd extends zzanh {
    C1493dd() {
    }

    /* renamed from: a */
    public String zzb(zzaom zzaom) {
        zzaon b = zzaom.mo7902b();
        if (b != zzaon.NULL) {
            return b == zzaon.BOOLEAN ? Boolean.toString(zzaom.nextBoolean()) : zzaom.nextString();
        }
        zzaom.nextNull();
        return null;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, String str) {
        zzaoo.zzts(str);
    }
}
