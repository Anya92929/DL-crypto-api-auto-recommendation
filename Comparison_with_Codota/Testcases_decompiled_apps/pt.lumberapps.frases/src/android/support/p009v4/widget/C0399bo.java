package android.support.p009v4.widget;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.widget.bo */
final class C0399bo implements Interpolator {
    C0399bo() {
    }

    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
