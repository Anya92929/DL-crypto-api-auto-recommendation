package p005pl.mg6.android.maps.extensions;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/* renamed from: pl.mg6.android.maps.extensions.Polyline */
public interface Polyline {
    int getColor();

    Object getData();

    @Deprecated
    String getId();

    List<LatLng> getPoints();

    float getWidth();

    float getZIndex();

    boolean isGeodesic();

    boolean isVisible();

    void remove();

    void setColor(int i);

    void setData(Object obj);

    void setGeodesic(boolean z);

    void setPoints(List<LatLng> list);

    void setVisible(boolean z);

    void setWidth(float f);

    void setZIndex(float f);
}
