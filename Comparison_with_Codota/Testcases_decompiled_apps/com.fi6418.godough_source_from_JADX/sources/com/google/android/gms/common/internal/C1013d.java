package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.common.internal.d */
public class C1013d implements Parcelable.Creator<ValidateAccountRequest> {
    /* renamed from: a */
    static void m4549a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, validateAccountRequest.f4669a);
        C1031c.m4610a(parcel, 2, validateAccountRequest.mo7491a());
        C1031c.m4613a(parcel, 3, validateAccountRequest.f4670b, false);
        C1031c.m4621a(parcel, 4, (T[]) validateAccountRequest.mo7492b(), i, false);
        C1031c.m4612a(parcel, 5, validateAccountRequest.mo7494d(), false);
        C1031c.m4616a(parcel, 6, validateAccountRequest.mo7493c(), false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public ValidateAccountRequest createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = C1029a.m4587b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 3:
                    iBinder = C1029a.m4600l(parcel, a);
                    break;
                case 4:
                    scopeArr = (Scope[]) C1029a.m4589b(parcel, a, Scope.CREATOR);
                    break;
                case 5:
                    bundle = C1029a.m4601m(parcel, a);
                    break;
                case 6:
                    str = C1029a.m4599k(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public ValidateAccountRequest[] newArray(int i) {
        return new ValidateAccountRequest[i];
    }
}
