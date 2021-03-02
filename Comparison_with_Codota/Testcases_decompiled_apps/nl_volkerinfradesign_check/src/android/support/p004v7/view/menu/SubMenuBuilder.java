package android.support.p004v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p001v4.content.ContextCompat;
import android.support.p004v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.SubMenuBuilder */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {

    /* renamed from: d */
    private MenuBuilder f1831d;

    /* renamed from: e */
    private MenuItemImpl f1832e;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.f1831d = menuBuilder;
        this.f1832e = menuItemImpl;
    }

    public void setQwertyMode(boolean z) {
        this.f1831d.setQwertyMode(z);
    }

    public boolean isQwertyMode() {
        return this.f1831d.isQwertyMode();
    }

    public void setShortcutsVisible(boolean z) {
        this.f1831d.setShortcutsVisible(z);
    }

    public boolean isShortcutsVisible() {
        return this.f1831d.isShortcutsVisible();
    }

    public Menu getParentMenu() {
        return this.f1831d;
    }

    public MenuItem getItem() {
        return this.f1832e;
    }

    public void setCallback(MenuBuilder.Callback callback) {
        this.f1831d.setCallback(callback);
    }

    public MenuBuilder getRootMenu() {
        return this.f1831d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3664a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.mo3664a(menuBuilder, menuItem) || this.f1831d.mo3664a(menuBuilder, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1832e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f1832e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.setHeaderIconInt(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.setHeaderIconInt(ContextCompat.getDrawable(getContext(), i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.setHeaderTitleInt(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.setHeaderTitleInt((CharSequence) getContext().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.setHeaderViewInt(view);
        return this;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return this.f1831d.expandItemActionView(menuItemImpl);
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return this.f1831d.collapseItemActionView(menuItemImpl);
    }

    public String getActionViewStatesKey() {
        int itemId = this.f1832e != null ? this.f1832e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }
}
