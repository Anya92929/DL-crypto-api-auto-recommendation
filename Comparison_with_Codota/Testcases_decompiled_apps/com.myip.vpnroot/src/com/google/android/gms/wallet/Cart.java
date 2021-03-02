package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Parcelable.Creator<Cart> CREATOR = new C2171b();

    /* renamed from: BR */
    private final int f4612BR;
    String ask;
    String asl;
    ArrayList<LineItem> asm;

    public final class Builder {
        private Builder() {
        }

        public Builder addLineItem(LineItem lineItem) {
            Cart.this.asm.add(lineItem);
            return this;
        }

        public Cart build() {
            return Cart.this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            Cart.this.asl = currencyCode;
            return this;
        }

        public Builder setLineItems(List<LineItem> lineItems) {
            Cart.this.asm.clear();
            Cart.this.asm.addAll(lineItems);
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            Cart.this.ask = totalPrice;
            return this;
        }
    }

    Cart() {
        this.f4612BR = 1;
        this.asm = new ArrayList<>();
    }

    Cart(int versionCode, String totalPrice, String currencyCode, ArrayList<LineItem> lineItems) {
        this.f4612BR = versionCode;
        this.ask = totalPrice;
        this.asl = currencyCode;
        this.asm = lineItems;
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
        return this.asl;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.asm;
    }

    public String getTotalPrice() {
        return this.ask;
    }

    public int getVersionCode() {
        return this.f4612BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2171b.m7297a(this, dest, flags);
    }
}
