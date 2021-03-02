package p005pl.mg6.android.maps.extensions.impl;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;
import p005pl.mg6.android.maps.extensions.Polygon;

/* renamed from: pl.mg6.android.maps.extensions.impl.DelegatingPolygon */
class DelegatingPolygon implements Polygon {
    private Object data;
    private DelegatingGoogleMap map;
    private com.google.android.gms.maps.model.Polygon real;

    DelegatingPolygon(com.google.android.gms.maps.model.Polygon real2, DelegatingGoogleMap map2) {
        this.real = real2;
        this.map = map2;
    }

    public Object getData() {
        return this.data;
    }

    public int getFillColor() {
        return this.real.getFillColor();
    }

    public List<List<LatLng>> getHoles() {
        return this.real.getHoles();
    }

    @Deprecated
    public String getId() {
        return this.real.getId();
    }

    public List<LatLng> getPoints() {
        return this.real.getPoints();
    }

    public int getStrokeColor() {
        return this.real.getStrokeColor();
    }

    public float getStrokeWidth() {
        return this.real.getStrokeWidth();
    }

    public float getZIndex() {
        return this.real.getZIndex();
    }

    public boolean isGeodesic() {
        return this.real.isGeodesic();
    }

    public boolean isVisible() {
        return this.real.isVisible();
    }

    public void remove() {
        this.real.remove();
        this.map.remove(this.real);
    }

    public void setData(Object data2) {
        this.data = data2;
    }

    public void setFillColor(int fillColor) {
        this.real.setFillColor(fillColor);
    }

    public void setGeodesic(boolean geodesic) {
        this.real.setGeodesic(geodesic);
    }

    public void setHoles(List<? extends List<LatLng>> holes) {
        this.real.setHoles(holes);
    }

    public void setPoints(List<LatLng> points) {
        this.real.setPoints(points);
    }

    public void setStrokeColor(int strokeColor) {
        this.real.setStrokeColor(strokeColor);
    }

    public void setStrokeWidth(float strokeWidth) {
        this.real.setStrokeWidth(strokeWidth);
    }

    public void setVisible(boolean visible) {
        this.real.setVisible(visible);
    }

    public void setZIndex(float zIndex) {
        this.real.setZIndex(zIndex);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DelegatingPolygon)) {
            return false;
        }
        return this.real.equals(((DelegatingPolygon) o).real);
    }

    public int hashCode() {
        return this.real.hashCode();
    }

    public String toString() {
        return this.real.toString();
    }
}
