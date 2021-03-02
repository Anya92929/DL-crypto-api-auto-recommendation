package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.maps.model.k */
public class C0744k {
    /* renamed from: a */
    static void m2112a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, visibleRegion.mo6168i());
        C0359b.m671a(parcel, 2, (Parcelable) visibleRegion.nearLeft, i, false);
        C0359b.m671a(parcel, 3, (Parcelable) visibleRegion.nearRight, i, false);
        C0359b.m671a(parcel, 4, (Parcelable) visibleRegion.farLeft, i, false);
        C0359b.m671a(parcel, 5, (Parcelable) visibleRegion.farRight, i, false);
        C0359b.m671a(parcel, 6, (Parcelable) visibleRegion.latLngBounds, i, false);
        C0359b.m663C(parcel, d);
    }
}
