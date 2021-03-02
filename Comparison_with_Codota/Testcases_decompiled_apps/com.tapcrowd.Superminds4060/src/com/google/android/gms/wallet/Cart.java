package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements SafeParcelable {
    public static final Parcelable.Creator<Cart> CREATOR = new C0757b();

    /* renamed from: iM */
    private final int f1881iM;

    /* renamed from: tD */
    String f1882tD;

    /* renamed from: tE */
    String f1883tE;

    /* renamed from: tF */
    ArrayList<LineItem> f1884tF;

    public final class Builder {
        private Builder() {
        }

        public Builder addLineItem(LineItem lineItem) {
            Cart.this.f1884tF.add(lineItem);
            return this;
        }

        public Cart build() {
            return Cart.this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            Cart.this.f1883tE = currencyCode;
            return this;
        }

        public Builder setLineItems(List<LineItem> lineItems) {
            Cart.this.f1884tF.clear();
            Cart.this.f1884tF.addAll(lineItems);
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            Cart.this.f1882tD = totalPrice;
            return this;
        }
    }

    public Cart() {
        this.f1881iM = 1;
        this.f1884tF = new ArrayList<>();
    }

    Cart(int versionCode, String totalPrice, String currencyCode, ArrayList<LineItem> lineItems) {
        this.f1881iM = versionCode;
        this.f1882tD = totalPrice;
        this.f1883tE = currencyCode;
        this.f1884tF = lineItems;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.f1883tE;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.f1884tF;
    }

    public String getTotalPrice() {
        return this.f1882tD;
    }

    public int getVersionCode() {
        return this.f1881iM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0757b.m2169a(this, dest, flags);
    }
}
