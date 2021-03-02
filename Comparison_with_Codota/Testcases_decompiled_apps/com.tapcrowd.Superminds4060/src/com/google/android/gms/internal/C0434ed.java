package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.internal.ed */
public class C0434ed implements Parcelable.Creator<C0433ec> {
    /* renamed from: a */
    static void m1069a(C0433ec ecVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, ecVar.getVersionCode());
        C0155b.m347a(parcel, 2, ecVar.mo4494bH(), false);
        C0155b.m348a(parcel, 3, (Parcelable) ecVar.mo4495bI(), i, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: G */
    public C0433ec[] newArray(int i) {
        return new C0433ec[i];
    }

    /* renamed from: s */
    public C0433ec createFromParcel(Parcel parcel) {
        C0427dz dzVar = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    parcel2 = C0153a.m336y(parcel, i2);
                    break;
                case 3:
                    dzVar = (C0427dz) C0153a.m305a(parcel, i2, C0427dz.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0433ec(i, parcel2, dzVar);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
