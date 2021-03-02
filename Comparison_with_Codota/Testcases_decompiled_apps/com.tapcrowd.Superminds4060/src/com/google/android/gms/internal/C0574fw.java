package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import com.google.android.gms.internal.C0563fv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.fw */
public class C0574fw implements Parcelable.Creator<C0563fv> {
    /* renamed from: a */
    static void m1797a(C0563fv fvVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        Set<Integer> di = fvVar.mo5041di();
        if (di.contains(1)) {
            C0155b.m359c(parcel, 1, fvVar.getVersionCode());
        }
        if (di.contains(2)) {
            C0155b.m349a(parcel, 2, fvVar.getAboutMe(), true);
        }
        if (di.contains(3)) {
            C0155b.m348a(parcel, 3, (Parcelable) fvVar.mo5032dD(), i, true);
        }
        if (di.contains(4)) {
            C0155b.m349a(parcel, 4, fvVar.getBirthday(), true);
        }
        if (di.contains(5)) {
            C0155b.m349a(parcel, 5, fvVar.getBraggingRights(), true);
        }
        if (di.contains(6)) {
            C0155b.m359c(parcel, 6, fvVar.getCircledByCount());
        }
        if (di.contains(7)) {
            C0155b.m348a(parcel, 7, (Parcelable) fvVar.mo5033dE(), i, true);
        }
        if (di.contains(8)) {
            C0155b.m349a(parcel, 8, fvVar.getCurrentLocation(), true);
        }
        if (di.contains(9)) {
            C0155b.m349a(parcel, 9, fvVar.getDisplayName(), true);
        }
        if (di.contains(12)) {
            C0155b.m359c(parcel, 12, fvVar.getGender());
        }
        if (di.contains(14)) {
            C0155b.m349a(parcel, 14, fvVar.getId(), true);
        }
        if (di.contains(15)) {
            C0155b.m348a(parcel, 15, (Parcelable) fvVar.mo5034dF(), i, true);
        }
        if (di.contains(16)) {
            C0155b.m352a(parcel, 16, fvVar.isPlusUser());
        }
        if (di.contains(19)) {
            C0155b.m348a(parcel, 19, (Parcelable) fvVar.mo5035dG(), i, true);
        }
        if (di.contains(18)) {
            C0155b.m349a(parcel, 18, fvVar.getLanguage(), true);
        }
        if (di.contains(21)) {
            C0155b.m359c(parcel, 21, fvVar.getObjectType());
        }
        if (di.contains(20)) {
            C0155b.m349a(parcel, 20, fvVar.getNickname(), true);
        }
        if (di.contains(23)) {
            C0155b.m358b(parcel, 23, fvVar.mo5037dI(), true);
        }
        if (di.contains(22)) {
            C0155b.m358b(parcel, 22, fvVar.mo5036dH(), true);
        }
        if (di.contains(25)) {
            C0155b.m359c(parcel, 25, fvVar.getRelationshipStatus());
        }
        if (di.contains(24)) {
            C0155b.m359c(parcel, 24, fvVar.getPlusOneCount());
        }
        if (di.contains(27)) {
            C0155b.m349a(parcel, 27, fvVar.getUrl(), true);
        }
        if (di.contains(26)) {
            C0155b.m349a(parcel, 26, fvVar.getTagline(), true);
        }
        if (di.contains(29)) {
            C0155b.m352a(parcel, 29, fvVar.isVerified());
        }
        if (di.contains(28)) {
            C0155b.m358b(parcel, 28, fvVar.mo5038dJ(), true);
        }
        C0155b.m340C(parcel, k);
    }

    /* renamed from: D */
    public C0563fv createFromParcel(Parcel parcel) {
        int j = C0153a.m320j(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        C0563fv.C0564a aVar = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C0563fv.C0565b bVar = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C0563fv.C0568c cVar = null;
        boolean z = false;
        String str7 = null;
        C0563fv.C0569d dVar = null;
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
        while (parcel.dataPosition() < j) {
            int i7 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i7)) {
                case 1:
                    i = C0153a.m314f(parcel, i7);
                    hashSet.add(1);
                    break;
                case 2:
                    str = C0153a.m322l(parcel, i7);
                    hashSet.add(2);
                    break;
                case 3:
                    hashSet.add(3);
                    aVar = (C0563fv.C0564a) C0153a.m305a(parcel, i7, C0563fv.C0564a.CREATOR);
                    break;
                case 4:
                    str2 = C0153a.m322l(parcel, i7);
                    hashSet.add(4);
                    break;
                case 5:
                    str3 = C0153a.m322l(parcel, i7);
                    hashSet.add(5);
                    break;
                case 6:
                    i2 = C0153a.m314f(parcel, i7);
                    hashSet.add(6);
                    break;
                case 7:
                    hashSet.add(7);
                    bVar = (C0563fv.C0565b) C0153a.m305a(parcel, i7, C0563fv.C0565b.CREATOR);
                    break;
                case 8:
                    str4 = C0153a.m322l(parcel, i7);
                    hashSet.add(8);
                    break;
                case 9:
                    str5 = C0153a.m322l(parcel, i7);
                    hashSet.add(9);
                    break;
                case 12:
                    i3 = C0153a.m314f(parcel, i7);
                    hashSet.add(12);
                    break;
                case 14:
                    str6 = C0153a.m322l(parcel, i7);
                    hashSet.add(14);
                    break;
                case 15:
                    hashSet.add(15);
                    cVar = (C0563fv.C0568c) C0153a.m305a(parcel, i7, C0563fv.C0568c.CREATOR);
                    break;
                case 16:
                    z = C0153a.m311c(parcel, i7);
                    hashSet.add(16);
                    break;
                case 18:
                    str7 = C0153a.m322l(parcel, i7);
                    hashSet.add(18);
                    break;
                case 19:
                    hashSet.add(19);
                    dVar = (C0563fv.C0569d) C0153a.m305a(parcel, i7, C0563fv.C0569d.CREATOR);
                    break;
                case 20:
                    str8 = C0153a.m322l(parcel, i7);
                    hashSet.add(20);
                    break;
                case 21:
                    i4 = C0153a.m314f(parcel, i7);
                    hashSet.add(21);
                    break;
                case 22:
                    arrayList = C0153a.m310c(parcel, i7, C0563fv.C0571f.CREATOR);
                    hashSet.add(22);
                    break;
                case 23:
                    arrayList2 = C0153a.m310c(parcel, i7, C0563fv.C0572g.CREATOR);
                    hashSet.add(23);
                    break;
                case 24:
                    i5 = C0153a.m314f(parcel, i7);
                    hashSet.add(24);
                    break;
                case 25:
                    i6 = C0153a.m314f(parcel, i7);
                    hashSet.add(25);
                    break;
                case 26:
                    str9 = C0153a.m322l(parcel, i7);
                    hashSet.add(26);
                    break;
                case 27:
                    str10 = C0153a.m322l(parcel, i7);
                    hashSet.add(27);
                    break;
                case 28:
                    arrayList3 = C0153a.m310c(parcel, i7, C0563fv.C0573h.CREATOR);
                    hashSet.add(28);
                    break;
                case 29:
                    z2 = C0153a.m311c(parcel, i7);
                    hashSet.add(29);
                    break;
                default:
                    C0153a.m308b(parcel, i7);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0563fv(hashSet, i, str, aVar, str2, str3, i2, bVar, str4, str5, i3, str6, cVar, z, str7, dVar, str8, i4, arrayList, arrayList2, i5, i6, str9, str10, arrayList3, z2);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: ai */
    public C0563fv[] newArray(int i) {
        return new C0563fv[i];
    }
}
