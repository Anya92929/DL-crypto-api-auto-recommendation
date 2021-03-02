package android.support.p021v7.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: android.support.v7.view.menu.h */
class C0555h implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ C0554g f1077a;

    C0555h(C0554g gVar) {
        this.f1077a = gVar;
    }

    public void onGlobalLayout() {
        if (this.f1077a.mo2364d() && this.f1077a.f1061h.size() > 0 && !((C0558k) this.f1077a.f1061h.get(0)).f1083a.mo3181g()) {
            View b = this.f1077a.f1067n;
            if (b == null || !b.isShown()) {
                this.f1077a.mo2363c();
                return;
            }
            for (C0558k kVar : this.f1077a.f1061h) {
                kVar.f1083a.mo2362a();
            }
        }
    }
}
