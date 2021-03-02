package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.p001v4.widget.TintableCompoundButton;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: fd */
public class C1111fd {

    /* renamed from: a */
    private static Field f4082a;

    /* renamed from: b */
    private static boolean f4083b;

    /* renamed from: a */
    public static void m5043a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static ColorStateList m5042a(CompoundButton compoundButton) {
        if (compoundButton instanceof TintableCompoundButton) {
            return ((TintableCompoundButton) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    /* renamed from: a */
    public static void m5044a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    /* renamed from: b */
    public static PorterDuff.Mode m5045b(CompoundButton compoundButton) {
        if (compoundButton instanceof TintableCompoundButton) {
            return ((TintableCompoundButton) compoundButton).getSupportButtonTintMode();
        }
        return null;
    }

    /* renamed from: c */
    public static Drawable m5046c(CompoundButton compoundButton) {
        if (!f4083b) {
            try {
                f4082a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f4082a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", e);
            }
            f4083b = true;
        }
        if (f4082a != null) {
            try {
                return (Drawable) f4082a.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", e2);
                f4082a = null;
            }
        }
        return null;
    }
}
