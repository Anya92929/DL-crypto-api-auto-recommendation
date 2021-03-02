package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzv;

/* renamed from: com.google.android.gms.maps.ae */
class C1165ae extends zzv.zza {

    /* renamed from: a */
    final /* synthetic */ OnStreetViewPanoramaReadyCallback f5041a;

    /* renamed from: b */
    final /* synthetic */ C1164ad f5042b;

    C1165ae(C1164ad adVar, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        this.f5042b = adVar;
        this.f5041a = onStreetViewPanoramaReadyCallback;
    }

    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.f5041a.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
    }
}
