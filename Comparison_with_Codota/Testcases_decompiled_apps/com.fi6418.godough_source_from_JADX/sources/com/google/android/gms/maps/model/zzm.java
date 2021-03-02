package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zzm implements Parcelable.Creator<StreetViewPanoramaOrientation> {
    /* renamed from: a */
    static void m5128a(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, streetViewPanoramaOrientation.mo8727a());
        C1031c.m4609a(parcel, 2, streetViewPanoramaOrientation.tilt);
        C1031c.m4609a(parcel, 3, streetViewPanoramaOrientation.bearing);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzfi */
    public StreetViewPanoramaOrientation createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        int b = C1029a.m4587b(parcel);
        int i = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    f2 = C1029a.m4597i(parcel, a);
                    break;
                case 3:
                    f = C1029a.m4597i(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StreetViewPanoramaOrientation(i, f2, f);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhI */
    public StreetViewPanoramaOrientation[] newArray(int i) {
        return new StreetViewPanoramaOrientation[i];
    }
}
