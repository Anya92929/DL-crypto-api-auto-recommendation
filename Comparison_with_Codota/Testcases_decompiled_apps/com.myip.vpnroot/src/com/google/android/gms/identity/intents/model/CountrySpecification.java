package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification implements SafeParcelable {
    public static final Parcelable.Creator<CountrySpecification> CREATOR = new C0878a();

    /* renamed from: BR */
    private final int f2401BR;

    /* renamed from: uW */
    String f2402uW;

    CountrySpecification(int versionCode, String countryCode) {
        this.f2401BR = versionCode;
        this.f2402uW = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.f2401BR = 1;
        this.f2402uW = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.f2402uW;
    }

    public int getVersionCode() {
        return this.f2401BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0878a.m3786a(this, dest, flags);
    }
}
