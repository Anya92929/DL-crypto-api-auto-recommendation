package p005pl.mg6.android.maps.extensions.impl;

import android.location.Location;
import com.google.android.gms.maps.model.LatLng;
import p005pl.mg6.android.maps.extensions.Circle;

/* renamed from: pl.mg6.android.maps.extensions.impl.DelegatingCircle */
class DelegatingCircle implements Circle {
    private Object data;
    private DelegatingGoogleMap map;
    private com.google.android.gms.maps.model.Circle real;

    DelegatingCircle(com.google.android.gms.maps.model.Circle real2, DelegatingGoogleMap map2) {
        this.real = real2;
        this.map = map2;
    }

    public boolean contains(LatLng position) {
        LatLng center = getCenter();
        double radius = getRadius();
        float[] distance = new float[1];
        Location.distanceBetween(position.latitude, position.longitude, center.latitude, center.longitude, distance);
        return ((double) distance[0]) < radius;
    }

    public LatLng getCenter() {
        return this.real.getCenter();
    }

    public Object getData() {
        return this.data;
    }

    public int getFillColor() {
        return this.real.getFillColor();
    }

    @Deprecated
    public String getId() {
        return this.real.getId();
    }

    public double getRadius() {
        return this.real.getRadius();
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

    public boolean isVisible() {
        return this.real.isVisible();
    }

    public void remove() {
        this.real.remove();
        this.map.remove(this.real);
    }

    public void setCenter(LatLng center) {
        this.real.setCenter(center);
    }

    public void setData(Object data2) {
        this.data = data2;
    }

    public void setFillColor(int fillColor) {
        this.real.setFillColor(fillColor);
    }

    public void setRadius(double radius) {
        this.real.setRadius(radius);
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
        if (!(o instanceof DelegatingCircle)) {
            return false;
        }
        return this.real.equals(((DelegatingCircle) o).real);
    }

    public int hashCode() {
        return this.real.hashCode();
    }

    public String toString() {
        return this.real.toString();
    }
}
