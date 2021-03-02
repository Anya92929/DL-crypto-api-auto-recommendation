package android.support.p000v4.view;

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
    private final GestureDetectorCompatImpl f1156a;

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImpl */
    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener);
    }

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase */
    class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {

        /* renamed from: e */
        private static final int f1157e = ViewConfiguration.getLongPressTimeout();

        /* renamed from: f */
        private static final int f1158f = ViewConfiguration.getTapTimeout();

        /* renamed from: g */
        private static final int f1159g = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: a */
        private int f1160a;

        /* renamed from: b */
        private int f1161b;

        /* renamed from: c */
        private int f1162c;

        /* renamed from: d */
        private int f1163d;

        /* renamed from: h */
        private final Handler f1164h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public final GestureDetector.OnGestureListener f1165i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public GestureDetector.OnDoubleTapListener f1166j;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public boolean f1167k;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public boolean f1168l;

        /* renamed from: m */
        private boolean f1169m;

        /* renamed from: n */
        private boolean f1170n;

        /* renamed from: o */
        private boolean f1171o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public MotionEvent f1172p;

        /* renamed from: q */
        private MotionEvent f1173q;

        /* renamed from: r */
        private boolean f1174r;

        /* renamed from: s */
        private float f1175s;

        /* renamed from: t */
        private float f1176t;

        /* renamed from: u */
        private float f1177u;

        /* renamed from: v */
        private float f1178v;

        /* renamed from: w */
        private boolean f1179w;

        /* renamed from: x */
        private VelocityTracker f1180x;

        /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler */
        class GestureHandler extends Handler {
            GestureHandler() {
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GestureDetectorCompatImplBase.this.f1165i.onShowPress(GestureDetectorCompatImplBase.this.f1172p);
                        return;
                    case 2:
                        GestureDetectorCompatImplBase.this.m854c();
                        return;
                    case 3:
                        if (GestureDetectorCompatImplBase.this.f1166j == null) {
                            return;
                        }
                        if (!GestureDetectorCompatImplBase.this.f1167k) {
                            GestureDetectorCompatImplBase.this.f1166j.onSingleTapConfirmed(GestureDetectorCompatImplBase.this.f1172p);
                            return;
                        } else {
                            boolean unused = GestureDetectorCompatImplBase.this.f1168l = true;
                            return;
                        }
                    default:
                        throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        public GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f1164h = new GestureHandler(handler);
            } else {
                this.f1164h = new GestureHandler();
            }
            this.f1165i = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            m849a(context);
        }

        /* renamed from: a */
        private void m848a() {
            this.f1164h.removeMessages(1);
            this.f1164h.removeMessages(2);
            this.f1164h.removeMessages(3);
            this.f1180x.recycle();
            this.f1180x = null;
            this.f1174r = false;
            this.f1167k = false;
            this.f1170n = false;
            this.f1171o = false;
            this.f1168l = false;
            if (this.f1169m) {
                this.f1169m = false;
            }
        }

        /* renamed from: a */
        private void m849a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f1165i == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.f1179w = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f1162c = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f1163d = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f1160a = scaledTouchSlop * scaledTouchSlop;
                this.f1161b = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        /* renamed from: a */
        private boolean m851a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.f1171o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) f1159g)) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.f1161b;
        }

        /* renamed from: b */
        private void m853b() {
            this.f1164h.removeMessages(1);
            this.f1164h.removeMessages(2);
            this.f1164h.removeMessages(3);
            this.f1174r = false;
            this.f1170n = false;
            this.f1171o = false;
            this.f1168l = false;
            if (this.f1169m) {
                this.f1169m = false;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public void m854c() {
            this.f1164h.removeMessages(3);
            this.f1168l = false;
            this.f1169m = true;
            this.f1165i.onLongPress(this.f1172p);
        }

        public boolean isLongpressEnabled() {
            return this.f1179w;
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0104  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r14) {
            /*
                r13 = this;
                r6 = 0
                r12 = 2
                r11 = 3
                r8 = 1
                r3 = 0
                int r9 = r14.getAction()
                android.view.VelocityTracker r0 = r13.f1180x
                if (r0 != 0) goto L_0x0013
                android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
                r13.f1180x = r0
            L_0x0013:
                android.view.VelocityTracker r0 = r13.f1180x
                r0.addMovement(r14)
                r0 = r9 & 255(0xff, float:3.57E-43)
                r1 = 6
                if (r0 != r1) goto L_0x0032
                r7 = r8
            L_0x001e:
                if (r7 == 0) goto L_0x0034
                int r0 = android.support.p000v4.view.MotionEventCompat.getActionIndex(r14)
            L_0x0024:
                int r4 = android.support.p000v4.view.MotionEventCompat.getPointerCount(r14)
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
                float r10 = android.support.p000v4.view.MotionEventCompat.getX(r14, r5)
                float r2 = r2 + r10
                float r10 = android.support.p000v4.view.MotionEventCompat.getY(r14, r5)
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
                r13.f1175s = r2
                r13.f1177u = r2
                r13.f1176t = r1
                r13.f1178v = r1
                r13.m853b()
                goto L_0x004e
            L_0x005d:
                r13.f1175s = r2
                r13.f1177u = r2
                r13.f1176t = r1
                r13.f1178v = r1
                android.view.VelocityTracker r0 = r13.f1180x
                r1 = 1000(0x3e8, float:1.401E-42)
                int r2 = r13.f1163d
                float r2 = (float) r2
                r0.computeCurrentVelocity(r1, r2)
                int r1 = android.support.p000v4.view.MotionEventCompat.getActionIndex(r14)
                int r0 = android.support.p000v4.view.MotionEventCompat.getPointerId(r14, r1)
                android.view.VelocityTracker r2 = r13.f1180x
                float r2 = android.support.p000v4.view.VelocityTrackerCompat.getXVelocity(r2, r0)
                android.view.VelocityTracker r5 = r13.f1180x
                float r5 = android.support.p000v4.view.VelocityTrackerCompat.getYVelocity(r5, r0)
                r0 = r3
            L_0x0084:
                if (r0 >= r4) goto L_0x004e
                if (r0 != r1) goto L_0x008b
            L_0x0088:
                int r0 = r0 + 1
                goto L_0x0084
            L_0x008b:
                int r7 = android.support.p000v4.view.MotionEventCompat.getPointerId(r14, r0)
                android.view.VelocityTracker r8 = r13.f1180x
                float r8 = android.support.p000v4.view.VelocityTrackerCompat.getXVelocity(r8, r7)
                float r8 = r8 * r2
                android.view.VelocityTracker r9 = r13.f1180x
                float r7 = android.support.p000v4.view.VelocityTrackerCompat.getYVelocity(r9, r7)
                float r7 = r7 * r5
                float r7 = r7 + r8
                int r7 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r7 >= 0) goto L_0x0088
                android.view.VelocityTracker r0 = r13.f1180x
                r0.clear()
                goto L_0x004e
            L_0x00a8:
                android.view.GestureDetector$OnDoubleTapListener r0 = r13.f1166j
                if (r0 == 0) goto L_0x013d
                android.os.Handler r0 = r13.f1164h
                boolean r0 = r0.hasMessages(r11)
                if (r0 == 0) goto L_0x00b9
                android.os.Handler r4 = r13.f1164h
                r4.removeMessages(r11)
            L_0x00b9:
                android.view.MotionEvent r4 = r13.f1172p
                if (r4 == 0) goto L_0x0135
                android.view.MotionEvent r4 = r13.f1173q
                if (r4 == 0) goto L_0x0135
                if (r0 == 0) goto L_0x0135
                android.view.MotionEvent r0 = r13.f1172p
                android.view.MotionEvent r4 = r13.f1173q
                boolean r0 = r13.m851a(r0, r4, r14)
                if (r0 == 0) goto L_0x0135
                r13.f1174r = r8
                android.view.GestureDetector$OnDoubleTapListener r0 = r13.f1166j
                android.view.MotionEvent r4 = r13.f1172p
                boolean r0 = r0.onDoubleTap(r4)
                r0 = r0 | r3
                android.view.GestureDetector$OnDoubleTapListener r4 = r13.f1166j
                boolean r4 = r4.onDoubleTapEvent(r14)
                r0 = r0 | r4
            L_0x00df:
                r13.f1175s = r2
                r13.f1177u = r2
                r13.f1176t = r1
                r13.f1178v = r1
                android.view.MotionEvent r1 = r13.f1172p
                if (r1 == 0) goto L_0x00f0
                android.view.MotionEvent r1 = r13.f1172p
                r1.recycle()
            L_0x00f0:
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r14)
                r13.f1172p = r1
                r13.f1170n = r8
                r13.f1171o = r8
                r13.f1167k = r8
                r13.f1169m = r3
                r13.f1168l = r3
                boolean r1 = r13.f1179w
                if (r1 == 0) goto L_0x011c
                android.os.Handler r1 = r13.f1164h
                r1.removeMessages(r12)
                android.os.Handler r1 = r13.f1164h
                android.view.MotionEvent r2 = r13.f1172p
                long r2 = r2.getDownTime()
                int r4 = f1158f
                long r4 = (long) r4
                long r2 = r2 + r4
                int r4 = f1157e
                long r4 = (long) r4
                long r2 = r2 + r4
                r1.sendEmptyMessageAtTime(r12, r2)
            L_0x011c:
                android.os.Handler r1 = r13.f1164h
                android.view.MotionEvent r2 = r13.f1172p
                long r2 = r2.getDownTime()
                int r4 = f1158f
                long r4 = (long) r4
                long r2 = r2 + r4
                r1.sendEmptyMessageAtTime(r8, r2)
                android.view.GestureDetector$OnGestureListener r1 = r13.f1165i
                boolean r1 = r1.onDown(r14)
                r3 = r0 | r1
                goto L_0x004e
            L_0x0135:
                android.os.Handler r0 = r13.f1164h
                int r4 = f1159g
                long r4 = (long) r4
                r0.sendEmptyMessageDelayed(r11, r4)
            L_0x013d:
                r0 = r3
                goto L_0x00df
            L_0x013f:
                boolean r0 = r13.f1169m
                if (r0 != 0) goto L_0x004e
                float r0 = r13.f1175s
                float r0 = r0 - r2
                float r4 = r13.f1176t
                float r4 = r4 - r1
                boolean r5 = r13.f1174r
                if (r5 == 0) goto L_0x0156
                android.view.GestureDetector$OnDoubleTapListener r0 = r13.f1166j
                boolean r0 = r0.onDoubleTapEvent(r14)
                r3 = r3 | r0
                goto L_0x004e
            L_0x0156:
                boolean r5 = r13.f1170n
                if (r5 == 0) goto L_0x0191
                float r5 = r13.f1177u
                float r5 = r2 - r5
                int r5 = (int) r5
                float r6 = r13.f1178v
                float r6 = r1 - r6
                int r6 = (int) r6
                int r5 = r5 * r5
                int r6 = r6 * r6
                int r5 = r5 + r6
                int r6 = r13.f1160a
                if (r5 <= r6) goto L_0x024f
                android.view.GestureDetector$OnGestureListener r6 = r13.f1165i
                android.view.MotionEvent r7 = r13.f1172p
                boolean r0 = r6.onScroll(r7, r14, r0, r4)
                r13.f1175s = r2
                r13.f1176t = r1
                r13.f1170n = r3
                android.os.Handler r1 = r13.f1164h
                r1.removeMessages(r11)
                android.os.Handler r1 = r13.f1164h
                r1.removeMessages(r8)
                android.os.Handler r1 = r13.f1164h
                r1.removeMessages(r12)
            L_0x0188:
                int r1 = r13.f1160a
                if (r5 <= r1) goto L_0x018e
                r13.f1171o = r3
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
                android.view.GestureDetector$OnGestureListener r3 = r13.f1165i
                android.view.MotionEvent r5 = r13.f1172p
                boolean r3 = r3.onScroll(r5, r14, r0, r4)
                r13.f1175s = r2
                r13.f1176t = r1
                goto L_0x004e
            L_0x01b3:
                r13.f1167k = r3
                android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r14)
                boolean r0 = r13.f1174r
                if (r0 == 0) goto L_0x01ec
                android.view.GestureDetector$OnDoubleTapListener r0 = r13.f1166j
                boolean r0 = r0.onDoubleTapEvent(r14)
                r0 = r0 | r3
            L_0x01c4:
                android.view.MotionEvent r2 = r13.f1173q
                if (r2 == 0) goto L_0x01cd
                android.view.MotionEvent r2 = r13.f1173q
                r2.recycle()
            L_0x01cd:
                r13.f1173q = r1
                android.view.VelocityTracker r1 = r13.f1180x
                if (r1 == 0) goto L_0x01db
                android.view.VelocityTracker r1 = r13.f1180x
                r1.recycle()
                r1 = 0
                r13.f1180x = r1
            L_0x01db:
                r13.f1174r = r3
                r13.f1168l = r3
                android.os.Handler r1 = r13.f1164h
                r1.removeMessages(r8)
                android.os.Handler r1 = r13.f1164h
                r1.removeMessages(r12)
                r3 = r0
                goto L_0x004e
            L_0x01ec:
                boolean r0 = r13.f1169m
                if (r0 == 0) goto L_0x01f9
                android.os.Handler r0 = r13.f1164h
                r0.removeMessages(r11)
                r13.f1169m = r3
                r0 = r3
                goto L_0x01c4
            L_0x01f9:
                boolean r0 = r13.f1170n
                if (r0 == 0) goto L_0x0211
                android.view.GestureDetector$OnGestureListener r0 = r13.f1165i
                boolean r0 = r0.onSingleTapUp(r14)
                boolean r2 = r13.f1168l
                if (r2 == 0) goto L_0x01c4
                android.view.GestureDetector$OnDoubleTapListener r2 = r13.f1166j
                if (r2 == 0) goto L_0x01c4
                android.view.GestureDetector$OnDoubleTapListener r2 = r13.f1166j
                r2.onSingleTapConfirmed(r14)
                goto L_0x01c4
            L_0x0211:
                android.view.VelocityTracker r0 = r13.f1180x
                int r2 = android.support.p000v4.view.MotionEventCompat.getPointerId(r14, r3)
                r4 = 1000(0x3e8, float:1.401E-42)
                int r5 = r13.f1163d
                float r5 = (float) r5
                r0.computeCurrentVelocity(r4, r5)
                float r4 = android.support.p000v4.view.VelocityTrackerCompat.getYVelocity(r0, r2)
                float r0 = android.support.p000v4.view.VelocityTrackerCompat.getXVelocity(r0, r2)
                float r2 = java.lang.Math.abs(r4)
                int r5 = r13.f1162c
                float r5 = (float) r5
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r2 > 0) goto L_0x023d
                float r2 = java.lang.Math.abs(r0)
                int r5 = r13.f1162c
                float r5 = (float) r5
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r2 <= 0) goto L_0x024c
            L_0x023d:
                android.view.GestureDetector$OnGestureListener r2 = r13.f1165i
                android.view.MotionEvent r5 = r13.f1172p
                boolean r0 = r2.onFling(r5, r14, r0, r4)
                goto L_0x01c4
            L_0x0247:
                r13.m848a()
                goto L_0x004e
            L_0x024c:
                r0 = r3
                goto L_0x01c4
            L_0x024f:
                r0 = r3
                goto L_0x0188
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.view.GestureDetectorCompat.GestureDetectorCompatImplBase.onTouchEvent(android.view.MotionEvent):boolean");
        }

        public void setIsLongpressEnabled(boolean z) {
            this.f1179w = z;
        }

        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f1166j = onDoubleTapListener;
        }
    }

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2 */
    class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {

        /* renamed from: a */
        private final GestureDetector f1182a;

        public GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f1182a = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean isLongpressEnabled() {
            return this.f1182a.isLongpressEnabled();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.f1182a.onTouchEvent(motionEvent);
        }

        public void setIsLongpressEnabled(boolean z) {
            this.f1182a.setIsLongpressEnabled(z);
        }

        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f1182a.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f1156a = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.f1156a = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }

    public boolean isLongpressEnabled() {
        return this.f1156a.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f1156a.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.f1156a.setIsLongpressEnabled(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f1156a.setOnDoubleTapListener(onDoubleTapListener);
    }
}
