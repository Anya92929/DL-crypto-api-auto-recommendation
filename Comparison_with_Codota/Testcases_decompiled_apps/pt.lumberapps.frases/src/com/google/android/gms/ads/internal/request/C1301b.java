package com.google.android.gms.ads.internal.request;

/* renamed from: com.google.android.gms.ads.internal.request.b */
class C1301b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzb f3914a;

    C1301b(zzb zzb) {
        this.f3914a = zzb;
    }

    public void run() {
        synchronized (this.f3914a.f3937f) {
            if (this.f3914a.f3932a != null) {
                this.f3914a.onStop();
                this.f3914a.m5734a(2, "Timed out waiting for ad response.");
            }
        }
    }
}
