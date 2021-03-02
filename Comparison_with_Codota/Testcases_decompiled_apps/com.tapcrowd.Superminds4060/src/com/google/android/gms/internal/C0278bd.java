package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.internal.bd */
public class C0278bd implements Parcelable.Creator<C0279be> {
    /* renamed from: a */
    static void m561a(C0279be beVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, beVar.versionCode);
        C0155b.m349a(parcel, 2, beVar.f844fy, false);
        C0155b.m349a(parcel, 3, beVar.f845fz, false);
        C0155b.m349a(parcel, 4, beVar.mimeType, false);
        C0155b.m349a(parcel, 5, beVar.packageName, false);
        C0155b.m349a(parcel, 6, beVar.f841fA, false);
        C0155b.m349a(parcel, 7, beVar.f842fB, false);
        C0155b.m349a(parcel, 8, beVar.f843fC, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: c */
    public C0279be createFromParcel(Parcel parcel) {
        String str = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    str7 = C0153a.m322l(parcel, i2);
                    break;
                case 3:
                    str6 = C0153a.m322l(parcel, i2);
                    break;
                case 4:
                    str5 = C0153a.m322l(parcel, i2);
                    break;
                case 5:
                    str4 = C0153a.m322l(parcel, i2);
                    break;
                case 6:
                    str3 = C0153a.m322l(parcel, i2);
                    break;
                case 7:
                    str2 = C0153a.m322l(parcel, i2);
                    break;
                case 8:
                    str = C0153a.m322l(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0279be(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: g */
    public C0279be[] newArray(int i) {
        return new C0279be[i];
    }
}
