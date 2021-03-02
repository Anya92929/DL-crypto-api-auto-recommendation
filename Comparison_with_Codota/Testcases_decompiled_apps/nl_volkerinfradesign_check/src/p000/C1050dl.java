package p000;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: dl */
public class C1050dl {
    /* renamed from: a */
    public static boolean m4695a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    /* renamed from: b */
    public static boolean m4698b(View view, int i) {
        return view.canScrollVertically(i);
    }

    /* renamed from: a */
    public static void m4693a(View view, @Nullable Object obj) {
        view.setAccessibilityDelegate((View.AccessibilityDelegate) obj);
    }

    /* renamed from: a */
    public static void m4692a(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* renamed from: b */
    public static void m4696b(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    /* renamed from: b */
    public static void m4697b(View view, Object obj) {
        view.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo) obj);
    }

    /* renamed from: a */
    public static void m4694a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }
}
