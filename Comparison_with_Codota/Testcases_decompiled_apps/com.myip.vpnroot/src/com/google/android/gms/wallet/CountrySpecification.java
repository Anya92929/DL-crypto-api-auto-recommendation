package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class CountrySpecification implements SafeParcelable {
    public static final Parcelable.Creator<CountrySpecification> CREATOR = new C2172c();

    /* renamed from: BR */
    private final int f4613BR;

    /* renamed from: uW */
    String f4614uW;

    CountrySpecification(int versionCode, String countryCode) {
        this.f4613BR = versionCode;
        this.f4614uW = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.f4613BR = 1;
        this.f4614uW = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.f4614uW;
    }

    public int getVersionCode() {
        return this.f4613BR;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2172c.m7300a(this, dest, flags);
    }
}
