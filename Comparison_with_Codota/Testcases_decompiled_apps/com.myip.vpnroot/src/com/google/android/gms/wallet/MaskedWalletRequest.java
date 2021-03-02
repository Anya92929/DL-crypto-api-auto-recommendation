package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new C2194l();

    /* renamed from: BR */
    private final int f4623BR;
    Cart asA;
    String asl;
    String asr;
    boolean ate;
    boolean atf;
    boolean atg;
    String ath;
    String ati;
    boolean atj;
    boolean atk;
    CountrySpecification[] atl;
    boolean atm;
    boolean atn;
    ArrayList<CountrySpecification> ato;

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (MaskedWalletRequest.this.ato == null) {
                MaskedWalletRequest.this.ato = new ArrayList<>();
            }
            MaskedWalletRequest.this.ato.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> countrySpecifications) {
            if (countrySpecifications != null) {
                if (MaskedWalletRequest.this.ato == null) {
                    MaskedWalletRequest.this.ato = new ArrayList<>();
                }
                MaskedWalletRequest.this.ato.addAll(countrySpecifications);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public Builder setAllowDebitCard(boolean allowDebitCard) {
            MaskedWalletRequest.this.atn = allowDebitCard;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean allowPrepaidCard) {
            MaskedWalletRequest.this.atm = allowPrepaidCard;
            return this;
        }

        public Builder setCart(Cart cart) {
            MaskedWalletRequest.this.asA = cart;
            return this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            MaskedWalletRequest.this.asl = currencyCode;
            return this;
        }

        public Builder setEstimatedTotalPrice(String estimatedTotalPrice) {
            MaskedWalletRequest.this.ath = estimatedTotalPrice;
            return this;
        }

        public Builder setIsBillingAgreement(boolean isBillingAgreement) {
            MaskedWalletRequest.this.atk = isBillingAgreement;
            return this;
        }

        public Builder setMerchantName(String merchantName) {
            MaskedWalletRequest.this.ati = merchantName;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            MaskedWalletRequest.this.asr = merchantTransactionId;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean phoneNumberRequired) {
            MaskedWalletRequest.this.ate = phoneNumberRequired;
            return this;
        }

        public Builder setShippingAddressRequired(boolean shippingAddressRequired) {
            MaskedWalletRequest.this.atf = shippingAddressRequired;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean shouldRetrieveWalletObjects) {
            MaskedWalletRequest.this.atj = shouldRetrieveWalletObjects;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean useMinimalBillingAddress) {
            MaskedWalletRequest.this.atg = useMinimalBillingAddress;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.f4623BR = 3;
        this.atm = true;
        this.atn = true;
    }

    MaskedWalletRequest(int versionCode, String merchantTransactionId, boolean phoneNumberRequired, boolean shippingAddressRequired, boolean useMinimalBillingAddress, String estimatedTotalPrice, String currencyCode, String merchantName, Cart cart, boolean shouldRetrieveWalletObjects, boolean isBillingAgreement, CountrySpecification[] allowedShippingCountrySpecifications, boolean allowPrepaidCard, boolean allowDebitCard, ArrayList<CountrySpecification> allowedCountrySpecificationsForShipping) {
        this.f4623BR = versionCode;
        this.asr = merchantTransactionId;
        this.ate = phoneNumberRequired;
        this.atf = shippingAddressRequired;
        this.atg = useMinimalBillingAddress;
        this.ath = estimatedTotalPrice;
        this.asl = currencyCode;
        this.ati = merchantName;
        this.asA = cart;
        this.atj = shouldRetrieveWalletObjects;
        this.atk = isBillingAgreement;
        this.atl = allowedShippingCountrySpecifications;
        this.atm = allowPrepaidCard;
        this.atn = allowDebitCard;
        this.ato = allowedCountrySpecificationsForShipping;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.atn;
    }

    public boolean allowPrepaidCard() {
        return this.atm;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.ato;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.atl;
    }

    public Cart getCart() {
        return this.asA;
    }

    public String getCurrencyCode() {
        return this.asl;
    }

    public String getEstimatedTotalPrice() {
        return this.ath;
    }

    public String getMerchantName() {
        return this.ati;
    }

    public String getMerchantTransactionId() {
        return this.asr;
    }

    public int getVersionCode() {
        return this.f4623BR;
    }

    public boolean isBillingAgreement() {
        return this.atk;
    }

    public boolean isPhoneNumberRequired() {
        return this.ate;
    }

    public boolean isShippingAddressRequired() {
        return this.atf;
    }

    public boolean shouldRetrieveWalletObjects() {
        return this.atj;
    }

    public boolean useMinimalBillingAddress() {
        return this.atg;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2194l.m7408a(this, dest, flags);
    }
}
