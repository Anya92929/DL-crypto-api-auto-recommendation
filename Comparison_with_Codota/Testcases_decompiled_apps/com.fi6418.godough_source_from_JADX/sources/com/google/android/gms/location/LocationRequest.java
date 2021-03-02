package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.C1006bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class LocationRequest implements SafeParcelable {
    public static final C1118g CREATOR = new C1118g();

    /* renamed from: a */
    int f4895a;

    /* renamed from: b */
    long f4896b;

    /* renamed from: c */
    long f4897c;

    /* renamed from: d */
    boolean f4898d;

    /* renamed from: e */
    long f4899e;

    /* renamed from: f */
    int f4900f;

    /* renamed from: g */
    float f4901g;

    /* renamed from: h */
    long f4902h;

    /* renamed from: i */
    private final int f4903i;

    public LocationRequest() {
        this.f4903i = 1;
        this.f4895a = 102;
        this.f4896b = 3600000;
        this.f4897c = 600000;
        this.f4898d = false;
        this.f4899e = Long.MAX_VALUE;
        this.f4900f = Integer.MAX_VALUE;
        this.f4901g = BitmapDescriptorFactory.HUE_RED;
        this.f4902h = 0;
    }

    LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f, long j4) {
        this.f4903i = i;
        this.f4895a = i2;
        this.f4896b = j;
        this.f4897c = j2;
        this.f4898d = z;
        this.f4899e = j3;
        this.f4900f = i3;
        this.f4901g = f;
        this.f4902h = j4;
    }

    /* renamed from: a */
    public static String m4804a(int i) {
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

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7743a() {
        return this.f4903i;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.f4895a == locationRequest.f4895a && this.f4896b == locationRequest.f4896b && this.f4897c == locationRequest.f4897c && this.f4898d == locationRequest.f4898d && this.f4899e == locationRequest.f4899e && this.f4900f == locationRequest.f4900f && this.f4901g == locationRequest.f4901g;
    }

    public int hashCode() {
        return C1006bc.m4523a(Integer.valueOf(this.f4895a), Long.valueOf(this.f4896b), Long.valueOf(this.f4897c), Boolean.valueOf(this.f4898d), Long.valueOf(this.f4899e), Integer.valueOf(this.f4900f), Float.valueOf(this.f4901g));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(m4804a(this.f4895a));
        if (this.f4895a != 105) {
            sb.append(" requested=");
            sb.append(this.f4896b + "ms");
        }
        sb.append(" fastest=");
        sb.append(this.f4897c + "ms");
        if (this.f4902h > this.f4896b) {
            sb.append(" maxWait=");
            sb.append(this.f4902h + "ms");
        }
        if (this.f4899e != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append((this.f4899e - SystemClock.elapsedRealtime()) + "ms");
        }
        if (this.f4900f != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.f4900f);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1118g.m4839a(this, parcel, i);
    }
}
