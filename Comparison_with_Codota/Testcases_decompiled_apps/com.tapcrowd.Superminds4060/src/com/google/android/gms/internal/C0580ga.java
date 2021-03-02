package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0563fv;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ga */
public class C0580ga implements Parcelable.Creator<C0563fv.C0565b.C0567b> {
    /* renamed from: a */
    static void m1812a(C0563fv.C0565b.C0567b bVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        Set<Integer> di = bVar.mo5133di();
        if (di.contains(1)) {
            C0155b.m359c(parcel, 1, bVar.getVersionCode());
        }
        if (di.contains(2)) {
            C0155b.m359c(parcel, 2, bVar.getHeight());
        }
        if (di.contains(3)) {
            C0155b.m349a(parcel, 3, bVar.getUrl(), true);
        }
        if (di.contains(4)) {
            C0155b.m359c(parcel, 4, bVar.getWidth());
        }
        C0155b.m340C(parcel, k);
    }

    /* renamed from: H */
    public C0563fv.C0565b.C0567b createFromParcel(Parcel parcel) {
        int i = 0;
        int j = C0153a.m320j(parcel);
        HashSet hashSet = new HashSet();
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    i3 = C0153a.m314f(parcel, i4);
                    hashSet.add(1);
                    break;
                case 2:
                    i2 = C0153a.m314f(parcel, i4);
                    hashSet.add(2);
                    break;
                case 3:
                    str = C0153a.m322l(parcel, i4);
                    hashSet.add(3);
                    break;
                case 4:
                    i = C0153a.m314f(parcel, i4);
                    hashSet.add(4);
                    break;
                default:
                    C0153a.m308b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0563fv.C0565b.C0567b(hashSet, i3, i2, str, i);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: am */
    public C0563fv.C0565b.C0567b[] newArray(int i) {
        return new C0563fv.C0565b.C0567b[i];
    }
}
