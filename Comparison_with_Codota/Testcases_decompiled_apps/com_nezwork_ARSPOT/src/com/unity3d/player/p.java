package com.unity3d.player;

import android.content.Context;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.view.WindowManager;
import com.qualcomm.ar.pl.SystemTools;
import java.util.Iterator;
import java.util.List;

final class p implements SensorEventListener, LocationListener {
    private static final int[] d = {1, 1, 0, 1, -1, 1, 1, 0, -1, -1, 0, 1, 1, -1, 1, 0};
    private static final float[][] e = {new float[]{0.0f, 0.0f, 0.0f, 1.0f}, new float[]{0.0f, 0.0f, ((float) Math.sqrt(2.0d)) * 0.5f, (-((float) Math.sqrt(2.0d))) * 0.5f}, new float[]{0.0f, 0.0f, 1.0f, 0.0f}, new float[]{0.0f, 0.0f, (-((float) Math.sqrt(2.0d))) * 0.5f, (-((float) Math.sqrt(2.0d))) * 0.5f}};
    private Runnable A = new r(this);
    private Runnable B = new s(this);
    private Runnable C = new t(this);
    private Runnable D = new u(this);
    /* access modifiers changed from: private */
    public float[] E = new float[5];
    /* access modifiers changed from: private */
    public double F;
    private Runnable G = new v(this);
    private float[] H = new float[9];
    private float[] I = new float[3];
    /* access modifiers changed from: private */
    public int J;
    private Runnable K = new w(this);
    private Location L;
    private float M = 0.0f;
    private boolean N = false;
    private int O = 0;
    private boolean P = false;
    private int Q = 0;
    private final Context a;
    /* access modifiers changed from: private */
    public final UnityPlayer b;
    private final WindowManager c;
    private float[] f = new float[3];
    private float[] g = new float[3];
    /* access modifiers changed from: private */
    public float h;
    /* access modifiers changed from: private */
    public float i;
    /* access modifiers changed from: private */
    public float j;
    /* access modifiers changed from: private */
    public long k;
    /* access modifiers changed from: private */
    public float l;
    /* access modifiers changed from: private */
    public float m;
    /* access modifiers changed from: private */
    public float n;
    /* access modifiers changed from: private */
    public long o;
    /* access modifiers changed from: private */
    public float p;
    /* access modifiers changed from: private */
    public float q;
    /* access modifiers changed from: private */
    public float r;
    /* access modifiers changed from: private */
    public long s;
    /* access modifiers changed from: private */
    public float t;
    /* access modifiers changed from: private */
    public float u;
    /* access modifiers changed from: private */
    public float v;
    /* access modifiers changed from: private */
    public long w;
    /* access modifiers changed from: private */
    public float[] x = new float[4];
    private float[] y = new float[4];
    private Runnable z = new q(this);

    protected p(Context context, UnityPlayer unityPlayer) {
        this.a = context;
        this.b = unityPlayer;
        this.c = (WindowManager) this.a.getSystemService("window");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0087, code lost:
        if (r5 != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008d, code lost:
        if (r0 == false) goto L_0x008f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.location.Location r11) {
        /*
            r10 = this;
            r2 = 0
            r1 = 1
            if (r11 != 0) goto L_0x0005
        L_0x0004:
            return
        L_0x0005:
            android.location.Location r7 = r10.L
            if (r7 != 0) goto L_0x0031
        L_0x0009:
            if (r1 == 0) goto L_0x0004
            r10.L = r11
            com.unity3d.player.UnityPlayer r0 = r10.b
            double r1 = r11.getLatitude()
            float r1 = (float) r1
            double r2 = r11.getLongitude()
            float r2 = (float) r2
            double r3 = r11.getAltitude()
            float r3 = (float) r3
            float r4 = r11.getAccuracy()
            long r5 = r11.getTime()
            double r5 = (double) r5
            r7 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r5 = r5 / r7
            r0.nativeSetLocation(r1, r2, r3, r4, r5)
            goto L_0x0004
        L_0x0031:
            long r3 = r11.getTime()
            long r5 = r7.getTime()
            long r4 = r3 - r5
            r8 = 120000(0x1d4c0, double:5.9288E-319)
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x0092
            r3 = r1
        L_0x0043:
            r8 = -120000(0xfffffffffffe2b40, double:NaN)
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0094
            r0 = r1
        L_0x004b:
            r8 = 0
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x0096
            r6 = r1
        L_0x0052:
            if (r3 != 0) goto L_0x0009
            if (r0 != 0) goto L_0x008f
            float r0 = r11.getAccuracy()
            float r3 = r7.getAccuracy()
            float r0 = r0 - r3
            int r0 = (int) r0
            if (r0 <= 0) goto L_0x0098
            r5 = r1
        L_0x0063:
            if (r0 >= 0) goto L_0x009a
            r4 = r1
        L_0x0066:
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 <= r3) goto L_0x009c
            r0 = r1
        L_0x006b:
            float r3 = r11.getAccuracy()
            r8 = 0
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x009e
            r3 = r1
        L_0x0075:
            r3 = r3 | r0
            java.lang.String r0 = r11.getProvider()
            java.lang.String r7 = r7.getProvider()
            if (r0 != 0) goto L_0x00a2
            if (r7 != 0) goto L_0x00a0
            r0 = r1
        L_0x0083:
            if (r4 != 0) goto L_0x0009
            if (r6 == 0) goto L_0x0089
            if (r5 == 0) goto L_0x0009
        L_0x0089:
            if (r6 == 0) goto L_0x008f
            if (r3 != 0) goto L_0x008f
            if (r0 != 0) goto L_0x0009
        L_0x008f:
            r1 = r2
            goto L_0x0009
        L_0x0092:
            r3 = r2
            goto L_0x0043
        L_0x0094:
            r0 = r2
            goto L_0x004b
        L_0x0096:
            r6 = r2
            goto L_0x0052
        L_0x0098:
            r5 = r2
            goto L_0x0063
        L_0x009a:
            r4 = r2
            goto L_0x0066
        L_0x009c:
            r0 = r2
            goto L_0x006b
        L_0x009e:
            r3 = r2
            goto L_0x0075
        L_0x00a0:
            r0 = r2
            goto L_0x0083
        L_0x00a2:
            boolean r0 = r0.equals(r7)
            goto L_0x0083
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.p.a(android.location.Location):void");
    }

    static /* synthetic */ long f() {
        return 0;
    }

    public final void a(float f2) {
        this.M = f2;
    }

    public final boolean a() {
        return !((LocationManager) this.a.getSystemService("location")).getProviders(new Criteria(), true).isEmpty();
    }

    public final void b() {
        LocationProvider locationProvider;
        this.P = false;
        if (this.N) {
            l.Log(5, "Location_StartUpdatingLocation already started!");
        } else if (!a()) {
            this.Q = 3;
            this.b.nativeSetLocationStatus(3);
        } else {
            LocationManager locationManager = (LocationManager) this.a.getSystemService("location");
            this.Q = 1;
            this.b.nativeSetLocationStatus(1);
            List<String> providers = locationManager.getProviders(true);
            if (providers.isEmpty()) {
                this.Q = 3;
                this.b.nativeSetLocationStatus(3);
                return;
            }
            if (this.O == 2) {
                Iterator<String> it = providers.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    LocationProvider provider = locationManager.getProvider(it.next());
                    if (provider.getAccuracy() == 2) {
                        locationProvider = provider;
                        break;
                    }
                }
            }
            locationProvider = null;
            for (String next : providers) {
                if (locationProvider == null || locationManager.getProvider(next).getAccuracy() != 1) {
                    a(locationManager.getLastKnownLocation(next));
                    locationManager.requestLocationUpdates(next, 0, this.M, this, this.a.getMainLooper());
                    this.N = true;
                }
            }
        }
    }

    public final void b(float f2) {
        if (f2 < 100.0f) {
            this.O = 1;
        } else if (f2 < 500.0f) {
            this.O = 1;
        } else {
            this.O = 2;
        }
    }

    public final void c() {
        ((LocationManager) this.a.getSystemService("location")).removeUpdates(this);
        this.N = false;
        this.L = null;
        this.Q = 0;
        this.b.nativeSetLocationStatus(0);
    }

    public final void d() {
        if (this.Q == 1 || this.Q == 2) {
            this.P = true;
            c();
        }
    }

    public final void e() {
        if (this.P) {
            b();
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public final void onLocationChanged(Location location) {
        this.Q = 2;
        this.b.nativeSetLocationStatus(2);
        a(location);
    }

    public final void onProviderDisabled(String str) {
        this.L = null;
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        float sqrt;
        float f2;
        int i2;
        int orientation = this.c.getDefaultDisplay().getOrientation();
        int i3 = (orientation - 1) & 3;
        float f3 = (float) d[(i3 * 4) + 0];
        float f4 = (float) d[(i3 * 4) + 1];
        int i4 = d[(i3 * 4) + 2];
        int i5 = d[(i3 * 4) + 3];
        switch (sensorEvent.sensor.getType()) {
            case 1:
                this.f = (float[]) sensorEvent.values.clone();
                int orientation2 = this.c.getDefaultDisplay().getOrientation();
                int i6 = (orientation2 - 1) & 3;
                int i7 = d[(i6 * 4) + 2];
                int i8 = d[(i6 * 4) + 3];
                this.h = ((float) d[(i6 * 4) + 0]) * -0.10197162f * sensorEvent.values[i7];
                this.i = sensorEvent.values[i8] * ((float) d[(i6 * 4) + 1]) * -0.10197162f;
                this.j = sensorEvent.values[2] * -0.10197162f;
                this.k = sensorEvent.timestamp;
                this.b.queueEvent(this.z);
                float f5 = sensorEvent.values[0];
                float f6 = sensorEvent.values[1];
                float f7 = sensorEvent.values[2];
                float sqrt2 = 1.0f / ((float) Math.sqrt((double) (((f5 * f5) + (f6 * f6)) + (f7 * f7))));
                float f8 = f5 * sqrt2;
                float f9 = f6 * sqrt2;
                float f10 = f7 * sqrt2;
                int orientation3 = this.b.getOrientation();
                int i9 = (orientation2 - (orientation3 == 1 ? 0 : orientation3 == 0 ? 1 : orientation3 == 9 ? 2 : orientation3 == 8 ? 3 : 0)) & 3;
                if (i9 == 1) {
                    f2 = f9;
                } else if (i9 == 3) {
                    f8 = -f8;
                    f2 = f9;
                } else {
                    f2 = f8;
                    f8 = f9;
                }
                float f11 = -1.0f;
                if (-1.0f < f8) {
                    i2 = 1;
                    f11 = f8;
                } else {
                    i2 = 0;
                }
                if (f11 < (-f8)) {
                    f11 = -f8;
                    i2 = 2;
                }
                if (f11 < f2) {
                    i2 = 3;
                    f11 = f2;
                }
                if (f11 < (-f2)) {
                    f11 = -f2;
                    i2 = 4;
                }
                if (f11 < f10) {
                    i2 = 5;
                    f11 = f10;
                }
                if (f11 < (-f10)) {
                    f11 = -f10;
                    i2 = 6;
                }
                if (((double) f11) < 0.5d * Math.sqrt(3.0d)) {
                    i2 = 0;
                }
                this.J = i2;
                this.b.queueEvent(this.K);
                return;
            case 2:
                this.g = (float[]) sensorEvent.values.clone();
                this.F = ((double) System.currentTimeMillis()) / 1000.0d;
                if (SensorManager.getRotationMatrix(this.H, (float[]) null, this.f, this.g)) {
                    SensorManager.getOrientation(this.H, this.I);
                    float degrees = (float) Math.toDegrees((double) this.I[0]);
                    switch (orientation) {
                        case 1:
                            degrees += 90.0f;
                            break;
                        case 2:
                            degrees += 180.0f;
                            break;
                        case SystemTools.AR_ERROR_INVALID_ENUM:
                            degrees += 270.0f;
                            break;
                    }
                    while (degrees >= 360.0f) {
                        degrees -= 360.0f;
                    }
                    float f12 = degrees < 0.0f ? degrees + 360.0f : degrees;
                    this.E[0] = this.g[0];
                    this.E[1] = this.g[1];
                    this.E[2] = this.g[2];
                    this.E[3] = f12;
                    if (this.L != null && System.currentTimeMillis() - this.L.getTime() < 1200000) {
                        f12 += new GeomagneticField((float) this.L.getLatitude(), (float) this.L.getLongitude(), (float) this.L.getAltitude(), this.L.getTime()).getDeclination();
                    }
                    while (true) {
                        float f13 = f12;
                        if (f13 >= 360.0f) {
                            f12 = f13 - 360.0f;
                        } else {
                            if (f13 < 0.0f) {
                                f13 += 360.0f;
                            }
                            this.E[4] = f13;
                            this.b.queueEvent(this.G);
                            return;
                        }
                    }
                } else {
                    return;
                }
            case SystemTools.AR_ERROR_INVALID_HANDLE:
                this.l = f3 * sensorEvent.values[i4];
                this.m = sensorEvent.values[i5] * f4;
                this.n = sensorEvent.values[2];
                this.o = sensorEvent.timestamp;
                this.b.queueEvent(this.A);
                return;
            case 9:
                this.p = f3 * -0.10197162f * sensorEvent.values[i4];
                this.q = sensorEvent.values[i5] * f4 * -0.10197162f;
                this.r = sensorEvent.values[2] * -0.10197162f;
                this.s = sensorEvent.timestamp;
                this.b.queueEvent(this.B);
                return;
            case 10:
                this.t = f3 * -0.10197162f * sensorEvent.values[i4];
                this.u = sensorEvent.values[i5] * f4 * -0.10197162f;
                this.v = sensorEvent.values[2] * -0.10197162f;
                this.w = sensorEvent.timestamp;
                this.b.queueEvent(this.C);
                return;
            case 11:
                this.y[0] = sensorEvent.values[0];
                this.y[1] = sensorEvent.values[1];
                this.y[2] = sensorEvent.values[2];
                if (sensorEvent.values.length == 4) {
                    fArr = this.y;
                    sqrt = sensorEvent.values[3];
                } else {
                    float f14 = (this.y[0] * this.y[0]) + (this.y[1] * this.y[1]) + (this.y[2] * this.y[2]);
                    fArr = this.y;
                    sqrt = f14 < 1.0f ? (float) Math.sqrt((double) (1.0f - f14)) : 0.0f;
                }
                fArr[3] = sqrt;
                float[] fArr2 = this.x;
                float[] fArr3 = this.y;
                float[] fArr4 = e[orientation];
                fArr2[0] = (((fArr3[3] * fArr4[0]) + (fArr3[0] * fArr4[3])) + (fArr3[1] * fArr4[2])) - (fArr3[2] * fArr4[1]);
                fArr2[1] = (((fArr3[3] * fArr4[1]) + (fArr3[1] * fArr4[3])) + (fArr3[2] * fArr4[0])) - (fArr3[0] * fArr4[2]);
                fArr2[2] = (((fArr3[3] * fArr4[2]) + (fArr3[2] * fArr4[3])) + (fArr3[0] * fArr4[1])) - (fArr3[1] * fArr4[0]);
                fArr2[3] = (((fArr3[3] * fArr4[3]) - (fArr4[0] * fArr3[0])) - (fArr3[1] * fArr4[1])) - (fArr3[2] * fArr4[2]);
                this.b.queueEvent(this.D);
                return;
            default:
                return;
        }
    }

    public final void onStatusChanged(String str, int i2, Bundle bundle) {
    }
}
