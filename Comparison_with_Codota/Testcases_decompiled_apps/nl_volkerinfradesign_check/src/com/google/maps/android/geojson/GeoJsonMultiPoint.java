package com.google.maps.android.geojson;

import java.util.List;

public class GeoJsonMultiPoint implements GeoJsonGeometry {

    /* renamed from: a */
    private final List<GeoJsonPoint> f3961a;

    public GeoJsonMultiPoint(List<GeoJsonPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException("GeoJsonPoints cannot be null");
        }
        this.f3961a = list;
    }

    public String getType() {
        return "MultiPoint";
    }

    public List<GeoJsonPoint> getPoints() {
        return this.f3961a;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("MultiPoint").append("{");
        append.append("\n points=").append(this.f3961a);
        append.append("\n}\n");
        return append.toString();
    }
}
