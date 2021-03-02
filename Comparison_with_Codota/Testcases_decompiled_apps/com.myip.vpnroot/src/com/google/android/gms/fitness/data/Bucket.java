package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public class Bucket implements SafeParcelable {
    public static final Parcelable.Creator<Bucket> CREATOR = new C0611d();
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;

    /* renamed from: BR */
    private final int f1290BR;

    /* renamed from: KL */
    private final long f1291KL;

    /* renamed from: Si */
    private final long f1292Si;

    /* renamed from: Sk */
    private final Session f1293Sk;

    /* renamed from: Sv */
    private final int f1294Sv;

    /* renamed from: Sw */
    private final List<DataSet> f1295Sw;

    /* renamed from: Sx */
    private final int f1296Sx;

    /* renamed from: Sy */
    private boolean f1297Sy;

    Bucket(int versionCode, long startTimeMillis, long endTimeMillis, Session session, int activity, List<DataSet> dataSets, int bucketType, boolean serverHasMoreData) {
        this.f1297Sy = false;
        this.f1290BR = versionCode;
        this.f1291KL = startTimeMillis;
        this.f1292Si = endTimeMillis;
        this.f1293Sk = session;
        this.f1294Sv = activity;
        this.f1295Sw = dataSets;
        this.f1296Sx = bucketType;
        this.f1297Sy = serverHasMoreData;
    }

    public Bucket(RawBucket bucket, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this(2, bucket.f1345KL, bucket.f1346Si, bucket.f1347Sk, bucket.f1348Sv, m1763a(bucket.f1349Sw, uniqueDataSources, uniqueDataTypes), bucket.f1350Sx, bucket.f1351Sy);
    }

    /* renamed from: a */
    private static List<DataSet> m1763a(List<RawDataSet> list, List<DataSource> list2, List<DataType> list3) {
        ArrayList arrayList = new ArrayList(list.size());
        for (RawDataSet dataSet : list) {
            arrayList.add(new DataSet(dataSet, list2, list3));
        }
        return arrayList;
    }

    /* renamed from: a */
    private boolean m1764a(Bucket bucket) {
        return this.f1291KL == bucket.f1291KL && this.f1292Si == bucket.f1292Si && this.f1294Sv == bucket.f1294Sv && C0345m.equal(this.f1295Sw, bucket.f1295Sw) && this.f1296Sx == bucket.f1296Sx && this.f1297Sy == bucket.f1297Sy;
    }

    /* renamed from: cz */
    public static String m1765cz(int i) {
        switch (i) {
            case 0:
                return "unknown";
            case 1:
                return "time";
            case 2:
                return "session";
            case 3:
                return "type";
            case 4:
                return "segment";
            default:
                return "bug";
        }
    }

    /* renamed from: b */
    public boolean mo5598b(Bucket bucket) {
        return this.f1291KL == bucket.f1291KL && this.f1292Si == bucket.f1292Si && this.f1294Sv == bucket.f1294Sv && this.f1296Sx == bucket.f1296Sx;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof Bucket) && m1764a((Bucket) o));
    }

    public int getActivity() {
        return this.f1294Sv;
    }

    public int getBucketType() {
        return this.f1296Sx;
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet next : this.f1295Sw) {
            if (next.getDataType().equals(dataType)) {
                return next;
            }
        }
        return null;
    }

    public List<DataSet> getDataSets() {
        return this.f1295Sw;
    }

    public long getEndTimeMillis() {
        return this.f1292Si;
    }

    public Session getSession() {
        return this.f1293Sk;
    }

    public long getStartTimeMillis() {
        return this.f1291KL;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1290BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Long.valueOf(this.f1291KL), Long.valueOf(this.f1292Si), Integer.valueOf(this.f1294Sv), Integer.valueOf(this.f1296Sx));
    }

    /* renamed from: iB */
    public boolean mo5610iB() {
        if (this.f1297Sy) {
            return true;
        }
        for (DataSet iB : this.f1295Sw) {
            if (iB.mo5648iB()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("startTime", Long.valueOf(this.f1291KL)).mo4549a("endTime", Long.valueOf(this.f1292Si)).mo4549a("activity", Integer.valueOf(this.f1294Sv)).mo4549a("dataSets", this.f1295Sw).mo4549a("bucketType", m1765cz(this.f1296Sx)).mo4549a("serverHasMoreData", Boolean.valueOf(this.f1297Sy)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0611d.m1837a(this, dest, flags);
    }
}
