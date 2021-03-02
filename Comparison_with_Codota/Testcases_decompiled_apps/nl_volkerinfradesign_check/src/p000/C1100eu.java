package p000;

import android.view.accessibility.AccessibilityRecord;

/* renamed from: eu */
public class C1100eu {
    /* renamed from: a */
    public static int m5008a(Object obj) {
        return ((AccessibilityRecord) obj).getMaxScrollX();
    }

    /* renamed from: b */
    public static int m5010b(Object obj) {
        return ((AccessibilityRecord) obj).getMaxScrollY();
    }

    /* renamed from: a */
    public static void m5009a(Object obj, int i) {
        ((AccessibilityRecord) obj).setMaxScrollX(i);
    }

    /* renamed from: b */
    public static void m5011b(Object obj, int i) {
        ((AccessibilityRecord) obj).setMaxScrollY(i);
    }
}
