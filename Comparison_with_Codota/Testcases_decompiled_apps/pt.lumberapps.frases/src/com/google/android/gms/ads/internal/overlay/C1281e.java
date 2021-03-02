package com.google.android.gms.ads.internal.overlay;

/* renamed from: com.google.android.gms.ads.internal.overlay.e */
class C1281e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzc f3737a;

    C1281e(zzc zzc) {
        this.f3737a = zzc;
    }

    public void run() {
        if (this.f3737a.f3777s != null) {
            this.f3737a.f3777s.onPaused();
            this.f3737a.f3777s.zzom();
        }
    }
}
