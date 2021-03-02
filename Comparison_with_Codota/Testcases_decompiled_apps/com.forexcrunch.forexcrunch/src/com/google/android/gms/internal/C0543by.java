package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0357a;
import com.google.android.gms.common.internal.safeparcel.C0359b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.by */
public class C0543by implements Parcelable.Creator<C0542bx> {
    /* renamed from: a */
    static void m1564a(C0542bx bxVar, Parcel parcel, int i) {
        int d = C0359b.m684d(parcel);
        Set<Integer> bH = bxVar.mo4943bH();
        if (bH.contains(1)) {
            C0359b.m682c(parcel, 1, bxVar.mo5071i());
        }
        if (bH.contains(2)) {
            C0359b.m671a(parcel, 2, (Parcelable) bxVar.mo4944bI(), i, true);
        }
        if (bH.contains(3)) {
            C0359b.m673a(parcel, 3, bxVar.getAdditionalName(), true);
        }
        if (bH.contains(4)) {
            C0359b.m671a(parcel, 4, (Parcelable) bxVar.mo4945bJ(), i, true);
        }
        if (bH.contains(5)) {
            C0359b.m672a(parcel, 5, bxVar.getAddressCountry(), true);
        }
        if (bH.contains(6)) {
            C0359b.m672a(parcel, 6, bxVar.getAddressLocality(), true);
        }
        if (bH.contains(7)) {
            C0359b.m672a(parcel, 7, bxVar.getAddressRegion(), true);
        }
        if (bH.contains(8)) {
            C0359b.m681b(parcel, 8, bxVar.mo4946bK(), true);
        }
        if (bH.contains(9)) {
            C0359b.m682c(parcel, 9, bxVar.getAttendeeCount());
        }
        if (bH.contains(10)) {
            C0359b.m681b(parcel, 10, bxVar.mo4947bL(), true);
        }
        if (bH.contains(11)) {
            C0359b.m671a(parcel, 11, (Parcelable) bxVar.mo4948bM(), i, true);
        }
        if (bH.contains(12)) {
            C0359b.m681b(parcel, 12, bxVar.mo4949bN(), true);
        }
        if (bH.contains(13)) {
            C0359b.m672a(parcel, 13, bxVar.getBestRating(), true);
        }
        if (bH.contains(14)) {
            C0359b.m672a(parcel, 14, bxVar.getBirthDate(), true);
        }
        if (bH.contains(15)) {
            C0359b.m671a(parcel, 15, (Parcelable) bxVar.mo4950bO(), i, true);
        }
        if (bH.contains(17)) {
            C0359b.m672a(parcel, 17, bxVar.getContentSize(), true);
        }
        if (bH.contains(16)) {
            C0359b.m672a(parcel, 16, bxVar.getCaption(), true);
        }
        if (bH.contains(19)) {
            C0359b.m681b(parcel, 19, bxVar.mo4951bP(), true);
        }
        if (bH.contains(18)) {
            C0359b.m672a(parcel, 18, bxVar.getContentUrl(), true);
        }
        if (bH.contains(21)) {
            C0359b.m672a(parcel, 21, bxVar.getDateModified(), true);
        }
        if (bH.contains(20)) {
            C0359b.m672a(parcel, 20, bxVar.getDateCreated(), true);
        }
        if (bH.contains(23)) {
            C0359b.m672a(parcel, 23, bxVar.getDescription(), true);
        }
        if (bH.contains(22)) {
            C0359b.m672a(parcel, 22, bxVar.getDatePublished(), true);
        }
        if (bH.contains(25)) {
            C0359b.m672a(parcel, 25, bxVar.getEmbedUrl(), true);
        }
        if (bH.contains(24)) {
            C0359b.m672a(parcel, 24, bxVar.getDuration(), true);
        }
        if (bH.contains(27)) {
            C0359b.m672a(parcel, 27, bxVar.getFamilyName(), true);
        }
        if (bH.contains(26)) {
            C0359b.m672a(parcel, 26, bxVar.getEndDate(), true);
        }
        if (bH.contains(29)) {
            C0359b.m671a(parcel, 29, (Parcelable) bxVar.mo4952bQ(), i, true);
        }
        if (bH.contains(28)) {
            C0359b.m672a(parcel, 28, bxVar.getGender(), true);
        }
        if (bH.contains(31)) {
            C0359b.m672a(parcel, 31, bxVar.getHeight(), true);
        }
        if (bH.contains(30)) {
            C0359b.m672a(parcel, 30, bxVar.getGivenName(), true);
        }
        if (bH.contains(34)) {
            C0359b.m671a(parcel, 34, (Parcelable) bxVar.mo4953bR(), i, true);
        }
        if (bH.contains(32)) {
            C0359b.m672a(parcel, 32, bxVar.getId(), true);
        }
        if (bH.contains(33)) {
            C0359b.m672a(parcel, 33, bxVar.getImage(), true);
        }
        if (bH.contains(38)) {
            C0359b.m665a(parcel, 38, bxVar.getLongitude());
        }
        if (bH.contains(39)) {
            C0359b.m672a(parcel, 39, bxVar.getName(), true);
        }
        if (bH.contains(36)) {
            C0359b.m665a(parcel, 36, bxVar.getLatitude());
        }
        if (bH.contains(37)) {
            C0359b.m671a(parcel, 37, (Parcelable) bxVar.mo4954bS(), i, true);
        }
        if (bH.contains(42)) {
            C0359b.m672a(parcel, 42, bxVar.getPlayerType(), true);
        }
        if (bH.contains(43)) {
            C0359b.m672a(parcel, 43, bxVar.getPostOfficeBoxNumber(), true);
        }
        if (bH.contains(40)) {
            C0359b.m671a(parcel, 40, (Parcelable) bxVar.mo4955bT(), i, true);
        }
        if (bH.contains(41)) {
            C0359b.m681b(parcel, 41, bxVar.mo4956bU(), true);
        }
        if (bH.contains(46)) {
            C0359b.m671a(parcel, 46, (Parcelable) bxVar.mo4957bV(), i, true);
        }
        if (bH.contains(47)) {
            C0359b.m672a(parcel, 47, bxVar.getStartDate(), true);
        }
        if (bH.contains(44)) {
            C0359b.m672a(parcel, 44, bxVar.getPostalCode(), true);
        }
        if (bH.contains(45)) {
            C0359b.m672a(parcel, 45, bxVar.getRatingValue(), true);
        }
        if (bH.contains(51)) {
            C0359b.m672a(parcel, 51, bxVar.getThumbnailUrl(), true);
        }
        if (bH.contains(50)) {
            C0359b.m671a(parcel, 50, (Parcelable) bxVar.mo4958bW(), i, true);
        }
        if (bH.contains(49)) {
            C0359b.m672a(parcel, 49, bxVar.getText(), true);
        }
        if (bH.contains(48)) {
            C0359b.m672a(parcel, 48, bxVar.getStreetAddress(), true);
        }
        if (bH.contains(55)) {
            C0359b.m672a(parcel, 55, bxVar.getWidth(), true);
        }
        if (bH.contains(54)) {
            C0359b.m672a(parcel, 54, bxVar.getUrl(), true);
        }
        if (bH.contains(53)) {
            C0359b.m672a(parcel, 53, bxVar.getType(), true);
        }
        if (bH.contains(52)) {
            C0359b.m672a(parcel, 52, bxVar.getTickerSymbol(), true);
        }
        if (bH.contains(56)) {
            C0359b.m672a(parcel, 56, bxVar.getWorstRating(), true);
        }
        C0359b.m663C(parcel, d);
    }

    /* renamed from: W */
    public C0542bx[] newArray(int i) {
        return new C0542bx[i];
    }

    /* renamed from: w */
    public C0542bx createFromParcel(Parcel parcel) {
        int c = C0357a.m634c(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        C0542bx bxVar = null;
        ArrayList<String> arrayList = null;
        C0542bx bxVar2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        ArrayList arrayList2 = null;
        int i2 = 0;
        ArrayList arrayList3 = null;
        C0542bx bxVar3 = null;
        ArrayList arrayList4 = null;
        String str4 = null;
        String str5 = null;
        C0542bx bxVar4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        ArrayList arrayList5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        C0542bx bxVar5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        C0542bx bxVar6 = null;
        double d = 0.0d;
        C0542bx bxVar7 = null;
        double d2 = 0.0d;
        String str22 = null;
        C0542bx bxVar8 = null;
        ArrayList arrayList6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        C0542bx bxVar9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        C0542bx bxVar10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < c) {
            int b = C0357a.m631b(parcel);
            switch (C0357a.m646m(b)) {
                case 1:
                    i = C0357a.m639f(parcel, b);
                    hashSet.add(1);
                    break;
                case 2:
                    hashSet.add(2);
                    bxVar = (C0542bx) C0357a.m628a(parcel, b, C0542bx.CREATOR);
                    break;
                case 3:
                    arrayList = C0357a.m658x(parcel, b);
                    hashSet.add(3);
                    break;
                case 4:
                    hashSet.add(4);
                    bxVar2 = (C0542bx) C0357a.m628a(parcel, b, C0542bx.CREATOR);
                    break;
                case 5:
                    str = C0357a.m645l(parcel, b);
                    hashSet.add(5);
                    break;
                case 6:
                    str2 = C0357a.m645l(parcel, b);
                    hashSet.add(6);
                    break;
                case 7:
                    str3 = C0357a.m645l(parcel, b);
                    hashSet.add(7);
                    break;
                case 8:
                    arrayList2 = C0357a.m635c(parcel, b, C0542bx.CREATOR);
                    hashSet.add(8);
                    break;
                case 9:
                    i2 = C0357a.m639f(parcel, b);
                    hashSet.add(9);
                    break;
                case 10:
                    arrayList3 = C0357a.m635c(parcel, b, C0542bx.CREATOR);
                    hashSet.add(10);
                    break;
                case 11:
                    hashSet.add(11);
                    bxVar3 = (C0542bx) C0357a.m628a(parcel, b, C0542bx.CREATOR);
                    break;
                case 12:
                    arrayList4 = C0357a.m635c(parcel, b, C0542bx.CREATOR);
                    hashSet.add(12);
                    break;
                case 13:
                    str4 = C0357a.m645l(parcel, b);
                    hashSet.add(13);
                    break;
                case 14:
                    str5 = C0357a.m645l(parcel, b);
                    hashSet.add(14);
                    break;
                case 15:
                    hashSet.add(15);
                    bxVar4 = (C0542bx) C0357a.m628a(parcel, b, C0542bx.CREATOR);
                    break;
                case 16:
                    str6 = C0357a.m645l(parcel, b);
                    hashSet.add(16);
                    break;
                case 17:
                    str7 = C0357a.m645l(parcel, b);
                    hashSet.add(17);
                    break;
                case 18:
                    str8 = C0357a.m645l(parcel, b);
                    hashSet.add(18);
                    break;
                case 19:
                    arrayList5 = C0357a.m635c(parcel, b, C0542bx.CREATOR);
                    hashSet.add(19);
                    break;
                case 20:
                    str9 = C0357a.m645l(parcel, b);
                    hashSet.add(20);
                    break;
                case 21:
                    str10 = C0357a.m645l(parcel, b);
                    hashSet.add(21);
                    break;
                case 22:
                    str11 = C0357a.m645l(parcel, b);
                    hashSet.add(22);
                    break;
                case 23:
                    str12 = C0357a.m645l(parcel, b);
                    hashSet.add(23);
                    break;
                case 24:
                    str13 = C0357a.m645l(parcel, b);
                    hashSet.add(24);
                    break;
                case 25:
                    str14 = C0357a.m645l(parcel, b);
                    hashSet.add(25);
                    break;
                case 26:
                    str15 = C0357a.m645l(parcel, b);
                    hashSet.add(26);
                    break;
                case 27:
                    str16 = C0357a.m645l(parcel, b);
                    hashSet.add(27);
                    break;
                case 28:
                    str17 = C0357a.m645l(parcel, b);
                    hashSet.add(28);
                    break;
                case 29:
                    hashSet.add(29);
                    bxVar5 = (C0542bx) C0357a.m628a(parcel, b, C0542bx.CREATOR);
                    break;
                case 30:
                    str18 = C0357a.m645l(parcel, b);
                    hashSet.add(30);
                    break;
                case 31:
                    str19 = C0357a.m645l(parcel, b);
                    hashSet.add(31);
                    break;
                case 32:
                    str20 = C0357a.m645l(parcel, b);
                    hashSet.add(32);
                    break;
                case 33:
                    str21 = C0357a.m645l(parcel, b);
                    hashSet.add(33);
                    break;
                case 34:
                    hashSet.add(34);
                    bxVar6 = (C0542bx) C0357a.m628a(parcel, b, C0542bx.CREATOR);
                    break;
                case 36:
                    d = C0357a.m643j(parcel, b);
                    hashSet.add(36);
                    break;
                case 37:
                    hashSet.add(37);
                    bxVar7 = (C0542bx) C0357a.m628a(parcel, b, C0542bx.CREATOR);
                    break;
                case 38:
                    d2 = C0357a.m643j(parcel, b);
                    hashSet.add(38);
                    break;
                case 39:
                    str22 = C0357a.m645l(parcel, b);
                    hashSet.add(39);
                    break;
                case 40:
                    hashSet.add(40);
                    bxVar8 = (C0542bx) C0357a.m628a(parcel, b, C0542bx.CREATOR);
                    break;
                case 41:
                    arrayList6 = C0357a.m635c(parcel, b, C0542bx.CREATOR);
                    hashSet.add(41);
                    break;
                case 42:
                    str23 = C0357a.m645l(parcel, b);
                    hashSet.add(42);
                    break;
                case 43:
                    str24 = C0357a.m645l(parcel, b);
                    hashSet.add(43);
                    break;
                case 44:
                    str25 = C0357a.m645l(parcel, b);
                    hashSet.add(44);
                    break;
                case 45:
                    str26 = C0357a.m645l(parcel, b);
                    hashSet.add(45);
                    break;
                case 46:
                    hashSet.add(46);
                    bxVar9 = (C0542bx) C0357a.m628a(parcel, b, C0542bx.CREATOR);
                    break;
                case 47:
                    str27 = C0357a.m645l(parcel, b);
                    hashSet.add(47);
                    break;
                case 48:
                    str28 = C0357a.m645l(parcel, b);
                    hashSet.add(48);
                    break;
                case 49:
                    str29 = C0357a.m645l(parcel, b);
                    hashSet.add(49);
                    break;
                case 50:
                    hashSet.add(50);
                    bxVar10 = (C0542bx) C0357a.m628a(parcel, b, C0542bx.CREATOR);
                    break;
                case 51:
                    str30 = C0357a.m645l(parcel, b);
                    hashSet.add(51);
                    break;
                case 52:
                    str31 = C0357a.m645l(parcel, b);
                    hashSet.add(52);
                    break;
                case 53:
                    str32 = C0357a.m645l(parcel, b);
                    hashSet.add(53);
                    break;
                case 54:
                    str33 = C0357a.m645l(parcel, b);
                    hashSet.add(54);
                    break;
                case 55:
                    str34 = C0357a.m645l(parcel, b);
                    hashSet.add(55);
                    break;
                case 56:
                    str35 = C0357a.m645l(parcel, b);
                    hashSet.add(56);
                    break;
                default:
                    C0357a.m632b(parcel, b);
                    break;
            }
        }
        if (parcel.dataPosition() == c) {
            return new C0542bx(hashSet, i, bxVar, arrayList, bxVar2, str, str2, str3, arrayList2, i2, arrayList3, bxVar3, arrayList4, str4, str5, bxVar4, str6, str7, str8, arrayList5, str9, str10, str11, str12, str13, str14, str15, str16, str17, bxVar5, str18, str19, str20, str21, bxVar6, d, bxVar7, d2, str22, bxVar8, arrayList6, str23, str24, str25, str26, bxVar9, str27, str28, str29, bxVar10, str30, str31, str32, str33, str34, str35);
        }
        throw new C0357a.C0358a("Overread allowed size end=" + c, parcel);
    }
}
