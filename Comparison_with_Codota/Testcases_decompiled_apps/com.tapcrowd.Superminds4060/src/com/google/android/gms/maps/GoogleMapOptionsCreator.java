package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.maps.model.CameraPosition;

public class GoogleMapOptionsCreator implements Parcelable.Creator<GoogleMapOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1996a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, googleMapOptions.getVersionCode());
        C0155b.m341a(parcel, 2, googleMapOptions.mo5491cv());
        C0155b.m341a(parcel, 3, googleMapOptions.mo5492cw());
        C0155b.m359c(parcel, 4, googleMapOptions.getMapType());
        C0155b.m348a(parcel, 5, (Parcelable) googleMapOptions.getCamera(), i, false);
        C0155b.m341a(parcel, 6, googleMapOptions.mo5493cx());
        C0155b.m341a(parcel, 7, googleMapOptions.mo5494cy());
        C0155b.m341a(parcel, 8, googleMapOptions.mo5495cz());
        C0155b.m341a(parcel, 9, googleMapOptions.mo5486cA());
        C0155b.m341a(parcel, 10, googleMapOptions.mo5487cB());
        C0155b.m341a(parcel, 11, googleMapOptions.mo5488cC());
        C0155b.m340C(parcel, k);
    }

    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = 0;
        int j = C0153a.m320j(parcel);
        CameraPosition cameraPosition = null;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        byte b6 = 0;
        int i = 0;
        byte b7 = 0;
        byte b8 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i3)) {
                case 1:
                    i2 = C0153a.m314f(parcel, i3);
                    break;
                case 2:
                    b8 = C0153a.m312d(parcel, i3);
                    break;
                case 3:
                    b7 = C0153a.m312d(parcel, i3);
                    break;
                case 4:
                    i = C0153a.m314f(parcel, i3);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) C0153a.m305a(parcel, i3, CameraPosition.CREATOR);
                    break;
                case 6:
                    b6 = C0153a.m312d(parcel, i3);
                    break;
                case 7:
                    b5 = C0153a.m312d(parcel, i3);
                    break;
                case 8:
                    b4 = C0153a.m312d(parcel, i3);
                    break;
                case 9:
                    b3 = C0153a.m312d(parcel, i3);
                    break;
                case 10:
                    b2 = C0153a.m312d(parcel, i3);
                    break;
                case 11:
                    b = C0153a.m312d(parcel, i3);
                    break;
                default:
                    C0153a.m308b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new GoogleMapOptions(i2, b8, b7, i, cameraPosition, b6, b5, b4, b3, b2, b);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public GoogleMapOptions[] newArray(int size) {
        return new GoogleMapOptions[size];
    }
}
