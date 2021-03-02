package com.google.android.gms.common.util;

import android.os.SystemClock;

public final class zzh implements zze {

    /* renamed from: a */
    private static zzh f4725a;

    public static synchronized zze zzavm() {
        zzh zzh;
        synchronized (zzh.class) {
            if (f4725a == null) {
                f4725a = new zzh();
            }
            zzh = f4725a;
        }
        return zzh;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
