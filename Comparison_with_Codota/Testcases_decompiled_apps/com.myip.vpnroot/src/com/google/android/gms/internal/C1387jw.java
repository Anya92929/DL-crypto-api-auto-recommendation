package com.google.android.gms.internal;

import android.os.SystemClock;

/* renamed from: com.google.android.gms.internal.jw */
public final class C1387jw implements C1385ju {

    /* renamed from: MK */
    private static C1387jw f4136MK;

    /* renamed from: hA */
    public static synchronized C1385ju m5217hA() {
        C1387jw jwVar;
        synchronized (C1387jw.class) {
            if (f4136MK == null) {
                f4136MK = new C1387jw();
            }
            jwVar = f4136MK;
        }
        return jwVar;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
