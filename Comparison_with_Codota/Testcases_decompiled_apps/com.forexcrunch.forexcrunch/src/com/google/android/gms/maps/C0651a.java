package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.maps.a */
public class C0651a {
    /* renamed from: a */
    static void m1964a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, googleMapOptions.mo5680i());
        C0359b.m664a(parcel, 2, googleMapOptions.mo5659aZ());
        C0359b.m664a(parcel, 3, googleMapOptions.mo5660ba());
        C0359b.m682c(parcel, 4, googleMapOptions.getMapType());
        C0359b.m671a(parcel, 5, (Parcelable) googleMapOptions.getCamera(), i, false);
        C0359b.m664a(parcel, 6, googleMapOptions.mo5661bb());
        C0359b.m664a(parcel, 7, googleMapOptions.mo5662bc());
        C0359b.m664a(parcel, 8, googleMapOptions.mo5663bd());
        C0359b.m664a(parcel, 9, googleMapOptions.mo5664be());
        C0359b.m664a(parcel, 10, googleMapOptions.mo5665bf());
        C0359b.m664a(parcel, 11, googleMapOptions.mo5666bg());
        C0359b.m663C(parcel, d);
    }
}
