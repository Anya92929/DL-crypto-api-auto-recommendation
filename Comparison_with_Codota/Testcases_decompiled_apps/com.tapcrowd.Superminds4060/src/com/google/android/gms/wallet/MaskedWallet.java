package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MaskedWallet implements SafeParcelable {
    public static final Parcelable.Creator<MaskedWallet> CREATOR = new C0762g();

    /* renamed from: iM */
    private final int f1912iM;

    /* renamed from: tH */
    String f1913tH;

    /* renamed from: tI */
    String f1914tI;

    /* renamed from: tK */
    String f1915tK;

    /* renamed from: tL */
    Address f1916tL;

    /* renamed from: tM */
    Address f1917tM;

    /* renamed from: tN */
    String[] f1918tN;

    /* renamed from: tZ */
    LoyaltyWalletObject[] f1919tZ;

    /* renamed from: ua */
    OfferWalletObject[] f1920ua;

    public MaskedWallet() {
        this.f1912iM = 2;
    }

    MaskedWallet(int versionCode, String googleTransactionId, String merchantTransactionId, String[] paymentDescriptions, String email, Address billingAddress, Address shippingAddress, LoyaltyWalletObject[] loyaltyWalletObjects, OfferWalletObject[] offerWalletObjects) {
        this.f1912iM = versionCode;
        this.f1913tH = googleTransactionId;
        this.f1914tI = merchantTransactionId;
        this.f1918tN = paymentDescriptions;
        this.f1915tK = email;
        this.f1916tL = billingAddress;
        this.f1917tM = shippingAddress;
        this.f1919tZ = loyaltyWalletObjects;
        this.f1920ua = offerWalletObjects;
    }

    public int describeContents() {
        return 0;
    }

    public Address getBillingAddress() {
        return this.f1916tL;
    }

    public String getEmail() {
        return this.f1915tK;
    }

    public String getGoogleTransactionId() {
        return this.f1913tH;
    }

    public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.f1919tZ;
    }

    public String getMerchantTransactionId() {
        return this.f1914tI;
    }

    public OfferWalletObject[] getOfferWalletObjects() {
        return this.f1920ua;
    }

    public String[] getPaymentDescriptions() {
        return this.f1918tN;
    }

    public Address getShippingAddress() {
        return this.f1917tM;
    }

    public int getVersionCode() {
        return this.f1912iM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0762g.m2184a(this, dest, flags);
    }
}
