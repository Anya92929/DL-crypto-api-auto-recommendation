package p000;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/* renamed from: ep */
public class C1088ep {
    /* renamed from: a */
    public static void m4918a(Object obj, String str) {
        ((AccessibilityNodeInfo) obj).setViewIdResourceName(str);
    }

    /* renamed from: a */
    public static String m4916a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getViewIdResourceName();
    }

    /* renamed from: b */
    public static List<Object> m4921b(Object obj, String str) {
        return ((AccessibilityNodeInfo) obj).findAccessibilityNodeInfosByViewId(str);
    }

    /* renamed from: a */
    public static void m4917a(Object obj, int i, int i2) {
        ((AccessibilityNodeInfo) obj).setTextSelection(i, i2);
    }

    /* renamed from: b */
    public static int m4920b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getTextSelectionStart();
    }

    /* renamed from: c */
    public static int m4922c(Object obj) {
        return ((AccessibilityNodeInfo) obj).getTextSelectionEnd();
    }

    /* renamed from: d */
    public static boolean m4923d(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEditable();
    }

    /* renamed from: a */
    public static void m4919a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setEditable(z);
    }

    /* renamed from: e */
    public static boolean m4924e(Object obj) {
        return ((AccessibilityNodeInfo) obj).refresh();
    }
}
