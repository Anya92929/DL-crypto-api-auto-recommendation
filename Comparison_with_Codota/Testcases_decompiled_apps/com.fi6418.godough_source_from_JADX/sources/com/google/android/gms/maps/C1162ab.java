package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzv;

/* renamed from: com.google.android.gms.maps.ab */
class C1162ab extends zzv.zza {

    /* renamed from: a */
    final /* synthetic */ OnStreetViewPanoramaReadyCallback f5032a;

    /* renamed from: b */
    final /* synthetic */ C1161aa f5033b;

    C1162ab(C1161aa aaVar, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        this.f5033b = aaVar;
        this.f5032a = onStreetViewPanoramaReadyCallback;
    }

    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.f5032a.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
    }
}
