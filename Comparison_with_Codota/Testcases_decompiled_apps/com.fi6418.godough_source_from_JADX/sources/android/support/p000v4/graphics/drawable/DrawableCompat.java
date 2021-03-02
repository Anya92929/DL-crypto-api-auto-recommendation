package android.support.p000v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* renamed from: android.support.v4.graphics.drawable.DrawableCompat */
public class DrawableCompat {

    /* renamed from: a */
    static final DrawableImpl f783a;

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$BaseDrawableImpl */
    class BaseDrawableImpl implements DrawableImpl {
        BaseDrawableImpl() {
        }

        public int getLayoutDirection(Drawable drawable) {
            return 0;
        }

        public boolean isAutoMirrored(Drawable drawable) {
            return false;
        }

        public void jumpToCurrentState(Drawable drawable) {
        }

        public void setAutoMirrored(Drawable drawable, boolean z) {
        }

        public void setHotspot(Drawable drawable, float f, float f2) {
        }

        public void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void setLayoutDirection(Drawable drawable, int i) {
        }

        public void setTint(Drawable drawable, int i) {
            DrawableCompatBase.setTint(drawable, i);
        }

        public void setTintList(Drawable drawable, ColorStateList colorStateList) {
            DrawableCompatBase.setTintList(drawable, colorStateList);
        }

        public void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
            DrawableCompatBase.setTintMode(drawable, mode);
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatBase.wrapForTinting(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$DrawableImpl */
    interface DrawableImpl {
        int getLayoutDirection(Drawable drawable);

        boolean isAutoMirrored(Drawable drawable);

        void jumpToCurrentState(Drawable drawable);

        void setAutoMirrored(Drawable drawable, boolean z);

        void setHotspot(Drawable drawable, float f, float f2);

        void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4);

        void setLayoutDirection(Drawable drawable, int i);

        void setTint(Drawable drawable, int i);

        void setTintList(Drawable drawable, ColorStateList colorStateList);

        void setTintMode(Drawable drawable, PorterDuff.Mode mode);

        Drawable wrap(Drawable drawable);
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$HoneycombDrawableImpl */
    class HoneycombDrawableImpl extends BaseDrawableImpl {
        HoneycombDrawableImpl() {
        }

        public void jumpToCurrentState(Drawable drawable) {
            DrawableCompatHoneycomb.jumpToCurrentState(drawable);
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatHoneycomb.wrapForTinting(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$JellybeanMr1DrawableImpl */
    class JellybeanMr1DrawableImpl extends HoneycombDrawableImpl {
        JellybeanMr1DrawableImpl() {
        }

        public int getLayoutDirection(Drawable drawable) {
            int layoutDirection = DrawableCompatJellybeanMr1.getLayoutDirection(drawable);
            if (layoutDirection < 0) {
                return layoutDirection;
            }
            return 0;
        }

        public void setLayoutDirection(Drawable drawable, int i) {
            DrawableCompatJellybeanMr1.setLayoutDirection(drawable, i);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$KitKatDrawableImpl */
    class KitKatDrawableImpl extends JellybeanMr1DrawableImpl {
        KitKatDrawableImpl() {
        }

        public boolean isAutoMirrored(Drawable drawable) {
            return DrawableCompatKitKat.isAutoMirrored(drawable);
        }

        public void setAutoMirrored(Drawable drawable, boolean z) {
            DrawableCompatKitKat.setAutoMirrored(drawable, z);
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatKitKat.wrapForTinting(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$LollipopDrawableImpl */
    class LollipopDrawableImpl extends KitKatDrawableImpl {
        LollipopDrawableImpl() {
        }

        public void setHotspot(Drawable drawable, float f, float f2) {
            DrawableCompatLollipop.setHotspot(drawable, f, f2);
        }

        public void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
            DrawableCompatLollipop.setHotspotBounds(drawable, i, i2, i3, i4);
        }

        public void setTint(Drawable drawable, int i) {
            DrawableCompatLollipop.setTint(drawable, i);
        }

        public void setTintList(Drawable drawable, ColorStateList colorStateList) {
            DrawableCompatLollipop.setTintList(drawable, colorStateList);
        }

        public void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
            DrawableCompatLollipop.setTintMode(drawable, mode);
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatLollipop.wrapForTinting(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$LollipopMr1DrawableImpl */
    class LollipopMr1DrawableImpl extends LollipopDrawableImpl {
        LollipopMr1DrawableImpl() {
        }

        public Drawable wrap(Drawable drawable) {
            return DrawableCompatApi22.wrapForTinting(drawable);
        }
    }

    /* renamed from: android.support.v4.graphics.drawable.DrawableCompat$MDrawableImpl */
    class MDrawableImpl extends LollipopMr1DrawableImpl {
        MDrawableImpl() {
        }

        public int getLayoutDirection(Drawable drawable) {
            return DrawableCompatApi23.getLayoutDirection(drawable);
        }

        public void setLayoutDirection(Drawable drawable, int i) {
            DrawableCompatApi23.setLayoutDirection(drawable, i);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            f783a = new MDrawableImpl();
        } else if (i >= 22) {
            f783a = new LollipopMr1DrawableImpl();
        } else if (i >= 21) {
            f783a = new LollipopDrawableImpl();
        } else if (i >= 19) {
            f783a = new KitKatDrawableImpl();
        } else if (i >= 17) {
            f783a = new JellybeanMr1DrawableImpl();
        } else if (i >= 11) {
            f783a = new HoneycombDrawableImpl();
        } else {
            f783a = new BaseDrawableImpl();
        }
    }

    public static int getLayoutDirection(Drawable drawable) {
        return f783a.getLayoutDirection(drawable);
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return f783a.isAutoMirrored(drawable);
    }

    public static void jumpToCurrentState(Drawable drawable) {
        f783a.jumpToCurrentState(drawable);
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        f783a.setAutoMirrored(drawable, z);
    }

    public static void setHotspot(Drawable drawable, float f, float f2) {
        f783a.setHotspot(drawable, f, f2);
    }

    public static void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        f783a.setHotspotBounds(drawable, i, i2, i3, i4);
    }

    public static void setLayoutDirection(Drawable drawable, int i) {
        f783a.setLayoutDirection(drawable, i);
    }

    public static void setTint(Drawable drawable, int i) {
        f783a.setTint(drawable, i);
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        f783a.setTintList(drawable, colorStateList);
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
        f783a.setTintMode(drawable, mode);
    }

    public static <T extends Drawable> T unwrap(Drawable drawable) {
        return drawable instanceof DrawableWrapper ? ((DrawableWrapper) drawable).getWrappedDrawable() : drawable;
    }

    public static Drawable wrap(Drawable drawable) {
        return f783a.wrap(drawable);
    }
}
