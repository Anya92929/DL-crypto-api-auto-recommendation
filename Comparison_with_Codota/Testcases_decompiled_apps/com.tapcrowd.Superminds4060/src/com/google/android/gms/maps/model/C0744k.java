package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.maps.model.k */
public class C0744k {
    /* renamed from: a */
    static void m2152a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, visibleRegion.getVersionCode());
        C0155b.m348a(parcel, 2, (Parcelable) visibleRegion.nearLeft, i, false);
        C0155b.m348a(parcel, 3, (Parcelable) visibleRegion.nearRight, i, false);
        C0155b.m348a(parcel, 4, (Parcelable) visibleRegion.farLeft, i, false);
        C0155b.m348a(parcel, 5, (Parcelable) visibleRegion.farRight, i, false);
        C0155b.m348a(parcel, 6, (Parcelable) visibleRegion.latLngBounds, i, false);
        C0155b.m340C(parcel, k);
    }
}
