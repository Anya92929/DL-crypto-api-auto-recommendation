package p000;

import android.content.Context;
import android.support.p001v4.internal.view.SupportMenuItem;
import android.support.p001v4.internal.view.SupportSubMenu;
import android.support.p001v4.util.ArrayMap;
import android.support.p004v7.view.menu.MenuWrapperFactory;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* renamed from: gh */
public abstract class C1163gh<T> extends C1164gi<T> {

    /* renamed from: a */
    public final Context f4159a;

    /* renamed from: c */
    private Map<SupportMenuItem, MenuItem> f4160c;

    /* renamed from: d */
    private Map<SupportSubMenu, SubMenu> f4161d;

    public C1163gh(Context context, T t) {
        super(t);
        this.f4159a = context;
    }

    /* renamed from: a */
    public final MenuItem mo8130a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f4160c == null) {
            this.f4160c = new ArrayMap();
        }
        MenuItem menuItem2 = this.f4160c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem wrapSupportMenuItem = MenuWrapperFactory.wrapSupportMenuItem(this.f4159a, supportMenuItem);
        this.f4160c.put(supportMenuItem, wrapSupportMenuItem);
        return wrapSupportMenuItem;
    }

    /* renamed from: a */
    public final SubMenu mo8131a(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f4161d == null) {
            this.f4161d = new ArrayMap();
        }
        SubMenu subMenu2 = this.f4161d.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu wrapSupportSubMenu = MenuWrapperFactory.wrapSupportSubMenu(this.f4159a, supportSubMenu);
        this.f4161d.put(supportSubMenu, wrapSupportSubMenu);
        return wrapSupportSubMenu;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo8132a() {
        if (this.f4160c != null) {
            this.f4160c.clear();
        }
        if (this.f4161d != null) {
            this.f4161d.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo8133a(int i) {
        if (this.f4160c != null) {
            Iterator<SupportMenuItem> it = this.f4160c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo8134b(int i) {
        if (this.f4160c != null) {
            Iterator<SupportMenuItem> it = this.f4160c.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
