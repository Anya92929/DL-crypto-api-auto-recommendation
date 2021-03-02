package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest {
    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;

    /* renamed from: SF */
    private final DataType f1458SF;

    /* renamed from: Sh */
    private final DataSource f1459Sh;

    /* renamed from: Ti */
    private final long f1460Ti;

    /* renamed from: Tj */
    private final int f1461Tj;

    /* renamed from: Us */
    private final long f1462Us;

    /* renamed from: Ut */
    private final long f1463Ut;

    /* renamed from: Ux */
    private final LocationRequest f1464Ux;

    /* renamed from: Uy */
    private final long f1465Uy;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: SF */
        public DataType f1466SF;
        /* access modifiers changed from: private */

        /* renamed from: Sh */
        public DataSource f1467Sh;
        /* access modifiers changed from: private */

        /* renamed from: Ti */
        public long f1468Ti = -1;
        /* access modifiers changed from: private */

        /* renamed from: Tj */
        public int f1469Tj = 2;
        /* access modifiers changed from: private */

        /* renamed from: Us */
        public long f1470Us = 0;
        /* access modifiers changed from: private */

        /* renamed from: Ut */
        public long f1471Ut = 0;
        /* access modifiers changed from: private */

        /* renamed from: Uy */
        public long f1472Uy = Long.MAX_VALUE;

        /* renamed from: Uz */
        private boolean f1473Uz = false;

        public SensorRequest build() {
            boolean z = false;
            C0348n.m852a((this.f1467Sh == null && this.f1466SF == null) ? false : true, "Must call setDataSource() or setDataType()");
            if (this.f1466SF == null || this.f1467Sh == null || this.f1466SF.equals(this.f1467Sh.getDataType())) {
                z = true;
            }
            C0348n.m852a(z, "Specified data type is incompatible with specified data source");
            return new SensorRequest(this);
        }

        public Builder setAccuracyMode(int accuracyMode) {
            this.f1469Tj = SensorRequest.m1933da(accuracyMode);
            return this;
        }

        public Builder setDataSource(DataSource dataSource) {
            this.f1467Sh = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.f1466SF = dataType;
            return this;
        }

        public Builder setFastestRate(int fastestInterval, TimeUnit unit) {
            C0348n.m859b(fastestInterval >= 0, (Object) "Cannot use a negative interval");
            this.f1473Uz = true;
            this.f1471Ut = unit.toMicros((long) fastestInterval);
            return this;
        }

        public Builder setMaxDeliveryLatency(int interval, TimeUnit unit) {
            C0348n.m859b(interval >= 0, (Object) "Cannot use a negative delivery interval");
            this.f1470Us = unit.toMicros((long) interval);
            return this;
        }

        public Builder setSamplingRate(long interval, TimeUnit unit) {
            C0348n.m859b(interval >= 0, (Object) "Cannot use a negative sampling interval");
            this.f1468Ti = unit.toMicros(interval);
            if (!this.f1473Uz) {
                this.f1471Ut = this.f1468Ti / 2;
            }
            return this;
        }

        public Builder setTimeout(long timeout, TimeUnit timeUnit) {
            boolean z = true;
            C0348n.m860b(timeout > 0, "Invalid time out value specified: %d", Long.valueOf(timeout));
            if (timeUnit == null) {
                z = false;
            }
            C0348n.m859b(z, (Object) "Invalid time unit specified");
            this.f1472Uy = timeUnit.toMicros(timeout);
            return this;
        }
    }

    private SensorRequest(DataSource dataSource, LocationRequest locationRequest) {
        this.f1464Ux = locationRequest;
        this.f1460Ti = TimeUnit.MILLISECONDS.toMicros(locationRequest.getInterval());
        this.f1463Ut = TimeUnit.MILLISECONDS.toMicros(locationRequest.getFastestInterval());
        this.f1462Us = this.f1460Ti;
        this.f1458SF = dataSource.getDataType();
        this.f1461Tj = m1931a(locationRequest);
        this.f1459Sh = dataSource;
        long expirationTime = locationRequest.getExpirationTime();
        if (expirationTime == Long.MAX_VALUE) {
            this.f1465Uy = Long.MAX_VALUE;
        } else {
            this.f1465Uy = TimeUnit.MILLISECONDS.toMicros(expirationTime - SystemClock.elapsedRealtime());
        }
    }

    private SensorRequest(Builder builder) {
        this.f1459Sh = builder.f1467Sh;
        this.f1458SF = builder.f1466SF;
        this.f1460Ti = builder.f1468Ti;
        this.f1463Ut = builder.f1471Ut;
        this.f1462Us = builder.f1470Us;
        this.f1461Tj = builder.f1469Tj;
        this.f1464Ux = null;
        this.f1465Uy = builder.f1472Uy;
    }

    /* renamed from: a */
    private static int m1931a(LocationRequest locationRequest) {
        switch (locationRequest.getPriority()) {
            case 100:
                return 3;
            case 104:
                return 1;
            default:
                return 2;
        }
    }

    /* renamed from: a */
    private boolean m1932a(SensorRequest sensorRequest) {
        return C0345m.equal(this.f1459Sh, sensorRequest.f1459Sh) && C0345m.equal(this.f1458SF, sensorRequest.f1458SF) && this.f1460Ti == sensorRequest.f1460Ti && this.f1463Ut == sensorRequest.f1463Ut && this.f1462Us == sensorRequest.f1462Us && this.f1461Tj == sensorRequest.f1461Tj && C0345m.equal(this.f1464Ux, sensorRequest.f1464Ux) && this.f1465Uy == sensorRequest.f1465Uy;
    }

    /* renamed from: da */
    public static int m1933da(int i) {
        switch (i) {
            case 1:
            case 3:
                return i;
            default:
                return 2;
        }
    }

    public static SensorRequest fromLocationRequest(DataSource dataSource, LocationRequest locationRequest) {
        return new SensorRequest(dataSource, locationRequest);
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SensorRequest) && m1932a((SensorRequest) that));
    }

    public DataSource getDataSource() {
        return this.f1459Sh;
    }

    public DataType getDataType() {
        return this.f1458SF;
    }

    public long getSamplingRateMicros() {
        return this.f1460Ti;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1459Sh, this.f1458SF, Long.valueOf(this.f1460Ti), Long.valueOf(this.f1463Ut), Long.valueOf(this.f1462Us), Integer.valueOf(this.f1461Tj), this.f1464Ux, Long.valueOf(this.f1465Uy));
    }

    /* renamed from: iQ */
    public int mo5953iQ() {
        return this.f1461Tj;
    }

    /* renamed from: jm */
    public long mo5954jm() {
        return this.f1463Ut;
    }

    /* renamed from: jn */
    public long mo5955jn() {
        return this.f1462Us;
    }

    /* renamed from: jr */
    public long mo5956jr() {
        return this.f1465Uy;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("dataSource", this.f1459Sh).mo4549a("dataType", this.f1458SF).mo4549a("samplingRateMicros", Long.valueOf(this.f1460Ti)).mo4549a("deliveryLatencyMicros", Long.valueOf(this.f1462Us)).mo4549a("timeOutMicros", Long.valueOf(this.f1465Uy)).toString();
    }
}
