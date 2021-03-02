package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0427dz;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ea */
public class C0431ea implements Parcelable.Creator<C0427dz> {
    /* renamed from: a */
    static void m1046a(C0427dz dzVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, dzVar.getVersionCode());
        C0155b.m358b(parcel, 2, dzVar.mo4469bE(), false);
        C0155b.m349a(parcel, 3, dzVar.mo4470bF(), false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: E */
    public C0427dz[] newArray(int i) {
        return new C0427dz[i];
    }

    /* renamed from: q */
    public C0427dz createFromParcel(Parcel parcel) {
        String str = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    arrayList = C0153a.m310c(parcel, i2, C0427dz.C0428a.CREATOR);
                    break;
                case 3:
                    str = C0153a.m322l(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0427dz(i, arrayList, str);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
