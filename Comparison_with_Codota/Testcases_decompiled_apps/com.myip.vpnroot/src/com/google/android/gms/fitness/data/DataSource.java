package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1447kv;

public class DataSource implements SafeParcelable {
    public static final Parcelable.Creator<DataSource> CREATOR = new C0614g();
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;

    /* renamed from: BR */
    private final int f1312BR;

    /* renamed from: FD */
    private final int f1313FD;

    /* renamed from: SF */
    private final DataType f1314SF;

    /* renamed from: SI */
    private final Device f1315SI;

    /* renamed from: SJ */
    private final C0608a f1316SJ;

    /* renamed from: SK */
    private final String f1317SK;

    /* renamed from: SL */
    private final boolean f1318SL;

    /* renamed from: SM */
    private final String f1319SM;
    private final String mName;

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: FD */
        public int f1320FD = -1;
        /* access modifiers changed from: private */

        /* renamed from: SF */
        public DataType f1321SF;
        /* access modifiers changed from: private */

        /* renamed from: SI */
        public Device f1322SI;
        /* access modifiers changed from: private */

        /* renamed from: SJ */
        public C0608a f1323SJ;
        /* access modifiers changed from: private */

        /* renamed from: SK */
        public String f1324SK = "";
        /* access modifiers changed from: private */

        /* renamed from: SL */
        public boolean f1325SL = false;
        /* access modifiers changed from: private */
        public String mName;

        public DataSource build() {
            boolean z = true;
            C0348n.m852a(this.f1321SF != null, "Must set data type");
            if (this.f1320FD < 0) {
                z = false;
            }
            C0348n.m852a(z, "Must set data source type");
            return new DataSource(this);
        }

        public Builder setAppPackageName(Context appContext) {
            return setAppPackageName(appContext.getPackageName());
        }

        public Builder setAppPackageName(String packageName) {
            this.f1323SJ = new C0608a(packageName, (String) null, (String) null);
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.f1321SF = dataType;
            return this;
        }

        public Builder setDevice(Device device) {
            this.f1322SI = device;
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        public Builder setObfuscated(boolean isObfuscated) {
            this.f1325SL = isObfuscated;
            return this;
        }

        public Builder setStreamName(String streamName) {
            C0348n.m859b(streamName != null, (Object) "Must specify a valid stream name");
            this.f1324SK = streamName;
            return this;
        }

        public Builder setType(int type) {
            this.f1320FD = type;
            return this;
        }
    }

    DataSource(int versionCode, DataType dataType, String name, int type, Device device, C0608a application, String streamName, boolean isObfuscated) {
        this.f1312BR = versionCode;
        this.f1314SF = dataType;
        this.f1313FD = type;
        this.mName = name;
        this.f1315SI = device;
        this.f1316SJ = application;
        this.f1317SK = streamName;
        this.f1318SL = isObfuscated;
        this.f1319SM = m1783iI();
    }

    private DataSource(Builder builder) {
        this.f1312BR = 3;
        this.f1314SF = builder.f1321SF;
        this.f1313FD = builder.f1320FD;
        this.mName = builder.mName;
        this.f1315SI = builder.f1322SI;
        this.f1316SJ = builder.f1323SJ;
        this.f1317SK = builder.f1324SK;
        this.f1318SL = builder.f1325SL;
        this.f1319SM = m1783iI();
    }

    /* renamed from: a */
    private boolean m1782a(DataSource dataSource) {
        return this.f1314SF.equals(dataSource.f1314SF) && this.f1313FD == dataSource.f1313FD && C0345m.equal(this.mName, dataSource.mName) && C0345m.equal(this.f1315SI, dataSource.f1315SI) && C0345m.equal(this.f1317SK, dataSource.f1317SK) && C0345m.equal(this.f1316SJ, dataSource.f1316SJ);
    }

    private String getTypeString() {
        switch (this.f1313FD) {
            case 0:
                return "raw";
            case 1:
                return "derived";
            default:
                throw new IllegalArgumentException("invalid type value");
        }
    }

    /* renamed from: iI */
    private String m1783iI() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTypeString());
        sb.append(":").append(this.f1314SF.getName());
        if (this.f1316SJ != null) {
            sb.append(":").append(this.f1316SJ.getPackageName());
        }
        if (this.f1315SI != null) {
            sb.append(":").append(this.f1315SI.getStreamIdentifier());
        }
        if (this.f1317SK != null) {
            sb.append(":").append(this.f1317SK);
        }
        return sb.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSource) && m1782a((DataSource) that));
    }

    public String getAppPackageName() {
        if (this.f1316SJ == null) {
            return null;
        }
        return this.f1316SJ.getPackageName();
    }

    public DataType getDataType() {
        return this.f1314SF;
    }

    public Device getDevice() {
        return this.f1315SI;
    }

    public String getName() {
        return this.mName;
    }

    public String getStreamIdentifier() {
        return this.f1319SM;
    }

    public String getStreamName() {
        return this.f1317SK;
    }

    public int getType() {
        return this.f1313FD;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1312BR;
    }

    public int hashCode() {
        return this.f1319SM.hashCode();
    }

    /* renamed from: iH */
    public C0608a mo5664iH() {
        return this.f1316SJ;
    }

    /* renamed from: iJ */
    public boolean mo5665iJ() {
        return this.f1318SL;
    }

    /* renamed from: iK */
    public DataSource mo5666iK() {
        return new DataSource(3, this.f1314SF, this.mName, this.f1313FD, this.f1315SI == null ? null : this.f1315SI.mo5699iM(), this.f1316SJ == null ? null : this.f1316SJ.mo5780iA(), C1447kv.m5334bq(this.f1317SK), this.f1318SL);
    }

    public String toDebugString() {
        return (this.f1313FD == 0 ? "r" : "d") + ":" + this.f1314SF.mo5685iL() + (this.f1316SJ == null ? "" : this.f1316SJ.equals(C0608a.f1391Sp) ? ":gms" : ":" + this.f1316SJ.getPackageName()) + (this.f1315SI != null ? ":" + this.f1315SI.getModel() : "") + (this.f1317SK != null ? ":" + this.f1317SK : "");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataSource{");
        sb.append(getTypeString());
        if (this.mName != null) {
            sb.append(":").append(this.mName);
        }
        if (this.f1316SJ != null) {
            sb.append(":").append(this.f1316SJ);
        }
        if (this.f1315SI != null) {
            sb.append(":").append(this.f1315SI);
        }
        if (this.f1317SK != null) {
            sb.append(":").append(this.f1317SK);
        }
        sb.append(":").append(this.f1314SF);
        return sb.append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0614g.m1846a(C1447kv.m5335c(this), parcel, flags);
    }
}
