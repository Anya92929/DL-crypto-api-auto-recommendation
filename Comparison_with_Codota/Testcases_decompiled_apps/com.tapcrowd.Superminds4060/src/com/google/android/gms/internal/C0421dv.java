package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0418dt;

/* renamed from: com.google.android.gms.internal.dv */
public class C0421dv implements Parcelable.Creator<C0418dt.C0419a> {
    /* renamed from: a */
    static void m976a(C0418dt.C0419a aVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, aVar.versionCode);
        C0155b.m349a(parcel, 2, aVar.f1151lx, false);
        C0155b.m359c(parcel, 3, aVar.f1152ly);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: B */
    public C0418dt.C0419a[] newArray(int i) {
        return new C0418dt.C0419a[i];
    }

    /* renamed from: n */
    public C0418dt.C0419a createFromParcel(Parcel parcel) {
        int i = 0;
        int j = C0153a.m320j(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i3)) {
                case 1:
                    i2 = C0153a.m314f(parcel, i3);
                    break;
                case 2:
                    str = C0153a.m322l(parcel, i3);
                    break;
                case 3:
                    i = C0153a.m314f(parcel, i3);
                    break;
                default:
                    C0153a.m308b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0418dt.C0419a(i2, str, i);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
