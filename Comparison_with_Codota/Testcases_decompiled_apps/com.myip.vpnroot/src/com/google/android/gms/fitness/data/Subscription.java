package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Subscription implements SafeParcelable {
    public static final Parcelable.Creator<Subscription> CREATOR = new C0630s();

    /* renamed from: BR */
    private final int f1378BR;

    /* renamed from: SF */
    private final DataType f1379SF;

    /* renamed from: Sh */
    private final DataSource f1380Sh;

    /* renamed from: Ti */
    private final long f1381Ti;

    /* renamed from: Tj */
    private final int f1382Tj;

    /* renamed from: com.google.android.gms.fitness.data.Subscription$a */
    public static class C0607a {
        /* access modifiers changed from: private */

        /* renamed from: SF */
        public DataType f1383SF;
        /* access modifiers changed from: private */

        /* renamed from: Sh */
        public DataSource f1384Sh;
        /* access modifiers changed from: private */

        /* renamed from: Ti */
        public long f1385Ti = -1;
        /* access modifiers changed from: private */

        /* renamed from: Tj */
        public int f1386Tj = 2;

        /* renamed from: b */
        public C0607a mo5758b(DataSource dataSource) {
            this.f1384Sh = dataSource;
            return this;
        }

        /* renamed from: b */
        public C0607a mo5759b(DataType dataType) {
            this.f1383SF = dataType;
            return this;
        }

        /* renamed from: iR */
        public Subscription mo5760iR() {
            boolean z = false;
            C0348n.m852a((this.f1384Sh == null && this.f1383SF == null) ? false : true, "Must call setDataSource() or setDataType()");
            if (this.f1383SF == null || this.f1384Sh == null || this.f1383SF.equals(this.f1384Sh.getDataType())) {
                z = true;
            }
            C0348n.m852a(z, "Specified data type is incompatible with specified data source");
            return new Subscription(this);
        }
    }

    Subscription(int versionCode, DataSource dataSource, DataType dataType, long samplingIntervalMicros, int accuracyMode) {
        this.f1378BR = versionCode;
        this.f1380Sh = dataSource;
        this.f1379SF = dataType;
        this.f1381Ti = samplingIntervalMicros;
        this.f1382Tj = accuracyMode;
    }

    private Subscription(C0607a builder) {
        this.f1378BR = 1;
        this.f1379SF = builder.f1383SF;
        this.f1380Sh = builder.f1384Sh;
        this.f1381Ti = builder.f1385Ti;
        this.f1382Tj = builder.f1386Tj;
    }

    /* renamed from: a */
    private boolean m1817a(Subscription subscription) {
        return C0345m.equal(this.f1380Sh, subscription.f1380Sh) && C0345m.equal(this.f1379SF, subscription.f1379SF) && this.f1381Ti == subscription.f1381Ti && this.f1382Tj == subscription.f1382Tj;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Subscription) && m1817a((Subscription) that));
    }

    public DataSource getDataSource() {
        return this.f1380Sh;
    }

    public DataType getDataType() {
        return this.f1379SF;
    }

    public long getSamplingRateMicros() {
        return this.f1381Ti;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1378BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1380Sh, this.f1380Sh, Long.valueOf(this.f1381Ti), Integer.valueOf(this.f1382Tj));
    }

    /* renamed from: iQ */
    public int mo5755iQ() {
        return this.f1382Tj;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("dataSource", this.f1380Sh).mo4549a("dataType", this.f1379SF).mo4549a("samplingIntervalMicros", Long.valueOf(this.f1381Ti)).mo4549a("accuracyMode", Integer.valueOf(this.f1382Tj)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0630s.m1880a(this, dest, flags);
    }
}
