package com.google.android.gms.common.stats;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.p018c.C0614ac;
import com.google.android.gms.p018c.C0618ag;
import java.util.List;

/* renamed from: com.google.android.gms.common.stats.j */
public class C1101j {

    /* renamed from: a */
    private static String f4865a = "WakeLockTracker";

    /* renamed from: b */
    private static C1101j f4866b = new C1101j();

    /* renamed from: c */
    private static final ComponentName f4867c = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");

    /* renamed from: d */
    private static IntentFilter f4868d = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: e */
    private static Integer f4869e;

    /* renamed from: a */
    private int m4780a(Context context) {
        int i = 1;
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, f4868d);
        boolean z = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0;
        int i2 = (C0618ag.m3568f() ? ((PowerManager) context.getSystemService("power")).isInteractive() : ((PowerManager) context.getSystemService("power")).isScreenOn() ? 1 : 0) << 1;
        if (!z) {
            i = 0;
        }
        return i2 | i;
    }

    /* renamed from: a */
    public static C1101j m4781a() {
        return f4866b;
    }

    /* renamed from: b */
    private float m4782b(Context context) {
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return Float.NaN;
        }
        return ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
    }

    /* renamed from: b */
    private static int m4783b() {
        try {
            return C0614ac.m3553a() ? C1096e.f4853a.mo7234c().intValue() : C1097f.f4855a;
        } catch (SecurityException e) {
            return C1097f.f4855a;
        }
    }

    /* renamed from: c */
    private static boolean m4784c(Context context) {
        if (f4869e == null) {
            f4869e = Integer.valueOf(m4783b());
        }
        return f4869e.intValue() != C1097f.f4855a;
    }

    /* renamed from: a */
    public void mo7712a(Context context, String str, int i, String str2, String str3, int i2, List<String> list) {
        if (m4784c(context)) {
            if (TextUtils.isEmpty(str)) {
                Log.e(f4865a, "missing wakeLock key. " + str);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                try {
                    context.startService(new Intent().setComponent(f4867c).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, list, str, SystemClock.elapsedRealtime(), m4780a(context), str3, context.getPackageName(), m4782b(context))));
                } catch (Exception e) {
                    Log.wtf(f4865a, e);
                }
            }
        }
    }
}
