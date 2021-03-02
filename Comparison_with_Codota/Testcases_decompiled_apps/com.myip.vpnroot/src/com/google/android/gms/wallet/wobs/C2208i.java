package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wallet.wobs.i */
public class C2208i implements Parcelable.Creator<C2205f> {
    /* renamed from: a */
    static void m7435a(C2205f fVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, fVar.getVersionCode());
        C0354b.m927a(parcel, 2, fVar.label, false);
        C0354b.m923a(parcel, 3, (Parcelable) fVar.aur, i, false);
        C0354b.m927a(parcel, 4, fVar.type, false);
        C0354b.m923a(parcel, 5, (Parcelable) fVar.asR, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dK */
    public C2205f createFromParcel(Parcel parcel) {
        C2211l lVar = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        C2206g gVar = null;
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
                    gVar = (C2206g) C0352a.m880a(parcel, B, C2206g.CREATOR);
                    break;
                case 4:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    lVar = (C2211l) C0352a.m880a(parcel, B, C2211l.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C2205f(i, str2, gVar, str, lVar);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fM */
    public C2205f[] newArray(int i) {
        return new C2205f[i];
    }
}
