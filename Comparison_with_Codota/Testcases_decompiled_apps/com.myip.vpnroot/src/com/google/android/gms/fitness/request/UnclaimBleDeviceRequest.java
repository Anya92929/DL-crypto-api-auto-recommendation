package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UnclaimBleDeviceRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnclaimBleDeviceRequest> CREATOR = new C0653ag();

    /* renamed from: BR */
    private final int f1508BR;

    /* renamed from: TX */
    private final String f1509TX;

    UnclaimBleDeviceRequest(int versionCode, String deviceAddress) {
        this.f1508BR = versionCode;
        this.f1509TX = deviceAddress;
    }

    public UnclaimBleDeviceRequest(String deviceAddress) {
        this(3, deviceAddress);
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceAddress() {
        return this.f1509TX;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1508BR;
    }

    public String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[]{this.f1509TX});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0653ag.m1994a(this, parcel, flags);
    }
}
