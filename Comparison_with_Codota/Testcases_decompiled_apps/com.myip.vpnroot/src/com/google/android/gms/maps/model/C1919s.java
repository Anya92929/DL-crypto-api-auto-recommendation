package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.s */
public class C1919s implements Parcelable.Creator<StreetViewPanoramaLocation> {
    /* renamed from: a */
    static void m6496a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, streetViewPanoramaLocation.getVersionCode());
        C0354b.m933a(parcel, 2, (T[]) streetViewPanoramaLocation.links, i, false);
        C0354b.m923a(parcel, 3, (Parcelable) streetViewPanoramaLocation.position, i, false);
        C0354b.m927a(parcel, 4, streetViewPanoramaLocation.panoId, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cS */
    public StreetViewPanoramaLocation createFromParcel(Parcel parcel) {
        String o;
        LatLng latLng;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr;
        int i;
        String str = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        LatLng latLng2 = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    String str2 = str;
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = C0352a.m892g(parcel, B);
                    o = str2;
                    break;
                case 2:
                    i = i2;
                    LatLng latLng3 = latLng2;
                    streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) C0352a.m886b(parcel, B, StreetViewPanoramaLink.CREATOR);
                    o = str;
                    latLng = latLng3;
                    break;
                case 3:
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    String str3 = str;
                    latLng = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    o = str3;
                    break;
                case 4:
                    o = C0352a.m900o(parcel, B);
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    o = str;
                    latLng = latLng2;
                    streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
                    i = i2;
                    break;
            }
            i2 = i;
            streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
            latLng2 = latLng;
            str = o;
        }
        if (parcel.dataPosition() == C) {
            return new StreetViewPanoramaLocation(i2, streetViewPanoramaLinkArr2, latLng2, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eH */
    public StreetViewPanoramaLocation[] newArray(int i) {
        return new StreetViewPanoramaLocation[i];
    }
}
