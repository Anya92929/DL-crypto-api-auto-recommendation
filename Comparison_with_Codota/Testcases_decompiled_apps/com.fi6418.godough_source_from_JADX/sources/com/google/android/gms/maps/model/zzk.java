package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zzk implements Parcelable.Creator<StreetViewPanoramaLink> {
    /* renamed from: a */
    static void m5126a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, streetViewPanoramaLink.mo8715a());
        C1031c.m4616a(parcel, 2, streetViewPanoramaLink.panoId, false);
        C1031c.m4609a(parcel, 3, streetViewPanoramaLink.bearing);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzfg */
    public StreetViewPanoramaLink createFromParcel(Parcel parcel) {
        int b = C1029a.m4587b(parcel);
        int i = 0;
        String str = null;
        float f = BitmapDescriptorFactory.HUE_RED;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    str = C1029a.m4599k(parcel, a);
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
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhG */
    public StreetViewPanoramaLink[] newArray(int i) {
        return new StreetViewPanoramaLink[i];
    }
}
