package com.google.android.gms.internal;

import android.os.SystemClock;

public final class zzmt implements zzmq {

    /* renamed from: a */
    private static zzmt f3220a;

    public static synchronized zzmq zzsc() {
        zzmt zzmt;
        synchronized (zzmt.class) {
            if (f3220a == null) {
                f3220a = new zzmt();
            }
            zzmt = f3220a;
        }
        return zzmt;
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
