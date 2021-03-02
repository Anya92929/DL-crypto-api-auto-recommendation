package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.maps.a */
public class C0648a {
    /* renamed from: a */
    static void m2010a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, googleMapOptions.getVersionCode());
        C0155b.m341a(parcel, 2, googleMapOptions.mo5491cv());
        C0155b.m341a(parcel, 3, googleMapOptions.mo5492cw());
        C0155b.m359c(parcel, 4, googleMapOptions.getMapType());
        C0155b.m348a(parcel, 5, (Parcelable) googleMapOptions.getCamera(), i, false);
        C0155b.m341a(parcel, 6, googleMapOptions.mo5493cx());
        C0155b.m341a(parcel, 7, googleMapOptions.mo5494cy());
        C0155b.m341a(parcel, 8, googleMapOptions.mo5495cz());
        C0155b.m341a(parcel, 9, googleMapOptions.mo5486cA());
        C0155b.m341a(parcel, 10, googleMapOptions.mo5487cB());
        C0155b.m341a(parcel, 11, googleMapOptions.mo5488cC());
        C0155b.m340C(parcel, k);
    }
}
