package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class RawDataSet implements SafeParcelable {
    public static final Parcelable.Creator<RawDataSet> CREATOR = new C0626o();

    /* renamed from: BR */
    final int f1360BR;

    /* renamed from: Sy */
    final boolean f1361Sy;

    /* renamed from: Tb */
    final int f1362Tb;

    /* renamed from: Td */
    final int f1363Td;

    /* renamed from: Te */
    final List<RawDataPoint> f1364Te;

    RawDataSet(int versionCode, int dataSourceIndex, int dataTypeIndex, List<RawDataPoint> rawDataPoints, boolean serverHasMoreData) {
        this.f1360BR = versionCode;
        this.f1362Tb = dataSourceIndex;
        this.f1363Td = dataTypeIndex;
        this.f1364Te = rawDataPoints;
        this.f1361Sy = serverHasMoreData;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.f1360BR = 2;
        this.f1364Te = dataSet.mo5641e(uniqueDataSources);
        this.f1361Sy = dataSet.mo5648iB();
        this.f1362Tb = C0631t.m1883a(dataSet.getDataSource(), uniqueDataSources);
        this.f1363Td = C0631t.m1883a(dataSet.getDataType(), uniqueDataTypes);
    }

    /* renamed from: a */
    private boolean m1807a(RawDataSet rawDataSet) {
        return this.f1362Tb == rawDataSet.f1362Tb && this.f1363Td == rawDataSet.f1363Td && this.f1361Sy == rawDataSet.f1361Sy && C0345m.equal(this.f1364Te, rawDataSet.f1364Te);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataSet) && m1807a((RawDataSet) o));
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.f1362Tb), Integer.valueOf(this.f1363Td));
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s, %s]}", new Object[]{Integer.valueOf(this.f1362Tb), Integer.valueOf(this.f1363Td), this.f1364Te});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0626o.m1869a(this, parcel, flags);
    }
}
