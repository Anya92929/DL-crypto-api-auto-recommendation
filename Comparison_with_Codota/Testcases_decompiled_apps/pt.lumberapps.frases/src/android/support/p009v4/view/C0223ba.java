package android.support.p009v4.view;

import android.os.Build;
import android.view.MotionEvent;

/* renamed from: android.support.v4.view.ba */
public final class C0223ba {

    /* renamed from: a */
    static final C0230bh f344a;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            f344a = new C0229bg();
        } else if (Build.VERSION.SDK_INT >= 12) {
            f344a = new C0228bf();
        } else if (Build.VERSION.SDK_INT >= 9) {
            f344a = new C0227be();
        } else if (Build.VERSION.SDK_INT >= 5) {
            f344a = new C0226bd();
        } else {
            f344a = new C0225bc();
        }
    }

    /* renamed from: a */
    public static int m828a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    /* renamed from: a */
    public static int m829a(MotionEvent motionEvent, int i) {
        return f344a.mo1414a(motionEvent, i);
    }

    /* renamed from: b */
    public static int m830b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    /* renamed from: b */
    public static int m831b(MotionEvent motionEvent, int i) {
        return f344a.mo1416b(motionEvent, i);
    }

    /* renamed from: c */
    public static float m832c(MotionEvent motionEvent, int i) {
        return f344a.mo1417c(motionEvent, i);
    }

    /* renamed from: c */
    public static int m833c(MotionEvent motionEvent) {
        return f344a.mo1413a(motionEvent);
    }

    /* renamed from: d */
    public static float m834d(MotionEvent motionEvent, int i) {
        return f344a.mo1418d(motionEvent, i);
    }

    /* renamed from: d */
    public static int m835d(MotionEvent motionEvent) {
        return f344a.mo1415b(motionEvent);
    }

    /* renamed from: e */
    public static float m836e(MotionEvent motionEvent, int i) {
        return f344a.mo1419e(motionEvent, i);
    }
}
