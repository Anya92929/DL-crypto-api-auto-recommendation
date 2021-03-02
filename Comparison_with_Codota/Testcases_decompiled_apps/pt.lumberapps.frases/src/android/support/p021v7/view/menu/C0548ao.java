package android.support.p021v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p014c.p015a.C0125c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.ao */
class C0548ao extends C0543aj implements SubMenu {
    C0548ao(Context context, C0125c cVar) {
        super(context, cVar);
    }

    /* renamed from: b */
    public C0125c mo2387b() {
        return (C0125c) this.f1053b;
    }

    public void clearHeader() {
        mo2387b().clearHeader();
    }

    public MenuItem getItem() {
        return mo2409a(mo2387b().getItem());
    }

    public SubMenu setHeaderIcon(int i) {
        mo2387b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        mo2387b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        mo2387b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        mo2387b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        mo2387b().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        mo2387b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        mo2387b().setIcon(drawable);
        return this;
    }
}
