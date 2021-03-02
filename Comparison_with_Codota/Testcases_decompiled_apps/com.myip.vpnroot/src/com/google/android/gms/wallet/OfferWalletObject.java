package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<OfferWalletObject> CREATOR = new C2196n();

    /* renamed from: BR */
    private final int f4625BR;
    String ats;
    CommonWalletObject att;

    /* renamed from: fl */
    String f4626fl;

    OfferWalletObject() {
        this.f4625BR = 3;
    }

    OfferWalletObject(int versionCode, String id, String redemptionCode, CommonWalletObject commonWalletObject) {
        this.f4625BR = versionCode;
        this.ats = redemptionCode;
        if (versionCode < 3) {
            this.att = CommonWalletObject.m7420pO().mo12101dc(id).mo12102pP();
        } else {
            this.att = commonWalletObject;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.att.getId();
    }

    public String getRedemptionCode() {
        return this.ats;
    }

    public int getVersionCode() {
        return this.f4625BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2196n.m7414a(this, dest, flags);
    }
}
