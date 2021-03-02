package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0556cc;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ck */
public class C0574ck implements Parcelable.Creator<C0556cc.C0564f> {
    /* renamed from: a */
    static void m1714a(C0556cc.C0564f fVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        Set<Integer> bH = fVar.mo5256bH();
        if (bH.contains(1)) {
            C0359b.m682c(parcel, 1, fVar.mo5278i());
        }
        if (bH.contains(2)) {
            C0359b.m672a(parcel, 2, fVar.getDepartment(), true);
        }
        if (bH.contains(3)) {
            C0359b.m672a(parcel, 3, fVar.getDescription(), true);
        }
        if (bH.contains(4)) {
            C0359b.m672a(parcel, 4, fVar.getEndDate(), true);
        }
        if (bH.contains(5)) {
            C0359b.m672a(parcel, 5, fVar.getLocation(), true);
        }
        if (bH.contains(6)) {
            C0359b.m672a(parcel, 6, fVar.getName(), true);
        }
        if (bH.contains(7)) {
            C0359b.m675a(parcel, 7, fVar.isPrimary());
        }
        if (bH.contains(8)) {
            C0359b.m672a(parcel, 8, fVar.getStartDate(), true);
        }
        if (bH.contains(9)) {
            C0359b.m672a(parcel, 9, fVar.getTitle(), true);
        }
        if (bH.contains(10)) {
            C0359b.m682c(parcel, 10, fVar.getType());
        }
        C0359b.m663C(parcel, d);
    }

    /* renamed from: F */
    public C0556cc.C0564f createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int c = C0357a.m634c(parcel);
        HashSet hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i2 = C0357a.m639f(parcel, b);
                    hashSet.add(1);
                    break;
                case 2:
                    str7 = C0357a.m645l(parcel, b);
                    hashSet.add(2);
                    break;
                case 3:
                    str6 = C0357a.m645l(parcel, b);
                    hashSet.add(3);
                    break;
                case 4:
                    str5 = C0357a.m645l(parcel, b);
                    hashSet.add(4);
                    break;
                case 5:
                    str4 = C0357a.m645l(parcel, b);
                    hashSet.add(5);
                    break;
                case 6:
                    str3 = C0357a.m645l(parcel, b);
                    hashSet.add(6);
                    break;
                case 7:
                    z = C0357a.m636c(parcel, b);
                    hashSet.add(7);
                    break;
                case 8:
                    str2 = C0357a.m645l(parcel, b);
                    hashSet.add(8);
                    break;
                case 9:
                    str = C0357a.m645l(parcel, b);
                    hashSet.add(9);
                    break;
                case 10:
                    i = C0357a.m639f(parcel, b);
                    hashSet.add(10);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0556cc.C0564f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: af */
    public C0556cc.C0564f[] newArray(int i) {
        return new C0556cc.C0564f[i];
    }
}
