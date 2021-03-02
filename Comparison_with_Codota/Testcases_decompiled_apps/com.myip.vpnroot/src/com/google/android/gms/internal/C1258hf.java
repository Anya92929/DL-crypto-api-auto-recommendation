package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.internal.hf */
public class C1258hf implements Parcelable.Creator<C1256he> {
    /* renamed from: a */
    static void m4763a(C1256he heVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m933a(parcel, 1, (T[]) heVar.f3836BS, i, false);
        C0354b.m939c(parcel, 1000, heVar.f3835BR);
        C0354b.m927a(parcel, 2, heVar.f3837BT, false);
        C0354b.m930a(parcel, 3, heVar.f3838BU);
        C0354b.m923a(parcel, 4, (Parcelable) heVar.account, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: I */
    public C1256he[] newArray(int i) {
        return new C1256he[i];
    }

    /* renamed from: l */
    public C1256he createFromParcel(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int C = C0352a.m875C(parcel);
        String str = null;
        C1261hi[] hiVarArr = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    hiVarArr = (C1261hi[]) C0352a.m886b(parcel, B, C1261hi.CREATOR);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 4:
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
            return new C1256he(i, hiVarArr, str, z, account);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }
}
