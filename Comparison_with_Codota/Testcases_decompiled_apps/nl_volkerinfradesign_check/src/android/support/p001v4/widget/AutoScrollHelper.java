package android.support.p001v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.p001v4.view.MotionEventCompat;
import android.support.p001v4.view.ViewCompat;
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
    private static final int f1102r = ViewConfiguration.getTapTimeout();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0390a f1103a = new C0390a();

    /* renamed from: b */
    private final Interpolator f1104b = new AccelerateInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final View f1105c;

    /* renamed from: d */
    private Runnable f1106d;

    /* renamed from: e */
    private float[] f1107e = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: f */
    private float[] f1108f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: g */
    private int f1109g;

    /* renamed from: h */
    private int f1110h;

    /* renamed from: i */
    private float[] f1111i = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: j */
    private float[] f1112j = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};

    /* renamed from: k */
    private float[] f1113k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: l */
    private boolean f1114l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f1115m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f1116n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f1117o;

    /* renamed from: p */
    private boolean f1118p;

    /* renamed from: q */
    private boolean f1119q;

    public abstract boolean canTargetScrollHorizontally(int i);

    public abstract boolean canTargetScrollVertically(int i);

    public abstract void scrollTargetBy(int i, int i2);

    public AutoScrollHelper(View view) {
        this.f1105c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        setMaximumVelocity((float) i, (float) i);
        setMinimumVelocity((float) i2, (float) i2);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(f1102r);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    public AutoScrollHelper setEnabled(boolean z) {
        if (this.f1118p && !z) {
            m2386c();
        }
        this.f1118p = z;
        return this;
    }

    public boolean isEnabled() {
        return this.f1118p;
    }

    public AutoScrollHelper setExclusive(boolean z) {
        this.f1119q = z;
        return this;
    }

    public boolean isExclusive() {
        return this.f1119q;
    }

    public AutoScrollHelper setMaximumVelocity(float f, float f2) {
        this.f1113k[0] = f / 1000.0f;
        this.f1113k[1] = f2 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float f, float f2) {
        this.f1112j[0] = f / 1000.0f;
        this.f1112j[1] = f2 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float f, float f2) {
        this.f1111i[0] = f / 1000.0f;
        this.f1111i[1] = f2 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setEdgeType(int i) {
        this.f1109g = i;
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float f, float f2) {
        this.f1107e[0] = f;
        this.f1107e[1] = f2;
        return this;
    }

    public AutoScrollHelper setMaximumEdges(float f, float f2) {
        this.f1108f[0] = f;
        this.f1108f[1] = f2;
        return this;
    }

    public AutoScrollHelper setActivationDelay(int i) {
        this.f1110h = i;
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int i) {
        this.f1103a.mo2611a(i);
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int i) {
        this.f1103a.mo2613b(i);
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f1118p) {
            return false;
        }
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.f1116n = true;
                this.f1114l = false;
                break;
            case 1:
            case 3:
                m2386c();
                break;
            case 2:
                break;
        }
        this.f1103a.mo2610a(m2375a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1105c.getWidth()), m2375a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1105c.getHeight()));
        if (!this.f1117o && m2377a()) {
            m2382b();
        }
        if (!this.f1119q || !this.f1117o) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m2377a() {
        C0390a aVar = this.f1103a;
        int f = aVar.mo2617f();
        int e = aVar.mo2616e();
        return (f != 0 && canTargetScrollVertically(f)) || (e != 0 && canTargetScrollHorizontally(e));
    }

    /* renamed from: b */
    private void m2382b() {
        if (this.f1106d == null) {
            this.f1106d = new C0391b();
        }
        this.f1117o = true;
        this.f1115m = true;
        if (this.f1114l || this.f1110h <= 0) {
            this.f1106d.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.f1105c, this.f1106d, (long) this.f1110h);
        }
        this.f1114l = true;
    }

    /* renamed from: c */
    private void m2386c() {
        if (this.f1115m) {
            this.f1117o = false;
        } else {
            this.f1103a.mo2612b();
        }
    }

    /* renamed from: a */
    private float m2375a(int i, float f, float f2, float f3) {
        float a = m2374a(this.f1107e[i], f2, this.f1108f[i], f);
        if (a == BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        float f4 = this.f1111i[i];
        float f5 = this.f1112j[i];
        float f6 = this.f1113k[i];
        float f7 = f4 * f3;
        if (a > BitmapDescriptorFactory.HUE_RED) {
            return m2380b(a * f7, f5, f6);
        }
        return -m2380b((-a) * f7, f5, f6);
    }

    /* renamed from: a */
    private float m2374a(float f, float f2, float f3, float f4) {
        float interpolation;
        float b = m2380b(f * f2, (float) BitmapDescriptorFactory.HUE_RED, f3);
        float a = m2372a(f2 - f4, b) - m2372a(f4, b);
        if (a < BitmapDescriptorFactory.HUE_RED) {
            interpolation = -this.f1104b.getInterpolation(-a);
        } else if (a <= BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        } else {
            interpolation = this.f1104b.getInterpolation(a);
        }
        return m2380b(interpolation, -1.0f, 1.0f);
    }

    /* renamed from: a */
    private float m2372a(float f, float f2) {
        if (f2 == BitmapDescriptorFactory.HUE_RED) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        switch (this.f1109g) {
            case 0:
            case 1:
                if (f >= f2) {
                    return BitmapDescriptorFactory.HUE_RED;
                }
                if (f >= BitmapDescriptorFactory.HUE_RED) {
                    return 1.0f - (f / f2);
                }
                if (!this.f1117o || this.f1109g != 1) {
                    return BitmapDescriptorFactory.HUE_RED;
                }
                return 1.0f;
            case 2:
                if (f < BitmapDescriptorFactory.HUE_RED) {
                    return f / (-f2);
                }
                return BitmapDescriptorFactory.HUE_RED;
            default:
                return BitmapDescriptorFactory.HUE_RED;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m2381b(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < i2) {
            return i2;
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static float m2380b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2388d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
        this.f1105c.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* renamed from: android.support.v4.widget.AutoScrollHelper$b */
    class C0391b implements Runnable {
        private C0391b() {
        }

        public void run() {
            if (AutoScrollHelper.this.f1117o) {
                if (AutoScrollHelper.this.f1115m) {
                    boolean unused = AutoScrollHelper.this.f1115m = false;
                    AutoScrollHelper.this.f1103a.mo2609a();
                }
                C0390a c = AutoScrollHelper.this.f1103a;
                if (c.mo2614c() || !AutoScrollHelper.this.m2377a()) {
                    boolean unused2 = AutoScrollHelper.this.f1117o = false;
                    return;
                }
                if (AutoScrollHelper.this.f1116n) {
                    boolean unused3 = AutoScrollHelper.this.f1116n = false;
                    AutoScrollHelper.this.m2388d();
                }
                c.mo2615d();
                AutoScrollHelper.this.scrollTargetBy(c.mo2618g(), c.mo2619h());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.f1105c, this);
            }
        }
    }

    /* renamed from: android.support.v4.widget.AutoScrollHelper$a */
    static class C0390a {

        /* renamed from: a */
        private int f1120a;

        /* renamed from: b */
        private int f1121b;

        /* renamed from: c */
        private float f1122c;

        /* renamed from: d */
        private float f1123d;

        /* renamed from: e */
        private long f1124e = Long.MIN_VALUE;

        /* renamed from: f */
        private long f1125f = 0;

        /* renamed from: g */
        private int f1126g = 0;

        /* renamed from: h */
        private int f1127h = 0;

        /* renamed from: i */
        private long f1128i = -1;

        /* renamed from: j */
        private float f1129j;

        /* renamed from: k */
        private int f1130k;

        /* renamed from: a */
        public void mo2611a(int i) {
            this.f1120a = i;
        }

        /* renamed from: b */
        public void mo2613b(int i) {
            this.f1121b = i;
        }

        /* renamed from: a */
        public void mo2609a() {
            this.f1124e = AnimationUtils.currentAnimationTimeMillis();
            this.f1128i = -1;
            this.f1125f = this.f1124e;
            this.f1129j = 0.5f;
            this.f1126g = 0;
            this.f1127h = 0;
        }

        /* renamed from: b */
        public void mo2612b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1130k = AutoScrollHelper.m2381b((int) (currentAnimationTimeMillis - this.f1124e), 0, this.f1121b);
            this.f1129j = m2394a(currentAnimationTimeMillis);
            this.f1128i = currentAnimationTimeMillis;
        }

        /* renamed from: c */
        public boolean mo2614c() {
            return this.f1128i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1128i + ((long) this.f1130k);
        }

        /* renamed from: a */
        private float m2394a(long j) {
            if (j < this.f1124e) {
                return BitmapDescriptorFactory.HUE_RED;
            }
            if (this.f1128i < 0 || j < this.f1128i) {
                return AutoScrollHelper.m2380b(((float) (j - this.f1124e)) / ((float) this.f1120a), (float) BitmapDescriptorFactory.HUE_RED, 1.0f) * 0.5f;
            }
            return (AutoScrollHelper.m2380b(((float) (j - this.f1128i)) / ((float) this.f1130k), (float) BitmapDescriptorFactory.HUE_RED, 1.0f) * this.f1129j) + (1.0f - this.f1129j);
        }

        /* renamed from: a */
        private float m2393a(float f) {
            return (-4.0f * f * f) + (4.0f * f);
        }

        /* renamed from: d */
        public void mo2615d() {
            if (this.f1125f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float a = m2393a(m2394a(currentAnimationTimeMillis));
            long j = currentAnimationTimeMillis - this.f1125f;
            this.f1125f = currentAnimationTimeMillis;
            this.f1126g = (int) (((float) j) * a * this.f1122c);
            this.f1127h = (int) (((float) j) * a * this.f1123d);
        }

        /* renamed from: a */
        public void mo2610a(float f, float f2) {
            this.f1122c = f;
            this.f1123d = f2;
        }

        /* renamed from: e */
        public int mo2616e() {
            return (int) (this.f1122c / Math.abs(this.f1122c));
        }

        /* renamed from: f */
        public int mo2617f() {
            return (int) (this.f1123d / Math.abs(this.f1123d));
        }

        /* renamed from: g */
        public int mo2618g() {
            return this.f1126g;
        }

        /* renamed from: h */
        public int mo2619h() {
            return this.f1127h;
        }
    }
}
