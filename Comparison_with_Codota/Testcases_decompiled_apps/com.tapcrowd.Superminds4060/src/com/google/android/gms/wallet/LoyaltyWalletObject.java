package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LoyaltyWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new C0761f();

    /* renamed from: iM */
    private final int f1906iM;

    /* renamed from: tU */
    String f1907tU;

    /* renamed from: tV */
    String f1908tV;

    /* renamed from: tW */
    String f1909tW;

    /* renamed from: tX */
    String f1910tX;

    /* renamed from: tY */
    String f1911tY;

    public LoyaltyWalletObject() {
        this.f1906iM = 2;
    }

    LoyaltyWalletObject(int versionCode, String id, String accountId, String issuerName, String programName, String accountName) {
        this.f1906iM = versionCode;
        this.f1907tU = id;
        this.f1908tV = accountId;
        this.f1909tW = issuerName;
        this.f1910tX = programName;
        this.f1911tY = accountName;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.f1908tV;
    }

    public String getAccountName() {
        return this.f1911tY;
    }

    public String getId() {
        return this.f1907tU;
    }

    public String getIssuerName() {
        return this.f1909tW;
    }

    public String getProgramName() {
        return this.f1910tX;
    }

    public int getVersionCode() {
        return this.f1906iM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0761f.m2181a(this, dest, flags);
    }
}
