package android.support.p003v7.internal.view.menu;

import android.os.Build;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.internal.view.SupportMenuItem;
import android.support.p000v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.v7.internal.view.menu.MenuWrapperFactory */
public final class MenuWrapperFactory {
    private MenuWrapperFactory() {
    }

    public static Menu createMenuWrapper(Menu frameworkMenu) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new MenuWrapperICS(frameworkMenu);
        }
        return frameworkMenu;
    }

    public static MenuItem createMenuItemWrapper(MenuItem frameworkMenuItem) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new MenuItemWrapperJB(frameworkMenuItem);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return new MenuItemWrapperICS(frameworkMenuItem);
        }
        return frameworkMenuItem;
    }

    public static SupportMenu createSupportMenuWrapper(Menu frameworkMenu) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new MenuWrapperICS(frameworkMenu);
        }
        throw new UnsupportedOperationException();
    }

    public static SupportSubMenu createSupportSubMenuWrapper(SubMenu frameworkSubMenu) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new SubMenuWrapperICS(frameworkSubMenu);
        }
        throw new UnsupportedOperationException();
    }

    public static SupportMenuItem createSupportMenuItemWrapper(MenuItem frameworkMenuItem) {
        if (Build.VERSION.SDK_INT >= 16) {
            return new MenuItemWrapperJB(frameworkMenuItem);
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return new MenuItemWrapperICS(frameworkMenuItem);
        }
        throw new UnsupportedOperationException();
    }
}
