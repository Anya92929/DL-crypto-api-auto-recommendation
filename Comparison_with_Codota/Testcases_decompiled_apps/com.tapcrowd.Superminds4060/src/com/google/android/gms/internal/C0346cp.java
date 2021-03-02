package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.internal.cp */
public class C0346cp implements Parcelable.Creator<C0345co> {
    /* renamed from: a */
    static void m738a(C0345co coVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, coVar.versionCode);
        C0155b.m349a(parcel, 2, coVar.f1014hP, false);
        C0155b.m359c(parcel, 3, coVar.f1015hQ);
        C0155b.m359c(parcel, 4, coVar.f1016hR);
        C0155b.m352a(parcel, 5, coVar.f1017hS);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: g */
    public C0345co createFromParcel(Parcel parcel) {
        boolean z = false;
        int j = C0153a.m320j(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    i3 = C0153a.m314f(parcel, i4);
                    break;
                case 2:
                    str = C0153a.m322l(parcel, i4);
                    break;
                case 3:
                    i2 = C0153a.m314f(parcel, i4);
                    break;
                case 4:
                    i = C0153a.m314f(parcel, i4);
                    break;
                case 5:
                    z = C0153a.m311c(parcel, i4);
                    break;
                default:
                    C0153a.m308b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0345co(i3, str, i2, i, z);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: l */
    public C0345co[] newArray(int i) {
        return new C0345co[i];
    }
}
