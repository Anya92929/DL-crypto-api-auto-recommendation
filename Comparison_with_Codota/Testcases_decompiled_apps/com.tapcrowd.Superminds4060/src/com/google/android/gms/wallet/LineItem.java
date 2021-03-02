package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LineItem implements SafeParcelable {
    public static final Parcelable.Creator<LineItem> CREATOR = new C0760e();
    String description;

    /* renamed from: iM */
    private final int f1899iM;

    /* renamed from: tD */
    String f1900tD;

    /* renamed from: tE */
    String f1901tE;

    /* renamed from: tQ */
    String f1902tQ;

    /* renamed from: tR */
    String f1903tR;

    /* renamed from: tS */
    int f1904tS;

    public final class Builder {
        private Builder() {
        }

        public LineItem build() {
            return LineItem.this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            LineItem.this.f1901tE = currencyCode;
            return this;
        }

        public Builder setDescription(String description) {
            LineItem.this.description = description;
            return this;
        }

        public Builder setQuantity(String quantity) {
            LineItem.this.f1902tQ = quantity;
            return this;
        }

        public Builder setRole(int role) {
            LineItem.this.f1904tS = role;
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            LineItem.this.f1900tD = totalPrice;
            return this;
        }

        public Builder setUnitPrice(String unitPrice) {
            LineItem.this.f1903tR = unitPrice;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    public LineItem() {
        this.f1904tS = 0;
        this.f1899iM = 1;
    }

    LineItem(int versionCode, String description2, String quantity, String unitPrice, String totalPrice, int role, String currencyCode) {
        this.f1904tS = 0;
        this.f1899iM = versionCode;
        this.description = description2;
        this.f1902tQ = quantity;
        this.f1903tR = unitPrice;
        this.f1900tD = totalPrice;
        this.f1904tS = role;
        this.f1901tE = currencyCode;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.f1901tE;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.f1902tQ;
    }

    public int getRole() {
        return this.f1904tS;
    }

    public String getTotalPrice() {
        return this.f1900tD;
    }

    public String getUnitPrice() {
        return this.f1903tR;
    }

    public int getVersionCode() {
        return this.f1899iM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0760e.m2178a(this, dest, flags);
    }
}
