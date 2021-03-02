package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.l */
public class C1912l {
    /* renamed from: a */
    static void m6481a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, markerOptions.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) markerOptions.getPosition(), i, false);
        C0354b.m927a(parcel, 3, markerOptions.getTitle(), false);
        C0354b.m927a(parcel, 4, markerOptions.getSnippet(), false);
        C0354b.m921a(parcel, 5, markerOptions.mo10888mN(), false);
        C0354b.m918a(parcel, 6, markerOptions.getAnchorU());
        C0354b.m918a(parcel, 7, markerOptions.getAnchorV());
        C0354b.m930a(parcel, 8, markerOptions.isDraggable());
        C0354b.m930a(parcel, 9, markerOptions.isVisible());
        C0354b.m915H(parcel, D);
    }
}
