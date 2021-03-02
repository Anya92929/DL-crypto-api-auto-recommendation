package p000;

import android.graphics.Rect;
import android.support.p001v4.view.WindowInsetsCompat;
import android.view.WindowInsets;

/* renamed from: eg */
class C1076eg extends WindowInsetsCompat {

    /* renamed from: a */
    private final WindowInsets f4068a;

    C1076eg(WindowInsets windowInsets) {
        this.f4068a = windowInsets;
    }

    public int getSystemWindowInsetLeft() {
        return this.f4068a.getSystemWindowInsetLeft();
    }

    public int getSystemWindowInsetTop() {
        return this.f4068a.getSystemWindowInsetTop();
    }

    public int getSystemWindowInsetRight() {
        return this.f4068a.getSystemWindowInsetRight();
    }

    public int getSystemWindowInsetBottom() {
        return this.f4068a.getSystemWindowInsetBottom();
    }

    public boolean hasSystemWindowInsets() {
        return this.f4068a.hasSystemWindowInsets();
    }

    public boolean hasInsets() {
        return this.f4068a.hasInsets();
    }

    public boolean isConsumed() {
        return this.f4068a.isConsumed();
    }

    public boolean isRound() {
        return this.f4068a.isRound();
    }

    public WindowInsetsCompat consumeSystemWindowInsets() {
        return new C1076eg(this.f4068a.consumeSystemWindowInsets());
    }

    public WindowInsetsCompat replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        return new C1076eg(this.f4068a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    public WindowInsetsCompat replaceSystemWindowInsets(Rect rect) {
        return new C1076eg(this.f4068a.replaceSystemWindowInsets(rect));
    }

    public int getStableInsetTop() {
        return this.f4068a.getStableInsetTop();
    }

    public int getStableInsetLeft() {
        return this.f4068a.getStableInsetLeft();
    }

    public int getStableInsetRight() {
        return this.f4068a.getStableInsetRight();
    }

    public int getStableInsetBottom() {
        return this.f4068a.getStableInsetBottom();
    }

    public boolean hasStableInsets() {
        return this.f4068a.hasStableInsets();
    }

    public WindowInsetsCompat consumeStableInsets() {
        return new C1076eg(this.f4068a.consumeStableInsets());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WindowInsets mo8090a() {
        return this.f4068a;
    }
}
