package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

public class VisibleRegionCreator implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2103a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, visibleRegion.getVersionCode());
        C0155b.m348a(parcel, 2, (Parcelable) visibleRegion.nearLeft, i, false);
        C0155b.m348a(parcel, 3, (Parcelable) visibleRegion.nearRight, i, false);
        C0155b.m348a(parcel, 4, (Parcelable) visibleRegion.farLeft, i, false);
        C0155b.m348a(parcel, 5, (Parcelable) visibleRegion.farRight, i, false);
        C0155b.m348a(parcel, 6, (Parcelable) visibleRegion.latLngBounds, i, false);
        C0155b.m340C(parcel, k);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    latLng4 = (LatLng) C0153a.m305a(parcel, i2, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) C0153a.m305a(parcel, i2, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) C0153a.m305a(parcel, i2, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) C0153a.m305a(parcel, i2, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0153a.m305a(parcel, i2, LatLngBounds.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public VisibleRegion[] newArray(int size) {
        return new VisibleRegion[size];
    }
}
