package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.signin.internal.l */
public class C1261l implements Parcelable.Creator<RecordConsentRequest> {
    /* renamed from: a */
    static void m5230a(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, recordConsentRequest.f5280a);
        C1031c.m4614a(parcel, 2, (Parcelable) recordConsentRequest.mo9028a(), i, false);
        C1031c.m4621a(parcel, 3, (T[]) recordConsentRequest.mo9029b(), i, false);
        C1031c.m4616a(parcel, 4, recordConsentRequest.mo9030c(), false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public RecordConsentRequest createFromParcel(Parcel parcel) {
        String k;
        Scope[] scopeArr;
        Account account;
        int i;
        String str = null;
        int b = C1029a.m4587b(parcel);
        int i2 = 0;
        Scope[] scopeArr2 = null;
        Account account2 = null;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    String str2 = str;
                    scopeArr = scopeArr2;
                    account = account2;
                    i = C1029a.m4594f(parcel, a);
                    k = str2;
                    break;
                case 2:
                    i = i2;
                    Scope[] scopeArr3 = scopeArr2;
                    account = (Account) C1029a.m4583a(parcel, a, Account.CREATOR);
                    k = str;
                    scopeArr = scopeArr3;
                    break;
                case 3:
                    account = account2;
                    i = i2;
                    String str3 = str;
                    scopeArr = (Scope[]) C1029a.m4589b(parcel, a, Scope.CREATOR);
                    k = str3;
                    break;
                case 4:
                    k = C1029a.m4599k(parcel, a);
                    scopeArr = scopeArr2;
                    account = account2;
                    i = i2;
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    k = str;
                    scopeArr = scopeArr2;
                    account = account2;
                    i = i2;
                    break;
            }
            i2 = i;
            account2 = account;
            scopeArr2 = scopeArr;
            str = k;
        }
        if (parcel.dataPosition() == b) {
            return new RecordConsentRequest(i2, account2, scopeArr2, str);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public RecordConsentRequest[] newArray(int i) {
        return new RecordConsentRequest[i];
    }
}
