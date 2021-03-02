package p000;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityWindowInfo;

/* renamed from: ew */
public class C1102ew {
    /* renamed from: a */
    public static Object m5013a() {
        return AccessibilityWindowInfo.obtain();
    }

    /* renamed from: a */
    public static Object m5014a(Object obj) {
        return AccessibilityWindowInfo.obtain((AccessibilityWindowInfo) obj);
    }

    /* renamed from: b */
    public static int m5017b(Object obj) {
        return ((AccessibilityWindowInfo) obj).getType();
    }

    /* renamed from: c */
    public static int m5018c(Object obj) {
        return ((AccessibilityWindowInfo) obj).getLayer();
    }

    /* renamed from: d */
    public static Object m5019d(Object obj) {
        return ((AccessibilityWindowInfo) obj).getRoot();
    }

    /* renamed from: e */
    public static Object m5020e(Object obj) {
        return ((AccessibilityWindowInfo) obj).getParent();
    }

    /* renamed from: f */
    public static int m5021f(Object obj) {
        return ((AccessibilityWindowInfo) obj).getId();
    }

    /* renamed from: a */
    public static void m5016a(Object obj, Rect rect) {
        ((AccessibilityWindowInfo) obj).getBoundsInScreen(rect);
    }

    /* renamed from: g */
    public static boolean m5022g(Object obj) {
        return ((AccessibilityWindowInfo) obj).isActive();
    }

    /* renamed from: h */
    public static boolean m5023h(Object obj) {
        return ((AccessibilityWindowInfo) obj).isFocused();
    }

    /* renamed from: i */
    public static boolean m5024i(Object obj) {
        return ((AccessibilityWindowInfo) obj).isAccessibilityFocused();
    }

    /* renamed from: j */
    public static int m5025j(Object obj) {
        return ((AccessibilityWindowInfo) obj).getChildCount();
    }

    /* renamed from: a */
    public static Object m5015a(Object obj, int i) {
        return ((AccessibilityWindowInfo) obj).getChild(i);
    }

    /* renamed from: k */
    public static void m5026k(Object obj) {
        ((AccessibilityWindowInfo) obj).recycle();
    }
}
