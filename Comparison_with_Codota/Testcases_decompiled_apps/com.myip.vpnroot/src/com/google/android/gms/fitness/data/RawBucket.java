package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class RawBucket implements SafeParcelable {
    public static final Parcelable.Creator<RawBucket> CREATOR = new C0624m();

    /* renamed from: BR */
    final int f1344BR;

    /* renamed from: KL */
    final long f1345KL;

    /* renamed from: Si */
    final long f1346Si;

    /* renamed from: Sk */
    final Session f1347Sk;

    /* renamed from: Sv */
    final int f1348Sv;

    /* renamed from: Sw */
    final List<RawDataSet> f1349Sw;

    /* renamed from: Sx */
    final int f1350Sx;

    /* renamed from: Sy */
    final boolean f1351Sy;

    RawBucket(int versionCode, long startTimeMillis, long endTimeMillis, Session session, int activity, List<RawDataSet> dataSets, int bucketType, boolean serverHasMoreData) {
        this.f1344BR = versionCode;
        this.f1345KL = startTimeMillis;
        this.f1346Si = endTimeMillis;
        this.f1347Sk = session;
        this.f1348Sv = activity;
        this.f1349Sw = dataSets;
        this.f1350Sx = bucketType;
        this.f1351Sy = serverHasMoreData;
    }

    public RawBucket(Bucket bucket, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.f1344BR = 2;
        this.f1345KL = bucket.getStartTimeMillis();
        this.f1346Si = bucket.getEndTimeMillis();
        this.f1347Sk = bucket.getSession();
        this.f1348Sv = bucket.getActivity();
        this.f1350Sx = bucket.getBucketType();
        this.f1351Sy = bucket.mo5610iB();
        List<DataSet> dataSets = bucket.getDataSets();
        this.f1349Sw = new ArrayList(dataSets.size());
        for (DataSet rawDataSet : dataSets) {
            this.f1349Sw.add(new RawDataSet(rawDataSet, uniqueDataSources, uniqueDataTypes));
        }
    }

    /* renamed from: a */
    private boolean m1805a(RawBucket rawBucket) {
        return this.f1345KL == rawBucket.f1345KL && this.f1346Si == rawBucket.f1346Si && this.f1348Sv == rawBucket.f1348Sv && C0345m.equal(this.f1349Sw, rawBucket.f1349Sw) && this.f1350Sx == rawBucket.f1350Sx && this.f1351Sy == rawBucket.f1351Sy;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawBucket) && m1805a((RawBucket) o));
    }

    public int hashCode() {
        return C0345m.hashCode(Long.valueOf(this.f1345KL), Long.valueOf(this.f1346Si), Integer.valueOf(this.f1350Sx));
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("startTime", Long.valueOf(this.f1345KL)).mo4549a("endTime", Long.valueOf(this.f1346Si)).mo4549a("activity", Integer.valueOf(this.f1348Sv)).mo4549a("dataSets", this.f1349Sw).mo4549a("bucketType", Integer.valueOf(this.f1350Sx)).mo4549a("serverHasMoreData", Boolean.valueOf(this.f1351Sy)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0624m.m1863a(this, parcel, flags);
    }
}
