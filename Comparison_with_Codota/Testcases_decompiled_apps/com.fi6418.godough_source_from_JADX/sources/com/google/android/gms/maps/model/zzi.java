package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import java.util.ArrayList;

public class zzi implements Parcelable.Creator<PolylineOptions> {
    /* renamed from: a */
    static void m5124a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, polylineOptions.mo8686a());
        C1031c.m4627c(parcel, 2, polylineOptions.getPoints(), false);
        C1031c.m4609a(parcel, 3, polylineOptions.getWidth());
        C1031c.m4610a(parcel, 4, polylineOptions.getColor());
        C1031c.m4609a(parcel, 5, polylineOptions.getZIndex());
        C1031c.m4619a(parcel, 6, polylineOptions.isVisible());
        C1031c.m4619a(parcel, 7, polylineOptions.isGeodesic());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzfe */
    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        boolean z = false;
        int b = C1029a.m4587b(parcel);
        ArrayList arrayList = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    arrayList = C1029a.m4590c(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = C1029a.m4597i(parcel, a);
                    break;
                case 4:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 5:
                    f = C1029a.m4597i(parcel, a);
                    break;
                case 6:
                    z2 = C1029a.m4591c(parcel, a);
                    break;
                case 7:
                    z = C1029a.m4591c(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PolylineOptions(i2, arrayList, f2, i, f, z2, z);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhE */
    public PolylineOptions[] newArray(int i) {
        return new PolylineOptions[i];
    }
}
