package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzn;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.internal.zzf;

/* renamed from: com.google.android.gms.maps.c */
class C1174c extends zzn.zza {

    /* renamed from: a */
    final /* synthetic */ GoogleMap.OnMarkerDragListener f5066a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5067b;

    C1174c(GoogleMap googleMap, GoogleMap.OnMarkerDragListener onMarkerDragListener) {
        this.f5067b = googleMap;
        this.f5066a = onMarkerDragListener;
    }

    public void zzb(zzf zzf) {
        this.f5066a.onMarkerDragStart(new Marker(zzf));
    }

    public void zzc(zzf zzf) {
        this.f5066a.onMarkerDragEnd(new Marker(zzf));
    }

    public void zzd(zzf zzf) {
        this.f5066a.onMarkerDrag(new Marker(zzf));
    }
}
