package com.google.p008a;

import com.google.p008a.p010b.C0433ag;
import com.google.p008a.p013d.C0473d;
import java.io.IOException;
import java.io.StringWriter;

/* renamed from: com.google.a.w */
public abstract class C0493w {
    /* renamed from: a */
    public Number mo6296a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: b */
    public String mo6298b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: c */
    public double mo6299c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: d */
    public long mo6300d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: e */
    public int mo6301e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: f */
    public boolean mo6303f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: g */
    public boolean mo6536g() {
        return this instanceof C0490t;
    }

    /* renamed from: h */
    public boolean mo6537h() {
        return this instanceof C0496z;
    }

    /* renamed from: i */
    public boolean mo6538i() {
        return this instanceof C0353ab;
    }

    /* renamed from: j */
    public boolean mo6539j() {
        return this instanceof C0495y;
    }

    /* renamed from: k */
    public C0496z mo6540k() {
        if (mo6537h()) {
            return (C0496z) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    /* renamed from: l */
    public C0490t mo6541l() {
        if (mo6536g()) {
            return (C0490t) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    /* renamed from: m */
    public C0353ab mo6542m() {
        if (mo6538i()) {
            return (C0353ab) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public Boolean mo6305n() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            C0473d dVar = new C0473d(stringWriter);
            dVar.mo6502b(true);
            C0433ag.m2723a(this, dVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
