package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";

    /* renamed from: BR */
    private final int f4414BR;
    List<DetectedActivity> adQ;
    long adR;
    long adS;

    public ActivityRecognitionResult(int versionCode, List<DetectedActivity> probableActivities, long timeMillis, long elapsedRealtimeMillis) {
        this.f4414BR = 1;
        this.adQ = probableActivities;
        this.adR = timeMillis;
        this.adS = elapsedRealtimeMillis;
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis) {
        this((List<DetectedActivity>) Collections.singletonList(mostProbableActivity), time, elapsedRealtimeMillis);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis) {
        boolean z = false;
        C0348n.m859b(probableActivities != null && probableActivities.size() > 0, (Object) "Must have at least 1 detected activity");
        if (time > 0 && elapsedRealtimeMillis > 0) {
            z = true;
        }
        C0348n.m859b(z, (Object) "Must set times");
        this.f4414BR = 1;
        this.adQ = probableActivities;
        this.adR = time;
        this.adS = elapsedRealtimeMillis;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        Object obj = intent.getExtras().get(EXTRA_ACTIVITY_RESULT);
        if (obj instanceof byte[]) {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall((byte[]) obj, 0, ((byte[]) obj).length);
            obtain.setDataPosition(0);
            return CREATOR.createFromParcel(obtain);
        } else if (obj instanceof ActivityRecognitionResult) {
            return (ActivityRecognitionResult) obj;
        } else {
            return null;
        }
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
        for (DetectedActivity next : this.adQ) {
            if (next.getType() == activityType) {
                return next.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.adS;
    }

    public DetectedActivity getMostProbableActivity() {
        return this.adQ.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.adQ;
    }

    public long getTime() {
        return this.adR;
    }

    public int getVersionCode() {
        return this.f4414BR;
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.adQ + ", timeMillis=" + this.adR + ", elapsedRealtimeMillis=" + this.adS + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        ActivityRecognitionResultCreator.m6235a(this, out, flags);
    }
}
