package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.wallet.j */
public class C0765j implements Parcelable.Creator<OfferWalletObject> {
    /* renamed from: a */
    static void m2193a(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, offerWalletObject.getVersionCode());
        C0155b.m349a(parcel, 2, offerWalletObject.f1938tU, false);
        C0155b.m349a(parcel, 3, offerWalletObject.f1939ul, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: W */
    public OfferWalletObject createFromParcel(Parcel parcel) {
        String str = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    str2 = C0153a.m322l(parcel, i2);
                    break;
                case 3:
                    str = C0153a.m322l(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new OfferWalletObject(i, str2, str);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: aB */
    public OfferWalletObject[] newArray(int i) {
        return new OfferWalletObject[i];
    }
}
