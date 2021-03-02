package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C0714d {
    /* renamed from: a */
    static void m2107a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, latLngBounds.getVersionCode());
        C0155b.m348a(parcel, 2, (Parcelable) latLngBounds.southwest, i, false);
        C0155b.m348a(parcel, 3, (Parcelable) latLngBounds.northeast, i, false);
        C0155b.m340C(parcel, k);
    }
}
