package com.google.android.gms.maps;

import android.location.Location;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzp;
import com.google.android.gms.p017b.C0605j;
import com.google.android.gms.p017b.C0608m;

/* renamed from: com.google.android.gms.maps.f */
class C1177f extends zzp.zza {

    /* renamed from: a */
    final /* synthetic */ GoogleMap.OnMyLocationChangeListener f5072a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5073b;

    C1177f(GoogleMap googleMap, GoogleMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        this.f5073b = googleMap;
        this.f5072a = onMyLocationChangeListener;
    }

    public void zzq(C0605j jVar) {
        this.f5072a.onMyLocationChange((Location) C0608m.m3537a(jVar));
    }
}
