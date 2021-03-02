package p000;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: cp */
public class C1017cp {

    /* renamed from: a */
    private static Method f4031a;

    /* renamed from: b */
    private static Method f4032b;

    static {
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f4031a = cls.getMethod("getScript", new Class[]{String.class});
                f4032b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Exception e) {
            f4031a = null;
            f4032b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    /* renamed from: a */
    public static String m4566a(Locale locale) {
        String b = m4567b(locale);
        if (b != null) {
            return m4565a(b);
        }
        return null;
    }

    /* renamed from: a */
    private static String m4565a(String str) {
        try {
            if (f4031a != null) {
                return (String) f4031a.invoke((Object) null, new Object[]{str});
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    /* renamed from: b */
    private static String m4567b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f4032b != null) {
                return (String) f4032b.invoke((Object) null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
