package com.google.maps.android.kml;

import com.google.android.gms.maps.model.LatLng;

public class KmlPoint implements KmlGeometry<LatLng> {
    public static final String GEOMETRY_TYPE = "Point";

    /* renamed from: a */
    private final LatLng f4011a;

    public KmlPoint(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("Coordinates cannot be null");
        }
        this.f4011a = latLng;
    }

    public String getGeometryType() {
        return GEOMETRY_TYPE;
    }

    public LatLng getGeometryObject() {
        return this.f4011a;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(GEOMETRY_TYPE).append("{");
        append.append("\n coordinates=").append(this.f4011a);
        append.append("\n}\n");
        return append.toString();
    }
}
