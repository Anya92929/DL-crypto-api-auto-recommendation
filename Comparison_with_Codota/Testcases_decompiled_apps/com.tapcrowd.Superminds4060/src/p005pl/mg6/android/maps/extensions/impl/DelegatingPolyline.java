package p005pl.mg6.android.maps.extensions.impl;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;
import p005pl.mg6.android.maps.extensions.Polyline;

/* renamed from: pl.mg6.android.maps.extensions.impl.DelegatingPolyline */
class DelegatingPolyline implements Polyline {
    private Object data;
    private DelegatingGoogleMap map;
    private com.google.android.gms.maps.model.Polyline real;

    DelegatingPolyline(com.google.android.gms.maps.model.Polyline real2, DelegatingGoogleMap map2) {
        this.real = real2;
        this.map = map2;
    }

    public int getColor() {
        return this.real.getColor();
    }

    public Object getData() {
        return this.data;
    }

    @Deprecated
    public String getId() {
        return this.real.getId();
    }

    public List<LatLng> getPoints() {
        return this.real.getPoints();
    }

    public float getWidth() {
        return this.real.getWidth();
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

    public void setColor(int color) {
        this.real.setColor(color);
    }

    public void setData(Object data2) {
        this.data = data2;
    }

    public void setGeodesic(boolean geodesic) {
        this.real.setGeodesic(geodesic);
    }

    public void setPoints(List<LatLng> points) {
        this.real.setPoints(points);
    }

    public void setVisible(boolean visible) {
        this.real.setVisible(visible);
    }

    public void setWidth(float width) {
        this.real.setWidth(width);
    }

    public void setZIndex(float zIndex) {
        this.real.setZIndex(zIndex);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DelegatingPolyline)) {
            return false;
        }
        return this.real.equals(((DelegatingPolyline) o).real);
    }

    public int hashCode() {
        return this.real.hashCode();
    }

    public String toString() {
        return this.real.toString();
    }
}
