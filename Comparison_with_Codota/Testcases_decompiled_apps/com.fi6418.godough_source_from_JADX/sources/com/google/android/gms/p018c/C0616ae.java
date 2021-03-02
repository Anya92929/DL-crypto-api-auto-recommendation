package com.google.android.gms.p018c;

import android.os.SystemClock;

/* renamed from: com.google.android.gms.c.ae */
public final class C0616ae implements C0615ad {

    /* renamed from: a */
    private static C0616ae f4218a;

    /* renamed from: c */
    public static synchronized C0615ad m3557c() {
        C0616ae aeVar;
        synchronized (C0616ae.class) {
            if (f4218a == null) {
                f4218a = new C0616ae();
            }
            aeVar = f4218a;
        }
        return aeVar;
    }

    /* renamed from: a */
    public long mo6990a() {
        return System.currentTimeMillis();
    }

    /* renamed from: b */
    public long mo6991b() {
        return SystemClock.elapsedRealtime();
    }
}
