package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import com.google.android.gms.maps.model.CameraPosition;

public class zza implements Parcelable.Creator<GoogleMapOptions> {
    /* renamed from: a */
    static void m5160a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, googleMapOptions.mo7999a());
        C1031c.m4607a(parcel, 2, googleMapOptions.mo8000b());
        C1031c.m4607a(parcel, 3, googleMapOptions.mo8001c());
        C1031c.m4610a(parcel, 4, googleMapOptions.getMapType());
        C1031c.m4614a(parcel, 5, (Parcelable) googleMapOptions.getCamera(), i, false);
        C1031c.m4607a(parcel, 6, googleMapOptions.mo8004d());
        C1031c.m4607a(parcel, 7, googleMapOptions.mo8006e());
        C1031c.m4607a(parcel, 8, googleMapOptions.mo8007f());
        C1031c.m4607a(parcel, 9, googleMapOptions.mo8008g());
        C1031c.m4607a(parcel, 10, googleMapOptions.mo8021h());
        C1031c.m4607a(parcel, 11, googleMapOptions.mo8022i());
        C1031c.m4607a(parcel, 12, googleMapOptions.mo8023j());
        C1031c.m4607a(parcel, 14, googleMapOptions.mo8024k());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzeU */
    public GoogleMapOptions createFromParcel(Parcel parcel) {
        int b = C1029a.m4587b(parcel);
        int i = 0;
        byte b2 = -1;
        byte b3 = -1;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b4 = -1;
        byte b5 = -1;
        byte b6 = -1;
        byte b7 = -1;
        byte b8 = -1;
        byte b9 = -1;
        byte b10 = -1;
        byte b11 = -1;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    b2 = C1029a.m4592d(parcel, a);
                    break;
                case 3:
                    b3 = C1029a.m4592d(parcel, a);
                    break;
                case 4:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) C1029a.m4583a(parcel, a, CameraPosition.CREATOR);
                    break;
                case 6:
                    b4 = C1029a.m4592d(parcel, a);
                    break;
                case 7:
                    b5 = C1029a.m4592d(parcel, a);
                    break;
                case 8:
                    b6 = C1029a.m4592d(parcel, a);
                    break;
                case 9:
                    b7 = C1029a.m4592d(parcel, a);
                    break;
                case 10:
                    b8 = C1029a.m4592d(parcel, a);
                    break;
                case 11:
                    b9 = C1029a.m4592d(parcel, a);
                    break;
                case 12:
                    b10 = C1029a.m4592d(parcel, a);
                    break;
                case 14:
                    b11 = C1029a.m4592d(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GoogleMapOptions(i, b2, b3, i2, cameraPosition, b4, b5, b6, b7, b8, b9, b10, b11);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhu */
    public GoogleMapOptions[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
