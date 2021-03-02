package android.support.p009v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.view.co */
class C0264co {

    /* renamed from: a */
    private static Field f360a;

    /* renamed from: b */
    private static boolean f361b;

    /* renamed from: a */
    static ColorStateList m1064a(View view) {
        if (view instanceof C0241bs) {
            return ((C0241bs) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* renamed from: a */
    static void m1065a(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), top + view.getHeight() + abs);
                return;
            }
            view.invalidate();
        }
    }

    /* renamed from: a */
    static void m1066a(View view, ColorStateList colorStateList) {
        if (view instanceof C0241bs) {
            ((C0241bs) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* renamed from: a */
    static void m1067a(View view, PorterDuff.Mode mode) {
        if (view instanceof C0241bs) {
            ((C0241bs) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* renamed from: b */
    static PorterDuff.Mode m1068b(View view) {
        if (view instanceof C0241bs) {
            return ((C0241bs) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* renamed from: b */
    static void m1069b(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), left + view.getWidth() + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }

    /* renamed from: c */
    static boolean m1070c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* renamed from: d */
    static int m1071d(View view) {
        if (!f361b) {
            try {
                f360a = View.class.getDeclaredField("mMinHeight");
                f360a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f361b = true;
        }
        if (f360a != null) {
            try {
                return ((Integer) f360a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    /* renamed from: e */
    static boolean m1072e(View view) {
        return view.getWindowToken() != null;
    }
}
