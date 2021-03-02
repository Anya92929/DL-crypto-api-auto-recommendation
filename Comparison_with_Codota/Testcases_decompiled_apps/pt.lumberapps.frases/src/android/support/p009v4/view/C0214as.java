package android.support.p009v4.view;

import android.os.Build;
import android.support.p009v4.p014c.p015a.C0124b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.view.as */
public final class C0214as {

    /* renamed from: a */
    static final C0218aw f343a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 14) {
            f343a = new C0217av();
        } else if (i >= 11) {
            f343a = new C0216au();
        } else {
            f343a = new C0215at();
        }
    }

    /* renamed from: a */
    public static MenuItem m784a(MenuItem menuItem, C0344n nVar) {
        if (menuItem instanceof C0124b) {
            return ((C0124b) menuItem).mo1017a(nVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    /* renamed from: a */
    public static MenuItem m785a(MenuItem menuItem, View view) {
        return menuItem instanceof C0124b ? ((C0124b) menuItem).setActionView(view) : f343a.mo1396a(menuItem, view);
    }

    /* renamed from: a */
    public static View m786a(MenuItem menuItem) {
        return menuItem instanceof C0124b ? ((C0124b) menuItem).getActionView() : f343a.mo1397a(menuItem);
    }

    /* renamed from: a */
    public static void m787a(MenuItem menuItem, int i) {
        if (menuItem instanceof C0124b) {
            ((C0124b) menuItem).setShowAsAction(i);
        } else {
            f343a.mo1398a(menuItem, i);
        }
    }

    /* renamed from: b */
    public static MenuItem m788b(MenuItem menuItem, int i) {
        return menuItem instanceof C0124b ? ((C0124b) menuItem).setActionView(i) : f343a.mo1399b(menuItem, i);
    }

    /* renamed from: b */
    public static boolean m789b(MenuItem menuItem) {
        return menuItem instanceof C0124b ? ((C0124b) menuItem).expandActionView() : f343a.mo1400b(menuItem);
    }

    /* renamed from: c */
    public static boolean m790c(MenuItem menuItem) {
        return menuItem instanceof C0124b ? ((C0124b) menuItem).isActionViewExpanded() : f343a.mo1401c(menuItem);
    }
}
