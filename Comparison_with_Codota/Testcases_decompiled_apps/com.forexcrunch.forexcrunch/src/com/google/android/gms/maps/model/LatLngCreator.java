package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

public class LatLngCreator implements Parcelable.Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2047a(LatLng latLng, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, latLng.mo5987i());
        C0359b.m665a(parcel, 2, latLng.latitude);
        C0359b.m665a(parcel, 3, latLng.longitude);
        C0359b.m663C(parcel, d);
    }

    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int c = C0357a.m634c(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    d2 = C0357a.m643j(parcel, b);
                    break;
                case 3:
                    d = C0357a.m643j(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new LatLng(i, d2, d);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public LatLng[] newArray(int size) {
        return new LatLng[size];
    }
}
