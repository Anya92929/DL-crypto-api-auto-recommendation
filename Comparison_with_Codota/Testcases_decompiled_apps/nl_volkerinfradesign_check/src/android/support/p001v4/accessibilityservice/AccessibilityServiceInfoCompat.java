package android.support.p001v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;

/* renamed from: android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat */
public class AccessibilityServiceInfoCompat {
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int DEFAULT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;

    /* renamed from: a */
    private static final C0028d f27a;

    /* renamed from: android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$d */
    interface C0028d {
        /* renamed from: a */
        boolean mo55a(AccessibilityServiceInfo accessibilityServiceInfo);

        /* renamed from: b */
        String mo56b(AccessibilityServiceInfo accessibilityServiceInfo);

        /* renamed from: c */
        String mo57c(AccessibilityServiceInfo accessibilityServiceInfo);

        /* renamed from: d */
        ResolveInfo mo58d(AccessibilityServiceInfo accessibilityServiceInfo);

        /* renamed from: e */
        String mo59e(AccessibilityServiceInfo accessibilityServiceInfo);

        /* renamed from: f */
        int mo60f(AccessibilityServiceInfo accessibilityServiceInfo);
    }

    /* renamed from: android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$c */
    static class C0027c implements C0028d {
        C0027c() {
        }

        /* renamed from: a */
        public boolean mo55a(AccessibilityServiceInfo accessibilityServiceInfo) {
            return false;
        }

        /* renamed from: b */
        public String mo56b(AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        /* renamed from: c */
        public String mo57c(AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        /* renamed from: d */
        public ResolveInfo mo58d(AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        /* renamed from: e */
        public String mo59e(AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        /* renamed from: f */
        public int mo60f(AccessibilityServiceInfo accessibilityServiceInfo) {
            return 0;
        }
    }

    /* renamed from: android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$a */
    static class C0025a extends C0027c {
        C0025a() {
        }

        /* renamed from: a */
        public boolean mo55a(AccessibilityServiceInfo accessibilityServiceInfo) {
            return C1035d.m4621a(accessibilityServiceInfo);
        }

        /* renamed from: b */
        public String mo56b(AccessibilityServiceInfo accessibilityServiceInfo) {
            return C1035d.m4622b(accessibilityServiceInfo);
        }

        /* renamed from: c */
        public String mo57c(AccessibilityServiceInfo accessibilityServiceInfo) {
            return C1035d.m4623c(accessibilityServiceInfo);
        }

        /* renamed from: d */
        public ResolveInfo mo58d(AccessibilityServiceInfo accessibilityServiceInfo) {
            return C1035d.m4624d(accessibilityServiceInfo);
        }

        /* renamed from: e */
        public String mo59e(AccessibilityServiceInfo accessibilityServiceInfo) {
            return C1035d.m4625e(accessibilityServiceInfo);
        }

        /* renamed from: f */
        public int mo60f(AccessibilityServiceInfo accessibilityServiceInfo) {
            if (mo55a(accessibilityServiceInfo)) {
                return 1;
            }
            return 0;
        }
    }

    /* renamed from: android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$b */
    static class C0026b extends C0025a {
        C0026b() {
        }

        /* renamed from: f */
        public int mo60f(AccessibilityServiceInfo accessibilityServiceInfo) {
            return C1066e.m4769a(accessibilityServiceInfo);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            f27a = new C0026b();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f27a = new C0025a();
        } else {
            f27a = new C0027c();
        }
    }

    private AccessibilityServiceInfoCompat() {
    }

    public static String getId(AccessibilityServiceInfo accessibilityServiceInfo) {
        return f27a.mo57c(accessibilityServiceInfo);
    }

    public static ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo) {
        return f27a.mo58d(accessibilityServiceInfo);
    }

    public static String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo) {
        return f27a.mo59e(accessibilityServiceInfo);
    }

    public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo) {
        return f27a.mo55a(accessibilityServiceInfo);
    }

    public static String getDescription(AccessibilityServiceInfo accessibilityServiceInfo) {
        return f27a.mo56b(accessibilityServiceInfo);
    }

    public static String feedbackTypeToString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (i > 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i);
            i &= numberOfTrailingZeros ^ -1;
            if (sb.length() > 1) {
                sb.append(", ");
            }
            switch (numberOfTrailingZeros) {
                case 1:
                    sb.append("FEEDBACK_SPOKEN");
                    break;
                case 2:
                    sb.append("FEEDBACK_HAPTIC");
                    break;
                case 4:
                    sb.append("FEEDBACK_AUDIBLE");
                    break;
                case 8:
                    sb.append("FEEDBACK_VISUAL");
                    break;
                case 16:
                    sb.append("FEEDBACK_GENERIC");
                    break;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String flagToString(int i) {
        switch (i) {
            case 1:
                return "DEFAULT";
            case 2:
                return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
            case 4:
                return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
            case 8:
                return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case 16:
                return "FLAG_REPORT_VIEW_IDS";
            case 32:
                return "FLAG_REQUEST_FILTER_KEY_EVENTS";
            default:
                return null;
        }
    }

    public static int getCapabilities(AccessibilityServiceInfo accessibilityServiceInfo) {
        return f27a.mo60f(accessibilityServiceInfo);
    }

    public static String capabilityToString(int i) {
        switch (i) {
            case 1:
                return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
            case 2:
                return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
            case 4:
                return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case 8:
                return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
            default:
                return "UNKNOWN";
        }
    }
}
