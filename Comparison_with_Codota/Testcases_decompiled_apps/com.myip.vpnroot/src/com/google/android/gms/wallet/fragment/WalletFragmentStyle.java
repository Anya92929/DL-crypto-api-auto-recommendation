package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.C0135R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentStyle implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentStyle> CREATOR = new C2188c();

    /* renamed from: BR */
    final int f4637BR;
    Bundle aud;
    int aue;

    public WalletFragmentStyle() {
        this.f4637BR = 1;
        this.aud = new Bundle();
    }

    WalletFragmentStyle(int versionCode, Bundle attributes, int styleResourceId) {
        this.f4637BR = versionCode;
        this.aud = attributes;
        this.aue = styleResourceId;
    }

    /* renamed from: a */
    private void m7379a(TypedArray typedArray, int i, String str) {
        TypedValue peekValue;
        if (!this.aud.containsKey(str) && (peekValue = typedArray.peekValue(i)) != null) {
            this.aud.putLong(str, Dimension.m7311a(peekValue));
        }
    }

    /* renamed from: a */
    private void m7380a(TypedArray typedArray, int i, String str, String str2) {
        TypedValue peekValue;
        if (!this.aud.containsKey(str) && !this.aud.containsKey(str2) && (peekValue = typedArray.peekValue(i)) != null) {
            if (peekValue.type < 28 || peekValue.type > 31) {
                this.aud.putInt(str2, peekValue.resourceId);
            } else {
                this.aud.putInt(str, peekValue.data);
            }
        }
    }

    /* renamed from: b */
    private void m7381b(TypedArray typedArray, int i, String str) {
        TypedValue peekValue;
        if (!this.aud.containsKey(str) && (peekValue = typedArray.peekValue(i)) != null) {
            this.aud.putInt(str, peekValue.data);
        }
    }

    /* renamed from: Z */
    public void mo12029Z(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.aue <= 0 ? C0135R.style.WalletFragmentDefaultStyle : this.aue, C0135R.styleable.WalletFragmentStyle);
        m7379a(obtainStyledAttributes, C0135R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
        m7379a(obtainStyledAttributes, C0135R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
        m7381b(obtainStyledAttributes, C0135R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
        m7381b(obtainStyledAttributes, C0135R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
        m7381b(obtainStyledAttributes, C0135R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
        m7381b(obtainStyledAttributes, C0135R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
        m7380a(obtainStyledAttributes, C0135R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        m7381b(obtainStyledAttributes, C0135R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
        m7380a(obtainStyledAttributes, C0135R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        m7381b(obtainStyledAttributes, C0135R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
        m7381b(obtainStyledAttributes, C0135R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public int mo12030a(String str, DisplayMetrics displayMetrics, int i) {
        return this.aud.containsKey(str) ? Dimension.m7309a(this.aud.getLong(str), displayMetrics) : i;
    }

    public int describeContents() {
        return 0;
    }

    public WalletFragmentStyle setBuyButtonAppearance(int buyButtonAppearance) {
        this.aud.putInt("buyButtonAppearance", buyButtonAppearance);
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int height) {
        this.aud.putLong("buyButtonHeight", Dimension.m7312fD(height));
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int unit, float height) {
        this.aud.putLong("buyButtonHeight", Dimension.m7310a(unit, height));
        return this;
    }

    public WalletFragmentStyle setBuyButtonText(int buyButtonText) {
        this.aud.putInt("buyButtonText", buyButtonText);
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int width) {
        this.aud.putLong("buyButtonWidth", Dimension.m7312fD(width));
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int unit, float width) {
        this.aud.putLong("buyButtonWidth", Dimension.m7310a(unit, width));
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int color) {
        this.aud.remove("maskedWalletDetailsBackgroundResource");
        this.aud.putInt("maskedWalletDetailsBackgroundColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int resourceId) {
        this.aud.remove("maskedWalletDetailsBackgroundColor");
        this.aud.putInt("maskedWalletDetailsBackgroundResource", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int color) {
        this.aud.remove("maskedWalletDetailsButtonBackgroundResource");
        this.aud.putInt("maskedWalletDetailsButtonBackgroundColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int resourceId) {
        this.aud.remove("maskedWalletDetailsButtonBackgroundColor");
        this.aud.putInt("maskedWalletDetailsButtonBackgroundResource", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int resourceId) {
        this.aud.putInt("maskedWalletDetailsButtonTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int resourceId) {
        this.aud.putInt("maskedWalletDetailsHeaderTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int imageType) {
        this.aud.putInt("maskedWalletDetailsLogoImageType", imageType);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int color) {
        this.aud.putInt("maskedWalletDetailsLogoTextColor", color);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int resourceId) {
        this.aud.putInt("maskedWalletDetailsTextAppearance", resourceId);
        return this;
    }

    public WalletFragmentStyle setStyleResourceId(int id) {
        this.aue = id;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2188c.m7390a(this, dest, flags);
    }
}
