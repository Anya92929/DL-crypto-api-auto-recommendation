package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ft */
public class C0561ft implements Parcelable.Creator<C0560fs> {
    /* renamed from: a */
    static void m1710a(C0560fs fsVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        Set<Integer> di = fsVar.mo5011di();
        if (di.contains(1)) {
            C0155b.m359c(parcel, 1, fsVar.getVersionCode());
        }
        if (di.contains(2)) {
            C0155b.m349a(parcel, 2, fsVar.getId(), true);
        }
        if (di.contains(4)) {
            C0155b.m348a(parcel, 4, (Parcelable) fsVar.mo5012dz(), i, true);
        }
        if (di.contains(5)) {
            C0155b.m349a(parcel, 5, fsVar.getStartDate(), true);
        }
        if (di.contains(6)) {
            C0155b.m348a(parcel, 6, (Parcelable) fsVar.mo5008dA(), i, true);
        }
        if (di.contains(7)) {
            C0155b.m349a(parcel, 7, fsVar.getType(), true);
        }
        C0155b.m340C(parcel, k);
    }

    /* renamed from: C */
    public C0560fs createFromParcel(Parcel parcel) {
        String str = null;
        int j = C0153a.m320j(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        C0558fq fqVar = null;
        String str2 = null;
        C0558fq fqVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    hashSet.add(1);
                    break;
                case 2:
                    str3 = C0153a.m322l(parcel, i2);
                    hashSet.add(2);
                    break;
                case 4:
                    hashSet.add(4);
                    fqVar2 = (C0558fq) C0153a.m305a(parcel, i2, C0558fq.CREATOR);
                    break;
                case 5:
                    str2 = C0153a.m322l(parcel, i2);
                    hashSet.add(5);
                    break;
                case 6:
                    hashSet.add(6);
                    fqVar = (C0558fq) C0153a.m305a(parcel, i2, C0558fq.CREATOR);
                    break;
                case 7:
                    str = C0153a.m322l(parcel, i2);
                    hashSet.add(7);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0560fs(hashSet, i, str3, fqVar2, str2, fqVar, str);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: ah */
    public C0560fs[] newArray(int i) {
        return new C0560fs[i];
    }
}
