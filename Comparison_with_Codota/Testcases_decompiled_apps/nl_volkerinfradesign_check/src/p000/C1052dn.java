package p000;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

/* renamed from: dn */
public class C1052dn {
    /* renamed from: a */
    public static boolean m4705a(View view) {
        return view.hasTransientState();
    }

    /* renamed from: a */
    public static void m4704a(View view, boolean z) {
        view.setHasTransientState(z);
    }

    /* renamed from: b */
    public static void m4707b(View view) {
        view.postInvalidateOnAnimation();
    }

    /* renamed from: a */
    public static void m4701a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    /* renamed from: a */
    public static void m4702a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    /* renamed from: a */
    public static void m4703a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    /* renamed from: c */
    public static int m4708c(View view) {
        return view.getImportantForAccessibility();
    }

    /* renamed from: a */
    public static void m4700a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    /* renamed from: a */
    public static boolean m4706a(View view, int i, Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    /* renamed from: d */
    public static Object m4709d(View view) {
        return view.getAccessibilityNodeProvider();
    }

    /* renamed from: e */
    public static ViewParent m4710e(View view) {
        return view.getParentForAccessibility();
    }

    /* renamed from: f */
    public static int m4711f(View view) {
        return view.getMinimumWidth();
    }

    /* renamed from: g */
    public static int m4712g(View view) {
        return view.getMinimumHeight();
    }

    /* renamed from: h */
    public static void m4713h(View view) {
        view.requestFitSystemWindows();
    }

    /* renamed from: i */
    public static boolean m4714i(View view) {
        return view.getFitsSystemWindows();
    }

    /* renamed from: j */
    public static boolean m4715j(View view) {
        return view.hasOverlappingRendering();
    }
}
