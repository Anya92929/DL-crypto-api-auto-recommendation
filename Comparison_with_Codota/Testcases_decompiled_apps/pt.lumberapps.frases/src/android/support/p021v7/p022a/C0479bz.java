package android.support.p021v7.p022a;

import android.support.p009v4.view.C0334fd;
import android.view.View;

/* renamed from: android.support.v7.a.bz */
class C0479bz implements C0334fd {

    /* renamed from: a */
    final /* synthetic */ C0476bw f747a;

    C0479bz(C0476bw bwVar) {
        this.f747a = bwVar;
    }

    public void onAnimationUpdate(View view) {
        ((View) this.f747a.f735q.getParent()).invalidate();
    }
}
