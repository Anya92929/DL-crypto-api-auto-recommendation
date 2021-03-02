package com.appbrain.p032a;

import android.content.Context;
import android.os.SystemClock;

/* renamed from: com.appbrain.a.ar */
public final class C0802ar {

    /* renamed from: a */
    private static final C0802ar f2109a = new C0802ar();

    /* renamed from: b */
    private static final C0802ar f2110b = new C0802ar();

    /* renamed from: c */
    private long f2111c = Long.MIN_VALUE;

    /* renamed from: a */
    public static void m3607a(Context context, String str) {
        f2109a.m3608a(context, str, "bcsample");
    }

    /* renamed from: a */
    private synchronized void m3608a(Context context, String str, String str2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f2111c < elapsedRealtime - 30000) {
            this.f2111c = elapsedRealtime;
            int a = C0932fm.m3968a().mo3840a(str2, 3);
            if (Math.random() < 1.0d / ((double) (1 << a))) {
                C0870de.m3790a(context).mo3745a(str, a);
            }
        }
    }

    /* renamed from: b */
    public static void m3609b(Context context, String str) {
        f2110b.m3608a(context, str, "icsample");
    }
}
