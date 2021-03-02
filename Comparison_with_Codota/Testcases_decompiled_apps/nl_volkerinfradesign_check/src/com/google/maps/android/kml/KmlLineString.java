package com.google.maps.android.kml;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class KmlLineString implements KmlGeometry<List<LatLng>> {
    public static final String GEOMETRY_TYPE = "LineString";

    /* renamed from: a */
    final ArrayList<LatLng> f4005a;

    public KmlLineString(ArrayList<LatLng> arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("Coordinates cannot be null");
        }
        this.f4005a = arrayList;
    }

    public String getGeometryType() {
        return GEOMETRY_TYPE;
    }

    public ArrayList<LatLng> getGeometryObject() {
        return this.f4005a;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(GEOMETRY_TYPE).append("{");
        append.append("\n coordinates=").append(this.f4005a);
        append.append("\n}\n");
        return append.toString();
    }
}
