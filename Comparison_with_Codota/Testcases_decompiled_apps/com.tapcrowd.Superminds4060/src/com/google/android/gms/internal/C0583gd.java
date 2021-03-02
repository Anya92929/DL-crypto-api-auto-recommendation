package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0563fv;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.gd */
public class C0583gd implements Parcelable.Creator<C0563fv.C0571f> {
    /* renamed from: a */
    static void m1821a(C0563fv.C0571f fVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        Set<Integer> di = fVar.mo5174di();
        if (di.contains(1)) {
            C0155b.m359c(parcel, 1, fVar.getVersionCode());
        }
        if (di.contains(2)) {
            C0155b.m349a(parcel, 2, fVar.getDepartment(), true);
        }
        if (di.contains(3)) {
            C0155b.m349a(parcel, 3, fVar.getDescription(), true);
        }
        if (di.contains(4)) {
            C0155b.m349a(parcel, 4, fVar.getEndDate(), true);
        }
        if (di.contains(5)) {
            C0155b.m349a(parcel, 5, fVar.getLocation(), true);
        }
        if (di.contains(6)) {
            C0155b.m349a(parcel, 6, fVar.getName(), true);
        }
        if (di.contains(7)) {
            C0155b.m352a(parcel, 7, fVar.isPrimary());
        }
        if (di.contains(8)) {
            C0155b.m349a(parcel, 8, fVar.getStartDate(), true);
        }
        if (di.contains(9)) {
            C0155b.m349a(parcel, 9, fVar.getTitle(), true);
        }
        if (di.contains(10)) {
            C0155b.m359c(parcel, 10, fVar.getType());
        }
        C0155b.m340C(parcel, k);
    }

    /* renamed from: K */
    public C0563fv.C0571f createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int j = C0153a.m320j(parcel);
        HashSet hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i3)) {
                case 1:
                    i2 = C0153a.m314f(parcel, i3);
                    hashSet.add(1);
                    break;
                case 2:
                    str7 = C0153a.m322l(parcel, i3);
                    hashSet.add(2);
                    break;
                case 3:
                    str6 = C0153a.m322l(parcel, i3);
                    hashSet.add(3);
                    break;
                case 4:
                    str5 = C0153a.m322l(parcel, i3);
                    hashSet.add(4);
                    break;
                case 5:
                    str4 = C0153a.m322l(parcel, i3);
                    hashSet.add(5);
                    break;
                case 6:
                    str3 = C0153a.m322l(parcel, i3);
                    hashSet.add(6);
                    break;
                case 7:
                    z = C0153a.m311c(parcel, i3);
                    hashSet.add(7);
                    break;
                case 8:
                    str2 = C0153a.m322l(parcel, i3);
                    hashSet.add(8);
                    break;
                case 9:
                    str = C0153a.m322l(parcel, i3);
                    hashSet.add(9);
                    break;
                case 10:
                    i = C0153a.m314f(parcel, i3);
                    hashSet.add(10);
                    break;
                default:
                    C0153a.m308b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0563fv.C0571f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: ap */
    public C0563fv.C0571f[] newArray(int i) {
        return new C0563fv.C0571f[i];
    }
}
