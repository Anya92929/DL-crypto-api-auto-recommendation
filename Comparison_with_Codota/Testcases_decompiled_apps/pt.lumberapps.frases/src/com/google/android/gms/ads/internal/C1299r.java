package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzkh;

@zzin
/* renamed from: com.google.android.gms.ads.internal.r */
class C1299r extends zzkc {

    /* renamed from: a */
    final /* synthetic */ zzl f3902a;

    /* renamed from: b */
    private final int f3903b;

    public C1299r(zzl zzl, int i) {
        this.f3902a = zzl;
        this.f3903b = i;
    }

    public void onStop() {
    }

    public void zzew() {
        InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.f3902a.f4011f.f4131v, this.f3902a.mo5861g(), this.f3902a.f4054n, this.f3902a.f4055o, this.f3902a.f4011f.f4131v ? this.f3903b : -1);
        int requestedOrientation = this.f3902a.f4011f.zzapb.zzbtm.getRequestedOrientation();
        zzkh.zzclc.post(new C1320s(this, new AdOverlayInfoParcel(this.f3902a, this.f3902a, this.f3902a, this.f3902a.f4011f.zzapb.zzbtm, requestedOrientation == -1 ? this.f3902a.f4011f.zzapb.orientation : requestedOrientation, this.f3902a.f4011f.zzaow, this.f3902a.f4011f.zzapb.zzccd, interstitialAdParameterParcel)));
    }
}
