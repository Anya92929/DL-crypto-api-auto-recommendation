package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.zzh;

/* renamed from: com.google.android.gms.maps.j */
class C1213j extends ILocationSourceDelegate.zza {

    /* renamed from: a */
    final /* synthetic */ LocationSource f5114a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5115b;

    C1213j(GoogleMap googleMap, LocationSource locationSource) {
        this.f5115b = googleMap;
        this.f5114a = locationSource;
    }

    public void activate(zzh zzh) {
        this.f5114a.activate(new C1214k(this, zzh));
    }

    public void deactivate() {
        this.f5114a.deactivate();
    }
}
