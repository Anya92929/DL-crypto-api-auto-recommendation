package android.support.p000v4.widget;

import android.widget.PopupWindow;

/* renamed from: android.support.v4.widget.PopupWindowCompatApi23 */
class PopupWindowCompatApi23 {
    PopupWindowCompatApi23() {
    }

    /* renamed from: a */
    static void m1128a(PopupWindow popupWindow, int i) {
        popupWindow.setWindowLayoutType(i);
    }

    /* renamed from: a */
    static void m1129a(PopupWindow popupWindow, boolean z) {
        popupWindow.setOverlapAnchor(z);
    }

    /* renamed from: a */
    static boolean m1130a(PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    /* renamed from: b */
    static int m1131b(PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }
}
