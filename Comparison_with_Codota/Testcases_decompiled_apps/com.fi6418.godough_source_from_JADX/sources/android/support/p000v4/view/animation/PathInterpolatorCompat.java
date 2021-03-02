package android.support.p000v4.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.animation.PathInterpolatorCompat */
public class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator create(float f, float f2) {
        return Build.VERSION.SDK_INT >= 21 ? PathInterpolatorCompatApi21.create(f, f2) : PathInterpolatorCompatBase.create(f, f2);
    }

    public static Interpolator create(float f, float f2, float f3, float f4) {
        return Build.VERSION.SDK_INT >= 21 ? PathInterpolatorCompatApi21.create(f, f2, f3, f4) : PathInterpolatorCompatBase.create(f, f2, f3, f4);
    }

    public static Interpolator create(Path path) {
        return Build.VERSION.SDK_INT >= 21 ? PathInterpolatorCompatApi21.create(path) : PathInterpolatorCompatBase.create(path);
    }
}
