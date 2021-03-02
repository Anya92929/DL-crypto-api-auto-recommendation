package android.support.p021v7.widget;

import android.content.Context;
import android.support.p021v7.p023b.C0506b;
import android.support.p021v7.view.menu.C0536ac;
import android.support.p021v7.view.menu.C0539af;
import android.support.p021v7.view.menu.C0547an;
import android.support.p021v7.view.menu.C0566s;
import android.view.View;

/* renamed from: android.support.v7.widget.m */
class C0691m extends C0536ac {

    /* renamed from: a */
    final /* synthetic */ C0689k f1709a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0691m(C0689k kVar, Context context, C0547an anVar, View view) {
        super(context, anVar, view, false, C0506b.actionOverflowMenuStyle);
        this.f1709a = kVar;
        if (!((C0566s) anVar.getItem()).mo2543j()) {
            setAnchorView(kVar.f1691i == null ? (View) kVar.f1045f : kVar.f1691i);
        }
        mo2323a((C0539af) kVar.f1689g);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo2329e() {
        C0691m unused = this.f1709a.f1707y = null;
        this.f1709a.f1690h = 0;
        super.mo2329e();
    }
}
