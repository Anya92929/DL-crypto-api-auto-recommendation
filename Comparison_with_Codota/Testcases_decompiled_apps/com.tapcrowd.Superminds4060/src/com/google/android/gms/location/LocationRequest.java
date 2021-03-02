package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.actionbarsherlock.widget.ActivityChooserView;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;

    /* renamed from: iM */
    private final int f1602iM;
    int mPriority;

    /* renamed from: oC */
    long f1603oC;

    /* renamed from: oJ */
    long f1604oJ;

    /* renamed from: oK */
    long f1605oK;

    /* renamed from: oL */
    boolean f1606oL;

    /* renamed from: oM */
    int f1607oM;

    /* renamed from: oN */
    float f1608oN;

    public LocationRequest() {
        this.f1602iM = 1;
        this.mPriority = PRIORITY_BALANCED_POWER_ACCURACY;
        this.f1604oJ = 3600000;
        this.f1605oK = 600000;
        this.f1606oL = false;
        this.f1603oC = Long.MAX_VALUE;
        this.f1607oM = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f1608oN = BitmapDescriptorFactory.HUE_RED;
    }

    LocationRequest(int versionCode, int priority, long interval, long fastestInterval, boolean explicitFastestInterval, long expireAt, int numUpdates, float smallestDisplacement) {
        this.f1602iM = versionCode;
        this.mPriority = priority;
        this.f1604oJ = interval;
        this.f1605oK = fastestInterval;
        this.f1606oL = explicitFastestInterval;
        this.f1603oC = expireAt;
        this.f1607oM = numUpdates;
        this.f1608oN = smallestDisplacement;
    }

    /* renamed from: X */
    private static void m1968X(int i) {
        switch (i) {
            case 100:
            case PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
            case PRIORITY_LOW_POWER /*104*/:
            case PRIORITY_NO_POWER /*105*/:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    /* renamed from: Y */
    public static String m1969Y(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case PRIORITY_LOW_POWER /*104*/:
                return "PRIORITY_LOW_POWER";
            case PRIORITY_NO_POWER /*105*/:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    /* renamed from: a */
    private static void m1970a(float f) {
        if (f < BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    /* renamed from: h */
    private static void m1971h(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) object;
        return this.mPriority == locationRequest.mPriority && this.f1604oJ == locationRequest.f1604oJ && this.f1605oK == locationRequest.f1605oK && this.f1606oL == locationRequest.f1606oL && this.f1603oC == locationRequest.f1603oC && this.f1607oM == locationRequest.f1607oM && this.f1608oN == locationRequest.f1608oN;
    }

    public long getExpirationTime() {
        return this.f1603oC;
    }

    public long getFastestInterval() {
        return this.f1605oK;
    }

    public long getInterval() {
        return this.f1604oJ;
    }

    public int getNumUpdates() {
        return this.f1607oM;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.f1608oN;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1602iM;
    }

    public int hashCode() {
        return C0408dl.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.f1604oJ), Long.valueOf(this.f1605oK), Boolean.valueOf(this.f1606oL), Long.valueOf(this.f1603oC), Integer.valueOf(this.f1607oM), Float.valueOf(this.f1608oN));
    }

    public LocationRequest setExpirationDuration(long millis) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (millis > Long.MAX_VALUE - elapsedRealtime) {
            this.f1603oC = Long.MAX_VALUE;
        } else {
            this.f1603oC = elapsedRealtime + millis;
        }
        if (this.f1603oC < 0) {
            this.f1603oC = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        this.f1603oC = millis;
        if (this.f1603oC < 0) {
            this.f1603oC = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long millis) {
        m1971h(millis);
        this.f1606oL = true;
        this.f1605oK = millis;
        return this;
    }

    public LocationRequest setInterval(long millis) {
        m1971h(millis);
        this.f1604oJ = millis;
        if (!this.f1606oL) {
            this.f1605oK = (long) (((double) this.f1604oJ) / 6.0d);
        }
        return this;
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        if (numUpdates <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + numUpdates);
        }
        this.f1607oM = numUpdates;
        return this;
    }

    public LocationRequest setPriority(int priority) {
        m1968X(priority);
        this.mPriority = priority;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        m1970a(smallestDisplacementMeters);
        this.f1608oN = smallestDisplacementMeters;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(m1969Y(this.mPriority));
        if (this.mPriority != 105) {
            sb.append(" requested=");
            sb.append(this.f1604oJ + "ms");
        }
        sb.append(" fastest=");
        sb.append(this.f1605oK + "ms");
        if (this.f1603oC != Long.MAX_VALUE) {
            long elapsedRealtime = this.f1603oC - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(elapsedRealtime + "ms");
        }
        if (this.f1607oM != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.f1607oM);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        LocationRequestCreator.m1972a(this, parcel, flags);
    }
}
