package android.support.p021v7.p022a;

import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0332fb;
import android.support.p009v4.view.C0333fc;
import android.view.View;

/* renamed from: android.support.v7.a.ba */
class C0454ba extends C0333fc {

    /* renamed from: a */
    final /* synthetic */ C0452az f644a;

    C0454ba(C0452az azVar) {
        this.f644a = azVar;
    }

    public void onAnimationEnd(View view) {
        C0247by.m903b((View) this.f644a.f642a.f625n, 1.0f);
        this.f644a.f642a.f628q.mo1554a((C0332fb) null);
        this.f644a.f642a.f628q = null;
    }

    public void onAnimationStart(View view) {
        this.f644a.f642a.f625n.setVisibility(0);
    }
}
