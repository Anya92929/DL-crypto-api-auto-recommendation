package android.support.p021v7.view.menu;

import android.content.Context;
import android.support.p009v4.view.C0344n;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.v */
class C0569v extends C0344n {

    /* renamed from: a */
    final ActionProvider f1161a;

    /* renamed from: b */
    final /* synthetic */ C0568u f1162b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0569v(C0568u uVar, Context context, ActionProvider actionProvider) {
        super(context);
        this.f1162b = uVar;
        this.f1161a = actionProvider;
    }

    /* renamed from: a */
    public View mo1615a() {
        return this.f1161a.onCreateActionView();
    }

    /* renamed from: a */
    public void mo1619a(SubMenu subMenu) {
        this.f1161a.onPrepareSubMenu(this.f1162b.mo2410a(subMenu));
    }

    /* renamed from: d */
    public boolean mo1623d() {
        return this.f1161a.onPerformDefaultAction();
    }

    /* renamed from: e */
    public boolean mo1624e() {
        return this.f1161a.hasSubMenu();
    }
}
