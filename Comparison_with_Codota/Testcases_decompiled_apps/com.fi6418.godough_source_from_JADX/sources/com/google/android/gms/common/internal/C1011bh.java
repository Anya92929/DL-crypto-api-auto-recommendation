package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.common.internal.bh */
public class C1011bh implements Parcelable.Creator<ResolveAccountResponse> {
    /* renamed from: a */
    static void m4542a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, resolveAccountResponse.f4664a);
        C1031c.m4613a(parcel, 2, resolveAccountResponse.f4665b, false);
        C1031c.m4614a(parcel, 3, (Parcelable) resolveAccountResponse.mo7485b(), i, false);
        C1031c.m4619a(parcel, 4, resolveAccountResponse.mo7486c());
        C1031c.m4619a(parcel, 5, resolveAccountResponse.mo7487d());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public ResolveAccountResponse createFromParcel(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = C1029a.m4587b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
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
                    connectionResult = (ConnectionResult) C1029a.m4583a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = C1029a.m4591c(parcel, a);
                    break;
                case 5:
                    z = C1029a.m4591c(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public ResolveAccountResponse[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}
