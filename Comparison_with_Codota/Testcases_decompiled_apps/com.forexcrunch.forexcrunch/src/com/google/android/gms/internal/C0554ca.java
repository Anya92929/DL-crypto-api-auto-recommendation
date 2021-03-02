package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ca */
public class C0554ca implements Parcelable.Creator<C0544bz> {
    /* renamed from: a */
    static void m1596a(C0544bz bzVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        Set<Integer> bH = bzVar.mo5077bH();
        if (bH.contains(1)) {
            C0359b.m682c(parcel, 1, bzVar.mo5094i());
        }
        if (bH.contains(2)) {
            C0359b.m672a(parcel, 2, bzVar.getId(), true);
        }
        if (bH.contains(4)) {
            C0359b.m671a(parcel, 4, (Parcelable) bzVar.mo5078bY(), i, true);
        }
        if (bH.contains(5)) {
            C0359b.m672a(parcel, 5, bzVar.getStartDate(), true);
        }
        if (bH.contains(6)) {
            C0359b.m671a(parcel, 6, (Parcelable) bzVar.mo5079bZ(), i, true);
        }
        if (bH.contains(7)) {
            C0359b.m672a(parcel, 7, bzVar.getType(), true);
        }
        C0359b.m663C(parcel, d);
    }

    /* renamed from: X */
    public C0544bz[] newArray(int i) {
        return new C0544bz[i];
    }

    /* renamed from: x */
    public C0544bz createFromParcel(Parcel parcel) {
        String str = null;
        int c = C0357a.m634c(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        C0542bx bxVar = null;
        String str2 = null;
        C0542bx bxVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    hashSet.add(1);
                    break;
                case 2:
                    str3 = C0357a.m645l(parcel, b);
                    hashSet.add(2);
                    break;
                case 4:
                    hashSet.add(4);
                    bxVar2 = (C0542bx) C0357a.m628a(parcel, b, C0542bx.CREATOR);
                    break;
                case 5:
                    str2 = C0357a.m645l(parcel, b);
                    hashSet.add(5);
                    break;
                case 6:
                    hashSet.add(6);
                    bxVar = (C0542bx) C0357a.m628a(parcel, b, C0542bx.CREATOR);
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
            return new C0544bz(hashSet, i, str3, bxVar2, str2, bxVar, str);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }
}
