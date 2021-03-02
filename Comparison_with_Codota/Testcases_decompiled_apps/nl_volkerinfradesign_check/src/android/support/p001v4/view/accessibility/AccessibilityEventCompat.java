package android.support.p001v4.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.accessibility.AccessibilityEventCompat */
public class AccessibilityEventCompat {
    public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
    public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
    public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
    public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_GESTURE_DETECTION_END = 524288;
    public static final int TYPE_GESTURE_DETECTION_START = 262144;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
    public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    public static final int TYPE_VIEW_HOVER_ENTER = 128;
    public static final int TYPE_VIEW_HOVER_EXIT = 256;
    public static final int TYPE_VIEW_SCROLLED = 4096;
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;

    /* renamed from: a */
    private static final C0359d f1078a;

    /* renamed from: android.support.v4.view.accessibility.AccessibilityEventCompat$d */
    interface C0359d {
        /* renamed from: a */
        int mo2194a(AccessibilityEvent accessibilityEvent);

        /* renamed from: a */
        Object mo2195a(AccessibilityEvent accessibilityEvent, int i);

        /* renamed from: a */
        void mo2196a(AccessibilityEvent accessibilityEvent, Object obj);

        /* renamed from: b */
        int mo2197b(AccessibilityEvent accessibilityEvent);

        /* renamed from: b */
        void mo2198b(AccessibilityEvent accessibilityEvent, int i);
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityEventCompat$c */
    static class C0358c implements C0359d {
        C0358c() {
        }

        /* renamed from: a */
        public void mo2196a(AccessibilityEvent accessibilityEvent, Object obj) {
        }

        /* renamed from: a */
        public Object mo2195a(AccessibilityEvent accessibilityEvent, int i) {
            return null;
        }

        /* renamed from: b */
        public void mo2198b(AccessibilityEvent accessibilityEvent, int i) {
        }

        /* renamed from: a */
        public int mo2194a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        /* renamed from: b */
        public int mo2197b(AccessibilityEvent accessibilityEvent) {
            return 0;
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityEventCompat$a */
    static class C0356a extends C0358c {
        C0356a() {
        }

        /* renamed from: a */
        public void mo2196a(AccessibilityEvent accessibilityEvent, Object obj) {
            C1077eh.m4818a(accessibilityEvent, obj);
        }

        /* renamed from: a */
        public Object mo2195a(AccessibilityEvent accessibilityEvent, int i) {
            return C1077eh.m4817a(accessibilityEvent, i);
        }

        /* renamed from: a */
        public int mo2194a(AccessibilityEvent accessibilityEvent) {
            return C1077eh.m4816a(accessibilityEvent);
        }
    }

    /* renamed from: android.support.v4.view.accessibility.AccessibilityEventCompat$b */
    static class C0357b extends C0356a {
        C0357b() {
        }

        /* renamed from: b */
        public void mo2198b(AccessibilityEvent accessibilityEvent, int i) {
            C1078ei.m4820a(accessibilityEvent, i);
        }

        /* renamed from: b */
        public int mo2197b(AccessibilityEvent accessibilityEvent) {
            return C1078ei.m4819a(accessibilityEvent);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f1078a = new C0357b();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f1078a = new C0356a();
        } else {
            f1078a = new C0358c();
        }
    }

    private AccessibilityEventCompat() {
    }

    public static int getRecordCount(AccessibilityEvent accessibilityEvent) {
        return f1078a.mo2194a(accessibilityEvent);
    }

    public static void appendRecord(AccessibilityEvent accessibilityEvent, AccessibilityRecordCompat accessibilityRecordCompat) {
        f1078a.mo2196a(accessibilityEvent, accessibilityRecordCompat.getImpl());
    }

    public static AccessibilityRecordCompat getRecord(AccessibilityEvent accessibilityEvent, int i) {
        return new AccessibilityRecordCompat(f1078a.mo2195a(accessibilityEvent, i));
    }

    public static AccessibilityRecordCompat asRecord(AccessibilityEvent accessibilityEvent) {
        return new AccessibilityRecordCompat(accessibilityEvent);
    }

    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i) {
        f1078a.mo2198b(accessibilityEvent, i);
    }

    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        return f1078a.mo2197b(accessibilityEvent);
    }
}
