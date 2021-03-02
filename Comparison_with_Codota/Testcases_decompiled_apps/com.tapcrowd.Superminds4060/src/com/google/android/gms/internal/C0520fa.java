package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.fa */
public class C0520fa implements SafeParcelable, Geofence {
    public static final C0521fb CREATOR = new C0521fb();

    /* renamed from: iM */
    private final int f1308iM;

    /* renamed from: oA */
    private final String f1309oA;

    /* renamed from: oB */
    private final int f1310oB;

    /* renamed from: oD */
    private final short f1311oD;

    /* renamed from: oE */
    private final double f1312oE;

    /* renamed from: oF */
    private final double f1313oF;

    /* renamed from: oG */
    private final float f1314oG;

    /* renamed from: oH */
    private final int f1315oH;

    /* renamed from: oI */
    private final int f1316oI;

    /* renamed from: pc */
    private final long f1317pc;

    public C0520fa(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        m1542R(str);
        m1546b(f);
        m1543a(d, d2);
        int aa = m1544aa(i2);
        this.f1308iM = i;
        this.f1311oD = s;
        this.f1309oA = str;
        this.f1312oE = d;
        this.f1313oF = d2;
        this.f1314oG = f;
        this.f1317pc = j;
        this.f1310oB = aa;
        this.f1315oH = i3;
        this.f1316oI = i4;
    }

    public C0520fa(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        this(1, str, i, s, d, d2, f, j, i2, i3);
    }

    /* renamed from: R */
    private static void m1542R(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    /* renamed from: a */
    private static void m1543a(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    /* renamed from: aa */
    private static int m1544aa(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    /* renamed from: ab */
    private static String m1545ab(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    /* renamed from: b */
    private static void m1546b(float f) {
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    /* renamed from: d */
    public static C0520fa m1547d(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        C0520fa z = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return z;
    }

    /* renamed from: co */
    public short mo4763co() {
        return this.f1311oD;
    }

    /* renamed from: cp */
    public float mo4764cp() {
        return this.f1314oG;
    }

    /* renamed from: cq */
    public int mo4765cq() {
        return this.f1310oB;
    }

    /* renamed from: cr */
    public int mo4766cr() {
        return this.f1316oI;
    }

    public int describeContents() {
        C0521fb fbVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof C0520fa)) {
            return false;
        }
        C0520fa faVar = (C0520fa) obj;
        if (this.f1314oG != faVar.f1314oG) {
            return false;
        }
        if (this.f1312oE != faVar.f1312oE) {
            return false;
        }
        if (this.f1313oF != faVar.f1313oF) {
            return false;
        }
        return this.f1311oD == faVar.f1311oD;
    }

    public long getExpirationTime() {
        return this.f1317pc;
    }

    public double getLatitude() {
        return this.f1312oE;
    }

    public double getLongitude() {
        return this.f1313oF;
    }

    public int getNotificationResponsiveness() {
        return this.f1315oH;
    }

    public String getRequestId() {
        return this.f1309oA;
    }

    public int getVersionCode() {
        return this.f1308iM;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f1312oE);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f1313oF);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f1314oG)) * 31) + this.f1311oD) * 31) + this.f1310oB;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{m1545ab(this.f1311oD), this.f1309oA, Integer.valueOf(this.f1310oB), Double.valueOf(this.f1312oE), Double.valueOf(this.f1313oF), Float.valueOf(this.f1314oG), Integer.valueOf(this.f1315oH / LocationStatusCodes.GEOFENCE_NOT_AVAILABLE), Integer.valueOf(this.f1316oI), Long.valueOf(this.f1317pc)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0521fb fbVar = CREATOR;
        C0521fb.m1552a(this, parcel, flags);
    }
}
