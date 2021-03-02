package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

public class LatLngBoundsCreator implements Parcelable.Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2090a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, latLngBounds.getVersionCode());
        C0155b.m348a(parcel, 2, (Parcelable) latLngBounds.southwest, i, false);
        C0155b.m348a(parcel, 3, (Parcelable) latLngBounds.northeast, i, false);
        C0155b.m340C(parcel, k);
    }

    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        int i;
        LatLng latLng3 = null;
        int j = C0153a.m320j(parcel);
        int i2 = 0;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < j) {
            int i3 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i3)) {
                case 1:
                    LatLng latLng5 = latLng3;
                    latLng2 = latLng4;
                    i = C0153a.m314f(parcel, i3);
                    latLng = latLng5;
                    break;
                case 2:
                    i = i2;
                    LatLng latLng6 = (LatLng) C0153a.m305a(parcel, i3, LatLng.CREATOR);
                    latLng = latLng3;
                    latLng2 = latLng6;
                    break;
                case 3:
                    latLng = (LatLng) C0153a.m305a(parcel, i3, LatLng.CREATOR);
                    latLng2 = latLng4;
                    i = i2;
                    break;
                default:
                    C0153a.m308b(parcel, i3);
                    latLng = latLng3;
                    latLng2 = latLng4;
                    i = i2;
                    break;
            }
            i2 = i;
            latLng4 = latLng2;
            latLng3 = latLng;
        }
        if (parcel.dataPosition() == j) {
            return new LatLngBounds(i2, latLng4, latLng3);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public LatLngBounds[] newArray(int size) {
        return new LatLngBounds[size];
    }
}
