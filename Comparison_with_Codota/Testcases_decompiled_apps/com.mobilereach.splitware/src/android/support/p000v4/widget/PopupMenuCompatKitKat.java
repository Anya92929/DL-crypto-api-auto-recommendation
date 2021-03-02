package android.support.p000v4.widget;

import android.view.View;
import android.widget.PopupMenu;

/* renamed from: android.support.v4.widget.PopupMenuCompatKitKat */
class PopupMenuCompatKitKat {
    PopupMenuCompatKitKat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object popupMenu) {
        return ((PopupMenu) popupMenu).getDragToOpenListener();
    }
}
