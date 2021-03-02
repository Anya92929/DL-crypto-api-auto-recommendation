package com.google.p008a.p010b.p011a;

import com.google.p008a.C0353ab;
import com.google.p008a.C0490t;
import com.google.p008a.C0493w;
import com.google.p008a.C0495y;
import com.google.p008a.C0496z;
import com.google.p008a.p013d.C0473d;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.a.b.a.j */
public final class C0410j extends C0473d {

    /* renamed from: a */
    private static final Writer f3412a = new C0411k();

    /* renamed from: b */
    private static final C0353ab f3413b = new C0353ab("closed");

    /* renamed from: c */
    private final List<C0493w> f3414c = new ArrayList();

    /* renamed from: d */
    private String f3415d;

    /* renamed from: e */
    private C0493w f3416e = C0495y.f3650a;

    public C0410j() {
        super(f3412a);
    }

    /* renamed from: a */
    private void m2659a(C0493w wVar) {
        if (this.f3415d != null) {
            if (!wVar.mo6539j() || mo6508i()) {
                ((C0496z) m2660j()).mo6546a(this.f3415d, wVar);
            }
            this.f3415d = null;
        } else if (this.f3414c.isEmpty()) {
            this.f3416e = wVar;
        } else {
            C0493w j = m2660j();
            if (j instanceof C0490t) {
                ((C0490t) j).mo6532a(wVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: j */
    private C0493w m2660j() {
        return this.f3414c.get(this.f3414c.size() - 1);
    }

    /* renamed from: a */
    public C0473d mo6394a(long j) {
        m2659a((C0493w) new C0353ab((Number) Long.valueOf(j)));
        return this;
    }

    /* renamed from: a */
    public C0473d mo6395a(Number number) {
        if (number == null) {
            return mo6405f();
        }
        if (!mo6506g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m2659a((C0493w) new C0353ab(number));
        return this;
    }

    /* renamed from: a */
    public C0473d mo6396a(String str) {
        if (this.f3414c.isEmpty() || this.f3415d != null) {
            throw new IllegalStateException();
        } else if (m2660j() instanceof C0496z) {
            this.f3415d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public C0473d mo6397a(boolean z) {
        m2659a((C0493w) new C0353ab(Boolean.valueOf(z)));
        return this;
    }

    /* renamed from: a */
    public C0493w mo6398a() {
        if (this.f3414c.isEmpty()) {
            return this.f3416e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f3414c);
    }

    /* renamed from: b */
    public C0473d mo6399b() {
        C0490t tVar = new C0490t();
        m2659a((C0493w) tVar);
        this.f3414c.add(tVar);
        return this;
    }

    /* renamed from: b */
    public C0473d mo6400b(String str) {
        if (str == null) {
            return mo6405f();
        }
        m2659a((C0493w) new C0353ab(str));
        return this;
    }

    /* renamed from: c */
    public C0473d mo6401c() {
        if (this.f3414c.isEmpty() || this.f3415d != null) {
            throw new IllegalStateException();
        } else if (m2660j() instanceof C0490t) {
            this.f3414c.remove(this.f3414c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public void close() {
        if (!this.f3414c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f3414c.add(f3413b);
    }

    /* renamed from: d */
    public C0473d mo6403d() {
        C0496z zVar = new C0496z();
        m2659a((C0493w) zVar);
        this.f3414c.add(zVar);
        return this;
    }

    /* renamed from: e */
    public C0473d mo6404e() {
        if (this.f3414c.isEmpty() || this.f3415d != null) {
            throw new IllegalStateException();
        } else if (m2660j() instanceof C0496z) {
            this.f3414c.remove(this.f3414c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: f */
    public C0473d mo6405f() {
        m2659a((C0493w) C0495y.f3650a);
        return this;
    }

    public void flush() {
    }
}
