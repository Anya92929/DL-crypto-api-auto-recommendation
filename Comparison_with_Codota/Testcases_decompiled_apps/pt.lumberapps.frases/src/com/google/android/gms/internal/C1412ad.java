package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ad */
class C1412ad extends zzanh {

    /* renamed from: a */
    final /* synthetic */ zzamp f4820a;

    C1412ad(zzamp zzamp) {
        this.f4820a = zzamp;
    }

    /* renamed from: a */
    public Number zzb(zzaom zzaom) {
        if (zzaom.mo7902b() != zzaon.NULL) {
            return Long.valueOf(zzaom.nextLong());
        }
        zzaom.nextNull();
        return null;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Number number) {
        if (number == null) {
            zzaoo.mo7926l();
        } else {
            zzaoo.zzts(number.toString());
        }
    }
}
