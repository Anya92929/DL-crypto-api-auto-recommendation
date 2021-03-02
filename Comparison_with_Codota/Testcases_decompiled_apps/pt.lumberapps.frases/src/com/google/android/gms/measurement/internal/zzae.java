package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvw;

public final class zzae {

    /* renamed from: d */
    private static Boolean f7257d;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Handler f7258a = new Handler();

    /* renamed from: b */
    private final Context f7259b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final zza f7260c;

    public interface zza {
        boolean callServiceStopSelfResult(int i);

        Context getContext();
    }

    public zzae(zza zza2) {
        this.f7259b = zza2.getContext();
        zzab.zzy(this.f7259b);
        this.f7260c = zza2;
    }

    /* renamed from: a */
    private void m7773a() {
        try {
            synchronized (zzu.f7346a) {
                zzvw zzvw = zzu.f7347b;
                if (zzvw != null && zzvw.isHeld()) {
                    zzvw.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    /* renamed from: b */
    private zzp m7775b() {
        return zzx.zzdo(this.f7259b).zzbsd();
    }

    public static boolean zzaw(Context context) {
        zzab.zzy(context);
        if (f7257d != null) {
            return f7257d.booleanValue();
        }
        boolean zzj = zzal.zzj(context, "com.google.android.gms.measurement.AppMeasurementService");
        f7257d = Boolean.valueOf(zzj);
        return zzj;
    }

    public IBinder onBind(Intent intent) {
        if (intent == null) {
            m7775b().zzbsv().log("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzy(zzx.zzdo(this.f7259b));
        }
        m7775b().zzbsx().zzj("onBind received unknown action", action);
        return null;
    }

    public void onCreate() {
        zzx zzdo = zzx.zzdo(this.f7259b);
        zzp zzbsd = zzdo.zzbsd();
        if (zzdo.zzbsf().zzabc()) {
            zzbsd.zzbtc().log("Device AppMeasurementService is starting up");
        } else {
            zzbsd.zzbtc().log("Local AppMeasurementService is starting up");
        }
    }

    public void onDestroy() {
        zzx zzdo = zzx.zzdo(this.f7259b);
        zzp zzbsd = zzdo.zzbsd();
        if (zzdo.zzbsf().zzabc()) {
            zzbsd.zzbtc().log("Device AppMeasurementService is shutting down");
        } else {
            zzbsd.zzbtc().log("Local AppMeasurementService is shutting down");
        }
    }

    public void onRebind(Intent intent) {
        if (intent == null) {
            m7775b().zzbsv().log("onRebind called with null intent");
            return;
        }
        m7775b().zzbtc().zzj("onRebind called. action", intent.getAction());
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m7773a();
        zzx zzdo = zzx.zzdo(this.f7259b);
        zzp zzbsd = zzdo.zzbsd();
        if (intent == null) {
            zzbsd.zzbsx().log("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            if (zzdo.zzbsf().zzabc()) {
                zzbsd.zzbtc().zze("Device AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            } else {
                zzbsd.zzbtc().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            }
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                zzdo.zzbsc().zzm(new C1942v(this, zzdo, i2, zzbsd));
            }
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        if (intent == null) {
            m7775b().zzbsv().log("onUnbind called with null intent");
        } else {
            m7775b().zzbtc().zzj("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
