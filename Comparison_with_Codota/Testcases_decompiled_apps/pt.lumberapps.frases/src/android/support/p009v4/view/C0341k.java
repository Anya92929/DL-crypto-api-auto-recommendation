package android.support.p009v4.view;

import android.os.Bundle;
import android.view.View;

/* renamed from: android.support.v4.view.k */
class C0341k {
    /* renamed from: a */
    public static Object m1309a(C0343m mVar) {
        return new C0342l(mVar);
    }

    /* renamed from: a */
    public static Object m1310a(Object obj, View view) {
        return ((View.AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    /* renamed from: a */
    public static boolean m1311a(Object obj, View view, int i, Bundle bundle) {
        return ((View.AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
