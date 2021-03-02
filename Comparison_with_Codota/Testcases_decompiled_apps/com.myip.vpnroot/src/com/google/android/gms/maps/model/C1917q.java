package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.q */
public class C1917q implements Parcelable.Creator<StreetViewPanoramaCamera> {
    /* renamed from: a */
    static void m6490a(StreetViewPanoramaCamera streetViewPanoramaCamera, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, streetViewPanoramaCamera.getVersionCode());
        C0354b.m918a(parcel, 2, streetViewPanoramaCamera.zoom);
        C0354b.m918a(parcel, 3, streetViewPanoramaCamera.tilt);
        C0354b.m918a(parcel, 4, streetViewPanoramaCamera.bearing);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cQ */
    public StreetViewPanoramaCamera createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int C = C0352a.m875C(parcel);
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
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
                    f3 = C0352a.m897l(parcel, B);
                    break;
                case 4:
                    f = C0352a.m897l(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new StreetViewPanoramaCamera(i, f2, f3, f);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eF */
    public StreetViewPanoramaCamera[] newArray(int i) {
        return new StreetViewPanoramaCamera[i];
    }
}
