package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.f */
public class C2175f implements Parcelable.Creator<FullWallet> {
    /* renamed from: a */
    static void m7306a(FullWallet fullWallet, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, fullWallet.getVersionCode());
        C0354b.m927a(parcel, 2, fullWallet.asq, false);
        C0354b.m927a(parcel, 3, fullWallet.asr, false);
        C0354b.m923a(parcel, 4, (Parcelable) fullWallet.ass, i, false);
        C0354b.m927a(parcel, 5, fullWallet.ast, false);
        C0354b.m923a(parcel, 6, (Parcelable) fullWallet.asu, i, false);
        C0354b.m923a(parcel, 7, (Parcelable) fullWallet.asv, i, false);
        C0354b.m934a(parcel, 8, fullWallet.asw, false);
        C0354b.m923a(parcel, 9, (Parcelable) fullWallet.asx, i, false);
        C0354b.m923a(parcel, 10, (Parcelable) fullWallet.asy, i, false);
        C0354b.m933a(parcel, 11, (T[]) fullWallet.asz, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dr */
    public FullWallet createFromParcel(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    proxyCard = (ProxyCard) C0352a.m880a(parcel, B, ProxyCard.CREATOR);
                    break;
                case 5:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    address2 = (Address) C0352a.m880a(parcel, B, Address.CREATOR);
                    break;
                case 7:
                    address = (Address) C0352a.m880a(parcel, B, Address.CREATOR);
                    break;
                case 8:
                    strArr = C0352a.m872A(parcel, B);
                    break;
                case 9:
                    userAddress2 = (UserAddress) C0352a.m880a(parcel, B, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) C0352a.m880a(parcel, B, UserAddress.CREATOR);
                    break;
                case 11:
                    instrumentInfoArr = (InstrumentInfo[]) C0352a.m886b(parcel, B, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fr */
    public FullWallet[] newArray(int i) {
        return new FullWallet[i];
    }
}
