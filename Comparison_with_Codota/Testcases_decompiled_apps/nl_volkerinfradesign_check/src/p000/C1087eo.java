package p000;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: eo */
public class C1087eo {
    /* renamed from: a */
    public static void m4911a(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setLabelFor(view);
    }

    /* renamed from: a */
    public static void m4912a(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).setLabelFor(view, i);
    }

    /* renamed from: a */
    public static Object m4910a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getLabelFor();
    }

    /* renamed from: b */
    public static void m4914b(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setLabeledBy(view);
    }

    /* renamed from: b */
    public static void m4915b(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).setLabeledBy(view, i);
    }

    /* renamed from: b */
    public static Object m4913b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getLabeledBy();
    }
}
