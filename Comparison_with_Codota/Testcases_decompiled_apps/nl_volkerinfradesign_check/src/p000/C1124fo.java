package p000;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* renamed from: fo */
public class C1124fo {

    /* renamed from: a */
    private static Method f4087a;

    /* renamed from: b */
    private static boolean f4088b;

    /* renamed from: c */
    private static Method f4089c;

    /* renamed from: d */
    private static boolean f4090d;

    /* renamed from: a */
    public static void m5074a(PopupWindow popupWindow, int i) {
        if (!f4088b) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                f4087a = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f4087a.setAccessible(true);
            } catch (Exception e) {
            }
            f4088b = true;
        }
        if (f4087a != null) {
            try {
                f4087a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    public static int m5073a(PopupWindow popupWindow) {
        if (!f4090d) {
            try {
                f4089c = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
                f4089c.setAccessible(true);
            } catch (Exception e) {
            }
            f4090d = true;
        }
        if (f4089c != null) {
            try {
                return ((Integer) f4089c.invoke(popupWindow, new Object[0])).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }
}
