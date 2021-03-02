package android.support.p000v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.Locale;

/* renamed from: android.support.v4.text.TextUtilsCompat */
public class TextUtilsCompat {
    private static String ARAB_SCRIPT_SUBTAG = "Arab";
    private static String HEBR_SCRIPT_SUBTAG = "Hebr";
    public static final Locale ROOT = new Locale("", "");

    @NonNull
    public static String htmlEncode(@NonNull String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case FitnessActivities.HANDBALL /*34*/:
                    sb.append("&quot;");
                    break;
                case FitnessActivities.HOUSEWORK /*38*/:
                    sb.append("&amp;");
                    break;
                case FitnessActivities.JUMP_ROPE /*39*/:
                    sb.append("&#39;");
                    break;
                case FitnessActivities.SCUBA_DIVING /*60*/:
                    sb.append("&lt;");
                    break;
                case FitnessActivities.SKATING /*62*/:
                    sb.append("&gt;");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale locale) {
        if (locale != null && !locale.equals(ROOT)) {
            String scriptSubtag = ICUCompat.getScript(ICUCompat.addLikelySubtags(locale.toString()));
            if (scriptSubtag == null) {
                return getLayoutDirectionFromFirstChar(locale);
            }
            if (scriptSubtag.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) || scriptSubtag.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) {
                return 1;
            }
        }
        return 0;
    }

    private static int getLayoutDirectionFromFirstChar(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}
