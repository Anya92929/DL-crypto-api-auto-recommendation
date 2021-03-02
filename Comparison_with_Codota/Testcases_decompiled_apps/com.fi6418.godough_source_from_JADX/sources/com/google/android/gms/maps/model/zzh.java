package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import java.util.ArrayList;
import java.util.List;

public class zzh implements Parcelable.Creator<PolygonOptions> {
    /* renamed from: a */
    static void m5123a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, polygonOptions.mo8648a());
        C1031c.m4627c(parcel, 2, polygonOptions.getPoints(), false);
        C1031c.m4628d(parcel, 3, polygonOptions.mo8653b(), false);
        C1031c.m4609a(parcel, 4, polygonOptions.getStrokeWidth());
        C1031c.m4610a(parcel, 5, polygonOptions.getStrokeColor());
        C1031c.m4610a(parcel, 6, polygonOptions.getFillColor());
        C1031c.m4609a(parcel, 7, polygonOptions.getZIndex());
        C1031c.m4619a(parcel, 8, polygonOptions.isVisible());
        C1031c.m4619a(parcel, 9, polygonOptions.isGeodesic());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzfd */
    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        boolean z = false;
        int b = C1029a.m4587b(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i3 = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    arrayList = C1029a.m4590c(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    C1029a.m4586a(parcel, a, (List) arrayList2, getClass().getClassLoader());
                    break;
                case 4:
                    f2 = C1029a.m4597i(parcel, a);
                    break;
                case 5:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                case 6:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 7:
                    f = C1029a.m4597i(parcel, a);
                    break;
                case 8:
                    z2 = C1029a.m4591c(parcel, a);
                    break;
                case 9:
                    z = C1029a.m4591c(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PolygonOptions(i3, arrayList, arrayList2, f2, i2, i, f, z2, z);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhD */
    public PolygonOptions[] newArray(int i) {
        return new PolygonOptions[i];
    }
}
