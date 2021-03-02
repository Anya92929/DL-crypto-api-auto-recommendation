package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final C1109a CREATOR = new C1109a();

    /* renamed from: a */
    List<DetectedActivity> f4872a;

    /* renamed from: b */
    long f4873b;

    /* renamed from: c */
    long f4874c;

    /* renamed from: d */
    int f4875d;

    /* renamed from: e */
    private final int f4876e;

    public ActivityRecognitionResult(int i, List<DetectedActivity> list, long j, long j2, int i2) {
        this.f4876e = i;
        this.f4872a = list;
        this.f4873b = j;
        this.f4874c = j2;
        this.f4875d = i2;
    }

    /* renamed from: a */
    public int mo7713a() {
        return this.f4876e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
        return this.f4873b == activityRecognitionResult.f4873b && this.f4874c == activityRecognitionResult.f4874c && this.f4875d == activityRecognitionResult.f4875d && C1006bc.m4525a(this.f4872a, activityRecognitionResult.f4872a);
    }

    public int hashCode() {
        return C1006bc.m4523a(Long.valueOf(this.f4873b), Long.valueOf(this.f4874c), Integer.valueOf(this.f4875d), this.f4872a);
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.f4872a + ", timeMillis=" + this.f4873b + ", elapsedRealtimeMillis=" + this.f4874c + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1109a.m4824a(this, parcel, i);
    }
}
