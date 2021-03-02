package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1414ki;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
    public static final Parcelable.Creator<BleDevice> CREATOR = new C0610c();

    /* renamed from: BR */
    private final int f1286BR;

    /* renamed from: Ss */
    private final String f1287Ss;

    /* renamed from: St */
    private final List<String> f1288St;

    /* renamed from: Su */
    private final List<DataType> f1289Su;
    private final String mName;

    BleDevice(int versionCode, String address, String name, List<String> profiles, List<DataType> dataTypes) {
        this.f1286BR = versionCode;
        this.f1287Ss = address;
        this.mName = name;
        this.f1288St = Collections.unmodifiableList(profiles);
        this.f1289Su = Collections.unmodifiableList(dataTypes);
    }

    /* renamed from: a */
    private boolean m1762a(BleDevice bleDevice) {
        return this.mName.equals(bleDevice.mName) && this.f1287Ss.equals(bleDevice.f1287Ss) && C1414ki.m5254a(bleDevice.f1288St, this.f1288St) && C1414ki.m5254a(this.f1289Su, bleDevice.f1289Su);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof BleDevice) && m1762a((BleDevice) o));
    }

    public String getAddress() {
        return this.f1287Ss;
    }

    public List<DataType> getDataTypes() {
        return this.f1289Su;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getSupportedProfiles() {
        return this.f1288St;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1286BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.mName, this.f1287Ss, this.f1288St, this.f1289Su);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("name", this.mName).mo4549a("address", this.f1287Ss).mo4549a("dataTypes", this.f1289Su).mo4549a("supportedProfiles", this.f1288St).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0610c.m1834a(this, parcel, flags);
    }
}
