package android.support.p001v4.view;

import android.os.Build;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v4.view.MotionEventCompat */
public class MotionEventCompat {
    public static final int ACTION_HOVER_ENTER = 9;
    public static final int ACTION_HOVER_EXIT = 10;
    public static final int ACTION_HOVER_MOVE = 7;
    public static final int ACTION_MASK = 255;
    public static final int ACTION_POINTER_DOWN = 5;
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static final int ACTION_SCROLL = 8;
    public static final int AXIS_BRAKE = 23;
    public static final int AXIS_DISTANCE = 24;
    public static final int AXIS_GAS = 22;
    public static final int AXIS_GENERIC_1 = 32;
    public static final int AXIS_GENERIC_10 = 41;
    public static final int AXIS_GENERIC_11 = 42;
    public static final int AXIS_GENERIC_12 = 43;
    public static final int AXIS_GENERIC_13 = 44;
    public static final int AXIS_GENERIC_14 = 45;
    public static final int AXIS_GENERIC_15 = 46;
    public static final int AXIS_GENERIC_16 = 47;
    public static final int AXIS_GENERIC_2 = 33;
    public static final int AXIS_GENERIC_3 = 34;
    public static final int AXIS_GENERIC_4 = 35;
    public static final int AXIS_GENERIC_5 = 36;
    public static final int AXIS_GENERIC_6 = 37;
    public static final int AXIS_GENERIC_7 = 38;
    public static final int AXIS_GENERIC_8 = 39;
    public static final int AXIS_GENERIC_9 = 40;
    public static final int AXIS_HAT_X = 15;
    public static final int AXIS_HAT_Y = 16;
    public static final int AXIS_HSCROLL = 10;
    public static final int AXIS_LTRIGGER = 17;
    public static final int AXIS_ORIENTATION = 8;
    public static final int AXIS_PRESSURE = 2;
    public static final int AXIS_RTRIGGER = 18;
    public static final int AXIS_RUDDER = 20;
    public static final int AXIS_RX = 12;
    public static final int AXIS_RY = 13;
    public static final int AXIS_RZ = 14;
    public static final int AXIS_SIZE = 3;
    public static final int AXIS_THROTTLE = 19;
    public static final int AXIS_TILT = 25;
    public static final int AXIS_TOOL_MAJOR = 6;
    public static final int AXIS_TOOL_MINOR = 7;
    public static final int AXIS_TOUCH_MAJOR = 4;
    public static final int AXIS_TOUCH_MINOR = 5;
    public static final int AXIS_VSCROLL = 9;
    public static final int AXIS_WHEEL = 21;
    public static final int AXIS_X = 0;
    public static final int AXIS_Y = 1;
    public static final int AXIS_Z = 11;

    /* renamed from: a */
    static final C0292e f935a;

    /* renamed from: android.support.v4.view.MotionEventCompat$e */
    interface C0292e {
        /* renamed from: a */
        float mo1790a(MotionEvent motionEvent, int i, int i2);

        /* renamed from: a */
        int mo1791a(MotionEvent motionEvent);

        /* renamed from: a */
        int mo1792a(MotionEvent motionEvent, int i);

        /* renamed from: b */
        int mo1793b(MotionEvent motionEvent);

        /* renamed from: b */
        int mo1794b(MotionEvent motionEvent, int i);

        /* renamed from: c */
        float mo1795c(MotionEvent motionEvent, int i);

        /* renamed from: d */
        float mo1796d(MotionEvent motionEvent, int i);

        /* renamed from: e */
        float mo1797e(MotionEvent motionEvent, int i);
    }

    /* renamed from: android.support.v4.view.MotionEventCompat$a */
    static class C0288a implements C0292e {
        C0288a() {
        }

        /* renamed from: a */
        public int mo1792a(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            return -1;
        }

        /* renamed from: b */
        public int mo1794b(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        /* renamed from: c */
        public float mo1795c(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        /* renamed from: d */
        public float mo1796d(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        /* renamed from: a */
        public int mo1791a(MotionEvent motionEvent) {
            return 1;
        }

        /* renamed from: b */
        public int mo1793b(MotionEvent motionEvent) {
            return 0;
        }

        /* renamed from: e */
        public float mo1797e(MotionEvent motionEvent, int i) {
            return BitmapDescriptorFactory.HUE_RED;
        }

        /* renamed from: a */
        public float mo1790a(MotionEvent motionEvent, int i, int i2) {
            return BitmapDescriptorFactory.HUE_RED;
        }
    }

    /* renamed from: android.support.v4.view.MotionEventCompat$b */
    static class C0289b extends C0288a {
        C0289b() {
        }

        /* renamed from: a */
        public int mo1792a(MotionEvent motionEvent, int i) {
            return C1039db.m4633a(motionEvent, i);
        }

        /* renamed from: b */
        public int mo1794b(MotionEvent motionEvent, int i) {
            return C1039db.m4634b(motionEvent, i);
        }

        /* renamed from: c */
        public float mo1795c(MotionEvent motionEvent, int i) {
            return C1039db.m4635c(motionEvent, i);
        }

        /* renamed from: d */
        public float mo1796d(MotionEvent motionEvent, int i) {
            return C1039db.m4636d(motionEvent, i);
        }

        /* renamed from: a */
        public int mo1791a(MotionEvent motionEvent) {
            return C1039db.m4632a(motionEvent);
        }
    }

    /* renamed from: android.support.v4.view.MotionEventCompat$c */
    static class C0290c extends C0289b {
        C0290c() {
        }

        /* renamed from: b */
        public int mo1793b(MotionEvent motionEvent) {
            return C1040dc.m4637a(motionEvent);
        }
    }

    /* renamed from: android.support.v4.view.MotionEventCompat$d */
    static class C0291d extends C0290c {
        C0291d() {
        }

        /* renamed from: e */
        public float mo1797e(MotionEvent motionEvent, int i) {
            return C1041dd.m4638a(motionEvent, i);
        }

        /* renamed from: a */
        public float mo1790a(MotionEvent motionEvent, int i, int i2) {
            return C1041dd.m4639a(motionEvent, i, i2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            f935a = new C0291d();
        } else if (Build.VERSION.SDK_INT >= 9) {
            f935a = new C0290c();
        } else if (Build.VERSION.SDK_INT >= 5) {
            f935a = new C0289b();
        } else {
            f935a = new C0288a();
        }
    }

    public static int getActionMasked(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int getActionIndex(MotionEvent motionEvent) {
        return (motionEvent.getAction() & ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static int findPointerIndex(MotionEvent motionEvent, int i) {
        return f935a.mo1792a(motionEvent, i);
    }

    public static int getPointerId(MotionEvent motionEvent, int i) {
        return f935a.mo1794b(motionEvent, i);
    }

    public static float getX(MotionEvent motionEvent, int i) {
        return f935a.mo1795c(motionEvent, i);
    }

    public static float getY(MotionEvent motionEvent, int i) {
        return f935a.mo1796d(motionEvent, i);
    }

    public static int getPointerCount(MotionEvent motionEvent) {
        return f935a.mo1791a(motionEvent);
    }

    public static int getSource(MotionEvent motionEvent) {
        return f935a.mo1793b(motionEvent);
    }

    public static float getAxisValue(MotionEvent motionEvent, int i) {
        return f935a.mo1797e(motionEvent, i);
    }

    public static float getAxisValue(MotionEvent motionEvent, int i, int i2) {
        return f935a.mo1790a(motionEvent, i, i2);
    }
}
