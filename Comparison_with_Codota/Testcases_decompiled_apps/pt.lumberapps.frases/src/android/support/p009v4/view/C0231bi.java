package android.support.p009v4.view;

import android.view.MotionEvent;

/* renamed from: android.support.v4.view.bi */
class C0231bi {
    /* renamed from: a */
    public static int m858a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    /* renamed from: a */
    public static int m859a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    /* renamed from: b */
    public static int m860b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    /* renamed from: c */
    public static float m861c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    /* renamed from: d */
    public static float m862d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
