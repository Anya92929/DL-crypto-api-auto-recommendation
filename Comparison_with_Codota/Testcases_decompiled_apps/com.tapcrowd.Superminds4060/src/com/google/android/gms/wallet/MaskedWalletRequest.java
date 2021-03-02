package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class MaskedWalletRequest implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new C0763h();

    /* renamed from: iM */
    private final int f1921iM;

    /* renamed from: tE */
    String f1922tE;

    /* renamed from: tI */
    String f1923tI;

    /* renamed from: tO */
    Cart f1924tO;

    /* renamed from: ub */
    boolean f1925ub;

    /* renamed from: uc */
    boolean f1926uc;

    /* renamed from: ud */
    boolean f1927ud;

    /* renamed from: ue */
    String f1928ue;

    /* renamed from: uf */
    String f1929uf;

    /* renamed from: ug */
    boolean f1930ug;

    /* renamed from: uh */
    boolean f1931uh;

    public final class Builder {
        private Builder() {
        }

        public MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public Builder setCart(Cart cart) {
            MaskedWalletRequest.this.f1924tO = cart;
            return this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            MaskedWalletRequest.this.f1922tE = currencyCode;
            return this;
        }

        public Builder setEstimatedTotalPrice(String estimatedTotalPrice) {
            MaskedWalletRequest.this.f1928ue = estimatedTotalPrice;
            return this;
        }

        public Builder setIsBillingAgreement(boolean isBillingAgreement) {
            MaskedWalletRequest.this.f1931uh = isBillingAgreement;
            return this;
        }

        public Builder setMerchantName(String merchantName) {
            MaskedWalletRequest.this.f1929uf = merchantName;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            MaskedWalletRequest.this.f1923tI = merchantTransactionId;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean phoneNumberRequired) {
            MaskedWalletRequest.this.f1925ub = phoneNumberRequired;
            return this;
        }

        public Builder setShippingAddressRequired(boolean shippingAddressRequired) {
            MaskedWalletRequest.this.f1926uc = shippingAddressRequired;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean shouldRetrieveWalletObjects) {
            MaskedWalletRequest.this.f1930ug = shouldRetrieveWalletObjects;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean useMinimalBillingAddress) {
            MaskedWalletRequest.this.f1927ud = useMinimalBillingAddress;
            return this;
        }
    }

    public MaskedWalletRequest() {
        this.f1921iM = 2;
    }

    MaskedWalletRequest(int versionCode, String merchantTransactionId, boolean phoneNumberRequired, boolean shippingAddressRequired, boolean useMinimalBillingAddress, String estimatedTotalPrice, String currencyCode, String merchantName, Cart cart, boolean shouldRetrieveWalletObjects, boolean isBillingAgreement) {
        this.f1921iM = versionCode;
        this.f1923tI = merchantTransactionId;
        this.f1925ub = phoneNumberRequired;
        this.f1926uc = shippingAddressRequired;
        this.f1927ud = useMinimalBillingAddress;
        this.f1928ue = estimatedTotalPrice;
        this.f1922tE = currencyCode;
        this.f1929uf = merchantName;
        this.f1924tO = cart;
        this.f1930ug = shouldRetrieveWalletObjects;
        this.f1931uh = isBillingAgreement;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.f1924tO;
    }

    public String getCurrencyCode() {
        return this.f1922tE;
    }

    public String getEstimatedTotalPrice() {
        return this.f1928ue;
    }

    public String getMerchantName() {
        return this.f1929uf;
    }

    public String getMerchantTransactionId() {
        return this.f1923tI;
    }

    public int getVersionCode() {
        return this.f1921iM;
    }

    public boolean isBillingAgreement() {
        return this.f1931uh;
    }

    public boolean isPhoneNumberRequired() {
        return this.f1925ub;
    }

    public boolean isShippingAddressRequired() {
        return this.f1926uc;
    }

    public boolean shouldRetrieveWalletObjects() {
        return this.f1930ug;
    }

    public boolean useMinimalBillingAddress() {
        return this.f1927ud;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0763h.m2187a(this, dest, flags);
    }
}
