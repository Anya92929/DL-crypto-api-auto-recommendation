package android.support.p000v4.view;

import android.view.View;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.ViewPropertyAnimatorCompatJellybeanMr2 */
class ViewPropertyAnimatorCompatJellybeanMr2 {
    ViewPropertyAnimatorCompatJellybeanMr2() {
    }

    public static Interpolator getInterpolator(View view) {
        return (Interpolator) view.animate().getInterpolator();
    }
}
