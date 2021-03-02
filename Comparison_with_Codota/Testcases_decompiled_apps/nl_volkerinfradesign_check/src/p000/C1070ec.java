package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.p001v4.view.ViewPropertyAnimatorListener;
import android.view.View;

/* renamed from: ec */
public class C1070ec {
    /* renamed from: a */
    public static void m4807a(View view, Runnable runnable) {
        view.animate().withStartAction(runnable);
    }

    /* renamed from: b */
    public static void m4808b(View view, Runnable runnable) {
        view.animate().withEndAction(runnable);
    }

    /* renamed from: a */
    public static void m4805a(View view) {
        view.animate().withLayer();
    }

    /* renamed from: a */
    public static void m4806a(final View view, final ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
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
