package com.google.maps.android.geojson;

import com.google.android.gms.maps.model.PolygonOptions;
import com.google.maps.android.kml.KmlPolygon;
import java.util.Arrays;
import java.util.Observable;

public class GeoJsonPolygonStyle extends Observable implements C1213hp {

    /* renamed from: a */
    private static final String[] f3967a = {KmlPolygon.GEOMETRY_TYPE, "MultiPolygon", "GeometryCollection"};

    /* renamed from: b */
    private final PolygonOptions f3968b = new PolygonOptions();

    public String[] getGeometryType() {
        return f3967a;
    }

    public int getFillColor() {
        return this.f3968b.getFillColor();
    }

    public void setFillColor(int i) {
        this.f3968b.fillColor(i);
        m4530a();
    }

    public boolean isGeodesic() {
        return this.f3968b.isGeodesic();
    }

    public void setGeodesic(boolean z) {
        this.f3968b.geodesic(z);
        m4530a();
    }

    public int getStrokeColor() {
        return this.f3968b.getStrokeColor();
    }

    public void setStrokeColor(int i) {
        this.f3968b.strokeColor(i);
        m4530a();
    }

    public float getStrokeWidth() {
        return this.f3968b.getStrokeWidth();
    }

    public void setStrokeWidth(float f) {
        this.f3968b.strokeWidth(f);
        m4530a();
    }

    public float getZIndex() {
        return this.f3968b.getZIndex();
    }

    public void setZIndex(float f) {
        this.f3968b.zIndex(f);
        m4530a();
    }

    public boolean isVisible() {
        return this.f3968b.isVisible();
    }

    public void setVisible(boolean z) {
        this.f3968b.visible(z);
        m4530a();
    }

    /* renamed from: a */
    private void m4530a() {
        setChanged();
        notifyObservers();
    }

    public PolygonOptions toPolygonOptions() {
        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.fillColor(this.f3968b.getFillColor());
        polygonOptions.geodesic(this.f3968b.isGeodesic());
        polygonOptions.strokeColor(this.f3968b.getStrokeColor());
        polygonOptions.strokeWidth(this.f3968b.getStrokeWidth());
        polygonOptions.visible(this.f3968b.isVisible());
        polygonOptions.zIndex(this.f3968b.getZIndex());
        return polygonOptions;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PolygonStyle{");
        sb.append("\n geometry type=").append(Arrays.toString(f3967a));
        sb.append(",\n fill color=").append(getFillColor());
        sb.append(",\n geodesic=").append(isGeodesic());
        sb.append(",\n stroke color=").append(getStrokeColor());
        sb.append(",\n stroke width=").append(getStrokeWidth());
        sb.append(",\n visible=").append(isVisible());
        sb.append(",\n z index=").append(getZIndex());
        sb.append("\n}\n");
        return sb.toString();
    }
}
