package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.wallet.h */
public class C0763h implements Parcelable.Creator<MaskedWalletRequest> {
    /* renamed from: a */
    static void m2187a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, maskedWalletRequest.getVersionCode());
        C0155b.m349a(parcel, 2, maskedWalletRequest.f1923tI, false);
        C0155b.m352a(parcel, 3, maskedWalletRequest.f1925ub);
        C0155b.m352a(parcel, 4, maskedWalletRequest.f1926uc);
        C0155b.m352a(parcel, 5, maskedWalletRequest.f1927ud);
        C0155b.m349a(parcel, 6, maskedWalletRequest.f1928ue, false);
        C0155b.m349a(parcel, 7, maskedWalletRequest.f1922tE, false);
        C0155b.m349a(parcel, 8, maskedWalletRequest.f1929uf, false);
        C0155b.m348a(parcel, 9, (Parcelable) maskedWalletRequest.f1924tO, i, false);
        C0155b.m352a(parcel, 10, maskedWalletRequest.f1930ug);
        C0155b.m352a(parcel, 11, maskedWalletRequest.f1931uh);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: U */
    public MaskedWalletRequest createFromParcel(Parcel parcel) {
        Cart cart = null;
        boolean z = false;
        int j = C0153a.m320j(parcel);
        boolean z2 = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    str4 = C0153a.m322l(parcel, i2);
                    break;
                case 3:
                    z5 = C0153a.m311c(parcel, i2);
                    break;
                case 4:
                    z4 = C0153a.m311c(parcel, i2);
                    break;
                case 5:
                    z3 = C0153a.m311c(parcel, i2);
                    break;
                case 6:
                    str3 = C0153a.m322l(parcel, i2);
                    break;
                case 7:
                    str2 = C0153a.m322l(parcel, i2);
                    break;
                case 8:
                    str = C0153a.m322l(parcel, i2);
                    break;
                case 9:
                    cart = (Cart) C0153a.m305a(parcel, i2, Cart.CREATOR);
                    break;
                case 10:
                    z2 = C0153a.m311c(parcel, i2);
                    break;
                case 11:
                    z = C0153a.m311c(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new MaskedWalletRequest(i, str4, z5, z4, z3, str3, str2, str, cart, z2, z);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: az */
    public MaskedWalletRequest[] newArray(int i) {
        return new MaskedWalletRequest[i];
    }
}
