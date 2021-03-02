package android.support.p009v4.view;

import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.view.ay */
class C0220ay {
    /* renamed from: a */
    public static MenuItem m813a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    /* renamed from: a */
    public static View m814a(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    /* renamed from: a */
    public static void m815a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    /* renamed from: b */
    public static MenuItem m816b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }
}
