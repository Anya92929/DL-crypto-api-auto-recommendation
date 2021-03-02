package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.mh */
public class C1559mh implements Parcelable.Creator<C1558mg> {
    /* renamed from: a */
    static void m5606a(C1558mg mgVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, mgVar.mo9394ma());
        C0354b.m939c(parcel, 1000, mgVar.getVersionCode());
        C0354b.m939c(parcel, 2, mgVar.mo9395me());
        C0354b.m923a(parcel, 3, (Parcelable) mgVar.mo9396mf(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cy */
    public C1558mg createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        int i2 = -1;
        C1560mi miVar = null;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    miVar = (C1560mi) C0352a.m880a(parcel, B, C1560mi.CREATOR);
                    break;
                case 1000:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1558mg(i3, i, i2, miVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: en */
    public C1558mg[] newArray(int i) {
        return new C1558mg[i];
    }
}
