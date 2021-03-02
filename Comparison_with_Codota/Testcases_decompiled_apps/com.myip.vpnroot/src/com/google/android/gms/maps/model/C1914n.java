package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.n */
public class C1914n {
    /* renamed from: a */
    static void m6485a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, polygonOptions.getVersionCode());
        C0354b.m940c(parcel, 2, polygonOptions.getPoints(), false);
        C0354b.m941d(parcel, 3, polygonOptions.mo10931mO(), false);
        C0354b.m918a(parcel, 4, polygonOptions.getStrokeWidth());
        C0354b.m939c(parcel, 5, polygonOptions.getStrokeColor());
        C0354b.m939c(parcel, 6, polygonOptions.getFillColor());
        C0354b.m918a(parcel, 7, polygonOptions.getZIndex());
        C0354b.m930a(parcel, 8, polygonOptions.isVisible());
        C0354b.m930a(parcel, 9, polygonOptions.isGeodesic());
        C0354b.m915H(parcel, D);
    }
}
