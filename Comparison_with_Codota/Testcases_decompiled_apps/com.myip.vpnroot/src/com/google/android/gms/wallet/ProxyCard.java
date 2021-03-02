package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable {
    public static final Parcelable.Creator<ProxyCard> CREATOR = new C2197o();

    /* renamed from: BR */
    private final int f4627BR;
    String atu;
    String atv;
    int atw;
    int atx;

    ProxyCard(int versionCode, String pan, String cvn, int expirationMonth, int expirationYear) {
        this.f4627BR = versionCode;
        this.atu = pan;
        this.atv = cvn;
        this.atw = expirationMonth;
        this.atx = expirationYear;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.atv;
    }

    public int getExpirationMonth() {
        return this.atw;
    }

    public int getExpirationYear() {
        return this.atx;
    }

    public String getPan() {
        return this.atu;
    }

    public int getVersionCode() {
        return this.f4627BR;
    }

    public void writeToParcel(Parcel out, int flags) {
        C2197o.m7417a(this, out, flags);
    }
}
