package android.support.p001v4.animation;

import android.os.Build;
import android.view.View;

/* renamed from: android.support.v4.animation.AnimatorCompatHelper */
public abstract class AnimatorCompatHelper {

    /* renamed from: a */
    static C1106f f28a;

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            f28a = new C1184h();
        } else {
            f28a = new C1144g();
        }
    }

    public static ValueAnimatorCompat emptyValueAnimator() {
        return f28a.mo8099a();
    }

    AnimatorCompatHelper() {
    }

    public static void clearInterpolator(View view) {
        f28a.mo8100a(view);
    }
}
