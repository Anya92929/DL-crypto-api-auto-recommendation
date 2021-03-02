package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.ht */
public class C1275ht implements Parcelable.Creator<C1274hs> {
    /* renamed from: a */
    static void m4802a(C1274hs hsVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) hsVar.f3881CD, i, false);
        C0354b.m939c(parcel, 1000, hsVar.f3880BR);
        C0354b.m919a(parcel, 2, hsVar.f3882CE);
        C0354b.m939c(parcel, 3, hsVar.f3883CF);
        C0354b.m927a(parcel, 4, hsVar.f3885oT, false);
        C0354b.m923a(parcel, 5, (Parcelable) hsVar.f3884CG, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: R */
    public C1274hs[] newArray(int i) {
        return new C1274hs[i];
    }

    /* renamed from: s */
    public C1274hs createFromParcel(Parcel parcel) {
        int i = 0;
        C1256he heVar = null;
        int C = C0352a.m875C(parcel);
        long j = 0;
        String str = null;
        C1259hg hgVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    hgVar = (C1259hg) C0352a.m880a(parcel, B, C1259hg.CREATOR);
                    break;
                case 2:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    heVar = (C1256he) C0352a.m880a(parcel, B, C1256he.CREATOR);
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
            return new C1274hs(i2, hgVar, j, i, str, heVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
