package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.mb */
public class C1553mb implements SafeParcelable, Geofence {
    public static final C1554mc CREATOR = new C1554mc();

    /* renamed from: BR */
    private final int f4280BR;

    /* renamed from: Xr */
    private final String f4281Xr;
    private final int adW;
    private final short adY;
    private final double adZ;
    private final double aea;
    private final float aeb;
    private final int aec;
    private final int aed;
    private final long afb;

    public C1553mb(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        m5585bV(str);
        m5584b(f);
        m5583a(d, d2);
        int ej = m5586ej(i2);
        this.f4280BR = i;
        this.adY = s;
        this.f4281Xr = str;
        this.adZ = d;
        this.aea = d2;
        this.aeb = f;
        this.afb = j;
        this.adW = ej;
        this.aec = i3;
        this.aed = i4;
    }

    public C1553mb(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        this(1, str, i, s, d, d2, f, j, i2, i3);
    }

    /* renamed from: a */
    private static void m5583a(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    /* renamed from: b */
    private static void m5584b(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    /* renamed from: bV */
    private static void m5585bV(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    /* renamed from: ej */
    private static int m5586ej(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    /* renamed from: ek */
    private static String m5587ek(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    /* renamed from: h */
    public static C1553mb m5588h(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        C1553mb cw = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return cw;
    }

    public int describeContents() {
        C1554mc mcVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof C1553mb)) {
            return false;
        }
        C1553mb mbVar = (C1553mb) obj;
        if (this.aeb != mbVar.aeb) {
            return false;
        }
        if (this.adZ != mbVar.adZ) {
            return false;
        }
        if (this.aea != mbVar.aea) {
            return false;
        }
        return this.adY == mbVar.adY;
    }

    public long getExpirationTime() {
        return this.afb;
    }

    public double getLatitude() {
        return this.adZ;
    }

    public double getLongitude() {
        return this.aea;
    }

    public int getNotificationResponsiveness() {
        return this.aec;
    }

    public String getRequestId() {
        return this.f4281Xr;
    }

    public int getVersionCode() {
        return this.f4280BR;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.adZ);
        long doubleToLongBits2 = Double.doubleToLongBits(this.aea);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.aeb)) * 31) + this.adY) * 31) + this.adW;
    }

    /* renamed from: lY */
    public short mo9372lY() {
        return this.adY;
    }

    /* renamed from: lZ */
    public float mo9373lZ() {
        return this.aeb;
    }

    /* renamed from: ma */
    public int mo9374ma() {
        return this.adW;
    }

    /* renamed from: mb */
    public int mo9375mb() {
        return this.aed;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{m5587ek(this.adY), this.f4281Xr, Integer.valueOf(this.adW), Double.valueOf(this.adZ), Double.valueOf(this.aea), Float.valueOf(this.aeb), Integer.valueOf(this.aec / 1000), Integer.valueOf(this.aed), Long.valueOf(this.afb)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1554mc mcVar = CREATOR;
        C1554mc.m5593a(this, parcel, flags);
    }
}
