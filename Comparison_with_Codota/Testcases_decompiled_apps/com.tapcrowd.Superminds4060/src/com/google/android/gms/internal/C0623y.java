package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.internal.y */
public class C0623y implements Parcelable.Creator<C0622x> {
    /* renamed from: a */
    static void m1961a(C0622x xVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, xVar.versionCode);
        C0155b.m349a(parcel, 2, xVar.f1581ew, false);
        C0155b.m359c(parcel, 3, xVar.height);
        C0155b.m359c(parcel, 4, xVar.heightPixels);
        C0155b.m352a(parcel, 5, xVar.f1582ex);
        C0155b.m359c(parcel, 6, xVar.width);
        C0155b.m359c(parcel, 7, xVar.widthPixels);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: b */
    public C0622x createFromParcel(Parcel parcel) {
        int i = 0;
        int j = C0153a.m320j(parcel);
        String str = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < j) {
            int i6 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i6)) {
                case 1:
                    i5 = C0153a.m314f(parcel, i6);
                    break;
                case 2:
                    str = C0153a.m322l(parcel, i6);
                    break;
                case 3:
                    i4 = C0153a.m314f(parcel, i6);
                    break;
                case 4:
                    i3 = C0153a.m314f(parcel, i6);
                    break;
                case 5:
                    z = C0153a.m311c(parcel, i6);
                    break;
                case 6:
                    i2 = C0153a.m314f(parcel, i6);
                    break;
                case 7:
                    i = C0153a.m314f(parcel, i6);
                    break;
                default:
                    C0153a.m308b(parcel, i6);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0622x(i5, str, i4, i3, z, i2, i);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: c */
    public C0622x[] newArray(int i) {
        return new C0622x[i];
    }
}
