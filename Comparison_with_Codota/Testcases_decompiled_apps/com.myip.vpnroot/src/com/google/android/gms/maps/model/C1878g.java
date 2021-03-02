package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.g */
public class C1878g implements Parcelable.Creator<LatLngBounds> {
    /* renamed from: a */
    static void m6426a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, latLngBounds.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) latLngBounds.southwest, i, false);
        C0354b.m923a(parcel, 3, (Parcelable) latLngBounds.northeast, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cL */
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        int i;
        LatLng latLng3 = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    LatLng latLng5 = latLng3;
                    latLng2 = latLng4;
                    i = C0352a.m892g(parcel, B);
                    latLng = latLng5;
                    break;
                case 2:
                    i = i2;
                    LatLng latLng6 = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    latLng = latLng3;
                    latLng2 = latLng6;
                    break;
                case 3:
                    latLng = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    latLng2 = latLng4;
                    i = i2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    latLng = latLng3;
                    latLng2 = latLng4;
                    i = i2;
                    break;
            }
            i2 = i;
            latLng4 = latLng2;
            latLng3 = latLng;
        }
        if (parcel.dataPosition() == C) {
            return new LatLngBounds(i2, latLng4, latLng3);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eA */
    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
