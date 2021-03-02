package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

/* renamed from: com.google.android.gms.internal.cn */
public final class C0344cn {
    /* renamed from: a */
    public static void m730a(String str, Throwable th) {
        if (m732k(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: b */
    public static void m731b(String str, Throwable th) {
        if (m732k(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: k */
    public static boolean m732k(int i) {
        return (i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i)) && i != 2;
    }

    /* renamed from: m */
    public static void m733m(String str) {
        if (m732k(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: n */
    public static void m734n(String str) {
        if (m732k(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: o */
    public static void m735o(String str) {
        if (m732k(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: p */
    public static void m736p(String str) {
        if (m732k(2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: q */
    public static void m737q(String str) {
        if (m732k(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }
}
