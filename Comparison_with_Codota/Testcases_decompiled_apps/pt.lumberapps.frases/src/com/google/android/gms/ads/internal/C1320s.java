package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* renamed from: com.google.android.gms.ads.internal.s */
class C1320s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdOverlayInfoParcel f3979a;

    /* renamed from: b */
    final /* synthetic */ C1299r f3980b;

    C1320s(C1299r rVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f3980b = rVar;
        this.f3979a = adOverlayInfoParcel;
    }

    public void run() {
        zzu.zzfo().zza(this.f3980b.f3902a.f4011f.zzagf, this.f3979a);
    }
}
