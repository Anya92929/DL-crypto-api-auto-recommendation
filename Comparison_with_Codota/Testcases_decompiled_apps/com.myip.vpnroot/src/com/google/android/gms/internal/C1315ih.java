package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.ih */
public class C1315ih implements Parcelable.Creator<C1314ig> {
    /* renamed from: a */
    static void m4916a(C1314ig igVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, igVar.getVersionCode());
        C0354b.m927a(parcel, 2, igVar.mo8826fz(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ab */
    public C1314ig[] newArray(int i) {
        return new C1314ig[i];
    }

    /* renamed from: w */
    public C1314ig createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1314ig(i, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
