package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.C0355c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint implements SafeParcelable {
    public static final Parcelable.Creator<DataPoint> CREATOR = new C0612e();

    /* renamed from: BR */
    private final int f1298BR;

    /* renamed from: SA */
    private long f1299SA;

    /* renamed from: SB */
    private final Value[] f1300SB;

    /* renamed from: SC */
    private DataSource f1301SC;

    /* renamed from: SD */
    private long f1302SD;

    /* renamed from: SE */
    private long f1303SE;

    /* renamed from: Sh */
    private final DataSource f1304Sh;

    /* renamed from: Sz */
    private long f1305Sz;

    DataPoint(int versionCode, DataSource dataSource, long timestampNanos, long startTimeNanos, Value[] values, DataSource originalDataSource, long rawTimestamp, long insertionTimeMillis) {
        this.f1298BR = versionCode;
        this.f1304Sh = dataSource;
        this.f1301SC = originalDataSource;
        this.f1305Sz = timestampNanos;
        this.f1299SA = startTimeNanos;
        this.f1300SB = values;
        this.f1302SD = rawTimestamp;
        this.f1303SE = insertionTimeMillis;
    }

    private DataPoint(DataSource dataSource) {
        this.f1298BR = 4;
        this.f1304Sh = (DataSource) C0348n.m857b(dataSource, (Object) "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.f1300SB = new Value[fields.size()];
        int i = 0;
        Iterator<Field> it = fields.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                this.f1300SB[i2] = new Value(it.next().getFormat());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    DataPoint(List<DataSource> dataSources, RawDataPoint rawDataPoint) {
        this(4, m1768a(dataSources, rawDataPoint.f1358Tb), rawDataPoint.f1357Sz, rawDataPoint.f1353SA, rawDataPoint.f1354SB, m1768a(dataSources, rawDataPoint.f1359Tc), rawDataPoint.f1355SD, rawDataPoint.f1356SE);
    }

    /* renamed from: a */
    private static DataSource m1768a(List<DataSource> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    /* renamed from: a */
    private boolean m1769a(DataPoint dataPoint) {
        return C0345m.equal(this.f1304Sh, dataPoint.f1304Sh) && this.f1305Sz == dataPoint.f1305Sz && this.f1299SA == dataPoint.f1299SA && Arrays.equals(this.f1300SB, dataPoint.f1300SB) && C0345m.equal(this.f1301SC, dataPoint.f1301SC);
    }

    /* renamed from: cB */
    private void m1770cB(int i) {
        List<Field> fields = getDataType().getFields();
        int size = fields.size();
        C0348n.m860b(i == size, "Attempting to insert %s values, but needed %s: %s", Integer.valueOf(i), Integer.valueOf(size), fields);
    }

    public static DataPoint create(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    public static DataPoint extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (DataPoint) C0355c.m942a(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof DataPoint) && m1769a((DataPoint) o));
    }

    public DataSource getDataSource() {
        return this.f1304Sh;
    }

    public DataType getDataType() {
        return this.f1304Sh.getDataType();
    }

    public long getEndTimeNanos() {
        return this.f1305Sz;
    }

    public DataSource getOriginalDataSource() {
        return this.f1301SC;
    }

    public long getStartTimeNanos() {
        return this.f1299SA;
    }

    public long getTimestampNanos() {
        return this.f1305Sz;
    }

    public Value getValue(Field field) {
        return this.f1300SB[getDataType().indexOf(field)];
    }

    public int getVersionCode() {
        return this.f1298BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1304Sh, Long.valueOf(this.f1305Sz), Long.valueOf(this.f1299SA));
    }

    /* renamed from: iC */
    public Value[] mo5624iC() {
        return this.f1300SB;
    }

    /* renamed from: iD */
    public long mo5625iD() {
        return this.f1302SD;
    }

    /* renamed from: iE */
    public long mo5626iE() {
        return this.f1303SE;
    }

    public DataPoint setFloatValues(float... values) {
        m1770cB(values.length);
        for (int i = 0; i < values.length; i++) {
            this.f1300SB[i].setFloat(values[i]);
        }
        return this;
    }

    public DataPoint setIntValues(int... values) {
        m1770cB(values.length);
        for (int i = 0; i < values.length; i++) {
            this.f1300SB[i].setInt(values[i]);
        }
        return this;
    }

    public DataPoint setTimeInterval(long startTime, long endTime, TimeUnit unit) {
        return setTimeIntervalNanos(unit.toNanos(startTime), unit.toNanos(endTime));
    }

    public DataPoint setTimeIntervalNanos(long startTimeNanos, long endTimeNanos) {
        this.f1299SA = startTimeNanos;
        this.f1305Sz = endTimeNanos;
        return this;
    }

    public DataPoint setTimestamp(long timestamp, TimeUnit unit) {
        return setTimestampNanos(unit.toNanos(timestamp));
    }

    public DataPoint setTimestampNanos(long timestampNanos) {
        this.f1305Sz = timestampNanos;
        return this;
    }

    public String toString() {
        return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", new Object[]{Arrays.toString(this.f1300SB), Long.valueOf(this.f1299SA), Long.valueOf(this.f1305Sz), Long.valueOf(this.f1302SD), Long.valueOf(this.f1303SE), this.f1304Sh, this.f1301SC});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0612e.m1840a(this, parcel, flags);
    }
}
