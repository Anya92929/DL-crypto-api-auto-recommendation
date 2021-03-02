package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzr;
import com.google.android.gms.maps.internal.zzs;
import com.google.android.gms.maps.internal.zzt;
import com.google.android.gms.maps.internal.zzu;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.p017b.C0605j;
import com.google.android.gms.p017b.C0608m;

public class StreetViewPanorama {

    /* renamed from: a */
    private final IStreetViewPanoramaDelegate f5008a;

    public interface OnStreetViewPanoramaCameraChangeListener {
        void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    public interface OnStreetViewPanoramaChangeListener {
        void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    public interface OnStreetViewPanoramaClickListener {
        void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public interface OnStreetViewPanoramaLongClickListener {
        void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    protected StreetViewPanorama(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.f5008a = (IStreetViewPanoramaDelegate) C1009bf.m4528a(iStreetViewPanoramaDelegate);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public IStreetViewPanoramaDelegate mo8067a() {
        return this.f5008a;
    }

    public void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j) {
        try {
            this.f5008a.animateTo(streetViewPanoramaCamera, j);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaLocation getLocation() {
        try {
            return this.f5008a.getStreetViewPanoramaLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaCamera getPanoramaCamera() {
        try {
            return this.f5008a.getPanoramaCamera();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isPanningGesturesEnabled() {
        try {
            return this.f5008a.isPanningGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isStreetNamesEnabled() {
        try {
            return this.f5008a.isStreetNamesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUserNavigationEnabled() {
        try {
            return this.f5008a.isUserNavigationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.f5008a.isZoomGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        try {
            C0605j orientationToPoint = this.f5008a.orientationToPoint(streetViewPanoramaOrientation);
            if (orientationToPoint == null) {
                return null;
            }
            return (Point) C0608m.m3537a(orientationToPoint);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point) {
        try {
            return this.f5008a.pointToOrientation(C0608m.m3536a(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
        if (onStreetViewPanoramaCameraChangeListener == null) {
            try {
                this.f5008a.setOnStreetViewPanoramaCameraChangeListener((zzr) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f5008a.setOnStreetViewPanoramaCameraChangeListener(new C1238x(this, onStreetViewPanoramaCameraChangeListener));
        }
    }

    public final void setOnStreetViewPanoramaChangeListener(OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
        if (onStreetViewPanoramaChangeListener == null) {
            try {
                this.f5008a.setOnStreetViewPanoramaChangeListener((zzs) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f5008a.setOnStreetViewPanoramaChangeListener(new C1237w(this, onStreetViewPanoramaChangeListener));
        }
    }

    public final void setOnStreetViewPanoramaClickListener(OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
        if (onStreetViewPanoramaClickListener == null) {
            try {
                this.f5008a.setOnStreetViewPanoramaClickListener((zzt) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f5008a.setOnStreetViewPanoramaClickListener(new C1239y(this, onStreetViewPanoramaClickListener));
        }
    }

    public final void setOnStreetViewPanoramaLongClickListener(OnStreetViewPanoramaLongClickListener onStreetViewPanoramaLongClickListener) {
        if (onStreetViewPanoramaLongClickListener == null) {
            try {
                this.f5008a.setOnStreetViewPanoramaLongClickListener((zzu) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f5008a.setOnStreetViewPanoramaLongClickListener(new C1240z(this, onStreetViewPanoramaLongClickListener));
        }
    }

    public void setPanningGesturesEnabled(boolean z) {
        try {
            this.f5008a.enablePanning(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.f5008a.setPosition(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng latLng, int i) {
        try {
            this.f5008a.setPositionWithRadius(latLng, i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(String str) {
        try {
            this.f5008a.setPositionWithID(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStreetNamesEnabled(boolean z) {
        try {
            this.f5008a.enableStreetNames(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setUserNavigationEnabled(boolean z) {
        try {
            this.f5008a.enableUserNavigation(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        try {
            this.f5008a.enableZoom(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
