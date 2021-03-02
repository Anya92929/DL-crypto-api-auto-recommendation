package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkd;

@zzin
/* renamed from: com.google.android.gms.ads.internal.overlay.o */
class C1291o implements SensorEventListener {

    /* renamed from: a */
    private final SensorManager f3748a;

    /* renamed from: b */
    private final Object f3749b = new Object();

    /* renamed from: c */
    private final Display f3750c;

    /* renamed from: d */
    private final float[] f3751d = new float[9];

    /* renamed from: e */
    private final float[] f3752e = new float[9];

    /* renamed from: f */
    private float[] f3753f;

    /* renamed from: g */
    private Handler f3754g;

    /* renamed from: h */
    private C1293q f3755h;

    C1291o(Context context) {
        this.f3748a = (SensorManager) context.getSystemService("sensor");
        this.f3750c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    /* renamed from: a */
    private void m5642a(int i, int i2) {
        float f = this.f3752e[i];
        this.f3752e[i] = this.f3752e[i2];
        this.f3752e[i2] = f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5416a() {
        return this.f3750c.getRotation();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5417a(C1293q qVar) {
        this.f3755h = qVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5418a(float[] fArr) {
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.f3749b) {
                if (this.f3753f == null) {
                    this.f3753f = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.f3751d, fArr);
            switch (mo5416a()) {
                case 1:
                    SensorManager.remapCoordinateSystem(this.f3751d, 2, 129, this.f3752e);
                    break;
                case 2:
                    SensorManager.remapCoordinateSystem(this.f3751d, 129, 130, this.f3752e);
                    break;
                case 3:
                    SensorManager.remapCoordinateSystem(this.f3751d, 130, 1, this.f3752e);
                    break;
                default:
                    System.arraycopy(this.f3751d, 0, this.f3752e, 0, 9);
                    break;
            }
            m5642a(1, 3);
            m5642a(2, 6);
            m5642a(5, 7);
            synchronized (this.f3749b) {
                System.arraycopy(this.f3752e, 0, this.f3753f, 0, 9);
            }
            if (this.f3755h != null) {
                this.f3755h.zznz();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5419b() {
        if (this.f3754g == null) {
            Sensor defaultSensor = this.f3748a.getDefaultSensor(11);
            if (defaultSensor == null) {
                zzkd.m5769e("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            this.f3754g = new Handler(handlerThread.getLooper());
            if (!this.f3748a.registerListener(this, defaultSensor, 0, this.f3754g)) {
                zzkd.m5769e("SensorManager.registerListener failed.");
                mo5421c();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5420b(float[] fArr) {
        boolean z = false;
        synchronized (this.f3749b) {
            if (this.f3753f != null) {
                System.arraycopy(this.f3753f, 0, fArr, 0, this.f3753f.length);
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5421c() {
        if (this.f3754g != null) {
            this.f3748a.unregisterListener(this);
            this.f3754g.post(new C1292p(this));
            this.f3754g = null;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        mo5418a(sensorEvent.values);
    }
}
