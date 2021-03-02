package com.google.maps.android.kml;

import java.util.ArrayList;

public class KmlMultiGeometry implements KmlGeometry<ArrayList<KmlGeometry>> {

    /* renamed from: a */
    private ArrayList<KmlGeometry> f4006a = new ArrayList<>();

    public KmlMultiGeometry(ArrayList<KmlGeometry> arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("Geometries cannot be null");
        }
        this.f4006a = arrayList;
    }

    public String getGeometryType() {
        return "MultiGeometry";
    }

    public ArrayList<KmlGeometry> getGeometryObject() {
        return this.f4006a;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("MultiGeometry").append("{");
        append.append("\n geometries=").append(this.f4006a);
        append.append("\n}\n");
        return append.toString();
    }
}
