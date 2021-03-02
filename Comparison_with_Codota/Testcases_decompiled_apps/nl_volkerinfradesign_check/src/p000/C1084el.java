package p000;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: el */
public class C1084el {
    /* renamed from: a */
    public static Object m4844a(Object obj) {
        return ((AccessibilityNodeInfo) obj).getTraversalBefore();
    }

    /* renamed from: a */
    public static void m4845a(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setTraversalBefore(view);
    }

    /* renamed from: a */
    public static void m4846a(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).setTraversalBefore(view, i);
    }

    /* renamed from: b */
    public static Object m4847b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getTraversalAfter();
    }

    /* renamed from: b */
    public static void m4848b(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setTraversalAfter(view);
    }

    /* renamed from: b */
    public static void m4849b(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).setTraversalAfter(view, i);
    }
}
