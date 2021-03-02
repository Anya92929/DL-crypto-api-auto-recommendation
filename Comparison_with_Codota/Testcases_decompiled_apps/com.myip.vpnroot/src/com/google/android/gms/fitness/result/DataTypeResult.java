package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;

public class DataTypeResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataTypeResult> CREATOR = new C0694d();

    /* renamed from: BR */
    private final int f1569BR;

    /* renamed from: CM */
    private final Status f1570CM;

    /* renamed from: SF */
    private final DataType f1571SF;

    DataTypeResult(int versionCode, Status status, DataType dataType) {
        this.f1569BR = versionCode;
        this.f1570CM = status;
        this.f1571SF = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.f1569BR = 2;
        this.f1570CM = status;
        this.f1571SF = dataType;
    }

    /* renamed from: F */
    public static DataTypeResult m2095F(Status status) {
        return new DataTypeResult(status, (DataType) null);
    }

    /* renamed from: b */
    private boolean m2096b(DataTypeResult dataTypeResult) {
        return this.f1570CM.equals(dataTypeResult.f1570CM) && C0345m.equal(this.f1571SF, dataTypeResult.f1571SF);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataTypeResult) && m2096b((DataTypeResult) that));
    }

    public DataType getDataType() {
        return this.f1571SF;
    }

    public Status getStatus() {
        return this.f1570CM;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1569BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1570CM, this.f1571SF);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("status", this.f1570CM).mo4549a("dataType", this.f1571SF).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0694d.m2113a(this, dest, flags);
    }
}
