package com.actionbarsherlock.internal.view.menu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import com.actionbarsherlock.internal.view.ActionProviderWrapper;
import com.actionbarsherlock.internal.widget.CollapsibleActionViewWrapper;
import com.actionbarsherlock.view.ActionProvider;
import com.actionbarsherlock.view.CollapsibleActionView;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

public class MenuItemWrapper implements MenuItem, MenuItem.OnMenuItemClickListener {
    /* access modifiers changed from: private */
    public MenuItem.OnActionExpandListener mActionExpandListener = null;
    private MenuItem.OnMenuItemClickListener mMenuItemClickListener = null;
    private MenuItem.OnActionExpandListener mNativeActionExpandListener = null;
    private final android.view.MenuItem mNativeItem;
    private SubMenu mSubMenu = null;

    public MenuItemWrapper(android.view.MenuItem nativeItem) {
        if (nativeItem == null) {
            throw new IllegalStateException("Wrapped menu item cannot be null.");
        }
        this.mNativeItem = nativeItem;
    }

    public int getItemId() {
        return this.mNativeItem.getItemId();
    }

    public int getGroupId() {
        return this.mNativeItem.getGroupId();
    }

    public int getOrder() {
        return this.mNativeItem.getOrder();
    }

    public com.actionbarsherlock.view.MenuItem setTitle(CharSequence title) {
        this.mNativeItem.setTitle(title);
        return this;
    }

    public com.actionbarsherlock.view.MenuItem setTitle(int title) {
        this.mNativeItem.setTitle(title);
        return this;
    }

    public CharSequence getTitle() {
        return this.mNativeItem.getTitle();
    }

    public com.actionbarsherlock.view.MenuItem setTitleCondensed(CharSequence title) {
        this.mNativeItem.setTitleCondensed(title);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return this.mNativeItem.getTitleCondensed();
    }

    public com.actionbarsherlock.view.MenuItem setIcon(Drawable icon) {
        this.mNativeItem.setIcon(icon);
        return this;
    }

    public com.actionbarsherlock.view.MenuItem setIcon(int iconRes) {
        this.mNativeItem.setIcon(iconRes);
        return this;
    }

    public Drawable getIcon() {
        return this.mNativeItem.getIcon();
    }

    public com.actionbarsherlock.view.MenuItem setIntent(Intent intent) {
        this.mNativeItem.setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return this.mNativeItem.getIntent();
    }

    public com.actionbarsherlock.view.MenuItem setShortcut(char numericChar, char alphaChar) {
        this.mNativeItem.setShortcut(numericChar, alphaChar);
        return this;
    }

    public com.actionbarsherlock.view.MenuItem setNumericShortcut(char numericChar) {
        this.mNativeItem.setNumericShortcut(numericChar);
        return this;
    }

    public char getNumericShortcut() {
        return this.mNativeItem.getNumericShortcut();
    }

    public com.actionbarsherlock.view.MenuItem setAlphabeticShortcut(char alphaChar) {
        this.mNativeItem.setAlphabeticShortcut(alphaChar);
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.mNativeItem.getAlphabeticShortcut();
    }

    public com.actionbarsherlock.view.MenuItem setCheckable(boolean checkable) {
        this.mNativeItem.setCheckable(checkable);
        return this;
    }

    public boolean isCheckable() {
        return this.mNativeItem.isCheckable();
    }

    public com.actionbarsherlock.view.MenuItem setChecked(boolean checked) {
        this.mNativeItem.setChecked(checked);
        return this;
    }

    public boolean isChecked() {
        return this.mNativeItem.isChecked();
    }

    public com.actionbarsherlock.view.MenuItem setVisible(boolean visible) {
        this.mNativeItem.setVisible(visible);
        return this;
    }

    public boolean isVisible() {
        return this.mNativeItem.isVisible();
    }

    public com.actionbarsherlock.view.MenuItem setEnabled(boolean enabled) {
        this.mNativeItem.setEnabled(enabled);
        return this;
    }

    public boolean isEnabled() {
        return this.mNativeItem.isEnabled();
    }

    public boolean hasSubMenu() {
        return this.mNativeItem.hasSubMenu();
    }

    public SubMenu getSubMenu() {
        if (hasSubMenu() && this.mSubMenu == null) {
            this.mSubMenu = new SubMenuWrapper(this.mNativeItem.getSubMenu());
        }
        return this.mSubMenu;
    }

    public com.actionbarsherlock.view.MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItemClickListener) {
        this.mMenuItemClickListener = menuItemClickListener;
        this.mNativeItem.setOnMenuItemClickListener(this);
        return this;
    }

    public boolean onMenuItemClick(android.view.MenuItem item) {
        if (this.mMenuItemClickListener != null) {
            return this.mMenuItemClickListener.onMenuItemClick(this);
        }
        return false;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mNativeItem.getMenuInfo();
    }

    public void setShowAsAction(int actionEnum) {
        this.mNativeItem.setShowAsAction(actionEnum);
    }

    public com.actionbarsherlock.view.MenuItem setShowAsActionFlags(int actionEnum) {
        this.mNativeItem.setShowAsActionFlags(actionEnum);
        return this;
    }

    public com.actionbarsherlock.view.MenuItem setActionView(View view) {
        if (view != null && (view instanceof CollapsibleActionView)) {
            view = new CollapsibleActionViewWrapper(view);
        }
        this.mNativeItem.setActionView(view);
        return this;
    }

    public com.actionbarsherlock.view.MenuItem setActionView(int resId) {
        this.mNativeItem.setActionView(resId);
        if (resId != 0) {
            View view = this.mNativeItem.getActionView();
            if (view instanceof CollapsibleActionView) {
                this.mNativeItem.setActionView(new CollapsibleActionViewWrapper(view));
            }
        }
        return this;
    }

    public View getActionView() {
        View actionView = this.mNativeItem.getActionView();
        if (actionView instanceof CollapsibleActionViewWrapper) {
            return ((CollapsibleActionViewWrapper) actionView).unwrap();
        }
        return actionView;
    }

    public com.actionbarsherlock.view.MenuItem setActionProvider(ActionProvider actionProvider) {
        this.mNativeItem.setActionProvider(new ActionProviderWrapper(actionProvider));
        return this;
    }

    public ActionProvider getActionProvider() {
        android.view.ActionProvider nativeProvider = this.mNativeItem.getActionProvider();
        if (nativeProvider == null || !(nativeProvider instanceof ActionProviderWrapper)) {
            return null;
        }
        return ((ActionProviderWrapper) nativeProvider).unwrap();
    }

    public boolean expandActionView() {
        return this.mNativeItem.expandActionView();
    }

    public boolean collapseActionView() {
        return this.mNativeItem.collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return this.mNativeItem.isActionViewExpanded();
    }

    public com.actionbarsherlock.view.MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener listener) {
        this.mActionExpandListener = listener;
        if (this.mNativeActionExpandListener == null) {
            this.mNativeActionExpandListener = new MenuItem.OnActionExpandListener() {
                public boolean onMenuItemActionExpand(android.view.MenuItem menuItem) {
                    if (MenuItemWrapper.this.mActionExpandListener != null) {
                        return MenuItemWrapper.this.mActionExpandListener.onMenuItemActionExpand(MenuItemWrapper.this);
                    }
                    return false;
                }

                public boolean onMenuItemActionCollapse(android.view.MenuItem menuItem) {
                    if (MenuItemWrapper.this.mActionExpandListener != null) {
                        return MenuItemWrapper.this.mActionExpandListener.onMenuItemActionCollapse(MenuItemWrapper.this);
                    }
                    return false;
                }
            };
            this.mNativeItem.setOnActionExpandListener(this.mNativeActionExpandListener);
        }
        return this;
    }
}
