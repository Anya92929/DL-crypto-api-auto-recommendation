package android.support.p001v4.text;

import android.os.Build;
import java.util.Locale;

/* renamed from: android.support.v4.text.ICUCompat */
public class ICUCompat {

    /* renamed from: a */
    private static final C0242a f833a;

    /* renamed from: android.support.v4.text.ICUCompat$a */
    interface C0242a {
        /* renamed from: a */
        String mo1547a(Locale locale);
    }

    /* renamed from: android.support.v4.text.ICUCompat$b */
    static class C0243b implements C0242a {
        C0243b() {
        }

        /* renamed from: a */
        public String mo1547a(Locale locale) {
            return null;
        }
    }

    /* renamed from: android.support.v4.text.ICUCompat$c */
    static class C0244c implements C0242a {
        C0244c() {
        }

        /* renamed from: a */
        public String mo1547a(Locale locale) {
            return C1017cp.m4566a(locale);
        }
    }

    /* renamed from: android.support.v4.text.ICUCompat$d */
    static class C0245d implements C0242a {
        C0245d() {
        }

        /* renamed from: a */
        public String mo1547a(Locale locale) {
            return ICUCompatApi23.maximizeAndGetScript(locale);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f833a = new C0245d();
        } else if (i >= 14) {
            f833a = new C0244c();
        } else {
            f833a = new C0243b();
        }
    }

    public static String maximizeAndGetScript(Locale locale) {
        return f833a.mo1547a(locale);
    }
}
