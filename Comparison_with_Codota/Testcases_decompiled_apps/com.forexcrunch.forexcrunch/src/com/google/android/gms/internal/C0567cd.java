package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import com.google.android.gms.internal.C0556cc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.cd */
public class C0567cd implements Parcelable.Creator<C0556cc> {
    /* renamed from: a */
    static void m1693a(C0556cc ccVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        Set<Integer> bH = ccVar.mo5114bH();
        if (bH.contains(1)) {
            C0359b.m682c(parcel, 1, ccVar.mo5174i());
        }
        if (bH.contains(2)) {
            C0359b.m672a(parcel, 2, ccVar.getAboutMe(), true);
        }
        if (bH.contains(3)) {
            C0359b.m671a(parcel, 3, (Parcelable) ccVar.mo5115cc(), i, true);
        }
        if (bH.contains(4)) {
            C0359b.m672a(parcel, 4, ccVar.getBirthday(), true);
        }
        if (bH.contains(5)) {
            C0359b.m672a(parcel, 5, ccVar.getBraggingRights(), true);
        }
        if (bH.contains(6)) {
            C0359b.m682c(parcel, 6, ccVar.getCircledByCount());
        }
        if (bH.contains(7)) {
            C0359b.m671a(parcel, 7, (Parcelable) ccVar.mo5116cd(), i, true);
        }
        if (bH.contains(8)) {
            C0359b.m672a(parcel, 8, ccVar.getCurrentLocation(), true);
        }
        if (bH.contains(9)) {
            C0359b.m672a(parcel, 9, ccVar.getDisplayName(), true);
        }
        if (bH.contains(12)) {
            C0359b.m682c(parcel, 12, ccVar.getGender());
        }
        if (bH.contains(14)) {
            C0359b.m672a(parcel, 14, ccVar.getId(), true);
        }
        if (bH.contains(15)) {
            C0359b.m671a(parcel, 15, (Parcelable) ccVar.mo5117ce(), i, true);
        }
        if (bH.contains(16)) {
            C0359b.m675a(parcel, 16, ccVar.isPlusUser());
        }
        if (bH.contains(19)) {
            C0359b.m671a(parcel, 19, (Parcelable) ccVar.mo5118cf(), i, true);
        }
        if (bH.contains(18)) {
            C0359b.m672a(parcel, 18, ccVar.getLanguage(), true);
        }
        if (bH.contains(21)) {
            C0359b.m682c(parcel, 21, ccVar.getObjectType());
        }
        if (bH.contains(20)) {
            C0359b.m672a(parcel, 20, ccVar.getNickname(), true);
        }
        if (bH.contains(23)) {
            C0359b.m681b(parcel, 23, ccVar.mo5120ch(), true);
        }
        if (bH.contains(22)) {
            C0359b.m681b(parcel, 22, ccVar.mo5119cg(), true);
        }
        if (bH.contains(25)) {
            C0359b.m682c(parcel, 25, ccVar.getRelationshipStatus());
        }
        if (bH.contains(24)) {
            C0359b.m682c(parcel, 24, ccVar.getPlusOneCount());
        }
        if (bH.contains(27)) {
            C0359b.m672a(parcel, 27, ccVar.getUrl(), true);
        }
        if (bH.contains(26)) {
            C0359b.m672a(parcel, 26, ccVar.getTagline(), true);
        }
        if (bH.contains(29)) {
            C0359b.m675a(parcel, 29, ccVar.isVerified());
        }
        if (bH.contains(28)) {
            C0359b.m681b(parcel, 28, ccVar.mo5121ci(), true);
        }
        C0359b.m663C(parcel, d);
    }

    /* renamed from: Y */
    public C0556cc[] newArray(int i) {
        return new C0556cc[i];
    }

    /* renamed from: y */
    public C0556cc createFromParcel(Parcel parcel) {
        int c = C0357a.m634c(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        C0556cc.C0557a aVar = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C0556cc.C0558b bVar = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C0556cc.C0561c cVar = null;
        boolean z = false;
        String str7 = null;
        C0556cc.C0562d dVar = null;
        String str8 = null;
        int i4 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        ArrayList arrayList3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    hashSet.add(1);
                    break;
                case 2:
                    str = C0357a.m645l(parcel, b);
                    hashSet.add(2);
                    break;
                case 3:
                    hashSet.add(3);
                    aVar = (C0556cc.C0557a) C0357a.m628a(parcel, b, C0556cc.C0557a.CREATOR);
                    break;
                case 4:
                    str2 = C0357a.m645l(parcel, b);
                    hashSet.add(4);
                    break;
                case 5:
                    str3 = C0357a.m645l(parcel, b);
                    hashSet.add(5);
                    break;
                case 6:
                    i2 = C0357a.m639f(parcel, b);
                    hashSet.add(6);
                    break;
                case 7:
                    hashSet.add(7);
                    bVar = (C0556cc.C0558b) C0357a.m628a(parcel, b, C0556cc.C0558b.CREATOR);
                    break;
                case 8:
                    str4 = C0357a.m645l(parcel, b);
                    hashSet.add(8);
                    break;
                case 9:
                    str5 = C0357a.m645l(parcel, b);
                    hashSet.add(9);
                    break;
                case 12:
                    i3 = C0357a.m639f(parcel, b);
                    hashSet.add(12);
                    break;
                case 14:
                    str6 = C0357a.m645l(parcel, b);
                    hashSet.add(14);
                    break;
                case 15:
                    hashSet.add(15);
                    cVar = (C0556cc.C0561c) C0357a.m628a(parcel, b, C0556cc.C0561c.CREATOR);
                    break;
                case 16:
                    z = C0357a.m636c(parcel, b);
                    hashSet.add(16);
                    break;
                case 18:
                    str7 = C0357a.m645l(parcel, b);
                    hashSet.add(18);
                    break;
                case 19:
                    hashSet.add(19);
                    dVar = (C0556cc.C0562d) C0357a.m628a(parcel, b, C0556cc.C0562d.CREATOR);
                    break;
                case 20:
                    str8 = C0357a.m645l(parcel, b);
                    hashSet.add(20);
                    break;
                case 21:
                    i4 = C0357a.m639f(parcel, b);
                    hashSet.add(21);
                    break;
                case 22:
                    arrayList = C0357a.m635c(parcel, b, C0556cc.C0564f.CREATOR);
                    hashSet.add(22);
                    break;
                case 23:
                    arrayList2 = C0357a.m635c(parcel, b, C0556cc.C0565g.CREATOR);
                    hashSet.add(23);
                    break;
                case 24:
                    i5 = C0357a.m639f(parcel, b);
                    hashSet.add(24);
                    break;
                case 25:
                    i6 = C0357a.m639f(parcel, b);
                    hashSet.add(25);
                    break;
                case 26:
                    str9 = C0357a.m645l(parcel, b);
                    hashSet.add(26);
                    break;
                case 27:
                    str10 = C0357a.m645l(parcel, b);
                    hashSet.add(27);
                    break;
                case 28:
                    arrayList3 = C0357a.m635c(parcel, b, C0556cc.C0566h.CREATOR);
                    hashSet.add(28);
                    break;
                case 29:
                    z2 = C0357a.m636c(parcel, b);
                    hashSet.add(29);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0556cc(hashSet, i, str, aVar, str2, str3, i2, bVar, str4, str5, i3, str6, cVar, z, str7, dVar, str8, i4, arrayList, arrayList2, i5, i6, str9, str10, arrayList3, z2);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }
}
