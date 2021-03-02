package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.jc */
public class C1362jc implements Parcelable.Creator<C1361jb> {
    /* renamed from: a */
    static void m5099a(C1361jb jbVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, jbVar.f4100BR);
        C0354b.m927a(parcel, 2, jbVar.f4101Mi, false);
        C0354b.m939c(parcel, 3, jbVar.f4102Mj);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: E */
    public C1361jb createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1361jb(i2, str, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: aE */
    public C1361jb[] newArray(int i) {
        return new C1361jb[i];
    }
}
