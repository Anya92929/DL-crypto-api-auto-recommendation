package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* renamed from: com.google.android.gms.wallet.fragment.a */
public class C2186a implements Parcelable.Creator<WalletFragmentInitParams> {
    /* renamed from: a */
    static void m7384a(WalletFragmentInitParams walletFragmentInitParams, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, walletFragmentInitParams.f4633BR);
        C0354b.m927a(parcel, 2, walletFragmentInitParams.getAccountName(), false);
        C0354b.m923a(parcel, 3, (Parcelable) walletFragmentInitParams.getMaskedWalletRequest(), i, false);
        C0354b.m939c(parcel, 4, walletFragmentInitParams.getMaskedWalletRequestCode());
        C0354b.m923a(parcel, 5, (Parcelable) walletFragmentInitParams.getMaskedWallet(), i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dD */
    public WalletFragmentInitParams createFromParcel(Parcel parcel) {
        MaskedWallet maskedWallet = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        int i2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String str = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    maskedWalletRequest = (MaskedWalletRequest) C0352a.m880a(parcel, B, MaskedWalletRequest.CREATOR);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    maskedWallet = (MaskedWallet) C0352a.m880a(parcel, B, MaskedWallet.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new WalletFragmentInitParams(i, str, maskedWalletRequest, i2, maskedWallet);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fE */
    public WalletFragmentInitParams[] newArray(int i) {
        return new WalletFragmentInitParams[i];
    }
}
