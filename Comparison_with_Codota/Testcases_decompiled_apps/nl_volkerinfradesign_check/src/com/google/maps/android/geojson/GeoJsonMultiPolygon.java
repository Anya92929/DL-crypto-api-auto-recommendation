package com.google.maps.android.geojson;

import java.util.List;

public class GeoJsonMultiPolygon implements GeoJsonGeometry {

    /* renamed from: a */
    private final List<GeoJsonPolygon> f3962a;

    public GeoJsonMultiPolygon(List<GeoJsonPolygon> list) {
        if (list == null) {
            throw new IllegalArgumentException("GeoJsonPolygons cannot be null");
        }
        this.f3962a = list;
    }

    public String getType() {
        return "MultiPolygon";
    }

    public List<GeoJsonPolygon> getPolygons() {
        return this.f3962a;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("MultiPolygon").append("{");
        append.append("\n Polygons=").append(this.f3962a);
        append.append("\n}\n");
        return append.toString();
    }
}
