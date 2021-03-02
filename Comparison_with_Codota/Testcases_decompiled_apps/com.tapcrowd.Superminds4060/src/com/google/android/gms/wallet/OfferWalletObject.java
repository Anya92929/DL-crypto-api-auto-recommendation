package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OfferWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<OfferWalletObject> CREATOR = new C0765j();

    /* renamed from: iM */
    private final int f1937iM;

    /* renamed from: tU */
    String f1938tU;

    /* renamed from: ul */
    String f1939ul;

    public OfferWalletObject() {
        this.f1937iM = 2;
    }

    OfferWalletObject(int versionCode, String id, String redemptionCode) {
        this.f1937iM = versionCode;
        this.f1938tU = id;
        this.f1939ul = redemptionCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f1938tU;
    }

    public String getRedemptionCode() {
        return this.f1939ul;
    }

    public int getVersionCode() {
        return this.f1937iM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0765j.m2193a(this, dest, flags);
    }
}
