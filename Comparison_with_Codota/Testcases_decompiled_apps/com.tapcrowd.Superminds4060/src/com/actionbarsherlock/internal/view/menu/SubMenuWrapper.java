package com.actionbarsherlock.internal.view.menu;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

public class SubMenuWrapper extends MenuWrapper implements SubMenu {
    private MenuItem mItem = null;
    private final android.view.SubMenu mNativeSubMenu;

    public SubMenuWrapper(android.view.SubMenu nativeSubMenu) {
        super(nativeSubMenu);
        this.mNativeSubMenu = nativeSubMenu;
    }

    public SubMenu setHeaderTitle(int titleRes) {
        this.mNativeSubMenu.setHeaderTitle(titleRes);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence title) {
        this.mNativeSubMenu.setHeaderTitle(title);
        return this;
    }

    public SubMenu setHeaderIcon(int iconRes) {
        this.mNativeSubMenu.setHeaderIcon(iconRes);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable icon) {
        this.mNativeSubMenu.setHeaderIcon(icon);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.mNativeSubMenu.setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        this.mNativeSubMenu.clearHeader();
    }

    public SubMenu setIcon(int iconRes) {
        this.mNativeSubMenu.setIcon(iconRes);
        return this;
    }

    public SubMenu setIcon(Drawable icon) {
        this.mNativeSubMenu.setIcon(icon);
        return this;
    }

    public MenuItem getItem() {
        if (this.mItem == null) {
            this.mItem = new MenuItemWrapper(this.mNativeSubMenu.getItem());
        }
        return this.mItem;
    }
}
