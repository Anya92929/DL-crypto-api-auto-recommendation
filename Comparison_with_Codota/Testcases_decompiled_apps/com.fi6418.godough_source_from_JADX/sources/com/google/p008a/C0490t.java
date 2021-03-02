package com.google.p008a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.a.t */
public final class C0490t extends C0493w implements Iterable<C0493w> {

    /* renamed from: a */
    private final List<C0493w> f3649a = new ArrayList();

    /* renamed from: a */
    public Number mo6296a() {
        if (this.f3649a.size() == 1) {
            return this.f3649a.get(0).mo6296a();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public void mo6532a(C0493w wVar) {
        if (wVar == null) {
            wVar = C0495y.f3650a;
        }
        this.f3649a.add(wVar);
    }

    /* renamed from: b */
    public String mo6298b() {
        if (this.f3649a.size() == 1) {
            return this.f3649a.get(0).mo6298b();
        }
        throw new IllegalStateException();
    }

    /* renamed from: c */
    public double mo6299c() {
        if (this.f3649a.size() == 1) {
            return this.f3649a.get(0).mo6299c();
        }
        throw new IllegalStateException();
    }

    /* renamed from: d */
    public long mo6300d() {
        if (this.f3649a.size() == 1) {
            return this.f3649a.get(0).mo6300d();
        }
        throw new IllegalStateException();
    }

    /* renamed from: e */
    public int mo6301e() {
        if (this.f3649a.size() == 1) {
            return this.f3649a.get(0).mo6301e();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0490t) && ((C0490t) obj).f3649a.equals(this.f3649a));
    }

    /* renamed from: f */
    public boolean mo6303f() {
        if (this.f3649a.size() == 1) {
            return this.f3649a.get(0).mo6303f();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f3649a.hashCode();
    }

    public Iterator<C0493w> iterator() {
        return this.f3649a.iterator();
    }
}
