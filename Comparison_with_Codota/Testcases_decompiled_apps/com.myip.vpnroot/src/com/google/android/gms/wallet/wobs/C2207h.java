package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wallet.wobs.h */
public class C2207h implements Parcelable.Creator<C2206g> {
    /* renamed from: a */
    static void m7432a(C2206g gVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, gVar.getVersionCode());
        C0354b.m939c(parcel, 2, gVar.aus);
        C0354b.m927a(parcel, 3, gVar.aut, false);
        C0354b.m917a(parcel, 4, gVar.auu);
        C0354b.m927a(parcel, 5, gVar.auv, false);
        C0354b.m919a(parcel, 6, gVar.auw);
        C0354b.m939c(parcel, 7, gVar.aux);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dJ */
    public C2206g createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int C = C0352a.m875C(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    d = C0352a.m898m(parcel, B);
                    break;
                case 5:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 7:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2206g(i3, i, str2, d, str, j, i2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fL */
    public C2206g[] newArray(int i) {
        return new C2206g[i];
    }
}
