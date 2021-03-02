package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable {
    public static final Parcelable.Creator<ProxyCard> CREATOR = new C0766k();

    /* renamed from: iM */
    private final int f1940iM;

    /* renamed from: um */
    String f1941um;

    /* renamed from: un */
    String f1942un;

    /* renamed from: uo */
    int f1943uo;

    /* renamed from: up */
    int f1944up;

    ProxyCard(int versionCode, String pan, String cvn, int expirationMonth, int expirationYear) {
        this.f1940iM = versionCode;
        this.f1941um = pan;
        this.f1942un = cvn;
        this.f1943uo = expirationMonth;
        this.f1944up = expirationYear;
    }

    public ProxyCard(String pan, String cvn, int expirationMonth, int expirationYear) {
        this.f1940iM = 1;
        this.f1941um = pan;
        this.f1942un = cvn;
        this.f1943uo = expirationMonth;
        this.f1944up = expirationYear;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.f1942un;
    }

    public int getExpirationMonth() {
        return this.f1943uo;
    }

    public int getExpirationYear() {
        return this.f1944up;
    }

    public String getPan() {
        return this.f1941um;
    }

    public int getVersionCode() {
        return this.f1940iM;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0766k.m2196a(this, out, flags);
    }
}
