package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

/* renamed from: com.google.android.gms.wallet.e */
public class C2174e implements Parcelable.Creator<C2173d> {
    /* renamed from: a */
    static void m7303a(C2173d dVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, dVar.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) dVar.aso, i, false);
        C0354b.m923a(parcel, 3, (Parcelable) dVar.asp, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: dq */
    public C2173d createFromParcel(Parcel parcel) {
        OfferWalletObject offerWalletObject;
        LoyaltyWalletObject loyaltyWalletObject;
        int i;
        OfferWalletObject offerWalletObject2 = null;
        int C = C0352a.m875C(parcel);
        int i2 = 0;
        LoyaltyWalletObject loyaltyWalletObject2 = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    OfferWalletObject offerWalletObject3 = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = C0352a.m892g(parcel, B);
                    offerWalletObject = offerWalletObject3;
                    break;
                case 2:
                    i = i2;
                    LoyaltyWalletObject loyaltyWalletObject3 = (LoyaltyWalletObject) C0352a.m880a(parcel, B, LoyaltyWalletObject.CREATOR);
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject3;
                    break;
                case 3:
                    offerWalletObject = (OfferWalletObject) C0352a.m880a(parcel, B, OfferWalletObject.CREATOR);
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = i2;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    offerWalletObject = offerWalletObject2;
                    loyaltyWalletObject = loyaltyWalletObject2;
                    i = i2;
                    break;
            }
            i2 = i;
            loyaltyWalletObject2 = loyaltyWalletObject;
            offerWalletObject2 = offerWalletObject;
        }
        if (parcel.dataPosition() == C) {
            return new C2173d(i2, loyaltyWalletObject2, offerWalletObject2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: fq */
    public C2173d[] newArray(int i) {
        return new C2173d[i];
    }
}
