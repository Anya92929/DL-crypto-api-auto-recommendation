package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.i */
public class C1880i implements Parcelable.Creator<LatLng> {
    /* renamed from: a */
    static void m6430a(LatLng latLng, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, latLng.getVersionCode());
        C0354b.m917a(parcel, 2, latLng.latitude);
        C0354b.m917a(parcel, 3, latLng.longitude);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cM */
    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int C = C0352a.m875C(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    d2 = C0352a.m898m(parcel, B);
                    break;
                case 3:
                    d = C0352a.m898m(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new LatLng(i, d2, d);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eB */
    public LatLng[] newArray(int i) {
        return new LatLng[i];
    }
}
