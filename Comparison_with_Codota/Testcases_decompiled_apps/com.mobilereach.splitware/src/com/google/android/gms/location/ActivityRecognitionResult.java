package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    Bundle extras;
    private final int mVersionCode;
    List<DetectedActivity> zzaNu;
    long zzaNv;
    long zzaNw;
    int zzaNx;

    public ActivityRecognitionResult(int versionCode, List<DetectedActivity> probableActivities, long timeMillis, long elapsedRealtimeMillis, int detectorInfoId, Bundle extras2) {
        this.mVersionCode = versionCode;
        this.zzaNu = probableActivities;
        this.zzaNv = timeMillis;
        this.zzaNw = elapsedRealtimeMillis;
        this.zzaNx = detectorInfoId;
        this.extras = extras2;
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis) {
        this(mostProbableActivity, time, elapsedRealtimeMillis, 0, (Bundle) null);
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis, int detectorInfoId, Bundle extra) {
        this((List<DetectedActivity>) Collections.singletonList(mostProbableActivity), time, elapsedRealtimeMillis, detectorInfoId, extra);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis) {
        this(probableActivities, time, elapsedRealtimeMillis, 0, (Bundle) null);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis, int detectorInfoId, Bundle extras2) {
        boolean z = true;
        zzx.zzb(probableActivities != null && probableActivities.size() > 0, (Object) "Must have at least 1 detected activity");
        zzx.zzb((time <= 0 || elapsedRealtimeMillis <= 0) ? false : z, (Object) "Must set times");
        this.mVersionCode = 2;
        this.zzaNu = probableActivities;
        this.zzaNv = time;
        this.zzaNw = elapsedRealtimeMillis;
        this.zzaNx = detectorInfoId;
        this.extras = extras2;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        Object obj = intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
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
        return intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    }

    private static boolean zzc(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle == null && bundle2 != null) || (bundle != null && bundle2 == null)) {
            return false;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!zzc(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) o;
        return this.zzaNv == activityRecognitionResult.zzaNv && this.zzaNw == activityRecognitionResult.zzaNw && this.zzaNx == activityRecognitionResult.zzaNx && zzw.equal(this.zzaNu, activityRecognitionResult.zzaNu) && zzc(this.extras, activityRecognitionResult.extras);
    }

    public int getActivityConfidence(int activityType) {
        for (DetectedActivity next : this.zzaNu) {
            if (next.getType() == activityType) {
                return next.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.zzaNw;
    }

    public DetectedActivity getMostProbableActivity() {
        return this.zzaNu.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.zzaNu;
    }

    public long getTime() {
        return this.zzaNv;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzaNv), Long.valueOf(this.zzaNw), Integer.valueOf(this.zzaNx), this.zzaNu, this.extras);
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.zzaNu + ", timeMillis=" + this.zzaNv + ", elapsedRealtimeMillis=" + this.zzaNw + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        ActivityRecognitionResultCreator.zza(this, out, flags);
    }
}
