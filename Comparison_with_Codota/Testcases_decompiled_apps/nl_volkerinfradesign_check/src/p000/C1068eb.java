package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.p001v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.view.animation.Interpolator;

/* renamed from: eb */
public class C1068eb {
    /* renamed from: a */
    public static void m4779a(View view, long j) {
        view.animate().setDuration(j);
    }

    /* renamed from: a */
    public static void m4778a(View view, float f) {
        view.animate().alpha(f);
    }

    /* renamed from: b */
    public static void m4783b(View view, float f) {
        view.animate().translationX(f);
    }

    /* renamed from: c */
    public static void m4786c(View view, float f) {
        view.animate().translationY(f);
    }

    /* renamed from: a */
    public static long m4777a(View view) {
        return view.animate().getDuration();
    }

    /* renamed from: a */
    public static void m4781a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    /* renamed from: b */
    public static void m4784b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    /* renamed from: b */
    public static long m4782b(View view) {
        return view.animate().getStartDelay();
    }

    /* renamed from: d */
    public static void m4788d(View view, float f) {
        view.animate().alphaBy(f);
    }

    /* renamed from: e */
    public static void m4789e(View view, float f) {
        view.animate().rotation(f);
    }

    /* renamed from: f */
    public static void m4790f(View view, float f) {
        view.animate().rotationBy(f);
    }

    /* renamed from: g */
    public static void m4791g(View view, float f) {
        view.animate().rotationX(f);
    }

    /* renamed from: h */
    public static void m4792h(View view, float f) {
        view.animate().rotationXBy(f);
    }

    /* renamed from: i */
    public static void m4793i(View view, float f) {
        view.animate().rotationY(f);
    }

    /* renamed from: j */
    public static void m4794j(View view, float f) {
        view.animate().rotationYBy(f);
    }

    /* renamed from: k */
    public static void m4795k(View view, float f) {
        view.animate().scaleX(f);
    }

    /* renamed from: l */
    public static void m4796l(View view, float f) {
        view.animate().scaleXBy(f);
    }

    /* renamed from: m */
    public static void m4797m(View view, float f) {
        view.animate().scaleY(f);
    }

    /* renamed from: n */
    public static void m4798n(View view, float f) {
        view.animate().scaleYBy(f);
    }

    /* renamed from: c */
    public static void m4785c(View view) {
        view.animate().cancel();
    }

    /* renamed from: o */
    public static void m4799o(View view, float f) {
        view.animate().x(f);
    }

    /* renamed from: p */
    public static void m4800p(View view, float f) {
        view.animate().xBy(f);
    }

    /* renamed from: q */
    public static void m4801q(View view, float f) {
        view.animate().y(f);
    }

    /* renamed from: r */
    public static void m4802r(View view, float f) {
        view.animate().yBy(f);
    }

    /* renamed from: s */
    public static void m4803s(View view, float f) {
        view.animate().translationXBy(f);
    }

    /* renamed from: t */
    public static void m4804t(View view, float f) {
        view.animate().translationYBy(f);
    }

    /* renamed from: d */
    public static void m4787d(View view) {
        view.animate().start();
    }

    /* renamed from: a */
    public static void m4780a(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }

                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationEnd(view);
                }

                public void onAnimationStart(Animator animator) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }
}
