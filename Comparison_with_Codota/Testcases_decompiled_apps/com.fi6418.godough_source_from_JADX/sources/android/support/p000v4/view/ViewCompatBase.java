package android.support.p000v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.view.ViewCompatBase */
class ViewCompatBase {

    /* renamed from: a */
    private static Field f1249a;

    /* renamed from: b */
    private static boolean f1250b;

    /* renamed from: c */
    private static Field f1251c;

    /* renamed from: d */
    private static boolean f1252d;

    ViewCompatBase() {
    }

    /* renamed from: a */
    static ColorStateList m875a(View view) {
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* renamed from: a */
    static void m876a(View view, ColorStateList colorStateList) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* renamed from: a */
    static void m877a(View view, PorterDuff.Mode mode) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* renamed from: b */
    static PorterDuff.Mode m878b(View view) {
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* renamed from: c */
    static boolean m879c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* renamed from: d */
    static int m880d(View view) {
        if (!f1250b) {
            try {
                f1249a = View.class.getDeclaredField("mMinWidth");
                f1249a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f1250b = true;
        }
        if (f1249a != null) {
            try {
                return ((Integer) f1249a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    /* renamed from: e */
    static int m881e(View view) {
        if (!f1252d) {
            try {
                f1251c = View.class.getDeclaredField("mMinHeight");
                f1251c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f1252d = true;
        }
        if (f1251c != null) {
            try {
                return ((Integer) f1251c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    /* renamed from: f */
    static boolean m882f(View view) {
        return view.getWindowToken() != null;
    }
}
