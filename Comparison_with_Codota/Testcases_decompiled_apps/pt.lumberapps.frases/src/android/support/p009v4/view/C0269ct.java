package android.support.p009v4.view;

import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.ct */
class C0269ct {
    /* renamed from: a */
    public static int m1092a(View view) {
        return view.getImportantForAccessibility();
    }

    /* renamed from: a */
    public static void m1093a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    /* renamed from: a */
    public static void m1094a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    /* renamed from: a */
    public static void m1095a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    /* renamed from: b */
    public static ViewParent m1096b(View view) {
        return view.getParentForAccessibility();
    }

    /* renamed from: c */
    public static int m1097c(View view) {
        return view.getMinimumHeight();
    }

    /* renamed from: d */
    public static boolean m1098d(View view) {
        return view.getFitsSystemWindows();
    }

    /* renamed from: e */
    public static boolean m1099e(View view) {
        return view.hasOverlappingRendering();
    }

    public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void requestApplyInsets(View view) {
        view.requestFitSystemWindows();
    }
}
