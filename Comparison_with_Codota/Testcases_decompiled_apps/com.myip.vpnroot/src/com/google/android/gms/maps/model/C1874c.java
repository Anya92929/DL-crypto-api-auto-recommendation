package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.c */
public class C1874c implements Parcelable.Creator<CircleOptions> {
    /* renamed from: a */
    static void m6418a(CircleOptions circleOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, circleOptions.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) circleOptions.getCenter(), i, false);
        C0354b.m917a(parcel, 3, circleOptions.getRadius());
        C0354b.m918a(parcel, 4, circleOptions.getStrokeWidth());
        C0354b.m939c(parcel, 5, circleOptions.getStrokeColor());
        C0354b.m939c(parcel, 6, circleOptions.getFillColor());
        C0354b.m918a(parcel, 7, circleOptions.getZIndex());
        C0354b.m930a(parcel, 8, circleOptions.isVisible());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cJ */
    public CircleOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int C = C0352a.m875C(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    latLng = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    break;
                case 3:
                    d = C0352a.m898m(parcel, B);
                    break;
                case 4:
                    f2 = C0352a.m897l(parcel, B);
                    break;
                case 5:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 6:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 7:
                    f = C0352a.m897l(parcel, B);
                    break;
                case 8:
                    z = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ey */
    public CircleOptions[] newArray(int i) {
        return new CircleOptions[i];
    }
}
