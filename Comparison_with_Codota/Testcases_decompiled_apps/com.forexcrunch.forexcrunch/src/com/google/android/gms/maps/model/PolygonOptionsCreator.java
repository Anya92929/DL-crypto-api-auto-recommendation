package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import java.util.ArrayList;

public class PolygonOptionsCreator implements Parcelable.Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2053a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, polygonOptions.mo6091i());
        C0359b.m681b(parcel, 2, polygonOptions.getPoints(), false);
        C0359b.m683c(parcel, 3, polygonOptions.mo6081br(), false);
        C0359b.m666a(parcel, 4, polygonOptions.getStrokeWidth());
        C0359b.m682c(parcel, 5, polygonOptions.getStrokeColor());
        C0359b.m682c(parcel, 6, polygonOptions.getFillColor());
        C0359b.m666a(parcel, 7, polygonOptions.getZIndex());
        C0359b.m675a(parcel, 8, polygonOptions.isVisible());
        C0359b.m675a(parcel, 9, polygonOptions.isGeodesic());
        C0359b.m663C(parcel, d);
    }

    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        boolean z = false;
        int c = C0357a.m634c(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i3 = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    arrayList = C0357a.m635c(parcel, b, LatLng.CREATOR);
                    break;
                case 3:
                    C0357a.m630a(parcel, b, arrayList2, getClass().getClassLoader());
                    break;
                case 4:
                    f2 = C0357a.m642i(parcel, b);
                    break;
                case 5:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                case 6:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 7:
                    f = C0357a.m642i(parcel, b);
                    break;
                case 8:
                    z2 = C0357a.m636c(parcel, b);
                    break;
                case 9:
                    z = C0357a.m636c(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new PolygonOptions(i3, arrayList, arrayList2, f2, i2, i, f, z2, z);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public PolygonOptions[] newArray(int size) {
        return new PolygonOptions[size];
    }
}
