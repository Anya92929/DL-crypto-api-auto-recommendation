package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.di */
public class C1054di implements Parcelable.Creator<C1055dj> {
    /* renamed from: a */
    static void m4229a(C1055dj djVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, djVar.versionCode);
        C0354b.m927a(parcel, 2, djVar.f3150rp, false);
        C0354b.m927a(parcel, 3, djVar.f3151rq, false);
        C0354b.m927a(parcel, 4, djVar.mimeType, false);
        C0354b.m927a(parcel, 5, djVar.packageName, false);
        C0354b.m927a(parcel, 6, djVar.f3152rr, false);
        C0354b.m927a(parcel, 7, djVar.f3153rs, false);
        C0354b.m927a(parcel, 8, djVar.f3154rt, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: e */
    public C1055dj createFromParcel(Parcel parcel) {
        String str = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str7 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str6 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    str5 = C0352a.m900o(parcel, B);
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
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new C1055dj(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: l */
    public C1055dj[] newArray(int i) {
        return new C1055dj[i];
    }
}
