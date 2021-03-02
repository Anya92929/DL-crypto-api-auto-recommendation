package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzl;

/* renamed from: com.google.android.gms.maps.q */
class C1232q extends zzl.zza {

    /* renamed from: a */
    final /* synthetic */ OnMapReadyCallback f5228a;

    /* renamed from: b */
    final /* synthetic */ C1231p f5229b;

    C1232q(C1231p pVar, OnMapReadyCallback onMapReadyCallback) {
        this.f5229b = pVar;
        this.f5228a = onMapReadyCallback;
    }

    public void zza(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f5228a.onMapReady(new GoogleMap(iGoogleMapDelegate));
    }
}
