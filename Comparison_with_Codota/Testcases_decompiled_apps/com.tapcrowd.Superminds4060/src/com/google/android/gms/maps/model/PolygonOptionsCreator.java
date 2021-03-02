package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import java.util.ArrayList;

public class PolygonOptionsCreator implements Parcelable.Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2095a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, polygonOptions.getVersionCode());
        C0155b.m358b(parcel, 2, polygonOptions.getPoints(), false);
        C0155b.m360c(parcel, 3, polygonOptions.mo5919cO(), false);
        C0155b.m343a(parcel, 4, polygonOptions.getStrokeWidth());
        C0155b.m359c(parcel, 5, polygonOptions.getStrokeColor());
        C0155b.m359c(parcel, 6, polygonOptions.getFillColor());
        C0155b.m343a(parcel, 7, polygonOptions.getZIndex());
        C0155b.m352a(parcel, 8, polygonOptions.isVisible());
        C0155b.m352a(parcel, 9, polygonOptions.isGeodesic());
        C0155b.m340C(parcel, k);
    }

    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        boolean z = false;
        int j = C0153a.m320j(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    i3 = C0153a.m314f(parcel, i4);
                    break;
                case 2:
                    arrayList = C0153a.m310c(parcel, i4, LatLng.CREATOR);
                    break;
                case 3:
                    C0153a.m307a(parcel, i4, arrayList2, getClass().getClassLoader());
                    break;
                case 4:
                    f2 = C0153a.m317i(parcel, i4);
                    break;
                case 5:
                    i2 = C0153a.m314f(parcel, i4);
                    break;
                case 6:
                    i = C0153a.m314f(parcel, i4);
                    break;
                case 7:
                    f = C0153a.m317i(parcel, i4);
                    break;
                case 8:
                    z2 = C0153a.m311c(parcel, i4);
                    break;
                case 9:
                    z = C0153a.m311c(parcel, i4);
                    break;
                default:
                    C0153a.m308b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new PolygonOptions(i3, arrayList, arrayList2, f2, i2, i, f, z2, z);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public PolygonOptions[] newArray(int size) {
        return new PolygonOptions[size];
    }
}
