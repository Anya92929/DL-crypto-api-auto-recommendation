package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.lf */
public class C1493lf implements SafeParcelable {
    public static final Parcelable.Creator<C1493lf> CREATOR = new C1494lg();

    /* renamed from: BR */
    private final int f4258BR;

    /* renamed from: Su */
    private final List<DataType> f4259Su;

    C1493lf(int i, List<DataType> list) {
        this.f4258BR = i;
        this.f4259Su = list;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.f4259Su);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4258BR;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("dataTypes", this.f4259Su).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1494lg.m5422a(this, parcel, flags);
    }
}
