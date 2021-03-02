package p005pl.mg6.android.maps.extensions.impl;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import p005pl.mg6.android.maps.extensions.GroundOverlay;

/* renamed from: pl.mg6.android.maps.extensions.impl.DelegatingGroundOverlay */
class DelegatingGroundOverlay implements GroundOverlay {
    private Object data;
    private DelegatingGoogleMap map;
    private com.google.android.gms.maps.model.GroundOverlay real;

    DelegatingGroundOverlay(com.google.android.gms.maps.model.GroundOverlay real2, DelegatingGoogleMap map2) {
        this.real = real2;
        this.map = map2;
    }

    public float getBearing() {
        return this.real.getBearing();
    }

    public LatLngBounds getBounds() {
        return this.real.getBounds();
    }

    public Object getData() {
        return this.data;
    }

    public float getHeight() {
        return this.real.getHeight();
    }

    @Deprecated
    public String getId() {
        return this.real.getId();
    }

    public LatLng getPosition() {
        return this.real.getPosition();
    }

    public float getTransparency() {
        return this.real.getTransparency();
    }

    public float getWidth() {
        return this.real.getWidth();
    }

    public float getZIndex() {
        return this.real.getZIndex();
    }

    public boolean isVisible() {
        return this.real.isVisible();
    }

    public void remove() {
        this.real.remove();
        this.map.remove(this.real);
    }

    public void setBearing(float bearing) {
        this.real.setBearing(bearing);
    }

    public void setData(Object data2) {
        this.data = data2;
    }

    public void setDimensions(float width, float height) {
        this.real.setDimensions(width, height);
    }

    public void setDimensions(float width) {
        this.real.setDimensions(width);
    }

    public void setPosition(LatLng position) {
        this.real.setPosition(position);
    }

    public void setPositionFromBounds(LatLngBounds bounds) {
        this.real.setPositionFromBounds(bounds);
    }

    public void setTransparency(float transparency) {
        this.real.setTransparency(transparency);
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
        if (!(o instanceof DelegatingGroundOverlay)) {
            return false;
        }
        return this.real.equals(((DelegatingGroundOverlay) o).real);
    }

    public int hashCode() {
        return this.real.hashCode();
    }

    public String toString() {
        return this.real.toString();
    }
}
