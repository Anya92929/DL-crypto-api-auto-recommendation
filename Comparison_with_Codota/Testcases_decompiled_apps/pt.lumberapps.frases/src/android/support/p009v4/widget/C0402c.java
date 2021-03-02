package android.support.p009v4.widget;

import android.view.animation.AnimationUtils;

/* renamed from: android.support.v4.widget.c */
class C0402c {

    /* renamed from: a */
    private int f543a;

    /* renamed from: b */
    private int f544b;

    /* renamed from: c */
    private float f545c;

    /* renamed from: d */
    private float f546d;

    /* renamed from: e */
    private long f547e = Long.MIN_VALUE;

    /* renamed from: f */
    private long f548f = 0;

    /* renamed from: g */
    private int f549g = 0;

    /* renamed from: h */
    private int f550h = 0;

    /* renamed from: i */
    private long f551i = -1;

    /* renamed from: j */
    private float f552j;

    /* renamed from: k */
    private int f553k;

    /* renamed from: a */
    private float m1691a(float f) {
        return (-4.0f * f * f) + (4.0f * f);
    }

    /* renamed from: a */
    private float m1692a(long j) {
        if (j < this.f547e) {
            return 0.0f;
        }
        if (this.f551i < 0 || j < this.f551i) {
            return C0357a.m1438b(((float) (j - this.f547e)) / ((float) this.f543a), 0.0f, 1.0f) * 0.5f;
        }
        return (C0357a.m1438b(((float) (j - this.f551i)) / ((float) this.f553k), 0.0f, 1.0f) * this.f552j) + (1.0f - this.f552j);
    }

    /* renamed from: a */
    public void mo1861a() {
        this.f547e = AnimationUtils.currentAnimationTimeMillis();
        this.f551i = -1;
        this.f548f = this.f547e;
        this.f552j = 0.5f;
        this.f549g = 0;
        this.f550h = 0;
    }

    /* renamed from: a */
    public void mo1862a(float f, float f2) {
        this.f545c = f;
        this.f546d = f2;
    }

    /* renamed from: a */
    public void mo1863a(int i) {
        this.f543a = i;
    }

    /* renamed from: b */
    public void mo1864b() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f553k = C0357a.m1439b((int) (currentAnimationTimeMillis - this.f547e), 0, this.f544b);
        this.f552j = m1692a(currentAnimationTimeMillis);
        this.f551i = currentAnimationTimeMillis;
    }

    /* renamed from: b */
    public void mo1865b(int i) {
        this.f544b = i;
    }

    /* renamed from: c */
    public boolean mo1866c() {
        return this.f551i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f551i + ((long) this.f553k);
    }

    /* renamed from: d */
    public void mo1867d() {
        if (this.f548f == 0) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float a = m1691a(m1692a(currentAnimationTimeMillis));
        long j = currentAnimationTimeMillis - this.f548f;
        this.f548f = currentAnimationTimeMillis;
        this.f549g = (int) (((float) j) * a * this.f545c);
        this.f550h = (int) (((float) j) * a * this.f546d);
    }

    /* renamed from: e */
    public int mo1868e() {
        return (int) (this.f545c / Math.abs(this.f545c));
    }

    /* renamed from: f */
    public int mo1869f() {
        return (int) (this.f546d / Math.abs(this.f546d));
    }

    /* renamed from: g */
    public int mo1870g() {
        return this.f549g;
    }

    /* renamed from: h */
    public int mo1871h() {
        return this.f550h;
    }
}
