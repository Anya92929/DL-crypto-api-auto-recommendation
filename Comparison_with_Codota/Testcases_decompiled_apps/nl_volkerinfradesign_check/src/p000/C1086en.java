package p000;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: en */
public class C1086en {
    /* renamed from: a */
    public static void m4899a(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).addChild(view, i);
    }

    /* renamed from: b */
    public static void m4905b(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).setSource(view, i);
    }

    /* renamed from: a */
    public static boolean m4901a(Object obj) {
        return ((AccessibilityNodeInfo) obj).isVisibleToUser();
    }

    /* renamed from: a */
    public static void m4900a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setVisibleToUser(z);
    }

    /* renamed from: a */
    public static boolean m4902a(Object obj, int i, Bundle bundle) {
        return ((AccessibilityNodeInfo) obj).performAction(i, bundle);
    }

    /* renamed from: a */
    public static void m4898a(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).setMovementGranularities(i);
    }

    /* renamed from: b */
    public static int m4903b(Object obj) {
        return ((AccessibilityNodeInfo) obj).getMovementGranularities();
    }

    /* renamed from: a */
    public static Object m4897a(View view, int i) {
        return AccessibilityNodeInfo.obtain(view, i);
    }

    /* renamed from: b */
    public static Object m4904b(Object obj, int i) {
        return ((AccessibilityNodeInfo) obj).findFocus(i);
    }

    /* renamed from: c */
    public static Object m4907c(Object obj, int i) {
        return ((AccessibilityNodeInfo) obj).focusSearch(i);
    }

    /* renamed from: c */
    public static void m4908c(Object obj, View view, int i) {
        ((AccessibilityNodeInfo) obj).setParent(view, i);
    }

    /* renamed from: c */
    public static boolean m4909c(Object obj) {
        return ((AccessibilityNodeInfo) obj).isAccessibilityFocused();
    }

    /* renamed from: b */
    public static void m4906b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setAccessibilityFocused(z);
    }
}
