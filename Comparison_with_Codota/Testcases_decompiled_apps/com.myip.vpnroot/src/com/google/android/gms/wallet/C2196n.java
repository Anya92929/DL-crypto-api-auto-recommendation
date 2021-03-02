package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

/* renamed from: com.google.android.gms.wallet.n */
public class C2196n implements Parcelable.Creator<OfferWalletObject> {
    /* renamed from: a */
    static void m7414a(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, offerWalletObject.getVersionCode());
        C0354b.m927a(parcel, 2, offerWalletObject.f4626fl, false);
        C0354b.m927a(parcel, 3, offerWalletObject.ats, false);
        C0354b.m923a(parcel, 4, (Parcelable) offerWalletObject.att, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dz */
    public OfferWalletObject createFromParcel(Parcel parcel) {
        CommonWalletObject commonWalletObject = null;
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
                    commonWalletObject = (CommonWalletObject) C0352a.m880a(parcel, B, CommonWalletObject.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new OfferWalletObject(i, str2, str, commonWalletObject);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fz */
    public OfferWalletObject[] newArray(int i) {
        return new OfferWalletObject[i];
    }
}
