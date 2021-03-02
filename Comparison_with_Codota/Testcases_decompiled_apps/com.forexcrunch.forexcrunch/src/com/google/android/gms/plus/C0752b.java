package com.google.android.gms.plus;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;

/* renamed from: com.google.android.gms.plus.b */
public class C0752b implements Parcelable.Creator<C0751a> {
    /* renamed from: a */
    static void m2131a(C0751a aVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        C0359b.m672a(parcel, 1, aVar.getAccountName(), false);
        C0359b.m682c(parcel, 1000, aVar.mo6371i());
        C0359b.m678a(parcel, 2, aVar.mo6365by(), false);
        C0359b.m678a(parcel, 3, aVar.mo6366bz(), false);
        C0359b.m678a(parcel, 4, aVar.mo6361bA(), false);
        C0359b.m672a(parcel, 5, aVar.mo6362bB(), false);
        C0359b.m672a(parcel, 6, aVar.mo6363bC(), false);
        C0359b.m672a(parcel, 7, aVar.mo6364bD(), false);
        C0359b.m663C(parcel, d);
    }

    /* renamed from: U */
    public C0751a[] newArray(int i) {
        return new C0751a[i];
    }

    /* renamed from: u */
    public C0751a createFromParcel(Parcel parcel) {
        String str = null;
        int c = C0357a.m634c(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str4 = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    str4 = C0357a.m645l(parcel, b);
                    break;
                case 2:
                    strArr3 = C0357a.m657w(parcel, b);
                    break;
                case 3:
                    strArr2 = C0357a.m657w(parcel, b);
                    break;
                case 4:
                    strArr = C0357a.m657w(parcel, b);
                    break;
                case 5:
                    str3 = C0357a.m645l(parcel, b);
                    break;
                case 6:
                    str2 = C0357a.m645l(parcel, b);
                    break;
                case 7:
                    str = C0357a.m645l(parcel, b);
                    break;
                case 1000:
                    i = C0357a.m639f(parcel, b);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0751a(i, str4, strArr3, strArr2, strArr, str3, str2, str);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }
}
