package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.maps.model.e */
public class C0715e {
    /* renamed from: a */
    static void m2108a(LatLng latLng, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, latLng.getVersionCode());
        C0155b.m342a(parcel, 2, latLng.latitude);
        C0155b.m342a(parcel, 3, latLng.longitude);
        C0155b.m340C(parcel, k);
    }
}
