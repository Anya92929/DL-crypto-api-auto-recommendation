package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.z */
public class C1926z {
    /* renamed from: a */
    static void m6513a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, visibleRegion.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) visibleRegion.nearLeft, i, false);
        C0354b.m923a(parcel, 3, (Parcelable) visibleRegion.nearRight, i, false);
        C0354b.m923a(parcel, 4, (Parcelable) visibleRegion.farLeft, i, false);
        C0354b.m923a(parcel, 5, (Parcelable) visibleRegion.farRight, i, false);
        C0354b.m923a(parcel, 6, (Parcelable) visibleRegion.latLngBounds, i, false);
        C0354b.m915H(parcel, D);
    }
}
