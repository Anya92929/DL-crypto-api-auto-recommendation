package com.google.android.gms.ads.internal.overlay;

/* renamed from: com.google.android.gms.ads.internal.overlay.g */
class C1283g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzc f3739a;

    C1283g(zzc zzc) {
        this.f3739a = zzc;
    }

    public void run() {
        if (this.f3739a.f3777s != null) {
            this.f3739a.f3777s.onPaused();
        }
    }
}
