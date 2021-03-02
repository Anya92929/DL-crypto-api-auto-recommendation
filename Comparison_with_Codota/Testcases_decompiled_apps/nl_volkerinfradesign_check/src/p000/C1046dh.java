package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.p001v4.view.TintableBackgroundView;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: dh */
public class C1046dh {

    /* renamed from: a */
    private static Field f4056a;

    /* renamed from: b */
    private static boolean f4057b;

    /* renamed from: c */
    private static Field f4058c;

    /* renamed from: d */
    private static boolean f4059d;

    /* renamed from: a */
    public static ColorStateList m4645a(View view) {
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* renamed from: a */
    public static void m4646a(View view, ColorStateList colorStateList) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* renamed from: b */
    public static PorterDuff.Mode m4648b(View view) {
        if (view instanceof TintableBackgroundView) {
            return ((TintableBackgroundView) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    /* renamed from: a */
    public static void m4647a(View view, PorterDuff.Mode mode) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* renamed from: c */
    public static boolean m4649c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* renamed from: d */
    public static int m4650d(View view) {
        if (!f4057b) {
            try {
                f4056a = View.class.getDeclaredField("mMinWidth");
                f4056a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f4057b = true;
        }
        if (f4056a != null) {
            try {
                return ((Integer) f4056a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    /* renamed from: e */
    public static int m4651e(View view) {
        if (!f4059d) {
            try {
                f4058c = View.class.getDeclaredField("mMinHeight");
                f4058c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f4059d = true;
        }
        if (f4058c != null) {
            try {
                return ((Integer) f4058c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    /* renamed from: f */
    public static boolean m4652f(View view) {
        return view.getWindowToken() != null;
    }
}
