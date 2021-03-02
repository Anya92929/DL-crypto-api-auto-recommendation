package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.C0618k;
import com.google.android.gms.fitness.data.DataSource;

public class FitnessSensorServiceRequest implements SafeParcelable {
    public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new C0700a();
    public static final int UNSPECIFIED = -1;

    /* renamed from: BR */
    private final int f1584BR;

    /* renamed from: Sh */
    private final DataSource f1585Sh;

    /* renamed from: UR */
    private final long f1586UR;

    /* renamed from: US */
    private final long f1587US;

    /* renamed from: Up */
    private final C0618k f1588Up;

    FitnessSensorServiceRequest(int versionCode, DataSource dataSource, IBinder listenerBinder, long samplingRateMicros, long batchIntervalMicros) {
        this.f1584BR = versionCode;
        this.f1585Sh = dataSource;
        this.f1588Up = C0618k.C0619a.m1858an(listenerBinder);
        this.f1586UR = samplingRateMicros;
        this.f1587US = batchIntervalMicros;
    }

    /* renamed from: a */
    private boolean m2129a(FitnessSensorServiceRequest fitnessSensorServiceRequest) {
        return C0345m.equal(this.f1585Sh, fitnessSensorServiceRequest.f1585Sh) && this.f1586UR == fitnessSensorServiceRequest.f1586UR && this.f1587US == fitnessSensorServiceRequest.f1587US;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof FitnessSensorServiceRequest) && m2129a((FitnessSensorServiceRequest) that));
    }

    public long getBatchIntervalMicros() {
        return this.f1587US;
    }

    public DataSource getDataSource() {
        return this.f1585Sh;
    }

    public SensorEventDispatcher getDispatcher() {
        return new C0701b(this.f1588Up);
    }

    public long getSamplingRateMicros() {
        return this.f1586UR;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1584BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1585Sh, Long.valueOf(this.f1586UR), Long.valueOf(this.f1587US));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: jq */
    public IBinder mo6317jq() {
        return this.f1588Up.asBinder();
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", new Object[]{this.f1585Sh});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0700a.m2131a(this, parcel, flags);
    }
}
