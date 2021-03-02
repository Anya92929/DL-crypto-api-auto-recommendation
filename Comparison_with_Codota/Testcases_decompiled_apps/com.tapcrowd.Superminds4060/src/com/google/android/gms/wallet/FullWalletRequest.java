package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FullWalletRequest implements SafeParcelable {
    public static final Parcelable.Creator<FullWalletRequest> CREATOR = new C0759d();

    /* renamed from: iM */
    private final int f1894iM;

    /* renamed from: tH */
    String f1895tH;

    /* renamed from: tI */
    String f1896tI;

    /* renamed from: tO */
    Cart f1897tO;

    public final class Builder {
        private Builder() {
        }

        public FullWalletRequest build() {
            return FullWalletRequest.this;
        }

        public Builder setCart(Cart cart) {
            FullWalletRequest.this.f1897tO = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            FullWalletRequest.this.f1895tH = googleTransactionId;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            FullWalletRequest.this.f1896tI = merchantTransactionId;
            return this;
        }
    }

    public FullWalletRequest() {
        this.f1894iM = 1;
    }

    FullWalletRequest(int versionCode, String googleTransactionId, String merchantTransactionId, Cart cart) {
        this.f1894iM = versionCode;
        this.f1895tH = googleTransactionId;
        this.f1896tI = merchantTransactionId;
        this.f1897tO = cart;
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
        return this.f1897tO;
    }

    public String getGoogleTransactionId() {
        return this.f1895tH;
    }

    public String getMerchantTransactionId() {
        return this.f1896tI;
    }

    public int getVersionCode() {
        return this.f1894iM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0759d.m2175a(this, dest, flags);
    }
}
