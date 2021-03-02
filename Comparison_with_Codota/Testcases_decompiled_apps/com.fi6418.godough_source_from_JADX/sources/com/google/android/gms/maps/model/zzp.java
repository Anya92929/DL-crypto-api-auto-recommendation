package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zzp implements Parcelable.Creator<VisibleRegion> {
    /* renamed from: a */
    static void m5131a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, visibleRegion.mo8764a());
        C1031c.m4614a(parcel, 2, (Parcelable) visibleRegion.nearLeft, i, false);
        C1031c.m4614a(parcel, 3, (Parcelable) visibleRegion.nearRight, i, false);
        C1031c.m4614a(parcel, 4, (Parcelable) visibleRegion.farLeft, i, false);
        C1031c.m4614a(parcel, 5, (Parcelable) visibleRegion.farRight, i, false);
        C1031c.m4614a(parcel, 6, (Parcelable) visibleRegion.latLngBounds, i, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzfl */
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int b = C1029a.m4587b(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    latLng4 = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C1029a.m4583a(parcel, a, LatLngBounds.CREATOR);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhL */
    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
