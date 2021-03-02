package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wearable.internal.ar */
public class C2264ar implements Parcelable.Creator<C2263aq> {
    /* renamed from: a */
    static void m7630a(C2263aq aqVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, aqVar.f4678BR);
        C0354b.m921a(parcel, 2, aqVar.mo12421pT(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: eg */
    public C2263aq createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    iBinder = C0352a.m901p(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2263aq(i, iBinder);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: gi */
    public C2263aq[] newArray(int i) {
        return new C2263aq[i];
    }
}
