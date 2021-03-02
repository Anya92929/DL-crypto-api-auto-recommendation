package android.support.p021v7.p022a;

import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0333fc;
import android.support.p021v7.view.C0531l;
import android.view.View;

/* renamed from: android.support.v7.a.bx */
class C0477bx extends C0333fc {

    /* renamed from: a */
    final /* synthetic */ C0476bw f745a;

    C0477bx(C0476bw bwVar) {
        this.f745a = bwVar;
    }

    public void onAnimationEnd(View view) {
        if (this.f745a.f716C && this.f745a.f738t != null) {
            C0247by.m890a(this.f745a.f738t, 0.0f);
            C0247by.m890a((View) this.f745a.f735q, 0.0f);
        }
        this.f745a.f735q.setVisibility(8);
        this.f745a.f735q.setTransitioning(false);
        C0531l unused = this.f745a.f721H = null;
        this.f745a.mo2078i();
        if (this.f745a.f734p != null) {
            C0247by.requestApplyInsets(this.f745a.f734p);
        }
    }
}
