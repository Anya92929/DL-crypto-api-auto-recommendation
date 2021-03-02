package android.support.p009v4.p019f;

import java.util.Iterator;

/* renamed from: android.support.v4.f.i */
final class C0144i implements Iterator {

    /* renamed from: a */
    final int f209a;

    /* renamed from: b */
    int f210b;

    /* renamed from: c */
    int f211c;

    /* renamed from: d */
    boolean f212d = false;

    /* renamed from: e */
    final /* synthetic */ C0143h f213e;

    C0144i(C0143h hVar, int i) {
        this.f213e = hVar;
        this.f209a = i;
        this.f210b = hVar.mo1041a();
    }

    public boolean hasNext() {
        return this.f211c < this.f210b;
    }

    public Object next() {
        Object a = this.f213e.mo1043a(this.f211c, this.f209a);
        this.f211c++;
        this.f212d = true;
        return a;
    }

    public void remove() {
        if (!this.f212d) {
            throw new IllegalStateException();
        }
        this.f211c--;
        this.f210b--;
        this.f212d = false;
        this.f213e.mo1045a(this.f211c);
    }
}
