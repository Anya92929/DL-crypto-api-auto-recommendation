package com.google.maps.android.geojson;

import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.kml.KmlLineString;
import java.util.Arrays;
import java.util.Observable;

public class GeoJsonLineStringStyle extends Observable implements C1213hp {

    /* renamed from: a */
    private static final String[] f3958a = {KmlLineString.GEOMETRY_TYPE, "MultiLineString", "GeometryCollection"};

    /* renamed from: b */
    private final PolylineOptions f3959b = new PolylineOptions();

    public String[] getGeometryType() {
        return f3958a;
    }

    public int getColor() {
        return this.f3959b.getColor();
    }

    public void setColor(int i) {
        this.f3959b.color(i);
        m4528a();
    }

    public boolean isClickable() {
        return this.f3959b.isClickable();
    }

    public void setClickable(boolean z) {
        this.f3959b.clickable(z);
        m4528a();
    }

    public boolean isGeodesic() {
        return this.f3959b.isGeodesic();
    }

    public void setGeodesic(boolean z) {
        this.f3959b.geodesic(z);
        m4528a();
    }

    public float getWidth() {
        return this.f3959b.getWidth();
    }

    public void setWidth(float f) {
        this.f3959b.width(f);
        m4528a();
    }

    public float getZIndex() {
        return this.f3959b.getZIndex();
    }

    public void setZIndex(float f) {
        this.f3959b.zIndex(f);
        m4528a();
    }

    public boolean isVisible() {
        return this.f3959b.isVisible();
    }

    public void setVisible(boolean z) {
        this.f3959b.visible(z);
        m4528a();
    }

    /* renamed from: a */
    private void m4528a() {
        setChanged();
        notifyObservers();
    }

    public PolylineOptions toPolylineOptions() {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(this.f3959b.getColor());
        polylineOptions.clickable(this.f3959b.isClickable());
        polylineOptions.geodesic(this.f3959b.isGeodesic());
        polylineOptions.visible(this.f3959b.isVisible());
        polylineOptions.width(this.f3959b.getWidth());
        polylineOptions.zIndex(this.f3959b.getZIndex());
        return polylineOptions;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LineStringStyle{");
        sb.append("\n geometry type=").append(Arrays.toString(f3958a));
        sb.append(",\n color=").append(getColor());
        sb.append(",\n clickable=").append(isClickable());
        sb.append(",\n geodesic=").append(isGeodesic());
        sb.append(",\n visible=").append(isVisible());
        sb.append(",\n width=").append(getWidth());
        sb.append(",\n z index=").append(getZIndex());
        sb.append("\n}\n");
        return sb.toString();
    }
}
