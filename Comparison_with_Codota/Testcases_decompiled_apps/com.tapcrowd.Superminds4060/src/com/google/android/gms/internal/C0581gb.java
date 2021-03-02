package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0563fv;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.gb */
public class C0581gb implements Parcelable.Creator<C0563fv.C0568c> {
    /* renamed from: a */
    static void m1815a(C0563fv.C0568c cVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        Set<Integer> di = cVar.mo5146di();
        if (di.contains(1)) {
            C0155b.m359c(parcel, 1, cVar.getVersionCode());
        }
        if (di.contains(2)) {
            C0155b.m349a(parcel, 2, cVar.getUrl(), true);
        }
        C0155b.m340C(parcel, k);
    }

    /* renamed from: I */
    public C0563fv.C0568c createFromParcel(Parcel parcel) {
        int j = C0153a.m320j(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    hashSet.add(1);
                    break;
                case 2:
                    str = C0153a.m322l(parcel, i2);
                    hashSet.add(2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0563fv.C0568c(hashSet, i, str);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: an */
    public C0563fv.C0568c[] newArray(int i) {
        return new C0563fv.C0568c[i];
    }
}
