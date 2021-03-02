package android.support.p003v7.internal.view.menu;

import android.content.Context;
import android.support.p000v4.internal.view.SupportMenuItem;
import android.support.p000v4.internal.view.SupportSubMenu;
import android.support.p000v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* renamed from: android.support.v7.internal.view.menu.BaseMenuWrapper */
abstract class BaseMenuWrapper<T> extends BaseWrapper<T> {

    /* renamed from: a */
    final Context f2070a;

    /* renamed from: c */
    private Map<SupportMenuItem, MenuItem> f2071c;

    /* renamed from: d */
    private Map<SupportSubMenu, SubMenu> f2072d;

    BaseMenuWrapper(Context context, T t) {
        super(t);
        this.f2070a = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final MenuItem mo4051a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f2071c == null) {
            this.f2071c = new ArrayMap();
        }
        MenuItem menuItem2 = this.f2071c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem wrapSupportMenuItem = MenuWrapperFactory.wrapSupportMenuItem(this.f2070a, supportMenuItem);
        this.f2071c.put(supportMenuItem, wrapSupportMenuItem);
        return wrapSupportMenuItem;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final SubMenu mo4052a(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f2072d == null) {
            this.f2072d = new ArrayMap();
        }
        SubMenu subMenu2 = this.f2072d.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu wrapSupportSubMenu = MenuWrapperFactory.wrapSupportSubMenu(this.f2070a, supportSubMenu);
        this.f2072d.put(supportSubMenu, wrapSupportSubMenu);
        return wrapSupportSubMenu;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo4053a() {
        if (this.f2071c != null) {
            this.f2071c.clear();
        }
        if (this.f2072d != null) {
            this.f2072d.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo4054a(int i) {
        if (this.f2071c != null) {
            Iterator<SupportMenuItem> it = this.f2071c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo4055b(int i) {
        if (this.f2071c != null) {
            Iterator<SupportMenuItem> it = this.f2071c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
