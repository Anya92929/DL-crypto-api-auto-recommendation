package com.google.p008a.p010b.p011a;

import com.google.p008a.C0353ab;
import com.google.p008a.C0490t;
import com.google.p008a.C0495y;
import com.google.p008a.C0496z;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.a.b.a.h */
public final class C0408h extends C0470a {

    /* renamed from: a */
    private static final Reader f3409a = new C0409i();

    /* renamed from: b */
    private static final Object f3410b = new Object();

    /* renamed from: c */
    private final List<Object> f3411c;

    /* renamed from: a */
    private void m2641a(C0472c cVar) {
        if (mo6381f() != cVar) {
            throw new IllegalStateException("Expected " + cVar + " but was " + mo6381f());
        }
    }

    /* renamed from: r */
    private Object m2642r() {
        return this.f3411c.get(this.f3411c.size() - 1);
    }

    /* renamed from: s */
    private Object m2643s() {
        return this.f3411c.remove(this.f3411c.size() - 1);
    }

    /* renamed from: a */
    public void mo6375a() {
        m2641a(C0472c.BEGIN_ARRAY);
        this.f3411c.add(((C0490t) m2642r()).iterator());
    }

    /* renamed from: b */
    public void mo6376b() {
        m2641a(C0472c.END_ARRAY);
        m2643s();
        m2643s();
    }

    /* renamed from: c */
    public void mo6377c() {
        m2641a(C0472c.BEGIN_OBJECT);
        this.f3411c.add(((C0496z) m2642r()).mo6549o().iterator());
    }

    public void close() {
        this.f3411c.clear();
        this.f3411c.add(f3410b);
    }

    /* renamed from: d */
    public void mo6379d() {
        m2641a(C0472c.END_OBJECT);
        m2643s();
        m2643s();
    }

    /* renamed from: e */
    public boolean mo6380e() {
        C0472c f = mo6381f();
        return (f == C0472c.END_OBJECT || f == C0472c.END_ARRAY) ? false : true;
    }

    /* renamed from: f */
    public C0472c mo6381f() {
        if (this.f3411c.isEmpty()) {
            return C0472c.END_DOCUMENT;
        }
        Object r = m2642r();
        if (r instanceof Iterator) {
            boolean z = this.f3411c.get(this.f3411c.size() - 2) instanceof C0496z;
            Iterator it = (Iterator) r;
            if (!it.hasNext()) {
                return z ? C0472c.END_OBJECT : C0472c.END_ARRAY;
            }
            if (z) {
                return C0472c.NAME;
            }
            this.f3411c.add(it.next());
            return mo6381f();
        } else if (r instanceof C0496z) {
            return C0472c.BEGIN_OBJECT;
        } else {
            if (r instanceof C0490t) {
                return C0472c.BEGIN_ARRAY;
            }
            if (r instanceof C0353ab) {
                C0353ab abVar = (C0353ab) r;
                if (abVar.mo6308q()) {
                    return C0472c.STRING;
                }
                if (abVar.mo6306o()) {
                    return C0472c.BOOLEAN;
                }
                if (abVar.mo6307p()) {
                    return C0472c.NUMBER;
                }
                throw new AssertionError();
            } else if (r instanceof C0495y) {
                return C0472c.NULL;
            } else {
                if (r == f3410b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    /* renamed from: g */
    public String mo6382g() {
        m2641a(C0472c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m2642r()).next();
        this.f3411c.add(entry.getValue());
        return (String) entry.getKey();
    }

    /* renamed from: h */
    public String mo6383h() {
        C0472c f = mo6381f();
        if (f == C0472c.STRING || f == C0472c.NUMBER) {
            return ((C0353ab) m2643s()).mo6298b();
        }
        throw new IllegalStateException("Expected " + C0472c.STRING + " but was " + f);
    }

    /* renamed from: i */
    public boolean mo6384i() {
        m2641a(C0472c.BOOLEAN);
        return ((C0353ab) m2643s()).mo6303f();
    }

    /* renamed from: j */
    public void mo6385j() {
        m2641a(C0472c.NULL);
        m2643s();
    }

    /* renamed from: k */
    public double mo6386k() {
        C0472c f = mo6381f();
        if (f == C0472c.NUMBER || f == C0472c.STRING) {
            double c = ((C0353ab) m2642r()).mo6299c();
            if (mo6500p() || (!Double.isNaN(c) && !Double.isInfinite(c))) {
                m2643s();
                return c;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + c);
        }
        throw new IllegalStateException("Expected " + C0472c.NUMBER + " but was " + f);
    }

    /* renamed from: l */
    public long mo6387l() {
        C0472c f = mo6381f();
        if (f == C0472c.NUMBER || f == C0472c.STRING) {
            long d = ((C0353ab) m2642r()).mo6300d();
            m2643s();
            return d;
        }
        throw new IllegalStateException("Expected " + C0472c.NUMBER + " but was " + f);
    }

    /* renamed from: m */
    public int mo6388m() {
        C0472c f = mo6381f();
        if (f == C0472c.NUMBER || f == C0472c.STRING) {
            int e = ((C0353ab) m2642r()).mo6301e();
            m2643s();
            return e;
        }
        throw new IllegalStateException("Expected " + C0472c.NUMBER + " but was " + f);
    }

    /* renamed from: n */
    public void mo6389n() {
        if (mo6381f() == C0472c.NAME) {
            mo6382g();
        } else {
            m2643s();
        }
    }

    /* renamed from: o */
    public void mo6390o() {
        m2641a(C0472c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m2642r()).next();
        this.f3411c.add(entry.getValue());
        this.f3411c.add(new C0353ab((String) entry.getKey()));
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
