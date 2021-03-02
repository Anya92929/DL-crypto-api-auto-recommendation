package android.support.design.widget;

import android.support.p000v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

/* renamed from: android.support.design.widget.v */
class C0074v extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ int f221a;

    /* renamed from: b */
    final /* synthetic */ Snackbar f222b;

    C0074v(Snackbar snackbar, int i) {
        this.f222b = snackbar;
        this.f221a = i;
    }

    public void onAnimationEnd(View view) {
        this.f222b.m106d(this.f221a);
    }

    public void onAnimationStart(View view) {
        this.f222b.f69c.mo135b(0, 180);
    }
}
