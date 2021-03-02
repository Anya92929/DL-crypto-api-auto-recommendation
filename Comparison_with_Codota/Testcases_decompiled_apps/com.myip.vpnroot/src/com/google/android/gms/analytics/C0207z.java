package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.z */
public class C0207z {

    /* renamed from: AT */
    private static GoogleAnalytics f333AT;

    /* renamed from: T */
    public static void m306T(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.error(str);
        }
    }

    /* renamed from: U */
    public static void m307U(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.info(str);
        }
    }

    /* renamed from: V */
    public static void m308V(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.verbose(str);
        }
    }

    /* renamed from: W */
    public static void m309W(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.warn(str);
        }
    }

    /* renamed from: eL */
    public static boolean m310eL() {
        return getLogger() != null && getLogger().getLogLevel() == 0;
    }

    private static Logger getLogger() {
        if (f333AT == null) {
            f333AT = GoogleAnalytics.m52eE();
        }
        if (f333AT != null) {
            return f333AT.getLogger();
        }
        return null;
    }
}
