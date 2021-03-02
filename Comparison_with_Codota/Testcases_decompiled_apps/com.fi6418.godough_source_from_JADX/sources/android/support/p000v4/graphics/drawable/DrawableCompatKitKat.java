package android.support.p000v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.graphics.drawable.DrawableCompatKitKat */
class DrawableCompatKitKat {
    DrawableCompatKitKat() {
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static Drawable wrapForTinting(Drawable drawable) {
        return !(drawable instanceof DrawableWrapperKitKat) ? new DrawableWrapperKitKat(drawable) : drawable;
    }
}
