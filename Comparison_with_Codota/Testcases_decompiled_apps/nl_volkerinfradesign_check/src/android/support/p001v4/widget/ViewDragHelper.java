package android.support.p001v4.widget;

import android.content.Context;
import android.support.p001v4.view.MotionEventCompat;
import android.support.p001v4.view.VelocityTrackerCompat;
import android.support.p001v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;
import p006nl.volkerinfradesign.checkandroid.database.LogTable;

/* renamed from: android.support.v4.widget.ViewDragHelper */
public class ViewDragHelper {
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: v */
    private static final Interpolator f1381v = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a */
    private int f1382a;

    /* renamed from: b */
    private int f1383b;

    /* renamed from: c */
    private int f1384c = -1;

    /* renamed from: d */
    private float[] f1385d;

    /* renamed from: e */
    private float[] f1386e;

    /* renamed from: f */
    private float[] f1387f;

    /* renamed from: g */
    private float[] f1388g;

    /* renamed from: h */
    private int[] f1389h;

    /* renamed from: i */
    private int[] f1390i;

    /* renamed from: j */
    private int[] f1391j;

    /* renamed from: k */
    private int f1392k;

    /* renamed from: l */
    private VelocityTracker f1393l;

    /* renamed from: m */
    private float f1394m;

    /* renamed from: n */
    private float f1395n;

    /* renamed from: o */
    private int f1396o;

    /* renamed from: p */
    private int f1397p;

    /* renamed from: q */
    private ScrollerCompat f1398q;

    /* renamed from: r */
    private final Callback f1399r;

    /* renamed from: s */
    private View f1400s;

    /* renamed from: t */
    private boolean f1401t;

    /* renamed from: u */
    private final ViewGroup f1402u;

    /* renamed from: w */
    private final Runnable f1403w = new Runnable() {
        public void run() {
            ViewDragHelper.this.mo3055a(0);
        }
    };

    /* renamed from: android.support.v4.widget.ViewDragHelper$Callback */
    public static abstract class Callback {
        public abstract boolean tryCaptureView(View view, int i);

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.f1383b = (int) (((float) create.f1383b) * (1.0f / f));
        return create;
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f1402u = viewGroup;
            this.f1399r = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1396o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1383b = viewConfiguration.getScaledTouchSlop();
            this.f1394m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1395n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1398q = ScrollerCompat.create(context, f1381v);
        }
    }

    public void setMinVelocity(float f) {
        this.f1395n = f;
    }

    public float getMinVelocity() {
        return this.f1395n;
    }

    public int getViewDragState() {
        return this.f1382a;
    }

    public void setEdgeTrackingEnabled(int i) {
        this.f1397p = i;
    }

    public int getEdgeSize() {
        return this.f1396o;
    }

    public void captureChildView(View view, int i) {
        if (view.getParent() != this.f1402u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1402u + ")");
        }
        this.f1400s = view;
        this.f1384c = i;
        this.f1399r.onViewCaptured(view, i);
        mo3055a(1);
    }

    public View getCapturedView() {
        return this.f1400s;
    }

    public int getActivePointerId() {
        return this.f1384c;
    }

    public int getTouchSlop() {
        return this.f1383b;
    }

    public void cancel() {
        this.f1384c = -1;
        m2832a();
        if (this.f1393l != null) {
            this.f1393l.recycle();
            this.f1393l = null;
        }
    }

    public void abort() {
        cancel();
        if (this.f1382a == 2) {
            int currX = this.f1398q.getCurrX();
            int currY = this.f1398q.getCurrY();
            this.f1398q.abortAnimation();
            int currX2 = this.f1398q.getCurrX();
            int currY2 = this.f1398q.getCurrY();
            this.f1399r.onViewPositionChanged(this.f1400s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        mo3055a(0);
    }

    public boolean smoothSlideViewTo(View view, int i, int i2) {
        this.f1400s = view;
        this.f1384c = -1;
        boolean a = m2837a(i, i2, 0, 0);
        if (!a && this.f1382a == 0 && this.f1400s != null) {
            this.f1400s = null;
        }
        return a;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.f1401t) {
            return m2837a(i, i2, (int) VelocityTrackerCompat.getXVelocity(this.f1393l, this.f1384c), (int) VelocityTrackerCompat.getYVelocity(this.f1393l, this.f1384c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* renamed from: a */
    private boolean m2837a(int i, int i2, int i3, int i4) {
        int left = this.f1400s.getLeft();
        int top = this.f1400s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1398q.abortAnimation();
            mo3055a(0);
            return false;
        }
        this.f1398q.startScroll(left, top, i5, i6, m2831a(this.f1400s, i5, i6, i3, i4));
        mo3055a(2);
        return true;
    }

    /* renamed from: a */
    private int m2831a(View view, int i, int i2, int i3, int i4) {
        int b = m2839b(i3, (int) this.f1395n, (int) this.f1394m);
        int b2 = m2839b(i4, (int) this.f1395n, (int) this.f1394m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m2830a(i2, b2, this.f1399r.getViewVerticalDragRange(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m2830a(i, b, this.f1399r.getViewHorizontalDragRange(view)))));
    }

    /* renamed from: a */
    private int m2830a(int i, int i2, int i3) {
        int abs;
        if (i == 0) {
            return 0;
        }
        int width = this.f1402u.getWidth();
        int i4 = width / 2;
        float a = (m2827a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(a / ((float) abs2)) * 1000.0f) * 4;
        } else {
            abs = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    /* renamed from: b */
    private int m2839b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    /* renamed from: a */
    private float m2828a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= BitmapDescriptorFactory.HUE_RED) {
            return -f3;
        }
        return f3;
    }

    /* renamed from: a */
    private float m2827a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (!this.f1401t) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.f1398q.fling(this.f1400s.getLeft(), this.f1400s.getTop(), (int) VelocityTrackerCompat.getXVelocity(this.f1393l, this.f1384c), (int) VelocityTrackerCompat.getYVelocity(this.f1393l, this.f1384c), i, i3, i2, i4);
        mo3055a(2);
    }

    public boolean continueSettling(boolean z) {
        boolean z2;
        if (this.f1382a == 2) {
            boolean computeScrollOffset = this.f1398q.computeScrollOffset();
            int currX = this.f1398q.getCurrX();
            int currY = this.f1398q.getCurrY();
            int left = currX - this.f1400s.getLeft();
            int top = currY - this.f1400s.getTop();
            if (left != 0) {
                this.f1400s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f1400s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1399r.onViewPositionChanged(this.f1400s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f1398q.getFinalX() && currY == this.f1398q.getFinalY()) {
                this.f1398q.abortAnimation();
                z2 = false;
            } else {
                z2 = computeScrollOffset;
            }
            if (!z2) {
                if (z) {
                    this.f1402u.post(this.f1403w);
                } else {
                    mo3055a(0);
                }
            }
        }
        return this.f1382a == 2;
    }

    /* renamed from: a */
    private void m2833a(float f, float f2) {
        this.f1401t = true;
        this.f1399r.onViewReleased(this.f1400s, f, f2);
        this.f1401t = false;
        if (this.f1382a == 1) {
            mo3055a(0);
        }
    }

    /* renamed from: a */
    private void m2832a() {
        if (this.f1385d != null) {
            Arrays.fill(this.f1385d, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f1386e, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f1387f, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f1388g, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f1389h, 0);
            Arrays.fill(this.f1390i, 0);
            Arrays.fill(this.f1391j, 0);
            this.f1392k = 0;
        }
    }

    /* renamed from: b */
    private void m2842b(int i) {
        if (this.f1385d != null) {
            this.f1385d[i] = 0.0f;
            this.f1386e[i] = 0.0f;
            this.f1387f[i] = 0.0f;
            this.f1388g[i] = 0.0f;
            this.f1389h[i] = 0;
            this.f1390i[i] = 0;
            this.f1391j[i] = 0;
            this.f1392k &= (1 << i) ^ -1;
        }
    }

    /* renamed from: c */
    private void m2844c(int i) {
        if (this.f1385d == null || this.f1385d.length <= i) {
            float[] fArr = new float[(i + 1)];
            float[] fArr2 = new float[(i + 1)];
            float[] fArr3 = new float[(i + 1)];
            float[] fArr4 = new float[(i + 1)];
            int[] iArr = new int[(i + 1)];
            int[] iArr2 = new int[(i + 1)];
            int[] iArr3 = new int[(i + 1)];
            if (this.f1385d != null) {
                System.arraycopy(this.f1385d, 0, fArr, 0, this.f1385d.length);
                System.arraycopy(this.f1386e, 0, fArr2, 0, this.f1386e.length);
                System.arraycopy(this.f1387f, 0, fArr3, 0, this.f1387f.length);
                System.arraycopy(this.f1388g, 0, fArr4, 0, this.f1388g.length);
                System.arraycopy(this.f1389h, 0, iArr, 0, this.f1389h.length);
                System.arraycopy(this.f1390i, 0, iArr2, 0, this.f1390i.length);
                System.arraycopy(this.f1391j, 0, iArr3, 0, this.f1391j.length);
            }
            this.f1385d = fArr;
            this.f1386e = fArr2;
            this.f1387f = fArr3;
            this.f1388g = fArr4;
            this.f1389h = iArr;
            this.f1390i = iArr2;
            this.f1391j = iArr3;
        }
    }

    /* renamed from: a */
    private void m2834a(float f, float f2, int i) {
        m2844c(i);
        float[] fArr = this.f1385d;
        this.f1387f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f1386e;
        this.f1388g[i] = f2;
        fArr2[i] = f2;
        this.f1389h[i] = m2829a((int) f, (int) f2);
        this.f1392k |= 1 << i;
    }

    /* renamed from: a */
    private void m2835a(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
            float x = MotionEventCompat.getX(motionEvent, i);
            float y = MotionEventCompat.getY(motionEvent, i);
            this.f1387f[pointerId] = x;
            this.f1388g[pointerId] = y;
        }
    }

    public boolean isPointerDown(int i) {
        return (this.f1392k & (1 << i)) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3055a(int i) {
        this.f1402u.removeCallbacks(this.f1403w);
        if (this.f1382a != i) {
            this.f1382a = i;
            this.f1399r.onViewDragStateChanged(i);
            if (this.f1382a == 0) {
                this.f1400s = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3056a(View view, int i) {
        if (view == this.f1400s && this.f1384c == i) {
            return true;
        }
        if (view == null || !this.f1399r.tryCaptureView(view, i)) {
            return false;
        }
        this.f1384c = i;
        captureChildView(view, i);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3, int i4) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollX >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && (ViewCompat.canScrollHorizontally(view, -i) || ViewCompat.canScrollVertically(view, -i2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f5, code lost:
        if (r8 != r7) goto L_0x0104;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldInterceptTouchEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            int r0 = android.support.p001v4.view.MotionEventCompat.getActionMasked(r14)
            int r1 = android.support.p001v4.view.MotionEventCompat.getActionIndex(r14)
            if (r0 != 0) goto L_0x000d
            r13.cancel()
        L_0x000d:
            android.view.VelocityTracker r2 = r13.f1393l
            if (r2 != 0) goto L_0x0017
            android.view.VelocityTracker r2 = android.view.VelocityTracker.obtain()
            r13.f1393l = r2
        L_0x0017:
            android.view.VelocityTracker r2 = r13.f1393l
            r2.addMovement(r14)
            switch(r0) {
                case 0: goto L_0x0026;
                case 1: goto L_0x0121;
                case 2: goto L_0x0092;
                case 3: goto L_0x0121;
                case 4: goto L_0x001f;
                case 5: goto L_0x005a;
                case 6: goto L_0x0118;
                default: goto L_0x001f;
            }
        L_0x001f:
            int r0 = r13.f1382a
            r1 = 1
            if (r0 != r1) goto L_0x0126
            r0 = 1
        L_0x0025:
            return r0
        L_0x0026:
            float r0 = r14.getX()
            float r1 = r14.getY()
            r2 = 0
            int r2 = android.support.p001v4.view.MotionEventCompat.getPointerId(r14, r2)
            r13.m2834a((float) r0, (float) r1, (int) r2)
            int r0 = (int) r0
            int r1 = (int) r1
            android.view.View r0 = r13.findTopChildUnder(r0, r1)
            android.view.View r1 = r13.f1400s
            if (r0 != r1) goto L_0x0048
            int r1 = r13.f1382a
            r3 = 2
            if (r1 != r3) goto L_0x0048
            r13.mo3056a((android.view.View) r0, (int) r2)
        L_0x0048:
            int[] r0 = r13.f1389h
            r0 = r0[r2]
            int r1 = r13.f1397p
            r1 = r1 & r0
            if (r1 == 0) goto L_0x001f
            android.support.v4.widget.ViewDragHelper$Callback r1 = r13.f1399r
            int r3 = r13.f1397p
            r0 = r0 & r3
            r1.onEdgeTouched(r0, r2)
            goto L_0x001f
        L_0x005a:
            int r0 = android.support.p001v4.view.MotionEventCompat.getPointerId(r14, r1)
            float r2 = android.support.p001v4.view.MotionEventCompat.getX(r14, r1)
            float r1 = android.support.p001v4.view.MotionEventCompat.getY(r14, r1)
            r13.m2834a((float) r2, (float) r1, (int) r0)
            int r3 = r13.f1382a
            if (r3 != 0) goto L_0x007f
            int[] r1 = r13.f1389h
            r1 = r1[r0]
            int r2 = r13.f1397p
            r2 = r2 & r1
            if (r2 == 0) goto L_0x001f
            android.support.v4.widget.ViewDragHelper$Callback r2 = r13.f1399r
            int r3 = r13.f1397p
            r1 = r1 & r3
            r2.onEdgeTouched(r1, r0)
            goto L_0x001f
        L_0x007f:
            int r3 = r13.f1382a
            r4 = 2
            if (r3 != r4) goto L_0x001f
            int r2 = (int) r2
            int r1 = (int) r1
            android.view.View r1 = r13.findTopChildUnder(r2, r1)
            android.view.View r2 = r13.f1400s
            if (r1 != r2) goto L_0x001f
            r13.mo3056a((android.view.View) r1, (int) r0)
            goto L_0x001f
        L_0x0092:
            float[] r0 = r13.f1385d
            if (r0 == 0) goto L_0x001f
            float[] r0 = r13.f1386e
            if (r0 == 0) goto L_0x001f
            int r2 = android.support.p001v4.view.MotionEventCompat.getPointerCount(r14)
            r0 = 0
            r1 = r0
        L_0x00a0:
            if (r1 >= r2) goto L_0x00fd
            int r3 = android.support.p001v4.view.MotionEventCompat.getPointerId(r14, r1)
            float r0 = android.support.p001v4.view.MotionEventCompat.getX(r14, r1)
            float r4 = android.support.p001v4.view.MotionEventCompat.getY(r14, r1)
            float[] r5 = r13.f1385d
            r5 = r5[r3]
            float r5 = r0 - r5
            float[] r6 = r13.f1386e
            r6 = r6[r3]
            float r6 = r4 - r6
            int r0 = (int) r0
            int r4 = (int) r4
            android.view.View r4 = r13.findTopChildUnder(r0, r4)
            if (r4 == 0) goto L_0x0102
            boolean r0 = r13.m2838a((android.view.View) r4, (float) r5, (float) r6)
            if (r0 == 0) goto L_0x0102
            r0 = 1
        L_0x00c9:
            if (r0 == 0) goto L_0x0104
            int r7 = r4.getLeft()
            int r8 = (int) r5
            int r8 = r8 + r7
            android.support.v4.widget.ViewDragHelper$Callback r9 = r13.f1399r
            int r10 = (int) r5
            int r8 = r9.clampViewPositionHorizontal(r4, r8, r10)
            int r9 = r4.getTop()
            int r10 = (int) r6
            int r10 = r10 + r9
            android.support.v4.widget.ViewDragHelper$Callback r11 = r13.f1399r
            int r12 = (int) r6
            int r10 = r11.clampViewPositionVertical(r4, r10, r12)
            android.support.v4.widget.ViewDragHelper$Callback r11 = r13.f1399r
            int r11 = r11.getViewHorizontalDragRange(r4)
            android.support.v4.widget.ViewDragHelper$Callback r12 = r13.f1399r
            int r12 = r12.getViewVerticalDragRange(r4)
            if (r11 == 0) goto L_0x00f7
            if (r11 <= 0) goto L_0x0104
            if (r8 != r7) goto L_0x0104
        L_0x00f7:
            if (r12 == 0) goto L_0x00fd
            if (r12 <= 0) goto L_0x0104
            if (r10 != r9) goto L_0x0104
        L_0x00fd:
            r13.m2835a((android.view.MotionEvent) r14)
            goto L_0x001f
        L_0x0102:
            r0 = 0
            goto L_0x00c9
        L_0x0104:
            r13.m2841b((float) r5, (float) r6, (int) r3)
            int r5 = r13.f1382a
            r6 = 1
            if (r5 == r6) goto L_0x00fd
            if (r0 == 0) goto L_0x0114
            boolean r0 = r13.mo3056a((android.view.View) r4, (int) r3)
            if (r0 != 0) goto L_0x00fd
        L_0x0114:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x00a0
        L_0x0118:
            int r0 = android.support.p001v4.view.MotionEventCompat.getPointerId(r14, r1)
            r13.m2842b(r0)
            goto L_0x001f
        L_0x0121:
            r13.cancel()
            goto L_0x001f
        L_0x0126:
            r0 = 0
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v4.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2 = 0;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.f1393l == null) {
            this.f1393l = VelocityTracker.obtain();
        }
        this.f1393l.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                View findTopChildUnder = findTopChildUnder((int) x, (int) y);
                m2834a(x, y, pointerId);
                mo3056a(findTopChildUnder, pointerId);
                int i3 = this.f1389h[pointerId];
                if ((this.f1397p & i3) != 0) {
                    this.f1399r.onEdgeTouched(i3 & this.f1397p, pointerId);
                    return;
                }
                return;
            case 1:
                if (this.f1382a == 1) {
                    m2840b();
                }
                cancel();
                return;
            case 2:
                if (this.f1382a == 1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f1384c);
                    float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    int i4 = (int) (x2 - this.f1387f[this.f1384c]);
                    int i5 = (int) (y2 - this.f1388g[this.f1384c]);
                    m2843b(this.f1400s.getLeft() + i4, this.f1400s.getTop() + i5, i4, i5);
                    m2835a(motionEvent);
                    return;
                }
                int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                while (i2 < pointerCount) {
                    int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i2);
                    float x3 = MotionEventCompat.getX(motionEvent, i2);
                    float y3 = MotionEventCompat.getY(motionEvent, i2);
                    float f = x3 - this.f1385d[pointerId2];
                    float f2 = y3 - this.f1386e[pointerId2];
                    m2841b(f, f2, pointerId2);
                    if (this.f1382a != 1) {
                        View findTopChildUnder2 = findTopChildUnder((int) x3, (int) y3);
                        if (!m2838a(findTopChildUnder2, f, f2) || !mo3056a(findTopChildUnder2, pointerId2)) {
                            i2++;
                        }
                    }
                    m2835a(motionEvent);
                    return;
                }
                m2835a(motionEvent);
                return;
            case 3:
                if (this.f1382a == 1) {
                    m2833a((float) BitmapDescriptorFactory.HUE_RED, (float) BitmapDescriptorFactory.HUE_RED);
                }
                cancel();
                return;
            case 5:
                int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                float x4 = MotionEventCompat.getX(motionEvent, actionIndex);
                float y4 = MotionEventCompat.getY(motionEvent, actionIndex);
                m2834a(x4, y4, pointerId3);
                if (this.f1382a == 0) {
                    mo3056a(findTopChildUnder((int) x4, (int) y4), pointerId3);
                    int i6 = this.f1389h[pointerId3];
                    if ((this.f1397p & i6) != 0) {
                        this.f1399r.onEdgeTouched(i6 & this.f1397p, pointerId3);
                        return;
                    }
                    return;
                } else if (isCapturedViewUnder((int) x4, (int) y4)) {
                    mo3056a(this.f1400s, pointerId3);
                    return;
                } else {
                    return;
                }
            case 6:
                int pointerId4 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (this.f1382a == 1 && pointerId4 == this.f1384c) {
                    int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
                    while (true) {
                        if (i2 >= pointerCount2) {
                            i = -1;
                        } else {
                            int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i2);
                            if (pointerId5 != this.f1384c) {
                                if (findTopChildUnder((int) MotionEventCompat.getX(motionEvent, i2), (int) MotionEventCompat.getY(motionEvent, i2)) == this.f1400s && mo3056a(this.f1400s, pointerId5)) {
                                    i = this.f1384c;
                                }
                            }
                            i2++;
                        }
                    }
                    if (i == -1) {
                        m2840b();
                    }
                }
                m2842b(pointerId4);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m2841b(float f, float f2, int i) {
        int i2 = 1;
        if (!m2836a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m2836a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m2836a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m2836a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1390i;
            iArr[i] = iArr[i] | i2;
            this.f1399r.onEdgeDragStarted(i2, i);
        }
    }

    /* renamed from: a */
    private boolean m2836a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1389h[i] & i2) != i2 || (this.f1397p & i2) == 0 || (this.f1391j[i] & i2) == i2 || (this.f1390i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f1383b) && abs2 <= ((float) this.f1383b)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f1399r.onEdgeLock(i2)) {
            int[] iArr = this.f1391j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f1390i[i] & i2) != 0 || abs <= ((float) this.f1383b)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    private boolean m2838a(View view, float f, float f2) {
        boolean z;
        boolean z2;
        if (view == null) {
            return false;
        }
        if (this.f1399r.getViewHorizontalDragRange(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1399r.getViewVerticalDragRange(view) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || !z2) {
            if (z) {
                if (Math.abs(f) <= ((float) this.f1383b)) {
                    return false;
                }
                return true;
            } else if (!z2) {
                return false;
            } else {
                if (Math.abs(f2) <= ((float) this.f1383b)) {
                    return false;
                }
                return true;
            }
        } else if ((f * f) + (f2 * f2) <= ((float) (this.f1383b * this.f1383b))) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkTouchSlop(int i) {
        int length = this.f1385d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (checkTouchSlop(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i, int i2) {
        boolean z;
        if (!isPointerDown(i2)) {
            return false;
        }
        boolean z2 = (i & 1) == 1;
        if ((i & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        float f = this.f1387f[i2] - this.f1385d[i2];
        float f2 = this.f1388g[i2] - this.f1386e[i2];
        if (!z2 || !z) {
            if (z2) {
                if (Math.abs(f) <= ((float) this.f1383b)) {
                    return false;
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                if (Math.abs(f2) <= ((float) this.f1383b)) {
                    return false;
                }
                return true;
            }
        } else if ((f * f) + (f2 * f2) <= ((float) (this.f1383b * this.f1383b))) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isEdgeTouched(int i) {
        int length = this.f1389h.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (isEdgeTouched(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (this.f1389h[i2] & i) != 0;
    }

    /* renamed from: b */
    private void m2840b() {
        this.f1393l.computeCurrentVelocity(LogTable.MAX_SIZE, this.f1394m);
        m2833a(m2828a(VelocityTrackerCompat.getXVelocity(this.f1393l, this.f1384c), this.f1395n, this.f1394m), m2828a(VelocityTrackerCompat.getYVelocity(this.f1393l, this.f1384c), this.f1395n, this.f1394m));
    }

    /* renamed from: b */
    private void m2843b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int left = this.f1400s.getLeft();
        int top = this.f1400s.getTop();
        if (i3 != 0) {
            i5 = this.f1399r.clampViewPositionHorizontal(this.f1400s, i, i3);
            this.f1400s.offsetLeftAndRight(i5 - left);
        } else {
            i5 = i;
        }
        if (i4 != 0) {
            i6 = this.f1399r.clampViewPositionVertical(this.f1400s, i2, i4);
            this.f1400s.offsetTopAndBottom(i6 - top);
        } else {
            i6 = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f1399r.onViewPositionChanged(this.f1400s, i5, i6, i5 - left, i6 - top);
        }
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.f1400s, i, i2);
    }

    public boolean isViewUnder(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View findTopChildUnder(int i, int i2) {
        for (int childCount = this.f1402u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1402u.getChildAt(this.f1399r.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    private int m2829a(int i, int i2) {
        int i3 = 0;
        if (i < this.f1402u.getLeft() + this.f1396o) {
            i3 = 1;
        }
        if (i2 < this.f1402u.getTop() + this.f1396o) {
            i3 |= 4;
        }
        if (i > this.f1402u.getRight() - this.f1396o) {
            i3 |= 2;
        }
        if (i2 > this.f1402u.getBottom() - this.f1396o) {
            return i3 | 8;
        }
        return i3;
    }
}
