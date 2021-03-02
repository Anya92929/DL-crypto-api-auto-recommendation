package android.support.p021v7.p022a;

import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0332fb;
import android.view.View;

/* renamed from: android.support.v7.a.az */
class C0452az implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0447au f642a;

    C0452az(C0447au auVar) {
        this.f642a = auVar;
    }

    public void run() {
        this.f642a.f626o.showAtLocation(this.f642a.f625n, 55, 0, 0);
        this.f642a.m1907v();
        C0247by.m903b((View) this.f642a.f625n, 0.0f);
        this.f642a.f628q = C0247by.m917j(this.f642a.f625n).mo1552a(1.0f);
        this.f642a.f628q.mo1554a((C0332fb) new C0454ba(this));
    }
}
