package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzla;

/* renamed from: com.google.android.gms.ads.internal.request.c */
class C1302c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzla f3915a;

    /* renamed from: b */
    final /* synthetic */ zzb f3916b;

    C1302c(zzb zzb, zzla zzla) {
        this.f3916b = zzb;
        this.f3915a = zzla;
    }

    public void run() {
        synchronized (this.f3916b.f3937f) {
            this.f3916b.f3932a = this.f3916b.mo5656a(this.f3916b.f3936e.zzaow, this.f3915a);
            if (this.f3916b.f3932a == null) {
                this.f3916b.m5734a(0, "Could not start the ad request service.");
                zzkh.zzclc.removeCallbacks(this.f3916b.f3941j);
            }
        }
    }
}
