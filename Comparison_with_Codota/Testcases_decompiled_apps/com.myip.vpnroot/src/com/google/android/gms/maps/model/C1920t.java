package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.t */
public class C1920t implements Parcelable.Creator<StreetViewPanoramaOrientation> {
    /* renamed from: a */
    static void m6499a(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, streetViewPanoramaOrientation.getVersionCode());
        C0354b.m918a(parcel, 2, streetViewPanoramaOrientation.tilt);
        C0354b.m918a(parcel, 3, streetViewPanoramaOrientation.bearing);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cT */
    public StreetViewPanoramaOrientation createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int C = C0352a.m875C(parcel);
        int i = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    f2 = C0352a.m897l(parcel, B);
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
            return new StreetViewPanoramaOrientation(i, f2, f);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eI */
    public StreetViewPanoramaOrientation[] newArray(int i) {
        return new StreetViewPanoramaOrientation[i];
    }
}
