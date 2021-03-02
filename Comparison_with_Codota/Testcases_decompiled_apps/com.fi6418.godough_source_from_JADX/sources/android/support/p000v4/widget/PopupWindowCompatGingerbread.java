package android.support.p000v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.widget.PopupWindowCompatGingerbread */
class PopupWindowCompatGingerbread {

    /* renamed from: a */
    private static Method f1579a;

    /* renamed from: b */
    private static boolean f1580b;

    /* renamed from: c */
    private static Method f1581c;

    /* renamed from: d */
    private static boolean f1582d;

    PopupWindowCompatGingerbread() {
    }

    /* renamed from: a */
    static int m1132a(PopupWindow popupWindow) {
        if (!f1582d) {
            try {
                f1581c = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
                f1581c.setAccessible(true);
            } catch (Exception e) {
            }
            f1582d = true;
        }
        if (f1581c != null) {
            try {
                return ((Integer) f1581c.invoke(popupWindow, new Object[0])).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    /* renamed from: a */
    static void m1133a(PopupWindow popupWindow, int i) {
        if (!f1580b) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                f1579a = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f1579a.setAccessible(true);
            } catch (Exception e) {
            }
            f1580b = true;
        }
        if (f1579a != null) {
            try {
                f1579a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
