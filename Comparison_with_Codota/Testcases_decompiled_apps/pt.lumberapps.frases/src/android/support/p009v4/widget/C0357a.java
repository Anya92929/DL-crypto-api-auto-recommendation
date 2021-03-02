package android.support.p009v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.p009v4.view.C0223ba;
import android.support.p009v4.view.C0247by;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.widget.a */
public abstract class C0357a implements View.OnTouchListener {

    /* renamed from: r */
    private static final int f483r = ViewConfiguration.getTapTimeout();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0402c f484a = new C0402c();

    /* renamed from: b */
    private final Interpolator f485b = new AccelerateInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final View f486c;

    /* renamed from: d */
    private Runnable f487d;

    /* renamed from: e */
    private float[] f488e = {0.0f, 0.0f};

    /* renamed from: f */
    private float[] f489f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: g */
    private int f490g;

    /* renamed from: h */
    private int f491h;

    /* renamed from: i */
    private float[] f492i = {0.0f, 0.0f};

    /* renamed from: j */
    private float[] f493j = {0.0f, 0.0f};

    /* renamed from: k */
    private float[] f494k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: l */
    private boolean f495l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f496m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f497n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f498o;

    /* renamed from: p */
    private boolean f499p;

    /* renamed from: q */
    private boolean f500q;

    public C0357a(View view) {
        this.f486c = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        mo1751a((float) i, (float) i);
        mo1755b((float) i2, (float) i2);
        mo1752a(1);
        mo1761e(Float.MAX_VALUE, Float.MAX_VALUE);
        mo1759d(0.2f, 0.2f);
        mo1757c(1.0f, 1.0f);
        mo1756b(f483r);
        mo1758c(500);
        mo1760d(500);
    }

    /* renamed from: a */
    private float m1432a(float f, float f2, float f3, float f4) {
        float interpolation;
        float b = m1438b(f * f2, 0.0f, f3);
        float f5 = m1449f(f2 - f4, b) - m1449f(f4, b);
        if (f5 < 0.0f) {
            interpolation = -this.f485b.getInterpolation(-f5);
        } else if (f5 <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.f485b.getInterpolation(f5);
        }
        return m1438b(interpolation, -1.0f, 1.0f);
    }

    /* renamed from: a */
    private float m1433a(int i, float f, float f2, float f3) {
        float a = m1432a(this.f488e[i], f2, this.f489f[i], f);
        if (a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f492i[i];
        float f5 = this.f493j[i];
        float f6 = this.f494k[i];
        float f7 = f4 * f3;
        return a > 0.0f ? m1438b(a * f7, f5, f6) : -m1438b((-a) * f7, f5, f6);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m1435a() {
        C0402c cVar = this.f484a;
        int f = cVar.mo1869f();
        int e = cVar.mo1868e();
        return (f != 0 && mo1763f(f)) || (e != 0 && mo1762e(e));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static float m1438b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m1439b(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* renamed from: b */
    private void m1440b() {
        if (this.f487d == null) {
            this.f487d = new C0403d(this);
        }
        this.f498o = true;
        this.f496m = true;
        if (this.f495l || this.f491h <= 0) {
            this.f487d.run();
        } else {
            C0247by.m898a(this.f486c, this.f487d, (long) this.f491h);
        }
        this.f495l = true;
    }

    /* renamed from: c */
    private void m1444c() {
        if (this.f496m) {
            this.f498o = false;
        } else {
            this.f484a.mo1864b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m1446d() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f486c.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* renamed from: f */
    private float m1449f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f490g) {
            case 0:
            case 1:
                if (f < f2) {
                    return f >= 0.0f ? 1.0f - (f / f2) : (!this.f498o || this.f490g != 1) ? 0.0f : 1.0f;
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    /* renamed from: a */
    public C0357a mo1751a(float f, float f2) {
        this.f494k[0] = f / 1000.0f;
        this.f494k[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: a */
    public C0357a mo1752a(int i) {
        this.f490g = i;
        return this;
    }

    /* renamed from: a */
    public C0357a mo1753a(boolean z) {
        if (this.f499p && !z) {
            m1444c();
        }
        this.f499p = z;
        return this;
    }

    /* renamed from: a */
    public abstract void mo1754a(int i, int i2);

    /* renamed from: b */
    public C0357a mo1755b(float f, float f2) {
        this.f493j[0] = f / 1000.0f;
        this.f493j[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: b */
    public C0357a mo1756b(int i) {
        this.f491h = i;
        return this;
    }

    /* renamed from: c */
    public C0357a mo1757c(float f, float f2) {
        this.f492i[0] = f / 1000.0f;
        this.f492i[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: c */
    public C0357a mo1758c(int i) {
        this.f484a.mo1863a(i);
        return this;
    }

    /* renamed from: d */
    public C0357a mo1759d(float f, float f2) {
        this.f488e[0] = f;
        this.f488e[1] = f2;
        return this;
    }

    /* renamed from: d */
    public C0357a mo1760d(int i) {
        this.f484a.mo1865b(i);
        return this;
    }

    /* renamed from: e */
    public C0357a mo1761e(float f, float f2) {
        this.f489f[0] = f;
        this.f489f[1] = f2;
        return this;
    }

    /* renamed from: e */
    public abstract boolean mo1762e(int i);

    /* renamed from: f */
    public abstract boolean mo1763f(int i);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = true;
        if (!this.f499p) {
            return false;
        }
        switch (C0223ba.m828a(motionEvent)) {
            case 0:
                this.f497n = true;
                this.f495l = false;
                break;
            case 1:
            case 3:
                m1444c();
                break;
            case 2:
                break;
        }
        this.f484a.mo1862a(m1433a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f486c.getWidth()), m1433a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f486c.getHeight()));
        if (!this.f498o && m1435a()) {
            m1440b();
        }
        if (!this.f500q || !this.f498o) {
            z = false;
        }
        return z;
    }
}
