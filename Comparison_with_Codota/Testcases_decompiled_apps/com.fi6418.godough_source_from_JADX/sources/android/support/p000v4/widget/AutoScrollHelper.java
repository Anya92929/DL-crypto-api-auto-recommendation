package android.support.p000v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.p000v4.view.MotionEventCompat;
import android.support.p000v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: android.support.v4.widget.AutoScrollHelper */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;

    /* renamed from: r */
    private static final int f1382r = ViewConfiguration.getTapTimeout();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ClampedScroller f1383a = new ClampedScroller();

    /* renamed from: b */
    private final Interpolator f1384b = new AccelerateInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final View f1385c;

    /* renamed from: d */
    private Runnable f1386d;

    /* renamed from: e */
    private float[] f1387e = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: f */
    private float[] f1388f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: g */
    private int f1389g;

    /* renamed from: h */
    private int f1390h;

    /* renamed from: i */
    private float[] f1391i = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: j */
    private float[] f1392j = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: k */
    private float[] f1393k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: l */
    private boolean f1394l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f1395m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f1396n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f1397o;

    /* renamed from: p */
    private boolean f1398p;

    /* renamed from: q */
    private boolean f1399q;

    /* renamed from: android.support.v4.widget.AutoScrollHelper$ClampedScroller */
    class ClampedScroller {

        /* renamed from: a */
        private int f1400a;

        /* renamed from: b */
        private int f1401b;

        /* renamed from: c */
        private float f1402c;

        /* renamed from: d */
        private float f1403d;

        /* renamed from: e */
        private long f1404e = Long.MIN_VALUE;

        /* renamed from: f */
        private long f1405f = 0;

        /* renamed from: g */
        private int f1406g = 0;

        /* renamed from: h */
        private int f1407h = 0;

        /* renamed from: i */
        private long f1408i = -1;

        /* renamed from: j */
        private float f1409j;

        /* renamed from: k */
        private int f1410k;

        /* renamed from: a */
        private float m1010a(float f) {
            return (-4.0f * f * f) + (4.0f * f);
        }

        /* renamed from: a */
        private float m1011a(long j) {
            if (j < this.f1404e) {
                return BitmapDescriptorFactory.HUE_RED;
            }
            if (this.f1408i < 0 || j < this.f1408i) {
                return AutoScrollHelper.m997b(((float) (j - this.f1404e)) / ((float) this.f1400a), (float) BitmapDescriptorFactory.HUE_RED, 1.0f) * 0.5f;
            }
            return (AutoScrollHelper.m997b(((float) (j - this.f1408i)) / ((float) this.f1410k), (float) BitmapDescriptorFactory.HUE_RED, 1.0f) * this.f1409j) + (1.0f - this.f1409j);
        }

        public void computeScrollDelta() {
            if (this.f1405f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = m1010a(m1011a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f1405f;
            this.f1405f = currentAnimationTimeMillis;
            this.f1406g = (int) (((float) j) * a * this.f1402c);
            this.f1407h = (int) (((float) j) * a * this.f1403d);
        }

        public int getDeltaX() {
            return this.f1406g;
        }

        public int getDeltaY() {
            return this.f1407h;
        }

        public int getHorizontalDirection() {
            return (int) (this.f1402c / Math.abs(this.f1402c));
        }

        public int getVerticalDirection() {
            return (int) (this.f1403d / Math.abs(this.f1403d));
        }

        public boolean isFinished() {
            return this.f1408i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1408i + ((long) this.f1410k);
        }

        public void requestStop() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1410k = AutoScrollHelper.m998b((int) (currentAnimationTimeMillis - this.f1404e), 0, this.f1401b);
            this.f1409j = m1011a(currentAnimationTimeMillis);
            this.f1408i = currentAnimationTimeMillis;
        }

        public void setRampDownDuration(int i) {
            this.f1401b = i;
        }

        public void setRampUpDuration(int i) {
            this.f1400a = i;
        }

        public void setTargetVelocity(float f, float f2) {
            this.f1402c = f;
            this.f1403d = f2;
        }

        public void start() {
            this.f1404e = AnimationUtils.currentAnimationTimeMillis();
            this.f1408i = -1;
            this.f1405f = this.f1404e;
            this.f1409j = 0.5f;
            this.f1406g = 0;
            this.f1407h = 0;
        }
    }

    /* renamed from: android.support.v4.widget.AutoScrollHelper$ScrollAnimationRunnable */
    class ScrollAnimationRunnable implements Runnable {
        private ScrollAnimationRunnable() {
        }

        public void run() {
            if (AutoScrollHelper.this.f1397o) {
                if (AutoScrollHelper.this.f1395m) {
                    boolean unused = AutoScrollHelper.this.f1395m = false;
                    AutoScrollHelper.this.f1383a.start();
                }
                ClampedScroller c = AutoScrollHelper.this.f1383a;
                if (c.isFinished() || !AutoScrollHelper.this.m994a()) {
                    boolean unused2 = AutoScrollHelper.this.f1397o = false;
                    return;
                }
                if (AutoScrollHelper.this.f1396n) {
                    boolean unused3 = AutoScrollHelper.this.f1396n = false;
                    AutoScrollHelper.this.m1005d();
                }
                c.computeScrollDelta();
                AutoScrollHelper.this.scrollTargetBy(c.getDeltaX(), c.getDeltaY());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.f1385c, this);
            }
        }
    }

    public AutoScrollHelper(View view) {
        this.f1385c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        setMaximumVelocity((float) i, (float) i);
        setMinimumVelocity((float) i2, (float) i2);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(f1382r);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    /* renamed from: a */
    private float m989a(float f, float f2) {
        if (f2 == BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        switch (this.f1389g) {
            case 0:
            case 1:
                if (f >= f2) {
                    return BitmapDescriptorFactory.HUE_RED;
                }
                if (f >= BitmapDescriptorFactory.HUE_RED) {
                    return 1.0f - (f / f2);
                }
                if (!this.f1397o || this.f1389g != 1) {
                    return BitmapDescriptorFactory.HUE_RED;
                }
                return 1.0f;
            case 2:
                return f < BitmapDescriptorFactory.HUE_RED ? f / (-f2) : BitmapDescriptorFactory.HUE_RED;
            default:
                return BitmapDescriptorFactory.HUE_RED;
        }
    }

    /* renamed from: a */
    private float m991a(float f, float f2, float f3, float f4) {
        float interpolation;
        float b = m997b(f * f2, (float) BitmapDescriptorFactory.HUE_RED, f3);
        float a = m989a(f2 - f4, b) - m989a(f4, b);
        if (a < BitmapDescriptorFactory.HUE_RED) {
            interpolation = -this.f1384b.getInterpolation(-a);
        } else if (a <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        } else {
            interpolation = this.f1384b.getInterpolation(a);
        }
        return m997b(interpolation, -1.0f, 1.0f);
    }

    /* renamed from: a */
    private float m992a(int i, float f, float f2, float f3) {
        float a = m991a(this.f1387e[i], f2, this.f1388f[i], f);
        if (a == BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        float f4 = this.f1391i[i];
        float f5 = this.f1392j[i];
        float f6 = this.f1393k[i];
        float f7 = f4 * f3;
        return a > BitmapDescriptorFactory.HUE_RED ? m997b(a * f7, f5, f6) : -m997b((-a) * f7, f5, f6);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m994a() {
        ClampedScroller clampedScroller = this.f1383a;
        int verticalDirection = clampedScroller.getVerticalDirection();
        int horizontalDirection = clampedScroller.getHorizontalDirection();
        return (verticalDirection != 0 && canTargetScrollVertically(verticalDirection)) || (horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static float m997b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m998b(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* renamed from: b */
    private void m999b() {
        if (this.f1386d == null) {
            this.f1386d = new ScrollAnimationRunnable();
        }
        this.f1397o = true;
        this.f1395m = true;
        if (this.f1394l || this.f1390h <= 0) {
            this.f1386d.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.f1385c, this.f1386d, (long) this.f1390h);
        }
        this.f1394l = true;
    }

    /* renamed from: c */
    private void m1003c() {
        if (this.f1395m) {
            this.f1397o = false;
        } else {
            this.f1383a.requestStop();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m1005d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
        this.f1385c.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract boolean canTargetScrollHorizontally(int i);

    public abstract boolean canTargetScrollVertically(int i);

    public boolean isEnabled() {
        return this.f1398p;
    }

    public boolean isExclusive() {
        return this.f1399q;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f1398p) {
            return false;
        }
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.f1396n = true;
                this.f1394l = false;
                break;
            case 1:
            case 3:
                m1003c();
                break;
            case 2:
                break;
        }
        this.f1383a.setTargetVelocity(m992a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1385c.getWidth()), m992a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1385c.getHeight()));
        if (!this.f1397o && m994a()) {
            m999b();
        }
        if (!this.f1399q || !this.f1397o) {
            z = false;
        }
        return z;
    }

    public abstract void scrollTargetBy(int i, int i2);

    public AutoScrollHelper setActivationDelay(int i) {
        this.f1390h = i;
        return this;
    }

    public AutoScrollHelper setEdgeType(int i) {
        this.f1389g = i;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z) {
        if (this.f1398p && !z) {
            m1003c();
        }
        this.f1398p = z;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z) {
        this.f1399q = z;
        return this;
    }

    public AutoScrollHelper setMaximumEdges(float f, float f2) {
        this.f1388f[0] = f;
        this.f1388f[1] = f2;
        return this;
    }

    public AutoScrollHelper setMaximumVelocity(float f, float f2) {
        this.f1393k[0] = f / 1000.0f;
        this.f1393k[1] = f2 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float f, float f2) {
        this.f1392j[0] = f / 1000.0f;
        this.f1392j[1] = f2 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int i) {
        this.f1383a.setRampDownDuration(i);
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int i) {
        this.f1383a.setRampUpDuration(i);
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float f, float f2) {
        this.f1387e[0] = f;
        this.f1387e[1] = f2;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float f, float f2) {
        this.f1391i[0] = f / 1000.0f;
        this.f1391i[1] = f2 / 1000.0f;
        return this;
    }
}
