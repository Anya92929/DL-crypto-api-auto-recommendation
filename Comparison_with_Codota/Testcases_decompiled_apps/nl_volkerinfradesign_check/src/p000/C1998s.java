package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: s */
public class C1998s {

    /* renamed from: a */
    private static Method f7281a;

    /* renamed from: b */
    private static boolean f7282b;

    /* renamed from: c */
    private static Method f7283c;

    /* renamed from: d */
    private static boolean f7284d;

    /* renamed from: a */
    public static IBinder m7560a(Bundle bundle, String str) {
        if (!f7282b) {
            try {
                f7281a = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                f7281a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("BundleCompatDonut", "Failed to retrieve getIBinder method", e);
            }
            f7282b = true;
        }
        if (f7281a != null) {
            try {
                return (IBinder) f7281a.invoke(bundle, new Object[]{str});
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                Log.i("BundleCompatDonut", "Failed to invoke getIBinder via reflection", e2);
                f7281a = null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m7561a(Bundle bundle, String str, IBinder iBinder) {
        if (!f7284d) {
            try {
                f7283c = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                f7283c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("BundleCompatDonut", "Failed to retrieve putIBinder method", e);
            }
            f7284d = true;
        }
        if (f7283c != null) {
            try {
                f7283c.invoke(bundle, new Object[]{str, iBinder});
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                Log.i("BundleCompatDonut", "Failed to invoke putIBinder via reflection", e2);
                f7283c = null;
            }
        }
    }
}
