package p000;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: be */
public class C0613be {

    /* renamed from: a */
    private static Method f2398a;

    /* renamed from: b */
    private static boolean f2399b;

    /* renamed from: c */
    private static Method f2400c;

    /* renamed from: d */
    private static boolean f2401d;

    /* renamed from: a */
    public static void m3423a(Drawable drawable, int i) {
        if (!f2399b) {
            Class<Drawable> cls = Drawable.class;
            try {
                f2398a = cls.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f2398a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f2399b = true;
        }
        if (f2398a != null) {
            try {
                f2398a.invoke(drawable, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f2398a = null;
            }
        }
    }

    /* renamed from: a */
    public static int m3422a(Drawable drawable) {
        if (!f2401d) {
            try {
                f2400c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f2400c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            f2401d = true;
        }
        if (f2400c != null) {
            try {
                return ((Integer) f2400c.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                f2400c = null;
            }
        }
        return -1;
    }
}
