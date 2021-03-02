package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C1875d {
    /* renamed from: a */
    static void m6421a(CircleOptions circleOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, circleOptions.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) circleOptions.getCenter(), i, false);
        C0354b.m917a(parcel, 3, circleOptions.getRadius());
        C0354b.m918a(parcel, 4, circleOptions.getStrokeWidth());
        C0354b.m939c(parcel, 5, circleOptions.getStrokeColor());
        C0354b.m939c(parcel, 6, circleOptions.getFillColor());
        C0354b.m918a(parcel, 7, circleOptions.getZIndex());
        C0354b.m930a(parcel, 8, circleOptions.isVisible());
        C0354b.m915H(parcel, D);
    }
}
