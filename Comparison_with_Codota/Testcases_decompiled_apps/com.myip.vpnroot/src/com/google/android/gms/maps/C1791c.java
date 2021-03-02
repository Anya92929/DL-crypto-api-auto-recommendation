package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* renamed from: com.google.android.gms.maps.c */
public class C1791c implements Parcelable.Creator<StreetViewPanoramaOptions> {
    /* renamed from: a */
    static void m6316a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        C0354b.m927a(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        C0354b.m923a(parcel, 4, (Parcelable) streetViewPanoramaOptions.getPosition(), i, false);
        C0354b.m925a(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        C0354b.m916a(parcel, 6, streetViewPanoramaOptions.mo10451mC());
        C0354b.m916a(parcel, 7, streetViewPanoramaOptions.mo10455mu());
        C0354b.m916a(parcel, 8, streetViewPanoramaOptions.mo10452mD());
        C0354b.m916a(parcel, 9, streetViewPanoramaOptions.mo10453mE());
        C0354b.m916a(parcel, 10, streetViewPanoramaOptions.mo10454mq());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cH */
    public StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        Integer num = null;
        byte b = 0;
        int C = C0352a.m875C(parcel);
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) C0352a.m880a(parcel, B, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    latLng = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    break;
                case 5:
                    num = C0352a.m893h(parcel, B);
                    break;
                case 6:
                    b5 = C0352a.m890e(parcel, B);
                    break;
                case 7:
                    b4 = C0352a.m890e(parcel, B);
                    break;
                case 8:
                    b3 = C0352a.m890e(parcel, B);
                    break;
                case 9:
                    b2 = C0352a.m890e(parcel, B);
                    break;
                case 10:
                    b = C0352a.m890e(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ew */
    public StreetViewPanoramaOptions[] newArray(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
