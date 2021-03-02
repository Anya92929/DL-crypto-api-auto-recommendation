package p000;

import android.animation.ValueAnimator;
import android.support.p001v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;

/* renamed from: ee */
public class C1073ee {
    /* renamed from: a */
    public static void m4810a(final View view, final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        C10741 r0 = null;
        if (viewPropertyAnimatorUpdateListener != null) {
            r0 = new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    viewPropertyAnimatorUpdateListener.onAnimationUpdate(view);
                }
            };
        }
        view.animate().setUpdateListener(r0);
    }
}
