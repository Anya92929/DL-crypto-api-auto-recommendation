package android.support.design.widget;

import android.view.ViewTreeObserver;

/* renamed from: android.support.design.widget.j */
class C0062j implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    final /* synthetic */ CoordinatorLayout f213a;

    C0062j(CoordinatorLayout coordinatorLayout) {
        this.f213a = coordinatorLayout;
    }

    public boolean onPreDraw() {
        this.f213a.mo74a(false);
        return true;
    }
}
