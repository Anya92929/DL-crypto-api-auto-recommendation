package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Address implements SafeParcelable {
    public static final Parcelable.Creator<Address> CREATOR = new C0756a();

    /* renamed from: hl */
    String f1870hl;

    /* renamed from: iM */
    private final int f1871iM;
    String name;

    /* renamed from: tA */
    String f1872tA;

    /* renamed from: tB */
    boolean f1873tB;

    /* renamed from: tC */
    String f1874tC;

    /* renamed from: tu */
    String f1875tu;

    /* renamed from: tv */
    String f1876tv;

    /* renamed from: tw */
    String f1877tw;

    /* renamed from: tx */
    String f1878tx;

    /* renamed from: ty */
    String f1879ty;

    /* renamed from: tz */
    String f1880tz;

    public Address() {
        this.f1871iM = 1;
    }

    Address(int versionCode, String name2, String address1, String address2, String address3, String countryCode, String city, String state, String postalCode, String phoneNumber, boolean isPostBox, String companyName) {
        this.f1871iM = versionCode;
        this.name = name2;
        this.f1875tu = address1;
        this.f1876tv = address2;
        this.f1877tw = address3;
        this.f1870hl = countryCode;
        this.f1878tx = city;
        this.f1879ty = state;
        this.f1880tz = postalCode;
        this.f1872tA = phoneNumber;
        this.f1873tB = isPostBox;
        this.f1874tC = companyName;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.f1875tu;
    }

    public String getAddress2() {
        return this.f1876tv;
    }

    public String getAddress3() {
        return this.f1877tw;
    }

    public String getCity() {
        return this.f1878tx;
    }

    public String getCompanyName() {
        return this.f1874tC;
    }

    public String getCountryCode() {
        return this.f1870hl;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.f1872tA;
    }

    public String getPostalCode() {
        return this.f1880tz;
    }

    public String getState() {
        return this.f1879ty;
    }

    public int getVersionCode() {
        return this.f1871iM;
    }

    public boolean isPostBox() {
        return this.f1873tB;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0756a.m2166a(this, out, flags);
    }
}
