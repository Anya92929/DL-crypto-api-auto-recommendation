package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new C0660d();

    /* renamed from: BR */
    private final int f1403BR;

    /* renamed from: KL */
    private final long f1404KL;

    /* renamed from: Si */
    private final long f1405Si;

    /* renamed from: Su */
    private final List<DataType> f1406Su;

    /* renamed from: TZ */
    private final List<DataSource> f1407TZ;

    /* renamed from: Ua */
    private final List<Session> f1408Ua;

    /* renamed from: Ub */
    private final boolean f1409Ub;

    /* renamed from: Uc */
    private final boolean f1410Uc;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: KL */
        public long f1411KL;
        /* access modifiers changed from: private */

        /* renamed from: Si */
        public long f1412Si;
        /* access modifiers changed from: private */

        /* renamed from: Su */
        public List<DataType> f1413Su = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: TZ */
        public List<DataSource> f1414TZ = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: Ua */
        public List<Session> f1415Ua = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: Ub */
        public boolean f1416Ub = false;
        /* access modifiers changed from: private */

        /* renamed from: Uc */
        public boolean f1417Uc = false;

        /* renamed from: iZ */
        private void m1897iZ() {
            if (!this.f1415Ua.isEmpty()) {
                for (Session next : this.f1415Ua) {
                    C0348n.m853a(next.getStartTimeMillis() >= this.f1411KL && next.getEndTimeMillis() <= this.f1412Si, "Session %s is outside the time interval [%d, %d]", next, Long.valueOf(this.f1411KL), Long.valueOf(this.f1412Si));
                }
            }
        }

        public Builder addDataSource(DataSource dataSource) {
            boolean z = true;
            C0348n.m859b(!this.f1416Ub, (Object) "All data is already marked for deletion");
            if (dataSource == null) {
                z = false;
            }
            C0348n.m859b(z, (Object) "Must specify a valid data source");
            if (!this.f1414TZ.contains(dataSource)) {
                this.f1414TZ.add(dataSource);
            }
            return this;
        }

        public Builder addDataType(DataType dataType) {
            boolean z = true;
            C0348n.m859b(!this.f1416Ub, (Object) "All data is already marked for deletion");
            if (dataType == null) {
                z = false;
            }
            C0348n.m859b(z, (Object) "Must specify a valid data type");
            if (!this.f1413Su.contains(dataType)) {
                this.f1413Su.add(dataType);
            }
            return this;
        }

        public Builder addSession(Session session) {
            boolean z = true;
            C0348n.m859b(!this.f1417Uc, (Object) "All sessions already marked for deletion");
            C0348n.m859b(session != null, (Object) "Must specify a valid session");
            if (session.getEndTimeMillis() <= 0) {
                z = false;
            }
            C0348n.m859b(z, (Object) "Must specify a session that has already ended");
            this.f1415Ua.add(session);
            return this;
        }

        public DataDeleteRequest build() {
            boolean z = false;
            C0348n.m852a(this.f1411KL > 0 && this.f1412Si > this.f1411KL, "Must specify a valid time interval");
            boolean z2 = this.f1416Ub || !this.f1414TZ.isEmpty() || !this.f1413Su.isEmpty();
            boolean z3 = this.f1417Uc || !this.f1415Ua.isEmpty();
            if (z2 || z3) {
                z = true;
            }
            C0348n.m852a(z, "No data or session marked for deletion");
            m1897iZ();
            return new DataDeleteRequest(this);
        }

        public Builder deleteAllData() {
            C0348n.m860b(this.f1413Su.isEmpty() && this.f1414TZ.isEmpty(), "Specific data source/type already specified for deletion. DataSources: %s DataTypes: %s", this.f1414TZ, this.f1413Su);
            this.f1416Ub = true;
            return this;
        }

        public Builder deleteAllSessions() {
            C0348n.m860b(this.f1415Ua.isEmpty(), "Specific sessions already added for deletion: %s", this.f1415Ua);
            this.f1417Uc = true;
            return this;
        }

        public Builder setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
            C0348n.m860b(startTime > 0, "Invalid start time :%d", Long.valueOf(startTime));
            C0348n.m860b(endTime > startTime, "Invalid end time :%d", Long.valueOf(endTime));
            this.f1411KL = timeUnit.toMillis(startTime);
            this.f1412Si = timeUnit.toMillis(endTime);
            return this;
        }
    }

    DataDeleteRequest(int versionCode, long startTimeMillis, long endTimeMillis, List<DataSource> dataSources, List<DataType> dataTypes, List<Session> sessions, boolean deleteAllData, boolean deleteAllSessions) {
        this.f1403BR = versionCode;
        this.f1404KL = startTimeMillis;
        this.f1405Si = endTimeMillis;
        this.f1407TZ = Collections.unmodifiableList(dataSources);
        this.f1406Su = Collections.unmodifiableList(dataTypes);
        this.f1408Ua = sessions;
        this.f1409Ub = deleteAllData;
        this.f1410Uc = deleteAllSessions;
    }

    private DataDeleteRequest(Builder builder) {
        this.f1403BR = 1;
        this.f1404KL = builder.f1411KL;
        this.f1405Si = builder.f1412Si;
        this.f1407TZ = Collections.unmodifiableList(builder.f1414TZ);
        this.f1406Su = Collections.unmodifiableList(builder.f1413Su);
        this.f1408Ua = Collections.unmodifiableList(builder.f1415Ua);
        this.f1409Ub = builder.f1416Ub;
        this.f1410Uc = builder.f1417Uc;
    }

    /* renamed from: a */
    private boolean m1887a(DataDeleteRequest dataDeleteRequest) {
        return this.f1404KL == dataDeleteRequest.f1404KL && this.f1405Si == dataDeleteRequest.f1405Si && C0345m.equal(this.f1407TZ, dataDeleteRequest.f1407TZ) && C0345m.equal(this.f1406Su, dataDeleteRequest.f1406Su) && C0345m.equal(this.f1408Ua, dataDeleteRequest.f1408Ua) && this.f1409Ub == dataDeleteRequest.f1409Ub && this.f1410Uc == dataDeleteRequest.f1410Uc;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataDeleteRequest) && m1887a((DataDeleteRequest) o));
    }

    public List<DataSource> getDataSources() {
        return this.f1407TZ;
    }

    public List<DataType> getDataTypes() {
        return this.f1406Su;
    }

    public long getEndTimeMillis() {
        return this.f1405Si;
    }

    public List<Session> getSessions() {
        return this.f1408Ua;
    }

    public long getStartTimeMillis() {
        return this.f1404KL;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1403BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Long.valueOf(this.f1404KL), Long.valueOf(this.f1405Si));
    }

    /* renamed from: iX */
    public boolean mo5873iX() {
        return this.f1409Ub;
    }

    /* renamed from: iY */
    public boolean mo5874iY() {
        return this.f1410Uc;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("startTimeMillis", Long.valueOf(this.f1404KL)).mo4549a("endTimeMillis", Long.valueOf(this.f1405Si)).mo4549a("dataSources", this.f1407TZ).mo4549a("dateTypes", this.f1406Su).mo4549a("sessions", this.f1408Ua).mo4549a("deleteAllData", Boolean.valueOf(this.f1409Ub)).mo4549a("deleteAllSessions", Boolean.valueOf(this.f1410Uc)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0660d.m2010a(this, dest, flags);
    }
}
