package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zzb implements Parcelable.Creator<CircleOptions> {
    /* renamed from: a */
    static void m5117a(CircleOptions circleOptions, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, circleOptions.mo8481a());
        C1031c.m4614a(parcel, 2, (Parcelable) circleOptions.getCenter(), i, false);
        C1031c.m4608a(parcel, 3, circleOptions.getRadius());
        C1031c.m4609a(parcel, 4, circleOptions.getStrokeWidth());
        C1031c.m4610a(parcel, 5, circleOptions.getStrokeColor());
        C1031c.m4610a(parcel, 6, circleOptions.getFillColor());
        C1031c.m4609a(parcel, 7, circleOptions.getZIndex());
        C1031c.m4619a(parcel, 8, circleOptions.isVisible());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzeX */
    public CircleOptions createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        boolean z = false;
        int b = C1029a.m4587b(parcel);
        LatLng latLng = null;
        double d = 0.0d;
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
                    latLng = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    d = C1029a.m4598j(parcel, a);
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
                    z = C1029a.m4591c(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhx */
    public CircleOptions[] newArray(int i) {
        return new CircleOptions[i];
    }
}
