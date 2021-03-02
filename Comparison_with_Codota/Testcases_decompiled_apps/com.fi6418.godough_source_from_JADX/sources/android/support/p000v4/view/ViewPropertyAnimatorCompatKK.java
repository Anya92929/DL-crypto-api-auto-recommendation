package android.support.p000v4.view;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: android.support.v4.view.ViewPropertyAnimatorCompatKK */
class ViewPropertyAnimatorCompatKK {
    ViewPropertyAnimatorCompatKK() {
    }

    public static void setUpdateListener(final View view, final ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        view.animate().setUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPropertyAnimatorUpdateListener.this.onAnimationUpdate(view);
            }
        });
    }
}
