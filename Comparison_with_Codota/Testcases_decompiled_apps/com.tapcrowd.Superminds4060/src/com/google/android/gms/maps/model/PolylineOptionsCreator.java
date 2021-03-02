package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import java.util.ArrayList;

public class PolylineOptionsCreator implements Parcelable.Creator<PolylineOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2096a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, polylineOptions.getVersionCode());
        C0155b.m358b(parcel, 2, polylineOptions.getPoints(), false);
        C0155b.m343a(parcel, 3, polylineOptions.getWidth());
        C0155b.m359c(parcel, 4, polylineOptions.getColor());
        C0155b.m343a(parcel, 5, polylineOptions.getZIndex());
        C0155b.m352a(parcel, 6, polylineOptions.isVisible());
        C0155b.m352a(parcel, 7, polylineOptions.isGeodesic());
        C0155b.m340C(parcel, k);
    }

    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        boolean z = false;
        int j = C0153a.m320j(parcel);
        ArrayList arrayList = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i3)) {
                case 1:
                    i2 = C0153a.m314f(parcel, i3);
                    break;
                case 2:
                    arrayList = C0153a.m310c(parcel, i3, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = C0153a.m317i(parcel, i3);
                    break;
                case 4:
                    i = C0153a.m314f(parcel, i3);
                    break;
                case 5:
                    f = C0153a.m317i(parcel, i3);
                    break;
                case 6:
                    z2 = C0153a.m311c(parcel, i3);
                    break;
                case 7:
                    z = C0153a.m311c(parcel, i3);
                    break;
                default:
                    C0153a.m308b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new PolylineOptions(i2, arrayList, f2, i, f, z2, z);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public PolylineOptions[] newArray(int size) {
        return new PolylineOptions[size];
    }
}
