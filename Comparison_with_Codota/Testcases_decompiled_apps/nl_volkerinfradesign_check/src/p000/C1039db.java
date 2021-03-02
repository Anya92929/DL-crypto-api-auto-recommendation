package p000;

import android.view.MotionEvent;

/* renamed from: db */
public class C1039db {
    /* renamed from: a */
    public static int m4633a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    /* renamed from: b */
    public static int m4634b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    /* renamed from: c */
    public static float m4635c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    /* renamed from: d */
    public static float m4636d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    /* renamed from: a */
    public static int m4632a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
}
