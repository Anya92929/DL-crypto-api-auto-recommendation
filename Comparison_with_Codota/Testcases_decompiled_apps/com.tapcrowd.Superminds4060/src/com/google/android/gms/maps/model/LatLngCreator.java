package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

public class LatLngCreator implements Parcelable.Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2091a(LatLng latLng, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, latLng.getVersionCode());
        C0155b.m342a(parcel, 2, latLng.latitude);
        C0155b.m342a(parcel, 3, latLng.longitude);
        C0155b.m340C(parcel, k);
    }

    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int j = C0153a.m320j(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    d2 = C0153a.m319j(parcel, i2);
                    break;
                case 3:
                    d = C0153a.m319j(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new LatLng(i, d2, d);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public LatLng[] newArray(int size) {
        return new LatLng[size];
    }
}
