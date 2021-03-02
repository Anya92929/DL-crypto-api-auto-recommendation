package p000;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* renamed from: fm */
public class C1122fm {

    /* renamed from: a */
    private static Field f4086a;

    static {
        try {
            f4086a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f4086a.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    /* renamed from: a */
    public static void m5067a(PopupWindow popupWindow, boolean z) {
        if (f4086a != null) {
            try {
                f4086a.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }

    /* renamed from: a */
    public static boolean m5068a(PopupWindow popupWindow) {
        if (f4086a != null) {
            try {
                return ((Boolean) f4086a.get(popupWindow)).booleanValue();
            } catch (IllegalAccessException e) {
                Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", e);
            }
        }
        return false;
    }
}
