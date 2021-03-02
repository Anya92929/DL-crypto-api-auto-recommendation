package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataReadResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataReadResult> CREATOR = new C0692b();

    /* renamed from: BR */
    private final int f1559BR;

    /* renamed from: CM */
    private final Status f1560CM;

    /* renamed from: SH */
    private final List<DataSource> f1561SH;

    /* renamed from: Sw */
    private final List<DataSet> f1562Sw;

    /* renamed from: UK */
    private final List<Bucket> f1563UK;

    /* renamed from: UL */
    private int f1564UL;

    /* renamed from: UM */
    private final List<DataType> f1565UM;

    DataReadResult(int versionCode, List<RawDataSet> dataSets, Status status, List<RawBucket> buckets, int batchCount, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.f1559BR = versionCode;
        this.f1560CM = status;
        this.f1564UL = batchCount;
        this.f1561SH = uniqueDataSources;
        this.f1565UM = uniqueDataTypes;
        this.f1562Sw = new ArrayList(dataSets.size());
        for (RawDataSet dataSet : dataSets) {
            this.f1562Sw.add(new DataSet(dataSet, uniqueDataSources, uniqueDataTypes));
        }
        this.f1563UK = new ArrayList(buckets.size());
        for (RawBucket bucket : buckets) {
            this.f1563UK.add(new Bucket(bucket, uniqueDataSources, uniqueDataTypes));
        }
    }

    public DataReadResult(List<DataSet> dataSets, List<Bucket> buckets, Status status) {
        this.f1559BR = 5;
        this.f1562Sw = dataSets;
        this.f1560CM = status;
        this.f1563UK = buckets;
        this.f1564UL = 1;
        this.f1561SH = new ArrayList();
        this.f1565UM = new ArrayList();
    }

    /* renamed from: a */
    public static DataReadResult m2083a(Status status, DataReadRequest dataReadRequest) {
        ArrayList arrayList = new ArrayList();
        for (DataSource create : dataReadRequest.getDataSources()) {
            arrayList.add(DataSet.create(create));
        }
        for (DataType dataType : dataReadRequest.getDataTypes()) {
            arrayList.add(DataSet.create(new DataSource.Builder().setDataType(dataType).setType(1).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    /* renamed from: a */
    private void m2084a(Bucket bucket, List<Bucket> list) {
        for (Bucket next : list) {
            if (next.mo5598b(bucket)) {
                for (DataSet a : bucket.getDataSets()) {
                    m2085a(a, next.getDataSets());
                }
                return;
            }
        }
        this.f1563UK.add(bucket);
    }

    /* renamed from: a */
    private void m2085a(DataSet dataSet, List<DataSet> list) {
        for (DataSet next : list) {
            if (next.getDataSource().equals(dataSet.getDataSource())) {
                next.mo5635a((Iterable<DataPoint>) dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    /* renamed from: c */
    private boolean m2086c(DataReadResult dataReadResult) {
        return this.f1560CM.equals(dataReadResult.f1560CM) && C0345m.equal(this.f1562Sw, dataReadResult.f1562Sw) && C0345m.equal(this.f1563UK, dataReadResult.f1563UK);
    }

    /* renamed from: b */
    public void mo6217b(DataReadResult dataReadResult) {
        for (DataSet a : dataReadResult.getDataSets()) {
            m2085a(a, this.f1562Sw);
        }
        for (Bucket a2 : dataReadResult.getBuckets()) {
            m2084a(a2, this.f1563UK);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadResult) && m2086c((DataReadResult) that));
    }

    public List<Bucket> getBuckets() {
        return this.f1563UK;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet next : this.f1562Sw) {
            if (dataSource.equals(next.getDataSource())) {
                return next;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{dataSource.getStreamIdentifier()}));
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet next : this.f1562Sw) {
            if (dataType.equals(next.getDataType())) {
                return next;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{dataType.getName()}));
    }

    public List<DataSet> getDataSets() {
        return this.f1562Sw;
    }

    public Status getStatus() {
        return this.f1560CM;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1559BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1560CM, this.f1562Sw, this.f1563UK);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: iG */
    public List<DataSource> mo6226iG() {
        return this.f1561SH;
    }

    /* renamed from: jF */
    public int mo6227jF() {
        return this.f1564UL;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: jG */
    public List<RawBucket> mo6228jG() {
        ArrayList arrayList = new ArrayList(this.f1563UK.size());
        for (Bucket rawBucket : this.f1563UK) {
            arrayList.add(new RawBucket(rawBucket, this.f1561SH, this.f1565UM));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: jH */
    public List<RawDataSet> mo6229jH() {
        ArrayList arrayList = new ArrayList(this.f1562Sw.size());
        for (DataSet rawDataSet : this.f1562Sw) {
            arrayList.add(new RawDataSet(rawDataSet, this.f1561SH, this.f1565UM));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: jI */
    public List<DataType> mo6230jI() {
        return this.f1565UM;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("status", this.f1560CM).mo4549a("dataSets", this.f1562Sw.size() > 5 ? this.f1562Sw.size() + " data sets" : this.f1562Sw).mo4549a("buckets", this.f1563UK.size() > 5 ? this.f1563UK.size() + " buckets" : this.f1563UK).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0692b.m2107a(this, dest, flags);
    }
}
