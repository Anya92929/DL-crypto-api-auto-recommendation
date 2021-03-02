package p000;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* renamed from: ey */
public class C1104ey {
    /* renamed from: a */
    public static Interpolator m5029a(Path path) {
        return new PathInterpolator(path);
    }

    /* renamed from: a */
    public static Interpolator m5027a(float f, float f2) {
        return new PathInterpolator(f, f2);
    }

    /* renamed from: a */
    public static Interpolator m5028a(float f, float f2, float f3, float f4) {
        return new PathInterpolator(f, f2, f3, f4);
    }
}
