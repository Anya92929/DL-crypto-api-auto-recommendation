package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.w */
class C1943w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1942v f7238a;

    C1943w(C1942v vVar) {
        this.f7238a = vVar;
    }

    public void run() {
        if (!this.f7238a.f7237d.f7260c.callServiceStopSelfResult(this.f7238a.f7235b)) {
            return;
        }
        if (this.f7238a.f7234a.zzbsf().zzabc()) {
            this.f7238a.f7236c.zzbtc().log("Device AppMeasurementService processed last upload request");
        } else {
            this.f7238a.f7236c.zzbtc().log("Local AppMeasurementService processed last upload request");
        }
    }
}
