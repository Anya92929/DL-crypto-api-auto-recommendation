package android.support.p021v7.view.menu;

import android.support.p009v4.view.C0219ax;
import android.view.MenuItem;

/* renamed from: android.support.v7.view.menu.x */
class C0571x extends C0553f implements C0219ax {

    /* renamed from: a */
    final /* synthetic */ C0568u f1164a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0571x(C0568u uVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        super(onActionExpandListener);
        this.f1164a = uVar;
    }

    /* renamed from: a */
    public boolean mo1402a(MenuItem menuItem) {
        return ((MenuItem.OnActionExpandListener) this.f1053b).onMenuItemActionExpand(this.f1164a.mo2409a(menuItem));
    }

    /* renamed from: b */
    public boolean mo1403b(MenuItem menuItem) {
        return ((MenuItem.OnActionExpandListener) this.f1053b).onMenuItemActionCollapse(this.f1164a.mo2409a(menuItem));
    }
}
