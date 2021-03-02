package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C0712b {
    /* renamed from: a */
    static void m2067a(CircleOptions circleOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, circleOptions.mo5928i());
        C0359b.m671a(parcel, 2, (Parcelable) circleOptions.getCenter(), i, false);
        C0359b.m665a(parcel, 3, circleOptions.getRadius());
        C0359b.m666a(parcel, 4, circleOptions.getStrokeWidth());
        C0359b.m682c(parcel, 5, circleOptions.getStrokeColor());
        C0359b.m682c(parcel, 6, circleOptions.getFillColor());
        C0359b.m666a(parcel, 7, circleOptions.getZIndex());
        C0359b.m675a(parcel, 8, circleOptions.isVisible());
        C0359b.m663C(parcel, d);
    }
}
