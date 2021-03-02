package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

public class CameraPositionCreator implements Parcelable.Creator<CameraPosition> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2030a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, cameraPosition.mo5891i());
        C0359b.m671a(parcel, 2, (Parcelable) cameraPosition.target, i, false);
        C0359b.m666a(parcel, 3, cameraPosition.zoom);
        C0359b.m666a(parcel, 4, cameraPosition.tilt);
        C0359b.m666a(parcel, 5, cameraPosition.bearing);
        C0359b.m663C(parcel, d);
    }

    public CameraPosition createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        int c = C0357a.m634c(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    break;
                case 2:
                    latLng = (LatLng) C0357a.m628a(parcel, b, LatLng.CREATOR);
                    break;
                case 3:
                    f3 = C0357a.m642i(parcel, b);
                    break;
                case 4:
                    f2 = C0357a.m642i(parcel, b);
                    break;
                case 5:
                    f = C0357a.m642i(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public CameraPosition[] newArray(int size) {
        return new CameraPosition[size];
    }
}
