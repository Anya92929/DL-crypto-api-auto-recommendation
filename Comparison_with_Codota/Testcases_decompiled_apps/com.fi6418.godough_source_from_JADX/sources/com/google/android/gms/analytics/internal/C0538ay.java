package com.google.android.gms.analytics.internal;

/* renamed from: com.google.android.gms.analytics.internal.ay */
public enum C0538ay {
    NONE,
    GZIP;

    /* renamed from: a */
    public static C0538ay m3130a(String str) {
        return "GZIP".equalsIgnoreCase(str) ? GZIP : NONE;
    }
}
