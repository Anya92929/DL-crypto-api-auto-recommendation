package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0411dm;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";

    /* renamed from: iM */
    private final int f1585iM;

    /* renamed from: ov */
    List<DetectedActivity> f1586ov;

    /* renamed from: ow */
    long f1587ow;

    /* renamed from: ox */
    long f1588ox;

    public ActivityRecognitionResult(int versionCode, List<DetectedActivity> probableActivities, long timeMillis, long elapsedRealtimeMillis) {
        this.f1585iM = 1;
        this.f1586ov = probableActivities;
        this.f1587ow = timeMillis;
        this.f1588ox = elapsedRealtimeMillis;
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis) {
        this((List<DetectedActivity>) Collections.singletonList(mostProbableActivity), time, elapsedRealtimeMillis);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis) {
        C0411dm.m943b(probableActivities != null && probableActivities.size() > 0, "Must have at least 1 detected activity");
        this.f1585iM = 1;
        this.f1586ov = probableActivities;
        this.f1587ow = time;
        this.f1588ox = elapsedRealtimeMillis;
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
        for (DetectedActivity next : this.f1586ov) {
            if (next.getType() == activityType) {
                return next.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.f1588ox;
    }

    public DetectedActivity getMostProbableActivity() {
        return this.f1586ov.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.f1586ov;
    }

    public long getTime() {
        return this.f1587ow;
    }

    public int getVersionCode() {
        return this.f1585iM;
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.f1586ov + ", timeMillis=" + this.f1587ow + ", elapsedRealtimeMillis=" + this.f1588ox + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        ActivityRecognitionResultCreator.m1965a(this, out, flags);
    }
}
