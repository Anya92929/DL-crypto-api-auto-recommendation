package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzad;

/* renamed from: com.google.android.gms.measurement.internal.r */
class C1938r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzm f7227a;

    /* renamed from: b */
    final /* synthetic */ zzad.zza f7228b;

    C1938r(zzad.zza zza, zzm zzm) {
        this.f7228b = zza;
        this.f7227a = zzm;
    }

    public void run() {
        synchronized (this.f7228b) {
            boolean unused = this.f7228b.f7255b = false;
            if (!zzad.this.isConnected()) {
                zzad.this.zzbsd().zzbtc().log("Connected to service");
                zzad.this.m7753a(this.f7227a);
            }
        }
    }
}
