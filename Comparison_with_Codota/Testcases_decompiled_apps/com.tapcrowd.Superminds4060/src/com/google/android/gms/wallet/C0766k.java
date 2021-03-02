package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

/* renamed from: com.google.android.gms.wallet.k */
public class C0766k implements Parcelable.Creator<ProxyCard> {
    /* renamed from: a */
    static void m2196a(ProxyCard proxyCard, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, proxyCard.getVersionCode());
        C0155b.m349a(parcel, 2, proxyCard.f1941um, false);
        C0155b.m349a(parcel, 3, proxyCard.f1942un, false);
        C0155b.m359c(parcel, 4, proxyCard.f1943uo);
        C0155b.m359c(parcel, 5, proxyCard.f1944up);
        C0155b.m340C(parcel, k);
    }

    /* renamed from: X */
    public ProxyCard createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int j = C0153a.m320j(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i4)) {
                case 1:
                    i3 = C0153a.m314f(parcel, i4);
                    break;
                case 2:
                    str2 = C0153a.m322l(parcel, i4);
                    break;
                case 3:
                    str = C0153a.m322l(parcel, i4);
                    break;
                case 4:
                    i2 = C0153a.m314f(parcel, i4);
                    break;
                case 5:
                    i = C0153a.m314f(parcel, i4);
                    break;
                default:
                    C0153a.m308b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    /* renamed from: aC */
    public ProxyCard[] newArray(int i) {
        return new ProxyCard[i];
    }
}
