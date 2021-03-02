package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.p */
public class C1916p {
    /* renamed from: a */
    static void m6489a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, polylineOptions.getVersionCode());
        C0354b.m940c(parcel, 2, polylineOptions.getPoints(), false);
        C0354b.m918a(parcel, 3, polylineOptions.getWidth());
        C0354b.m939c(parcel, 4, polylineOptions.getColor());
        C0354b.m918a(parcel, 5, polylineOptions.getZIndex());
        C0354b.m930a(parcel, 6, polylineOptions.isVisible());
        C0354b.m930a(parcel, 7, polylineOptions.isGeodesic());
        C0354b.m915H(parcel, D);
    }
}
