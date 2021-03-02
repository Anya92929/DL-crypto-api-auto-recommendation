package com.google.ads.util;

import android.util.Log;
import com.google.ads.AdRequest;

/* renamed from: com.google.ads.util.b */
public final class C0284b {

    /* renamed from: a */
    public static C0286b f707a = null;

    /* renamed from: b */
    private static int f708b = 5;

    /* renamed from: com.google.ads.util.b$b */
    public interface C0286b {
        /* renamed from: a */
        void mo3702a(C0285a aVar, String str, Throwable th);
    }

    /* renamed from: com.google.ads.util.b$a */
    public enum C0285a {
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6);
        

        /* renamed from: f */
        public final int f715f;

        private C0285a(int i) {
            this.f715f = i;
        }
    }

    /* renamed from: a */
    private static void m478a(C0285a aVar, String str) {
        m479a(aVar, str, (Throwable) null);
    }

    /* renamed from: a */
    private static void m479a(C0285a aVar, String str, Throwable th) {
        if (f707a != null) {
            f707a.mo3702a(aVar, str, th);
        }
    }

    /* renamed from: a */
    public static void m480a(String str) {
        if (m483a(AdRequest.LOGTAG, 3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
        m478a(C0285a.DEBUG, str);
    }

    /* renamed from: a */
    public static void m481a(String str, Throwable th) {
        if (m483a(AdRequest.LOGTAG, 3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
        m479a(C0285a.DEBUG, str, th);
    }

    /* renamed from: b */
    public static void m484b(String str) {
        if (m483a(AdRequest.LOGTAG, 6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
        m478a(C0285a.ERROR, str);
    }

    /* renamed from: b */
    public static void m485b(String str, Throwable th) {
        if (m483a(AdRequest.LOGTAG, 6)) {
            Log.e(AdRequest.LOGTAG, str);
            Log.i(AdRequest.LOGTAG, "The following was caught and handled:", th);
        }
        m479a(C0285a.ERROR, str, th);
    }

    /* renamed from: c */
    public static void m486c(String str) {
        if (m483a(AdRequest.LOGTAG, 4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
        m478a(C0285a.INFO, str);
    }

    /* renamed from: c */
    public static void m487c(String str, Throwable th) {
        if (m483a(AdRequest.LOGTAG, 4)) {
            Log.i(AdRequest.LOGTAG, str, th);
        }
        m479a(C0285a.INFO, str, th);
    }

    /* renamed from: d */
    public static void m488d(String str) {
        if (m483a(AdRequest.LOGTAG, 2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
        m478a(C0285a.VERBOSE, str);
    }

    /* renamed from: e */
    public static void m490e(String str) {
        if (m483a(AdRequest.LOGTAG, 5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
        m478a(C0285a.WARN, str);
    }

    /* renamed from: d */
    public static void m489d(String str, Throwable th) {
        if (m483a(AdRequest.LOGTAG, 5)) {
            Log.w(AdRequest.LOGTAG, str);
            Log.i(AdRequest.LOGTAG, "The following was caught and handled:", th);
        }
        m479a(C0285a.WARN, str, th);
    }

    /* renamed from: a */
    public static boolean m483a(String str, int i) {
        return m482a(i) || Log.isLoggable(str, i);
    }

    /* renamed from: a */
    private static boolean m482a(int i) {
        return i >= f708b;
    }
}
