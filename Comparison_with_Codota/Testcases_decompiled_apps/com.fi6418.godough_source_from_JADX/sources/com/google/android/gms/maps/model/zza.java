package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zza implements Parcelable.Creator<CameraPosition> {
    /* renamed from: a */
    static void m5116a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, cameraPosition.mo8452a());
        C1031c.m4614a(parcel, 2, (Parcelable) cameraPosition.target, i, false);
        C1031c.m4609a(parcel, 3, cameraPosition.zoom);
        C1031c.m4609a(parcel, 4, cameraPosition.tilt);
        C1031c.m4609a(parcel, 5, cameraPosition.bearing);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzeW */
    public CameraPosition createFromParcel(Parcel parcel) {
        float f = BitmapDescriptorFactory.HUE_RED;
        int b = C1029a.m4587b(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    latLng = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    f3 = C1029a.m4597i(parcel, a);
                    break;
                case 4:
                    f2 = C1029a.m4597i(parcel, a);
                    break;
                case 5:
                    f = C1029a.m4597i(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhw */
    public CameraPosition[] newArray(int i) {
        return new CameraPosition[i];
    }
}
