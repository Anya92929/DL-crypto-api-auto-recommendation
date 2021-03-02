package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BleDevicesResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<BleDevicesResult> CREATOR = new C0691a();

    /* renamed from: BR */
    private final int f1556BR;

    /* renamed from: CM */
    private final Status f1557CM;

    /* renamed from: UJ */
    private final List<BleDevice> f1558UJ;

    BleDevicesResult(int versionCode, List<BleDevice> bleDevices, Status status) {
        this.f1556BR = versionCode;
        this.f1558UJ = Collections.unmodifiableList(bleDevices);
        this.f1557CM = status;
    }

    public BleDevicesResult(List<BleDevice> bleDevices, Status status) {
        this.f1556BR = 3;
        this.f1558UJ = Collections.unmodifiableList(bleDevices);
        this.f1557CM = status;
    }

    /* renamed from: D */
    public static BleDevicesResult m2081D(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    /* renamed from: b */
    private boolean m2082b(BleDevicesResult bleDevicesResult) {
        return this.f1557CM.equals(bleDevicesResult.f1557CM) && C0345m.equal(this.f1558UJ, bleDevicesResult.f1558UJ);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof BleDevicesResult) && m2082b((BleDevicesResult) that));
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.f1558UJ;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (BleDevice next : this.f1558UJ) {
            if (next.getDataTypes().contains(dataType)) {
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.f1557CM;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1556BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1557CM, this.f1558UJ);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("status", this.f1557CM).mo4549a("bleDevices", this.f1558UJ).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0691a.m2104a(this, dest, flags);
    }
}
