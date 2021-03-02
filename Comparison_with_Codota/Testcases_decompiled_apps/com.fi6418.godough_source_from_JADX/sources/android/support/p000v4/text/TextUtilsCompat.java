package android.support.p000v4.text;

import android.os.Build;
import java.util.Locale;

/* renamed from: android.support.v4.text.TextUtilsCompat */
public class TextUtilsCompat {
    public static final Locale ROOT = new Locale("", "");

    /* renamed from: a */
    private static final TextUtilsCompatImpl f1079a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f1080b = "Arab";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f1081c = "Hebr";

    /* renamed from: android.support.v4.text.TextUtilsCompat$TextUtilsCompatImpl */
    class TextUtilsCompatImpl {
        private TextUtilsCompatImpl() {
        }

        /* renamed from: a */
        private static int m804a(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case 1:
                case 2:
                    return 1;
                default:
                    return 0;
            }
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            if (locale != null && !locale.equals(TextUtilsCompat.ROOT)) {
                String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
                if (maximizeAndGetScript == null) {
                    return m804a(locale);
                }
                if (maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.f1080b) || maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.f1081c)) {
                    return 1;
                }
            }
            return 0;
        }

        public String htmlEncode(String str) {
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
    }

    /* renamed from: android.support.v4.text.TextUtilsCompat$TextUtilsCompatJellybeanMr1Impl */
    class TextUtilsCompatJellybeanMr1Impl extends TextUtilsCompatImpl {
        private TextUtilsCompatJellybeanMr1Impl() {
            super();
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(locale);
        }

        public String htmlEncode(String str) {
            return TextUtilsCompatJellybeanMr1.htmlEncode(str);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f1079a = new TextUtilsCompatJellybeanMr1Impl();
        } else {
            f1079a = new TextUtilsCompatImpl();
        }
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        return f1079a.getLayoutDirectionFromLocale(locale);
    }

    public static String htmlEncode(String str) {
        return f1079a.htmlEncode(str);
    }
}
