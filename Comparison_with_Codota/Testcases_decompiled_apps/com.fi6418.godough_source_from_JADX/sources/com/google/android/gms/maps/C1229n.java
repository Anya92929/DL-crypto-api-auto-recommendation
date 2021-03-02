package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzk;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: com.google.android.gms.maps.n */
class C1229n extends zzk.zza {

    /* renamed from: a */
    final /* synthetic */ GoogleMap.OnMapLongClickListener f5223a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5224b;

    C1229n(GoogleMap googleMap, GoogleMap.OnMapLongClickListener onMapLongClickListener) {
        this.f5224b = googleMap;
        this.f5223a = onMapLongClickListener;
    }

    public void onMapLongClick(LatLng latLng) {
        this.f5223a.onMapLongClick(latLng);
    }
}
