package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSourcesResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataSourcesResult> CREATOR = new C0693c();

    /* renamed from: BR */
    private final int f1566BR;

    /* renamed from: CM */
    private final Status f1567CM;

    /* renamed from: TZ */
    private final List<DataSource> f1568TZ;

    DataSourcesResult(int versionCode, List<DataSource> dataSources, Status status) {
        this.f1566BR = versionCode;
        this.f1568TZ = Collections.unmodifiableList(dataSources);
        this.f1567CM = status;
    }

    public DataSourcesResult(List<DataSource> dataSources, Status status) {
        this.f1566BR = 3;
        this.f1568TZ = Collections.unmodifiableList(dataSources);
        this.f1567CM = status;
    }

    /* renamed from: E */
    public static DataSourcesResult m2093E(Status status) {
        return new DataSourcesResult(Collections.emptyList(), status);
    }

    /* renamed from: b */
    private boolean m2094b(DataSourcesResult dataSourcesResult) {
        return this.f1567CM.equals(dataSourcesResult.f1567CM) && C0345m.equal(this.f1568TZ, dataSourcesResult.f1568TZ);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSourcesResult) && m2094b((DataSourcesResult) that));
    }

    public List<DataSource> getDataSources() {
        return this.f1568TZ;
    }

    public List<DataSource> getDataSources(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (DataSource next : this.f1568TZ) {
            if (next.getDataType().equals(dataType)) {
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.f1567CM;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1566BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1567CM, this.f1568TZ);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("status", this.f1567CM).mo4549a("dataSets", this.f1568TZ).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0693c.m2110a(this, dest, flags);
    }
}
