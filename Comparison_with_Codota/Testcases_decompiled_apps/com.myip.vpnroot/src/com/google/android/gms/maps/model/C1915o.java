package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.maps.model.o */
public class C1915o implements Parcelable.Creator<PolylineOptions> {
    /* renamed from: a */
    static void m6486a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, polylineOptions.getVersionCode());
        C0354b.m940c(parcel, 2, polylineOptions.getPoints(), false);
        C0354b.m918a(parcel, 3, polylineOptions.getWidth());
        C0354b.m939c(parcel, 4, polylineOptions.getColor());
        C0354b.m918a(parcel, 5, polylineOptions.getZIndex());
        C0354b.m930a(parcel, 6, polylineOptions.isVisible());
        C0354b.m930a(parcel, 7, polylineOptions.isGeodesic());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cP */
    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int C = C0352a.m875C(parcel);
        ArrayList arrayList = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    arrayList = C0352a.m887c(parcel, B, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = C0352a.m897l(parcel, B);
                    break;
                case 4:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    f = C0352a.m897l(parcel, B);
                    break;
                case 6:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 7:
                    z = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new PolylineOptions(i2, arrayList, f2, i, f, z2, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eE */
    public PolylineOptions[] newArray(int i) {
        return new PolylineOptions[i];
    }
}
