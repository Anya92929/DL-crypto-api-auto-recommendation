package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.C0642a;
import com.google.android.gms.fitness.request.C0667k;
import com.google.android.gms.internal.C1382jr;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
    public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new C0646ab();

    /* renamed from: BR */
    private final int f1501BR;

    /* renamed from: Su */
    private final List<DataType> f1502Su;

    /* renamed from: UF */
    private final C0667k f1503UF;

    /* renamed from: UG */
    private final int f1504UG;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: UF */
        public C0667k f1505UF;
        /* access modifiers changed from: private */

        /* renamed from: UG */
        public int f1506UG = 10;
        /* access modifiers changed from: private */

        /* renamed from: Un */
        public DataType[] f1507Un = new DataType[0];

        /* renamed from: a */
        public Builder mo6011a(C0667k kVar) {
            this.f1505UF = kVar;
            return this;
        }

        public StartBleScanRequest build() {
            C0348n.m852a(this.f1505UF != null, "Must set BleScanCallback");
            return new StartBleScanRequest(this);
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            mo6011a((C0667k) C0642a.C0644a.m1972iV().mo6023a(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.f1507Un = dataTypes;
            return this;
        }

        public Builder setTimeoutSecs(int stopTimeSecs) {
            boolean z = true;
            C0348n.m859b(stopTimeSecs > 0, (Object) "Stop time must be greater than zero");
            if (stopTimeSecs > 60) {
                z = false;
            }
            C0348n.m859b(z, (Object) "Stop time must be less than 1 minute");
            this.f1506UG = stopTimeSecs;
            return this;
        }
    }

    StartBleScanRequest(int versionCode, List<DataType> dataTypes, IBinder bleScanCallback, int timeoutSecs) {
        this.f1501BR = versionCode;
        this.f1502Su = dataTypes;
        this.f1503UF = C0667k.C0668a.m2029ay(bleScanCallback);
        this.f1504UG = timeoutSecs;
    }

    private StartBleScanRequest(Builder builder) {
        this.f1501BR = 2;
        this.f1502Su = C1382jr.m5208b(builder.f1507Un);
        this.f1503UF = builder.f1505UF;
        this.f1504UG = builder.f1506UG;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.f1502Su);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1501BR;
    }

    /* renamed from: jA */
    public int mo6007jA() {
        return this.f1504UG;
    }

    /* renamed from: jz */
    public IBinder mo6008jz() {
        return this.f1503UF.asBinder();
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("dataTypes", this.f1502Su).mo4549a("timeoutSecs", Integer.valueOf(this.f1504UG)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0646ab.m1978a(this, parcel, flags);
    }
}
