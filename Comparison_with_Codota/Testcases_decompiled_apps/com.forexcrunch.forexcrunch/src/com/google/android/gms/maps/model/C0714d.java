package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C0714d {
    /* renamed from: a */
    static void m2069a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, latLngBounds.mo5995i());
        C0359b.m671a(parcel, 2, (Parcelable) latLngBounds.southwest, i, false);
        C0359b.m671a(parcel, 3, (Parcelable) latLngBounds.northeast, i, false);
        C0359b.m663C(parcel, d);
    }
}
