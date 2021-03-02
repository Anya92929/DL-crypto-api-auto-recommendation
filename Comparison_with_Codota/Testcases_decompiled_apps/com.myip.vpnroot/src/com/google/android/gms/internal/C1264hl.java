package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.hl */
public class C1264hl implements Parcelable.Creator<C1263hk> {
    /* renamed from: a */
    static void m4773a(C1263hk hkVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, hkVar.f3856id);
        C0354b.m939c(parcel, 1000, hkVar.f3854BR);
        C0354b.m920a(parcel, 2, hkVar.f3855Ci, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: L */
    public C1263hk[] newArray(int i) {
        return new C1263hk[i];
    }

    /* renamed from: o */
    public C1263hk createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    bundle = C0352a.m902q(parcel, B);
                    break;
                case 1000:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1263hk(i2, i, bundle);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
