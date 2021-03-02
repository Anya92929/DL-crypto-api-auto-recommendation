package android.support.p000v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: android.support.v4.text.ICUCompatIcs */
class ICUCompatIcs {

    /* renamed from: a */
    private static Method f1074a;

    /* renamed from: b */
    private static Method f1075b;

    static {
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f1074a = cls.getMethod("getScript", new Class[]{String.class});
                f1075b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Exception e) {
            f1074a = null;
            f1075b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    ICUCompatIcs() {
    }

    /* renamed from: a */
    private static String m792a(String str) {
        try {
            if (f1074a != null) {
                return (String) f1074a.invoke((Object) null, new Object[]{str});
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    /* renamed from: a */
    private static String m793a(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f1075b != null) {
                return (String) f1075b.invoke((Object) null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }

    public static String maximizeAndGetScript(Locale locale) {
        String a = m793a(locale);
        if (a != null) {
            return m792a(a);
        }
        return null;
    }
}
