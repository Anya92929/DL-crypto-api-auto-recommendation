package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzad;

/* renamed from: com.google.android.gms.measurement.internal.t */
class C1940t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzm f7231a;

    /* renamed from: b */
    final /* synthetic */ zzad.zza f7232b;

    C1940t(zzad.zza zza, zzm zzm) {
        this.f7232b = zza;
        this.f7231a = zzm;
    }

    public void run() {
        synchronized (this.f7232b) {
            boolean unused = this.f7232b.f7255b = false;
            if (!zzad.this.isConnected()) {
                zzad.this.zzbsd().zzbtb().log("Connected to remote service");
                zzad.this.m7753a(this.f7231a);
            }
        }
    }
}
