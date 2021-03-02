package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.fr */
public class C0559fr implements Parcelable.Creator<C0558fq> {
    /* renamed from: a */
    static void m1698a(C0558fq fqVar, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        Set<Integer> di = fqVar.mo4875di();
        if (di.contains(1)) {
            C0155b.m359c(parcel, 1, fqVar.getVersionCode());
        }
        if (di.contains(2)) {
            C0155b.m348a(parcel, 2, (Parcelable) fqVar.mo4876dj(), i, true);
        }
        if (di.contains(3)) {
            C0155b.m350a(parcel, 3, fqVar.getAdditionalName(), true);
        }
        if (di.contains(4)) {
            C0155b.m348a(parcel, 4, (Parcelable) fqVar.mo4877dk(), i, true);
        }
        if (di.contains(5)) {
            C0155b.m349a(parcel, 5, fqVar.getAddressCountry(), true);
        }
        if (di.contains(6)) {
            C0155b.m349a(parcel, 6, fqVar.getAddressLocality(), true);
        }
        if (di.contains(7)) {
            C0155b.m349a(parcel, 7, fqVar.getAddressRegion(), true);
        }
        if (di.contains(8)) {
            C0155b.m358b(parcel, 8, fqVar.mo4878dl(), true);
        }
        if (di.contains(9)) {
            C0155b.m359c(parcel, 9, fqVar.getAttendeeCount());
        }
        if (di.contains(10)) {
            C0155b.m358b(parcel, 10, fqVar.mo4879dm(), true);
        }
        if (di.contains(11)) {
            C0155b.m348a(parcel, 11, (Parcelable) fqVar.mo4880dn(), i, true);
        }
        if (di.contains(12)) {
            C0155b.m358b(parcel, 12, fqVar.mo4881do(), true);
        }
        if (di.contains(13)) {
            C0155b.m349a(parcel, 13, fqVar.getBestRating(), true);
        }
        if (di.contains(14)) {
            C0155b.m349a(parcel, 14, fqVar.getBirthDate(), true);
        }
        if (di.contains(15)) {
            C0155b.m348a(parcel, 15, (Parcelable) fqVar.mo4882dp(), i, true);
        }
        if (di.contains(17)) {
            C0155b.m349a(parcel, 17, fqVar.getContentSize(), true);
        }
        if (di.contains(16)) {
            C0155b.m349a(parcel, 16, fqVar.getCaption(), true);
        }
        if (di.contains(19)) {
            C0155b.m358b(parcel, 19, fqVar.mo4883dq(), true);
        }
        if (di.contains(18)) {
            C0155b.m349a(parcel, 18, fqVar.getContentUrl(), true);
        }
        if (di.contains(21)) {
            C0155b.m349a(parcel, 21, fqVar.getDateModified(), true);
        }
        if (di.contains(20)) {
            C0155b.m349a(parcel, 20, fqVar.getDateCreated(), true);
        }
        if (di.contains(23)) {
            C0155b.m349a(parcel, 23, fqVar.getDescription(), true);
        }
        if (di.contains(22)) {
            C0155b.m349a(parcel, 22, fqVar.getDatePublished(), true);
        }
        if (di.contains(25)) {
            C0155b.m349a(parcel, 25, fqVar.getEmbedUrl(), true);
        }
        if (di.contains(24)) {
            C0155b.m349a(parcel, 24, fqVar.getDuration(), true);
        }
        if (di.contains(27)) {
            C0155b.m349a(parcel, 27, fqVar.getFamilyName(), true);
        }
        if (di.contains(26)) {
            C0155b.m349a(parcel, 26, fqVar.getEndDate(), true);
        }
        if (di.contains(29)) {
            C0155b.m348a(parcel, 29, (Parcelable) fqVar.mo4884dr(), i, true);
        }
        if (di.contains(28)) {
            C0155b.m349a(parcel, 28, fqVar.getGender(), true);
        }
        if (di.contains(31)) {
            C0155b.m349a(parcel, 31, fqVar.getHeight(), true);
        }
        if (di.contains(30)) {
            C0155b.m349a(parcel, 30, fqVar.getGivenName(), true);
        }
        if (di.contains(34)) {
            C0155b.m348a(parcel, 34, (Parcelable) fqVar.mo4885ds(), i, true);
        }
        if (di.contains(32)) {
            C0155b.m349a(parcel, 32, fqVar.getId(), true);
        }
        if (di.contains(33)) {
            C0155b.m349a(parcel, 33, fqVar.getImage(), true);
        }
        if (di.contains(38)) {
            C0155b.m342a(parcel, 38, fqVar.getLongitude());
        }
        if (di.contains(39)) {
            C0155b.m349a(parcel, 39, fqVar.getName(), true);
        }
        if (di.contains(36)) {
            C0155b.m342a(parcel, 36, fqVar.getLatitude());
        }
        if (di.contains(37)) {
            C0155b.m348a(parcel, 37, (Parcelable) fqVar.mo4886dt(), i, true);
        }
        if (di.contains(42)) {
            C0155b.m349a(parcel, 42, fqVar.getPlayerType(), true);
        }
        if (di.contains(43)) {
            C0155b.m349a(parcel, 43, fqVar.getPostOfficeBoxNumber(), true);
        }
        if (di.contains(40)) {
            C0155b.m348a(parcel, 40, (Parcelable) fqVar.mo4887du(), i, true);
        }
        if (di.contains(41)) {
            C0155b.m358b(parcel, 41, fqVar.mo4888dv(), true);
        }
        if (di.contains(46)) {
            C0155b.m348a(parcel, 46, (Parcelable) fqVar.mo4889dw(), i, true);
        }
        if (di.contains(47)) {
            C0155b.m349a(parcel, 47, fqVar.getStartDate(), true);
        }
        if (di.contains(44)) {
            C0155b.m349a(parcel, 44, fqVar.getPostalCode(), true);
        }
        if (di.contains(45)) {
            C0155b.m349a(parcel, 45, fqVar.getRatingValue(), true);
        }
        if (di.contains(51)) {
            C0155b.m349a(parcel, 51, fqVar.getThumbnailUrl(), true);
        }
        if (di.contains(50)) {
            C0155b.m348a(parcel, 50, (Parcelable) fqVar.mo4890dx(), i, true);
        }
        if (di.contains(49)) {
            C0155b.m349a(parcel, 49, fqVar.getText(), true);
        }
        if (di.contains(48)) {
            C0155b.m349a(parcel, 48, fqVar.getStreetAddress(), true);
        }
        if (di.contains(55)) {
            C0155b.m349a(parcel, 55, fqVar.getWidth(), true);
        }
        if (di.contains(54)) {
            C0155b.m349a(parcel, 54, fqVar.getUrl(), true);
        }
        if (di.contains(53)) {
            C0155b.m349a(parcel, 53, fqVar.getType(), true);
        }
        if (di.contains(52)) {
            C0155b.m349a(parcel, 52, fqVar.getTickerSymbol(), true);
        }
        if (di.contains(56)) {
            C0155b.m349a(parcel, 56, fqVar.getWorstRating(), true);
        }
        C0155b.m340C(parcel, k);
    }

    /* renamed from: B */
    public C0558fq createFromParcel(Parcel parcel) {
        int j = C0153a.m320j(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        C0558fq fqVar = null;
        ArrayList<String> arrayList = null;
        C0558fq fqVar2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        ArrayList arrayList2 = null;
        int i2 = 0;
        ArrayList arrayList3 = null;
        C0558fq fqVar3 = null;
        ArrayList arrayList4 = null;
        String str4 = null;
        String str5 = null;
        C0558fq fqVar4 = null;
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
        C0558fq fqVar5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        C0558fq fqVar6 = null;
        double d = 0.0d;
        C0558fq fqVar7 = null;
        double d2 = 0.0d;
        String str22 = null;
        C0558fq fqVar8 = null;
        ArrayList arrayList6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        C0558fq fqVar9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        C0558fq fqVar10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < j) {
            int i3 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i3)) {
                case 1:
                    i = C0153a.m314f(parcel, i3);
                    hashSet.add(1);
                    break;
                case 2:
                    hashSet.add(2);
                    fqVar = (C0558fq) C0153a.m305a(parcel, i3, C0558fq.CREATOR);
                    break;
                case 3:
                    arrayList = C0153a.m334x(parcel, i3);
                    hashSet.add(3);
                    break;
                case 4:
                    hashSet.add(4);
                    fqVar2 = (C0558fq) C0153a.m305a(parcel, i3, C0558fq.CREATOR);
                    break;
                case 5:
                    str = C0153a.m322l(parcel, i3);
                    hashSet.add(5);
                    break;
                case 6:
                    str2 = C0153a.m322l(parcel, i3);
                    hashSet.add(6);
                    break;
                case 7:
                    str3 = C0153a.m322l(parcel, i3);
                    hashSet.add(7);
                    break;
                case 8:
                    arrayList2 = C0153a.m310c(parcel, i3, C0558fq.CREATOR);
                    hashSet.add(8);
                    break;
                case 9:
                    i2 = C0153a.m314f(parcel, i3);
                    hashSet.add(9);
                    break;
                case 10:
                    arrayList3 = C0153a.m310c(parcel, i3, C0558fq.CREATOR);
                    hashSet.add(10);
                    break;
                case 11:
                    hashSet.add(11);
                    fqVar3 = (C0558fq) C0153a.m305a(parcel, i3, C0558fq.CREATOR);
                    break;
                case 12:
                    arrayList4 = C0153a.m310c(parcel, i3, C0558fq.CREATOR);
                    hashSet.add(12);
                    break;
                case 13:
                    str4 = C0153a.m322l(parcel, i3);
                    hashSet.add(13);
                    break;
                case 14:
                    str5 = C0153a.m322l(parcel, i3);
                    hashSet.add(14);
                    break;
                case 15:
                    hashSet.add(15);
                    fqVar4 = (C0558fq) C0153a.m305a(parcel, i3, C0558fq.CREATOR);
                    break;
                case 16:
                    str6 = C0153a.m322l(parcel, i3);
                    hashSet.add(16);
                    break;
                case 17:
                    str7 = C0153a.m322l(parcel, i3);
                    hashSet.add(17);
                    break;
                case 18:
                    str8 = C0153a.m322l(parcel, i3);
                    hashSet.add(18);
                    break;
                case 19:
                    arrayList5 = C0153a.m310c(parcel, i3, C0558fq.CREATOR);
                    hashSet.add(19);
                    break;
                case 20:
                    str9 = C0153a.m322l(parcel, i3);
                    hashSet.add(20);
                    break;
                case 21:
                    str10 = C0153a.m322l(parcel, i3);
                    hashSet.add(21);
                    break;
                case 22:
                    str11 = C0153a.m322l(parcel, i3);
                    hashSet.add(22);
                    break;
                case 23:
                    str12 = C0153a.m322l(parcel, i3);
                    hashSet.add(23);
                    break;
                case 24:
                    str13 = C0153a.m322l(parcel, i3);
                    hashSet.add(24);
                    break;
                case 25:
                    str14 = C0153a.m322l(parcel, i3);
                    hashSet.add(25);
                    break;
                case 26:
                    str15 = C0153a.m322l(parcel, i3);
                    hashSet.add(26);
                    break;
                case 27:
                    str16 = C0153a.m322l(parcel, i3);
                    hashSet.add(27);
                    break;
                case 28:
                    str17 = C0153a.m322l(parcel, i3);
                    hashSet.add(28);
                    break;
                case 29:
                    hashSet.add(29);
                    fqVar5 = (C0558fq) C0153a.m305a(parcel, i3, C0558fq.CREATOR);
                    break;
                case 30:
                    str18 = C0153a.m322l(parcel, i3);
                    hashSet.add(30);
                    break;
                case 31:
                    str19 = C0153a.m322l(parcel, i3);
                    hashSet.add(31);
                    break;
                case 32:
                    str20 = C0153a.m322l(parcel, i3);
                    hashSet.add(32);
                    break;
                case 33:
                    str21 = C0153a.m322l(parcel, i3);
                    hashSet.add(33);
                    break;
                case 34:
                    hashSet.add(34);
                    fqVar6 = (C0558fq) C0153a.m305a(parcel, i3, C0558fq.CREATOR);
                    break;
                case 36:
                    d = C0153a.m319j(parcel, i3);
                    hashSet.add(36);
                    break;
                case 37:
                    hashSet.add(37);
                    fqVar7 = (C0558fq) C0153a.m305a(parcel, i3, C0558fq.CREATOR);
                    break;
                case 38:
                    d2 = C0153a.m319j(parcel, i3);
                    hashSet.add(38);
                    break;
                case 39:
                    str22 = C0153a.m322l(parcel, i3);
                    hashSet.add(39);
                    break;
                case 40:
                    hashSet.add(40);
                    fqVar8 = (C0558fq) C0153a.m305a(parcel, i3, C0558fq.CREATOR);
                    break;
                case 41:
                    arrayList6 = C0153a.m310c(parcel, i3, C0558fq.CREATOR);
                    hashSet.add(41);
                    break;
                case 42:
                    str23 = C0153a.m322l(parcel, i3);
                    hashSet.add(42);
                    break;
                case 43:
                    str24 = C0153a.m322l(parcel, i3);
                    hashSet.add(43);
                    break;
                case 44:
                    str25 = C0153a.m322l(parcel, i3);
                    hashSet.add(44);
                    break;
                case 45:
                    str26 = C0153a.m322l(parcel, i3);
                    hashSet.add(45);
                    break;
                case 46:
                    hashSet.add(46);
                    fqVar9 = (C0558fq) C0153a.m305a(parcel, i3, C0558fq.CREATOR);
                    break;
                case 47:
                    str27 = C0153a.m322l(parcel, i3);
                    hashSet.add(47);
                    break;
                case 48:
                    str28 = C0153a.m322l(parcel, i3);
                    hashSet.add(48);
                    break;
                case 49:
                    str29 = C0153a.m322l(parcel, i3);
                    hashSet.add(49);
                    break;
                case 50:
                    hashSet.add(50);
                    fqVar10 = (C0558fq) C0153a.m305a(parcel, i3, C0558fq.CREATOR);
                    break;
                case 51:
                    str30 = C0153a.m322l(parcel, i3);
                    hashSet.add(51);
                    break;
                case 52:
                    str31 = C0153a.m322l(parcel, i3);
                    hashSet.add(52);
                    break;
                case 53:
                    str32 = C0153a.m322l(parcel, i3);
                    hashSet.add(53);
                    break;
                case 54:
                    str33 = C0153a.m322l(parcel, i3);
                    hashSet.add(54);
                    break;
                case 55:
                    str34 = C0153a.m322l(parcel, i3);
                    hashSet.add(55);
                    break;
                case 56:
                    str35 = C0153a.m322l(parcel, i3);
                    hashSet.add(56);
                    break;
                default:
                    C0153a.m308b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0558fq(hashSet, i, fqVar, arrayList, fqVar2, str, str2, str3, arrayList2, i2, arrayList3, fqVar3, arrayList4, str4, str5, fqVar4, str6, str7, str8, arrayList5, str9, str10, str11, str12, str13, str14, str15, str16, str17, fqVar5, str18, str19, str20, str21, fqVar6, d, fqVar7, d2, str22, fqVar8, arrayList6, str23, str24, str25, str26, fqVar9, str27, str28, str29, fqVar10, str30, str31, str32, str33, str34, str35);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: ag */
    public C0558fq[] newArray(int i) {
        return new C0558fq[i];
    }
}
