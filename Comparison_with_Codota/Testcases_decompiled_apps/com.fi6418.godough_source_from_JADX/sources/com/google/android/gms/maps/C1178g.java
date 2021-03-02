package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzo;

/* renamed from: com.google.android.gms.maps.g */
class C1178g extends zzo.zza {

    /* renamed from: a */
    final /* synthetic */ GoogleMap.OnMyLocationButtonClickListener f5074a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5075b;

    C1178g(GoogleMap googleMap, GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        this.f5075b = googleMap;
        this.f5074a = onMyLocationButtonClickListener;
    }

    public boolean onMyLocationButtonClick() {
        return this.f5074a.onMyLocationButtonClick();
    }
}
