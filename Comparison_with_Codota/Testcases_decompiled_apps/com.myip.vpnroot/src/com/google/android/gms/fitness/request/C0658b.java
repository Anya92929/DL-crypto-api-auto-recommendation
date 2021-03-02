package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;

/* renamed from: com.google.android.gms.fitness.request.b */
public class C0658b implements SafeParcelable {
    public static final Parcelable.Creator<C0658b> CREATOR = new C0659c();

    /* renamed from: BR */
    private final int f1525BR;

    /* renamed from: TX */
    private final String f1526TX;

    /* renamed from: TY */
    private final BleDevice f1527TY;

    C0658b(int i, String str, BleDevice bleDevice) {
        this.f1525BR = i;
        this.f1526TX = str;
        this.f1527TY = bleDevice;
    }

    public C0658b(BleDevice bleDevice) {
        this(2, bleDevice.getAddress(), bleDevice);
    }

    public C0658b(String str) {
        this(2, str, (BleDevice) null);
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceAddress() {
        return this.f1526TX;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1525BR;
    }

    /* renamed from: iW */
    public BleDevice mo6074iW() {
        return this.f1527TY;
    }

    public String toString() {
        return String.format("ClaimBleDeviceRequest{%s %s}", new Object[]{this.f1526TX, this.f1527TY});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0659c.m2007a(this, parcel, flags);
    }
}
