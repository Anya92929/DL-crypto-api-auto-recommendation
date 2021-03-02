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

/* renamed from: pl.mg6.android.maps.extensions.impl.IGoogleMap */
interface IGoogleMap {
    Circle addCircle(CircleOptions circleOptions);

    GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions);

    Marker addMarker(MarkerOptions markerOptions);

    Polygon addPolygon(PolygonOptions polygonOptions);

    Polyline addPolyline(PolylineOptions polylineOptions);

    TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions);

    void animateCamera(CameraUpdate cameraUpdate);

    void animateCamera(CameraUpdate cameraUpdate, int i, GoogleMap.CancelableCallback cancelableCallback);

    void animateCamera(CameraUpdate cameraUpdate, GoogleMap.CancelableCallback cancelableCallback);

    void clear();

    CameraPosition getCameraPosition();

    GoogleMap getMap();

    int getMapType();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    Location getMyLocation();

    IProjection getProjection();

    UiSettings getUiSettings();

    boolean isIndoorEnabled();

    boolean isMyLocationEnabled();

    boolean isTrafficEnabled();

    void moveCamera(CameraUpdate cameraUpdate);

    boolean setIndoorEnabled(boolean z);

    void setInfoWindowAdapter(GoogleMap.InfoWindowAdapter infoWindowAdapter);

    void setLocationSource(LocationSource locationSource);

    void setMapType(int i);

    void setMyLocationEnabled(boolean z);

    void setOnCameraChangeListener(GoogleMap.OnCameraChangeListener onCameraChangeListener);

    void setOnInfoWindowClickListener(GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener);

    void setOnMapClickListener(GoogleMap.OnMapClickListener onMapClickListener);

    void setOnMapLongClickListener(GoogleMap.OnMapLongClickListener onMapLongClickListener);

    void setOnMarkerClickListener(GoogleMap.OnMarkerClickListener onMarkerClickListener);

    void setOnMarkerDragListener(GoogleMap.OnMarkerDragListener onMarkerDragListener);

    void setOnMyLocationChangeListener(GoogleMap.OnMyLocationChangeListener onMyLocationChangeListener);

    void setTrafficEnabled(boolean z);

    void stopAnimation();
}
