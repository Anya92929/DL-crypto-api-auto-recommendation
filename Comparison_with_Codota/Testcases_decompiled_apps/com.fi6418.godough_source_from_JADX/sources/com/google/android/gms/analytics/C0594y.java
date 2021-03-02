package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.C0561i;

/* renamed from: com.google.android.gms.analytics.y */
public final class C0594y {
    /* renamed from: a */
    public static String m3485a(int i) {
        return m3486a("&cd", i);
    }

    /* renamed from: a */
    private static String m3486a(String str, int i) {
        if (i >= 1) {
            return str + i;
        }
        C0561i.m3260a("index out of range for prefix", str);
        return "";
    }

    /* renamed from: b */
    public static String m3487b(int i) {
        return m3486a("cd", i);
    }

    /* renamed from: c */
    public static String m3488c(int i) {
        return m3486a("cm", i);
    }

    /* renamed from: d */
    public static String m3489d(int i) {
        return m3486a("&pr", i);
    }

    /* renamed from: e */
    public static String m3490e(int i) {
        return m3486a("pr", i);
    }

    /* renamed from: f */
    public static String m3491f(int i) {
        return m3486a("&promo", i);
    }

    /* renamed from: g */
    public static String m3492g(int i) {
        return m3486a("promo", i);
    }

    /* renamed from: h */
    public static String m3493h(int i) {
        return m3486a("pi", i);
    }

    /* renamed from: i */
    public static String m3494i(int i) {
        return m3486a("&il", i);
    }

    /* renamed from: j */
    public static String m3495j(int i) {
        return m3486a("il", i);
    }
}
