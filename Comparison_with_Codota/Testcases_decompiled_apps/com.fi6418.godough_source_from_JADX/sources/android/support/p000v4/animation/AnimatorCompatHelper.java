package android.support.p000v4.animation;

import android.os.Build;
import android.view.View;

/* renamed from: android.support.v4.animation.AnimatorCompatHelper */
public abstract class AnimatorCompatHelper {

    /* renamed from: a */
    static AnimatorProvider f239a;

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            f239a = new HoneycombMr1AnimatorCompatProvider();
        } else {
            f239a = new DonutAnimatorCompatProvider();
        }
    }

    AnimatorCompatHelper() {
    }

    public static void clearInterpolator(View view) {
        f239a.clearInterpolator(view);
    }

    public static ValueAnimatorCompat emptyValueAnimator() {
        return f239a.emptyValueAnimator();
    }
}
