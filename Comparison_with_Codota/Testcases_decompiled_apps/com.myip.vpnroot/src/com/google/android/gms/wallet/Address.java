package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address implements SafeParcelable {
    public static final Parcelable.Creator<Address> CREATOR = new C2170a();

    /* renamed from: BR */
    private final int f4610BR;
    String adC;
    String adD;
    String adE;
    String adJ;
    String adL;
    boolean adM;
    String adN;
    String asi;
    String asj;
    String name;

    /* renamed from: uW */
    String f4611uW;

    Address() {
        this.f4610BR = 1;
    }

    Address(int versionCode, String name2, String address1, String address2, String address3, String countryCode, String city, String state, String postalCode, String phoneNumber, boolean isPostBox, String companyName) {
        this.f4610BR = versionCode;
        this.name = name2;
        this.adC = address1;
        this.adD = address2;
        this.adE = address3;
        this.f4611uW = countryCode;
        this.asi = city;
        this.asj = state;
        this.adJ = postalCode;
        this.adL = phoneNumber;
        this.adM = isPostBox;
        this.adN = companyName;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.adC;
    }

    public String getAddress2() {
        return this.adD;
    }

    public String getAddress3() {
        return this.adE;
    }

    public String getCity() {
        return this.asi;
    }

    public String getCompanyName() {
        return this.adN;
    }

    public String getCountryCode() {
        return this.f4611uW;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.adL;
    }

    public String getPostalCode() {
        return this.adJ;
    }

    public String getState() {
        return this.asj;
    }

    public int getVersionCode() {
        return this.f4610BR;
    }

    public boolean isPostBox() {
        return this.adM;
    }

    public void writeToParcel(Parcel out, int flags) {
        C2170a.m7294a(this, out, flags);
    }
}
