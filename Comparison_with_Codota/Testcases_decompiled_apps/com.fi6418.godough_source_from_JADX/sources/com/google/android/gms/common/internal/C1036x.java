package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.common.internal.x */
public class C1036x implements Parcelable.Creator<GetServiceRequest> {
    /* renamed from: a */
    static void m4643a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, getServiceRequest.f4653a);
        C1031c.m4610a(parcel, 2, getServiceRequest.f4654b);
        C1031c.m4610a(parcel, 3, getServiceRequest.f4655c);
        C1031c.m4616a(parcel, 4, getServiceRequest.f4656d, false);
        C1031c.m4613a(parcel, 5, getServiceRequest.f4657e, false);
        C1031c.m4621a(parcel, 6, (T[]) getServiceRequest.f4658f, i, false);
        C1031c.m4612a(parcel, 7, getServiceRequest.f4659g, false);
        C1031c.m4614a(parcel, 8, (Parcelable) getServiceRequest.f4660h, i, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public GetServiceRequest createFromParcel(Parcel parcel) {
        int i = 0;
        Account account = null;
        int b = C1029a.m4587b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i3 = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                case 3:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 4:
                    str = C1029a.m4599k(parcel, a);
                    break;
                case 5:
                    iBinder = C1029a.m4600l(parcel, a);
                    break;
                case 6:
                    scopeArr = (Scope[]) C1029a.m4589b(parcel, a, Scope.CREATOR);
                    break;
                case 7:
                    bundle = C1029a.m4601m(parcel, a);
                    break;
                case 8:
                    account = (Account) C1029a.m4583a(parcel, a, Account.CREATOR);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
