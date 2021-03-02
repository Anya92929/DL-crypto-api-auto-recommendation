package android.support.p000v4.view;

import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.view.MenuItemCompatHoneycomb */
class MenuItemCompatHoneycomb {
    MenuItemCompatHoneycomb() {
    }

    public static void setShowAsAction(MenuItem item, int actionEnum) {
        item.setShowAsAction(actionEnum);
    }

    public static MenuItem setActionView(MenuItem item, View view) {
        return item.setActionView(view);
    }
}
