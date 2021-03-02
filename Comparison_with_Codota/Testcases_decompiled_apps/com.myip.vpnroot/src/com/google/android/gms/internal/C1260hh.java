package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.hh */
public class C1260hh implements Parcelable.Creator<C1259hg> {
    /* renamed from: a */
    static void m4766a(C1259hg hgVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, hgVar.f3844BZ, false);
        C0354b.m939c(parcel, 1000, hgVar.f3843BR);
        C0354b.m927a(parcel, 2, hgVar.f3845Ca, false);
        C0354b.m927a(parcel, 3, hgVar.f3846Cb, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: J */
    public C1259hg[] newArray(int i) {
        return new C1259hg[i];
    }

    /* renamed from: m */
    public C1259hg createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 1000:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1259hg(i, str3, str2, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
