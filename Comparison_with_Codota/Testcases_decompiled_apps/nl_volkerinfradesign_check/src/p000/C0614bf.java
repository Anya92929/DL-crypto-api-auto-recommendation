package p000;

import android.graphics.drawable.Drawable;

/* renamed from: bf */
public class C0614bf {
    /* renamed from: a */
    public static void m3424a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    /* renamed from: a */
    public static boolean m3425a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    /* renamed from: b */
    public static Drawable m3426b(Drawable drawable) {
        if (!(drawable instanceof C0618bj)) {
            return new C0618bj(drawable);
        }
        return drawable;
    }
}
