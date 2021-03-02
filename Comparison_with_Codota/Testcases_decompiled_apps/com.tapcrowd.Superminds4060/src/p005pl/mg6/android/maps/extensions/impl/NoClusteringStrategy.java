package p005pl.mg6.android.maps.extensions.impl;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import java.util.List;
import p005pl.mg6.android.maps.extensions.Marker;

/* renamed from: pl.mg6.android.maps.extensions.impl.NoClusteringStrategy */
class NoClusteringStrategy implements ClusteringStrategy {
    public NoClusteringStrategy(List<DelegatingMarker> markers) {
        for (DelegatingMarker marker : markers) {
            if (marker.isVisible()) {
                marker.changeVisible(true);
            }
        }
    }

    public void cleanup() {
    }

    public void onCameraChange(CameraPosition cameraPosition) {
    }

    public void onAdd(DelegatingMarker marker) {
    }

    public void onRemove(DelegatingMarker marker) {
    }

    public void onPositionChange(DelegatingMarker marker) {
    }

    public void onVisibilityChangeRequest(DelegatingMarker marker, boolean visible) {
        marker.changeVisible(visible);
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
}
