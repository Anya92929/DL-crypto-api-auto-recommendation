package android.support.p001v4.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.view.GestureDetectorCompat */
public class GestureDetectorCompat {

    /* renamed from: a */
    private final C0265a f901a;

    /* renamed from: android.support.v4.view.GestureDetectorCompat$a */
    interface C0265a {
        /* renamed from: a */
        void mo1752a(GestureDetector.OnDoubleTapListener onDoubleTapListener);

        /* renamed from: a */
        void mo1753a(boolean z);

        /* renamed from: a */
        boolean mo1754a();

        /* renamed from: a */
        boolean mo1755a(MotionEvent motionEvent);
    }

    /* renamed from: android.support.v4.view.GestureDetectorCompat$b */
    static class C0266b implements C0265a {

        /* renamed from: e */
        private static final int f902e = ViewConfiguration.getLongPressTimeout();

        /* renamed from: f */
        private static final int f903f = ViewConfiguration.getTapTimeout();

        /* renamed from: g */
        private static final int f904g = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: a */
        private int f905a;

        /* renamed from: b */
        private int f906b;

        /* renamed from: c */
        private int f907c;

        /* renamed from: d */
        private int f908d;

        /* renamed from: h */
        private final Handler f909h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public final GestureDetector.OnGestureListener f910i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public GestureDetector.OnDoubleTapListener f911j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public boolean f912k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public boolean f913l;

        /* renamed from: m */
        private boolean f914m;

        /* renamed from: n */
        private boolean f915n;

        /* renamed from: o */
        private boolean f916o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public MotionEvent f917p;

        /* renamed from: q */
        private MotionEvent f918q;

        /* renamed from: r */
        private boolean f919r;

        /* renamed from: s */
        private float f920s;

        /* renamed from: t */
        private float f921t;

        /* renamed from: u */
        private float f922u;

        /* renamed from: v */
        private float f923v;

        /* renamed from: w */
        private boolean f924w;

        /* renamed from: x */
        private VelocityTracker f925x;

        /* renamed from: android.support.v4.view.GestureDetectorCompat$b$a */
        class C0267a extends Handler {
            C0267a() {
            }

            C0267a(Handler handler) {
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0266b.this.f910i.onShowPress(C0266b.this.f917p);
                        return;
                    case 2:
                        C0266b.this.m1059d();
                        return;
                    case 3:
                        if (C0266b.this.f911j == null) {
                            return;
                        }
                        if (!C0266b.this.f912k) {
                            C0266b.this.f911j.onSingleTapConfirmed(C0266b.this.f917p);
                            return;
                        } else {
                            boolean unused = C0266b.this.f913l = true;
                            return;
                        }
                    default:
                        throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        public C0266b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f909h = new C0267a(handler);
            } else {
                this.f909h = new C0267a();
            }
            this.f910i = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                mo1752a((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            m1051a(context);
        }

        /* renamed from: a */
        private void m1051a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f910i == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.f924w = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f907c = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f908d = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f905a = scaledTouchSlop * scaledTouchSlop;
                this.f906b = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        /* renamed from: a */
        public void mo1752a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f911j = onDoubleTapListener;
        }

        /* renamed from: a */
        public void mo1753a(boolean z) {
            this.f924w = z;
        }

        /* renamed from: a */
        public boolean mo1754a() {
            return this.f924w;
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0104  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo1755a(android.view.MotionEvent r14) {
            /*
                r13 = this;
                r6 = 0
                r12 = 2
                r11 = 3
                r8 = 1
                r3 = 0
                int r9 = r14.getAction()
                android.view.VelocityTracker r0 = r13.f925x
                if (r0 != 0) goto L_0x0013
                android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
                r13.f925x = r0
            L_0x0013:
                android.view.VelocityTracker r0 = r13.f925x
                r0.addMovement(r14)
                r0 = r9 & 255(0xff, float:3.57E-43)
                r1 = 6
                if (r0 != r1) goto L_0x0032
                r7 = r8
            L_0x001e:
                if (r7 == 0) goto L_0x0034
                int r0 = android.support.p001v4.view.MotionEventCompat.getActionIndex(r14)
            L_0x0024:
                int r4 = android.support.p001v4.view.MotionEventCompat.getPointerCount(r14)
                r5 = r3
                r1 = r6
                r2 = r6
            L_0x002b:
                if (r5 >= r4) goto L_0x0041
                if (r0 != r5) goto L_0x0036
            L_0x002f:
                int r5 = r5 + 1
                goto L_0x002b
            L_0x0032:
                r7 = r3
                goto L_0x001e
            L_0x0034:
                r0 = -1
                goto L_0x0024
            L_0x0036:
                float r10 = android.support.p001v4.view.MotionEventCompat.getX(r14, r5)
                float r2 = r2 + r10
                float r10 = android.support.p001v4.view.MotionEventCompat.getY(r14, r5)
                float r1 = r1 + r10
                goto L_0x002f
            L_0x0041:
                if (r7 == 0) goto L_0x004f
                int r0 = r4 + -1
            L_0x0045:
                float r5 = (float) r0
                float r2 = r2 / r5
                float r0 = (float) r0
                float r1 = r1 / r0
                r0 = r9 & 255(0xff, float:3.57E-43)
                switch(r0) {
                    case 0: goto L_0x00a8;
                    case 1: goto L_0x01b3;
                    case 2: goto L_0x013f;
                    case 3: goto L_0x0247;
                    case 4: goto L_0x004e;
                    case 5: goto L_0x0051;
                    case 6: goto L_0x005d;
                    default: goto L_0x004e;
                }
            L_0x004e:
                return r3
            L_0x004f:
                r0 = r4
                goto L_0x0045
            L_0x0051:
                r13.f920s = r2
                r13.f922u = r2
                r13.f921t = r1
                r13.f923v = r1
                r13.m1056c()
                goto L_0x004e
            L_0x005d:
                r13.f920s = r2
                r13.f922u = r2
                r13.f921t = r1
                r13.f923v = r1
                android.view.VelocityTracker r0 = r13.f925x
                r1 = 1000(0x3e8, float:1.401E-42)
                int r2 = r13.f908d
                float r2 = (float) r2
                r0.computeCurrentVelocity(r1, r2)
                int r1 = android.support.p001v4.view.MotionEventCompat.getActionIndex(r14)
                int r0 = android.support.p001v4.view.MotionEventCompat.getPointerId(r14, r1)
                android.view.VelocityTracker r2 = r13.f925x
                float r2 = android.support.p001v4.view.VelocityTrackerCompat.getXVelocity(r2, r0)
                android.view.VelocityTracker r5 = r13.f925x
                float r5 = android.support.p001v4.view.VelocityTrackerCompat.getYVelocity(r5, r0)
                r0 = r3
            L_0x0084:
                if (r0 >= r4) goto L_0x004e
                if (r0 != r1) goto L_0x008b
            L_0x0088:
                int r0 = r0 + 1
                goto L_0x0084
            L_0x008b:
                int r7 = android.support.p001v4.view.MotionEventCompat.getPointerId(r14, r0)
                android.view.VelocityTracker r8 = r13.f925x
                float r8 = android.support.p001v4.view.VelocityTrackerCompat.getXVelocity(r8, r7)
                float r8 = r8 * r2
                android.view.VelocityTracker r9 = r13.f925x
                float r7 = android.support.p001v4.view.VelocityTrackerCompat.getYVelocity(r9, r7)
                float r7 = r7 * r5
                float r7 = r7 + r8
                int r7 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r7 >= 0) goto L_0x0088
                android.view.VelocityTracker r0 = r13.f925x
                r0.clear()
                goto L_0x004e
            L_0x00a8:
                android.view.GestureDetector$OnDoubleTapListener r0 = r13.f911j
                if (r0 == 0) goto L_0x013d
                android.os.Handler r0 = r13.f909h
                boolean r0 = r0.hasMessages(r11)
                if (r0 == 0) goto L_0x00b9
                android.os.Handler r4 = r13.f909h
                r4.removeMessages(r11)
            L_0x00b9:
                android.view.MotionEvent r4 = r13.f917p
                if (r4 == 0) goto L_0x0135
                android.view.MotionEvent r4 = r13.f918q
                if (r4 == 0) goto L_0x0135
                if (r0 == 0) goto L_0x0135
                android.view.MotionEvent r0 = r13.f917p
                android.view.MotionEvent r4 = r13.f918q
                boolean r0 = r13.m1053a(r0, r4, r14)
                if (r0 == 0) goto L_0x0135
                r13.f919r = r8
                android.view.GestureDetector$OnDoubleTapListener r0 = r13.f911j
                android.view.MotionEvent r4 = r13.f917p
                boolean r0 = r0.onDoubleTap(r4)
                r0 = r0 | r3
                android.view.GestureDetector$OnDoubleTapListener r4 = r13.f911j
                boolean r4 = r4.onDoubleTapEvent(r14)
                r0 = r0 | r4
            L_0x00df:
                r13.f920s = r2
                r13.f922u = r2
                r13.f921t = r1
                r13.f923v = r1
                android.view.MotionEvent r1 = r13.f917p
                if (r1 == 0) goto L_0x00f0
                android.view.MotionEvent r1 = r13.f917p
                r1.recycle()
            L_0x00f0:
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r14)
                r13.f917p = r1
                r13.f915n = r8
                r13.f916o = r8
                r13.f912k = r8
                r13.f914m = r3
                r13.f913l = r3
                boolean r1 = r13.f924w
                if (r1 == 0) goto L_0x011c
                android.os.Handler r1 = r13.f909h
                r1.removeMessages(r12)
                android.os.Handler r1 = r13.f909h
                android.view.MotionEvent r2 = r13.f917p
                long r2 = r2.getDownTime()
                int r4 = f903f
                long r4 = (long) r4
                long r2 = r2 + r4
                int r4 = f902e
                long r4 = (long) r4
                long r2 = r2 + r4
                r1.sendEmptyMessageAtTime(r12, r2)
            L_0x011c:
                android.os.Handler r1 = r13.f909h
                android.view.MotionEvent r2 = r13.f917p
                long r2 = r2.getDownTime()
                int r4 = f903f
                long r4 = (long) r4
                long r2 = r2 + r4
                r1.sendEmptyMessageAtTime(r8, r2)
                android.view.GestureDetector$OnGestureListener r1 = r13.f910i
                boolean r1 = r1.onDown(r14)
                r3 = r0 | r1
                goto L_0x004e
            L_0x0135:
                android.os.Handler r0 = r13.f909h
                int r4 = f904g
                long r4 = (long) r4
                r0.sendEmptyMessageDelayed(r11, r4)
            L_0x013d:
                r0 = r3
                goto L_0x00df
            L_0x013f:
                boolean r0 = r13.f914m
                if (r0 != 0) goto L_0x004e
                float r0 = r13.f920s
                float r0 = r0 - r2
                float r4 = r13.f921t
                float r4 = r4 - r1
                boolean r5 = r13.f919r
                if (r5 == 0) goto L_0x0156
                android.view.GestureDetector$OnDoubleTapListener r0 = r13.f911j
                boolean r0 = r0.onDoubleTapEvent(r14)
                r3 = r3 | r0
                goto L_0x004e
            L_0x0156:
                boolean r5 = r13.f915n
                if (r5 == 0) goto L_0x0191
                float r5 = r13.f922u
                float r5 = r2 - r5
                int r5 = (int) r5
                float r6 = r13.f923v
                float r6 = r1 - r6
                int r6 = (int) r6
                int r5 = r5 * r5
                int r6 = r6 * r6
                int r5 = r5 + r6
                int r6 = r13.f905a
                if (r5 <= r6) goto L_0x024f
                android.view.GestureDetector$OnGestureListener r6 = r13.f910i
                android.view.MotionEvent r7 = r13.f917p
                boolean r0 = r6.onScroll(r7, r14, r0, r4)
                r13.f920s = r2
                r13.f921t = r1
                r13.f915n = r3
                android.os.Handler r1 = r13.f909h
                r1.removeMessages(r11)
                android.os.Handler r1 = r13.f909h
                r1.removeMessages(r8)
                android.os.Handler r1 = r13.f909h
                r1.removeMessages(r12)
            L_0x0188:
                int r1 = r13.f905a
                if (r5 <= r1) goto L_0x018e
                r13.f916o = r3
            L_0x018e:
                r3 = r0
                goto L_0x004e
            L_0x0191:
                float r5 = java.lang.Math.abs(r0)
                r6 = 1065353216(0x3f800000, float:1.0)
                int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                if (r5 >= 0) goto L_0x01a5
                float r5 = java.lang.Math.abs(r4)
                r6 = 1065353216(0x3f800000, float:1.0)
                int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                if (r5 < 0) goto L_0x004e
            L_0x01a5:
                android.view.GestureDetector$OnGestureListener r3 = r13.f910i
                android.view.MotionEvent r5 = r13.f917p
                boolean r3 = r3.onScroll(r5, r14, r0, r4)
                r13.f920s = r2
                r13.f921t = r1
                goto L_0x004e
            L_0x01b3:
                r13.f912k = r3
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r14)
                boolean r0 = r13.f919r
                if (r0 == 0) goto L_0x01ec
                android.view.GestureDetector$OnDoubleTapListener r0 = r13.f911j
                boolean r0 = r0.onDoubleTapEvent(r14)
                r0 = r0 | r3
            L_0x01c4:
                android.view.MotionEvent r2 = r13.f918q
                if (r2 == 0) goto L_0x01cd
                android.view.MotionEvent r2 = r13.f918q
                r2.recycle()
            L_0x01cd:
                r13.f918q = r1
                android.view.VelocityTracker r1 = r13.f925x
                if (r1 == 0) goto L_0x01db
                android.view.VelocityTracker r1 = r13.f925x
                r1.recycle()
                r1 = 0
                r13.f925x = r1
            L_0x01db:
                r13.f919r = r3
                r13.f913l = r3
                android.os.Handler r1 = r13.f909h
                r1.removeMessages(r8)
                android.os.Handler r1 = r13.f909h
                r1.removeMessages(r12)
                r3 = r0
                goto L_0x004e
            L_0x01ec:
                boolean r0 = r13.f914m
                if (r0 == 0) goto L_0x01f9
                android.os.Handler r0 = r13.f909h
                r0.removeMessages(r11)
                r13.f914m = r3
                r0 = r3
                goto L_0x01c4
            L_0x01f9:
                boolean r0 = r13.f915n
                if (r0 == 0) goto L_0x0211
                android.view.GestureDetector$OnGestureListener r0 = r13.f910i
                boolean r0 = r0.onSingleTapUp(r14)
                boolean r2 = r13.f913l
                if (r2 == 0) goto L_0x01c4
                android.view.GestureDetector$OnDoubleTapListener r2 = r13.f911j
                if (r2 == 0) goto L_0x01c4
                android.view.GestureDetector$OnDoubleTapListener r2 = r13.f911j
                r2.onSingleTapConfirmed(r14)
                goto L_0x01c4
            L_0x0211:
                android.view.VelocityTracker r0 = r13.f925x
                int r2 = android.support.p001v4.view.MotionEventCompat.getPointerId(r14, r3)
                r4 = 1000(0x3e8, float:1.401E-42)
                int r5 = r13.f908d
                float r5 = (float) r5
                r0.computeCurrentVelocity(r4, r5)
                float r4 = android.support.p001v4.view.VelocityTrackerCompat.getYVelocity(r0, r2)
                float r0 = android.support.p001v4.view.VelocityTrackerCompat.getXVelocity(r0, r2)
                float r2 = java.lang.Math.abs(r4)
                int r5 = r13.f907c
                float r5 = (float) r5
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r2 > 0) goto L_0x023d
                float r2 = java.lang.Math.abs(r0)
                int r5 = r13.f907c
                float r5 = (float) r5
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r2 <= 0) goto L_0x024c
            L_0x023d:
                android.view.GestureDetector$OnGestureListener r2 = r13.f910i
                android.view.MotionEvent r5 = r13.f917p
                boolean r0 = r2.onFling(r5, r14, r0, r4)
                goto L_0x01c4
            L_0x0247:
                r13.m1055b()
                goto L_0x004e
            L_0x024c:
                r0 = r3
                goto L_0x01c4
            L_0x024f:
                r0 = r3
                goto L_0x0188
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.view.GestureDetectorCompat.C0266b.mo1755a(android.view.MotionEvent):boolean");
        }

        /* renamed from: b */
        private void m1055b() {
            this.f909h.removeMessages(1);
            this.f909h.removeMessages(2);
            this.f909h.removeMessages(3);
            this.f925x.recycle();
            this.f925x = null;
            this.f919r = false;
            this.f912k = false;
            this.f915n = false;
            this.f916o = false;
            this.f913l = false;
            if (this.f914m) {
                this.f914m = false;
            }
        }

        /* renamed from: c */
        private void m1056c() {
            this.f909h.removeMessages(1);
            this.f909h.removeMessages(2);
            this.f909h.removeMessages(3);
            this.f919r = false;
            this.f915n = false;
            this.f916o = false;
            this.f913l = false;
            if (this.f914m) {
                this.f914m = false;
            }
        }

        /* renamed from: a */
        private boolean m1053a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.f916o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) f904g)) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x * x) + (y * y) < this.f906b) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public void m1059d() {
            this.f909h.removeMessages(3);
            this.f913l = false;
            this.f914m = true;
            this.f910i.onLongPress(this.f917p);
        }
    }

    /* renamed from: android.support.v4.view.GestureDetectorCompat$c */
    static class C0268c implements C0265a {

        /* renamed from: a */
        private final GestureDetector f927a;

        public C0268c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f927a = new GestureDetector(context, onGestureListener, handler);
        }

        /* renamed from: a */
        public boolean mo1754a() {
            return this.f927a.isLongpressEnabled();
        }

        /* renamed from: a */
        public boolean mo1755a(MotionEvent motionEvent) {
            return this.f927a.onTouchEvent(motionEvent);
        }

        /* renamed from: a */
        public void mo1753a(boolean z) {
            this.f927a.setIsLongpressEnabled(z);
        }

        /* renamed from: a */
        public void mo1752a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f927a.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f901a = new C0268c(context, onGestureListener, handler);
        } else {
            this.f901a = new C0266b(context, onGestureListener, handler);
        }
    }

    public boolean isLongpressEnabled() {
        return this.f901a.mo1754a();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f901a.mo1755a(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.f901a.mo1753a(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f901a.mo1752a(onDoubleTapListener);
    }
}
