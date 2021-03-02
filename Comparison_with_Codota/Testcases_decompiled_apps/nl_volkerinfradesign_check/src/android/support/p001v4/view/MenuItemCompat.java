package android.support.p001v4.view;

import android.os.Build;
import android.support.p001v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import p000.C1036da;

/* renamed from: android.support.v4.view.MenuItemCompat */
public class MenuItemCompat {
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    /* renamed from: a */
    static final C0287d f932a;

    /* renamed from: android.support.v4.view.MenuItemCompat$OnActionExpandListener */
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    /* renamed from: android.support.v4.view.MenuItemCompat$d */
    interface C0287d {
        /* renamed from: a */
        MenuItem mo1780a(MenuItem menuItem, OnActionExpandListener onActionExpandListener);

        /* renamed from: a */
        MenuItem mo1781a(MenuItem menuItem, View view);

        /* renamed from: a */
        View mo1782a(MenuItem menuItem);

        /* renamed from: a */
        void mo1783a(MenuItem menuItem, int i);

        /* renamed from: b */
        MenuItem mo1784b(MenuItem menuItem, int i);

        /* renamed from: b */
        boolean mo1785b(MenuItem menuItem);

        /* renamed from: c */
        boolean mo1786c(MenuItem menuItem);

        /* renamed from: d */
        boolean mo1787d(MenuItem menuItem);
    }

    /* renamed from: android.support.v4.view.MenuItemCompat$a */
    static class C0283a implements C0287d {
        C0283a() {
        }

        /* renamed from: a */
        public void mo1783a(MenuItem menuItem, int i) {
        }

        /* renamed from: a */
        public MenuItem mo1781a(MenuItem menuItem, View view) {
            return menuItem;
        }

        /* renamed from: b */
        public MenuItem mo1784b(MenuItem menuItem, int i) {
            return menuItem;
        }

        /* renamed from: a */
        public View mo1782a(MenuItem menuItem) {
            return null;
        }

        /* renamed from: b */
        public boolean mo1785b(MenuItem menuItem) {
            return false;
        }

        /* renamed from: c */
        public boolean mo1786c(MenuItem menuItem) {
            return false;
        }

        /* renamed from: d */
        public boolean mo1787d(MenuItem menuItem) {
            return false;
        }

        /* renamed from: a */
        public MenuItem mo1780a(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
            return menuItem;
        }
    }

    /* renamed from: android.support.v4.view.MenuItemCompat$b */
    static class C0284b implements C0287d {
        C0284b() {
        }

        /* renamed from: a */
        public void mo1783a(MenuItem menuItem, int i) {
            C1034cz.m4619a(menuItem, i);
        }

        /* renamed from: a */
        public MenuItem mo1781a(MenuItem menuItem, View view) {
            return C1034cz.m4617a(menuItem, view);
        }

        /* renamed from: b */
        public MenuItem mo1784b(MenuItem menuItem, int i) {
            return C1034cz.m4620b(menuItem, i);
        }

        /* renamed from: a */
        public View mo1782a(MenuItem menuItem) {
            return C1034cz.m4618a(menuItem);
        }

        /* renamed from: b */
        public boolean mo1785b(MenuItem menuItem) {
            return false;
        }

        /* renamed from: c */
        public boolean mo1786c(MenuItem menuItem) {
            return false;
        }

        /* renamed from: d */
        public boolean mo1787d(MenuItem menuItem) {
            return false;
        }

        /* renamed from: a */
        public MenuItem mo1780a(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
            return menuItem;
        }
    }

    /* renamed from: android.support.v4.view.MenuItemCompat$c */
    static class C0285c extends C0284b {
        C0285c() {
        }

        /* renamed from: b */
        public boolean mo1785b(MenuItem menuItem) {
            return C1036da.m4627a(menuItem);
        }

        /* renamed from: c */
        public boolean mo1786c(MenuItem menuItem) {
            return C1036da.m4628b(menuItem);
        }

        /* renamed from: d */
        public boolean mo1787d(MenuItem menuItem) {
            return C1036da.m4629c(menuItem);
        }

        /* renamed from: a */
        public MenuItem mo1780a(MenuItem menuItem, final OnActionExpandListener onActionExpandListener) {
            if (onActionExpandListener == null) {
                return C1036da.m4626a(menuItem, (C1036da.C1038b) null);
            }
            return C1036da.m4626a(menuItem, new C1036da.C1038b() {
                /* renamed from: a */
                public boolean mo1788a(MenuItem menuItem) {
                    return onActionExpandListener.onMenuItemActionExpand(menuItem);
                }

                /* renamed from: b */
                public boolean mo1789b(MenuItem menuItem) {
                    return onActionExpandListener.onMenuItemActionCollapse(menuItem);
                }
            });
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 14) {
            f932a = new C0285c();
        } else if (i >= 11) {
            f932a = new C0284b();
        } else {
            f932a = new C0283a();
        }
    }

    public static void setShowAsAction(MenuItem menuItem, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setShowAsAction(i);
        } else {
            f932a.mo1783a(menuItem, i);
        }
    }

    public static MenuItem setActionView(MenuItem menuItem, View view) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setActionView(view);
        }
        return f932a.mo1781a(menuItem, view);
    }

    public static MenuItem setActionView(MenuItem menuItem, int i) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setActionView(i);
        }
        return f932a.mo1784b(menuItem, i);
    }

    public static View getActionView(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getActionView();
        }
        return f932a.mo1782a(menuItem);
    }

    public static MenuItem setActionProvider(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setSupportActionProvider(actionProvider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static ActionProvider getActionProvider(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getSupportActionProvider();
        }
        Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    public static boolean expandActionView(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).expandActionView();
        }
        return f932a.mo1785b(menuItem);
    }

    public static boolean collapseActionView(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).collapseActionView();
        }
        return f932a.mo1786c(menuItem);
    }

    public static boolean isActionViewExpanded(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).isActionViewExpanded();
        }
        return f932a.mo1787d(menuItem);
    }

    public static MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setSupportOnActionExpandListener(onActionExpandListener);
        }
        return f932a.mo1780a(menuItem, onActionExpandListener);
    }
}
