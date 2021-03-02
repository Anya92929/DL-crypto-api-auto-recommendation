package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    int mPriority;
    private final int mVersionCode;
    boolean zzaBr;
    long zzaND;
    long zzaNY;
    long zzaNZ;
    int zzaOa;
    float zzaOb;
    long zzaOc;

    public LocationRequest() {
        this.mVersionCode = 1;
        this.mPriority = PRIORITY_BALANCED_POWER_ACCURACY;
        this.zzaNY = 3600000;
        this.zzaNZ = 600000;
        this.zzaBr = false;
        this.zzaND = Long.MAX_VALUE;
        this.zzaOa = Integer.MAX_VALUE;
        this.zzaOb = 0.0f;
        this.zzaOc = 0;
    }

    LocationRequest(int versionCode, int priority, long interval, long fastestInterval, boolean explicitFastestInterval, long expireAt, int numUpdates, float smallestDisplacement, long maxWaitTime) {
        this.mVersionCode = versionCode;
        this.mPriority = priority;
        this.zzaNY = interval;
        this.zzaNZ = fastestInterval;
        this.zzaBr = explicitFastestInterval;
        this.zzaND = expireAt;
        this.zzaOa = numUpdates;
        this.zzaOb = smallestDisplacement;
        this.zzaOc = maxWaitTime;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zzL(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    private static void zzd(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    private static void zzhs(int i) {
        switch (i) {
            case 100:
            case PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
            case 104:
            case 105:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String zzht(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case 104:
                return "PRIORITY_LOW_POWER";
            case 105:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
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
        return this.mPriority == locationRequest.mPriority && this.zzaNY == locationRequest.zzaNY && this.zzaNZ == locationRequest.zzaNZ && this.zzaBr == locationRequest.zzaBr && this.zzaND == locationRequest.zzaND && this.zzaOa == locationRequest.zzaOa && this.zzaOb == locationRequest.zzaOb;
    }

    public long getExpirationTime() {
        return this.zzaND;
    }

    public long getFastestInterval() {
        return this.zzaNZ;
    }

    public long getInterval() {
        return this.zzaNY;
    }

    public long getMaxWaitTime() {
        long j = this.zzaOc;
        return j < this.zzaNY ? this.zzaNY : j;
    }

    public int getNumUpdates() {
        return this.zzaOa;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.zzaOb;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.zzaNY), Long.valueOf(this.zzaNZ), Boolean.valueOf(this.zzaBr), Long.valueOf(this.zzaND), Integer.valueOf(this.zzaOa), Float.valueOf(this.zzaOb));
    }

    public LocationRequest setExpirationDuration(long millis) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (millis > Long.MAX_VALUE - elapsedRealtime) {
            this.zzaND = Long.MAX_VALUE;
        } else {
            this.zzaND = elapsedRealtime + millis;
        }
        if (this.zzaND < 0) {
            this.zzaND = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        this.zzaND = millis;
        if (this.zzaND < 0) {
            this.zzaND = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long millis) {
        zzL(millis);
        this.zzaBr = true;
        this.zzaNZ = millis;
        return this;
    }

    public LocationRequest setInterval(long millis) {
        zzL(millis);
        this.zzaNY = millis;
        if (!this.zzaBr) {
            this.zzaNZ = (long) (((double) this.zzaNY) / 6.0d);
        }
        return this;
    }

    public LocationRequest setMaxWaitTime(long millis) {
        zzL(millis);
        this.zzaOc = millis;
        return this;
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        if (numUpdates <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + numUpdates);
        }
        this.zzaOa = numUpdates;
        return this;
    }

    public LocationRequest setPriority(int priority) {
        zzhs(priority);
        this.mPriority = priority;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        zzd(smallestDisplacementMeters);
        this.zzaOb = smallestDisplacementMeters;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(zzht(this.mPriority));
        if (this.mPriority != 105) {
            sb.append(" requested=");
            sb.append(this.zzaNY).append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzaNZ).append("ms");
        if (this.zzaOc > this.zzaNY) {
            sb.append(" maxWait=");
            sb.append(this.zzaOc).append("ms");
        }
        if (this.zzaND != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append(this.zzaND - SystemClock.elapsedRealtime()).append("ms");
        }
        if (this.zzaOa != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.zzaOa);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        LocationRequestCreator.zza(this, parcel, flags);
    }
}
