package android.support.p000v4.view;

import android.graphics.Rect;
import android.view.WindowInsets;

/* renamed from: android.support.v4.view.WindowInsetsCompatApi21 */
class WindowInsetsCompatApi21 extends WindowInsetsCompat {

    /* renamed from: a */
    private final WindowInsets f1350a;

    WindowInsetsCompatApi21(WindowInsets windowInsets) {
        this.f1350a = windowInsets;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WindowInsets mo2606a() {
        return this.f1350a;
    }

    public WindowInsetsCompat consumeStableInsets() {
        return new WindowInsetsCompatApi21(this.f1350a.consumeStableInsets());
    }

    public WindowInsetsCompat consumeSystemWindowInsets() {
        return new WindowInsetsCompatApi21(this.f1350a.consumeSystemWindowInsets());
    }

    public int getStableInsetBottom() {
        return this.f1350a.getStableInsetBottom();
    }

    public int getStableInsetLeft() {
        return this.f1350a.getStableInsetLeft();
    }

    public int getStableInsetRight() {
        return this.f1350a.getStableInsetRight();
    }

    public int getStableInsetTop() {
        return this.f1350a.getStableInsetTop();
    }

    public int getSystemWindowInsetBottom() {
        return this.f1350a.getSystemWindowInsetBottom();
    }

    public int getSystemWindowInsetLeft() {
        return this.f1350a.getSystemWindowInsetLeft();
    }

    public int getSystemWindowInsetRight() {
        return this.f1350a.getSystemWindowInsetRight();
    }

    public int getSystemWindowInsetTop() {
        return this.f1350a.getSystemWindowInsetTop();
    }

    public boolean hasInsets() {
        return this.f1350a.hasInsets();
    }

    public boolean hasStableInsets() {
        return this.f1350a.hasStableInsets();
    }

    public boolean hasSystemWindowInsets() {
        return this.f1350a.hasSystemWindowInsets();
    }

    public boolean isConsumed() {
        return this.f1350a.isConsumed();
    }

    public boolean isRound() {
        return this.f1350a.isRound();
    }

    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        return new WindowInsetsCompatApi21(this.f1350a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    public WindowInsetsCompat replaceSystemWindowInsets(Rect rect) {
        return new WindowInsetsCompatApi21(this.f1350a.replaceSystemWindowInsets(rect));
    }
}
