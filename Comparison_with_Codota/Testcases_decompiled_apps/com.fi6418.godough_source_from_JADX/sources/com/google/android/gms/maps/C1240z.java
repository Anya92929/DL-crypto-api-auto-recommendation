package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzu;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* renamed from: com.google.android.gms.maps.z */
class C1240z extends zzu.zza {

    /* renamed from: a */
    final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaLongClickListener f5250a;

    /* renamed from: b */
    final /* synthetic */ StreetViewPanorama f5251b;

    C1240z(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaLongClickListener onStreetViewPanoramaLongClickListener) {
        this.f5251b = streetViewPanorama;
        this.f5250a = onStreetViewPanoramaLongClickListener;
    }

    public void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        this.f5250a.onStreetViewPanoramaLongClick(streetViewPanoramaOrientation);
    }
}
