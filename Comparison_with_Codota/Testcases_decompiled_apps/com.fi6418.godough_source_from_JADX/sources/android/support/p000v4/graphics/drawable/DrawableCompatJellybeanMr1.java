package android.support.p000v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.graphics.drawable.DrawableCompatJellybeanMr1 */
class DrawableCompatJellybeanMr1 {

    /* renamed from: a */
    private static Method f784a;

    /* renamed from: b */
    private static boolean f785b;

    /* renamed from: c */
    private static Method f786c;

    /* renamed from: d */
    private static boolean f787d;

    DrawableCompatJellybeanMr1() {
    }

    public static int getLayoutDirection(Drawable drawable) {
        if (!f787d) {
            try {
                f786c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f786c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            f787d = true;
        }
        if (f786c != null) {
            try {
                return ((Integer) f786c.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                f786c = null;
            }
        }
        return -1;
    }

    public static void setLayoutDirection(Drawable drawable, int i) {
        if (!f785b) {
            Class<Drawable> cls = Drawable.class;
            try {
                f784a = cls.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f784a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f785b = true;
        }
        if (f784a != null) {
            try {
                f784a.invoke(drawable, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f784a = null;
            }
        }
    }
}
