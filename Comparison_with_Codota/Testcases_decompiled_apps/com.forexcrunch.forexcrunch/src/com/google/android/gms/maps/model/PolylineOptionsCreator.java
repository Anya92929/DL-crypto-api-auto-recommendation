package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import java.util.ArrayList;

public class PolylineOptionsCreator implements Parcelable.Creator<PolylineOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2055a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, polylineOptions.mo6127i());
        C0359b.m681b(parcel, 2, polylineOptions.getPoints(), false);
        C0359b.m666a(parcel, 3, polylineOptions.getWidth());
        C0359b.m682c(parcel, 4, polylineOptions.getColor());
        C0359b.m666a(parcel, 5, polylineOptions.getZIndex());
        C0359b.m675a(parcel, 6, polylineOptions.isVisible());
        C0359b.m675a(parcel, 7, polylineOptions.isGeodesic());
        C0359b.m663C(parcel, d);
    }

    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        boolean z = false;
        int c = C0357a.m634c(parcel);
        ArrayList arrayList = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i2 = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    arrayList = C0357a.m635c(parcel, b, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = C0357a.m642i(parcel, b);
                    break;
                case 4:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 5:
                    f = C0357a.m642i(parcel, b);
                    break;
                case 6:
                    z2 = C0357a.m636c(parcel, b);
                    break;
                case 7:
                    z = C0357a.m636c(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new PolylineOptions(i2, arrayList, f2, i, f, z2, z);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public PolylineOptions[] newArray(int size) {
        return new PolylineOptions[size];
    }
}
