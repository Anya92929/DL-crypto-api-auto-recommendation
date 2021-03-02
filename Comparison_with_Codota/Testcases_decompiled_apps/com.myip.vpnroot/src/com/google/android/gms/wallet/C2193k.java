package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.k */
public class C2193k implements Parcelable.Creator<MaskedWallet> {
    /* renamed from: a */
    static void m7405a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, maskedWallet.getVersionCode());
        C0354b.m927a(parcel, 2, maskedWallet.asq, false);
        C0354b.m927a(parcel, 3, maskedWallet.asr, false);
        C0354b.m934a(parcel, 4, maskedWallet.asw, false);
        C0354b.m927a(parcel, 5, maskedWallet.ast, false);
        C0354b.m923a(parcel, 6, (Parcelable) maskedWallet.asu, i, false);
        C0354b.m923a(parcel, 7, (Parcelable) maskedWallet.asv, i, false);
        C0354b.m933a(parcel, 8, (T[]) maskedWallet.atb, i, false);
        C0354b.m933a(parcel, 9, (T[]) maskedWallet.atc, i, false);
        C0354b.m923a(parcel, 10, (Parcelable) maskedWallet.asx, i, false);
        C0354b.m923a(parcel, 11, (Parcelable) maskedWallet.asy, i, false);
        C0354b.m933a(parcel, 12, (T[]) maskedWallet.asz, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dw */
    public MaskedWallet createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
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
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    strArr = C0352a.m872A(parcel, B);
                    break;
                case 5:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    address = (Address) C0352a.m880a(parcel, B, Address.CREATOR);
                    break;
                case 7:
                    address2 = (Address) C0352a.m880a(parcel, B, Address.CREATOR);
                    break;
                case 8:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) C0352a.m886b(parcel, B, LoyaltyWalletObject.CREATOR);
                    break;
                case 9:
                    offerWalletObjectArr = (OfferWalletObject[]) C0352a.m886b(parcel, B, OfferWalletObject.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) C0352a.m880a(parcel, B, UserAddress.CREATOR);
                    break;
                case 11:
                    userAddress2 = (UserAddress) C0352a.m880a(parcel, B, UserAddress.CREATOR);
                    break;
                case 12:
                    instrumentInfoArr = (InstrumentInfo[]) C0352a.m886b(parcel, B, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fw */
    public MaskedWallet[] newArray(int i) {
        return new MaskedWallet[i];
    }
}
