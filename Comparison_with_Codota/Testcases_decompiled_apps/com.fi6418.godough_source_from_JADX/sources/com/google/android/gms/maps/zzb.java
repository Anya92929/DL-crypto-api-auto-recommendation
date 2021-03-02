package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class zzb implements Parcelable.Creator<StreetViewPanoramaOptions> {
    /* renamed from: a */
    static void m5161a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, streetViewPanoramaOptions.mo8107a());
        C1031c.m4614a(parcel, 2, (Parcelable) streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        C1031c.m4616a(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        C1031c.m4614a(parcel, 4, (Parcelable) streetViewPanoramaOptions.getPosition(), i, false);
        C1031c.m4615a(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        C1031c.m4607a(parcel, 6, streetViewPanoramaOptions.mo8108b());
        C1031c.m4607a(parcel, 7, streetViewPanoramaOptions.mo8109c());
        C1031c.m4607a(parcel, 8, streetViewPanoramaOptions.mo8110d());
        C1031c.m4607a(parcel, 9, streetViewPanoramaOptions.mo8112e());
        C1031c.m4607a(parcel, 10, streetViewPanoramaOptions.mo8113f());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzeV */
    public StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        Integer num = null;
        byte b = 0;
        int b2 = C1029a.m4587b(parcel);
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        byte b6 = 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) C1029a.m4583a(parcel, a, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = C1029a.m4599k(parcel, a);
                    break;
                case 4:
                    latLng = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    break;
                case 5:
                    num = C1029a.m4595g(parcel, a);
                    break;
                case 6:
                    b6 = C1029a.m4592d(parcel, a);
                    break;
                case 7:
                    b5 = C1029a.m4592d(parcel, a);
                    break;
                case 8:
                    b4 = C1029a.m4592d(parcel, a);
                    break;
                case 9:
                    b3 = C1029a.m4592d(parcel, a);
                    break;
                case 10:
                    b = C1029a.m4592d(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b2) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b6, b5, b4, b3, b);
        }
        throw new C1030b("Overread allowed size end=" + b2, parcel);
    }

    /* renamed from: zzhv */
    public StreetViewPanoramaOptions[] newArray(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
