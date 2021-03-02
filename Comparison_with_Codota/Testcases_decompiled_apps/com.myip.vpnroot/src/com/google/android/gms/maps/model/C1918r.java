package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.r */
public class C1918r implements Parcelable.Creator<StreetViewPanoramaLink> {
    /* renamed from: a */
    static void m6493a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, streetViewPanoramaLink.getVersionCode());
        C0354b.m927a(parcel, 2, streetViewPanoramaLink.panoId, false);
        C0354b.m918a(parcel, 3, streetViewPanoramaLink.bearing);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cR */
    public StreetViewPanoramaLink createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    f = C0352a.m897l(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eG */
    public StreetViewPanoramaLink[] newArray(int i) {
        return new StreetViewPanoramaLink[i];
    }
}
