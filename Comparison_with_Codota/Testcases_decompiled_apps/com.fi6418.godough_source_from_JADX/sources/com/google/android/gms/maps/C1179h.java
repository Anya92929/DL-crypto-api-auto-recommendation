package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzj;

/* renamed from: com.google.android.gms.maps.h */
class C1179h extends zzj.zza {

    /* renamed from: a */
    final /* synthetic */ GoogleMap.OnMapLoadedCallback f5076a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5077b;

    C1179h(GoogleMap googleMap, GoogleMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.f5077b = googleMap;
        this.f5076a = onMapLoadedCallback;
    }

    public void onMapLoaded() {
        this.f5076a.onMapLoaded();
    }
}
