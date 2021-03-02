package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo implements SafeParcelable {
    public static final Parcelable.Creator<InstrumentInfo> CREATOR = new C2190h();

    /* renamed from: BR */
    private final int f4617BR;
    private String asC;
    private String asD;

    InstrumentInfo(int versionCode, String instrumentType, String instrumentDetails) {
        this.f4617BR = versionCode;
        this.asC = instrumentType;
        this.asD = instrumentDetails;
    }

    public int describeContents() {
        return 0;
    }

    public String getInstrumentDetails() {
        return this.asD;
    }

    public String getInstrumentType() {
        return this.asC;
    }

    public int getVersionCode() {
        return this.f4617BR;
    }

    public void writeToParcel(Parcel out, int flags) {
        C2190h.m7396a(this, out, flags);
    }
}
