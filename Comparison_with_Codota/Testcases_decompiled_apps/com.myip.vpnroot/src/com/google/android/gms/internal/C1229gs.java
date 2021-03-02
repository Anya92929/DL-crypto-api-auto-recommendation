package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

@C1130ez
/* renamed from: com.google.android.gms.internal.gs */
public final class C1229gs {
    /* renamed from: S */
    public static void m4675S(String str) {
        if (m4684u(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: T */
    public static void m4676T(String str) {
        if (m4684u(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: U */
    public static void m4677U(String str) {
        if (m4684u(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: V */
    public static void m4678V(String str) {
        if (m4684u(2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: W */
    public static void m4679W(String str) {
        if (m4684u(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: a */
    public static void m4680a(String str, Throwable th) {
        if (m4684u(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: b */
    public static void m4681b(String str, Throwable th) {
        if (m4684u(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: c */
    public static void m4682c(String str, Throwable th) {
        if (m4684u(4)) {
            Log.i(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: d */
    public static void m4683d(String str, Throwable th) {
        if (m4684u(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: u */
    public static boolean m4684u(int i) {
        return (i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i)) && i != 2;
    }
}
