package android.support.p009v4.view;

import android.view.WindowInsets;

/* renamed from: android.support.v4.view.ff */
class C0336ff extends C0335fe {

    /* renamed from: a */
    private final WindowInsets f403a;

    C0336ff(WindowInsets windowInsets) {
        this.f403a = windowInsets;
    }

    /* renamed from: a */
    public int mo1592a() {
        return this.f403a.getSystemWindowInsetLeft();
    }

    /* renamed from: a */
    public C0335fe mo1593a(int i, int i2, int i3, int i4) {
        return new C0336ff(this.f403a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    /* renamed from: b */
    public int mo1594b() {
        return this.f403a.getSystemWindowInsetTop();
    }

    /* renamed from: c */
    public int mo1595c() {
        return this.f403a.getSystemWindowInsetRight();
    }

    /* renamed from: d */
    public int mo1596d() {
        return this.f403a.getSystemWindowInsetBottom();
    }

    /* renamed from: e */
    public boolean mo1597e() {
        return this.f403a.isConsumed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public WindowInsets mo1598f() {
        return this.f403a;
    }
}
