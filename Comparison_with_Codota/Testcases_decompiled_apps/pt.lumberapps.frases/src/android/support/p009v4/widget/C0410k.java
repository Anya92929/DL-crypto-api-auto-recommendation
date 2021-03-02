package android.support.p009v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.k */
class C0410k {

    /* renamed from: a */
    private static Field f556a;

    /* renamed from: b */
    private static boolean f557b;

    /* renamed from: a */
    static Drawable m1717a(CompoundButton compoundButton) {
        if (!f557b) {
            try {
                f556a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f556a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", e);
            }
            f557b = true;
        }
        if (f556a != null) {
            try {
                return (Drawable) f556a.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", e2);
                f556a = null;
            }
        }
        return null;
    }

    /* renamed from: a */
    static void m1718a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof C0397bm) {
            ((C0397bm) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    /* renamed from: a */
    static void m1719a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (compoundButton instanceof C0397bm) {
            ((C0397bm) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
