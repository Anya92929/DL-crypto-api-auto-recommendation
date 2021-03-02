package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wallet.wobs.q */
public class C2216q implements Parcelable.Creator<C2215p> {
    /* renamed from: a */
    static void m7447a(C2215p pVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, pVar.getVersionCode());
        C0354b.m927a(parcel, 2, pVar.auy, false);
        C0354b.m927a(parcel, 3, pVar.f4649tG, false);
        C0354b.m923a(parcel, 4, (Parcelable) pVar.auC, i, false);
        C0354b.m923a(parcel, 5, (Parcelable) pVar.auD, i, false);
        C0354b.m923a(parcel, 6, (Parcelable) pVar.auE, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dO */
    public C2215p createFromParcel(Parcel parcel) {
        C2213n nVar = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        C2213n nVar2 = null;
        C2211l lVar = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    lVar = (C2211l) C0352a.m880a(parcel, B, C2211l.CREATOR);
                    break;
                case 5:
                    nVar2 = (C2213n) C0352a.m880a(parcel, B, C2213n.CREATOR);
                    break;
                case 6:
                    nVar = (C2213n) C0352a.m880a(parcel, B, C2213n.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2215p(i, str2, str, lVar, nVar2, nVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fQ */
    public C2215p[] newArray(int i) {
        return new C2215p[i];
    }
}
