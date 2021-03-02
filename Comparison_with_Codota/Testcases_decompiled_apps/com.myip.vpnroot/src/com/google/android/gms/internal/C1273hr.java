package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.hr */
public class C1273hr implements Parcelable.Creator<C1271hq> {
    /* renamed from: a */
    static void m4791a(C1271hq hqVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, hqVar.name, false);
        C0354b.m939c(parcel, 1000, hqVar.f3864BR);
        C0354b.m927a(parcel, 2, hqVar.f3865Co, false);
        C0354b.m930a(parcel, 3, hqVar.f3866Cp);
        C0354b.m939c(parcel, 4, hqVar.weight);
        C0354b.m930a(parcel, 5, hqVar.f3867Cq);
        C0354b.m927a(parcel, 6, hqVar.f3868Cr, false);
        C0354b.m933a(parcel, 7, (T[]) hqVar.f3869Cs, i, false);
        C0354b.m932a(parcel, 8, hqVar.f3870Ct, false);
        C0354b.m927a(parcel, 11, hqVar.f3871Cu, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: Q */
    public C1271hq[] newArray(int i) {
        return new C1271hq[i];
    }

    /* renamed from: r */
    public C1271hq createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 1;
        int[] iArr = null;
        C1263hk[] hkVarArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    z2 = C0352a.m888c(parcel, B);
                    break;
                case 4:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 6:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    hkVarArr = (C1263hk[]) C0352a.m886b(parcel, B, C1263hk.CREATOR);
                    break;
                case 8:
                    iArr = C0352a.m906u(parcel, B);
                    break;
                case 11:
                    str = C0352a.m900o(parcel, B);
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
            return new C1271hq(i2, str4, str3, z2, i, z, str2, hkVarArr, iArr, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
