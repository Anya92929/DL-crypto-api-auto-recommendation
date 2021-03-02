package android.support.p003v7.internal.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p000v4.internal.view.SupportSubMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.SubMenuWrapperICS */
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
    }

    public void clearHeader() {
        getWrappedObject().clearHeader();
    }

    public MenuItem getItem() {
        return mo4051a(getWrappedObject().getItem());
    }

    public SupportSubMenu getWrappedObject() {
        return (SupportSubMenu) this.f2073b;
    }

    public SubMenu setHeaderIcon(int i) {
        getWrappedObject().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        getWrappedObject().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        getWrappedObject().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        getWrappedObject().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        getWrappedObject().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        getWrappedObject().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        getWrappedObject().setIcon(drawable);
        return this;
    }
}
