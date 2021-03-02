package android.support.p009v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.view.cq */
class C0266cq {
    /* renamed from: a */
    public static int m1074a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    /* renamed from: a */
    public static int m1075a(View view) {
        return view.getLayerType();
    }

    /* renamed from: a */
    static long m1076a() {
        return ValueAnimator.getFrameDelay();
    }

    /* renamed from: a */
    public static void m1077a(View view, float f) {
        view.setTranslationY(f);
    }

    /* renamed from: a */
    static void m1078a(View view, int i) {
        view.offsetTopAndBottom(i);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m1087e((View) parent);
        }
    }

    /* renamed from: a */
    public static void m1079a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    /* renamed from: a */
    public static void m1080a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    /* renamed from: b */
    public static int m1081b(View view) {
        return view.getMeasuredWidthAndState();
    }

    /* renamed from: b */
    public static void m1082b(View view, float f) {
        view.setAlpha(f);
    }

    /* renamed from: b */
    static void m1083b(View view, int i) {
        view.offsetLeftAndRight(i);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m1087e((View) parent);
        }
    }

    /* renamed from: b */
    public static void m1084b(View view, boolean z) {
        view.setActivated(z);
    }

    /* renamed from: c */
    public static int m1085c(View view) {
        return view.getMeasuredState();
    }

    /* renamed from: d */
    public static float m1086d(View view) {
        return view.getTranslationY();
    }

    /* renamed from: e */
    private static void m1087e(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }
}
