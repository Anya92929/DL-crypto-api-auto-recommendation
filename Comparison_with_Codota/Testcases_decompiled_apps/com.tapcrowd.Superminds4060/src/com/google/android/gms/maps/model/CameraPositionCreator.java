package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

public class CameraPositionCreator implements Parcelable.Creator<CameraPosition> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2078a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, cameraPosition.getVersionCode());
        C0155b.m348a(parcel, 2, (Parcelable) cameraPosition.target, i, false);
        C0155b.m343a(parcel, 3, cameraPosition.zoom);
        C0155b.m343a(parcel, 4, cameraPosition.tilt);
        C0155b.m343a(parcel, 5, cameraPosition.bearing);
        C0155b.m340C(parcel, k);
    }

    public CameraPosition createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        int j = C0153a.m320j(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    latLng = (LatLng) C0153a.m305a(parcel, i2, LatLng.CREATOR);
                    break;
                case 3:
                    f3 = C0153a.m317i(parcel, i2);
                    break;
                case 4:
                    f2 = C0153a.m317i(parcel, i2);
                    break;
                case 5:
                    f = C0153a.m317i(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public CameraPosition[] newArray(int size) {
        return new CameraPosition[size];
    }
}
