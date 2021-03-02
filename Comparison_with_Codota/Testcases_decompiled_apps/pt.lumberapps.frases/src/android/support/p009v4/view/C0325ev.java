package android.support.p009v4.view;

import android.animation.Animator;
import android.view.View;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.ev */
class C0325ev {
    /* renamed from: a */
    public static long m1251a(View view) {
        return view.animate().getDuration();
    }

    /* renamed from: a */
    public static void m1252a(View view, float f) {
        view.animate().alpha(f);
    }

    /* renamed from: a */
    public static void m1253a(View view, long j) {
        view.animate().setDuration(j);
    }

    /* renamed from: a */
    public static void m1254a(View view, C0332fb fbVar) {
        if (fbVar != null) {
            view.animate().setListener(new C0326ew(fbVar, view));
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    /* renamed from: a */
    public static void m1255a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    /* renamed from: b */
    public static void m1256b(View view, float f) {
        view.animate().translationY(f);
    }

    /* renamed from: b */
    public static void m1257b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void cancel(View view) {
        view.animate().cancel();
    }

    public static void start(View view) {
        view.animate().start();
    }
}
