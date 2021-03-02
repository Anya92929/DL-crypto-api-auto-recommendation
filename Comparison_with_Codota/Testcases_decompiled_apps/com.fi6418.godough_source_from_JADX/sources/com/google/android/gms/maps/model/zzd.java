package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zzd implements Parcelable.Creator<LatLngBounds> {
    /* renamed from: a */
    static void m5119a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, latLngBounds.mo8560a());
        C1031c.m4614a(parcel, 2, (Parcelable) latLngBounds.southwest, i, false);
        C1031c.m4614a(parcel, 3, (Parcelable) latLngBounds.northeast, i, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzeZ */
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        int i;
        LatLng latLng3 = null;
        int b = C1029a.m4587b(parcel);
        int i2 = 0;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    LatLng latLng5 = latLng3;
                    latLng2 = latLng4;
                    i = C1029a.m4594f(parcel, a);
                    latLng = latLng5;
                    break;
                case 2:
                    i = i2;
                    LatLng latLng6 = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    latLng = latLng3;
                    latLng2 = latLng6;
                    break;
                case 3:
                    latLng = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    latLng2 = latLng4;
                    i = i2;
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    latLng = latLng3;
                    latLng2 = latLng4;
                    i = i2;
                    break;
            }
            i2 = i;
            latLng4 = latLng2;
            latLng3 = latLng;
        }
        if (parcel.dataPosition() == b) {
            return new LatLngBounds(i2, latLng4, latLng3);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhz */
    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
