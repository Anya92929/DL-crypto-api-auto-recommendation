package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

public class CircleOptionsCreator implements Parcelable.Creator<CircleOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2032a(CircleOptions circleOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, circleOptions.mo5928i());
        C0359b.m671a(parcel, 2, (Parcelable) circleOptions.getCenter(), i, false);
        C0359b.m665a(parcel, 3, circleOptions.getRadius());
        C0359b.m666a(parcel, 4, circleOptions.getStrokeWidth());
        C0359b.m682c(parcel, 5, circleOptions.getStrokeColor());
        C0359b.m682c(parcel, 6, circleOptions.getFillColor());
        C0359b.m666a(parcel, 7, circleOptions.getZIndex());
        C0359b.m675a(parcel, 8, circleOptions.isVisible());
        C0359b.m663C(parcel, d);
    }

    public CircleOptions createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        boolean z = false;
        int c = C0357a.m634c(parcel);
        LatLng latLng = null;
        double d = 0.0d;
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
                    latLng = (LatLng) C0357a.m628a(parcel, b, LatLng.CREATOR);
                    break;
                case 3:
                    d = C0357a.m643j(parcel, b);
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
                    z = C0357a.m636c(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public CircleOptions[] newArray(int size) {
        return new CircleOptions[size];
    }
}
