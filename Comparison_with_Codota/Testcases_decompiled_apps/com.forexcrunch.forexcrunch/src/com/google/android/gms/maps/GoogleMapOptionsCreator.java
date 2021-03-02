package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.maps.model.CameraPosition;

public class GoogleMapOptionsCreator implements Parcelable.Creator<GoogleMapOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1950a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m682c(parcel, 1, googleMapOptions.mo5680i());
        C0359b.m664a(parcel, 2, googleMapOptions.mo5659aZ());
        C0359b.m664a(parcel, 3, googleMapOptions.mo5660ba());
        C0359b.m682c(parcel, 4, googleMapOptions.getMapType());
        C0359b.m671a(parcel, 5, (Parcelable) googleMapOptions.getCamera(), i, false);
        C0359b.m664a(parcel, 6, googleMapOptions.mo5661bb());
        C0359b.m664a(parcel, 7, googleMapOptions.mo5662bc());
        C0359b.m664a(parcel, 8, googleMapOptions.mo5663bd());
        C0359b.m664a(parcel, 9, googleMapOptions.mo5664be());
        C0359b.m664a(parcel, 10, googleMapOptions.mo5665bf());
        C0359b.m664a(parcel, 11, googleMapOptions.mo5666bg());
        C0359b.m663C(parcel, d);
    }

    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = 0;
        int c = C0357a.m634c(parcel);
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
        while (parcel.dataPosition() < c) {
            int b9 = C0357a.m631b(parcel);
            switch (C0357a.m646m(b9)) {
                case 1:
                    i2 = C0357a.m639f(parcel, b9);
                    break;
                case 2:
                    b8 = C0357a.m637d(parcel, b9);
                    break;
                case 3:
                    b7 = C0357a.m637d(parcel, b9);
                    break;
                case 4:
                    i = C0357a.m639f(parcel, b9);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) C0357a.m628a(parcel, b9, CameraPosition.CREATOR);
                    break;
                case 6:
                    b6 = C0357a.m637d(parcel, b9);
                    break;
                case 7:
                    b5 = C0357a.m637d(parcel, b9);
                    break;
                case 8:
                    b4 = C0357a.m637d(parcel, b9);
                    break;
                case 9:
                    b3 = C0357a.m637d(parcel, b9);
                    break;
                case 10:
                    b2 = C0357a.m637d(parcel, b9);
                    break;
                case 11:
                    b = C0357a.m637d(parcel, b9);
                    break;
                default:
                    C0357a.m632b(parcel, b9);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new GoogleMapOptions(i2, b8, b7, i, cameraPosition, b6, b5, b4, b3, b2, b);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    public GoogleMapOptions[] newArray(int size) {
        return new GoogleMapOptions[size];
    }
}
