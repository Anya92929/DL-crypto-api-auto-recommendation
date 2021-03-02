package p005pl.mg6.android.maps.extensions;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* renamed from: pl.mg6.android.maps.extensions.GroundOverlay */
public interface GroundOverlay {
    float getBearing();

    LatLngBounds getBounds();

    Object getData();

    float getHeight();

    @Deprecated
    String getId();

    LatLng getPosition();

    float getTransparency();

    float getWidth();

    float getZIndex();

    boolean isVisible();

    void remove();

    void setBearing(float f);

    void setData(Object obj);

    void setDimensions(float f);

    void setDimensions(float f, float f2);

    void setPosition(LatLng latLng);

    void setPositionFromBounds(LatLngBounds latLngBounds);

    void setTransparency(float f);

    void setVisible(boolean z);

    void setZIndex(float f);
}
