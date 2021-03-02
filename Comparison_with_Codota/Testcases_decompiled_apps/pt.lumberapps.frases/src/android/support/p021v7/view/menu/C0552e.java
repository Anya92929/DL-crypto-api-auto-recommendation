package android.support.p021v7.view.menu;

import android.content.Context;
import android.support.p009v4.p014c.p015a.C0124b;
import android.support.p009v4.p014c.p015a.C0125c;
import android.support.p009v4.p019f.C0136a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* renamed from: android.support.v7.view.menu.e */
abstract class C0552e extends C0553f {

    /* renamed from: a */
    final Context f1050a;

    /* renamed from: c */
    private Map f1051c;

    /* renamed from: d */
    private Map f1052d;

    C0552e(Context context, Object obj) {
        super(obj);
        this.f1050a = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final MenuItem mo2409a(MenuItem menuItem) {
        if (!(menuItem instanceof C0124b)) {
            return menuItem;
        }
        C0124b bVar = (C0124b) menuItem;
        if (this.f1051c == null) {
            this.f1051c = new C0136a();
        }
        MenuItem menuItem2 = (MenuItem) this.f1051c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem a = C0542ai.m2332a(this.f1050a, bVar);
        this.f1051c.put(bVar, a);
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final SubMenu mo2410a(SubMenu subMenu) {
        if (!(subMenu instanceof C0125c)) {
            return subMenu;
        }
        C0125c cVar = (C0125c) subMenu;
        if (this.f1052d == null) {
            this.f1052d = new C0136a();
        }
        SubMenu subMenu2 = (SubMenu) this.f1052d.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu a = C0542ai.m2333a(this.f1050a, cVar);
        this.f1052d.put(cVar, a);
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo2411a() {
        if (this.f1051c != null) {
            this.f1051c.clear();
        }
        if (this.f1052d != null) {
            this.f1052d.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo2412a(int i) {
        if (this.f1051c != null) {
            Iterator it = this.f1051c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo2413b(int i) {
        if (this.f1051c != null) {
            Iterator it = this.f1051c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
