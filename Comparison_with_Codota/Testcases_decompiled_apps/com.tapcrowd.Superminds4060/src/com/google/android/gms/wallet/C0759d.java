package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.wallet.d */
public class C0759d implements Parcelable.Creator<FullWalletRequest> {
    /* renamed from: a */
    static void m2175a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, fullWalletRequest.getVersionCode());
        C0155b.m349a(parcel, 2, fullWalletRequest.f1895tH, false);
        C0155b.m349a(parcel, 3, fullWalletRequest.f1896tI, false);
        C0155b.m348a(parcel, 4, (Parcelable) fullWalletRequest.f1897tO, i, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: Q */
    public FullWalletRequest createFromParcel(Parcel parcel) {
        Cart cart = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        String str = null;
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
                case 4:
                    cart = (Cart) C0153a.m305a(parcel, i2, Cart.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: av */
    public FullWalletRequest[] newArray(int i) {
        return new FullWalletRequest[i];
    }
}
