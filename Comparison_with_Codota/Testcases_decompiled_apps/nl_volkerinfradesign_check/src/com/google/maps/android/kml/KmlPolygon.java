package com.google.maps.android.kml;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class KmlPolygon implements KmlGeometry<ArrayList<ArrayList<LatLng>>> {
    public static final String GEOMETRY_TYPE = "Polygon";

    /* renamed from: a */
    private final ArrayList<LatLng> f4012a;

    /* renamed from: b */
    private final ArrayList<ArrayList<LatLng>> f4013b;

    public KmlPolygon(ArrayList<LatLng> arrayList, ArrayList<ArrayList<LatLng>> arrayList2) {
        if (arrayList == null) {
            throw new IllegalArgumentException("Outer boundary coordinates cannot be null");
        }
        this.f4012a = arrayList;
        this.f4013b = arrayList2;
    }

    public String getGeometryType() {
        return GEOMETRY_TYPE;
    }

    public ArrayList<LatLng> getOuterBoundaryCoordinates() {
        return this.f4012a;
    }

    public ArrayList<ArrayList<LatLng>> getInnerBoundaryCoordinates() {
        return this.f4013b;
    }

    public ArrayList<ArrayList<LatLng>> getGeometryObject() {
        ArrayList<ArrayList<LatLng>> arrayList = new ArrayList<>();
        arrayList.add(this.f4012a);
        if (this.f4013b != null) {
            arrayList.addAll(this.f4013b);
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder append = new StringBuilder(GEOMETRY_TYPE).append("{");
        append.append("\n outer coordinates=").append(this.f4012a);
        append.append(",\n inner coordinates=").append(this.f4013b);
        append.append("\n}\n");
        return append.toString();
    }
}
