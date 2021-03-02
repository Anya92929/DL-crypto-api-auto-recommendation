package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.wallet.g */
public class C0762g implements Parcelable.Creator<MaskedWallet> {
    /* renamed from: a */
    static void m2184a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, maskedWallet.getVersionCode());
        C0155b.m349a(parcel, 2, maskedWallet.f1913tH, false);
        C0155b.m349a(parcel, 3, maskedWallet.f1914tI, false);
        C0155b.m355a(parcel, 4, maskedWallet.f1918tN, false);
        C0155b.m349a(parcel, 5, maskedWallet.f1915tK, false);
        C0155b.m348a(parcel, 6, (Parcelable) maskedWallet.f1916tL, i, false);
        C0155b.m348a(parcel, 7, (Parcelable) maskedWallet.f1917tM, i, false);
        C0155b.m354a(parcel, 8, (T[]) maskedWallet.f1919tZ, i, false);
        C0155b.m354a(parcel, 9, (T[]) maskedWallet.f1920ua, i, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: T */
    public MaskedWallet createFromParcel(Parcel parcel) {
        OfferWalletObject[] offerWalletObjectArr = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        String[] strArr = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    str3 = C0153a.m322l(parcel, i2);
                    break;
                case 3:
                    str2 = C0153a.m322l(parcel, i2);
                    break;
                case 4:
                    strArr = C0153a.m333w(parcel, i2);
                    break;
                case 5:
                    str = C0153a.m322l(parcel, i2);
                    break;
                case 6:
                    address2 = (Address) C0153a.m305a(parcel, i2, Address.CREATOR);
                    break;
                case 7:
                    address = (Address) C0153a.m305a(parcel, i2, Address.CREATOR);
                    break;
                case 8:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) C0153a.m309b(parcel, i2, LoyaltyWalletObject.CREATOR);
                    break;
                case 9:
                    offerWalletObjectArr = (OfferWalletObject[]) C0153a.m309b(parcel, i2, OfferWalletObject.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new MaskedWallet(i, str3, str2, strArr, str, address2, address, loyaltyWalletObjectArr, offerWalletObjectArr);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: ay */
    public MaskedWallet[] newArray(int i) {
        return new MaskedWallet[i];
    }
}
