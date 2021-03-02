package android.support.p009v4.view.p020a;

import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.view.a.t */
class C0189t {
    /* renamed from: a */
    public static void m739a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setVisibleToUser(z);
    }

    /* renamed from: a */
    public static boolean m740a(Object obj) {
        return ((AccessibilityNodeInfo) obj).isVisibleToUser();
    }

    /* renamed from: b */
    public static void m741b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
    }

    /* renamed from: b */
    public static boolean m742b(Object obj) {
        return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
    }
}
