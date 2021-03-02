package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C0718h {
    /* renamed from: a */
    static void m2111a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, polylineOptions.getVersionCode());
        C0155b.m358b(parcel, 2, polylineOptions.getPoints(), false);
        C0155b.m343a(parcel, 3, polylineOptions.getWidth());
        C0155b.m359c(parcel, 4, polylineOptions.getColor());
        C0155b.m343a(parcel, 5, polylineOptions.getZIndex());
        C0155b.m352a(parcel, 6, polylineOptions.isVisible());
        C0155b.m352a(parcel, 7, polylineOptions.isGeodesic());
        C0155b.m340C(parcel, k);
    }
}
