package android.support.p009v4.p012b.p013a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.b.a.n */
class C0110n {

    /* renamed from: a */
    private static Method f168a;

    /* renamed from: b */
    private static boolean f169b;

    /* renamed from: c */
    private static Method f170c;

    /* renamed from: d */
    private static boolean f171d;

    /* renamed from: a */
    public static int m276a(Drawable drawable) {
        if (!f171d) {
            try {
                f170c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f170c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            f171d = true;
        }
        if (f170c != null) {
            try {
                return ((Integer) f170c.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                f170c = null;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static void m277a(Drawable drawable, int i) {
        if (!f169b) {
            Class<Drawable> cls = Drawable.class;
            try {
                f168a = cls.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f168a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f169b = true;
        }
        if (f168a != null) {
            try {
                f168a.invoke(drawable, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f168a = null;
            }
        }
    }
}
