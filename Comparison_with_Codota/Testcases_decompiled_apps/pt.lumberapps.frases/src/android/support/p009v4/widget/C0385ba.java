package android.support.p009v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.ba */
class C0385ba {

    /* renamed from: a */
    private static Field f511a;

    static {
        try {
            f511a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f511a.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    /* renamed from: a */
    static void m1557a(PopupWindow popupWindow, boolean z) {
        if (f511a != null) {
            try {
                f511a.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }
}
