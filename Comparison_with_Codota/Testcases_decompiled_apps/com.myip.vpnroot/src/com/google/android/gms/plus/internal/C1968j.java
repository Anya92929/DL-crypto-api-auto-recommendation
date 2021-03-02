package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.plus.internal.j */
public class C1968j implements Parcelable.Creator<C1966h> {
    /* renamed from: a */
    static void m6665a(C1966h hVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, hVar.getAccountName(), false);
        C0354b.m939c(parcel, 1000, hVar.getVersionCode());
        C0354b.m934a(parcel, 2, hVar.mo11382ne(), false);
        C0354b.m934a(parcel, 3, hVar.mo11383nf(), false);
        C0354b.m934a(parcel, 4, hVar.mo11384ng(), false);
        C0354b.m927a(parcel, 5, hVar.mo11385nh(), false);
        C0354b.m927a(parcel, 6, hVar.mo11386ni(), false);
        C0354b.m927a(parcel, 7, hVar.mo11387nj(), false);
        C0354b.m927a(parcel, 8, hVar.mo11388nk(), false);
        C0354b.m923a(parcel, 9, (Parcelable) hVar.mo11389nl(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: da */
    public C1966h createFromParcel(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    strArr3 = C0352a.m872A(parcel, B);
                    break;
                case 3:
                    strArr2 = C0352a.m872A(parcel, B);
                    break;
                case 4:
                    strArr = C0352a.m872A(parcel, B);
                    break;
                case 5:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 8:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 9:
                    plusCommonExtras = (PlusCommonExtras) C0352a.m880a(parcel, B, PlusCommonExtras.CREATOR);
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
            return new C1966h(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: eR */
    public C1966h[] newArray(int i) {
        return new C1966h[i];
    }
}
