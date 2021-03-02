package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C1910j {
    /* renamed from: a */
    static void m6477a(LatLng latLng, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, latLng.getVersionCode());
        C0354b.m917a(parcel, 2, latLng.latitude);
        C0354b.m917a(parcel, 3, latLng.longitude);
        C0354b.m915H(parcel, D);
    }
}
