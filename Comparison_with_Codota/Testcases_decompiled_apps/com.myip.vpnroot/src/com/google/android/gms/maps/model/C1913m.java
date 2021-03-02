package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.model.m */
public class C1913m implements Parcelable.Creator<PolygonOptions> {
    /* renamed from: a */
    static void m6482a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, polygonOptions.getVersionCode());
        C0354b.m940c(parcel, 2, polygonOptions.getPoints(), false);
        C0354b.m941d(parcel, 3, polygonOptions.mo10931mO(), false);
        C0354b.m918a(parcel, 4, polygonOptions.getStrokeWidth());
        C0354b.m939c(parcel, 5, polygonOptions.getStrokeColor());
        C0354b.m939c(parcel, 6, polygonOptions.getFillColor());
        C0354b.m918a(parcel, 7, polygonOptions.getZIndex());
        C0354b.m930a(parcel, 8, polygonOptions.isVisible());
        C0354b.m930a(parcel, 9, polygonOptions.isGeodesic());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cO */
    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int C = C0352a.m875C(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
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
                    arrayList = C0352a.m887c(parcel, B, LatLng.CREATOR);
                    break;
                case 3:
                    C0352a.m883a(parcel, B, (List) arrayList2, getClass().getClassLoader());
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
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 9:
                    z = C0352a.m888c(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new PolygonOptions(i3, arrayList, arrayList2, f2, i2, i, f, z2, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eD */
    public PolygonOptions[] newArray(int i) {
        return new PolygonOptions[i];
    }
}
