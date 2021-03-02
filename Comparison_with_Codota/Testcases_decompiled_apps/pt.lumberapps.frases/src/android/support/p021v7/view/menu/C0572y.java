package android.support.p021v7.view.menu;

import android.view.MenuItem;

/* renamed from: android.support.v7.view.menu.y */
class C0572y extends C0553f implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C0568u f1165a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0572y(C0568u uVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        super(onMenuItemClickListener);
        this.f1165a = uVar;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return ((MenuItem.OnMenuItemClickListener) this.f1053b).onMenuItemClick(this.f1165a.mo2409a(menuItem));
    }
}
