package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0563fv;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ge */
public class C0584ge implements Parcelable.Creator<C0563fv.C0572g> {
    /* renamed from: a */
    static void m1824a(C0563fv.C0572g gVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        Set<Integer> di = gVar.mo5199di();
        if (di.contains(1)) {
            C0155b.m359c(parcel, 1, gVar.getVersionCode());
        }
        if (di.contains(2)) {
            C0155b.m352a(parcel, 2, gVar.isPrimary());
        }
        if (di.contains(3)) {
            C0155b.m349a(parcel, 3, gVar.getValue(), true);
        }
        C0155b.m340C(parcel, k);
    }

    /* renamed from: L */
    public C0563fv.C0572g createFromParcel(Parcel parcel) {
        boolean z = false;
        int j = C0153a.m320j(parcel);
        HashSet hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    hashSet.add(1);
                    break;
                case 2:
                    z = C0153a.m311c(parcel, i2);
                    hashSet.add(2);
                    break;
                case 3:
                    str = C0153a.m322l(parcel, i2);
                    hashSet.add(3);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0563fv.C0572g(hashSet, i, z, str);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: aq */
    public C0563fv.C0572g[] newArray(int i) {
        return new C0563fv.C0572g[i];
    }
}
