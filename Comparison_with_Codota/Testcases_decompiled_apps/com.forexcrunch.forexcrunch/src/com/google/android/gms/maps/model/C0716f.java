package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C0716f {
    /* renamed from: a */
    static void m2071a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, markerOptions.mo6043i());
        C0359b.m671a(parcel, 2, (Parcelable) markerOptions.getPosition(), i, false);
        C0359b.m672a(parcel, 3, markerOptions.getTitle(), false);
        C0359b.m672a(parcel, 4, markerOptions.getSnippet(), false);
        C0359b.m669a(parcel, 5, markerOptions.mo6030bq(), false);
        C0359b.m666a(parcel, 6, markerOptions.getAnchorU());
        C0359b.m666a(parcel, 7, markerOptions.getAnchorV());
        C0359b.m675a(parcel, 8, markerOptions.isDraggable());
        C0359b.m675a(parcel, 9, markerOptions.isVisible());
        C0359b.m663C(parcel, d);
    }
}
