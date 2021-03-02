package p000;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

/* renamed from: fi */
public class C1118fi {
    /* renamed from: a */
    public static Object m5056a(Context context) {
        return new EdgeEffect(context);
    }

    /* renamed from: a */
    public static void m5057a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    /* renamed from: a */
    public static boolean m5058a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    /* renamed from: b */
    public static void m5062b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    /* renamed from: a */
    public static boolean m5059a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    /* renamed from: c */
    public static boolean m5063c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    /* renamed from: a */
    public static boolean m5060a(Object obj, int i) {
        ((EdgeEffect) obj).onAbsorb(i);
        return true;
    }

    /* renamed from: a */
    public static boolean m5061a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}
