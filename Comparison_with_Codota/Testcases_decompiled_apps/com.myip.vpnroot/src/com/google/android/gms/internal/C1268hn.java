package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.internal.C1265hm;

/* renamed from: com.google.android.gms.internal.hn */
public class C1268hn implements Parcelable.Creator<C1265hm.C1266a> {
    /* renamed from: a */
    static void m4776a(C1265hm.C1266a aVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) aVar.f3858Cj, i, false);
        C0354b.m939c(parcel, 1000, aVar.f3857BR);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: M */
    public C1265hm.C1266a[] newArray(int i) {
        return new C1265hm.C1266a[i];
    }

    /* renamed from: p */
    public C1265hm.C1266a createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        Account account = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    account = (Account) C0352a.m880a(parcel, B, Account.CREATOR);
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
            return new C1265hm.C1266a(i, account);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
