package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.n */
public final class C0180n {
    /* renamed from: A */
    public static String m201A(int i) {
        return m206d("&promo", i);
    }

    /* renamed from: B */
    public static String m202B(int i) {
        return m206d("pi", i);
    }

    /* renamed from: C */
    public static String m203C(int i) {
        return m206d("&il", i);
    }

    /* renamed from: D */
    public static String m204D(int i) {
        return m206d("cd", i);
    }

    /* renamed from: E */
    public static String m205E(int i) {
        return m206d("cm", i);
    }

    /* renamed from: d */
    private static String m206d(String str, int i) {
        if (i >= 1) {
            return str + i;
        }
        C0207z.m306T("index out of range for " + str + " (" + i + ")");
        return "";
    }

    /* renamed from: x */
    static String m207x(int i) {
        return m206d("&cd", i);
    }

    /* renamed from: y */
    static String m208y(int i) {
        return m206d("&cm", i);
    }

    /* renamed from: z */
    public static String m209z(int i) {
        return m206d("&pr", i);
    }
}
