package com.google.ads.util;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.google.ads.util.a */
public class C0282a {

    /* renamed from: a */
    private static boolean f706a = Log.isLoggable("GoogleAdsAssertion", 3);

    /* renamed from: a */
    public static void m472a(boolean z) {
        m477c(z, "Assertion failed.");
    }

    /* renamed from: a */
    public static void m473a(boolean z, String str) {
        m477c(z, str);
    }

    /* renamed from: b */
    public static void m475b(boolean z) {
        m477c(!z, "Assertion failed.");
    }

    /* renamed from: b */
    public static void m476b(boolean z, String str) {
        m477c(!z, str);
    }

    /* renamed from: a */
    public static void m469a(Object obj) {
        m477c(obj == null, "Assertion that an object is null failed.");
    }

    /* renamed from: b */
    public static void m474b(Object obj) {
        m477c(obj != null, "Assertion that an object is not null failed.");
    }

    /* renamed from: a */
    public static void m470a(Object obj, Object obj2) {
        m477c(obj == obj2, "Assertion that 'a' and 'b' refer to the same object failed.a: " + obj + ", b: " + obj2);
    }

    /* renamed from: a */
    public static void m471a(String str) {
        m477c(!TextUtils.isEmpty(str), "Expected a non empty string, got: " + str);
    }

    /* renamed from: com.google.ads.util.a$a */
    public static class C0283a extends Error {
        public C0283a(String str) {
            super(str);
        }
    }

    /* renamed from: c */
    private static void m477c(boolean z, String str) {
        if ((Log.isLoggable("GoogleAdsAssertion", 3) || f706a) && !z) {
            C0283a aVar = new C0283a(str);
            Log.d("GoogleAdsAssertion", str, aVar);
            throw aVar;
        }
    }
}
