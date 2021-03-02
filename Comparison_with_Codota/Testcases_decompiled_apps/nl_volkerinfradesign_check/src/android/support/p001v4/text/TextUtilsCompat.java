package android.support.p001v4.text;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Locale;

/* renamed from: android.support.v4.text.TextUtilsCompat */
public class TextUtilsCompat {
    public static final Locale ROOT = new Locale("", "");

    /* renamed from: a */
    private static final C0254a f842a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f843b = "Arab";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f844c = "Hebr";

    /* renamed from: android.support.v4.text.TextUtilsCompat$a */
    static class C0254a {
        private C0254a() {
        }

        @NonNull
        /* renamed from: a */
        public String mo1553a(@NonNull String str) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                switch (charAt) {
                    case '\"':
                        sb.append("&quot;");
                        break;
                    case '&':
                        sb.append("&amp;");
                        break;
                    case '\'':
                        sb.append("&#39;");
                        break;
                    case '<':
                        sb.append("&lt;");
                        break;
                    case '>':
                        sb.append("&gt;");
                        break;
                    default:
                        sb.append(charAt);
                        break;
                }
            }
            return sb.toString();
        }

        /* renamed from: a */
        public int mo1552a(@Nullable Locale locale) {
            if (locale != null && !locale.equals(TextUtilsCompat.ROOT)) {
                String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
                if (maximizeAndGetScript == null) {
                    return m967b(locale);
                }
                if (maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.f843b) || maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.f844c)) {
                    return 1;
                }
            }
            return 0;
        }

        /* renamed from: b */
        private static int m967b(@NonNull Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case 1:
                case 2:
                    return 1;
                default:
                    return 0;
            }
        }
    }

    /* renamed from: android.support.v4.text.TextUtilsCompat$b */
    static class C0255b extends C0254a {
        private C0255b() {
            super();
        }

        @NonNull
        /* renamed from: a */
        public String mo1553a(@NonNull String str) {
            return TextUtilsCompatJellybeanMr1.htmlEncode(str);
        }

        /* renamed from: a */
        public int mo1552a(@Nullable Locale locale) {
            return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(locale);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f842a = new C0255b();
        } else {
            f842a = new C0254a();
        }
    }

    @NonNull
    public static String htmlEncode(@NonNull String str) {
        return f842a.mo1553a(str);
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale locale) {
        return f842a.mo1552a(locale);
    }
}
