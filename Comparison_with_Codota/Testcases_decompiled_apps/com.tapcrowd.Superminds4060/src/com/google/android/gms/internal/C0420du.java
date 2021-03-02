package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0418dt;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.du */
public class C0420du implements Parcelable.Creator<C0418dt> {
    /* renamed from: a */
    static void m973a(C0418dt dtVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, dtVar.getVersionCode());
        C0155b.m358b(parcel, 2, dtVar.mo4409bm(), false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: A */
    public C0418dt[] newArray(int i) {
        return new C0418dt[i];
    }

    /* renamed from: m */
    public C0418dt createFromParcel(Parcel parcel) {
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
                    arrayList = C0153a.m310c(parcel, i2, C0418dt.C0419a.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0418dt(i, arrayList);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }
}
