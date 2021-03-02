package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

public class DetectedActivity implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    public static final Comparator<DetectedActivity> adT = new Comparator<DetectedActivity>() {
        /* renamed from: a */
        public int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            int compareTo = Integer.valueOf(detectedActivity2.getConfidence()).compareTo(Integer.valueOf(detectedActivity.getConfidence()));
            return compareTo == 0 ? Integer.valueOf(detectedActivity.getType()).compareTo(Integer.valueOf(detectedActivity2.getType())) : compareTo;
        }
    };

    /* renamed from: BR */
    private final int f4415BR;
    int adU;
    int adV;

    public DetectedActivity(int activityType, int confidence) {
        this.f4415BR = 1;
        this.adU = activityType;
        this.adV = confidence;
    }

    public DetectedActivity(int versionCode, int activityType, int confidence) {
        this.f4415BR = versionCode;
        this.adU = activityType;
        this.adV = confidence;
    }

    /* renamed from: cw */
    private int m6236cw(int i) {
        if (i > 9) {
            return 4;
        }
        return i;
    }

    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.adV;
    }

    public int getType() {
        return m6236cw(this.adU);
    }

    public int getVersionCode() {
        return this.f4415BR;
    }

    public String toString() {
        return "DetectedActivity [type=" + getType() + ", confidence=" + this.adV + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        DetectedActivityCreator.m6238a(this, out, flags);
    }
}
