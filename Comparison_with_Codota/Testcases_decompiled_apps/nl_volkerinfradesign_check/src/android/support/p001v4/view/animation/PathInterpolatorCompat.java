package android.support.p001v4.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.animation.PathInterpolatorCompat */
public class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator create(Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C1104ey.m5029a(path);
        }
        return C1105ez.m5032a(path);
    }

    public static Interpolator create(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C1104ey.m5027a(f, f2);
        }
        return C1105ez.m5030a(f, f2);
    }

    public static Interpolator create(float f, float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C1104ey.m5028a(f, f2, f3, f4);
        }
        return C1105ez.m5031a(f, f2, f3, f4);
    }
}
