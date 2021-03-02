package com.google.maps.android.geojson;

import java.util.List;

public class GeoJsonMultiLineString implements GeoJsonGeometry {

    /* renamed from: a */
    private final List<GeoJsonLineString> f3960a;

    public GeoJsonMultiLineString(List<GeoJsonLineString> list) {
        if (list == null) {
            throw new IllegalArgumentException("GeoJsonLineStrings cannot be null");
        }
        this.f3960a = list;
    }

    public String getType() {
        return "MultiLineString";
    }

    public List<GeoJsonLineString> getLineStrings() {
        return this.f3960a;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("MultiLineString").append("{");
        append.append("\n LineStrings=").append(this.f3960a);
        append.append("\n}\n");
        return append.toString();
    }
}
