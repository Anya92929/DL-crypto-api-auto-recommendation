package android.support.p021v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p009v4.p010a.C0025a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.an */
public class C0547an extends C0562o implements SubMenu {

    /* renamed from: d */
    private C0562o f1037d;

    /* renamed from: e */
    private C0566s f1038e;

    public C0547an(Context context, C0562o oVar, C0566s sVar) {
        super(context);
        this.f1037d = oVar;
        this.f1038e = sVar;
    }

    /* renamed from: a */
    public String mo2369a() {
        int itemId = this.f1038e != null ? this.f1038e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo2369a() + ":" + itemId;
    }

    /* renamed from: a */
    public void mo2370a(C0563p pVar) {
        this.f1037d.mo2370a(pVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2371a(C0562o oVar, MenuItem menuItem) {
        return super.mo2371a(oVar, menuItem) || this.f1037d.mo2371a(oVar, menuItem);
    }

    /* renamed from: b */
    public boolean mo2372b() {
        return this.f1037d.mo2372b();
    }

    /* renamed from: c */
    public boolean mo2373c() {
        return this.f1037d.mo2373c();
    }

    /* renamed from: c */
    public boolean mo2374c(C0566s sVar) {
        return this.f1037d.mo2374c(sVar);
    }

    /* renamed from: d */
    public boolean mo2375d(C0566s sVar) {
        return this.f1037d.mo2375d(sVar);
    }

    public MenuItem getItem() {
        return this.f1038e;
    }

    /* renamed from: p */
    public C0562o mo2377p() {
        return this.f1037d;
    }

    /* renamed from: s */
    public Menu mo2378s() {
        return this.f1037d;
    }

    public SubMenu setHeaderIcon(int i) {
        super.mo2443a(C0025a.getDrawable(mo2477e(), i));
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.mo2443a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.mo2445a((CharSequence) mo2477e().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.mo2445a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.mo2444a(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f1038e.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1038e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.f1037d.setQwertyMode(z);
    }
}
