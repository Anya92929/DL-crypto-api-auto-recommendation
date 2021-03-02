package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import org.apache.commons.lang3.time.DateUtils;

public final class zzmv {

    /* renamed from: a */
    private static IntentFilter f3221a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: b */
    private static long f3222b;

    /* renamed from: c */
    private static float f3223c = Float.NaN;

    @TargetApi(20)
    public static int zzax(Context context) {
        int i = 1;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, f3221a);
        boolean z = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        int i2 = (zzne.zzsl() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 1 : 0) << 1;
        if (!z) {
            i = 0;
        }
        return i2 | i;
    }

    public static synchronized float zzay(Context context) {
        float f;
        synchronized (zzmv.class) {
            if (SystemClock.elapsedRealtime() - f3222b >= DateUtils.MILLIS_PER_MINUTE || f3223c == Float.NaN) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, f3221a);
                if (registerReceiver != null) {
                    f3223c = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                f3222b = SystemClock.elapsedRealtime();
                f = f3223c;
            } else {
                f = f3223c;
            }
        }
        return f;
    }
}
