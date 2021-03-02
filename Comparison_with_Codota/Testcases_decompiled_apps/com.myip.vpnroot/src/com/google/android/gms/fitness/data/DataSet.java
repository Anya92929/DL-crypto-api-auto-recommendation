package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DataSet implements SafeParcelable {
    public static final Parcelable.Creator<DataSet> CREATOR = new C0613f();

    /* renamed from: BR */
    private final int f1306BR;

    /* renamed from: SF */
    private final DataType f1307SF;

    /* renamed from: SG */
    private final List<DataPoint> f1308SG;

    /* renamed from: SH */
    private final List<DataSource> f1309SH;

    /* renamed from: Sh */
    private final DataSource f1310Sh;

    /* renamed from: Sy */
    private boolean f1311Sy;

    DataSet(int versionCode, DataSource dataSource, DataType dataType, List<RawDataPoint> dataPoints, List<DataSource> uniqueDataSources, boolean serverHasMoreData) {
        this.f1311Sy = false;
        this.f1306BR = versionCode;
        this.f1310Sh = dataSource;
        this.f1307SF = dataType;
        this.f1311Sy = serverHasMoreData;
        this.f1308SG = new ArrayList(dataPoints.size());
        this.f1309SH = versionCode < 2 ? Collections.singletonList(dataSource) : uniqueDataSources;
        for (RawDataPoint dataPoint : dataPoints) {
            this.f1308SG.add(new DataPoint(this.f1309SH, dataPoint));
        }
    }

    private DataSet(DataSource dataSource, DataType dataType) {
        this.f1311Sy = false;
        this.f1306BR = 3;
        this.f1310Sh = (DataSource) C0348n.m861i(dataSource);
        this.f1307SF = (DataType) C0348n.m861i(dataType);
        this.f1308SG = new ArrayList();
        this.f1309SH = new ArrayList();
        this.f1309SH.add(this.f1310Sh);
    }

    public DataSet(RawDataSet dataSet, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this(3, (DataSource) m1775b(uniqueDataSources, dataSet.f1362Tb), (DataType) m1775b(uniqueDataTypes, dataSet.f1363Td), dataSet.f1364Te, uniqueDataSources, dataSet.f1361Sy);
    }

    /* renamed from: a */
    private boolean m1774a(DataSet dataSet) {
        return C0345m.equal(this.f1307SF, dataSet.f1307SF) && C0345m.equal(this.f1310Sh, dataSet.f1310Sh) && C0345m.equal(this.f1308SG, dataSet.f1308SG) && this.f1311Sy == dataSet.f1311Sy;
    }

    /* renamed from: b */
    private static <T> T m1775b(List<T> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static DataSet create(DataSource dataSource) {
        return new DataSet(dataSource, dataSource.getDataType());
    }

    /* renamed from: a */
    public void mo5635a(Iterable<DataPoint> iterable) {
        for (DataPoint b : iterable) {
            mo5638b(b);
        }
    }

    public void add(DataPoint dataPoint) {
        DataSource dataSource = dataPoint.getDataSource();
        C0348n.m860b(dataSource.getStreamIdentifier().equals(this.f1310Sh.getStreamIdentifier()), "Conflicting data sources found %s vs %s", dataSource, this.f1310Sh);
        C0348n.m860b(dataPoint.getDataType().getName().equals(this.f1307SF.getName()), "Conflicting data types found %s vs %s", dataPoint.getDataType(), this.f1307SF);
        C0348n.m860b(dataPoint.getTimestampNanos() > 0, "Data point does not have the timestamp set: %s", dataPoint);
        C0348n.m860b(dataPoint.getStartTimeNanos() <= dataPoint.getEndTimeNanos(), "Data point with start time greater than end time found: %s", dataPoint);
        mo5638b(dataPoint);
    }

    public void addAll(Iterable<DataPoint> dataPoints) {
        for (DataPoint add : dataPoints) {
            add(add);
        }
    }

    /* renamed from: b */
    public void mo5638b(DataPoint dataPoint) {
        this.f1308SG.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.f1309SH.contains(originalDataSource)) {
            this.f1309SH.add(originalDataSource);
        }
    }

    public DataPoint createDataPoint() {
        return DataPoint.create(this.f1310Sh);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public List<RawDataPoint> mo5641e(List<DataSource> list) {
        ArrayList arrayList = new ArrayList(this.f1308SG.size());
        for (DataPoint rawDataPoint : this.f1308SG) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataSet) && m1774a((DataSet) o));
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.f1308SG);
    }

    public DataSource getDataSource() {
        return this.f1310Sh;
    }

    public DataType getDataType() {
        return this.f1307SF;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1306BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1307SF, this.f1310Sh);
    }

    /* renamed from: iB */
    public boolean mo5648iB() {
        return this.f1311Sy;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: iF */
    public List<RawDataPoint> mo5649iF() {
        return mo5641e(this.f1309SH);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: iG */
    public List<DataSource> mo5650iG() {
        return this.f1309SH;
    }

    public String toString() {
        List<RawDataPoint> iF = mo5649iF();
        Object[] objArr = new Object[2];
        objArr[0] = this.f1310Sh.toDebugString();
        Object obj = iF;
        if (this.f1308SG.size() >= 10) {
            obj = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.f1308SG.size()), iF.subList(0, 5)});
        }
        objArr[1] = obj;
        return String.format("DataSet{%s %s}", objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0613f.m1843a(this, parcel, flags);
    }
}
