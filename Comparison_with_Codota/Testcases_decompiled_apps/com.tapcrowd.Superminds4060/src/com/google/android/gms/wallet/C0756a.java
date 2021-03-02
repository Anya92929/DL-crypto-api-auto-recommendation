package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.wallet.a */
public class C0756a implements Parcelable.Creator<Address> {
    /* renamed from: a */
    static void m2166a(Address address, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, address.getVersionCode());
        C0155b.m349a(parcel, 2, address.name, false);
        C0155b.m349a(parcel, 3, address.f1875tu, false);
        C0155b.m349a(parcel, 4, address.f1876tv, false);
        C0155b.m349a(parcel, 5, address.f1877tw, false);
        C0155b.m349a(parcel, 6, address.f1870hl, false);
        C0155b.m349a(parcel, 7, address.f1878tx, false);
        C0155b.m349a(parcel, 8, address.f1879ty, false);
        C0155b.m349a(parcel, 9, address.f1880tz, false);
        C0155b.m349a(parcel, 10, address.f1872tA, false);
        C0155b.m352a(parcel, 11, address.f1873tB);
        C0155b.m349a(parcel, 12, address.f1874tC, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: N */
    public Address createFromParcel(Parcel parcel) {
        int j = C0153a.m320j(parcel);
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
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    str = C0153a.m322l(parcel, i2);
                    break;
                case 3:
                    str2 = C0153a.m322l(parcel, i2);
                    break;
                case 4:
                    str3 = C0153a.m322l(parcel, i2);
                    break;
                case 5:
                    str4 = C0153a.m322l(parcel, i2);
                    break;
                case 6:
                    str5 = C0153a.m322l(parcel, i2);
                    break;
                case 7:
                    str6 = C0153a.m322l(parcel, i2);
                    break;
                case 8:
                    str7 = C0153a.m322l(parcel, i2);
                    break;
                case 9:
                    str8 = C0153a.m322l(parcel, i2);
                    break;
                case 10:
                    str9 = C0153a.m322l(parcel, i2);
                    break;
                case 11:
                    z = C0153a.m311c(parcel, i2);
                    break;
                case 12:
                    str10 = C0153a.m322l(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new Address(i, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: as */
    public Address[] newArray(int i) {
        return new Address[i];
    }
}
