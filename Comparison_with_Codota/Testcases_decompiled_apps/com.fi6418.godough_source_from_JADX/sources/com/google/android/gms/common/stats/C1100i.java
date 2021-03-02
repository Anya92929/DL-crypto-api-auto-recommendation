package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C1029a;
import com.google.android.gms.common.internal.safeparcel.C1030b;
import com.google.android.gms.common.internal.safeparcel.C1031c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.stats.i */
public class C1100i implements Parcelable.Creator<WakeLockEvent> {
    /* renamed from: a */
    static void m4777a(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int a = C1031c.m4605a(parcel);
        C1031c.m4610a(parcel, 1, wakeLockEvent.f4824a);
        C1031c.m4611a(parcel, 2, wakeLockEvent.mo7684a());
        C1031c.m4616a(parcel, 4, wakeLockEvent.mo7686c(), false);
        C1031c.m4610a(parcel, 5, wakeLockEvent.mo7689e());
        C1031c.m4625b(parcel, 6, wakeLockEvent.mo7690f(), false);
        C1031c.m4611a(parcel, 8, wakeLockEvent.mo7692h());
        C1031c.m4616a(parcel, 10, wakeLockEvent.mo7687d(), false);
        C1031c.m4610a(parcel, 11, wakeLockEvent.mo7685b());
        C1031c.m4616a(parcel, 12, wakeLockEvent.mo7691g(), false);
        C1031c.m4616a(parcel, 13, wakeLockEvent.mo7694j(), false);
        C1031c.m4610a(parcel, 14, wakeLockEvent.mo7693i());
        C1031c.m4609a(parcel, 15, wakeLockEvent.mo7695k());
        C1031c.m4606a(parcel, a);
    }

    /* renamed from: a */
    public WakeLockEvent createFromParcel(Parcel parcel) {
        int b = C1029a.m4587b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        ArrayList<String> arrayList = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = BitmapDescriptorFactory.HUE_RED;
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
                    i3 = C1029a.m4594f(parcel, a);
                    break;
                case 6:
                    arrayList = C1029a.m4604p(parcel, a);
                    break;
                case 8:
                    j2 = C1029a.m4596h(parcel, a);
                    break;
                case 10:
                    str3 = C1029a.m4599k(parcel, a);
                    break;
                case 11:
                    i2 = C1029a.m4594f(parcel, a);
                    break;
                case 12:
                    str2 = C1029a.m4599k(parcel, a);
                    break;
                case 13:
                    str4 = C1029a.m4599k(parcel, a);
                    break;
                case 14:
                    i4 = C1029a.m4594f(parcel, a);
                    break;
                case 15:
                    f = C1029a.m4597i(parcel, a);
                    break;
                default:
                    C1029a.m4588b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f);
        }
        throw new C1030b("Overread allowed size end=" + b, parcel);
    }

    /* renamed from: a */
    public WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
