package android.support.design.widget;

import android.support.p000v4.view.animation.FastOutSlowInInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: android.support.design.widget.a */
class C0008a {

    /* renamed from: a */
    static final Interpolator f107a = new LinearInterpolator();

    /* renamed from: b */
    static final Interpolator f108b = new FastOutSlowInInterpolator();

    /* renamed from: c */
    static final Interpolator f109c = new DecelerateInterpolator();

    /* renamed from: a */
    static int m170a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
