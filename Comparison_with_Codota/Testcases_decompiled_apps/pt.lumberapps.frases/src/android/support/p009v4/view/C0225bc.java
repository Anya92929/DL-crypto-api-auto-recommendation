package android.support.p009v4.view;

import android.view.MotionEvent;

/* renamed from: android.support.v4.view.bc */
class C0225bc implements C0230bh {
    C0225bc() {
    }

    /* renamed from: a */
    public int mo1413a(MotionEvent motionEvent) {
        return 1;
    }

    /* renamed from: a */
    public int mo1414a(MotionEvent motionEvent, int i) {
        return i == 0 ? 0 : -1;
    }

    /* renamed from: b */
    public int mo1415b(MotionEvent motionEvent) {
        return 0;
    }

    /* renamed from: b */
    public int mo1416b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    /* renamed from: c */
    public float mo1417c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    /* renamed from: d */
    public float mo1418d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    /* renamed from: e */
    public float mo1419e(MotionEvent motionEvent, int i) {
        return 0.0f;
    }
}
