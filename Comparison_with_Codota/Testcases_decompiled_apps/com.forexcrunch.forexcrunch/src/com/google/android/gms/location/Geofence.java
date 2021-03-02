package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.C0505bi;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {

        /* renamed from: fA */
        private float f1457fA;

        /* renamed from: fu */
        private String f1458fu = null;

        /* renamed from: fv */
        private int f1459fv = 0;

        /* renamed from: fw */
        private long f1460fw = Long.MIN_VALUE;

        /* renamed from: fx */
        private short f1461fx = -1;

        /* renamed from: fy */
        private double f1462fy;

        /* renamed from: fz */
        private double f1463fz;

        public Geofence build() {
            if (this.f1458fu == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.f1459fv == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if (this.f1460fw == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.f1461fx != -1) {
                return new C0505bi(this.f1458fu, this.f1459fv, 1, this.f1462fy, this.f1463fz, this.f1457fA, this.f1460fw);
            } else {
                throw new IllegalArgumentException("Geofence region not set.");
            }
        }

        public Builder setCircularRegion(double latitude, double longitude, float radius) {
            this.f1461fx = 1;
            this.f1462fy = latitude;
            this.f1463fz = longitude;
            this.f1457fA = radius;
            return this;
        }

        public Builder setExpirationDuration(long durationMillis) {
            if (durationMillis < 0) {
                this.f1460fw = -1;
            } else {
                this.f1460fw = SystemClock.elapsedRealtime() + durationMillis;
            }
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.f1458fu = requestId;
            return this;
        }

        public Builder setTransitionTypes(int transitionTypes) {
            this.f1459fv = transitionTypes;
            return this;
        }
    }

    String getRequestId();
}
