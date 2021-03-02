package android.support.p009v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.widget.bc */
class C0387bc {

    /* renamed from: a */
    private static Method f512a;

    /* renamed from: b */
    private static boolean f513b;

    /* renamed from: a */
    static void m1560a(PopupWindow popupWindow, int i) {
        if (!f513b) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                f512a = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f512a.setAccessible(true);
            } catch (Exception e) {
            }
            f513b = true;
        }
        if (f512a != null) {
            try {
                f512a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
