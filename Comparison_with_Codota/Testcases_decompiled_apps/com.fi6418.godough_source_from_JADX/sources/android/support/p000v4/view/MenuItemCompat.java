package android.support.p000v4.view;

import android.os.Build;
import android.support.p000v4.internal.view.SupportMenuItem;
import android.support.p000v4.view.MenuItemCompatIcs;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.view.MenuItemCompat */
public class MenuItemCompat {
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    /* renamed from: a */
    static final MenuVersionImpl f1190a;

    /* renamed from: android.support.v4.view.MenuItemCompat$BaseMenuVersionImpl */
    class BaseMenuVersionImpl implements MenuVersionImpl {
        BaseMenuVersionImpl() {
        }

        public boolean collapseActionView(MenuItem menuItem) {
            return false;
        }

        public boolean expandActionView(MenuItem menuItem) {
            return false;
        }

        public View getActionView(MenuItem menuItem) {
            return null;
        }

        public boolean isActionViewExpanded(MenuItem menuItem) {
            return false;
        }

        public MenuItem setActionView(MenuItem menuItem, int i) {
            return menuItem;
        }

        public MenuItem setActionView(MenuItem menuItem, View view) {
            return menuItem;
        }

        public MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
            return menuItem;
        }

        public void setShowAsAction(MenuItem menuItem, int i) {
        }
    }

    /* renamed from: android.support.v4.view.MenuItemCompat$HoneycombMenuVersionImpl */
    class HoneycombMenuVersionImpl implements MenuVersionImpl {
        HoneycombMenuVersionImpl() {
        }

        public boolean collapseActionView(MenuItem menuItem) {
            return false;
        }

        public boolean expandActionView(MenuItem menuItem) {
            return false;
        }

        public View getActionView(MenuItem menuItem) {
            return MenuItemCompatHoneycomb.getActionView(menuItem);
        }

        public boolean isActionViewExpanded(MenuItem menuItem) {
            return false;
        }

        public MenuItem setActionView(MenuItem menuItem, int i) {
            return MenuItemCompatHoneycomb.setActionView(menuItem, i);
        }

        public MenuItem setActionView(MenuItem menuItem, View view) {
            return MenuItemCompatHoneycomb.setActionView(menuItem, view);
        }

        public MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
            return menuItem;
        }

        public void setShowAsAction(MenuItem menuItem, int i) {
            MenuItemCompatHoneycomb.setShowAsAction(menuItem, i);
        }
    }

    /* renamed from: android.support.v4.view.MenuItemCompat$IcsMenuVersionImpl */
    class IcsMenuVersionImpl extends HoneycombMenuVersionImpl {
        IcsMenuVersionImpl() {
        }

        public boolean collapseActionView(MenuItem menuItem) {
            return MenuItemCompatIcs.collapseActionView(menuItem);
        }

        public boolean expandActionView(MenuItem menuItem) {
            return MenuItemCompatIcs.expandActionView(menuItem);
        }

        public boolean isActionViewExpanded(MenuItem menuItem) {
            return MenuItemCompatIcs.isActionViewExpanded(menuItem);
        }

        public MenuItem setOnActionExpandListener(MenuItem menuItem, final OnActionExpandListener onActionExpandListener) {
            return onActionExpandListener == null ? MenuItemCompatIcs.setOnActionExpandListener(menuItem, (MenuItemCompatIcs.SupportActionExpandProxy) null) : MenuItemCompatIcs.setOnActionExpandListener(menuItem, new MenuItemCompatIcs.SupportActionExpandProxy() {
                public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                    return onActionExpandListener.onMenuItemActionCollapse(menuItem);
                }

                public boolean onMenuItemActionExpand(MenuItem menuItem) {
                    return onActionExpandListener.onMenuItemActionExpand(menuItem);
                }
            });
        }
    }

    /* renamed from: android.support.v4.view.MenuItemCompat$MenuVersionImpl */
    interface MenuVersionImpl {
        boolean collapseActionView(MenuItem menuItem);

        boolean expandActionView(MenuItem menuItem);

        View getActionView(MenuItem menuItem);

        boolean isActionViewExpanded(MenuItem menuItem);

        MenuItem setActionView(MenuItem menuItem, int i);

        MenuItem setActionView(MenuItem menuItem, View view);

        MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener);

        void setShowAsAction(MenuItem menuItem, int i);
    }

    /* renamed from: android.support.v4.view.MenuItemCompat$OnActionExpandListener */
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 14) {
            f1190a = new IcsMenuVersionImpl();
        } else if (i >= 11) {
            f1190a = new HoneycombMenuVersionImpl();
        } else {
            f1190a = new BaseMenuVersionImpl();
        }
    }

    public static boolean collapseActionView(MenuItem menuItem) {
        return menuItem instanceof SupportMenuItem ? ((SupportMenuItem) menuItem).collapseActionView() : f1190a.collapseActionView(menuItem);
    }

    public static boolean expandActionView(MenuItem menuItem) {
        return menuItem instanceof SupportMenuItem ? ((SupportMenuItem) menuItem).expandActionView() : f1190a.expandActionView(menuItem);
    }

    public static ActionProvider getActionProvider(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getSupportActionProvider();
        }
        Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    public static View getActionView(MenuItem menuItem) {
        return menuItem instanceof SupportMenuItem ? ((SupportMenuItem) menuItem).getActionView() : f1190a.getActionView(menuItem);
    }

    public static boolean isActionViewExpanded(MenuItem menuItem) {
        return menuItem instanceof SupportMenuItem ? ((SupportMenuItem) menuItem).isActionViewExpanded() : f1190a.isActionViewExpanded(menuItem);
    }

    public static MenuItem setActionProvider(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setSupportActionProvider(actionProvider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem setActionView(MenuItem menuItem, int i) {
        return menuItem instanceof SupportMenuItem ? ((SupportMenuItem) menuItem).setActionView(i) : f1190a.setActionView(menuItem, i);
    }

    public static MenuItem setActionView(MenuItem menuItem, View view) {
        return menuItem instanceof SupportMenuItem ? ((SupportMenuItem) menuItem).setActionView(view) : f1190a.setActionView(menuItem, view);
    }

    public static MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
        return menuItem instanceof SupportMenuItem ? ((SupportMenuItem) menuItem).setSupportOnActionExpandListener(onActionExpandListener) : f1190a.setOnActionExpandListener(menuItem, onActionExpandListener);
    }

    public static void setShowAsAction(MenuItem menuItem, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setShowAsAction(i);
        } else {
            f1190a.setShowAsAction(menuItem, i);
        }
    }
}
