package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.plus.internal.f */
public class C1964f implements Parcelable.Creator<PlusCommonExtras> {
    /* renamed from: a */
    static void m6645a(PlusCommonExtras plusCommonExtras, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, plusCommonExtras.mo11308nc(), false);
        C0354b.m939c(parcel, 1000, plusCommonExtras.getVersionCode());
        C0354b.m927a(parcel, 2, plusCommonExtras.mo11309nd(), false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cZ */
    public PlusCommonExtras createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 2:
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
            return new PlusCommonExtras(i, str2, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eQ */
    public PlusCommonExtras[] newArray(int i) {
        return new PlusCommonExtras[i];
    }
}
