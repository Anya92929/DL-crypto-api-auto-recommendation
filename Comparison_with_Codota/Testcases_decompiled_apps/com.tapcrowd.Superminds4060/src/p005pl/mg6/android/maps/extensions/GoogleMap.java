package p005pl.mg6.android.maps.extensions;

import android.location.Location;
import android.view.View;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import java.util.List;

/* renamed from: pl.mg6.android.maps.extensions.GoogleMap */
public interface GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;

    /* renamed from: pl.mg6.android.maps.extensions.GoogleMap$CancelableCallback */
    public interface CancelableCallback extends GoogleMap.CancelableCallback {
        void onCancel();

        void onFinish();
    }

    /* renamed from: pl.mg6.android.maps.extensions.GoogleMap$InfoWindowAdapter */
    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    /* renamed from: pl.mg6.android.maps.extensions.GoogleMap$OnCameraChangeListener */
    public interface OnCameraChangeListener extends GoogleMap.OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    /* renamed from: pl.mg6.android.maps.extensions.GoogleMap$OnInfoWindowClickListener */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    /* renamed from: pl.mg6.android.maps.extensions.GoogleMap$OnMapClickListener */
    public interface OnMapClickListener extends GoogleMap.OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    /* renamed from: pl.mg6.android.maps.extensions.GoogleMap$OnMapLongClickListener */
    public interface OnMapLongClickListener extends GoogleMap.OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* renamed from: pl.mg6.android.maps.extensions.GoogleMap$OnMarkerClickListener */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* renamed from: pl.mg6.android.maps.extensions.GoogleMap$OnMarkerDragListener */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* renamed from: pl.mg6.android.maps.extensions.GoogleMap$OnMyLocationChangeListener */
    public interface OnMyLocationChangeListener extends GoogleMap.OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    Circle addCircle(CircleOptions circleOptions);

    GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions);

    Marker addMarker(MarkerOptions markerOptions);

    Polygon addPolygon(PolygonOptions polygonOptions);

    Polyline addPolyline(PolylineOptions polylineOptions);

    TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions);

    void animateCamera(CameraUpdate cameraUpdate);

    void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback);

    void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback);

    void clear();

    CameraPosition getCameraPosition();

    List<Circle> getCircles();

    List<Marker> getDisplayedMarkers();

    List<GroundOverlay> getGroundOverlays();

    int getMapType();

    Marker getMarkerShowingInfoWindow();

    List<Marker> getMarkers();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    float getMinZoomLevelNotClustered(Marker marker);

    Location getMyLocation();

    List<Polygon> getPolygons();

    List<Polyline> getPolylines();

    Projection getProjection();

    List<TileOverlay> getTileOverlays();

    UiSettings getUiSettings();

    boolean isIndoorEnabled();

    boolean isMyLocationEnabled();

    boolean isTrafficEnabled();

    void moveCamera(CameraUpdate cameraUpdate);

    void setClustering(ClusteringSettings clusteringSettings);

    boolean setIndoorEnabled(boolean z);

    void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter);

    void setLocationSource(LocationSource locationSource);

    void setMapType(int i);

    void setMyLocationEnabled(boolean z);

    void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener);

    void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener);

    void setOnMapClickListener(OnMapClickListener onMapClickListener);

    void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener);

    void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener);

    void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener);

    void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener);

    void setTrafficEnabled(boolean z);

    void stopAnimation();
}
