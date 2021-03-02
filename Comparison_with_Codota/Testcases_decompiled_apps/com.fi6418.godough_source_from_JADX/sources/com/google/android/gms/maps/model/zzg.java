package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zzg implements Parcelable.Creator<PointOfInterest> {
    /* renamed from: a */
    static void m5122a(PointOfInterest pointOfInterest, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, pointOfInterest.mo8625a());
        C1031c.m4614a(parcel, 2, (Parcelable) pointOfInterest.zzaHy, i, false);
        C1031c.m4616a(parcel, 3, pointOfInterest.zzaHz, false);
        C1031c.m4616a(parcel, 4, pointOfInterest.name, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzfc */
    public PointOfInterest createFromParcel(Parcel parcel) {
        String k;
        String str;
        LatLng latLng;
        int i;
        String str2 = null;
        int b = C1029a.m4587b(parcel);
        int i2 = 0;
        String str3 = null;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    String str4 = str2;
                    str = str3;
                    latLng = latLng2;
                    i = C1029a.m4594f(parcel, a);
                    k = str4;
                    break;
                case 2:
                    i = i2;
                    String str5 = str3;
                    latLng = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    k = str2;
                    str = str5;
                    break;
                case 3:
                    latLng = latLng2;
                    i = i2;
                    String str6 = str2;
                    str = C1029a.m4599k(parcel, a);
                    k = str6;
                    break;
                case 4:
                    k = C1029a.m4599k(parcel, a);
                    str = str3;
                    latLng = latLng2;
                    i = i2;
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    k = str2;
                    str = str3;
                    latLng = latLng2;
                    i = i2;
                    break;
            }
            i2 = i;
            latLng2 = latLng;
            str3 = str;
            str2 = k;
        }
        if (parcel.dataPosition() == b) {
            return new PointOfInterest(i2, latLng2, str3, str2);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhC */
    public PointOfInterest[] newArray(int i) {
        return new PointOfInterest[i];
    }
}
