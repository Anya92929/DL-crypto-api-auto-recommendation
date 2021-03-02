package android.support.p021v7.widget;

import android.support.p009v4.view.C0247by;

/* renamed from: android.support.v7.widget.co */
class C0644co implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0636cg f1563a;

    private C0644co(C0636cg cgVar) {
        this.f1563a = cgVar;
    }

    /* synthetic */ C0644co(C0636cg cgVar, C0637ch chVar) {
        this(cgVar);
    }

    public void run() {
        if (this.f1563a.f1537h != null && C0247by.m925r(this.f1563a.f1537h) && this.f1563a.f1537h.getCount() > this.f1563a.f1537h.getChildCount() && this.f1563a.f1537h.getChildCount() <= this.f1563a.f1533b) {
            this.f1563a.f1534c.setInputMethodMode(2);
            this.f1563a.mo2362a();
        }
    }
}
