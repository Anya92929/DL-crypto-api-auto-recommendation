package android.support.p009v4.view.p020a;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.a.a */
public final class C0153a {

    /* renamed from: a */
    private static final C0174e f302a;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f302a = new C0172c();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f302a = new C0171b();
        } else {
            f302a = new C0173d();
        }
    }

    /* renamed from: a */
    public static C0163aj m459a(AccessibilityEvent accessibilityEvent) {
        return new C0163aj(accessibilityEvent);
    }
}
