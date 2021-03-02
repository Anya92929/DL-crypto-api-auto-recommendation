package android.support.p009v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;

/* renamed from: android.support.v4.widget.af */
public final class C0363af {

    /* renamed from: b */
    private static final C0366ai f507b;

    /* renamed from: a */
    private Object f508a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f507b = new C0367aj();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f507b = new C0365ah();
        } else {
            f507b = new C0364ag();
        }
    }

    public C0363af(Context context) {
        this.f508a = f507b.mo1788a(context);
    }

    /* renamed from: a */
    public void mo1780a(int i, int i2) {
        f507b.mo1789a(this.f508a, i, i2);
    }

    /* renamed from: a */
    public boolean mo1781a() {
        return f507b.mo1790a(this.f508a);
    }

    /* renamed from: a */
    public boolean mo1782a(float f) {
        return f507b.mo1791a(this.f508a, f);
    }

    /* renamed from: a */
    public boolean mo1783a(float f, float f2) {
        return f507b.mo1792a(this.f508a, f, f2);
    }

    /* renamed from: a */
    public boolean mo1784a(int i) {
        return f507b.mo1793a(this.f508a, i);
    }

    /* renamed from: a */
    public boolean mo1785a(Canvas canvas) {
        return f507b.mo1794a(this.f508a, canvas);
    }

    /* renamed from: b */
    public void mo1786b() {
        f507b.mo1795b(this.f508a);
    }

    /* renamed from: c */
    public boolean mo1787c() {
        return f507b.mo1796c(this.f508a);
    }
}
