package com.google.maps.android.geojson;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.kml.KmlLineString;
import java.util.List;

public class GeoJsonLineString implements GeoJsonGeometry {

    /* renamed from: a */
    private final List<LatLng> f3957a;

    public GeoJsonLineString(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("Coordinates cannot be null");
        }
        this.f3957a = list;
    }

    public String getType() {
        return KmlLineString.GEOMETRY_TYPE;
    }

    public List<LatLng> getCoordinates() {
        return this.f3957a;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(KmlLineString.GEOMETRY_TYPE).append("{");
        append.append("\n coordinates=").append(this.f3957a);
        append.append("\n}\n");
        return append.toString();
    }
}
