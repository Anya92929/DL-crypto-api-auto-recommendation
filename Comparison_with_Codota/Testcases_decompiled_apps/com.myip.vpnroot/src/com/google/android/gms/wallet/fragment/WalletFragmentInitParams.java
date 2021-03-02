package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentInitParams> CREATOR = new C2186a();

    /* renamed from: BR */
    final int f4633BR;
    /* access modifiers changed from: private */

    /* renamed from: Dd */
    public String f4634Dd;
    /* access modifiers changed from: private */
    public MaskedWalletRequest atL;
    /* access modifiers changed from: private */
    public MaskedWallet atM;
    /* access modifiers changed from: private */
    public int atZ;

    public final class Builder {
        private Builder() {
        }

        public WalletFragmentInitParams build() {
            boolean z = true;
            C0348n.m852a((WalletFragmentInitParams.this.atM != null && WalletFragmentInitParams.this.atL == null) || (WalletFragmentInitParams.this.atM == null && WalletFragmentInitParams.this.atL != null), "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            if (WalletFragmentInitParams.this.atZ < 0) {
                z = false;
            }
            C0348n.m852a(z, "masked wallet request code is required and must be non-negative");
            return WalletFragmentInitParams.this;
        }

        public Builder setAccountName(String accountName) {
            String unused = WalletFragmentInitParams.this.f4634Dd = accountName;
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedWallet) {
            MaskedWallet unused = WalletFragmentInitParams.this.atM = maskedWallet;
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest request) {
            MaskedWalletRequest unused = WalletFragmentInitParams.this.atL = request;
            return this;
        }

        public Builder setMaskedWalletRequestCode(int requestCode) {
            int unused = WalletFragmentInitParams.this.atZ = requestCode;
            return this;
        }
    }

    private WalletFragmentInitParams() {
        this.f4633BR = 1;
        this.atZ = -1;
    }

    WalletFragmentInitParams(int versionCode, String accountName, MaskedWalletRequest maskedWalletRequest, int maskedWalletRequestCode, MaskedWallet maskedWallet) {
        this.f4633BR = versionCode;
        this.f4634Dd = accountName;
        this.atL = maskedWalletRequest;
        this.atZ = maskedWalletRequestCode;
        this.atM = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.f4634Dd;
    }

    public MaskedWallet getMaskedWallet() {
        return this.atM;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.atL;
    }

    public int getMaskedWalletRequestCode() {
        return this.atZ;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2186a.m7384a(this, dest, flags);
    }
}
