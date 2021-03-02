package android.support.p000v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.CompoundButtonCompatDonut */
class CompoundButtonCompatDonut {

    /* renamed from: a */
    private static Field f1419a;

    /* renamed from: b */
    private static boolean f1420b;

    CompoundButtonCompatDonut() {
    }

    /* renamed from: a */
    static ColorStateList m1016a(CompoundButton compoundButton) {
        if (compoundButton instanceof TintableCompoundButton) {
            return ((TintableCompoundButton) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    /* renamed from: a */
    static void m1017a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    /* renamed from: a */
    static void m1018a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    /* renamed from: b */
    static PorterDuff.Mode m1019b(CompoundButton compoundButton) {
        if (compoundButton instanceof TintableCompoundButton) {
            return ((TintableCompoundButton) compoundButton).getSupportButtonTintMode();
        }
        return null;
    }

    /* renamed from: c */
    static Drawable m1020c(CompoundButton compoundButton) {
        if (!f1420b) {
            try {
                f1419a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1419a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", e);
            }
            f1420b = true;
        }
        if (f1419a != null) {
            try {
                return (Drawable) f1419a.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", e2);
                f1419a = null;
            }
        }
        return null;
    }
}
