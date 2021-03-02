package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.maps.model.e */
public class C0715e {
    /* renamed from: a */
    static void m2070a(LatLng latLng, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, latLng.mo5987i());
        C0359b.m665a(parcel, 2, latLng.latitude);
        C0359b.m665a(parcel, 3, latLng.longitude);
        C0359b.m663C(parcel, d);
    }
}
