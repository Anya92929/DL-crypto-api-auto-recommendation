package p005pl.mg6.android.maps.extensions;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/* renamed from: pl.mg6.android.maps.extensions.Marker */
public interface Marker {
    Object getData();

    @Deprecated
    String getId();

    List<Marker> getMarkers();

    LatLng getPosition();

    String getSnippet();

    String getTitle();

    void hideInfoWindow();

    boolean isCluster();

    boolean isDraggable();

    boolean isInfoWindowShown();

    boolean isVisible();

    void remove();

    void setData(Object obj);

    void setDraggable(boolean z);

    void setPosition(LatLng latLng);

    void setSnippet(String str);

    void setTitle(String str);

    void setVisible(boolean z);

    void showInfoWindow();
}
