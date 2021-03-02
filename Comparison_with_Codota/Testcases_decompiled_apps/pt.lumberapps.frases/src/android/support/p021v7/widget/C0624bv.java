package android.support.p021v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.p009v4.p012b.p013a.C0113q;
import android.support.p021v7.p024c.p025a.C0516a;

/* renamed from: android.support.v7.widget.bv */
public class C0624bv {

    /* renamed from: a */
    public static final Rect f1485a = new Rect();

    /* renamed from: b */
    private static Class f1486b;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f1486b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    /* renamed from: a */
    static PorterDuff.Mode m2853a(int i, PorterDuff.Mode mode) {
        switch (i) {
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return Build.VERSION.SDK_INT >= 11 ? PorterDuff.Mode.valueOf("ADD") : mode;
            default:
                return mode;
        }
    }

    /* renamed from: a */
    static void m2854a(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m2856c(drawable);
        }
    }

    /* renamed from: b */
    public static boolean m2855b(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 8 && (drawable instanceof StateListDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                for (Drawable b : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                    if (!m2855b(b)) {
                        return false;
                    }
                }
            }
        } else if (drawable instanceof C0113q) {
            return m2855b(((C0113q) drawable).mo979a());
        } else {
            if (drawable instanceof C0516a) {
                return m2855b(((C0516a) drawable).mo2139a());
            }
            if (drawable instanceof ScaleDrawable) {
                return m2855b(((ScaleDrawable) drawable).getDrawable());
            }
        }
        return true;
    }

    /* renamed from: c */
    private static void m2856c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(C0665di.f1637e);
        } else {
            drawable.setState(C0665di.f1640h);
        }
        drawable.setState(state);
    }
}
