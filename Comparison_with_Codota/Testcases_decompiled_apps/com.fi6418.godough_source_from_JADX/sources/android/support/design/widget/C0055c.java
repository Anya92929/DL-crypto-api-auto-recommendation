package android.support.design.widget;

import android.support.design.widget.AppBarLayout;
import android.support.p000v4.view.ViewCompat;

/* renamed from: android.support.design.widget.c */
class C0055c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppBarLayout.Behavior f195a;

    /* renamed from: b */
    private final CoordinatorLayout f196b;

    /* renamed from: c */
    private final AppBarLayout f197c;

    C0055c(AppBarLayout.Behavior behavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f195a = behavior;
        this.f196b = coordinatorLayout;
        this.f197c = appBarLayout;
    }

    public void run() {
        if (this.f197c != null && this.f195a.f17d != null && this.f195a.f17d.computeScrollOffset()) {
            this.f195a.mo58b(this.f196b, this.f197c, this.f195a.f17d.getCurrY());
            ViewCompat.postOnAnimation(this.f197c, this);
        }
    }
}
