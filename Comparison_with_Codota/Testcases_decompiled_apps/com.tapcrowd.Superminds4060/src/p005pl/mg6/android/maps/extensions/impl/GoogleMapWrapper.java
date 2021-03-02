package p005pl.mg6.android.maps.extensions.impl;

import android.location.Location;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;

/* renamed from: pl.mg6.android.maps.extensions.impl.GoogleMapWrapper */
class GoogleMapWrapper implements IGoogleMap {
    private GoogleMap map;

    public GoogleMapWrapper(GoogleMap map2) {
        this.map = map2;
    }

    public final Circle addCircle(CircleOptions arg0) {
        return this.map.addCircle(arg0);
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions arg0) {
        return this.map.addGroundOverlay(arg0);
    }

    public final Marker addMarker(MarkerOptions arg0) {
        return this.map.addMarker(arg0);
    }

    public final Polygon addPolygon(PolygonOptions arg0) {
        return this.map.addPolygon(arg0);
    }

    public final Polyline addPolyline(PolylineOptions arg0) {
        return this.map.addPolyline(arg0);
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions arg0) {
        return this.map.addTileOverlay(arg0);
    }

    public final void animateCamera(CameraUpdate arg0, GoogleMap.CancelableCallback arg1) {
        this.map.animateCamera(arg0, arg1);
    }

    public final void animateCamera(CameraUpdate arg0, int arg1, GoogleMap.CancelableCallback arg2) {
        this.map.animateCamera(arg0, arg1, arg2);
    }

    public final void animateCamera(CameraUpdate arg0) {
        this.map.animateCamera(arg0);
    }

    public final void clear() {
        this.map.clear();
    }

    public final CameraPosition getCameraPosition() {
        return this.map.getCameraPosition();
    }

    public final int getMapType() {
        return this.map.getMapType();
    }

    public final float getMaxZoomLevel() {
        return this.map.getMaxZoomLevel();
    }

    public final float getMinZoomLevel() {
        return this.map.getMinZoomLevel();
    }

    public final Location getMyLocation() {
        return this.map.getMyLocation();
    }

    public final ProjectionWrapper getProjection() {
        return new ProjectionWrapper(this.map.getProjection());
    }

    public final UiSettings getUiSettings() {
        return this.map.getUiSettings();
    }

    public final boolean isIndoorEnabled() {
        return this.map.isIndoorEnabled();
    }

    public final boolean isMyLocationEnabled() {
        return this.map.isMyLocationEnabled();
    }

    public final boolean isTrafficEnabled() {
        return this.map.isTrafficEnabled();
    }

    public final void moveCamera(CameraUpdate arg0) {
        this.map.moveCamera(arg0);
    }

    public final boolean setIndoorEnabled(boolean arg0) {
        return this.map.setIndoorEnabled(arg0);
    }

    public final void setInfoWindowAdapter(GoogleMap.InfoWindowAdapter arg0) {
        this.map.setInfoWindowAdapter(arg0);
    }

    public final void setLocationSource(LocationSource arg0) {
        this.map.setLocationSource(arg0);
    }

    public final void setMapType(int arg0) {
        this.map.setMapType(arg0);
    }

    public final void setMyLocationEnabled(boolean arg0) {
        this.map.setMyLocationEnabled(arg0);
    }

    public final void setOnCameraChangeListener(GoogleMap.OnCameraChangeListener arg0) {
        this.map.setOnCameraChangeListener(arg0);
    }

    public final void setOnInfoWindowClickListener(GoogleMap.OnInfoWindowClickListener arg0) {
        this.map.setOnInfoWindowClickListener(arg0);
    }

    public final void setOnMapClickListener(GoogleMap.OnMapClickListener arg0) {
        this.map.setOnMapClickListener(arg0);
    }

    public final void setOnMapLongClickListener(GoogleMap.OnMapLongClickListener arg0) {
        this.map.setOnMapLongClickListener(arg0);
    }

    public final void setOnMarkerClickListener(GoogleMap.OnMarkerClickListener arg0) {
        this.map.setOnMarkerClickListener(arg0);
    }

    public final void setOnMarkerDragListener(GoogleMap.OnMarkerDragListener arg0) {
        this.map.setOnMarkerDragListener(arg0);
    }

    public final void setOnMyLocationChangeListener(GoogleMap.OnMyLocationChangeListener arg0) {
        this.map.setOnMyLocationChangeListener(arg0);
    }

    public final void setTrafficEnabled(boolean arg0) {
        this.map.setTrafficEnabled(arg0);
    }

    public final void stopAnimation() {
        this.map.stopAnimation();
    }

    public GoogleMap getMap() {
        return this.map;
    }
}
