package com.google.maps.android.geojson;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.kml.KmlPolygon;
import java.util.List;

public class GeoJsonPolygon implements GeoJsonGeometry {

    /* renamed from: a */
    private final List<? extends List<LatLng>> f3966a;

    public GeoJsonPolygon(List<? extends List<LatLng>> list) {
        if (list == null) {
            throw new IllegalArgumentException("Coordinates cannot be null");
        }
        this.f3966a = list;
    }

    public String getType() {
        return KmlPolygon.GEOMETRY_TYPE;
    }

    public List<? extends List<LatLng>> getCoordinates() {
        return this.f3966a;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(KmlPolygon.GEOMETRY_TYPE).append("{");
        append.append("\n coordinates=").append(this.f3966a);
        append.append("\n}\n");
        return append.toString();
    }
}
