package android.support.p009v4.view.p020a;

import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.view.a.q */
class C0186q {
    /* renamed from: a */
    static Object m700a(int i, CharSequence charSequence) {
        return new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
    }

    /* renamed from: a */
    public static boolean m701a(Object obj, Object obj2) {
        return ((AccessibilityNodeInfo) obj).removeAction((AccessibilityNodeInfo.AccessibilityAction) obj2);
    }
}
