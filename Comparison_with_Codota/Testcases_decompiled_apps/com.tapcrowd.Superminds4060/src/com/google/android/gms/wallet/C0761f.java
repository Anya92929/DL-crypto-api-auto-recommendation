package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.wallet.f */
public class C0761f implements Parcelable.Creator<LoyaltyWalletObject> {
    /* renamed from: a */
    static void m2181a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, loyaltyWalletObject.getVersionCode());
        C0155b.m349a(parcel, 2, loyaltyWalletObject.f1907tU, false);
        C0155b.m349a(parcel, 3, loyaltyWalletObject.f1908tV, false);
        C0155b.m349a(parcel, 4, loyaltyWalletObject.f1909tW, false);
        C0155b.m349a(parcel, 5, loyaltyWalletObject.f1910tX, false);
        C0155b.m349a(parcel, 6, loyaltyWalletObject.f1911tY, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: S */
    public LoyaltyWalletObject createFromParcel(Parcel parcel) {
        String str = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    str5 = C0153a.m322l(parcel, i2);
                    break;
                case 3:
                    str4 = C0153a.m322l(parcel, i2);
                    break;
                case 4:
                    str3 = C0153a.m322l(parcel, i2);
                    break;
                case 5:
                    str2 = C0153a.m322l(parcel, i2);
                    break;
                case 6:
                    str = C0153a.m322l(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new LoyaltyWalletObject(i, str5, str4, str3, str2, str);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: ax */
    public LoyaltyWalletObject[] newArray(int i) {
        return new LoyaltyWalletObject[i];
    }
}
