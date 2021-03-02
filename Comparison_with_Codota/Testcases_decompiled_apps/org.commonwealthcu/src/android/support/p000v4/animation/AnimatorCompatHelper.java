package android.support.p000v4.animation;

import android.os.Build;

/* renamed from: android.support.v4.animation.AnimatorCompatHelper */
public abstract class AnimatorCompatHelper {
    static AnimatorProvider IMPL;

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            IMPL = new HoneycombMr1AnimatorCompatProvider();
        } else {
            IMPL = new DonutAnimatorCompatProvider();
        }
    }

    AnimatorCompatHelper() {
    }

    public static ValueAnimatorCompat emptyValueAnimator() {
        return IMPL.emptyValueAnimator();
    }
}
