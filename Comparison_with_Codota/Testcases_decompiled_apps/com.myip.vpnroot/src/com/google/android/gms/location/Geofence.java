package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.C1553mb;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {

        /* renamed from: Xr */
        private String f4416Xr = null;
        private int adW = 0;
        private long adX = Long.MIN_VALUE;
        private short adY = -1;
        private double adZ;
        private double aea;
        private float aeb;
        private int aec = 0;
        private int aed = -1;

        public Geofence build() {
            if (this.f4416Xr == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.adW == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.adW & 4) != 0 && this.aed < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.adX == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.adY == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.aec >= 0) {
                return new C1553mb(this.f4416Xr, this.adW, 1, this.adZ, this.aea, this.aeb, this.adX, this.aec, this.aed);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public Builder setCircularRegion(double latitude, double longitude, float radius) {
            this.adY = 1;
            this.adZ = latitude;
            this.aea = longitude;
            this.aeb = radius;
            return this;
        }

        public Builder setExpirationDuration(long durationMillis) {
            if (durationMillis < 0) {
                this.adX = -1;
            } else {
                this.adX = SystemClock.elapsedRealtime() + durationMillis;
            }
            return this;
        }

        public Builder setLoiteringDelay(int loiteringDelayMs) {
            this.aed = loiteringDelayMs;
            return this;
        }

        public Builder setNotificationResponsiveness(int notificationResponsivenessMs) {
            this.aec = notificationResponsivenessMs;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.f4416Xr = requestId;
            return this;
        }

        public Builder setTransitionTypes(int transitionTypes) {
            this.adW = transitionTypes;
            return this;
        }
    }

    String getRequestId();
}
