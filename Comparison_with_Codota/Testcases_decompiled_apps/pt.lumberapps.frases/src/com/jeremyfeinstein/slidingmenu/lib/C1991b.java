package com.jeremyfeinstein.slidingmenu.lib;

import android.view.animation.Interpolator;

/* renamed from: com.jeremyfeinstein.slidingmenu.lib.b */
final class C1991b implements Interpolator {
    C1991b() {
    }

    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
