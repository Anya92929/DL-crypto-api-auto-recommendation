package android.support.p009v4.view;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.dq */
final class C0293dq implements Interpolator {
    C0293dq() {
    }

    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
