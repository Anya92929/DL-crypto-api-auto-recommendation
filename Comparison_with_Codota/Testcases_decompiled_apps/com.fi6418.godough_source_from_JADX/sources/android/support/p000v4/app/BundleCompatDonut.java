package android.support.p000v4.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.app.BundleCompatDonut */
class BundleCompatDonut {

    /* renamed from: a */
    private static Method f344a;

    /* renamed from: b */
    private static boolean f345b;

    /* renamed from: c */
    private static Method f346c;

    /* renamed from: d */
    private static boolean f347d;

    BundleCompatDonut() {
    }

    public static IBinder getBinder(Bundle bundle, String str) {
        if (!f345b) {
            try {
                f344a = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                f344a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("BundleCompatDonut", "Failed to retrieve getIBinder method", e);
            }
            f345b = true;
        }
        if (f344a != null) {
            try {
                return (IBinder) f344a.invoke(bundle, new Object[]{str});
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                Log.i("BundleCompatDonut", "Failed to invoke getIBinder via reflection", e2);
                f344a = null;
            }
        }
        return null;
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        if (!f347d) {
            try {
                f346c = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                f346c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("BundleCompatDonut", "Failed to retrieve putIBinder method", e);
            }
            f347d = true;
        }
        if (f346c != null) {
            try {
                f346c.invoke(bundle, new Object[]{str, iBinder});
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                Log.i("BundleCompatDonut", "Failed to invoke putIBinder via reflection", e2);
                f346c = null;
            }
        }
    }
}
