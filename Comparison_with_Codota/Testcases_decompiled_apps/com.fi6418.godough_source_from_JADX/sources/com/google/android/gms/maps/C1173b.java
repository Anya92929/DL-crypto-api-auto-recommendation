package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzm;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.internal.zzf;

/* renamed from: com.google.android.gms.maps.b */
class C1173b extends zzm.zza {

    /* renamed from: a */
    final /* synthetic */ GoogleMap.OnMarkerClickListener f5064a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5065b;

    C1173b(GoogleMap googleMap, GoogleMap.OnMarkerClickListener onMarkerClickListener) {
        this.f5065b = googleMap;
        this.f5064a = onMarkerClickListener;
    }

    public boolean zza(zzf zzf) {
        return this.f5064a.onMarkerClick(new Marker(zzf));
    }
}
