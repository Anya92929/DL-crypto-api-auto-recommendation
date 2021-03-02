package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C1873b {
    /* renamed from: a */
    static void m6417a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, cameraPosition.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) cameraPosition.target, i, false);
        C0354b.m918a(parcel, 3, cameraPosition.zoom);
        C0354b.m918a(parcel, 4, cameraPosition.tilt);
        C0354b.m918a(parcel, 5, cameraPosition.bearing);
        C0354b.m915H(parcel, D);
    }
}
