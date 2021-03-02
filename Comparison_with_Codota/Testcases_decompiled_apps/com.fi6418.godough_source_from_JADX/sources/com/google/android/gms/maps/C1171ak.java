package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzv;

/* renamed from: com.google.android.gms.maps.ak */
class C1171ak extends zzv.zza {

    /* renamed from: a */
    final /* synthetic */ OnStreetViewPanoramaReadyCallback f5058a;

    /* renamed from: b */
    final /* synthetic */ C1170aj f5059b;

    C1171ak(C1170aj ajVar, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        this.f5059b = ajVar;
        this.f5058a = onStreetViewPanoramaReadyCallback;
    }

    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.f5058a.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
    }
}
