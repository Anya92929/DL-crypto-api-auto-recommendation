package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

public class zzl implements Parcelable.Creator<StreetViewPanoramaLocation> {
    /* renamed from: a */
    static void m5127a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, streetViewPanoramaLocation.mo8721a());
        C1031c.m4621a(parcel, 2, (T[]) streetViewPanoramaLocation.links, i, false);
        C1031c.m4614a(parcel, 3, (Parcelable) streetViewPanoramaLocation.position, i, false);
        C1031c.m4616a(parcel, 4, streetViewPanoramaLocation.panoId, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: zzfh */
    public StreetViewPanoramaLocation createFromParcel(Parcel parcel) {
        String k;
        LatLng latLng;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr;
        int i;
        String str = null;
        int b = C1029a.m4587b(parcel);
        int i2 = 0;
        LatLng latLng2 = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr2 = null;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    String str2 = str;
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = C1029a.m4594f(parcel, a);
                    k = str2;
                    break;
                case 2:
                    i = i2;
                    LatLng latLng3 = latLng2;
                    streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) C1029a.m4589b(parcel, a, StreetViewPanoramaLink.CREATOR);
                    k = str;
                    latLng = latLng3;
                    break;
                case 3:
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    String str3 = str;
                    latLng = (LatLng) C1029a.m4583a(parcel, a, LatLng.CREATOR);
                    k = str3;
                    break;
                case 4:
                    k = C1029a.m4599k(parcel, a);
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    k = str;
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    break;
            }
            i2 = i;
            streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
            latLng2 = latLng;
            str = k;
        }
        if (parcel.dataPosition() == b) {
            return new StreetViewPanoramaLocation(i2, streetViewPanoramaLinkArr2, latLng2, str);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: zzhH */
    public StreetViewPanoramaLocation[] newArray(int i) {
        return new StreetViewPanoramaLocation[i];
    }
}
