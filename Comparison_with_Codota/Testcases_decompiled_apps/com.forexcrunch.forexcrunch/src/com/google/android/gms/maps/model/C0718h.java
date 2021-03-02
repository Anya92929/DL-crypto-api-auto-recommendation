package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C0718h {
    /* renamed from: a */
    static void m2073a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, polylineOptions.mo6127i());
        C0359b.m681b(parcel, 2, polylineOptions.getPoints(), false);
        C0359b.m666a(parcel, 3, polylineOptions.getWidth());
        C0359b.m682c(parcel, 4, polylineOptions.getColor());
        C0359b.m666a(parcel, 5, polylineOptions.getZIndex());
        C0359b.m675a(parcel, 6, polylineOptions.isVisible());
        C0359b.m675a(parcel, 7, polylineOptions.isGeodesic());
        C0359b.m663C(parcel, d);
    }
}
