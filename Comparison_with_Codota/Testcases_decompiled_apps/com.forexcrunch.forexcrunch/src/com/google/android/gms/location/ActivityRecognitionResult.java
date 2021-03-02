package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0621s;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";

    /* renamed from: ab */
    private final int f1450ab;

    /* renamed from: fp */
    List<DetectedActivity> f1451fp;

    /* renamed from: fq */
    long f1452fq;

    /* renamed from: fr */
    long f1453fr;

    public ActivityRecognitionResult(int versionCode, List<DetectedActivity> probableActivities, long timeMillis, long elapsedRealtimeMillis) {
        this.f1450ab = 1;
        this.f1451fp = probableActivities;
        this.f1452fq = timeMillis;
        this.f1453fr = elapsedRealtimeMillis;
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis) {
        this((List<DetectedActivity>) Collections.singletonList(mostProbableActivity), time, elapsedRealtimeMillis);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis) {
        C0621s.m1888b(probableActivities != null && probableActivities.size() > 0, (Object) "Must have at least 1 detected activity");
        this.f1450ab = 1;
        this.f1451fp = probableActivities;
        this.f1452fq = time;
        this.f1453fr = elapsedRealtimeMillis;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        return (ActivityRecognitionResult) intent.getExtras().get(EXTRA_ACTIVITY_RESULT);
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra(EXTRA_ACTIVITY_RESULT);
    }

    public int describeContents() {
        return 0;
    }

    public int getActivityConfidence(int activityType) {
        for (DetectedActivity next : this.f1451fp) {
            if (next.getType() == activityType) {
                return next.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.f1453fr;
    }

    public DetectedActivity getMostProbableActivity() {
        return this.f1451fp.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.f1451fp;
    }

    public long getTime() {
        return this.f1452fq;
    }

    /* renamed from: i */
    public int mo5528i() {
        return this.f1450ab;
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.f1451fp + ", timeMillis=" + this.f1452fq + ", elapsedRealtimeMillis=" + this.f1453fr + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        ActivityRecognitionResultCreator.m1917a(this, out, flags);
    }
}
