package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zze implements Parcelable.Creator<LatLng> {
    /* renamed from: a */
    static void m5120a(LatLng latLng, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, latLng.mo8554a());
        C1031c.m4608a(parcel, 2, latLng.latitude);
        C1031c.m4608a(parcel, 3, latLng.longitude);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzfa */
    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int b = C1029a.m4587b(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    d2 = C1029a.m4598j(parcel, a);
                    break;
                case 3:
                    d = C1029a.m4598j(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LatLng(i, d2, d);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhA */
    public LatLng[] newArray(int i) {
        return new LatLng[i];
    }
}
