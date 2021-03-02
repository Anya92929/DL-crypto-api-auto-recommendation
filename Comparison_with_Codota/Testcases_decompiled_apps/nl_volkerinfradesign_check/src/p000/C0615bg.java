package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;

/* renamed from: bg */
public class C0615bg {
    /* renamed from: a */
    public static void m3428a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    /* renamed from: a */
    public static void m3430a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    /* renamed from: a */
    public static void m3429a(Drawable drawable, int i) {
        if (drawable instanceof C0619bk) {
            C0611bc.m3417a(drawable, i);
        } else {
            drawable.setTint(i);
        }
    }

    /* renamed from: a */
    public static void m3431a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0619bk) {
            C0611bc.m3418a(drawable, colorStateList);
        } else {
            drawable.setTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m3432a(Drawable drawable, PorterDuff.Mode mode) {
        if (drawable instanceof C0619bk) {
            C0611bc.m3419a(drawable, mode);
        } else {
            drawable.setTintMode(mode);
        }
    }

    /* renamed from: a */
    public static Drawable m3427a(Drawable drawable) {
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer)) {
            return new C0619bk(drawable);
        }
        return drawable;
    }
}
