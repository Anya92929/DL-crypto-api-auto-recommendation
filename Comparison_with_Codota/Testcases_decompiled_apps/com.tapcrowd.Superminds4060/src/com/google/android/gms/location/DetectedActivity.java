package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DetectedActivity implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;

    /* renamed from: iM */
    private final int f1589iM;

    /* renamed from: oy */
    int f1590oy;

    /* renamed from: oz */
    int f1591oz;

    public DetectedActivity(int activityType, int confidence) {
        this.f1589iM = 1;
        this.f1590oy = activityType;
        this.f1591oz = confidence;
    }

    public DetectedActivity(int versionCode, int activityType, int confidence) {
        this.f1589iM = versionCode;
        this.f1590oy = activityType;
        this.f1591oz = confidence;
    }

    /* renamed from: W */
    private int m1966W(int i) {
        if (i > 6) {
            return 4;
        }
        return i;
    }

    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.f1591oz;
    }

    public int getType() {
        return m1966W(this.f1590oy);
    }

    public int getVersionCode() {
        return this.f1589iM;
    }

    public String toString() {
        return "DetectedActivity [type=" + getType() + ", confidence=" + this.f1591oz + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        DetectedActivityCreator.m1967a(this, out, flags);
    }
}
