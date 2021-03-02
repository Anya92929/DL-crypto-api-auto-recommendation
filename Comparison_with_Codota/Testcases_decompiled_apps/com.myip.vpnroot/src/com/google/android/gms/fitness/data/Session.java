package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.C0355c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.FitnessIntents;
import com.google.android.gms.plus.PlusShare;

public class Session implements SafeParcelable {
    public static final Parcelable.Creator<Session> CREATOR = new C0627p();

    /* renamed from: BR */
    private final int f1365BR;

    /* renamed from: KL */
    private final long f1366KL;

    /* renamed from: SJ */
    private final C0608a f1367SJ;

    /* renamed from: Si */
    private final long f1368Si;

    /* renamed from: Sv */
    private final int f1369Sv;

    /* renamed from: Tf */
    private final String f1370Tf;

    /* renamed from: Tg */
    private final String f1371Tg;
    private final String mName;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: KL */
        public long f1372KL = 0;
        /* access modifiers changed from: private */

        /* renamed from: SJ */
        public C0608a f1373SJ;
        /* access modifiers changed from: private */

        /* renamed from: Si */
        public long f1374Si = 0;
        /* access modifiers changed from: private */

        /* renamed from: Sv */
        public int f1375Sv = 4;
        /* access modifiers changed from: private */

        /* renamed from: Tf */
        public String f1376Tf;
        /* access modifiers changed from: private */

        /* renamed from: Tg */
        public String f1377Tg;
        /* access modifiers changed from: private */
        public String mName = null;

        public Session build() {
            boolean z = false;
            C0348n.m852a(this.f1372KL > 0, "Start time should be specified.");
            if (this.f1374Si == 0 || this.f1374Si > this.f1372KL) {
                z = true;
            }
            C0348n.m852a(z, "End time should be later than start time.");
            if (this.f1376Tf == null) {
                this.f1376Tf = (this.mName == null ? "" : this.mName) + this.f1372KL;
            }
            return new Session(this);
        }

        public Builder setActivity(int activity) {
            this.f1375Sv = FitnessActivities.m1757cw(activity);
            return this;
        }

        public Builder setDescription(String description) {
            C0348n.m860b(description.length() <= 1000, "Session description cannot exceed %d characters", 1000);
            this.f1377Tg = description;
            return this;
        }

        public Builder setEndTimeMillis(long endTimeMillis) {
            C0348n.m852a(endTimeMillis >= 0, "End time should be positive.");
            this.f1374Si = endTimeMillis;
            return this;
        }

        public Builder setIdentifier(String identifier) {
            this.f1376Tf = identifier;
            return this;
        }

        public Builder setName(String name) {
            C0348n.m860b(name.length() <= 100, "Session name cannot exceed %d characters", 100);
            this.mName = name;
            return this;
        }

        public Builder setStartTimeMillis(long startTimeMillis) {
            C0348n.m852a(startTimeMillis > 0, "Start time should be positive.");
            this.f1372KL = startTimeMillis;
            return this;
        }
    }

    Session(int versionCode, long startTimeMillis, long endTimeMillis, String name, String identifier, String description, int activity, C0608a application) {
        this.f1365BR = versionCode;
        this.f1366KL = startTimeMillis;
        this.f1368Si = endTimeMillis;
        this.mName = name;
        this.f1370Tf = identifier;
        this.f1371Tg = description;
        this.f1369Sv = activity;
        this.f1367SJ = application;
    }

    private Session(Builder builder) {
        this.f1365BR = 2;
        this.f1366KL = builder.f1372KL;
        this.f1368Si = builder.f1374Si;
        this.mName = builder.mName;
        this.f1370Tf = builder.f1376Tf;
        this.f1371Tg = builder.f1377Tg;
        this.f1369Sv = builder.f1375Sv;
        this.f1367SJ = builder.f1373SJ;
    }

    /* renamed from: a */
    private boolean m1808a(Session session) {
        return this.f1366KL == session.f1366KL && this.f1368Si == session.f1368Si && C0345m.equal(this.mName, session.mName) && C0345m.equal(this.f1370Tf, session.f1370Tf) && C0345m.equal(this.f1371Tg, session.f1371Tg) && C0345m.equal(this.f1367SJ, session.f1367SJ) && this.f1369Sv == session.f1369Sv;
    }

    public static Session extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Session) C0355c.m942a(intent, FitnessIntents.EXTRA_SESSION, CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof Session) && m1808a((Session) o));
    }

    public int getActivity() {
        return this.f1369Sv;
    }

    public String getAppPackageName() {
        if (this.f1367SJ == null) {
            return null;
        }
        return this.f1367SJ.getPackageName();
    }

    public String getDescription() {
        return this.f1371Tg;
    }

    public long getEndTimeMillis() {
        return this.f1368Si;
    }

    public String getIdentifier() {
        return this.f1370Tf;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartTimeMillis() {
        return this.f1366KL;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1365BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Long.valueOf(this.f1366KL), Long.valueOf(this.f1368Si), this.mName, this.f1370Tf, Integer.valueOf(this.f1369Sv), this.f1367SJ, this.f1371Tg);
    }

    /* renamed from: iH */
    public C0608a mo5737iH() {
        return this.f1367SJ;
    }

    public boolean isOngoing() {
        return this.f1368Si == 0;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("startTime", Long.valueOf(this.f1366KL)).mo4549a("endTime", Long.valueOf(this.f1368Si)).mo4549a("name", this.mName).mo4549a("identifier", this.f1370Tf).mo4549a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.f1371Tg).mo4549a("activity", Integer.valueOf(this.f1369Sv)).mo4549a("application", this.f1367SJ).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0627p.m1872a(this, dest, flags);
    }
}
