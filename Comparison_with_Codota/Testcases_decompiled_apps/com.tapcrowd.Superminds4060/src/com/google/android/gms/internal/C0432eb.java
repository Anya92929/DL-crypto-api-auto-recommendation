package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0427dz;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.eb */
public class C0432eb implements Parcelable.Creator<C0427dz.C0428a> {
    /* renamed from: a */
    static void m1049a(C0427dz.C0428a aVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, aVar.versionCode);
        C0155b.m349a(parcel, 2, aVar.className, false);
        C0155b.m358b(parcel, 3, aVar.f1168lM, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: F */
    public C0427dz.C0428a[] newArray(int i) {
        return new C0427dz.C0428a[i];
    }

    /* renamed from: r */
    public C0427dz.C0428a createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    str = C0153a.m322l(parcel, i2);
                    break;
                case 3:
                    arrayList = C0153a.m310c(parcel, i2, C0427dz.C0429b.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0427dz.C0428a(i, str, arrayList);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
