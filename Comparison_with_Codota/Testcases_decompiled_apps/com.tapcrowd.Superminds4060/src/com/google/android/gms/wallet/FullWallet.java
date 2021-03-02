package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWallet implements SafeParcelable {
    public static final Parcelable.Creator<FullWallet> CREATOR = new C0758c();

    /* renamed from: iM */
    private final int f1886iM;

    /* renamed from: tH */
    String f1887tH;

    /* renamed from: tI */
    String f1888tI;

    /* renamed from: tJ */
    ProxyCard f1889tJ;

    /* renamed from: tK */
    String f1890tK;

    /* renamed from: tL */
    Address f1891tL;

    /* renamed from: tM */
    Address f1892tM;

    /* renamed from: tN */
    String[] f1893tN;

    public FullWallet() {
        this.f1886iM = 1;
    }

    FullWallet(int versionCode, String googleTransactionId, String merchantTransactionId, ProxyCard proxyCard, String email, Address billingAddress, Address shippingAddress, String[] paymentDescriptions) {
        this.f1886iM = versionCode;
        this.f1887tH = googleTransactionId;
        this.f1888tI = merchantTransactionId;
        this.f1889tJ = proxyCard;
        this.f1890tK = email;
        this.f1891tL = billingAddress;
        this.f1892tM = shippingAddress;
        this.f1893tN = paymentDescriptions;
    }

    public int describeContents() {
        return 0;
    }

    public Address getBillingAddress() {
        return this.f1891tL;
    }

    public String getEmail() {
        return this.f1890tK;
    }

    public String getGoogleTransactionId() {
        return this.f1887tH;
    }

    public String getMerchantTransactionId() {
        return this.f1888tI;
    }

    public String[] getPaymentDescriptions() {
        return this.f1893tN;
    }

    public ProxyCard getProxyCard() {
        return this.f1889tJ;
    }

    public Address getShippingAddress() {
        return this.f1892tM;
    }

    public int getVersionCode() {
        return this.f1886iM;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0758c.m2172a(this, out, flags);
    }
}
