package p005pl.mg6.android.maps.extensions.impl;

import com.google.android.gms.maps.model.CameraPosition;
import java.util.List;
import p005pl.mg6.android.maps.extensions.Marker;

/* renamed from: pl.mg6.android.maps.extensions.impl.ClusteringStrategy */
interface ClusteringStrategy {
    void cleanup();

    List<Marker> getDisplayedMarkers();

    float getMinZoomLevelNotClustered(Marker marker);

    Marker map(com.google.android.gms.maps.model.Marker marker);

    void onAdd(DelegatingMarker delegatingMarker);

    void onCameraChange(CameraPosition cameraPosition);

    void onPositionChange(DelegatingMarker delegatingMarker);

    void onRemove(DelegatingMarker delegatingMarker);

    void onVisibilityChangeRequest(DelegatingMarker delegatingMarker, boolean z);
}
