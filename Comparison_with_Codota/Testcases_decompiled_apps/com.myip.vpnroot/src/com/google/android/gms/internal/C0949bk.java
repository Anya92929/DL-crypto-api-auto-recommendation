package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.bk */
public class C0949bk implements Parcelable.Creator<C0948bj> {
    /* renamed from: a */
    static void m3984a(C0948bj bjVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, bjVar.versionCode);
        C0354b.m939c(parcel, 2, bjVar.f2890oH);
        C0354b.m939c(parcel, 3, bjVar.backgroundColor);
        C0354b.m939c(parcel, 4, bjVar.f2891oI);
        C0354b.m939c(parcel, 5, bjVar.f2892oJ);
        C0354b.m939c(parcel, 6, bjVar.f2893oK);
        C0354b.m939c(parcel, 7, bjVar.f2894oL);
        C0354b.m939c(parcel, 8, bjVar.f2895oM);
        C0354b.m939c(parcel, 9, bjVar.f2896oN);
        C0354b.m927a(parcel, 10, bjVar.f2897oO, false);
        C0354b.m939c(parcel, 11, bjVar.f2898oP);
        C0354b.m927a(parcel, 12, bjVar.f2899oQ, false);
        C0354b.m939c(parcel, 13, bjVar.f2900oR);
        C0354b.m939c(parcel, 14, bjVar.f2901oS);
        C0354b.m927a(parcel, 15, bjVar.f2902oT, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: d */
    public C0948bj createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    i5 = C0352a.m892g(parcel, B);
                    break;
                case 6:
                    i6 = C0352a.m892g(parcel, B);
                    break;
                case 7:
                    i7 = C0352a.m892g(parcel, B);
                    break;
                case 8:
                    i8 = C0352a.m892g(parcel, B);
                    break;
                case 9:
                    i9 = C0352a.m892g(parcel, B);
                    break;
                case 10:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 11:
                    i10 = C0352a.m892g(parcel, B);
                    break;
                case 12:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 13:
                    i11 = C0352a.m892g(parcel, B);
                    break;
                case 14:
                    i12 = C0352a.m892g(parcel, B);
                    break;
                case 15:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C0948bj(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: h */
    public C0948bj[] newArray(int i) {
        return new C0948bj[i];
    }
}
