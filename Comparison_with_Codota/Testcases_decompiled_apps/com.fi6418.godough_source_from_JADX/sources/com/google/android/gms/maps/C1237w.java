package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzs;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

/* renamed from: com.google.android.gms.maps.w */
class C1237w extends zzs.zza {

    /* renamed from: a */
    final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaChangeListener f5244a;

    /* renamed from: b */
    final /* synthetic */ StreetViewPanorama f5245b;

    C1237w(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
        this.f5245b = streetViewPanorama;
        this.f5244a = onStreetViewPanoramaChangeListener;
    }

    public void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation) {
        this.f5244a.onStreetViewPanoramaChange(streetViewPanoramaLocation);
    }
}
