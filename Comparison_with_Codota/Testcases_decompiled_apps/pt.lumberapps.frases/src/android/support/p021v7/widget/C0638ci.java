package android.support.p021v7.widget;

import android.view.View;

/* renamed from: android.support.v7.widget.ci */
class C0638ci implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0636cg f1557a;

    C0638ci(C0636cg cgVar) {
        this.f1557a = cgVar;
    }

    public void run() {
        View i = this.f1557a.mo3184i();
        if (i != null && i.getWindowToken() != null) {
            this.f1557a.mo2362a();
        }
    }
}
