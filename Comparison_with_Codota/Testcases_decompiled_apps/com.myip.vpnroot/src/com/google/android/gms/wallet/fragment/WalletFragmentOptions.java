package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.C0135R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentOptions> CREATOR = new C2187b();

    /* renamed from: BR */
    final int f4635BR;
    /* access modifiers changed from: private */

    /* renamed from: MN */
    public int f4636MN;
    /* access modifiers changed from: private */
    public int atA;
    /* access modifiers changed from: private */
    public WalletFragmentStyle aub;
    /* access modifiers changed from: private */
    public int mTheme;

    public final class Builder {
        private Builder() {
        }

        public WalletFragmentOptions build() {
            return WalletFragmentOptions.this;
        }

        public Builder setEnvironment(int environment) {
            int unused = WalletFragmentOptions.this.atA = environment;
            return this;
        }

        public Builder setFragmentStyle(int styleResourceId) {
            WalletFragmentStyle unused = WalletFragmentOptions.this.aub = new WalletFragmentStyle().setStyleResourceId(styleResourceId);
            return this;
        }

        public Builder setFragmentStyle(WalletFragmentStyle fragmentStyle) {
            WalletFragmentStyle unused = WalletFragmentOptions.this.aub = fragmentStyle;
            return this;
        }

        public Builder setMode(int mode) {
            int unused = WalletFragmentOptions.this.f4636MN = mode;
            return this;
        }

        public Builder setTheme(int theme) {
            int unused = WalletFragmentOptions.this.mTheme = theme;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.f4635BR = 1;
    }

    WalletFragmentOptions(int versionCode, int environment, int theme, WalletFragmentStyle fragmentStyle, int mode) {
        this.f4635BR = versionCode;
        this.atA = environment;
        this.mTheme = theme;
        this.aub = fragmentStyle;
        this.f4636MN = mode;
    }

    /* renamed from: a */
    public static WalletFragmentOptions m7374a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0135R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(C0135R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(C0135R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(C0135R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(C0135R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.atA = i2;
        walletFragmentOptions.aub = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.aub.mo12029Z(context);
        walletFragmentOptions.f4636MN = i3;
        return walletFragmentOptions;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    /* renamed from: Z */
    public void mo12016Z(Context context) {
        if (this.aub != null) {
            this.aub.mo12029Z(context);
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.atA;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.aub;
    }

    public int getMode() {
        return this.f4636MN;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2187b.m7387a(this, dest, flags);
    }
}
