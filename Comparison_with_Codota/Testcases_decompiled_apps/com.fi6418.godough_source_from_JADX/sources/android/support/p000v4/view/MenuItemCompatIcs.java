package android.support.p000v4.view;

import android.view.MenuItem;

/* renamed from: android.support.v4.view.MenuItemCompatIcs */
class MenuItemCompatIcs {

    /* renamed from: android.support.v4.view.MenuItemCompatIcs$OnActionExpandListenerWrapper */
    class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {

        /* renamed from: a */
        private SupportActionExpandProxy f1193a;

        public OnActionExpandListenerWrapper(SupportActionExpandProxy supportActionExpandProxy) {
            this.f1193a = supportActionExpandProxy;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f1193a.onMenuItemActionCollapse(menuItem);
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f1193a.onMenuItemActionExpand(menuItem);
        }
    }

    /* renamed from: android.support.v4.view.MenuItemCompatIcs$SupportActionExpandProxy */
    interface SupportActionExpandProxy {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    MenuItemCompatIcs() {
    }

    public static boolean collapseActionView(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    public static boolean expandActionView(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    public static boolean isActionViewExpanded(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    public static MenuItem setOnActionExpandListener(MenuItem menuItem, SupportActionExpandProxy supportActionExpandProxy) {
        return menuItem.setOnActionExpandListener(new OnActionExpandListenerWrapper(supportActionExpandProxy));
    }
}
