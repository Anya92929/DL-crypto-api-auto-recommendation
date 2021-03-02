package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;

/* renamed from: com.google.android.gms.common.stats.a */
public class C1092a implements Parcelable.Creator<ConnectionEvent> {
    /* renamed from: a */
    static void m4758a(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, connectionEvent.f4812a);
        C1031c.m4611a(parcel, 2, connectionEvent.mo7672a());
        C1031c.m4616a(parcel, 4, connectionEvent.mo7674c(), false);
        C1031c.m4616a(parcel, 5, connectionEvent.mo7675d(), false);
        C1031c.m4616a(parcel, 6, connectionEvent.mo7677e(), false);
        C1031c.m4616a(parcel, 7, connectionEvent.mo7678f(), false);
        C1031c.m4616a(parcel, 8, connectionEvent.mo7679g(), false);
        C1031c.m4611a(parcel, 10, connectionEvent.mo7682j());
        C1031c.m4611a(parcel, 11, connectionEvent.mo7681i());
        C1031c.m4610a(parcel, 12, connectionEvent.mo7673b());
        C1031c.m4616a(parcel, 13, connectionEvent.mo7680h(), false);
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public ConnectionEvent createFromParcel(Parcel parcel) {
        int b = C1029a.m4587b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1029a.m4581a(parcel);
            switch (C1029a.m4580a(a)) {
                case 1:
                    i = C1029a.m4594f(parcel, a);
                    break;
                case 2:
                    j = C1029a.m4596h(parcel, a);
                    break;
                case 4:
                    str = C1029a.m4599k(parcel, a);
                    break;
                case 5:
                    str2 = C1029a.m4599k(parcel, a);
                    break;
                case 6:
                    str3 = C1029a.m4599k(parcel, a);
                    break;
                case 7:
                    str4 = C1029a.m4599k(parcel, a);
                    break;
                case 8:
                    str5 = C1029a.m4599k(parcel, a);
                    break;
                case 10:
                    j2 = C1029a.m4596h(parcel, a);
                    break;
                case 11:
                    j3 = C1029a.m4596h(parcel, a);
                    break;
                case 12:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                case 13:
                    str6 = C1029a.m4599k(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public ConnectionEvent[] newArray(int i) {
        return new ConnectionEvent[i];
    }
}
