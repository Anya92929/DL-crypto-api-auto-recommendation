package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.common.i */
public class C0961i implements Parcelable.Creator<ConnectionResult> {
    /* renamed from: a */
    static void m4329a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, connectionResult.f4399b);
        C1031c.m4610a(parcel, 2, connectionResult.mo7324c());
        C1031c.m4614a(parcel, 3, (Parcelable) connectionResult.mo7325d(), i, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public ConnectionResult createFromParcel(Parcel parcel) {
        int i = 0;
        int b = C1029a.m4587b(parcel);
        PendingIntent pendingIntent = null;
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
                    pendingIntent = (PendingIntent) C1029a.m4583a(parcel, a, PendingIntent.CREATOR);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public ConnectionResult[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
