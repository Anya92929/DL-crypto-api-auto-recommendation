package android.support.p009v4.widget;

import android.content.Context;
import android.os.Build;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.widget.bf */
public final class C0390bf {

    /* renamed from: a */
    Object f517a;

    /* renamed from: b */
    C0391bg f518b;

    private C0390bf(int i, Context context, Interpolator interpolator) {
        if (i >= 14) {
            this.f518b = new C0394bj();
        } else if (i >= 9) {
            this.f518b = new C0393bi();
        } else {
            this.f518b = new C0392bh();
        }
        this.f517a = this.f518b.mo1820a(context, interpolator);
    }

    /* renamed from: a */
    public static C0390bf m1564a(Context context) {
        return m1565a(context, (Interpolator) null);
    }

    /* renamed from: a */
    public static C0390bf m1565a(Context context, Interpolator interpolator) {
        return new C0390bf(Build.VERSION.SDK_INT, context, interpolator);
    }

    /* renamed from: a */
    public void mo1807a(int i, int i2, int i3, int i4) {
        this.f518b.mo1821a(this.f517a, i, i2, i3, i4);
    }

    /* renamed from: a */
    public void mo1808a(int i, int i2, int i3, int i4, int i5) {
        this.f518b.mo1822a(this.f517a, i, i2, i3, i4, i5);
    }

    /* renamed from: a */
    public void mo1809a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f518b.mo1823a(this.f517a, i, i2, i3, i4, i5, i6, i7, i8);
    }

    /* renamed from: a */
    public void mo1810a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f518b.mo1824a(this.f517a, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    /* renamed from: a */
    public boolean mo1811a() {
        return this.f518b.mo1825a(this.f517a);
    }

    /* renamed from: a */
    public boolean mo1812a(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.f518b.mo1826a(this.f517a, i, i2, i3, i4, i5, i6);
    }

    /* renamed from: b */
    public int mo1813b() {
        return this.f518b.mo1827b(this.f517a);
    }

    /* renamed from: c */
    public int mo1814c() {
        return this.f518b.mo1828c(this.f517a);
    }

    /* renamed from: d */
    public int mo1815d() {
        return this.f518b.mo1832g(this.f517a);
    }

    /* renamed from: e */
    public int mo1816e() {
        return this.f518b.mo1833h(this.f517a);
    }

    /* renamed from: f */
    public float mo1817f() {
        return this.f518b.mo1829d(this.f517a);
    }

    /* renamed from: g */
    public boolean mo1818g() {
        return this.f518b.mo1830e(this.f517a);
    }

    /* renamed from: h */
    public void mo1819h() {
        this.f518b.mo1831f(this.f517a);
    }
}
