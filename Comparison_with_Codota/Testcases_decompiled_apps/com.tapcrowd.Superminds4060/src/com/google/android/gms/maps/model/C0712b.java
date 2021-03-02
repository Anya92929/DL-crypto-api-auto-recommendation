package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C0712b {
    /* renamed from: a */
    static void m2105a(CircleOptions circleOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, circleOptions.getVersionCode());
        C0155b.m348a(parcel, 2, (Parcelable) circleOptions.getCenter(), i, false);
        C0155b.m342a(parcel, 3, circleOptions.getRadius());
        C0155b.m343a(parcel, 4, circleOptions.getStrokeWidth());
        C0155b.m359c(parcel, 5, circleOptions.getStrokeColor());
        C0155b.m359c(parcel, 6, circleOptions.getFillColor());
        C0155b.m343a(parcel, 7, circleOptions.getZIndex());
        C0155b.m352a(parcel, 8, circleOptions.isVisible());
        C0155b.m340C(parcel, k);
    }
}
