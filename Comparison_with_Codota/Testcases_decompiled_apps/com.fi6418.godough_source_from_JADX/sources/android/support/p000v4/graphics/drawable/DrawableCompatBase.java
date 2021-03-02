package android.support.p000v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.graphics.drawable.DrawableCompatBase */
class DrawableCompatBase {
    DrawableCompatBase() {
    }

    public static void setTint(Drawable drawable, int i) {
        if (drawable instanceof DrawableWrapper) {
            ((DrawableWrapper) drawable).setTint(i);
        }
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof DrawableWrapper) {
            ((DrawableWrapper) drawable).setTintList(colorStateList);
        }
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
        if (drawable instanceof DrawableWrapper) {
            ((DrawableWrapper) drawable).setTintMode(mode);
        }
    }

    public static Drawable wrapForTinting(Drawable drawable) {
        return !(drawable instanceof DrawableWrapperDonut) ? new DrawableWrapperDonut(drawable) : drawable;
    }
}
