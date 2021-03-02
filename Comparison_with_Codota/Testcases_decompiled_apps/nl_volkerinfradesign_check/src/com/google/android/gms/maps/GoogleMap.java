package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.support.annotation.RequiresPermission;
import android.view.View;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.zzab;
import com.google.android.gms.maps.internal.zzb;
import com.google.android.gms.maps.internal.zzd;
import com.google.android.gms.maps.internal.zze;
import com.google.android.gms.maps.internal.zzf;
import com.google.android.gms.maps.internal.zzg;
import com.google.android.gms.maps.internal.zzh;
import com.google.android.gms.maps.internal.zzi;
import com.google.android.gms.maps.internal.zzj;
import com.google.android.gms.maps.internal.zzk;
import com.google.android.gms.maps.internal.zzl;
import com.google.android.gms.maps.internal.zzm;
import com.google.android.gms.maps.internal.zzn;
import com.google.android.gms.maps.internal.zzp;
import com.google.android.gms.maps.internal.zzq;
import com.google.android.gms.maps.internal.zzr;
import com.google.android.gms.maps.internal.zzs;
import com.google.android.gms.maps.internal.zzu;
import com.google.android.gms.maps.internal.zzv;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.zzc;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.maps.model.internal.zzh;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;

    /* renamed from: a */
    private final IGoogleMapDelegate f3290a;

    /* renamed from: b */
    private UiSettings f3291b;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnGroundOverlayClickListener {
        void onGroundOverlayClick(GroundOverlay groundOverlay);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnInfoWindowCloseListener {
        void onInfoWindowClose(Marker marker);
    }

    public interface OnInfoWindowLongClickListener {
        void onInfoWindowLongClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap$a */
    static final class C0814a extends zzb.zza {

        /* renamed from: a */
        private final CancelableCallback f3330a;

        C0814a(CancelableCallback cancelableCallback) {
            this.f3330a = cancelableCallback;
        }

        public void onCancel() {
            this.f3330a.onCancel();
        }

        public void onFinish() {
            this.f3330a.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.f3290a = (IGoogleMapDelegate) zzx.zzz(iGoogleMapDelegate);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public IGoogleMapDelegate mo6094a() {
        return this.f3290a;
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.f3290a.addCircle(circleOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            zzc addGroundOverlay = this.f3290a.addGroundOverlay(groundOverlayOptions);
            if (addGroundOverlay != null) {
                return new GroundOverlay(addGroundOverlay);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            zzf addMarker = this.f3290a.addMarker(markerOptions);
            if (addMarker != null) {
                return new Marker(addMarker);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.f3290a.addPolygon(polygonOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.f3290a.addPolyline(polylineOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            zzh addTileOverlay = this.f3290a.addTileOverlay(tileOverlayOptions);
            if (addTileOverlay != null) {
                return new TileOverlay(addTileOverlay);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.f3290a.animateCamera(cameraUpdate.zzzH());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        try {
            this.f3290a.animateCameraWithDurationAndCallback(cameraUpdate.zzzH(), i, cancelableCallback == null ? null : new C0814a(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.f3290a.animateCameraWithCallback(cameraUpdate.zzzH(), cancelableCallback == null ? null : new C0814a(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.f3290a.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.f3290a.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            zzd focusedBuilding = this.f3290a.getFocusedBuilding();
            if (focusedBuilding != null) {
                return new IndoorBuilding(focusedBuilding);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.f3290a.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.f3290a.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.f3290a.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.f3290a.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.f3290a.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.f3291b == null) {
                this.f3291b = new UiSettings(this.f3290a.getUiSettings());
            }
            return this.f3291b;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.f3290a.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.f3290a.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.f3290a.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.f3290a.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.f3290a.moveCamera(cameraUpdate.zzzH());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        try {
            this.f3290a.setBuildingsEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String str) {
        try {
            this.f3290a.setContentDescription(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean z) {
        try {
            return this.f3290a.setIndoorEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(final InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            try {
                this.f3290a.setInfoWindowAdapter((com.google.android.gms.maps.internal.zzd) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setInfoWindowAdapter(new zzd.zza() {
                public com.google.android.gms.dynamic.zzd zzb(zzf zzf) {
                    return zze.zzC(infoWindowAdapter.getInfoWindow(new Marker(zzf)));
                }

                public com.google.android.gms.dynamic.zzd zzc(zzf zzf) {
                    return zze.zzC(infoWindowAdapter.getInfoContents(new Marker(zzf)));
                }
            });
        }
    }

    public final void setLocationSource(final LocationSource locationSource) {
        if (locationSource == null) {
            try {
                this.f3290a.setLocationSource((ILocationSourceDelegate) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setLocationSource(new ILocationSourceDelegate.zza() {
                public void activate(final zzk zzk) {
                    locationSource.activate(new LocationSource.OnLocationChangedListener() {
                        public void onLocationChanged(Location location) {
                            try {
                                zzk.zzd(location);
                            } catch (RemoteException e) {
                                throw new RuntimeRemoteException(e);
                            }
                        }
                    });
                }

                public void deactivate() {
                    locationSource.deactivate();
                }
            });
        }
    }

    public final void setMapType(int i) {
        try {
            this.f3290a.setMapType(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public final void setMyLocationEnabled(boolean z) {
        try {
            this.f3290a.setMyLocationEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(final OnCameraChangeListener onCameraChangeListener) {
        if (onCameraChangeListener == null) {
            try {
                this.f3290a.setOnCameraChangeListener((com.google.android.gms.maps.internal.zze) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnCameraChangeListener(new zze.zza() {
                public void onCameraChange(CameraPosition cameraPosition) {
                    onCameraChangeListener.onCameraChange(cameraPosition);
                }
            });
        }
    }

    public final void setOnGroundOverlayClickListener(final OnGroundOverlayClickListener onGroundOverlayClickListener) {
        if (onGroundOverlayClickListener == null) {
            try {
                this.f3290a.setOnGroundOverlayClickListener((com.google.android.gms.maps.internal.zzf) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnGroundOverlayClickListener(new zzf.zza() {
                public void zza(zzc zzc) {
                    onGroundOverlayClickListener.onGroundOverlayClick(new GroundOverlay(zzc));
                }
            });
        }
    }

    public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener onIndoorStateChangeListener) {
        if (onIndoorStateChangeListener == null) {
            try {
                this.f3290a.setOnIndoorStateChangeListener((zzg) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnIndoorStateChangeListener(new zzg.zza() {
                public void onIndoorBuildingFocused() {
                    onIndoorStateChangeListener.onIndoorBuildingFocused();
                }

                public void zza(com.google.android.gms.maps.model.internal.zzd zzd) {
                    onIndoorStateChangeListener.onIndoorLevelActivated(new IndoorBuilding(zzd));
                }
            });
        }
    }

    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener onInfoWindowClickListener) {
        if (onInfoWindowClickListener == null) {
            try {
                this.f3290a.setOnInfoWindowClickListener((com.google.android.gms.maps.internal.zzh) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnInfoWindowClickListener(new zzh.zza() {
                public void zzh(com.google.android.gms.maps.model.internal.zzf zzf) {
                    onInfoWindowClickListener.onInfoWindowClick(new Marker(zzf));
                }
            });
        }
    }

    public final void setOnInfoWindowCloseListener(final OnInfoWindowCloseListener onInfoWindowCloseListener) {
        if (onInfoWindowCloseListener == null) {
            try {
                this.f3290a.setOnInfoWindowCloseListener((zzi) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnInfoWindowCloseListener(new zzi.zza() {
                public void zza(com.google.android.gms.maps.model.internal.zzf zzf) {
                    onInfoWindowCloseListener.onInfoWindowClose(new Marker(zzf));
                }
            });
        }
    }

    public final void setOnInfoWindowLongClickListener(final OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        if (onInfoWindowLongClickListener == null) {
            try {
                this.f3290a.setOnInfoWindowLongClickListener((zzj) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnInfoWindowLongClickListener(new zzj.zza() {
                public void zzi(com.google.android.gms.maps.model.internal.zzf zzf) {
                    onInfoWindowLongClickListener.onInfoWindowLongClick(new Marker(zzf));
                }
            });
        }
    }

    public final void setOnMapClickListener(final OnMapClickListener onMapClickListener) {
        if (onMapClickListener == null) {
            try {
                this.f3290a.setOnMapClickListener((zzl) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnMapClickListener(new zzl.zza() {
                public void onMapClick(LatLng latLng) {
                    onMapClickListener.onMapClick(latLng);
                }
            });
        }
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback onMapLoadedCallback) {
        if (onMapLoadedCallback == null) {
            try {
                this.f3290a.setOnMapLoadedCallback((zzm) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnMapLoadedCallback(new zzm.zza() {
                public void onMapLoaded() throws RemoteException {
                    onMapLoadedCallback.onMapLoaded();
                }
            });
        }
    }

    public final void setOnMapLongClickListener(final OnMapLongClickListener onMapLongClickListener) {
        if (onMapLongClickListener == null) {
            try {
                this.f3290a.setOnMapLongClickListener((zzn) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnMapLongClickListener(new zzn.zza() {
                public void onMapLongClick(LatLng latLng) {
                    onMapLongClickListener.onMapLongClick(latLng);
                }
            });
        }
    }

    public final void setOnMarkerClickListener(final OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null) {
            try {
                this.f3290a.setOnMarkerClickListener((zzp) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnMarkerClickListener(new zzp.zza() {
                public boolean zzd(com.google.android.gms.maps.model.internal.zzf zzf) {
                    return onMarkerClickListener.onMarkerClick(new Marker(zzf));
                }
            });
        }
    }

    public final void setOnMarkerDragListener(final OnMarkerDragListener onMarkerDragListener) {
        if (onMarkerDragListener == null) {
            try {
                this.f3290a.setOnMarkerDragListener((zzq) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnMarkerDragListener(new zzq.zza() {
                public void zze(com.google.android.gms.maps.model.internal.zzf zzf) {
                    onMarkerDragListener.onMarkerDragStart(new Marker(zzf));
                }

                public void zzf(com.google.android.gms.maps.model.internal.zzf zzf) {
                    onMarkerDragListener.onMarkerDragEnd(new Marker(zzf));
                }

                public void zzg(com.google.android.gms.maps.model.internal.zzf zzf) {
                    onMarkerDragListener.onMarkerDrag(new Marker(zzf));
                }
            });
        }
    }

    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        if (onMyLocationButtonClickListener == null) {
            try {
                this.f3290a.setOnMyLocationButtonClickListener((zzr) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnMyLocationButtonClickListener(new zzr.zza() {
                public boolean onMyLocationButtonClick() throws RemoteException {
                    return onMyLocationButtonClickListener.onMyLocationButtonClick();
                }
            });
        }
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener onMyLocationChangeListener) {
        if (onMyLocationChangeListener == null) {
            try {
                this.f3290a.setOnMyLocationChangeListener((zzs) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnMyLocationChangeListener(new zzs.zza() {
                public void zzq(com.google.android.gms.dynamic.zzd zzd) {
                    onMyLocationChangeListener.onMyLocationChange((Location) com.google.android.gms.dynamic.zze.zzp(zzd));
                }
            });
        }
    }

    public final void setOnPolygonClickListener(final OnPolygonClickListener onPolygonClickListener) {
        if (onPolygonClickListener == null) {
            try {
                this.f3290a.setOnPolygonClickListener((zzu) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnPolygonClickListener(new zzu.zza() {
                public void zza(com.google.android.gms.maps.model.internal.zzg zzg) {
                    onPolygonClickListener.onPolygonClick(new Polygon(zzg));
                }
            });
        }
    }

    public final void setOnPolylineClickListener(final OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener == null) {
            try {
                this.f3290a.setOnPolylineClickListener((zzv) null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.f3290a.setOnPolylineClickListener(new zzv.zza() {
                public void zza(IPolylineDelegate iPolylineDelegate) {
                    onPolylineClickListener.onPolylineClick(new Polyline(iPolylineDelegate));
                }
            });
        }
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        try {
            this.f3290a.setPadding(i, i2, i3, i4);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        try {
            this.f3290a.setTrafficEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        snapshot(snapshotReadyCallback, (Bitmap) null);
    }

    public final void snapshot(final SnapshotReadyCallback snapshotReadyCallback, Bitmap bitmap) {
        try {
            this.f3290a.snapshot(new zzab.zza() {
                public void onSnapshotReady(Bitmap bitmap) throws RemoteException {
                    snapshotReadyCallback.onSnapshotReady(bitmap);
                }

                public void zzr(com.google.android.gms.dynamic.zzd zzd) throws RemoteException {
                    snapshotReadyCallback.onSnapshotReady((Bitmap) com.google.android.gms.dynamic.zze.zzp(zzd));
                }
            }, (com.google.android.gms.dynamic.zze) (bitmap != null ? com.google.android.gms.dynamic.zze.zzC(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.f3290a.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
