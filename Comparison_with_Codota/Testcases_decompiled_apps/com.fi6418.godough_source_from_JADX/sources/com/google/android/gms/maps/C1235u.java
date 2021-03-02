package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzl;

/* renamed from: com.google.android.gms.maps.u */
class C1235u extends zzl.zza {

    /* renamed from: a */
    final /* synthetic */ OnMapReadyCallback f5237a;

    /* renamed from: b */
    final /* synthetic */ C1234t f5238b;

    C1235u(C1234t tVar, OnMapReadyCallback onMapReadyCallback) {
        this.f5238b = tVar;
        this.f5237a = onMapReadyCallback;
    }

    public void zza(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f5237a.onMapReady(new GoogleMap(iGoogleMapDelegate));
    }
}
