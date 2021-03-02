package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ab */
class C1410ab extends zzanh {

    /* renamed from: a */
    final /* synthetic */ zzamp f4818a;

    C1410ab(zzamp zzamp) {
        this.f4818a = zzamp;
    }

    /* renamed from: a */
    public Double zzb(zzaom zzaom) {
        if (zzaom.mo7902b() != zzaon.NULL) {
            return Double.valueOf(zzaom.nextDouble());
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
        this.f4818a.m6650a(number.doubleValue());
        zzaoo.zza(number);
    }
}
