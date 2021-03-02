package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.b */
public class C1790b {
    /* renamed from: a */
    static void m6315a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, googleMapOptions.getVersionCode());
        C0354b.m916a(parcel, 2, googleMapOptions.mo10352mp());
        C0354b.m916a(parcel, 3, googleMapOptions.mo10353mq());
        C0354b.m939c(parcel, 4, googleMapOptions.getMapType());
        C0354b.m923a(parcel, 5, (Parcelable) googleMapOptions.getCamera(), i, false);
        C0354b.m916a(parcel, 6, googleMapOptions.mo10354mr());
        C0354b.m916a(parcel, 7, googleMapOptions.mo10355ms());
        C0354b.m916a(parcel, 8, googleMapOptions.mo10356mt());
        C0354b.m916a(parcel, 9, googleMapOptions.mo10357mu());
        C0354b.m916a(parcel, 10, googleMapOptions.mo10358mv());
        C0354b.m916a(parcel, 11, googleMapOptions.mo10359mw());
        C0354b.m915H(parcel, D);
    }
}
