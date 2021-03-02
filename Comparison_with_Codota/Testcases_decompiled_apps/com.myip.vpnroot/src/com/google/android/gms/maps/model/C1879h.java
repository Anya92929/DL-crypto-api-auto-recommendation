package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C1879h {
    /* renamed from: a */
    static void m6429a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, latLngBounds.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) latLngBounds.southwest, i, false);
        C0354b.m923a(parcel, 3, (Parcelable) latLngBounds.northeast, i, false);
        C0354b.m915H(parcel, D);
    }
}
