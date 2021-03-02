package android.support.p009v4.widget;

import android.support.p009v4.view.C0247by;

/* renamed from: android.support.v4.widget.d */
class C0403d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0357a f554a;

    private C0403d(C0357a aVar) {
        this.f554a = aVar;
    }

    public void run() {
        if (this.f554a.f498o) {
            if (this.f554a.f496m) {
                boolean unused = this.f554a.f496m = false;
                this.f554a.f484a.mo1861a();
            }
            C0402c c = this.f554a.f484a;
            if (c.mo1866c() || !this.f554a.m1435a()) {
                boolean unused2 = this.f554a.f498o = false;
                return;
            }
            if (this.f554a.f497n) {
                boolean unused3 = this.f554a.f497n = false;
                this.f554a.m1446d();
            }
            c.mo1867d();
            this.f554a.mo1754a(c.mo1870g(), c.mo1871h());
            C0247by.m897a(this.f554a.f486c, (Runnable) this);
        }
    }
}
