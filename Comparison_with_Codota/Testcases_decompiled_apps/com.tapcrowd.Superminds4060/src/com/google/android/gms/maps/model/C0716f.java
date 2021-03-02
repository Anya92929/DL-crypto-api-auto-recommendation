package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C0716f {
    /* renamed from: a */
    static void m2109a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, markerOptions.getVersionCode());
        C0155b.m348a(parcel, 2, (Parcelable) markerOptions.getPosition(), i, false);
        C0155b.m349a(parcel, 3, markerOptions.getTitle(), false);
        C0155b.m349a(parcel, 4, markerOptions.getSnippet(), false);
        C0155b.m346a(parcel, 5, markerOptions.mo5867cN(), false);
        C0155b.m343a(parcel, 6, markerOptions.getAnchorU());
        C0155b.m343a(parcel, 7, markerOptions.getAnchorV());
        C0155b.m352a(parcel, 8, markerOptions.isDraggable());
        C0155b.m352a(parcel, 9, markerOptions.isVisible());
        C0155b.m340C(parcel, k);
    }
}
