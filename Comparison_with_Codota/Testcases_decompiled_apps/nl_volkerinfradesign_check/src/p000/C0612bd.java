package p000;

import android.graphics.drawable.Drawable;

/* renamed from: bd */
public class C0612bd {
    /* renamed from: a */
    public static void m3420a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    /* renamed from: b */
    public static Drawable m3421b(Drawable drawable) {
        if (!(drawable instanceof C0617bi)) {
            return new C0617bi(drawable);
        }
        return drawable;
    }
}
