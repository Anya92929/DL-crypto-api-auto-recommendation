package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzl;

/* renamed from: com.google.android.gms.maps.ah */
class C1168ah extends zzl.zza {

    /* renamed from: a */
    final /* synthetic */ OnMapReadyCallback f5050a;

    /* renamed from: b */
    final /* synthetic */ C1167ag f5051b;

    C1168ah(C1167ag agVar, OnMapReadyCallback onMapReadyCallback) {
        this.f5051b = agVar;
        this.f5050a = onMapReadyCallback;
    }

    public void zza(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f5050a.onMapReady(new GoogleMap(iGoogleMapDelegate));
    }
}
