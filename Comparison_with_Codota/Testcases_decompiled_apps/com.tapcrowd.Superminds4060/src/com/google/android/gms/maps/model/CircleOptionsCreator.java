package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

public class CircleOptionsCreator implements Parcelable.Creator<CircleOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2079a(CircleOptions circleOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, circleOptions.getVersionCode());
        C0155b.m348a(parcel, 2, (Parcelable) circleOptions.getCenter(), i, false);
        C0155b.m342a(parcel, 3, circleOptions.getRadius());
        C0155b.m343a(parcel, 4, circleOptions.getStrokeWidth());
        C0155b.m359c(parcel, 5, circleOptions.getStrokeColor());
        C0155b.m359c(parcel, 6, circleOptions.getFillColor());
        C0155b.m343a(parcel, 7, circleOptions.getZIndex());
        C0155b.m352a(parcel, 8, circleOptions.isVisible());
        C0155b.m340C(parcel, k);
    }

    public CircleOptions createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        boolean z = false;
        int j = C0153a.m320j(parcel);
        LatLng latLng = null;
        double d = 0.0d;
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
                    latLng = (LatLng) C0153a.m305a(parcel, i4, LatLng.CREATOR);
                    break;
                case 3:
                    d = C0153a.m319j(parcel, i4);
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
                    z = C0153a.m311c(parcel, i4);
                    break;
                default:
                    C0153a.m308b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public CircleOptions[] newArray(int size) {
        return new CircleOptions[size];
    }
}
