package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0422dw;
import com.google.android.gms.internal.C0427dz;

/* renamed from: com.google.android.gms.internal.dy */
public class C0426dy implements Parcelable.Creator<C0427dz.C0429b> {
    /* renamed from: a */
    static void m1020a(C0427dz.C0429b bVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, bVar.versionCode);
        C0155b.m349a(parcel, 2, bVar.f1169lN, false);
        C0155b.m348a(parcel, 3, (Parcelable) bVar.f1170lO, i, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: D */
    public C0427dz.C0429b[] newArray(int i) {
        return new C0427dz.C0429b[i];
    }

    /* renamed from: p */
    public C0427dz.C0429b createFromParcel(Parcel parcel) {
        C0422dw.C0423a aVar = null;
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
                    aVar = (C0422dw.C0423a) C0153a.m305a(parcel, i2, C0422dw.C0423a.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0427dz.C0429b(i, str, aVar);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
