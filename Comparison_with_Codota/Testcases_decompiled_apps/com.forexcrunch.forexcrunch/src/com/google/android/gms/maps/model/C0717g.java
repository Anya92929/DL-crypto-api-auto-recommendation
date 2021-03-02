package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.maps.model.g */
public class C0717g {
    /* renamed from: a */
    static void m2072a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, polygonOptions.mo6091i());
        C0359b.m681b(parcel, 2, polygonOptions.getPoints(), false);
        C0359b.m683c(parcel, 3, polygonOptions.mo6081br(), false);
        C0359b.m666a(parcel, 4, polygonOptions.getStrokeWidth());
        C0359b.m682c(parcel, 5, polygonOptions.getStrokeColor());
        C0359b.m682c(parcel, 6, polygonOptions.getFillColor());
        C0359b.m666a(parcel, 7, polygonOptions.getZIndex());
        C0359b.m675a(parcel, 8, polygonOptions.isVisible());
        C0359b.m675a(parcel, 9, polygonOptions.isGeodesic());
        C0359b.m663C(parcel, d);
    }
}
