package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wallet.g */
public class C2189g implements Parcelable.Creator<FullWalletRequest> {
    /* renamed from: a */
    static void m7393a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, fullWalletRequest.getVersionCode());
        C0354b.m927a(parcel, 2, fullWalletRequest.asq, false);
        C0354b.m927a(parcel, 3, fullWalletRequest.asr, false);
        C0354b.m923a(parcel, 4, (Parcelable) fullWalletRequest.asA, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ds */
    public FullWalletRequest createFromParcel(Parcel parcel) {
        Cart cart = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    cart = (Cart) C0352a.m880a(parcel, B, Cart.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fs */
    public FullWalletRequest[] newArray(int i) {
        return new FullWalletRequest[i];
    }
}
