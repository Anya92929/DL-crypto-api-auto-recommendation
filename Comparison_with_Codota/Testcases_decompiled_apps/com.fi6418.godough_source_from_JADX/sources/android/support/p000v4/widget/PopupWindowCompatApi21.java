package android.support.p000v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.PopupWindowCompatApi21 */
class PopupWindowCompatApi21 {

    /* renamed from: a */
    private static Field f1578a;

    static {
        try {
            f1578a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f1578a.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    PopupWindowCompatApi21() {
    }

    /* renamed from: a */
    static void m1126a(PopupWindow popupWindow, boolean z) {
        if (f1578a != null) {
            try {
                f1578a.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }

    /* renamed from: a */
    static boolean m1127a(PopupWindow popupWindow) {
        if (f1578a != null) {
            try {
                return ((Boolean) f1578a.get(popupWindow)).booleanValue();
            } catch (IllegalAccessException e) {
                Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", e);
            }
        }
        return false;
    }
}
