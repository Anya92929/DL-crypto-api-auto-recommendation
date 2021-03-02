package com.p046c.p047a;

import android.view.animation.Interpolator;

/* renamed from: com.c.a.n */
public abstract class C1184n implements Cloneable {

    /* renamed from: a */
    float f3293a;

    /* renamed from: b */
    Class f3294b;

    /* renamed from: c */
    boolean f3295c = false;

    /* renamed from: d */
    private Interpolator f3296d = null;

    /* renamed from: a */
    public static C1184n m5397a(float f) {
        return new C1185o(f);
    }

    /* renamed from: a */
    public static C1184n m5398a(float f, float f2) {
        return new C1185o(f, f2);
    }

    /* renamed from: a */
    public void mo4572a(Interpolator interpolator) {
        this.f3296d = interpolator;
    }

    /* renamed from: a */
    public abstract void mo4573a(Object obj);

    /* renamed from: a */
    public boolean mo4574a() {
        return this.f3295c;
    }

    /* renamed from: b */
    public abstract Object mo4575b();

    /* renamed from: c */
    public float mo4576c() {
        return this.f3293a;
    }

    /* renamed from: d */
    public Interpolator mo4578d() {
        return this.f3296d;
    }

    /* renamed from: e */
    public abstract C1184n clone();
}
