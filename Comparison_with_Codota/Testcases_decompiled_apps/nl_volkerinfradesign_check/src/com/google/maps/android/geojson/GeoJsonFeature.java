package com.google.maps.android.geojson;

import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class GeoJsonFeature extends Observable implements Observer {

    /* renamed from: a */
    private final String f3947a;

    /* renamed from: b */
    private final LatLngBounds f3948b;

    /* renamed from: c */
    private final HashMap<String, String> f3949c;

    /* renamed from: d */
    private GeoJsonGeometry f3950d;

    /* renamed from: e */
    private GeoJsonPointStyle f3951e;

    /* renamed from: f */
    private GeoJsonLineStringStyle f3952f;

    /* renamed from: g */
    private GeoJsonPolygonStyle f3953g;

    public GeoJsonFeature(GeoJsonGeometry geoJsonGeometry, String str, HashMap<String, String> hashMap, LatLngBounds latLngBounds) {
        this.f3950d = geoJsonGeometry;
        this.f3947a = str;
        this.f3948b = latLngBounds;
        if (hashMap == null) {
            this.f3949c = new HashMap<>();
        } else {
            this.f3949c = hashMap;
        }
    }

    public Iterable<String> getPropertyKeys() {
        return this.f3949c.keySet();
    }

    public String getProperty(String str) {
        return this.f3949c.get(str);
    }

    public String setProperty(String str, String str2) {
        return this.f3949c.put(str, str2);
    }

    public boolean hasProperty(String str) {
        return this.f3949c.containsKey(str);
    }

    public String removeProperty(String str) {
        return this.f3949c.remove(str);
    }

    public GeoJsonPointStyle getPointStyle() {
        return this.f3951e;
    }

    public void setPointStyle(GeoJsonPointStyle geoJsonPointStyle) {
        if (geoJsonPointStyle == null) {
            throw new IllegalArgumentException("Point style cannot be null");
        }
        if (this.f3951e != null) {
            this.f3951e.deleteObserver(this);
        }
        this.f3951e = geoJsonPointStyle;
        this.f3951e.addObserver(this);
        m4526a(this.f3951e);
    }

    public GeoJsonLineStringStyle getLineStringStyle() {
        return this.f3952f;
    }

    public void setLineStringStyle(GeoJsonLineStringStyle geoJsonLineStringStyle) {
        if (geoJsonLineStringStyle == null) {
            throw new IllegalArgumentException("Line string style cannot be null");
        }
        if (this.f3952f != null) {
            this.f3952f.deleteObserver(this);
        }
        this.f3952f = geoJsonLineStringStyle;
        this.f3952f.addObserver(this);
        m4526a(this.f3952f);
    }

    public GeoJsonPolygonStyle getPolygonStyle() {
        return this.f3953g;
    }

    public void setPolygonStyle(GeoJsonPolygonStyle geoJsonPolygonStyle) {
        if (geoJsonPolygonStyle == null) {
            throw new IllegalArgumentException("Polygon style cannot be null");
        }
        if (this.f3953g != null) {
            this.f3953g.deleteObserver(this);
        }
        this.f3953g = geoJsonPolygonStyle;
        this.f3953g.addObserver(this);
        m4526a(this.f3953g);
    }

    /* renamed from: a */
    private void m4526a(C1213hp hpVar) {
        if (this.f3950d != null && Arrays.asList(hpVar.getGeometryType()).contains(this.f3950d.getType())) {
            setChanged();
            notifyObservers();
        }
    }

    public GeoJsonGeometry getGeometry() {
        return this.f3950d;
    }

    public void setGeometry(GeoJsonGeometry geoJsonGeometry) {
        this.f3950d = geoJsonGeometry;
        setChanged();
        notifyObservers();
    }

    public String getId() {
        return this.f3947a;
    }

    public boolean hasGeometry() {
        return this.f3950d != null;
    }

    public LatLngBounds getBoundingBox() {
        return this.f3948b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Feature{");
        sb.append("\n bounding box=").append(this.f3948b);
        sb.append(",\n geometry=").append(this.f3950d);
        sb.append(",\n point style=").append(this.f3951e);
        sb.append(",\n line string style=").append(this.f3952f);
        sb.append(",\n polygon style=").append(this.f3953g);
        sb.append(",\n id=").append(this.f3947a);
        sb.append(",\n properties=").append(this.f3949c);
        sb.append("\n}\n");
        return sb.toString();
    }

    public void update(Observable observable, Object obj) {
        if (observable instanceof C1213hp) {
            m4526a((C1213hp) observable);
        }
    }
}
