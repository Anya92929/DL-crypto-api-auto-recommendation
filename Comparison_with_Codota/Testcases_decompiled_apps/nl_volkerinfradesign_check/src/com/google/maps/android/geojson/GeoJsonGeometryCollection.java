package com.google.maps.android.geojson;

import java.util.List;

public class GeoJsonGeometryCollection implements GeoJsonGeometry {

    /* renamed from: a */
    private final List<GeoJsonGeometry> f3954a;

    public GeoJsonGeometryCollection(List<GeoJsonGeometry> list) {
        if (list == null) {
            throw new IllegalArgumentException("Geometries cannot be null");
        }
        this.f3954a = list;
    }

    public String getType() {
        return "GeometryCollection";
    }

    public List<GeoJsonGeometry> getGeometries() {
        return this.f3954a;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("GeometryCollection").append("{");
        append.append("\n Geometries=").append(this.f3954a);
        append.append("\n}\n");
        return append.toString();
    }
}
