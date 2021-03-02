package android.support.p000v4.text;

import android.os.Build;
import java.util.Locale;

/* renamed from: android.support.v4.text.ICUCompat */
public class ICUCompat {

    /* renamed from: a */
    private static final ICUCompatImpl f1072a;

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImpl */
    interface ICUCompatImpl {
        String maximizeAndGetScript(Locale locale);
    }

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImplBase */
    class ICUCompatImplBase implements ICUCompatImpl {
        ICUCompatImplBase() {
        }

        public String maximizeAndGetScript(Locale locale) {
            return null;
        }
    }

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImplIcs */
    class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
        }

        public String maximizeAndGetScript(Locale locale) {
            return ICUCompatIcs.maximizeAndGetScript(locale);
        }
    }

    /* renamed from: android.support.v4.text.ICUCompat$ICUCompatImplLollipop */
    class ICUCompatImplLollipop implements ICUCompatImpl {
        ICUCompatImplLollipop() {
        }

        public String maximizeAndGetScript(Locale locale) {
            return ICUCompatApi23.maximizeAndGetScript(locale);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f1072a = new ICUCompatImplLollipop();
        } else if (i >= 14) {
            f1072a = new ICUCompatImplIcs();
        } else {
            f1072a = new ICUCompatImplBase();
        }
    }

    public static String maximizeAndGetScript(Locale locale) {
        return f1072a.maximizeAndGetScript(locale);
    }
}
