package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.AggregateDataTypes;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.DataTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataReadRequest> CREATOR = new C0662f();

    /* renamed from: BR */
    private final int f1421BR;

    /* renamed from: KL */
    private final long f1422KL;

    /* renamed from: Si */
    private final long f1423Si;

    /* renamed from: Su */
    private final List<DataType> f1424Su;

    /* renamed from: Sx */
    private final int f1425Sx;

    /* renamed from: TZ */
    private final List<DataSource> f1426TZ;

    /* renamed from: Ud */
    private final List<DataType> f1427Ud;

    /* renamed from: Ue */
    private final List<DataSource> f1428Ue;

    /* renamed from: Uf */
    private final long f1429Uf;

    /* renamed from: Ug */
    private final DataSource f1430Ug;

    /* renamed from: Uh */
    private final int f1431Uh;

    /* renamed from: Ui */
    private final boolean f1432Ui;

    /* renamed from: Uj */
    private final boolean f1433Uj;

    /* renamed from: Uk */
    private final boolean f1434Uk;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: KL */
        public long f1435KL;
        /* access modifiers changed from: private */

        /* renamed from: Si */
        public long f1436Si;
        /* access modifiers changed from: private */

        /* renamed from: Su */
        public List<DataType> f1437Su = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: Sx */
        public int f1438Sx = 0;
        /* access modifiers changed from: private */

        /* renamed from: TZ */
        public List<DataSource> f1439TZ = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: Ud */
        public List<DataType> f1440Ud = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: Ue */
        public List<DataSource> f1441Ue = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: Uf */
        public long f1442Uf = 0;
        /* access modifiers changed from: private */

        /* renamed from: Ug */
        public DataSource f1443Ug;
        /* access modifiers changed from: private */

        /* renamed from: Uh */
        public int f1444Uh = 0;
        /* access modifiers changed from: private */

        /* renamed from: Ui */
        public boolean f1445Ui = false;
        /* access modifiers changed from: private */

        /* renamed from: Uj */
        public boolean f1446Uj = false;
        /* access modifiers changed from: private */

        /* renamed from: Uk */
        public boolean f1447Uk = false;

        public Builder aggregate(DataSource dataSource, DataType outputDataType) {
            C0348n.m857b(dataSource, (Object) "Attempting to add a null data source");
            C0348n.m852a(!this.f1439TZ.contains(dataSource), "Cannot add the same data source for aggregated and detailed");
            DataType dataType = dataSource.getDataType();
            C0348n.m860b(AggregateDataTypes.INPUT_TYPES.contains(dataType), "Unsupported input data type specified for aggregation: %s", dataType);
            C0348n.m860b(AggregateDataTypes.getForInput(dataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", dataType, outputDataType);
            if (!this.f1441Ue.contains(dataSource)) {
                this.f1441Ue.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType inputDataType, DataType outputDataType) {
            C0348n.m857b(inputDataType, (Object) "Attempting to use a null data type");
            C0348n.m852a(!this.f1437Su.contains(inputDataType), "Cannot add the same data type as aggregated and detailed");
            C0348n.m860b(AggregateDataTypes.INPUT_TYPES.contains(inputDataType), "Unsupported input data type specified for aggregation: %s", inputDataType);
            C0348n.m860b(AggregateDataTypes.getForInput(inputDataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", inputDataType, outputDataType);
            if (!this.f1440Ud.contains(inputDataType)) {
                this.f1440Ud.add(inputDataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit) {
            C0348n.m860b(this.f1438Sx == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.f1438Sx));
            C0348n.m860b(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.f1438Sx = 4;
            this.f1442Uf = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            C0348n.m860b(this.f1438Sx == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.f1438Sx));
            C0348n.m860b(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            C0348n.m859b(activityDataSource != null, (Object) "Invalid activity data source specified");
            C0348n.m860b(activityDataSource.getDataType().equals(DataTypes.ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.f1443Ug = activityDataSource;
            this.f1438Sx = 4;
            this.f1442Uf = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit) {
            C0348n.m860b(this.f1438Sx == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.f1438Sx));
            C0348n.m860b(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.f1438Sx = 3;
            this.f1442Uf = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            C0348n.m860b(this.f1438Sx == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.f1438Sx));
            C0348n.m860b(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            C0348n.m859b(activityDataSource != null, (Object) "Invalid activity data source specified");
            C0348n.m860b(activityDataSource.getDataType().equals(DataTypes.ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.f1443Ug = activityDataSource;
            this.f1438Sx = 3;
            this.f1442Uf = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketBySession(int minDuration, TimeUnit timeUnit) {
            C0348n.m860b(this.f1438Sx == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.f1438Sx));
            C0348n.m860b(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.f1438Sx = 2;
            this.f1442Uf = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByTime(int duration, TimeUnit timeUnit) {
            C0348n.m860b(this.f1438Sx == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.f1438Sx));
            C0348n.m860b(duration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(duration));
            this.f1438Sx = 1;
            this.f1442Uf = timeUnit.toMillis((long) duration);
            return this;
        }

        public DataReadRequest build() {
            boolean z = true;
            C0348n.m852a(!this.f1439TZ.isEmpty() || !this.f1437Su.isEmpty() || !this.f1441Ue.isEmpty() || !this.f1440Ud.isEmpty(), "Must add at least one data source (aggregated or detailed)");
            C0348n.m853a(this.f1435KL > 0, "Invalid start time: %s", Long.valueOf(this.f1435KL));
            C0348n.m853a(this.f1436Si > 0 && this.f1436Si > this.f1435KL, "Invalid end time: %s", Long.valueOf(this.f1436Si));
            boolean z2 = this.f1441Ue.isEmpty() && this.f1440Ud.isEmpty();
            if ((!z2 || this.f1438Sx != 0) && (z2 || this.f1438Sx == 0)) {
                z = false;
            }
            C0348n.m852a(z, "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest(this);
        }

        public Builder enableServerQueries() {
            this.f1447Uk = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            C0348n.m857b(dataSource, (Object) "Attempting to add a null data source");
            C0348n.m859b(!this.f1441Ue.contains(dataSource), (Object) "Cannot add the same data source as aggregated and detailed");
            if (!this.f1439TZ.contains(dataSource)) {
                this.f1439TZ.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            C0348n.m857b(dataType, (Object) "Attempting to use a null data type");
            C0348n.m852a(!this.f1440Ud.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            if (!this.f1437Su.contains(dataType)) {
                this.f1437Su.add(dataType);
            }
            return this;
        }

        public Builder setTimeRange(long startTimeMillis, long endTimeMillis) {
            this.f1435KL = startTimeMillis;
            this.f1436Si = endTimeMillis;
            return this;
        }
    }

    DataReadRequest(int versionCode, List<DataType> dataTypes, List<DataSource> dataSources, long startTimeMillis, long endTimeMillis, List<DataType> aggregatedDataTypes, List<DataSource> aggregatedDataSources, int bucketType, long bucketDurationMillis, DataSource activityDataSource, int limit, boolean disableTransformations, boolean flushBeforeRead, boolean serverQueriesEnabled) {
        this.f1421BR = versionCode;
        this.f1424Su = Collections.unmodifiableList(dataTypes);
        this.f1426TZ = Collections.unmodifiableList(dataSources);
        this.f1422KL = startTimeMillis;
        this.f1423Si = endTimeMillis;
        this.f1427Ud = Collections.unmodifiableList(aggregatedDataTypes);
        this.f1428Ue = Collections.unmodifiableList(aggregatedDataSources);
        this.f1425Sx = bucketType;
        this.f1429Uf = bucketDurationMillis;
        this.f1430Ug = activityDataSource;
        this.f1431Uh = limit;
        this.f1432Ui = disableTransformations;
        this.f1433Uj = flushBeforeRead;
        this.f1434Uk = serverQueriesEnabled;
    }

    private DataReadRequest(Builder builder) {
        this.f1421BR = 2;
        this.f1424Su = Collections.unmodifiableList(builder.f1437Su);
        this.f1426TZ = Collections.unmodifiableList(builder.f1439TZ);
        this.f1422KL = builder.f1435KL;
        this.f1423Si = builder.f1436Si;
        this.f1427Ud = Collections.unmodifiableList(builder.f1440Ud);
        this.f1428Ue = Collections.unmodifiableList(builder.f1441Ue);
        this.f1425Sx = builder.f1438Sx;
        this.f1429Uf = builder.f1442Uf;
        this.f1430Ug = builder.f1443Ug;
        this.f1431Uh = builder.f1444Uh;
        this.f1432Ui = builder.f1445Ui;
        this.f1433Uj = builder.f1446Uj;
        this.f1434Uk = builder.f1447Uk;
    }

    /* renamed from: a */
    private boolean m1901a(DataReadRequest dataReadRequest) {
        return this.f1424Su.equals(dataReadRequest.f1424Su) && this.f1426TZ.equals(dataReadRequest.f1426TZ) && this.f1422KL == dataReadRequest.f1422KL && this.f1423Si == dataReadRequest.f1423Si && this.f1425Sx == dataReadRequest.f1425Sx && this.f1428Ue.equals(dataReadRequest.f1428Ue) && this.f1427Ud.equals(dataReadRequest.f1427Ud) && C0345m.equal(this.f1430Ug, dataReadRequest.f1430Ug) && this.f1429Uf == dataReadRequest.f1429Uf && this.f1434Uk == dataReadRequest.f1434Uk;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadRequest) && m1901a((DataReadRequest) that));
    }

    public int getBucketType() {
        return this.f1425Sx;
    }

    public List<DataSource> getDataSources() {
        return this.f1426TZ;
    }

    public List<DataType> getDataTypes() {
        return this.f1424Su;
    }

    public long getEndTimeMillis() {
        return this.f1423Si;
    }

    public long getStartTimeMillis() {
        return this.f1422KL;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1421BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.f1425Sx), Long.valueOf(this.f1422KL), Long.valueOf(this.f1423Si));
    }

    /* renamed from: ja */
    public List<DataType> mo5902ja() {
        return this.f1427Ud;
    }

    /* renamed from: jb */
    public List<DataSource> mo5903jb() {
        return this.f1428Ue;
    }

    /* renamed from: jc */
    public long mo5904jc() {
        return this.f1429Uf;
    }

    /* renamed from: jd */
    public DataSource mo5905jd() {
        return this.f1430Ug;
    }

    /* renamed from: je */
    public int mo5906je() {
        return this.f1431Uh;
    }

    /* renamed from: jf */
    public boolean mo5907jf() {
        return this.f1432Ui;
    }

    /* renamed from: jg */
    public boolean mo5908jg() {
        return this.f1434Uk;
    }

    /* renamed from: jh */
    public boolean mo5909jh() {
        return this.f1433Uj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReadDataRequest{");
        if (!this.f1424Su.isEmpty()) {
            for (DataType iL : this.f1424Su) {
                sb.append(iL.mo5685iL()).append(" ");
            }
        }
        if (!this.f1426TZ.isEmpty()) {
            for (DataSource debugString : this.f1426TZ) {
                sb.append(debugString.toDebugString()).append(" ");
            }
        }
        if (this.f1425Sx != 0) {
            sb.append("bucket by ").append(Bucket.m1765cz(this.f1425Sx));
            if (this.f1429Uf > 0) {
                sb.append(" >").append(this.f1429Uf).append("ms");
            }
            sb.append(": ");
        }
        if (!this.f1427Ud.isEmpty()) {
            for (DataType iL2 : this.f1427Ud) {
                sb.append(iL2.mo5685iL()).append(" ");
            }
        }
        if (!this.f1428Ue.isEmpty()) {
            for (DataSource debugString2 : this.f1428Ue) {
                sb.append(debugString2.toDebugString()).append(" ");
            }
        }
        sb.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.f1422KL), Long.valueOf(this.f1422KL), Long.valueOf(this.f1423Si), Long.valueOf(this.f1423Si)}));
        if (this.f1430Ug != null) {
            sb.append("activities: ").append(this.f1430Ug.toDebugString());
        }
        if (this.f1434Uk) {
            sb.append(" +server");
        }
        sb.append("}");
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0662f.m2016a(this, dest, flags);
    }
}
