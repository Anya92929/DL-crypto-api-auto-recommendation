package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

public class DetectedActivity implements SafeParcelable {
    public static final C1111c CREATOR = new C1111c();

    /* renamed from: a */
    public static final Comparator<DetectedActivity> f4877a = new C1110b();

    /* renamed from: b */
    int f4878b;

    /* renamed from: c */
    int f4879c;

    /* renamed from: d */
    private final int f4880d;

    public DetectedActivity(int i, int i2, int i3) {
        this.f4880d = i;
        this.f4878b = i2;
        this.f4879c = i3;
    }

    /* renamed from: a */
    public static String m4792a(int i) {
        switch (i) {
            case 0:
                return "IN_VEHICLE";
            case 1:
                return "ON_BICYCLE";
            case 2:
                return "ON_FOOT";
            case 3:
                return "STILL";
            case 4:
                return "UNKNOWN";
            case 5:
                return "TILTING";
            case 7:
                return "WALKING";
            case 8:
                return "RUNNING";
            default:
                return Integer.toString(i);
        }
    }

    /* renamed from: b */
    private int m4793b(int i) {
        if (i > 15) {
            return 4;
        }
        return i;
    }

    /* renamed from: a */
    public int mo7719a() {
        return m4793b(this.f4878b);
    }

    /* renamed from: b */
    public int mo7720b() {
        return this.f4879c;
    }

    /* renamed from: c */
    public int mo7721c() {
        return this.f4880d;
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
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        return this.f4878b == detectedActivity.f4878b && this.f4879c == detectedActivity.f4879c;
    }

    public int hashCode() {
        return C1006bc.m4523a(Integer.valueOf(this.f4878b), Integer.valueOf(this.f4879c));
    }

    public String toString() {
        return "DetectedActivity [type=" + m4792a(mo7719a()) + ", confidence=" + this.f4879c + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1111c.m4828a(this, parcel, i);
    }
}
