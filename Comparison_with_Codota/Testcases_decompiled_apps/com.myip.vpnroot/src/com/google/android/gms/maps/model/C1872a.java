package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.maps.model.a */
public class C1872a implements Parcelable.Creator<CameraPosition> {
    /* renamed from: a */
    static void m6414a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, cameraPosition.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) cameraPosition.target, i, false);
        C0354b.m918a(parcel, 3, cameraPosition.zoom);
        C0354b.m918a(parcel, 4, cameraPosition.tilt);
        C0354b.m918a(parcel, 5, cameraPosition.bearing);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cI */
    public CameraPosition createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int C = C0352a.m875C(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    latLng = (LatLng) C0352a.m880a(parcel, B, LatLng.CREATOR);
                    break;
                case 3:
                    f3 = C0352a.m897l(parcel, B);
                    break;
                case 4:
                    f2 = C0352a.m897l(parcel, B);
                    break;
                case 5:
                    f = C0352a.m897l(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: ex */
    public CameraPosition[] newArray(int i) {
        return new CameraPosition[i];
    }
}
