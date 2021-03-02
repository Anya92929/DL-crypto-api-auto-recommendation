package android.support.p000v4.text;

import android.os.Build;

/* renamed from: android.support.v4.text.ICUCompat */
public class ICUCompat {
    private static final ICUCompatImpl IMPL;

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImpl */
    interface ICUCompatImpl {
        String addLikelySubtags(String str);

        String getScript(String str);
    }

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImplBase */
    static class ICUCompatImplBase implements ICUCompatImpl {
        ICUCompatImplBase() {
        }

        public String getScript(String locale) {
            return null;
        }

        public String addLikelySubtags(String locale) {
            return locale;
        }
    }

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImplIcs */
    static class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
        }

        public String getScript(String locale) {
            return ICUCompatIcs.getScript(locale);
        }

        public String addLikelySubtags(String locale) {
            return ICUCompatIcs.addLikelySubtags(locale);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new ICUCompatImplIcs();
        } else {
            IMPL = new ICUCompatImplBase();
        }
    }

    public static String getScript(String locale) {
        return IMPL.getScript(locale);
    }

    public static String addLikelySubtags(String locale) {
        return IMPL.addLikelySubtags(locale);
    }
}
