package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.common.internal.bg */
public class C1010bg implements Parcelable.Creator<ResolveAccountRequest> {
    /* renamed from: a */
    static void m4539a(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, resolveAccountRequest.f4661a);
        C1031c.m4614a(parcel, 2, (Parcelable) resolveAccountRequest.mo7480a(), i, false);
        C1031c.m4610a(parcel, 3, resolveAccountRequest.mo7481b());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public ResolveAccountRequest createFromParcel(Parcel parcel) {
        int f;
        Account account;
        int i;
        int i2 = 0;
        int b = C1029a.m4587b(parcel);
        Account account2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    int i4 = i2;
                    account = account2;
                    i = C1029a.m4594f(parcel, a);
                    f = i4;
                    break;
                case 2:
                    i = i3;
                    Account account3 = (Account) C1029a.m4583a(parcel, a, Account.CREATOR);
                    f = i2;
                    account = account3;
                    break;
                case 3:
                    f = C1029a.m4594f(parcel, a);
                    account = account2;
                    i = i3;
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    f = i2;
                    account = account2;
                    i = i3;
                    break;
            }
            i3 = i;
            account2 = account;
            i2 = f;
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountRequest(i3, account2, i2);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public ResolveAccountRequest[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
