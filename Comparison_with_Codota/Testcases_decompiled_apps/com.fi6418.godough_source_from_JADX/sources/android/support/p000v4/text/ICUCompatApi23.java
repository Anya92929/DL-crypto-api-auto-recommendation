package android.support.p000v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: android.support.v4.text.ICUCompatApi23 */
public class ICUCompatApi23 {

    /* renamed from: a */
    private static Method f1073a;

    static {
        try {
            f1073a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String maximizeAndGetScript(Locale locale) {
        try {
            return ((Locale) f1073a.invoke((Object) null, new Object[]{locale})).getScript();
        } catch (InvocationTargetException e) {
            Log.w("ICUCompatIcs", e);
        } catch (IllegalAccessException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale.getScript();
    }
}
