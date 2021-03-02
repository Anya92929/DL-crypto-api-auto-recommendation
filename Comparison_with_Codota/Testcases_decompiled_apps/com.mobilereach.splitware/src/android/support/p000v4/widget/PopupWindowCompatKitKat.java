package android.support.p000v4.widget;

import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v4.widget.PopupWindowCompatKitKat */
class PopupWindowCompatKitKat {
    PopupWindowCompatKitKat() {
    }

    public static void showAsDropDown(PopupWindow popup, View anchor, int xoff, int yoff, int gravity) {
        popup.showAsDropDown(anchor, xoff, yoff, gravity);
    }
}
