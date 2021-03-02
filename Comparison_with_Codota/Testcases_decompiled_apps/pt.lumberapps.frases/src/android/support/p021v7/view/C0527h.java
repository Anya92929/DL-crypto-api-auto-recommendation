package android.support.p021v7.view;

import android.content.Context;
import android.support.p009v4.p014c.p015a.C0123a;
import android.support.p009v4.p014c.p015a.C0124b;
import android.support.p009v4.p019f.C0150o;
import android.support.p021v7.view.menu.C0542ai;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.h */
public class C0527h implements C0522c {

    /* renamed from: a */
    final ActionMode.Callback f908a;

    /* renamed from: b */
    final Context f909b;

    /* renamed from: c */
    final ArrayList f910c = new ArrayList();

    /* renamed from: d */
    final C0150o f911d = new C0150o();

    public C0527h(Context context, ActionMode.Callback callback) {
        this.f909b = context;
        this.f908a = callback;
    }

    /* renamed from: a */
    private Menu m2227a(Menu menu) {
        Menu menu2 = (Menu) this.f911d.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        Menu a = C0542ai.m2331a(this.f909b, (C0123a) menu);
        this.f911d.put(menu, a);
        return a;
    }

    /* renamed from: a */
    public void mo2043a(C0521b bVar) {
        this.f908a.onDestroyActionMode(mo2221b(bVar));
    }

    /* renamed from: a */
    public boolean mo2044a(C0521b bVar, Menu menu) {
        return this.f908a.onCreateActionMode(mo2221b(bVar), m2227a(menu));
    }

    /* renamed from: a */
    public boolean mo2045a(C0521b bVar, MenuItem menuItem) {
        return this.f908a.onActionItemClicked(mo2221b(bVar), C0542ai.m2332a(this.f909b, (C0124b) menuItem));
    }

    /* renamed from: b */
    public ActionMode mo2221b(C0521b bVar) {
        int size = this.f910c.size();
        for (int i = 0; i < size; i++) {
            C0526g gVar = (C0526g) this.f910c.get(i);
            if (gVar != null && gVar.f907b == bVar) {
                return gVar;
            }
        }
        C0526g gVar2 = new C0526g(this.f909b, bVar);
        this.f910c.add(gVar2);
        return gVar2;
    }

    /* renamed from: b */
    public boolean mo2046b(C0521b bVar, Menu menu) {
        return this.f908a.onPrepareActionMode(mo2221b(bVar), m2227a(menu));
    }
}
