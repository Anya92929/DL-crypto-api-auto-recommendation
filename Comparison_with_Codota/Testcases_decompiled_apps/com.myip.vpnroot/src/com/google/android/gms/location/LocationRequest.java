package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import android.support.p003v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationRequest implements SafeParcelable {
    public static final C1756b CREATOR = new C1756b();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;

    /* renamed from: BR */
    private final int f4418BR;

    /* renamed from: Uz */
    boolean f4419Uz;
    long adX;
    long aeh;
    long aei;
    int aej;
    float aek;
    long ael;
    int mPriority;

    public LocationRequest() {
        this.f4418BR = 1;
        this.mPriority = 102;
        this.aeh = 3600000;
        this.aei = 600000;
        this.f4419Uz = false;
        this.adX = Long.MAX_VALUE;
        this.aej = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.aek = 0.0f;
        this.ael = 0;
    }

    LocationRequest(int versionCode, int priority, long interval, long fastestInterval, boolean explicitFastestInterval, long expireAt, int numUpdates, float smallestDisplacement, long maxWaitTime) {
        this.f4418BR = versionCode;
        this.mPriority = priority;
        this.aeh = interval;
        this.aei = fastestInterval;
        this.f4419Uz = explicitFastestInterval;
        this.adX = expireAt;
        this.aej = numUpdates;
        this.aek = smallestDisplacement;
        this.ael = maxWaitTime;
    }

    /* renamed from: a */
    private static void m6239a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    /* renamed from: ea */
    private static void m6240ea(int i) {
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

    /* renamed from: eb */
    public static String m6241eb(int i) {
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

    /* renamed from: v */
    private static void m6242v(long j) {
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
        return this.mPriority == locationRequest.mPriority && this.aeh == locationRequest.aeh && this.aei == locationRequest.aei && this.f4419Uz == locationRequest.f4419Uz && this.adX == locationRequest.adX && this.aej == locationRequest.aej && this.aek == locationRequest.aek;
    }

    public long getExpirationTime() {
        return this.adX;
    }

    public long getFastestInterval() {
        return this.aei;
    }

    public long getInterval() {
        return this.aeh;
    }

    public int getNumUpdates() {
        return this.aej;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.aek;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4418BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.aeh), Long.valueOf(this.aei), Boolean.valueOf(this.f4419Uz), Long.valueOf(this.adX), Integer.valueOf(this.aej), Float.valueOf(this.aek));
    }

    public LocationRequest setExpirationDuration(long millis) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (millis > Long.MAX_VALUE - elapsedRealtime) {
            this.adX = Long.MAX_VALUE;
        } else {
            this.adX = elapsedRealtime + millis;
        }
        if (this.adX < 0) {
            this.adX = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        this.adX = millis;
        if (this.adX < 0) {
            this.adX = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long millis) {
        m6242v(millis);
        this.f4419Uz = true;
        this.aei = millis;
        return this;
    }

    public LocationRequest setInterval(long millis) {
        m6242v(millis);
        this.aeh = millis;
        if (!this.f4419Uz) {
            this.aei = (long) (((double) this.aeh) / 6.0d);
        }
        return this;
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        if (numUpdates <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + numUpdates);
        }
        this.aej = numUpdates;
        return this;
    }

    public LocationRequest setPriority(int priority) {
        m6240ea(priority);
        this.mPriority = priority;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        m6239a(smallestDisplacementMeters);
        this.aek = smallestDisplacementMeters;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(m6241eb(this.mPriority));
        if (this.mPriority != 105) {
            sb.append(" requested=");
            sb.append(this.aeh + "ms");
        }
        sb.append(" fastest=");
        sb.append(this.aei + "ms");
        if (this.adX != Long.MAX_VALUE) {
            long elapsedRealtime = this.adX - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(elapsedRealtime + "ms");
        }
        if (this.aej != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.aej);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1756b.m6250a(this, parcel, flags);
    }
}
