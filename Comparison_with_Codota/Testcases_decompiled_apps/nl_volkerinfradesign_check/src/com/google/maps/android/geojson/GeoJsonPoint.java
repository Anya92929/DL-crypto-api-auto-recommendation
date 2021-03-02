package com.google.maps.android.geojson;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.kml.KmlPoint;

public class GeoJsonPoint implements GeoJsonGeometry {

    /* renamed from: a */
    private final LatLng f3963a;

    public GeoJsonPoint(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("Coordinate cannot be null");
        }
        this.f3963a = latLng;
    }

    public String getType() {
        return KmlPoint.GEOMETRY_TYPE;
    }

    public LatLng getCoordinates() {
        return this.f3963a;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(KmlPoint.GEOMETRY_TYPE).append("{");
        append.append("\n coordinates=").append(this.f3963a);
        append.append("\n}\n");
        return append.toString();
    }
}
