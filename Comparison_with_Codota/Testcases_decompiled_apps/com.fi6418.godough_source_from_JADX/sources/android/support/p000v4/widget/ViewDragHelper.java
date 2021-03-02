package android.support.p000v4.widget;

import android.content.Context;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.VelocityTrackerCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;

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
    private static final Interpolator f1698v = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a */
    private int f1699a;

    /* renamed from: b */
    private int f1700b;

    /* renamed from: c */
    private int f1701c = -1;

    /* renamed from: d */
    private float[] f1702d;

    /* renamed from: e */
    private float[] f1703e;

    /* renamed from: f */
    private float[] f1704f;

    /* renamed from: g */
    private float[] f1705g;

    /* renamed from: h */
    private int[] f1706h;

    /* renamed from: i */
    private int[] f1707i;

    /* renamed from: j */
    private int[] f1708j;

    /* renamed from: k */
    private int f1709k;

    /* renamed from: l */
    private VelocityTracker f1710l;

    /* renamed from: m */
    private float f1711m;

    /* renamed from: n */
    private float f1712n;

    /* renamed from: o */
    private int f1713o;

    /* renamed from: p */
    private int f1714p;

    /* renamed from: q */
    private ScrollerCompat f1715q;

    /* renamed from: r */
    private final Callback f1716r;

    /* renamed from: s */
    private View f1717s;

    /* renamed from: t */
    private boolean f1718t;

    /* renamed from: u */
    private final ViewGroup f1719u;

    /* renamed from: w */
    private final Runnable f1720w = new Runnable() {
        public void run() {
            ViewDragHelper.this.mo3474a(0);
        }
    };

    /* renamed from: android.support.v4.widget.ViewDragHelper$Callback */
    public abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
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

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f1719u = viewGroup;
            this.f1716r = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1713o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1700b = viewConfiguration.getScaledTouchSlop();
            this.f1711m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1712n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f1715q = ScrollerCompat.create(context, f1698v);
        }
    }

    /* renamed from: a */
    private float m1198a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    /* renamed from: a */
    private float m1199a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? BitmapDescriptorFactory.HUE_RED : abs > f3 ? f <= BitmapDescriptorFactory.HUE_RED ? -f3 : f3 : f;
    }

    /* renamed from: a */
    private int m1200a(int i, int i2) {
        int i3 = 0;
        if (i < this.f1719u.getLeft() + this.f1713o) {
            i3 = 1;
        }
        if (i2 < this.f1719u.getTop() + this.f1713o) {
            i3 |= 4;
        }
        if (i > this.f1719u.getRight() - this.f1713o) {
            i3 |= 2;
        }
        return i2 > this.f1719u.getBottom() - this.f1713o ? i3 | 8 : i3;
    }

    /* renamed from: a */
    private int m1201a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f1719u.getWidth();
        int i4 = width / 2;
        float a = (m1198a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        int abs = Math.abs(i2);
        return Math.min(abs > 0 ? Math.round(Math.abs(a / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    /* renamed from: a */
    private int m1202a(View view, int i, int i2, int i3, int i4) {
        int b = m1210b(i3, (int) this.f1712n, (int) this.f1711m);
        int b2 = m1210b(i4, (int) this.f1712n, (int) this.f1711m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m1201a(i2, b2, this.f1716r.getViewVerticalDragRange(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m1201a(i, b, this.f1716r.getViewHorizontalDragRange(view)))));
    }

    /* renamed from: a */
    private void m1203a() {
        if (this.f1702d != null) {
            Arrays.fill(this.f1702d, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f1703e, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f1704f, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f1705g, BitmapDescriptorFactory.HUE_RED);
            Arrays.fill(this.f1706h, 0);
            Arrays.fill(this.f1707i, 0);
            Arrays.fill(this.f1708j, 0);
            this.f1709k = 0;
        }
    }

    /* renamed from: a */
    private void m1204a(float f, float f2) {
        this.f1718t = true;
        this.f1716r.onViewReleased(this.f1717s, f, f2);
        this.f1718t = false;
        if (this.f1699a == 1) {
            mo3474a(0);
        }
    }

    /* renamed from: a */
    private void m1205a(float f, float f2, int i) {
        m1215c(i);
        float[] fArr = this.f1702d;
        this.f1704f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f1703e;
        this.f1705g[i] = f2;
        fArr2[i] = f2;
        this.f1706h[i] = m1200a((int) f, (int) f2);
        this.f1709k |= 1 << i;
    }

    /* renamed from: a */
    private void m1206a(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
            float x = MotionEventCompat.getX(motionEvent, i);
            float y = MotionEventCompat.getY(motionEvent, i);
            this.f1704f[pointerId] = x;
            this.f1705g[pointerId] = y;
        }
    }

    /* renamed from: a */
    private boolean m1207a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1706h[i] & i2) != i2 || (this.f1714p & i2) == 0 || (this.f1708j[i] & i2) == i2 || (this.f1707i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f1700b) && abs2 <= ((float) this.f1700b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f1716r.onEdgeLock(i2)) {
            return (this.f1707i[i] & i2) == 0 && abs > ((float) this.f1700b);
        }
        int[] iArr = this.f1708j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    /* renamed from: a */
    private boolean m1208a(int i, int i2, int i3, int i4) {
        int left = this.f1717s.getLeft();
        int top = this.f1717s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1715q.abortAnimation();
            mo3474a(0);
            return false;
        }
        this.f1715q.startScroll(left, top, i5, i6, m1202a(this.f1717s, i5, i6, i3, i4));
        mo3474a(2);
        return true;
    }

    /* renamed from: a */
    private boolean m1209a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f1716r.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.f1716r.getViewVerticalDragRange(view) > 0;
        if (z && z2) {
            return (f * f) + (f2 * f2) > ((float) (this.f1700b * this.f1700b));
        }
        if (z) {
            return Math.abs(f) > ((float) this.f1700b);
        }
        if (z2) {
            return Math.abs(f2) > ((float) this.f1700b);
        }
        return false;
    }

    /* renamed from: b */
    private int m1210b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    /* renamed from: b */
    private void m1211b() {
        this.f1710l.computeCurrentVelocity(1000, this.f1711m);
        m1204a(m1199a(VelocityTrackerCompat.getXVelocity(this.f1710l, this.f1701c), this.f1712n, this.f1711m), m1199a(VelocityTrackerCompat.getYVelocity(this.f1710l, this.f1701c), this.f1712n, this.f1711m));
    }

    /* renamed from: b */
    private void m1212b(float f, float f2, int i) {
        int i2 = 1;
        if (!m1207a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m1207a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m1207a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m1207a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1707i;
            iArr[i] = iArr[i] | i2;
            this.f1716r.onEdgeDragStarted(i2, i);
        }
    }

    /* renamed from: b */
    private void m1213b(int i) {
        if (this.f1702d != null) {
            this.f1702d[i] = 0.0f;
            this.f1703e[i] = 0.0f;
            this.f1704f[i] = 0.0f;
            this.f1705g[i] = 0.0f;
            this.f1706h[i] = 0;
            this.f1707i[i] = 0;
            this.f1708j[i] = 0;
            this.f1709k &= (1 << i) ^ -1;
        }
    }

    /* renamed from: b */
    private void m1214b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int left = this.f1717s.getLeft();
        int top = this.f1717s.getTop();
        if (i3 != 0) {
            i5 = this.f1716r.clampViewPositionHorizontal(this.f1717s, i, i3);
            this.f1717s.offsetLeftAndRight(i5 - left);
        } else {
            i5 = i;
        }
        if (i4 != 0) {
            i6 = this.f1716r.clampViewPositionVertical(this.f1717s, i2, i4);
            this.f1717s.offsetTopAndBottom(i6 - top);
        } else {
            i6 = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f1716r.onViewPositionChanged(this.f1717s, i5, i6, i5 - left, i6 - top);
        }
    }

    /* renamed from: c */
    private void m1215c(int i) {
        if (this.f1702d == null || this.f1702d.length <= i) {
            float[] fArr = new float[(i + 1)];
            float[] fArr2 = new float[(i + 1)];
            float[] fArr3 = new float[(i + 1)];
            float[] fArr4 = new float[(i + 1)];
            int[] iArr = new int[(i + 1)];
            int[] iArr2 = new int[(i + 1)];
            int[] iArr3 = new int[(i + 1)];
            if (this.f1702d != null) {
                System.arraycopy(this.f1702d, 0, fArr, 0, this.f1702d.length);
                System.arraycopy(this.f1703e, 0, fArr2, 0, this.f1703e.length);
                System.arraycopy(this.f1704f, 0, fArr3, 0, this.f1704f.length);
                System.arraycopy(this.f1705g, 0, fArr4, 0, this.f1705g.length);
                System.arraycopy(this.f1706h, 0, iArr, 0, this.f1706h.length);
                System.arraycopy(this.f1707i, 0, iArr2, 0, this.f1707i.length);
                System.arraycopy(this.f1708j, 0, iArr3, 0, this.f1708j.length);
            }
            this.f1702d = fArr;
            this.f1703e = fArr2;
            this.f1704f = fArr3;
            this.f1705g = fArr4;
            this.f1706h = iArr;
            this.f1707i = iArr2;
            this.f1708j = iArr3;
        }
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.f1700b = (int) (((float) create.f1700b) * (1.0f / f));
        return create;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3474a(int i) {
        this.f1719u.removeCallbacks(this.f1720w);
        if (this.f1699a != i) {
            this.f1699a = i;
            this.f1716r.onViewDragStateChanged(i);
            if (this.f1699a == 0) {
                this.f1717s = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3475a(View view, int i) {
        if (view == this.f1717s && this.f1701c == i) {
            return true;
        }
        if (view == null || !this.f1716r.tryCaptureView(view, i)) {
            return false;
        }
        this.f1701c = i;
        captureChildView(view, i);
        return true;
    }

    public void abort() {
        cancel();
        if (this.f1699a == 2) {
            int currX = this.f1715q.getCurrX();
            int currY = this.f1715q.getCurrY();
            this.f1715q.abortAnimation();
            int currX2 = this.f1715q.getCurrX();
            int currY2 = this.f1715q.getCurrY();
            this.f1716r.onViewPositionChanged(this.f1717s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        mo3474a(0);
    }

    public void cancel() {
        this.f1701c = -1;
        m1203a();
        if (this.f1710l != null) {
            this.f1710l.recycle();
            this.f1710l = null;
        }
    }

    public void captureChildView(View view, int i) {
        if (view.getParent() != this.f1719u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1719u + ")");
        }
        this.f1717s = view;
        this.f1701c = i;
        this.f1716r.onViewCaptured(view, i);
        mo3474a(1);
    }

    public boolean checkTouchSlop(int i) {
        int length = this.f1702d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (checkTouchSlop(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i, int i2) {
        if (!isPointerDown(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f1704f[i2] - this.f1702d[i2];
        float f2 = this.f1705g[i2] - this.f1703e[i2];
        if (z && z2) {
            return (f * f) + (f2 * f2) > ((float) (this.f1700b * this.f1700b));
        }
        if (z) {
            return Math.abs(f) > ((float) this.f1700b);
        }
        if (z2) {
            return Math.abs(f2) > ((float) this.f1700b);
        }
        return false;
    }

    public boolean continueSettling(boolean z) {
        boolean z2;
        if (this.f1699a == 2) {
            boolean computeScrollOffset = this.f1715q.computeScrollOffset();
            int currX = this.f1715q.getCurrX();
            int currY = this.f1715q.getCurrY();
            int left = currX - this.f1717s.getLeft();
            int top = currY - this.f1717s.getTop();
            if (left != 0) {
                this.f1717s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f1717s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f1716r.onViewPositionChanged(this.f1717s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f1715q.getFinalX() && currY == this.f1715q.getFinalY()) {
                this.f1715q.abortAnimation();
                z2 = false;
            } else {
                z2 = computeScrollOffset;
            }
            if (!z2) {
                if (z) {
                    this.f1719u.post(this.f1720w);
                } else {
                    mo3474a(0);
                }
            }
        }
        return this.f1699a == 2;
    }

    public View findTopChildUnder(int i, int i2) {
        for (int childCount = this.f1719u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1719u.getChildAt(this.f1716r.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (!this.f1718t) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.f1715q.fling(this.f1717s.getLeft(), this.f1717s.getTop(), (int) VelocityTrackerCompat.getXVelocity(this.f1710l, this.f1701c), (int) VelocityTrackerCompat.getYVelocity(this.f1710l, this.f1701c), i, i3, i2, i4);
        mo3474a(2);
    }

    public int getActivePointerId() {
        return this.f1701c;
    }

    public View getCapturedView() {
        return this.f1717s;
    }

    public int getEdgeSize() {
        return this.f1713o;
    }

    public float getMinVelocity() {
        return this.f1712n;
    }

    public int getTouchSlop() {
        return this.f1700b;
    }

    public int getViewDragState() {
        return this.f1699a;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.f1717s, i, i2);
    }

    public boolean isEdgeTouched(int i) {
        int length = this.f1706h.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (isEdgeTouched(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (this.f1706h[i2] & i) != 0;
    }

    public boolean isPointerDown(int i) {
        return (this.f1709k & (1 << i)) != 0;
    }

    public boolean isViewUnder(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2 = 0;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.f1710l == null) {
            this.f1710l = VelocityTracker.obtain();
        }
        this.f1710l.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                View findTopChildUnder = findTopChildUnder((int) x, (int) y);
                m1205a(x, y, pointerId);
                mo3475a(findTopChildUnder, pointerId);
                int i3 = this.f1706h[pointerId];
                if ((this.f1714p & i3) != 0) {
                    this.f1716r.onEdgeTouched(i3 & this.f1714p, pointerId);
                    return;
                }
                return;
            case 1:
                if (this.f1699a == 1) {
                    m1211b();
                }
                cancel();
                return;
            case 2:
                if (this.f1699a == 1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f1701c);
                    float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    int i4 = (int) (x2 - this.f1704f[this.f1701c]);
                    int i5 = (int) (y2 - this.f1705g[this.f1701c]);
                    m1214b(this.f1717s.getLeft() + i4, this.f1717s.getTop() + i5, i4, i5);
                    m1206a(motionEvent);
                    return;
                }
                int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                while (i2 < pointerCount) {
                    int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i2);
                    float x3 = MotionEventCompat.getX(motionEvent, i2);
                    float y3 = MotionEventCompat.getY(motionEvent, i2);
                    float f = x3 - this.f1702d[pointerId2];
                    float f2 = y3 - this.f1703e[pointerId2];
                    m1212b(f, f2, pointerId2);
                    if (this.f1699a != 1) {
                        View findTopChildUnder2 = findTopChildUnder((int) x3, (int) y3);
                        if (!m1209a(findTopChildUnder2, f, f2) || !mo3475a(findTopChildUnder2, pointerId2)) {
                            i2++;
                        }
                    }
                    m1206a(motionEvent);
                    return;
                }
                m1206a(motionEvent);
                return;
            case 3:
                if (this.f1699a == 1) {
                    m1204a((float) BitmapDescriptorFactory.HUE_RED, (float) BitmapDescriptorFactory.HUE_RED);
                }
                cancel();
                return;
            case 5:
                int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                float x4 = MotionEventCompat.getX(motionEvent, actionIndex);
                float y4 = MotionEventCompat.getY(motionEvent, actionIndex);
                m1205a(x4, y4, pointerId3);
                if (this.f1699a == 0) {
                    mo3475a(findTopChildUnder((int) x4, (int) y4), pointerId3);
                    int i6 = this.f1706h[pointerId3];
                    if ((this.f1714p & i6) != 0) {
                        this.f1716r.onEdgeTouched(i6 & this.f1714p, pointerId3);
                        return;
                    }
                    return;
                } else if (isCapturedViewUnder((int) x4, (int) y4)) {
                    mo3475a(this.f1717s, pointerId3);
                    return;
                } else {
                    return;
                }
            case 6:
                int pointerId4 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (this.f1699a == 1 && pointerId4 == this.f1701c) {
                    int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
                    while (true) {
                        if (i2 >= pointerCount2) {
                            i = -1;
                        } else {
                            int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i2);
                            if (pointerId5 != this.f1701c) {
                                if (findTopChildUnder((int) MotionEventCompat.getX(motionEvent, i2), (int) MotionEventCompat.getY(motionEvent, i2)) == this.f1717s && mo3475a(this.f1717s, pointerId5)) {
                                    i = this.f1701c;
                                }
                            }
                            i2++;
                        }
                    }
                    if (i == -1) {
                        m1211b();
                    }
                }
                m1213b(pointerId4);
                return;
            default:
                return;
        }
    }

    public void setEdgeTrackingEnabled(int i) {
        this.f1714p = i;
    }

    public void setMinVelocity(float f) {
        this.f1712n = f;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.f1718t) {
            return m1208a(i, i2, (int) VelocityTrackerCompat.getXVelocity(this.f1710l, this.f1701c), (int) VelocityTrackerCompat.getYVelocity(this.f1710l, this.f1701c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f5, code lost:
        if (r8 != r7) goto L_0x0104;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldInterceptTouchEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            int r0 = android.support.p000v4.view.MotionEventCompat.getActionMasked(r14)
            int r1 = android.support.p000v4.view.MotionEventCompat.getActionIndex(r14)
            if (r0 != 0) goto L_0x000d
            r13.cancel()
        L_0x000d:
            android.view.VelocityTracker r2 = r13.f1710l
            if (r2 != 0) goto L_0x0017
            android.view.VelocityTracker r2 = android.view.VelocityTracker.obtain()
            r13.f1710l = r2
        L_0x0017:
            android.view.VelocityTracker r2 = r13.f1710l
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
            int r0 = r13.f1699a
            r1 = 1
            if (r0 != r1) goto L_0x0126
            r0 = 1
        L_0x0025:
            return r0
        L_0x0026:
            float r0 = r14.getX()
            float r1 = r14.getY()
            r2 = 0
            int r2 = android.support.p000v4.view.MotionEventCompat.getPointerId(r14, r2)
            r13.m1205a((float) r0, (float) r1, (int) r2)
            int r0 = (int) r0
            int r1 = (int) r1
            android.view.View r0 = r13.findTopChildUnder(r0, r1)
            android.view.View r1 = r13.f1717s
            if (r0 != r1) goto L_0x0048
            int r1 = r13.f1699a
            r3 = 2
            if (r1 != r3) goto L_0x0048
            r13.mo3475a((android.view.View) r0, (int) r2)
        L_0x0048:
            int[] r0 = r13.f1706h
            r0 = r0[r2]
            int r1 = r13.f1714p
            r1 = r1 & r0
            if (r1 == 0) goto L_0x001f
            android.support.v4.widget.ViewDragHelper$Callback r1 = r13.f1716r
            int r3 = r13.f1714p
            r0 = r0 & r3
            r1.onEdgeTouched(r0, r2)
            goto L_0x001f
        L_0x005a:
            int r0 = android.support.p000v4.view.MotionEventCompat.getPointerId(r14, r1)
            float r2 = android.support.p000v4.view.MotionEventCompat.getX(r14, r1)
            float r1 = android.support.p000v4.view.MotionEventCompat.getY(r14, r1)
            r13.m1205a((float) r2, (float) r1, (int) r0)
            int r3 = r13.f1699a
            if (r3 != 0) goto L_0x007f
            int[] r1 = r13.f1706h
            r1 = r1[r0]
            int r2 = r13.f1714p
            r2 = r2 & r1
            if (r2 == 0) goto L_0x001f
            android.support.v4.widget.ViewDragHelper$Callback r2 = r13.f1716r
            int r3 = r13.f1714p
            r1 = r1 & r3
            r2.onEdgeTouched(r1, r0)
            goto L_0x001f
        L_0x007f:
            int r3 = r13.f1699a
            r4 = 2
            if (r3 != r4) goto L_0x001f
            int r2 = (int) r2
            int r1 = (int) r1
            android.view.View r1 = r13.findTopChildUnder(r2, r1)
            android.view.View r2 = r13.f1717s
            if (r1 != r2) goto L_0x001f
            r13.mo3475a((android.view.View) r1, (int) r0)
            goto L_0x001f
        L_0x0092:
            float[] r0 = r13.f1702d
            if (r0 == 0) goto L_0x001f
            float[] r0 = r13.f1703e
            if (r0 == 0) goto L_0x001f
            int r2 = android.support.p000v4.view.MotionEventCompat.getPointerCount(r14)
            r0 = 0
            r1 = r0
        L_0x00a0:
            if (r1 >= r2) goto L_0x00fd
            int r3 = android.support.p000v4.view.MotionEventCompat.getPointerId(r14, r1)
            float r0 = android.support.p000v4.view.MotionEventCompat.getX(r14, r1)
            float r4 = android.support.p000v4.view.MotionEventCompat.getY(r14, r1)
            float[] r5 = r13.f1702d
            r5 = r5[r3]
            float r5 = r0 - r5
            float[] r6 = r13.f1703e
            r6 = r6[r3]
            float r6 = r4 - r6
            int r0 = (int) r0
            int r4 = (int) r4
            android.view.View r4 = r13.findTopChildUnder(r0, r4)
            if (r4 == 0) goto L_0x0102
            boolean r0 = r13.m1209a((android.view.View) r4, (float) r5, (float) r6)
            if (r0 == 0) goto L_0x0102
            r0 = 1
        L_0x00c9:
            if (r0 == 0) goto L_0x0104
            int r7 = r4.getLeft()
            int r8 = (int) r5
            int r8 = r8 + r7
            android.support.v4.widget.ViewDragHelper$Callback r9 = r13.f1716r
            int r10 = (int) r5
            int r8 = r9.clampViewPositionHorizontal(r4, r8, r10)
            int r9 = r4.getTop()
            int r10 = (int) r6
            int r10 = r10 + r9
            android.support.v4.widget.ViewDragHelper$Callback r11 = r13.f1716r
            int r12 = (int) r6
            int r10 = r11.clampViewPositionVertical(r4, r10, r12)
            android.support.v4.widget.ViewDragHelper$Callback r11 = r13.f1716r
            int r11 = r11.getViewHorizontalDragRange(r4)
            android.support.v4.widget.ViewDragHelper$Callback r12 = r13.f1716r
            int r12 = r12.getViewVerticalDragRange(r4)
            if (r11 == 0) goto L_0x00f7
            if (r11 <= 0) goto L_0x0104
            if (r8 != r7) goto L_0x0104
        L_0x00f7:
            if (r12 == 0) goto L_0x00fd
            if (r12 <= 0) goto L_0x0104
            if (r10 != r9) goto L_0x0104
        L_0x00fd:
            r13.m1206a((android.view.MotionEvent) r14)
            goto L_0x001f
        L_0x0102:
            r0 = 0
            goto L_0x00c9
        L_0x0104:
            r13.m1212b((float) r5, (float) r6, (int) r3)
            int r5 = r13.f1699a
            r6 = 1
            if (r5 == r6) goto L_0x00fd
            if (r0 == 0) goto L_0x0114
            boolean r0 = r13.mo3475a((android.view.View) r4, (int) r3)
            if (r0 != 0) goto L_0x00fd
        L_0x0114:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x00a0
        L_0x0118:
            int r0 = android.support.p000v4.view.MotionEventCompat.getPointerId(r14, r1)
            r13.m1213b(r0)
            goto L_0x001f
        L_0x0121:
            r13.cancel()
            goto L_0x001f
        L_0x0126:
            r0 = 0
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(View view, int i, int i2) {
        this.f1717s = view;
        this.f1701c = -1;
        boolean a = m1208a(i, i2, 0, 0);
        if (!a && this.f1699a == 0 && this.f1717s != null) {
            this.f1717s = null;
        }
        return a;
    }
}
