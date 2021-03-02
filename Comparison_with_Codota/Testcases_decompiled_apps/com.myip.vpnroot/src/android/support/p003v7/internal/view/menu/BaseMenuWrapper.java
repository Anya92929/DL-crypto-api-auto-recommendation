package android.support.p003v7.internal.view.menu;

import android.support.p000v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: android.support.v7.internal.view.menu.BaseMenuWrapper */
abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {
    private HashMap<MenuItem, SupportMenuItem> mMenuItems;
    private HashMap<SubMenu, SubMenu> mSubMenus;

    BaseMenuWrapper(T object) {
        super(object);
    }

    /* access modifiers changed from: package-private */
    public final SupportMenuItem getMenuItemWrapper(MenuItem frameworkItem) {
        if (frameworkItem == null) {
            return null;
        }
        if (this.mMenuItems == null) {
            this.mMenuItems = new HashMap<>();
        }
        SupportMenuItem compatItem = this.mMenuItems.get(frameworkItem);
        if (compatItem != null) {
            return compatItem;
        }
        SupportMenuItem compatItem2 = MenuWrapperFactory.createSupportMenuItemWrapper(frameworkItem);
        this.mMenuItems.put(frameworkItem, compatItem2);
        return compatItem2;
    }

    /* access modifiers changed from: package-private */
    public final SubMenu getSubMenuWrapper(SubMenu frameworkSubMenu) {
        if (frameworkSubMenu == null) {
            return null;
        }
        if (this.mSubMenus == null) {
            this.mSubMenus = new HashMap<>();
        }
        SubMenu compatSubMenu = this.mSubMenus.get(frameworkSubMenu);
        if (compatSubMenu != null) {
            return compatSubMenu;
        }
        SubMenu compatSubMenu2 = MenuWrapperFactory.createSupportSubMenuWrapper(frameworkSubMenu);
        this.mSubMenus.put(frameworkSubMenu, compatSubMenu2);
        return compatSubMenu2;
    }

    /* access modifiers changed from: package-private */
    public final void internalClear() {
        if (this.mMenuItems != null) {
            this.mMenuItems.clear();
        }
        if (this.mSubMenus != null) {
            this.mSubMenus.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void internalRemoveGroup(int groupId) {
        if (this.mMenuItems != null) {
            Iterator<MenuItem> iterator = this.mMenuItems.keySet().iterator();
            while (iterator.hasNext()) {
                if (groupId == iterator.next().getGroupId()) {
                    iterator.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void internalRemoveItem(int id) {
        if (this.mMenuItems != null) {
            Iterator<MenuItem> iterator = this.mMenuItems.keySet().iterator();
            while (iterator.hasNext()) {
                if (id == iterator.next().getItemId()) {
                    iterator.remove();
                    return;
                }
            }
        }
    }
}
