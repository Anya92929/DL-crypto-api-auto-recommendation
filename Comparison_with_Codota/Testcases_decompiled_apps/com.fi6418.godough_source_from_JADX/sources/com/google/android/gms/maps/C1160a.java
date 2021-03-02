package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzf;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.internal.zzd;

/* renamed from: com.google.android.gms.maps.a */
class C1160a extends zzf.zza {

    /* renamed from: a */
    final /* synthetic */ GoogleMap.OnIndoorStateChangeListener f5028a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5029b;

    C1160a(GoogleMap googleMap, GoogleMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        this.f5029b = googleMap;
        this.f5028a = onIndoorStateChangeListener;
    }

    public void onIndoorBuildingFocused() {
        this.f5028a.onIndoorBuildingFocused();
    }

    public void zza(zzd zzd) {
        this.f5028a.onIndoorLevelActivated(new IndoorBuilding(zzd));
    }
}
