package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzt;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* renamed from: com.google.android.gms.maps.y */
class C1239y extends zzt.zza {

    /* renamed from: a */
    final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaClickListener f5248a;

    /* renamed from: b */
    final /* synthetic */ StreetViewPanorama f5249b;

    C1239y(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
        this.f5249b = streetViewPanorama;
        this.f5248a = onStreetViewPanoramaClickListener;
    }

    public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        this.f5248a.onStreetViewPanoramaClick(streetViewPanoramaOrientation);
    }
}
