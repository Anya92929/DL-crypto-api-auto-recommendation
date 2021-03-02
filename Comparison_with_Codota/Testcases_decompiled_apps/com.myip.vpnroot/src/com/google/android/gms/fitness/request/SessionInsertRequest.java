package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new C0678r();

    /* renamed from: BR */
    private final int f1474BR;

    /* renamed from: Sk */
    private final Session f1475Sk;

    /* renamed from: Sw */
    private final List<DataSet> f1476Sw;

    /* renamed from: UA */
    private final List<DataPoint> f1477UA;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: Sk */
        public Session f1478Sk;
        /* access modifiers changed from: private */

        /* renamed from: Sw */
        public List<DataSet> f1479Sw = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: UA */
        public List<DataPoint> f1480UA = new ArrayList();

        /* renamed from: UB */
        private List<DataSource> f1481UB = new ArrayList();

        /* renamed from: c */
        private void m1950c(DataPoint dataPoint) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(this.f1478Sk.getStartTimeMillis());
            long nanos2 = TimeUnit.MILLISECONDS.toNanos(this.f1478Sk.getEndTimeMillis());
            long timestampNanos = dataPoint.getTimestampNanos();
            if (timestampNanos != 0) {
                C0348n.m853a(timestampNanos >= nanos && timestampNanos <= nanos2, "Data point %s has time stamp outside session interval [%d, %d]", dataPoint, Long.valueOf(nanos), Long.valueOf(nanos2));
            }
            long startTimeNanos = dataPoint.getStartTimeNanos();
            long endTimeNanos = dataPoint.getEndTimeNanos();
            if (startTimeNanos != 0 && endTimeNanos != 0) {
                C0348n.m853a(startTimeNanos >= nanos && endTimeNanos <= nanos2, "Data point %s has start and end times outside session interval [%d, %d]", dataPoint, Long.valueOf(nanos), Long.valueOf(nanos2));
            }
        }

        /* renamed from: jt */
        private void m1951jt() {
            for (DataSet dataPoints : this.f1479Sw) {
                for (DataPoint c : dataPoints.getDataPoints()) {
                    m1950c(c);
                }
            }
            for (DataPoint c2 : this.f1480UA) {
                m1950c(c2);
            }
        }

        public Builder addAggregateDataPoint(DataPoint aggregateDataPoint) {
            C0348n.m859b(aggregateDataPoint != null, (Object) "Must specify a valid aggregate data point.");
            long startTimeNanos = aggregateDataPoint.getStartTimeNanos();
            C0348n.m860b(startTimeNanos > 0 && aggregateDataPoint.getEndTimeNanos() > startTimeNanos, "Aggregate data point should have valid start and end times: %s", aggregateDataPoint);
            DataSource dataSource = aggregateDataPoint.getDataSource();
            C0348n.m853a(!this.f1481UB.contains(dataSource), "Data set/Aggregate data point for this data source %s is already added.", dataSource);
            this.f1481UB.add(dataSource);
            this.f1480UA.add(aggregateDataPoint);
            return this;
        }

        public Builder addDataSet(DataSet dataSet) {
            boolean z = true;
            C0348n.m859b(dataSet != null, (Object) "Must specify a valid data set.");
            DataSource dataSource = dataSet.getDataSource();
            C0348n.m853a(!this.f1481UB.contains(dataSource), "Data set for this data source %s is already added.", dataSource);
            if (dataSet.getDataPoints().isEmpty()) {
                z = false;
            }
            C0348n.m859b(z, (Object) "No data points specified in the input data set.");
            this.f1481UB.add(dataSource);
            this.f1479Sw.add(dataSet);
            return this;
        }

        public SessionInsertRequest build() {
            boolean z = true;
            C0348n.m852a(this.f1478Sk != null, "Must specify a valid session.");
            if (this.f1478Sk.getEndTimeMillis() == 0) {
                z = false;
            }
            C0348n.m852a(z, "Must specify a valid end time, cannot insert a continuing session.");
            m1951jt();
            return new SessionInsertRequest(this);
        }

        public Builder setSession(Session session) {
            this.f1478Sk = session;
            return this;
        }
    }

    SessionInsertRequest(int versionCode, Session session, List<DataSet> dataSets, List<DataPoint> aggregateDataPoints) {
        this.f1474BR = versionCode;
        this.f1475Sk = session;
        this.f1476Sw = Collections.unmodifiableList(dataSets);
        this.f1477UA = Collections.unmodifiableList(aggregateDataPoints);
    }

    private SessionInsertRequest(Builder builder) {
        this.f1474BR = 1;
        this.f1475Sk = builder.f1478Sk;
        this.f1476Sw = Collections.unmodifiableList(builder.f1479Sw);
        this.f1477UA = Collections.unmodifiableList(builder.f1480UA);
    }

    /* renamed from: a */
    private boolean m1945a(SessionInsertRequest sessionInsertRequest) {
        return C0345m.equal(this.f1475Sk, sessionInsertRequest.f1475Sk) && C0345m.equal(this.f1476Sw, sessionInsertRequest.f1476Sw) && C0345m.equal(this.f1477UA, sessionInsertRequest.f1477UA);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionInsertRequest) && m1945a((SessionInsertRequest) o));
    }

    public List<DataSet> getDataSets() {
        return this.f1476Sw;
    }

    public Session getSession() {
        return this.f1475Sk;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1474BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1475Sk, this.f1476Sw, this.f1477UA);
    }

    /* renamed from: js */
    public List<DataPoint> mo5972js() {
        return this.f1477UA;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("session", this.f1475Sk).mo4549a("dataSets", this.f1476Sw).mo4549a("aggregateDataPoints", this.f1477UA).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0678r.m2052a(this, dest, flags);
    }
}
