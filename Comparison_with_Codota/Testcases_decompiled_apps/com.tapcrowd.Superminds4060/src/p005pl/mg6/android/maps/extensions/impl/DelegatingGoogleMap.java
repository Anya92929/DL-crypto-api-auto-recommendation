package p005pl.mg6.android.maps.extensions.impl;

import android.location.Location;
import android.view.View;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.Projection;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p005pl.mg6.android.maps.extensions.ClusteringSettings;
import p005pl.mg6.android.maps.extensions.GoogleMap;
import p005pl.mg6.android.maps.extensions.lazy.LazyMarker;

/* renamed from: pl.mg6.android.maps.extensions.impl.DelegatingGoogleMap */
public class DelegatingGoogleMap implements GoogleMap, LazyMarker.OnMarkerCreateListener {
    private Map<Circle, p005pl.mg6.android.maps.extensions.Circle> circles;
    private ClusteringSettings clusteringSettings = new ClusteringSettings().enabled(false);
    /* access modifiers changed from: private */
    public ClusteringStrategy clusteringStrategy = new NoClusteringStrategy(new ArrayList());
    /* access modifiers changed from: private */
    public Map<Marker, LazyMarker> createdMarkers;
    private Map<GroundOverlay, p005pl.mg6.android.maps.extensions.GroundOverlay> groundOverlays;
    /* access modifiers changed from: private */
    public GoogleMap.InfoWindowAdapter infoWindowAdapter;
    /* access modifiers changed from: private */
    public p005pl.mg6.android.maps.extensions.Marker markerShowingInfoWindow;
    /* access modifiers changed from: private */
    public Map<LazyMarker, DelegatingMarker> markers;
    /* access modifiers changed from: private */
    public GoogleMap.OnCameraChangeListener onCameraChangeListener;
    /* access modifiers changed from: private */
    public GoogleMap.OnMarkerDragListener onMarkerDragListener;
    private Map<Polygon, p005pl.mg6.android.maps.extensions.Polygon> polygons;
    private Map<Polyline, p005pl.mg6.android.maps.extensions.Polyline> polylines;
    private GoogleMapWrapper real;
    private Map<TileOverlay, p005pl.mg6.android.maps.extensions.TileOverlay> tileOverlays;

    public DelegatingGoogleMap(com.google.android.gms.maps.GoogleMap real2) {
        this.real = new GoogleMapWrapper(real2);
        this.markers = new HashMap();
        this.createdMarkers = new HashMap();
        this.polylines = new HashMap();
        this.polygons = new HashMap();
        this.circles = new HashMap();
        this.groundOverlays = new HashMap();
        this.tileOverlays = new HashMap();
        real2.setInfoWindowAdapter(new DelegatingInfoWindowAdapter(this, (DelegatingInfoWindowAdapter) null));
        real2.setOnCameraChangeListener(new DelegatingOnCameraChangeListener(this, (DelegatingOnCameraChangeListener) null));
        real2.setOnMarkerDragListener(new DelegatingOnMarkerDragListener(this, (DelegatingOnMarkerDragListener) null));
    }

    public p005pl.mg6.android.maps.extensions.Circle addCircle(CircleOptions circleOptions) {
        Circle realCircle = this.real.addCircle(circleOptions);
        p005pl.mg6.android.maps.extensions.Circle circle = new DelegatingCircle(realCircle, this);
        this.circles.put(realCircle, circle);
        return circle;
    }

    public p005pl.mg6.android.maps.extensions.GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        GroundOverlay realGroundOverlay = this.real.addGroundOverlay(groundOverlayOptions);
        p005pl.mg6.android.maps.extensions.GroundOverlay groundOverlay = new DelegatingGroundOverlay(realGroundOverlay, this);
        this.groundOverlays.put(realGroundOverlay, groundOverlay);
        return groundOverlay;
    }

    public p005pl.mg6.android.maps.extensions.Marker addMarker(MarkerOptions markerOptions) {
        boolean visible = markerOptions.isVisible();
        markerOptions.visible(false);
        LazyMarker realMarker = new LazyMarker(this.real.getMap(), markerOptions, this);
        markerOptions.visible(visible);
        DelegatingMarker marker = new DelegatingMarker(realMarker, this);
        this.markers.put(realMarker, marker);
        this.clusteringStrategy.onAdd(marker);
        marker.setVisible(visible);
        return marker;
    }

    public p005pl.mg6.android.maps.extensions.Polygon addPolygon(PolygonOptions polygonOptions) {
        Polygon realPolygon = this.real.addPolygon(polygonOptions);
        p005pl.mg6.android.maps.extensions.Polygon polygon = new DelegatingPolygon(realPolygon, this);
        this.polygons.put(realPolygon, polygon);
        return polygon;
    }

    public p005pl.mg6.android.maps.extensions.Polyline addPolyline(PolylineOptions polylineOptions) {
        Polyline realPolyline = this.real.addPolyline(polylineOptions);
        p005pl.mg6.android.maps.extensions.Polyline polyline = new DelegatingPolyline(realPolyline, this);
        this.polylines.put(realPolyline, polyline);
        return polyline;
    }

    public p005pl.mg6.android.maps.extensions.TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        TileOverlay realTileOverlay = this.real.addTileOverlay(tileOverlayOptions);
        p005pl.mg6.android.maps.extensions.TileOverlay tileOverlay = new DelegatingTileOverlay(realTileOverlay, this);
        this.tileOverlays.put(realTileOverlay, tileOverlay);
        return tileOverlay;
    }

    public void animateCamera(CameraUpdate cameraUpdate, GoogleMap.CancelableCallback cancelableCallback) {
        this.real.animateCamera(cameraUpdate, cancelableCallback);
    }

    public void animateCamera(CameraUpdate cameraUpdate, int time, GoogleMap.CancelableCallback cancelableCallback) {
        this.real.animateCamera(cameraUpdate, time, cancelableCallback);
    }

    public void animateCamera(CameraUpdate cameraUpdate) {
        this.real.animateCamera(cameraUpdate);
    }

    public void clear() {
        this.real.clear();
        this.markers.clear();
        this.createdMarkers.clear();
        this.polylines.clear();
        this.polygons.clear();
        this.circles.clear();
        this.groundOverlays.clear();
        this.tileOverlays.clear();
        this.clusteringStrategy.cleanup();
    }

    public CameraPosition getCameraPosition() {
        return this.real.getCameraPosition();
    }

    public List<p005pl.mg6.android.maps.extensions.Marker> getDisplayedMarkers() {
        List<p005pl.mg6.android.maps.extensions.Marker> displayedMarkers = this.clusteringStrategy.getDisplayedMarkers();
        if (displayedMarkers == null) {
            displayedMarkers = getMarkers();
            Iterator<p005pl.mg6.android.maps.extensions.Marker> iterator = displayedMarkers.iterator();
            while (iterator.hasNext()) {
                if (!iterator.next().isVisible()) {
                    iterator.remove();
                }
            }
        }
        return displayedMarkers;
    }

    public int getMapType() {
        return this.real.getMapType();
    }

    public List<p005pl.mg6.android.maps.extensions.Circle> getCircles() {
        return new ArrayList(this.circles.values());
    }

    public List<p005pl.mg6.android.maps.extensions.GroundOverlay> getGroundOverlays() {
        return new ArrayList(this.groundOverlays.values());
    }

    public List<p005pl.mg6.android.maps.extensions.Marker> getMarkers() {
        return new ArrayList(this.markers.values());
    }

    public p005pl.mg6.android.maps.extensions.Marker getMarkerShowingInfoWindow() {
        if (this.markerShowingInfoWindow != null && !this.markerShowingInfoWindow.isInfoWindowShown()) {
            this.markerShowingInfoWindow = null;
        }
        return this.markerShowingInfoWindow;
    }

    public List<p005pl.mg6.android.maps.extensions.Polygon> getPolygons() {
        return new ArrayList(this.polygons.values());
    }

    public List<p005pl.mg6.android.maps.extensions.Polyline> getPolylines() {
        return new ArrayList(this.polylines.values());
    }

    public List<p005pl.mg6.android.maps.extensions.TileOverlay> getTileOverlays() {
        return new ArrayList(this.tileOverlays.values());
    }

    public float getMaxZoomLevel() {
        return this.real.getMaxZoomLevel();
    }

    public float getMinZoomLevel() {
        return this.real.getMinZoomLevel();
    }

    public float getMinZoomLevelNotClustered(p005pl.mg6.android.maps.extensions.Marker marker) {
        return this.clusteringStrategy.getMinZoomLevelNotClustered(marker);
    }

    public Location getMyLocation() {
        return this.real.getMyLocation();
    }

    public Projection getProjection() {
        return this.real.getProjection().getProjection();
    }

    public UiSettings getUiSettings() {
        return this.real.getUiSettings();
    }

    public boolean isIndoorEnabled() {
        return this.real.isIndoorEnabled();
    }

    public boolean isMyLocationEnabled() {
        return this.real.isMyLocationEnabled();
    }

    public boolean isTrafficEnabled() {
        return this.real.isTrafficEnabled();
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        this.real.moveCamera(cameraUpdate);
    }

    public void setClustering(ClusteringSettings clusteringSettings2) {
        if (clusteringSettings2 == null) {
            clusteringSettings2 = new ClusteringSettings().enabled(false);
        }
        if (!this.clusteringSettings.equals(clusteringSettings2)) {
            this.clusteringSettings = clusteringSettings2;
            this.clusteringStrategy.cleanup();
            ArrayList<DelegatingMarker> list = new ArrayList<>(this.markers.values());
            if (clusteringSettings2.isEnabled()) {
                this.clusteringStrategy = new GridClusteringStrategy(clusteringSettings2, this.real, list, new ClusterRefresher());
            } else if (clusteringSettings2.isAddMarkersDynamically()) {
                this.clusteringStrategy = new DynamicNoClusteringStrategy(this.real, list);
            } else {
                this.clusteringStrategy = new NoClusteringStrategy(list);
            }
        }
    }

    public boolean setIndoorEnabled(boolean indoorEnabled) {
        return this.real.setIndoorEnabled(indoorEnabled);
    }

    public void setInfoWindowAdapter(GoogleMap.InfoWindowAdapter infoWindowAdapter2) {
        this.infoWindowAdapter = infoWindowAdapter2;
    }

    public void setLocationSource(LocationSource locationSource) {
        this.real.setLocationSource(locationSource);
    }

    public void setMapType(int mapType) {
        this.real.setMapType(mapType);
    }

    public void setMyLocationEnabled(boolean myLocationEnabled) {
        this.real.setMyLocationEnabled(myLocationEnabled);
    }

    public void setOnCameraChangeListener(GoogleMap.OnCameraChangeListener onCameraChangeListener2) {
        this.onCameraChangeListener = onCameraChangeListener2;
    }

    public void setOnInfoWindowClickListener(GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        GoogleMap.OnInfoWindowClickListener realOnInfoWindowClickListener = null;
        if (onInfoWindowClickListener != null) {
            realOnInfoWindowClickListener = new DelegatingOnInfoWindowClickListener(this, onInfoWindowClickListener, (DelegatingOnInfoWindowClickListener) null);
        }
        this.real.setOnInfoWindowClickListener(realOnInfoWindowClickListener);
    }

    public void setOnMapClickListener(GoogleMap.OnMapClickListener onMapClickListener) {
        this.real.setOnMapClickListener(onMapClickListener);
    }

    public void setOnMapLongClickListener(GoogleMap.OnMapLongClickListener onMapLongClickListener) {
        this.real.setOnMapLongClickListener(onMapLongClickListener);
    }

    public void setOnMarkerClickListener(GoogleMap.OnMarkerClickListener onMarkerClickListener) {
        GoogleMap.OnMarkerClickListener realOnMarkerClickListener = null;
        if (onMarkerClickListener != null) {
            realOnMarkerClickListener = new DelegatingOnMarkerClickListener(this, onMarkerClickListener, (DelegatingOnMarkerClickListener) null);
        }
        this.real.setOnMarkerClickListener(realOnMarkerClickListener);
    }

    public void setOnMarkerDragListener(GoogleMap.OnMarkerDragListener onMarkerDragListener2) {
        this.onMarkerDragListener = onMarkerDragListener2;
    }

    public void setOnMyLocationChangeListener(GoogleMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        this.real.setOnMyLocationChangeListener(onMyLocationChangeListener);
    }

    public void setTrafficEnabled(boolean trafficEnabled) {
        this.real.setTrafficEnabled(trafficEnabled);
    }

    public void stopAnimation() {
        this.real.stopAnimation();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DelegatingGoogleMap)) {
            return false;
        }
        return this.real.equals(((DelegatingGoogleMap) o).real);
    }

    public int hashCode() {
        return this.real.hashCode();
    }

    public String toString() {
        return this.real.toString();
    }

    /* access modifiers changed from: package-private */
    public void remove(Polyline polyline) {
        this.polylines.remove(polyline);
    }

    /* access modifiers changed from: package-private */
    public void remove(Polygon polygon) {
        this.polygons.remove(polygon);
    }

    /* access modifiers changed from: package-private */
    public void remove(Circle circle) {
        this.circles.remove(circle);
    }

    /* access modifiers changed from: package-private */
    public void remove(GroundOverlay groundOverlay) {
        this.groundOverlays.remove(groundOverlay);
    }

    /* access modifiers changed from: package-private */
    public void remove(TileOverlay tileOverlay) {
        this.tileOverlays.remove(tileOverlay);
    }

    /* access modifiers changed from: package-private */
    public void onRemove(DelegatingMarker marker) {
        this.markers.remove(marker.getReal());
        this.createdMarkers.remove(marker.getReal().getMarker());
        this.clusteringStrategy.onRemove(marker);
    }

    /* access modifiers changed from: package-private */
    public void onPositionChange(DelegatingMarker marker) {
        this.clusteringStrategy.onPositionChange(marker);
    }

    /* access modifiers changed from: package-private */
    public void onVisibilityChangeRequest(DelegatingMarker marker, boolean visible) {
        this.clusteringStrategy.onVisibilityChangeRequest(marker, visible);
    }

    public void onMarkerCreate(LazyMarker marker) {
        this.createdMarkers.put(marker.getMarker(), marker);
    }

    /* renamed from: pl.mg6.android.maps.extensions.impl.DelegatingGoogleMap$DelegatingOnCameraChangeListener */
    private class DelegatingOnCameraChangeListener implements GoogleMap.OnCameraChangeListener {
        private DelegatingOnCameraChangeListener() {
        }

        /* synthetic */ DelegatingOnCameraChangeListener(DelegatingGoogleMap delegatingGoogleMap, DelegatingOnCameraChangeListener delegatingOnCameraChangeListener) {
            this();
        }

        public void onCameraChange(CameraPosition cameraPosition) {
            DelegatingGoogleMap.this.clusteringStrategy.onCameraChange(cameraPosition);
            if (DelegatingGoogleMap.this.onCameraChangeListener != null) {
                DelegatingGoogleMap.this.onCameraChangeListener.onCameraChange(cameraPosition);
            }
        }
    }

    /* renamed from: pl.mg6.android.maps.extensions.impl.DelegatingGoogleMap$DelegatingInfoWindowAdapter */
    private class DelegatingInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
        private DelegatingInfoWindowAdapter() {
        }

        /* synthetic */ DelegatingInfoWindowAdapter(DelegatingGoogleMap delegatingGoogleMap, DelegatingInfoWindowAdapter delegatingInfoWindowAdapter) {
            this();
        }

        public View getInfoWindow(Marker marker) {
            DelegatingGoogleMap.this.markerShowingInfoWindow = DelegatingGoogleMap.this.map(marker);
            if (DelegatingGoogleMap.this.infoWindowAdapter != null) {
                return DelegatingGoogleMap.this.infoWindowAdapter.getInfoWindow(DelegatingGoogleMap.this.markerShowingInfoWindow);
            }
            return null;
        }

        public View getInfoContents(Marker marker) {
            if (DelegatingGoogleMap.this.infoWindowAdapter != null) {
                return DelegatingGoogleMap.this.infoWindowAdapter.getInfoContents(DelegatingGoogleMap.this.map(marker));
            }
            return null;
        }
    }

    /* renamed from: pl.mg6.android.maps.extensions.impl.DelegatingGoogleMap$DelegatingOnInfoWindowClickListener */
    private class DelegatingOnInfoWindowClickListener implements GoogleMap.OnInfoWindowClickListener {
        private GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener;

        private DelegatingOnInfoWindowClickListener(GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener2) {
            this.onInfoWindowClickListener = onInfoWindowClickListener2;
        }

        /* synthetic */ DelegatingOnInfoWindowClickListener(DelegatingGoogleMap delegatingGoogleMap, GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener2, DelegatingOnInfoWindowClickListener delegatingOnInfoWindowClickListener) {
            this(onInfoWindowClickListener2);
        }

        public void onInfoWindowClick(Marker marker) {
            this.onInfoWindowClickListener.onInfoWindowClick(DelegatingGoogleMap.this.map(marker));
        }
    }

    /* renamed from: pl.mg6.android.maps.extensions.impl.DelegatingGoogleMap$DelegatingOnMarkerClickListener */
    private class DelegatingOnMarkerClickListener implements GoogleMap.OnMarkerClickListener {
        private GoogleMap.OnMarkerClickListener onMarkerClickListener;

        private DelegatingOnMarkerClickListener(GoogleMap.OnMarkerClickListener onMarkerClickListener2) {
            this.onMarkerClickListener = onMarkerClickListener2;
        }

        /* synthetic */ DelegatingOnMarkerClickListener(DelegatingGoogleMap delegatingGoogleMap, GoogleMap.OnMarkerClickListener onMarkerClickListener2, DelegatingOnMarkerClickListener delegatingOnMarkerClickListener) {
            this(onMarkerClickListener2);
        }

        public boolean onMarkerClick(Marker marker) {
            return this.onMarkerClickListener.onMarkerClick(DelegatingGoogleMap.this.map(marker));
        }
    }

    /* renamed from: pl.mg6.android.maps.extensions.impl.DelegatingGoogleMap$DelegatingOnMarkerDragListener */
    private class DelegatingOnMarkerDragListener implements GoogleMap.OnMarkerDragListener {
        private DelegatingOnMarkerDragListener() {
        }

        /* synthetic */ DelegatingOnMarkerDragListener(DelegatingGoogleMap delegatingGoogleMap, DelegatingOnMarkerDragListener delegatingOnMarkerDragListener) {
            this();
        }

        public void onMarkerDragStart(Marker marker) {
            if (DelegatingGoogleMap.this.onMarkerDragListener != null) {
                DelegatingGoogleMap.this.onMarkerDragListener.onMarkerDragStart(DelegatingGoogleMap.this.map(marker));
            }
        }

        public void onMarkerDrag(Marker marker) {
            if (DelegatingGoogleMap.this.onMarkerDragListener != null) {
                DelegatingGoogleMap.this.onMarkerDragListener.onMarkerDrag(DelegatingGoogleMap.this.map(marker));
            }
        }

        public void onMarkerDragEnd(Marker marker) {
            Map access$8 = DelegatingGoogleMap.this.markers;
            DelegatingGoogleMap.this.clusteringStrategy.onPositionChange((DelegatingMarker) access$8.get((LazyMarker) DelegatingGoogleMap.this.createdMarkers.get(marker)));
            if (DelegatingGoogleMap.this.onMarkerDragListener != null) {
                DelegatingGoogleMap.this.onMarkerDragListener.onMarkerDragEnd(DelegatingGoogleMap.this.map(marker));
            }
        }
    }

    /* access modifiers changed from: private */
    public p005pl.mg6.android.maps.extensions.Marker map(Marker marker) {
        p005pl.mg6.android.maps.extensions.Marker cluster = this.clusteringStrategy.map(marker);
        if (cluster != null) {
            return cluster;
        }
        return (DelegatingMarker) this.markers.get(this.createdMarkers.get(marker));
    }
}
