package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p001v4.graphics.drawable.DrawableWrapper;

/* renamed from: bc */
public class C0611bc {
    /* renamed from: a */
    public static void m3417a(Drawable drawable, int i) {
        if (drawable instanceof DrawableWrapper) {
            ((DrawableWrapper) drawable).setTint(i);
        }
    }

    /* renamed from: a */
    public static void m3418a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof DrawableWrapper) {
            ((DrawableWrapper) drawable).setTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m3419a(Drawable drawable, PorterDuff.Mode mode) {
        if (drawable instanceof DrawableWrapper) {
            ((DrawableWrapper) drawable).setTintMode(mode);
        }
    }

    /* renamed from: a */
    public static Drawable m3416a(Drawable drawable) {
        if (!(drawable instanceof C0616bh)) {
            return new C0616bh(drawable);
        }
        return drawable;
    }
}
