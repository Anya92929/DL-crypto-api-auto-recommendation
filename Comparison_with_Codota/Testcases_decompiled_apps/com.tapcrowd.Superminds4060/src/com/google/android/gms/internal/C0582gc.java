package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0563fv;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.gc */
public class C0582gc implements Parcelable.Creator<C0563fv.C0569d> {
    /* renamed from: a */
    static void m1818a(C0563fv.C0569d dVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        Set<Integer> di = dVar.mo5155di();
        if (di.contains(1)) {
            C0155b.m359c(parcel, 1, dVar.getVersionCode());
        }
        if (di.contains(2)) {
            C0155b.m349a(parcel, 2, dVar.getFamilyName(), true);
        }
        if (di.contains(3)) {
            C0155b.m349a(parcel, 3, dVar.getFormatted(), true);
        }
        if (di.contains(4)) {
            C0155b.m349a(parcel, 4, dVar.getGivenName(), true);
        }
        if (di.contains(5)) {
            C0155b.m349a(parcel, 5, dVar.getHonorificPrefix(), true);
        }
        if (di.contains(6)) {
            C0155b.m349a(parcel, 6, dVar.getHonorificSuffix(), true);
        }
        if (di.contains(7)) {
            C0155b.m349a(parcel, 7, dVar.getMiddleName(), true);
        }
        C0155b.m340C(parcel, k);
    }

    /* renamed from: J */
    public C0563fv.C0569d createFromParcel(Parcel parcel) {
        String str = null;
        int j = C0153a.m320j(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    hashSet.add(1);
                    break;
                case 2:
                    str6 = C0153a.m322l(parcel, i2);
                    hashSet.add(2);
                    break;
                case 3:
                    str5 = C0153a.m322l(parcel, i2);
                    hashSet.add(3);
                    break;
                case 4:
                    str4 = C0153a.m322l(parcel, i2);
                    hashSet.add(4);
                    break;
                case 5:
                    str3 = C0153a.m322l(parcel, i2);
                    hashSet.add(5);
                    break;
                case 6:
                    str2 = C0153a.m322l(parcel, i2);
                    hashSet.add(6);
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
            return new C0563fv.C0569d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: ao */
    public C0563fv.C0569d[] newArray(int i) {
        return new C0563fv.C0569d[i];
    }
}
