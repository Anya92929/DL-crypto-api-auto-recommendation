package android.support.p009v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

/* renamed from: android.support.v4.widget.ak */
class C0368ak {
    /* renamed from: a */
    public static Object m1522a(Context context) {
        return new EdgeEffect(context);
    }

    /* renamed from: a */
    public static void m1523a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    /* renamed from: a */
    public static boolean m1524a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    /* renamed from: a */
    public static boolean m1525a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    /* renamed from: a */
    public static boolean m1526a(Object obj, int i) {
        ((EdgeEffect) obj).onAbsorb(i);
        return true;
    }

    /* renamed from: a */
    public static boolean m1527a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }

    /* renamed from: b */
    public static void m1528b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    /* renamed from: c */
    public static boolean m1529c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }
}
