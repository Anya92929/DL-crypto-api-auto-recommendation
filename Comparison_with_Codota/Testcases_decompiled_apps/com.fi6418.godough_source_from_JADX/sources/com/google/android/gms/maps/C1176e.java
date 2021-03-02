package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzd;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.p017b.C0605j;
import com.google.android.gms.p017b.C0608m;

/* renamed from: com.google.android.gms.maps.e */
class C1176e extends zzd.zza {

    /* renamed from: a */
    final /* synthetic */ GoogleMap.InfoWindowAdapter f5070a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5071b;

    C1176e(GoogleMap googleMap, GoogleMap.InfoWindowAdapter infoWindowAdapter) {
        this.f5071b = googleMap;
        this.f5070a = infoWindowAdapter;
    }

    public C0605j zzf(zzf zzf) {
        return C0608m.m3536a(this.f5070a.getInfoWindow(new Marker(zzf)));
    }

    public C0605j zzg(zzf zzf) {
        return C0608m.m3536a(this.f5070a.getInfoContents(new Marker(zzf)));
    }
}
