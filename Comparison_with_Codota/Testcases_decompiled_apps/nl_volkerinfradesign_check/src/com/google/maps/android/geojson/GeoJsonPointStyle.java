package com.google.maps.android.geojson;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.kml.KmlPoint;
import java.util.Arrays;
import java.util.Observable;

public class GeoJsonPointStyle extends Observable implements C1213hp {

    /* renamed from: a */
    private static final String[] f3964a = {KmlPoint.GEOMETRY_TYPE, "MultiPoint", "GeometryCollection"};

    /* renamed from: b */
    private final MarkerOptions f3965b = new MarkerOptions();

    public String[] getGeometryType() {
        return f3964a;
    }

    public float getAlpha() {
        return this.f3965b.getAlpha();
    }

    public void setAlpha(float f) {
        this.f3965b.alpha(f);
        m4529a();
    }

    public float getAnchorU() {
        return this.f3965b.getAnchorU();
    }

    public float getAnchorV() {
        return this.f3965b.getAnchorV();
    }

    public void setAnchor(float f, float f2) {
        this.f3965b.anchor(f, f2);
        m4529a();
    }

    public boolean isDraggable() {
        return this.f3965b.isDraggable();
    }

    public void setDraggable(boolean z) {
        this.f3965b.draggable(z);
        m4529a();
    }

    public boolean isFlat() {
        return this.f3965b.isFlat();
    }

    public void setFlat(boolean z) {
        this.f3965b.flat(z);
        m4529a();
    }

    public BitmapDescriptor getIcon() {
        return this.f3965b.getIcon();
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        this.f3965b.icon(bitmapDescriptor);
        m4529a();
    }

    public float getInfoWindowAnchorU() {
        return this.f3965b.getInfoWindowAnchorU();
    }

    public float getInfoWindowAnchorV() {
        return this.f3965b.getInfoWindowAnchorV();
    }

    public void setInfoWindowAnchor(float f, float f2) {
        this.f3965b.infoWindowAnchor(f, f2);
        m4529a();
    }

    public float getRotation() {
        return this.f3965b.getRotation();
    }

    public void setRotation(float f) {
        this.f3965b.rotation(f);
        m4529a();
    }

    public String getSnippet() {
        return this.f3965b.getSnippet();
    }

    public void setSnippet(String str) {
        this.f3965b.snippet(str);
        m4529a();
    }

    public String getTitle() {
        return this.f3965b.getTitle();
    }

    public void setTitle(String str) {
        this.f3965b.title(str);
        m4529a();
    }

    public boolean isVisible() {
        return this.f3965b.isVisible();
    }

    public void setVisible(boolean z) {
        this.f3965b.visible(z);
        m4529a();
    }

    /* renamed from: a */
    private void m4529a() {
        setChanged();
        notifyObservers();
    }

    public MarkerOptions toMarkerOptions() {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.alpha(this.f3965b.getAlpha());
        markerOptions.anchor(this.f3965b.getAnchorU(), this.f3965b.getAnchorV());
        markerOptions.draggable(this.f3965b.isDraggable());
        markerOptions.flat(this.f3965b.isFlat());
        markerOptions.icon(this.f3965b.getIcon());
        markerOptions.infoWindowAnchor(this.f3965b.getInfoWindowAnchorU(), this.f3965b.getInfoWindowAnchorV());
        markerOptions.rotation(this.f3965b.getRotation());
        markerOptions.snippet(this.f3965b.getSnippet());
        markerOptions.title(this.f3965b.getTitle());
        markerOptions.visible(this.f3965b.isVisible());
        return markerOptions;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PointStyle{");
        sb.append("\n geometry type=").append(Arrays.toString(f3964a));
        sb.append(",\n alpha=").append(getAlpha());
        sb.append(",\n anchor U=").append(getAnchorU());
        sb.append(",\n anchor V=").append(getAnchorV());
        sb.append(",\n draggable=").append(isDraggable());
        sb.append(",\n flat=").append(isFlat());
        sb.append(",\n info window anchor U=").append(getInfoWindowAnchorU());
        sb.append(",\n info window anchor V=").append(getInfoWindowAnchorV());
        sb.append(",\n rotation=").append(getRotation());
        sb.append(",\n snippet=").append(getSnippet());
        sb.append(",\n title=").append(getTitle());
        sb.append(",\n visible=").append(isVisible());
        sb.append("\n}\n");
        return sb.toString();
    }
}
