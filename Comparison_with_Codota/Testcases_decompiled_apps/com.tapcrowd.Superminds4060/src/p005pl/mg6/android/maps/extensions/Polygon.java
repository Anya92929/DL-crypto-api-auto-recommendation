package p005pl.mg6.android.maps.extensions;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

/* renamed from: pl.mg6.android.maps.extensions.Polygon */
public interface Polygon {
    Object getData();

    int getFillColor();

    List<List<LatLng>> getHoles();

    @Deprecated
    String getId();

    List<LatLng> getPoints();

    int getStrokeColor();

    float getStrokeWidth();

    float getZIndex();

    boolean isGeodesic();

    boolean isVisible();

    void remove();

    void setData(Object obj);

    void setFillColor(int i);

    void setGeodesic(boolean z);

    void setHoles(List<? extends List<LatLng>> list);

    void setPoints(List<LatLng> list);

    void setStrokeColor(int i);

    void setStrokeWidth(float f);

    void setVisible(boolean z);

    void setZIndex(float f);
}
