package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.internal.ds */
public class C0417ds implements Parcelable.Creator<C0416dr> {
    /* renamed from: a */
    static void m963a(C0416dr drVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, drVar.getVersionCode());
        C0155b.m348a(parcel, 2, (Parcelable) drVar.mo4399bk(), i, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: l */
    public C0416dr createFromParcel(Parcel parcel) {
        int j = C0153a.m320j(parcel);
        int i = 0;
        C0418dt dtVar = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    dtVar = (C0418dt) C0153a.m305a(parcel, i2, C0418dt.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0416dr(i, dtVar);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: z */
    public C0416dr[] newArray(int i) {
        return new C0416dr[i];
    }
}
