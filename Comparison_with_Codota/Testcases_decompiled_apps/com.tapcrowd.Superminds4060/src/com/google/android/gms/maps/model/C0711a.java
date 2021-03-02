package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.maps.model.a */
public class C0711a {
    /* renamed from: a */
    static void m2104a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, cameraPosition.getVersionCode());
        C0155b.m348a(parcel, 2, (Parcelable) cameraPosition.target, i, false);
        C0155b.m343a(parcel, 3, cameraPosition.zoom);
        C0155b.m343a(parcel, 4, cameraPosition.tilt);
        C0155b.m343a(parcel, 5, cameraPosition.bearing);
        C0155b.m340C(parcel, k);
    }
}
