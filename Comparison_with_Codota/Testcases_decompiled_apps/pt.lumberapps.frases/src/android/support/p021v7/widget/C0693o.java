package android.support.p021v7.widget;

import android.view.View;

/* renamed from: android.support.v7.widget.o */
class C0693o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0689k f1711a;

    /* renamed from: b */
    private C0696r f1712b;

    public C0693o(C0689k kVar, C0696r rVar) {
        this.f1711a = kVar;
        this.f1712b = rVar;
    }

    public void run() {
        if (this.f1711a.f1042c != null) {
            this.f1711a.f1042c.mo2478f();
        }
        View view = (View) this.f1711a.f1045f;
        if (!(view == null || view.getWindowToken() == null || !this.f1712b.mo2327c())) {
            C0696r unused = this.f1711a.f1706x = this.f1712b;
        }
        C0693o unused2 = this.f1711a.f1708z = null;
    }
}
