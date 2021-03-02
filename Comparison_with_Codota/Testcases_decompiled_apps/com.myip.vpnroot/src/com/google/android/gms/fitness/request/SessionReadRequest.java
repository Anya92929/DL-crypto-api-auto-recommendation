package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionReadRequest> CREATOR = new C0679s();

    /* renamed from: BR */
    private final int f1482BR;

    /* renamed from: KL */
    private final long f1483KL;

    /* renamed from: Si */
    private final long f1484Si;

    /* renamed from: Su */
    private final List<DataType> f1485Su;

    /* renamed from: TZ */
    private final List<DataSource> f1486TZ;

    /* renamed from: UC */
    private final String f1487UC;

    /* renamed from: UD */
    private boolean f1488UD;

    /* renamed from: UE */
    private final List<String> f1489UE;

    /* renamed from: Uk */
    private final boolean f1490Uk;

    /* renamed from: vL */
    private final String f1491vL;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: KL */
        public long f1492KL = 0;
        /* access modifiers changed from: private */

        /* renamed from: Si */
        public long f1493Si = 0;
        /* access modifiers changed from: private */

        /* renamed from: Su */
        public List<DataType> f1494Su = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: TZ */
        public List<DataSource> f1495TZ = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: UC */
        public String f1496UC;
        /* access modifiers changed from: private */

        /* renamed from: UD */
        public boolean f1497UD = false;
        /* access modifiers changed from: private */

        /* renamed from: UE */
        public List<String> f1498UE = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: Uk */
        public boolean f1499Uk = false;
        /* access modifiers changed from: private */

        /* renamed from: vL */
        public String f1500vL;

        public SessionReadRequest build() {
            C0348n.m860b(this.f1492KL > 0, "Invalid start time: %s", Long.valueOf(this.f1492KL));
            C0348n.m860b(this.f1493Si > 0 && this.f1493Si > this.f1492KL, "Invalid end time: %s", Long.valueOf(this.f1493Si));
            return new SessionReadRequest(this);
        }

        public Builder enableServerQueries() {
            this.f1499Uk = true;
            return this;
        }

        public Builder excludePackage(String appPackageName) {
            C0348n.m857b(appPackageName, (Object) "Attempting to use a null package name");
            if (!this.f1498UE.contains(appPackageName)) {
                this.f1498UE.add(appPackageName);
            }
            return this;
        }

        public Builder read(DataSource dataSource) {
            C0348n.m857b(dataSource, (Object) "Attempting to add a null data source");
            if (!this.f1495TZ.contains(dataSource)) {
                this.f1495TZ.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            C0348n.m857b(dataType, (Object) "Attempting to use a null data type");
            if (!this.f1494Su.contains(dataType)) {
                this.f1494Su.add(dataType);
            }
            return this;
        }

        public Builder readSessionsFromAllApps() {
            this.f1497UD = true;
            return this;
        }

        public Builder setSessionId(String sessionId) {
            this.f1500vL = sessionId;
            return this;
        }

        public Builder setSessionName(String sessionName) {
            this.f1496UC = sessionName;
            return this;
        }

        public Builder setTimeInterval(long startTimeMillis, long endTimeMillis) {
            this.f1492KL = startTimeMillis;
            this.f1493Si = endTimeMillis;
            return this;
        }

        public Builder setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
            return setTimeInterval(timeUnit.toMillis(startTime), timeUnit.toMillis(endTime));
        }
    }

    SessionReadRequest(int versionCode, String sessionName, String sessionId, long startTimeMillis, long endTimeMillis, List<DataType> dataTypes, List<DataSource> dataSources, boolean getSessionsFromAllApps, boolean serverQueriesEnabled, List<String> excludedPackages) {
        this.f1482BR = versionCode;
        this.f1487UC = sessionName;
        this.f1491vL = sessionId;
        this.f1483KL = startTimeMillis;
        this.f1484Si = endTimeMillis;
        this.f1485Su = Collections.unmodifiableList(dataTypes);
        this.f1486TZ = Collections.unmodifiableList(dataSources);
        this.f1488UD = getSessionsFromAllApps;
        this.f1490Uk = serverQueriesEnabled;
        this.f1489UE = excludedPackages;
    }

    private SessionReadRequest(Builder builder) {
        this.f1482BR = 3;
        this.f1487UC = builder.f1496UC;
        this.f1491vL = builder.f1500vL;
        this.f1483KL = builder.f1492KL;
        this.f1484Si = builder.f1493Si;
        this.f1485Su = Collections.unmodifiableList(builder.f1494Su);
        this.f1486TZ = Collections.unmodifiableList(builder.f1495TZ);
        this.f1488UD = builder.f1497UD;
        this.f1490Uk = builder.f1499Uk;
        this.f1489UE = builder.f1498UE;
    }

    /* renamed from: a */
    private boolean m1952a(SessionReadRequest sessionReadRequest) {
        return C0345m.equal(this.f1487UC, sessionReadRequest.f1487UC) && this.f1491vL.equals(sessionReadRequest.f1491vL) && this.f1483KL == sessionReadRequest.f1483KL && this.f1484Si == sessionReadRequest.f1484Si && C0345m.equal(this.f1485Su, sessionReadRequest.f1485Su) && C0345m.equal(this.f1486TZ, sessionReadRequest.f1486TZ) && this.f1488UD == sessionReadRequest.f1488UD && this.f1489UE.equals(sessionReadRequest.f1489UE) && this.f1490Uk == sessionReadRequest.f1490Uk;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof SessionReadRequest) && m1952a((SessionReadRequest) o));
    }

    public List<DataSource> getDataSources() {
        return this.f1486TZ;
    }

    public List<DataType> getDataTypes() {
        return this.f1485Su;
    }

    public long getEndTimeMillis() {
        return this.f1484Si;
    }

    public String getSessionId() {
        return this.f1491vL;
    }

    public long getStartTimeMillis() {
        return this.f1483KL;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1482BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1487UC, this.f1491vL, Long.valueOf(this.f1483KL), Long.valueOf(this.f1484Si));
    }

    /* renamed from: jg */
    public boolean mo5988jg() {
        return this.f1490Uk;
    }

    /* renamed from: ju */
    public String mo5989ju() {
        return this.f1487UC;
    }

    /* renamed from: jv */
    public boolean mo5990jv() {
        return this.f1488UD;
    }

    /* renamed from: jw */
    public List<String> mo5991jw() {
        return this.f1489UE;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("sessionName", this.f1487UC).mo4549a("sessionId", this.f1491vL).mo4549a("startTimeMillis", Long.valueOf(this.f1483KL)).mo4549a("endTimeMillis", Long.valueOf(this.f1484Si)).mo4549a("dataTypes", this.f1485Su).mo4549a("dataSources", this.f1486TZ).mo4549a("sessionsFromAllApps", Boolean.valueOf(this.f1488UD)).mo4549a("excludedPackages", this.f1489UE).mo4549a("useServer", Boolean.valueOf(this.f1490Uk)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0679s.m2055a(this, dest, flags);
    }
}
