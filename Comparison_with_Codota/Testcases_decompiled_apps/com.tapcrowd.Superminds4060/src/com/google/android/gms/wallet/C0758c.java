package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.wallet.c */
public class C0758c implements Parcelable.Creator<FullWallet> {
    /* renamed from: a */
    static void m2172a(FullWallet fullWallet, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, fullWallet.getVersionCode());
        C0155b.m349a(parcel, 2, fullWallet.f1887tH, false);
        C0155b.m349a(parcel, 3, fullWallet.f1888tI, false);
        C0155b.m348a(parcel, 4, (Parcelable) fullWallet.f1889tJ, i, false);
        C0155b.m349a(parcel, 5, fullWallet.f1890tK, false);
        C0155b.m348a(parcel, 6, (Parcelable) fullWallet.f1891tL, i, false);
        C0155b.m348a(parcel, 7, (Parcelable) fullWallet.f1892tM, i, false);
        C0155b.m355a(parcel, 8, fullWallet.f1893tN, false);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: P */
    public FullWallet createFromParcel(Parcel parcel) {
        String[] strArr = null;
        int j = C0153a.m320j(parcel);
        int i = 0;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
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
                    proxyCard = (ProxyCard) C0153a.m305a(parcel, i2, ProxyCard.CREATOR);
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
                    strArr = C0153a.m333w(parcel, i2);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: au */
    public FullWallet[] newArray(int i) {
        return new FullWallet[i];
    }
}
