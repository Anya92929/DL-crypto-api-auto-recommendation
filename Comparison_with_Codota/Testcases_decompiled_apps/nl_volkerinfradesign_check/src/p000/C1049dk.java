package p000;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* renamed from: dk */
public class C1049dk {
    /* renamed from: a */
    public static long m4660a() {
        return ValueAnimator.getFrameDelay();
    }

    /* renamed from: a */
    public static float m4657a(View view) {
        return view.getAlpha();
    }

    /* renamed from: a */
    public static void m4662a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    /* renamed from: b */
    public static int m4664b(View view) {
        return view.getLayerType();
    }

    /* renamed from: a */
    public static int m4659a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    /* renamed from: c */
    public static int m4667c(View view) {
        return view.getMeasuredWidthAndState();
    }

    /* renamed from: d */
    public static int m4669d(View view) {
        return view.getMeasuredHeightAndState();
    }

    /* renamed from: e */
    public static int m4671e(View view) {
        return view.getMeasuredState();
    }

    /* renamed from: f */
    public static float m4673f(View view) {
        return view.getTranslationX();
    }

    /* renamed from: g */
    public static float m4675g(View view) {
        return view.getTranslationY();
    }

    /* renamed from: h */
    public static float m4677h(View view) {
        return view.getX();
    }

    /* renamed from: i */
    public static float m4679i(View view) {
        return view.getY();
    }

    /* renamed from: j */
    public static float m4681j(View view) {
        return view.getRotation();
    }

    /* renamed from: k */
    public static float m4683k(View view) {
        return view.getRotationX();
    }

    /* renamed from: l */
    public static float m4685l(View view) {
        return view.getRotationY();
    }

    /* renamed from: m */
    public static float m4687m(View view) {
        return view.getScaleX();
    }

    /* renamed from: n */
    public static float m4688n(View view) {
        return view.getScaleY();
    }

    /* renamed from: a */
    public static void m4661a(View view, float f) {
        view.setTranslationX(f);
    }

    /* renamed from: b */
    public static void m4665b(View view, float f) {
        view.setTranslationY(f);
    }

    /* renamed from: c */
    public static void m4668c(View view, float f) {
        view.setAlpha(f);
    }

    /* renamed from: d */
    public static void m4670d(View view, float f) {
        view.setX(f);
    }

    /* renamed from: e */
    public static void m4672e(View view, float f) {
        view.setY(f);
    }

    /* renamed from: f */
    public static void m4674f(View view, float f) {
        view.setRotation(f);
    }

    /* renamed from: g */
    public static void m4676g(View view, float f) {
        view.setRotationX(f);
    }

    /* renamed from: h */
    public static void m4678h(View view, float f) {
        view.setRotationY(f);
    }

    /* renamed from: i */
    public static void m4680i(View view, float f) {
        view.setScaleX(f);
    }

    /* renamed from: j */
    public static void m4682j(View view, float f) {
        view.setScaleY(f);
    }

    /* renamed from: k */
    public static void m4684k(View view, float f) {
        view.setPivotX(f);
    }

    /* renamed from: l */
    public static void m4686l(View view, float f) {
        view.setPivotY(f);
    }

    /* renamed from: o */
    public static float m4689o(View view) {
        return view.getPivotX();
    }

    /* renamed from: p */
    public static float m4690p(View view) {
        return view.getPivotY();
    }

    /* renamed from: q */
    public static void m4691q(View view) {
        view.jumpDrawablesToCurrentState();
    }

    /* renamed from: a */
    public static void m4663a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    /* renamed from: b */
    public static void m4666b(View view, boolean z) {
        view.setActivated(z);
    }

    /* renamed from: a */
    public static int m4658a(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }
}
