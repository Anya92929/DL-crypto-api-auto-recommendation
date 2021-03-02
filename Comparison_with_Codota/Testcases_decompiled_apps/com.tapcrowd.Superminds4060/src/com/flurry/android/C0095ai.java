package com.flurry.android;

import android.util.Log;

/* renamed from: com.flurry.android.ai */
final class C0095ai {

    /* renamed from: a */
    private static boolean f116a = false;

    /* renamed from: b */
    private static int f117b = 5;

    C0095ai() {
    }

    /* renamed from: a */
    static void m98a() {
        f116a = true;
    }

    /* renamed from: b */
    static void m103b() {
        f116a = false;
    }

    /* renamed from: a */
    static void m99a(int i) {
        f117b = i;
    }

    /* renamed from: a */
    static boolean m100a(String str) {
        return Log.isLoggable(str, 3);
    }

    /* renamed from: a */
    static int m97a(String str, String str2, Throwable th) {
        if (f116a || f117b <= 3) {
            return 0;
        }
        return Log.d(str, str2, th);
    }

    /* renamed from: a */
    static int m96a(String str, String str2) {
        if (f116a || f117b <= 3) {
            return 0;
        }
        return Log.d(str, str2);
    }

    /* renamed from: b */
    static int m102b(String str, String str2, Throwable th) {
        if (f116a || f117b <= 6) {
            return 0;
        }
        return Log.e(str, str2, th);
    }

    /* renamed from: b */
    static int m101b(String str, String str2) {
        if (f116a || f117b <= 6) {
            return 0;
        }
        return Log.e(str, str2);
    }

    /* renamed from: c */
    static int m105c(String str, String str2, Throwable th) {
        if (f116a || f117b <= 4) {
            return 0;
        }
        return Log.i(str, str2, th);
    }

    /* renamed from: c */
    static int m104c(String str, String str2) {
        if (f116a || f117b <= 4) {
            return 0;
        }
        return Log.i(str, str2);
    }

    /* renamed from: d */
    static int m107d(String str, String str2, Throwable th) {
        if (f116a || f117b <= 5) {
            return 0;
        }
        return Log.w(str, str2, th);
    }

    /* renamed from: d */
    static int m106d(String str, String str2) {
        if (f116a || f117b <= 5) {
            return 0;
        }
        return Log.w(str, str2);
    }
}
