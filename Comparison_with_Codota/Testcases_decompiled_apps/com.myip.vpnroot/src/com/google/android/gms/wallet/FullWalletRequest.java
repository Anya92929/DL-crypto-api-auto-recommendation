package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest implements SafeParcelable {
    public static final Parcelable.Creator<FullWalletRequest> CREATOR = new C2189g();

    /* renamed from: BR */
    private final int f4616BR;
    Cart asA;
    String asq;
    String asr;

    public final class Builder {
        private Builder() {
        }

        public FullWalletRequest build() {
            return FullWalletRequest.this;
        }

        public Builder setCart(Cart cart) {
            FullWalletRequest.this.asA = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            FullWalletRequest.this.asq = googleTransactionId;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            FullWalletRequest.this.asr = merchantTransactionId;
            return this;
        }
    }

    FullWalletRequest() {
        this.f4616BR = 1;
    }

    FullWalletRequest(int versionCode, String googleTransactionId, String merchantTransactionId, Cart cart) {
        this.f4616BR = versionCode;
        this.asq = googleTransactionId;
        this.asr = merchantTransactionId;
        this.asA = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.asA;
    }

    public String getGoogleTransactionId() {
        return this.asq;
    }

    public String getMerchantTransactionId() {
        return this.asr;
    }

    public int getVersionCode() {
        return this.f4616BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2189g.m7393a(this, dest, flags);
    }
}
