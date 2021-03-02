package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wallet.fragment.c */
public class C2188c implements Parcelable.Creator<WalletFragmentStyle> {
    /* renamed from: a */
    static void m7390a(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, walletFragmentStyle.f4637BR);
        C0354b.m920a(parcel, 2, walletFragmentStyle.aud, false);
        C0354b.m939c(parcel, 3, walletFragmentStyle.aue);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dF */
    public WalletFragmentStyle createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    bundle = C0352a.m902q(parcel, B);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fG */
    public WalletFragmentStyle[] newArray(int i) {
        return new WalletFragmentStyle[i];
    }
}
