package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Locale;

public class ParcelableGeofence implements SafeParcelable {
    public static final C1141u CREATOR = new C1141u();

    /* renamed from: a */
    private final int f4957a;

    /* renamed from: b */
    private final String f4958b;

    /* renamed from: c */
    private final long f4959c;

    /* renamed from: d */
    private final short f4960d;

    /* renamed from: e */
    private final double f4961e;

    /* renamed from: f */
    private final double f4962f;

    /* renamed from: g */
    private final float f4963g;

    /* renamed from: h */
    private final int f4964h;

    /* renamed from: i */
    private final int f4965i;

    /* renamed from: j */
    private final int f4966j;

    public ParcelableGeofence(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        m4855a(str);
        m4854a(f);
        m4853a(d, d2);
        int a = m4852a(i2);
        this.f4957a = i;
        this.f4960d = s;
        this.f4958b = str;
        this.f4961e = d;
        this.f4962f = d2;
        this.f4963g = f;
        this.f4959c = j;
        this.f4964h = a;
        this.f4965i = i3;
        this.f4966j = i4;
    }

    /* renamed from: a */
    private static int m4852a(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    /* renamed from: a */
    private static void m4853a(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    /* renamed from: a */
    private static void m4854a(float f) {
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    /* renamed from: a */
    private static void m4855a(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    /* renamed from: b */
    private static String m4856b(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    /* renamed from: a */
    public int mo7821a() {
        return this.f4957a;
    }

    /* renamed from: b */
    public short mo7822b() {
        return this.f4960d;
    }

    /* renamed from: c */
    public double mo7823c() {
        return this.f4961e;
    }

    /* renamed from: d */
    public double mo7824d() {
        return this.f4962f;
    }

    public int describeContents() {
        C1141u uVar = CREATOR;
        return 0;
    }

    /* renamed from: e */
    public float mo7826e() {
        return this.f4963g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ParcelableGeofence)) {
            return false;
        }
        ParcelableGeofence parcelableGeofence = (ParcelableGeofence) obj;
        if (this.f4963g != parcelableGeofence.f4963g) {
            return false;
        }
        if (this.f4961e != parcelableGeofence.f4961e) {
            return false;
        }
        if (this.f4962f != parcelableGeofence.f4962f) {
            return false;
        }
        return this.f4960d == parcelableGeofence.f4960d;
    }

    /* renamed from: f */
    public String mo7828f() {
        return this.f4958b;
    }

    /* renamed from: g */
    public long mo7829g() {
        return this.f4959c;
    }

    /* renamed from: h */
    public int mo7830h() {
        return this.f4964h;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f4961e);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f4962f);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f4963g)) * 31) + this.f4960d) * 31) + this.f4964h;
    }

    /* renamed from: i */
    public int mo7832i() {
        return this.f4965i;
    }

    /* renamed from: j */
    public int mo7833j() {
        return this.f4966j;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{m4856b(this.f4960d), this.f4958b, Integer.valueOf(this.f4964h), Double.valueOf(this.f4961e), Double.valueOf(this.f4962f), Float.valueOf(this.f4963g), Integer.valueOf(this.f4965i / 1000), Integer.valueOf(this.f4966j), Long.valueOf(this.f4959c)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1141u uVar = CREATOR;
        C1141u.m4964a(this, parcel, i);
    }
}
