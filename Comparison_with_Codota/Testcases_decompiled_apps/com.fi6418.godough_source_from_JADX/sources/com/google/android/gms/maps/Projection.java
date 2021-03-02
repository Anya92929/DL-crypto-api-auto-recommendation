package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;
import com.google.android.gms.p017b.C0608m;

public final class Projection {

    /* renamed from: a */
    private final IProjectionDelegate f5007a;

    Projection(IProjectionDelegate iProjectionDelegate) {
        this.f5007a = iProjectionDelegate;
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.f5007a.fromScreenLocation(C0608m.m3536a(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.f5007a.getVisibleRegion();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        try {
            return (Point) C0608m.m3537a(this.f5007a.toScreenLocation(latLng));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
