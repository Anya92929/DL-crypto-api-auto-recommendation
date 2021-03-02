package p000;

import android.view.MenuItem;
import android.view.View;

/* renamed from: cz */
public class C1034cz {
    /* renamed from: a */
    public static void m4619a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    /* renamed from: a */
    public static MenuItem m4617a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    /* renamed from: b */
    public static MenuItem m4620b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    /* renamed from: a */
    public static View m4618a(MenuItem menuItem) {
        return menuItem.getActionView();
    }
}
