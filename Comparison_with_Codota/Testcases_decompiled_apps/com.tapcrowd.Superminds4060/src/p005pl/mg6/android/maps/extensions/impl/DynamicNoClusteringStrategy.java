package p005pl.mg6.android.maps.extensions.impl;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p005pl.mg6.android.maps.extensions.Marker;

/* renamed from: pl.mg6.android.maps.extensions.impl.DynamicNoClusteringStrategy */
class DynamicNoClusteringStrategy implements ClusteringStrategy {
    private IGoogleMap map;
    private Set<DelegatingMarker> markers = new HashSet();
    private LatLngBounds visibleRegionBounds;

    public DynamicNoClusteringStrategy(IGoogleMap map2, List<DelegatingMarker> markers2) {
        this.map = map2;
        for (DelegatingMarker marker : markers2) {
            if (marker.isVisible()) {
                this.markers.add(marker);
            }
        }
        showMarkersInVisibleRegion();
    }

    public void cleanup() {
        this.markers.clear();
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        showMarkersInVisibleRegion();
    }

    public void onAdd(DelegatingMarker marker) {
        if (marker.isVisible()) {
            addMarker(marker);
        }
    }

    public void onRemove(DelegatingMarker marker) {
        if (marker.isVisible()) {
            this.markers.remove(marker);
        }
    }

    public void onPositionChange(DelegatingMarker marker) {
        if (marker.isVisible() && this.markers.contains(marker) && this.visibleRegionBounds.contains(marker.getPosition())) {
            this.markers.remove(marker);
            marker.changeVisible(true);
        }
    }

    public void onVisibilityChangeRequest(DelegatingMarker marker, boolean visible) {
        if (visible) {
            addMarker(marker);
            return;
        }
        this.markers.remove(marker);
        marker.changeVisible(false);
    }

    public Marker map(com.google.android.gms.maps.model.Marker original) {
        return null;
    }

    public List<Marker> getDisplayedMarkers() {
        return null;
    }

    public float getMinZoomLevelNotClustered(Marker marker) {
        return BitmapDescriptorFactory.HUE_RED;
    }

    private void showMarkersInVisibleRegion() {
        this.visibleRegionBounds = this.map.getProjection().getVisibleRegion().latLngBounds;
        Iterator<DelegatingMarker> iterator = this.markers.iterator();
        while (iterator.hasNext()) {
            DelegatingMarker marker = iterator.next();
            if (this.visibleRegionBounds.contains(marker.getPosition())) {
                marker.changeVisible(true);
                iterator.remove();
            }
        }
    }

    private void addMarker(DelegatingMarker marker) {
        if (this.visibleRegionBounds.contains(marker.getPosition())) {
            marker.changeVisible(true);
        } else {
            this.markers.add(marker);
        }
    }
}
