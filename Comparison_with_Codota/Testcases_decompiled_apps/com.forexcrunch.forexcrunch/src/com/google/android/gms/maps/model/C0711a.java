package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.maps.model.a */
public class C0711a {
    /* renamed from: a */
    static void m2066a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, cameraPosition.mo5891i());
        C0359b.m671a(parcel, 2, (Parcelable) cameraPosition.target, i, false);
        C0359b.m666a(parcel, 3, cameraPosition.zoom);
        C0359b.m666a(parcel, 4, cameraPosition.tilt);
        C0359b.m666a(parcel, 5, cameraPosition.bearing);
        C0359b.m663C(parcel, d);
    }
}
