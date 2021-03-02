package android.support.design.widget;

import android.support.p000v4.view.ViewCompat;
import android.view.View;

/* renamed from: android.support.design.widget.ag */
class C0015ag implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SwipeDismissBehavior f120a;

    /* renamed from: b */
    private final View f121b;

    /* renamed from: c */
    private final boolean f122c;

    C0015ag(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.f120a = swipeDismissBehavior;
        this.f121b = view;
        this.f122c = z;
    }

    public void run() {
        if (this.f120a.f77a != null && this.f120a.f77a.continueSettling(true)) {
            ViewCompat.postOnAnimation(this.f121b, this);
        } else if (this.f122c && this.f120a.f78b != null) {
            this.f120a.f78b.mo186a(this.f121b);
        }
    }
}
