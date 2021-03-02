package p005pl.mg6.android.maps.extensions;

import com.google.android.gms.maps.model.LatLng;

/* renamed from: pl.mg6.android.maps.extensions.Circle */
public interface Circle {
    boolean contains(LatLng latLng);

    LatLng getCenter();

    Object getData();

    int getFillColor();

    @Deprecated
    String getId();

    double getRadius();

    int getStrokeColor();

    float getStrokeWidth();

    float getZIndex();

    boolean isVisible();

    void remove();

    void setCenter(LatLng latLng);

    void setData(Object obj);

    void setFillColor(int i);

    void setRadius(double d);

    void setStrokeColor(int i);

    void setStrokeWidth(float f);

    void setVisible(boolean z);

    void setZIndex(float f);
}
