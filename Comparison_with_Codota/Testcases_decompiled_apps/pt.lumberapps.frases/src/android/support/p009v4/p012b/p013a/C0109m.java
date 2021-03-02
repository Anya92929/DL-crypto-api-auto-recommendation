package android.support.p009v4.p012b.p013a;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.b.a.m */
class C0109m {
    /* renamed from: a */
    public static void m274a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    /* renamed from: b */
    public static Drawable m275b(Drawable drawable) {
        return !(drawable instanceof C0119w) ? new C0119w(drawable) : drawable;
    }
}
