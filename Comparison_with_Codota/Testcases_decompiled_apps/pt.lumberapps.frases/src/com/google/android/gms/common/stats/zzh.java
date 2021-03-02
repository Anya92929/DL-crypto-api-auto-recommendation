package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzj;
import java.util.List;

public class zzh {

    /* renamed from: a */
    private static String f4721a = "WakeLockTracker";

    /* renamed from: b */
    private static zzh f4722b = new zzh();

    /* renamed from: c */
    private static Boolean f4723c;

    /* renamed from: a */
    private static boolean m6197a(Context context) {
        if (f4723c == null) {
            f4723c = Boolean.valueOf(m6198b(context));
        }
        return f4723c.booleanValue();
    }

    /* renamed from: b */
    private static boolean m6198b(Context context) {
        try {
            if (!zzd.zzabc()) {
                return false;
            }
            return ((Integer) zzc.zzb.f4708At.get()).intValue() != zzd.LOG_LEVEL_OFF;
        } catch (SecurityException e) {
            return false;
        }
    }

    public static zzh zzavi() {
        return f4722b;
    }

    public void zza(Context context, String str, int i, String str2, String str3, String str4, int i2, List list) {
        zza(context, str, i, str2, str3, str4, i2, list, 0);
    }

    public void zza(Context context, String str, int i, String str2, String str3, String str4, int i2, List list, long j) {
        if (m6197a(context)) {
            if (TextUtils.isEmpty(str)) {
                String str5 = f4721a;
                String valueOf = String.valueOf(str);
                Log.e(str5, valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                try {
                    context.startService(new Intent().setComponent(zzd.f4717Az).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, zzf.m6195a(list), str, SystemClock.elapsedRealtime(), zzj.zzcm(context), str3, zzf.m6194a(context.getPackageName()), zzj.zzcn(context), j, str4)));
                } catch (Exception e) {
                    Log.wtf(f4721a, e);
                }
            }
        }
    }
}
