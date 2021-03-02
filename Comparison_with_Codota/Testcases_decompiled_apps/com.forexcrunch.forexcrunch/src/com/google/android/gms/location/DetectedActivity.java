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

    /* renamed from: ab */
    private final int f1454ab;

    /* renamed from: fs */
    int f1455fs;

    /* renamed from: ft */
    int f1456ft;

    public DetectedActivity(int activityType, int confidence) {
        this.f1454ab = 1;
        this.f1455fs = activityType;
        this.f1456ft = confidence;
    }

    public DetectedActivity(int versionCode, int activityType, int confidence) {
        this.f1454ab = versionCode;
        this.f1455fs = activityType;
        this.f1456ft = confidence;
    }

    /* renamed from: L */
    private int m1918L(int i) {
        if (i > 5) {
            return 4;
        }
        return i;
    }

    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.f1456ft;
    }

    public int getType() {
        return m1918L(this.f1455fs);
    }

    /* renamed from: i */
    public int mo5536i() {
        return this.f1454ab;
    }

    public String toString() {
        return "DetectedActivity [type=" + getType() + ", confidence=" + this.f1456ft + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        DetectedActivityCreator.m1920a(this, out, flags);
    }
}
