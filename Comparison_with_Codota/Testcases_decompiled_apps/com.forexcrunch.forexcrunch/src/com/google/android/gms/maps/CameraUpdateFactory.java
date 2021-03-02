package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.internal.C0621s;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory {

    /* renamed from: fW */
    private static ICameraUpdateFactoryDelegate f1474fW;

    private CameraUpdateFactory() {
    }

    /* renamed from: a */
    static void m1930a(ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate) {
        if (f1474fW == null) {
            f1474fW = (ICameraUpdateFactoryDelegate) C0621s.m1890d(iCameraUpdateFactoryDelegate);
        }
    }

    /* renamed from: aX */
    private static ICameraUpdateFactoryDelegate m1931aX() {
        return (ICameraUpdateFactoryDelegate) C0621s.m1887b(f1474fW, (Object) "CameraUpdateFactory is not initialized");
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        try {
            return new CameraUpdate(m1931aX().newCameraPosition(cameraPosition));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        try {
            return new CameraUpdate(m1931aX().newLatLng(latLng));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds bounds, int padding) {
        try {
            return new CameraUpdate(m1931aX().newLatLngBounds(bounds, padding));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds bounds, int width, int height, int padding) {
        try {
            return new CameraUpdate(m1931aX().newLatLngBoundsWithSize(bounds, width, height, padding));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float zoom) {
        try {
            return new CameraUpdate(m1931aX().newLatLngZoom(latLng, zoom));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate scrollBy(float xPixel, float yPixel) {
        try {
            return new CameraUpdate(m1931aX().scrollBy(xPixel, yPixel));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomBy(float amount) {
        try {
            return new CameraUpdate(m1931aX().zoomBy(amount));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomBy(float amount, Point focus) {
        try {
            return new CameraUpdate(m1931aX().zoomByWithFocus(amount, focus.x, focus.y));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomIn() {
        try {
            return new CameraUpdate(m1931aX().zoomIn());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomOut() {
        try {
            return new CameraUpdate(m1931aX().zoomOut());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomTo(float zoom) {
        try {
            return new CameraUpdate(m1931aX().zoomTo(zoom));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
