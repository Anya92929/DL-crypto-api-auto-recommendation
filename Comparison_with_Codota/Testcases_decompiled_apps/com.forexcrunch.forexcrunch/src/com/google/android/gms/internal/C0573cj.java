package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0556cc;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.cj */
public class C0573cj implements Parcelable.Creator<C0556cc.C0562d> {
    /* renamed from: a */
    static void m1711a(C0556cc.C0562d dVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        Set<Integer> bH = dVar.mo5237bH();
        if (bH.contains(1)) {
            C0359b.m682c(parcel, 1, dVar.mo5254i());
        }
        if (bH.contains(2)) {
            C0359b.m672a(parcel, 2, dVar.getFamilyName(), true);
        }
        if (bH.contains(3)) {
            C0359b.m672a(parcel, 3, dVar.getFormatted(), true);
        }
        if (bH.contains(4)) {
            C0359b.m672a(parcel, 4, dVar.getGivenName(), true);
        }
        if (bH.contains(5)) {
            C0359b.m672a(parcel, 5, dVar.getHonorificPrefix(), true);
        }
        if (bH.contains(6)) {
            C0359b.m672a(parcel, 6, dVar.getHonorificSuffix(), true);
        }
        if (bH.contains(7)) {
            C0359b.m672a(parcel, 7, dVar.getMiddleName(), true);
        }
        C0359b.m663C(parcel, d);
    }

    /* renamed from: E */
    public C0556cc.C0562d createFromParcel(Parcel parcel) {
        String str = null;
        int c = C0357a.m634c(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    hashSet.add(1);
                    break;
                case 2:
                    str6 = C0357a.m645l(parcel, b);
                    hashSet.add(2);
                    break;
                case 3:
                    str5 = C0357a.m645l(parcel, b);
                    hashSet.add(3);
                    break;
                case 4:
                    str4 = C0357a.m645l(parcel, b);
                    hashSet.add(4);
                    break;
                case 5:
                    str3 = C0357a.m645l(parcel, b);
                    hashSet.add(5);
                    break;
                case 6:
                    str2 = C0357a.m645l(parcel, b);
                    hashSet.add(6);
                    break;
                case 7:
                    str = C0357a.m645l(parcel, b);
                    hashSet.add(7);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0556cc.C0562d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }

    /* renamed from: ae */
    public C0556cc.C0562d[] newArray(int i) {
        return new C0556cc.C0562d[i];
    }
}
