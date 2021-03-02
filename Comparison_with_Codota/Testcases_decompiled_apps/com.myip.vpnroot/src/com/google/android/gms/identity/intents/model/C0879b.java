package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.identity.intents.model.b */
public class C0879b implements Parcelable.Creator<UserAddress> {
    /* renamed from: a */
    static void m3789a(UserAddress userAddress, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, userAddress.getVersionCode());
        C0354b.m927a(parcel, 2, userAddress.name, false);
        C0354b.m927a(parcel, 3, userAddress.adC, false);
        C0354b.m927a(parcel, 4, userAddress.adD, false);
        C0354b.m927a(parcel, 5, userAddress.adE, false);
        C0354b.m927a(parcel, 6, userAddress.adF, false);
        C0354b.m927a(parcel, 7, userAddress.adG, false);
        C0354b.m927a(parcel, 8, userAddress.adH, false);
        C0354b.m927a(parcel, 9, userAddress.adI, false);
        C0354b.m927a(parcel, 10, userAddress.f2404uW, false);
        C0354b.m927a(parcel, 11, userAddress.adJ, false);
        C0354b.m927a(parcel, 12, userAddress.adK, false);
        C0354b.m927a(parcel, 13, userAddress.adL, false);
        C0354b.m930a(parcel, 14, userAddress.adM);
        C0354b.m927a(parcel, 15, userAddress.adN, false);
        C0354b.m927a(parcel, 16, userAddress.adO, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cr */
    public UserAddress createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 5:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    str6 = C0352a.m900o(parcel, B);
                    break;
                case 8:
                    str7 = C0352a.m900o(parcel, B);
                    break;
                case 9:
                    str8 = C0352a.m900o(parcel, B);
                    break;
                case 10:
                    str9 = C0352a.m900o(parcel, B);
                    break;
                case 11:
                    str10 = C0352a.m900o(parcel, B);
                    break;
                case 12:
                    str11 = C0352a.m900o(parcel, B);
                    break;
                case 13:
                    str12 = C0352a.m900o(parcel, B);
                    break;
                case 14:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 15:
                    str13 = C0352a.m900o(parcel, B);
                    break;
                case 16:
                    str14 = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dZ */
    public UserAddress[] newArray(int i) {
        return new UserAddress[i];
    }
}
