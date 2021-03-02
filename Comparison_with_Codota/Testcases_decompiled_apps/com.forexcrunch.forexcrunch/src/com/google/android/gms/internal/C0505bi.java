package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: com.google.android.gms.internal.bi */
public class C0505bi implements SafeParcelable, Geofence {
    public static final C0506bj CREATOR = new C0506bj();

    /* renamed from: ab */
    private final int f1130ab;

    /* renamed from: fA */
    private final float f1131fA;

    /* renamed from: fU */
    private final long f1132fU;

    /* renamed from: fu */
    private final String f1133fu;

    /* renamed from: fv */
    private final int f1134fv;

    /* renamed from: fx */
    private final short f1135fx;

    /* renamed from: fy */
    private final double f1136fy;

    /* renamed from: fz */
    private final double f1137fz;

    public C0505bi(int i, String str, int i2, short s, double d, double d2, float f, long j) {
        m1348A(str);
        m1352b(f);
        m1351a(d, d2);
        int P = m1349P(i2);
        this.f1130ab = i;
        this.f1135fx = s;
        this.f1133fu = str;
        this.f1136fy = d;
        this.f1137fz = d2;
        this.f1131fA = f;
        this.f1132fU = j;
        this.f1134fv = P;
    }

    public C0505bi(String str, int i, short s, double d, double d2, float f, long j) {
        this(1, str, i, s, d, d2, f, j);
    }

    /* renamed from: A */
    private static void m1348A(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    /* renamed from: P */
    private static int m1349P(int i) {
        int i2 = i & 3;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    /* renamed from: Q */
    private static String m1350Q(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    /* renamed from: a */
    private static void m1351a(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    /* renamed from: b */
    private static void m1352b(float f) {
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    /* renamed from: c */
    public static C0505bi m1353c(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        C0505bi t = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }

    /* renamed from: aT */
    public short mo4817aT() {
        return this.f1135fx;
    }

    /* renamed from: aU */
    public float mo4818aU() {
        return this.f1131fA;
    }

    /* renamed from: aV */
    public int mo4819aV() {
        return this.f1134fv;
    }

    public int describeContents() {
        C0506bj bjVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof C0505bi)) {
            return false;
        }
        C0505bi biVar = (C0505bi) obj;
        if (this.f1131fA != biVar.f1131fA) {
            return false;
        }
        if (this.f1136fy != biVar.f1136fy) {
            return false;
        }
        if (this.f1137fz != biVar.f1137fz) {
            return false;
        }
        return this.f1135fx == biVar.f1135fx;
    }

    public long getExpirationTime() {
        return this.f1132fU;
    }

    public double getLatitude() {
        return this.f1136fy;
    }

    public double getLongitude() {
        return this.f1137fz;
    }

    public String getRequestId() {
        return this.f1133fu;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f1136fy);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f1137fz);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f1131fA)) * 31) + this.f1135fx) * 31) + this.f1134fv;
    }

    /* renamed from: i */
    public int mo4827i() {
        return this.f1130ab;
    }

    public String toString() {
        return String.format("Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, @%d]", new Object[]{m1350Q(this.f1135fx), this.f1133fu, Integer.valueOf(this.f1134fv), Double.valueOf(this.f1136fy), Double.valueOf(this.f1137fz), Float.valueOf(this.f1131fA), Long.valueOf(this.f1132fU)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0506bj bjVar = CREATOR;
        C0506bj.m1358a(this, parcel, flags);
    }
}
