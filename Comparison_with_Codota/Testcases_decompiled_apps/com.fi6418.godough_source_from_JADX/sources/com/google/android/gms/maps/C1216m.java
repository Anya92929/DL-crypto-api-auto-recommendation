package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzi;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: com.google.android.gms.maps.m */
class C1216m extends zzi.zza {

    /* renamed from: a */
    final /* synthetic */ GoogleMap.OnMapClickListener f5120a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5121b;

    C1216m(GoogleMap googleMap, GoogleMap.OnMapClickListener onMapClickListener) {
        this.f5121b = googleMap;
        this.f5120a = onMapClickListener;
    }

    public void onMapClick(LatLng latLng) {
        this.f5120a.onMapClick(latLng);
    }
}
