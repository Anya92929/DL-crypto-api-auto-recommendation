package cmn;

import android.content.Context;

/* renamed from: cmn.ad */
public final class C0709ad {

    /* renamed from: a */
    private static float f1748a = 1.0f;

    /* renamed from: a */
    public static float m3186a(float f) {
        return f1748a * f;
    }

    /* renamed from: a */
    public static void m3187a(Context context) {
        if (context.getResources() != null) {
            f1748a = context.getResources().getDisplayMetrics().density;
        }
    }

    /* renamed from: b */
    public static int m3188b(float f) {
        int round = Math.round(f1748a * f);
        if (round != 0) {
            return round;
        }
        if (f > 0.0f) {
            return 1;
        }
        if (f < 0.0f) {
            return -1;
        }
        return round;
    }
}
