package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.maps.model.g */
public class C0717g {
    /* renamed from: a */
    static void m2110a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, polygonOptions.getVersionCode());
        C0155b.m358b(parcel, 2, polygonOptions.getPoints(), false);
        C0155b.m360c(parcel, 3, polygonOptions.mo5919cO(), false);
        C0155b.m343a(parcel, 4, polygonOptions.getStrokeWidth());
        C0155b.m359c(parcel, 5, polygonOptions.getStrokeColor());
        C0155b.m359c(parcel, 6, polygonOptions.getFillColor());
        C0155b.m343a(parcel, 7, polygonOptions.getZIndex());
        C0155b.m352a(parcel, 8, polygonOptions.isVisible());
        C0155b.m352a(parcel, 9, polygonOptions.isGeodesic());
        C0155b.m340C(parcel, k);
    }
}
