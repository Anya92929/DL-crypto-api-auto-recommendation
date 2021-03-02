package android.support.p021v7.widget;

import android.support.p021v7.view.menu.C0562o;
import android.support.p021v7.view.menu.C0563p;
import android.view.MenuItem;

/* renamed from: android.support.v7.widget.x */
class C0702x implements C0563p {

    /* renamed from: a */
    final /* synthetic */ ActionMenuView f1726a;

    private C0702x(ActionMenuView actionMenuView) {
        this.f1726a = actionMenuView;
    }

    /* renamed from: a */
    public void mo2028a(C0562o oVar) {
        if (this.f1726a.f1222g != null) {
            this.f1726a.f1222g.mo2028a(oVar);
        }
    }

    /* renamed from: a */
    public boolean mo2030a(C0562o oVar, MenuItem menuItem) {
        return this.f1726a.f1227l != null && this.f1726a.f1227l.mo3333a(menuItem);
    }
}
