package android.support.p021v7.p022a;

import android.support.p009v4.view.C0247by;
import android.support.p009v4.view.C0332fb;
import android.support.p021v7.view.C0521b;
import android.support.p021v7.view.C0522c;
import android.view.Menu;
import android.view.MenuItem;

/* renamed from: android.support.v7.a.bd */
class C0457bd implements C0522c {

    /* renamed from: a */
    final /* synthetic */ C0447au f647a;

    /* renamed from: b */
    private C0522c f648b;

    public C0457bd(C0447au auVar, C0522c cVar) {
        this.f647a = auVar;
        this.f648b = cVar;
    }

    /* renamed from: a */
    public void mo2043a(C0521b bVar) {
        this.f648b.mo2043a(bVar);
        if (this.f647a.f626o != null) {
            this.f647a.f590b.getDecorView().removeCallbacks(this.f647a.f627p);
        }
        if (this.f647a.f625n != null) {
            this.f647a.m1907v();
            this.f647a.f628q = C0247by.m917j(this.f647a.f625n).mo1552a(0.0f);
            this.f647a.f628q.mo1554a((C0332fb) new C0458be(this));
        }
        if (this.f647a.f593e != null) {
            this.f647a.f593e.mo1957b(this.f647a.f624m);
        }
        this.f647a.f624m = null;
    }

    /* renamed from: a */
    public boolean mo2044a(C0521b bVar, Menu menu) {
        return this.f648b.mo2044a(bVar, menu);
    }

    /* renamed from: a */
    public boolean mo2045a(C0521b bVar, MenuItem menuItem) {
        return this.f648b.mo2045a(bVar, menuItem);
    }

    /* renamed from: b */
    public boolean mo2046b(C0521b bVar, Menu menu) {
        return this.f648b.mo2046b(bVar, menu);
    }
}
