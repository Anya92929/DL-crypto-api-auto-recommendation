package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzg;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.internal.zzf;

/* renamed from: com.google.android.gms.maps.d */
class C1175d extends zzg.zza {

    /* renamed from: a */
    final /* synthetic */ GoogleMap.OnInfoWindowClickListener f5068a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5069b;

    C1175d(GoogleMap googleMap, GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.f5069b = googleMap;
        this.f5068a = onInfoWindowClickListener;
    }

    public void zze(zzf zzf) {
        this.f5068a.onInfoWindowClick(new Marker(zzf));
    }
}
