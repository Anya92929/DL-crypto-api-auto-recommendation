package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvw;

public final class zzu {

    /* renamed from: a */
    static final Object f7346a = new Object();

    /* renamed from: b */
    static zzvw f7347b;

    /* renamed from: c */
    static Boolean f7348c;

    public static boolean zzav(Context context) {
        zzab.zzy(context);
        if (f7348c != null) {
            return f7348c.booleanValue();
        }
        boolean zzb = zzal.zzb(context, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
        f7348c = Boolean.valueOf(zzb);
        return zzb;
    }

    public void onReceive(Context context, Intent intent) {
        zzx zzdo = zzx.zzdo(context);
        zzp zzbsd = zzdo.zzbsd();
        if (intent == null) {
            zzbsd.zzbsx().log("AppMeasurementReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (zzdo.zzbsf().zzabc()) {
            zzbsd.zzbtc().zzj("Device AppMeasurementReceiver got", action);
        } else {
            zzbsd.zzbtc().zzj("Local AppMeasurementReceiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean zzaw = zzae.zzaw(context);
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            synchronized (f7346a) {
                context.startService(className);
                if (zzaw) {
                    try {
                        if (f7347b == null) {
                            f7347b = new zzvw(context, 1, "AppMeasurement WakeLock");
                            f7347b.setReferenceCounted(false);
                        }
                        f7347b.acquire(1000);
                    } catch (SecurityException e) {
                        zzbsd.zzbsx().log("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
                    }
                }
            }
        }
    }
}
