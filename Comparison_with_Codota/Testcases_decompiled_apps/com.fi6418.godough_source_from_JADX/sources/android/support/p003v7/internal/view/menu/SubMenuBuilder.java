package android.support.p003v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.ContextCompat;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.SubMenuBuilder */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {

    /* renamed from: d */
    private MenuBuilder f2188d;

    /* renamed from: e */
    private MenuItemImpl f2189e;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.f2188d = menuBuilder;
        this.f2189e = menuItemImpl;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4086a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.mo4086a(menuBuilder, menuItem) || this.f2188d.mo4086a(menuBuilder, menuItem);
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return this.f2188d.collapseItemActionView(menuItemImpl);
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return this.f2188d.expandItemActionView(menuItemImpl);
    }

    public String getActionViewStatesKey() {
        int itemId = this.f2189e != null ? this.f2189e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }

    public MenuItem getItem() {
        return this.f2189e;
    }

    public Menu getParentMenu() {
        return this.f2188d;
    }

    public MenuBuilder getRootMenu() {
        return this.f2188d;
    }

    public boolean isQwertyMode() {
        return this.f2188d.isQwertyMode();
    }

    public boolean isShortcutsVisible() {
        return this.f2188d.isShortcutsVisible();
    }

    public void setCallback(MenuBuilder.Callback callback) {
        this.f2188d.setCallback(callback);
    }

    public SubMenu setHeaderIcon(int i) {
        super.mo4078a(ContextCompat.getDrawable(getContext(), i));
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.mo4078a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.mo4080a((CharSequence) getContext().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.mo4080a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.mo4079a(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f2189e.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f2189e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.f2188d.setQwertyMode(z);
    }

    public void setShortcutsVisible(boolean z) {
        this.f2188d.setShortcutsVisible(z);
    }
}
