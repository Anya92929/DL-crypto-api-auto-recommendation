package android.support.p021v7.view.menu;

import android.content.Context;
import android.support.p009v4.view.C0346p;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.view.menu.aa */
class C0534aa extends C0569v implements ActionProvider.VisibilityListener {

    /* renamed from: c */
    C0346p f999c;

    /* renamed from: d */
    final /* synthetic */ C0573z f1000d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0534aa(C0573z zVar, Context context, ActionProvider actionProvider) {
        super(zVar, context, actionProvider);
        this.f1000d = zVar;
    }

    /* renamed from: a */
    public View mo1616a(MenuItem menuItem) {
        return this.f1161a.onCreateActionView(menuItem);
    }

    /* renamed from: a */
    public void mo1618a(C0346p pVar) {
        this.f999c = pVar;
        ActionProvider actionProvider = this.f1161a;
        if (pVar == null) {
            this = null;
        }
        actionProvider.setVisibilityListener(this);
    }

    /* renamed from: b */
    public boolean mo1621b() {
        return this.f1161a.overridesItemVisibility();
    }

    /* renamed from: c */
    public boolean mo1622c() {
        return this.f1161a.isVisible();
    }

    public void onActionProviderVisibilityChanged(boolean z) {
        if (this.f999c != null) {
            this.f999c.mo1627a(z);
        }
    }
}
