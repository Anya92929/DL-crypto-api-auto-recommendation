package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.je */
public class C1364je implements Parcelable.Creator<C1363jd> {
    /* renamed from: a */
    static void m5105a(C1363jd jdVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, jdVar.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) jdVar.mo8990ha(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: F */
    public C1363jd createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        C1365jf jfVar = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    jfVar = (C1365jf) C0352a.m880a(parcel, B, C1365jf.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1363jd(i, jfVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: aF */
    public C1363jd[] newArray(int i) {
        return new C1363jd[i];
    }
}
