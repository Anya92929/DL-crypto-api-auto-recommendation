package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wallet.a */
public class C2170a implements Parcelable.Creator<Address> {
    /* renamed from: a */
    static void m7294a(Address address, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, address.getVersionCode());
        C0354b.m927a(parcel, 2, address.name, false);
        C0354b.m927a(parcel, 3, address.adC, false);
        C0354b.m927a(parcel, 4, address.adD, false);
        C0354b.m927a(parcel, 5, address.adE, false);
        C0354b.m927a(parcel, 6, address.f4611uW, false);
        C0354b.m927a(parcel, 7, address.asi, false);
        C0354b.m927a(parcel, 8, address.asj, false);
        C0354b.m927a(parcel, 9, address.adJ, false);
        C0354b.m927a(parcel, 10, address.adL, false);
        C0354b.m930a(parcel, 11, address.adM);
        C0354b.m927a(parcel, 12, address.adN, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dn */
    public Address createFromParcel(Parcel parcel) {
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
        boolean z = false;
        String str10 = null;
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
                    z = C0352a.m888c(parcel, B);
                    break;
                case 12:
                    str10 = C0352a.m900o(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new Address(i, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fn */
    public Address[] newArray(int i) {
        return new Address[i];
    }
}
