package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzmv;
import java.util.List;

public class zzi {

    /* renamed from: a */
    private static String f3106a = "WakeLockTracker";

    /* renamed from: b */
    private static zzi f3107b = new zzi();

    /* renamed from: c */
    private static Integer f3108c;

    /* renamed from: a */
    private static int m4002a() {
        try {
            return zzmp.zzkr() ? zzc.zzb.zzanz.get().intValue() : zzd.LOG_LEVEL_OFF;
        } catch (SecurityException e) {
            return zzd.LOG_LEVEL_OFF;
        }
    }

    /* renamed from: a */
    private static boolean m4003a(Context context) {
        if (f3108c == null) {
            f3108c = Integer.valueOf(m4002a());
        }
        return f3108c.intValue() != zzd.LOG_LEVEL_OFF;
    }

    public static zzi zzrZ() {
        return f3107b;
    }

    public void zza(Context context, String str, int i, String str2, String str3, int i2, List<String> list) {
        zza(context, str, i, str2, str3, i2, list, 0);
    }

    public void zza(Context context, String str, int i, String str2, String str3, int i2, List<String> list, long j) {
        if (m4003a(context)) {
            if (TextUtils.isEmpty(str)) {
                Log.e(f3106a, "missing wakeLock key. " + str);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                try {
                    context.startService(new Intent().setComponent(zzd.zzanF).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, list, str, SystemClock.elapsedRealtime(), zzmv.zzax(context), str3, context.getPackageName(), zzmv.zzay(context), j)));
                } catch (Exception e) {
                    Log.wtf(f3106a, e);
                }
            }
        }
    }
}
