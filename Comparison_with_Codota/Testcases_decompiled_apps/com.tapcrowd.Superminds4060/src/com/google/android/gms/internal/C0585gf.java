package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0563fv;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.gf */
public class C0585gf implements Parcelable.Creator<C0563fv.C0573h> {
    /* renamed from: a */
    static void m1827a(C0563fv.C0573h hVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        Set<Integer> di = hVar.mo5211di();
        if (di.contains(1)) {
            C0155b.m359c(parcel, 1, hVar.getVersionCode());
        }
        if (di.contains(3)) {
            C0155b.m359c(parcel, 3, hVar.mo5208dV());
        }
        if (di.contains(4)) {
            C0155b.m349a(parcel, 4, hVar.getValue(), true);
        }
        if (di.contains(5)) {
            C0155b.m349a(parcel, 5, hVar.getLabel(), true);
        }
        if (di.contains(6)) {
            C0155b.m359c(parcel, 6, hVar.getType());
        }
        C0155b.m340C(parcel, k);
    }

    /* renamed from: M */
    public C0563fv.C0573h createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int j = C0153a.m320j(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    i3 = C0153a.m314f(parcel, i4);
                    hashSet.add(1);
                    break;
                case 3:
                    i = C0153a.m314f(parcel, i4);
                    hashSet.add(3);
                    break;
                case 4:
                    str = C0153a.m322l(parcel, i4);
                    hashSet.add(4);
                    break;
                case 5:
                    str2 = C0153a.m322l(parcel, i4);
                    hashSet.add(5);
                    break;
                case 6:
                    i2 = C0153a.m314f(parcel, i4);
                    hashSet.add(6);
                    break;
                default:
                    C0153a.m308b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0563fv.C0573h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: ar */
    public C0563fv.C0573h[] newArray(int i) {
        return new C0563fv.C0573h[i];
    }
}
