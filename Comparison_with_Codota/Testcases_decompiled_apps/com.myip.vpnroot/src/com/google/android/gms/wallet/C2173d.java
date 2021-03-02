package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.d */
public final class C2173d implements SafeParcelable {
    public static final Parcelable.Creator<C2173d> CREATOR = new C2174e();

    /* renamed from: BR */
    private final int f4630BR;
    LoyaltyWalletObject aso;
    OfferWalletObject asp;

    C2173d() {
        this.f4630BR = 2;
    }

    C2173d(int i, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject) {
        this.f4630BR = i;
        this.aso = loyaltyWalletObject;
        this.asp = offerWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f4630BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2174e.m7303a(this, dest, flags);
    }
}
