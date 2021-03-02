package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.location.internal.c */
public class C1123c implements Parcelable.Creator<ClientIdentity> {
    /* renamed from: a */
    static void m4876a(ClientIdentity clientIdentity, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, clientIdentity.f4939a);
        C1031c.m4610a(parcel, 1000, clientIdentity.mo7804a());
        C1031c.m4616a(parcel, 2, clientIdentity.f4940b, false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public ClientIdentity createFromParcel(Parcel parcel) {
        int i = 0;
        int b = C1029a.m4587b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    str = C1029a.m4599k(parcel, a);
                    break;
                case 1000:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ClientIdentity(i2, i, str);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public ClientIdentity[] newArray(int i) {
        return new ClientIdentity[i];
    }
}
