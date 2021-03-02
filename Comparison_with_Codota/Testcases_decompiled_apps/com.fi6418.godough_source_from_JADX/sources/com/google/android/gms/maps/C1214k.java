package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.internal.zzh;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* renamed from: com.google.android.gms.maps.k */
class C1214k implements LocationSource.OnLocationChangedListener {

    /* renamed from: a */
    final /* synthetic */ zzh f5116a;

    /* renamed from: b */
    final /* synthetic */ C1213j f5117b;

    C1214k(C1213j jVar, zzh zzh) {
        this.f5117b = jVar;
        this.f5116a = zzh;
    }

    public void onLocationChanged(Location location) {
        try {
            this.f5116a.zzc(location);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
