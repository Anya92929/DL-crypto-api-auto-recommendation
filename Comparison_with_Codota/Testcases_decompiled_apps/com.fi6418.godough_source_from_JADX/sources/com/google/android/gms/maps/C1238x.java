package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzr;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* renamed from: com.google.android.gms.maps.x */
class C1238x extends zzr.zza {

    /* renamed from: a */
    final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener f5246a;

    /* renamed from: b */
    final /* synthetic */ StreetViewPanorama f5247b;

    C1238x(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
        this.f5247b = streetViewPanorama;
        this.f5246a = onStreetViewPanoramaCameraChangeListener;
    }

    public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.f5246a.onStreetViewPanoramaCameraChange(streetViewPanoramaCamera);
    }
}
