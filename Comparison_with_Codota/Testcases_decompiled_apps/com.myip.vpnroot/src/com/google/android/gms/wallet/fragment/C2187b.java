package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wallet.fragment.b */
public class C2187b implements Parcelable.Creator<WalletFragmentOptions> {
    /* renamed from: a */
    static void m7387a(WalletFragmentOptions walletFragmentOptions, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, walletFragmentOptions.f4635BR);
        C0354b.m939c(parcel, 2, walletFragmentOptions.getEnvironment());
        C0354b.m939c(parcel, 3, walletFragmentOptions.getTheme());
        C0354b.m923a(parcel, 4, (Parcelable) walletFragmentOptions.getFragmentStyle(), i, false);
        C0354b.m939c(parcel, 5, walletFragmentOptions.getMode());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dE */
    public WalletFragmentOptions createFromParcel(Parcel parcel) {
        int i = 1;
        int i2 = 0;
        int C = C0352a.m875C(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int i3 = 1;
        int i4 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 4:
                    walletFragmentStyle = (WalletFragmentStyle) C0352a.m880a(parcel, B, WalletFragmentStyle.CREATOR);
                    break;
                case 5:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new WalletFragmentOptions(i4, i3, i2, walletFragmentStyle, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fF */
    public WalletFragmentOptions[] newArray(int i) {
        return new WalletFragmentOptions[i];
    }
}
