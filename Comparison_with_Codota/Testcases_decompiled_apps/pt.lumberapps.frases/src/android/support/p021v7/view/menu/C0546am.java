package android.support.p021v7.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: android.support.v7.view.menu.am */
class C0546am implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ C0545al f1036a;

    C0546am(C0545al alVar) {
        this.f1036a = alVar;
    }

    public void onGlobalLayout() {
        if (this.f1036a.mo2364d()) {
            View a = this.f1036a.f1026l;
            if (a == null || !a.isShown()) {
                this.f1036a.mo2363c();
            } else if (this.f1036a.mo2364d()) {
                this.f1036a.f1022h.mo2362a();
            }
        }
    }
}
