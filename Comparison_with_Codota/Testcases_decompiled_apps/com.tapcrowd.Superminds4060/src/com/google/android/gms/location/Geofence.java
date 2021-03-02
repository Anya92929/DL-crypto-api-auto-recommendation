package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.C0520fa;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {

        /* renamed from: oA */
        private String f1592oA = null;

        /* renamed from: oB */
        private int f1593oB = 0;

        /* renamed from: oC */
        private long f1594oC = Long.MIN_VALUE;

        /* renamed from: oD */
        private short f1595oD = -1;

        /* renamed from: oE */
        private double f1596oE;

        /* renamed from: oF */
        private double f1597oF;

        /* renamed from: oG */
        private float f1598oG;

        /* renamed from: oH */
        private int f1599oH = 0;

        /* renamed from: oI */
        private int f1600oI = -1;

        public Geofence build() {
            if (this.f1592oA == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.f1593oB == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.f1593oB & 4) != 0 && this.f1600oI < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.f1594oC == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.f1595oD == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.f1599oH >= 0) {
                return new C0520fa(this.f1592oA, this.f1593oB, 1, this.f1596oE, this.f1597oF, this.f1598oG, this.f1594oC, this.f1599oH, this.f1600oI);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public Builder setCircularRegion(double latitude, double longitude, float radius) {
            this.f1595oD = 1;
            this.f1596oE = latitude;
            this.f1597oF = longitude;
            this.f1598oG = radius;
            return this;
        }

        public Builder setExpirationDuration(long durationMillis) {
            if (durationMillis < 0) {
                this.f1594oC = -1;
            } else {
                this.f1594oC = SystemClock.elapsedRealtime() + durationMillis;
            }
            return this;
        }

        public Builder setLoiteringDelay(int loiteringDelayMs) {
            this.f1600oI = loiteringDelayMs;
            return this;
        }

        public Builder setNotificationResponsiveness(int notificationResponsivenessMs) {
            this.f1599oH = notificationResponsivenessMs;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.f1592oA = requestId;
            return this;
        }

        public Builder setTransitionTypes(int transitionTypes) {
            this.f1593oB = transitionTypes;
            return this;
        }
    }

    String getRequestId();
}
