package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.common.internal.e */
public class C1014e implements Parcelable.Creator<AuthAccountRequest> {
    /* renamed from: a */
    static void m4552a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, authAccountRequest.f4649a);
        C1031c.m4613a(parcel, 2, authAccountRequest.f4650b, false);
        C1031c.m4621a(parcel, 3, (T[]) authAccountRequest.f4651c, i, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public AuthAccountRequest createFromParcel(Parcel parcel) {
        Scope[] scopeArr = null;
        int b = C1029a.m4587b(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    iBinder = C1029a.m4600l(parcel, a);
                    break;
                case 3:
                    scopeArr = (Scope[]) C1029a.m4589b(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountRequest(i, iBinder, scopeArr);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public AuthAccountRequest[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
