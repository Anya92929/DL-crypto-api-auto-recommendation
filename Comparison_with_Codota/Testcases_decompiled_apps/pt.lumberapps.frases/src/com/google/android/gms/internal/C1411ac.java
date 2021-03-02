package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ac */
class C1411ac extends zzanh {

    /* renamed from: a */
    final /* synthetic */ zzamp f4819a;

    C1411ac(zzamp zzamp) {
        this.f4819a = zzamp;
    }

    /* renamed from: a */
    public Float zzb(zzaom zzaom) {
        if (zzaom.mo7902b() != zzaon.NULL) {
            return Float.valueOf((float) zzaom.nextDouble());
        }
        zzaom.nextNull();
        return null;
    }

    /* renamed from: a */
    public void zza(zzaoo zzaoo, Number number) {
        if (number == null) {
            zzaoo.mo7926l();
            return;
        }
        this.f4819a.m6650a((double) number.floatValue());
        zzaoo.zza(number);
    }
}
