package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0618r;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;

    /* renamed from: ab */
    private final int f1465ab;

    /* renamed from: fB */
    long f1466fB;

    /* renamed from: fC */
    long f1467fC;

    /* renamed from: fD */
    boolean f1468fD;

    /* renamed from: fE */
    int f1469fE;

    /* renamed from: fF */
    float f1470fF;

    /* renamed from: fw */
    long f1471fw;
    int mPriority;

    public LocationRequest() {
        this.f1465ab = 1;
        this.mPriority = 102;
        this.f1466fB = 3600000;
        this.f1467fC = 600000;
        this.f1468fD = false;
        this.f1471fw = Long.MAX_VALUE;
        this.f1469fE = Integer.MAX_VALUE;
        this.f1470fF = BitmapDescriptorFactory.HUE_RED;
    }

    LocationRequest(int versionCode, int priority, long interval, long fastestInterval, boolean explicitFastestInterval, long expireAt, int numUpdates, float smallestDisplacement) {
        this.f1465ab = versionCode;
        this.mPriority = priority;
        this.f1466fB = interval;
        this.f1467fC = fastestInterval;
        this.f1468fD = explicitFastestInterval;
        this.f1471fw = expireAt;
        this.f1469fE = numUpdates;
        this.f1470fF = smallestDisplacement;
    }

    /* renamed from: M */
    private static void m1921M(int i) {
        switch (i) {
            case 100:
            case 102:
            case 104:
            case 105:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    /* renamed from: N */
    public static String m1922N(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case 104:
                return "PRIORITY_LOW_POWER";
            case 105:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    /* renamed from: a */
    private static void m1923a(float f) {
        if (f < BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    /* renamed from: c */
    private static void m1924c(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    public static LocationRequest create() {
        return new LocationRequest();
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
        return this.mPriority == locationRequest.mPriority && this.f1466fB == locationRequest.f1466fB && this.f1467fC == locationRequest.f1467fC && this.f1468fD == locationRequest.f1468fD && this.f1471fw == locationRequest.f1471fw && this.f1469fE == locationRequest.f1469fE && this.f1470fF == locationRequest.f1470fF;
    }

    public long getExpirationTime() {
        return this.f1471fw;
    }

    public long getFastestInterval() {
        return this.f1467fC;
    }

    public long getInterval() {
        return this.f1466fB;
    }

    public int getNumUpdates() {
        return this.f1469fE;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.f1470fF;
    }

    public int hashCode() {
        return C0618r.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.f1466fB), Long.valueOf(this.f1467fC), Boolean.valueOf(this.f1468fD), Long.valueOf(this.f1471fw), Integer.valueOf(this.f1469fE), Float.valueOf(this.f1470fF));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int mo5570i() {
        return this.f1465ab;
    }

    public LocationRequest setExpirationDuration(long millis) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (millis > Long.MAX_VALUE - elapsedRealtime) {
            this.f1471fw = Long.MAX_VALUE;
        } else {
            this.f1471fw = elapsedRealtime + millis;
        }
        if (this.f1471fw < 0) {
            this.f1471fw = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        this.f1471fw = millis;
        if (this.f1471fw < 0) {
            this.f1471fw = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long millis) {
        m1924c(millis);
        this.f1468fD = true;
        this.f1467fC = millis;
        return this;
    }

    public LocationRequest setInterval(long millis) {
        m1924c(millis);
        this.f1466fB = millis;
        if (!this.f1468fD) {
            this.f1467fC = (long) (((double) this.f1466fB) / 6.0d);
        }
        return this;
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        if (numUpdates <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + numUpdates);
        }
        this.f1469fE = numUpdates;
        return this;
    }

    public LocationRequest setPriority(int priority) {
        m1921M(priority);
        this.mPriority = priority;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        m1923a(smallestDisplacementMeters);
        this.f1470fF = smallestDisplacementMeters;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(m1922N(this.mPriority));
        if (this.mPriority != 105) {
            sb.append(" requested=");
            sb.append(this.f1466fB + "ms");
        }
        sb.append(" fastest=");
        sb.append(this.f1467fC + "ms");
        if (this.f1471fw != Long.MAX_VALUE) {
            long elapsedRealtime = this.f1471fw - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(elapsedRealtime + "ms");
        }
        if (this.f1469fE != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.f1469fE);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        LocationRequestCreator.m1926a(this, parcel, flags);
    }
}
