package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.an */
class C1896an implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f7098a;

    /* renamed from: b */
    final /* synthetic */ zzp f7099b;

    C1896an(zzp zzp, String str) {
        this.f7099b = zzp;
        this.f7098a = str;
    }

    public void run() {
        zzt zzbse = this.f7099b.f7189n.zzbse();
        if (!zzbse.mo9337a() || zzbse.mo9338b()) {
            this.f7099b.mo9590a(6, "Persisted config not initialized . Not logging error/warn.");
        } else {
            zzbse.f7314b.zzev(this.f7098a);
        }
    }
}
