package android.support.p009v4.p012b.p013a;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.b.a.o */
class C0111o {
    /* renamed from: a */
    public static void m278a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    /* renamed from: a */
    public static boolean m279a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    /* renamed from: b */
    public static Drawable m280b(Drawable drawable) {
        return !(drawable instanceof C0121y) ? new C0121y(drawable) : drawable;
    }

    /* renamed from: c */
    public static int m281c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
