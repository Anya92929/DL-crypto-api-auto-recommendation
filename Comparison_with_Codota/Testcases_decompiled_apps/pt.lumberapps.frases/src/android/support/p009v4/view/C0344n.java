package android.support.p009v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v4.view.n */
public abstract class C0344n {

    /* renamed from: a */
    private final Context f406a;

    /* renamed from: b */
    private C0345o f407b;

    /* renamed from: c */
    private C0346p f408c;

    public C0344n(Context context) {
        this.f406a = context;
    }

    /* renamed from: a */
    public abstract View mo1615a();

    /* renamed from: a */
    public View mo1616a(MenuItem menuItem) {
        return mo1615a();
    }

    /* renamed from: a */
    public void mo1617a(C0345o oVar) {
        this.f407b = oVar;
    }

    /* renamed from: a */
    public void mo1618a(C0346p pVar) {
        if (!(this.f408c == null || pVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f408c = pVar;
    }

    /* renamed from: a */
    public void mo1619a(SubMenu subMenu) {
    }

    /* renamed from: a */
    public void mo1620a(boolean z) {
        if (this.f407b != null) {
            this.f407b.mo1626a(z);
        }
    }

    /* renamed from: b */
    public boolean mo1621b() {
        return false;
    }

    /* renamed from: c */
    public boolean mo1622c() {
        return true;
    }

    /* renamed from: d */
    public boolean mo1623d() {
        return false;
    }

    /* renamed from: e */
    public boolean mo1624e() {
        return false;
    }

    /* renamed from: f */
    public void mo1625f() {
        this.f408c = null;
        this.f407b = null;
    }
}
