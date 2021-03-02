package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;

public final class RawDataPoint implements SafeParcelable {
    public static final Parcelable.Creator<RawDataPoint> CREATOR = new C0625n();

    /* renamed from: BR */
    final int f1352BR;

    /* renamed from: SA */
    final long f1353SA;

    /* renamed from: SB */
    final Value[] f1354SB;

    /* renamed from: SD */
    final long f1355SD;

    /* renamed from: SE */
    final long f1356SE;

    /* renamed from: Sz */
    final long f1357Sz;

    /* renamed from: Tb */
    final int f1358Tb;

    /* renamed from: Tc */
    final int f1359Tc;

    RawDataPoint(int versionCode, long timestampNanos, long startTimeNanos, Value[] values, int dataSourceIndex, int originalDataSourceIndex, long rawTimestamp, long insertionTimeMillis) {
        this.f1352BR = versionCode;
        this.f1357Sz = timestampNanos;
        this.f1353SA = startTimeNanos;
        this.f1358Tb = dataSourceIndex;
        this.f1359Tc = originalDataSourceIndex;
        this.f1355SD = rawTimestamp;
        this.f1356SE = insertionTimeMillis;
        this.f1354SB = values;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> dataSources) {
        this.f1352BR = 4;
        this.f1357Sz = dataPoint.getTimestampNanos();
        this.f1353SA = dataPoint.getStartTimeNanos();
        this.f1354SB = dataPoint.mo5624iC();
        this.f1358Tb = C0631t.m1883a(dataPoint.getDataSource(), dataSources);
        this.f1359Tc = C0631t.m1883a(dataPoint.getOriginalDataSource(), dataSources);
        this.f1355SD = dataPoint.mo5625iD();
        this.f1356SE = dataPoint.mo5626iE();
    }

    /* renamed from: a */
    private boolean m1806a(RawDataPoint rawDataPoint) {
        return this.f1357Sz == rawDataPoint.f1357Sz && this.f1353SA == rawDataPoint.f1353SA && Arrays.equals(this.f1354SB, rawDataPoint.f1354SB) && this.f1358Tb == rawDataPoint.f1358Tb && this.f1359Tc == rawDataPoint.f1359Tc && this.f1355SD == rawDataPoint.f1355SD;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataPoint) && m1806a((RawDataPoint) o));
    }

    public int hashCode() {
        return C0345m.hashCode(Long.valueOf(this.f1357Sz), Long.valueOf(this.f1353SA));
    }

    public String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.f1354SB), Long.valueOf(this.f1353SA), Long.valueOf(this.f1357Sz), Integer.valueOf(this.f1358Tb), Integer.valueOf(this.f1359Tc)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0625n.m1866a(this, parcel, flags);
    }
}
