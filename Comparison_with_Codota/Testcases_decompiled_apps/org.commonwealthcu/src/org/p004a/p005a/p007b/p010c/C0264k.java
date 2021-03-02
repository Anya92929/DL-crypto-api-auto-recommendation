package org.p004a.p005a.p007b.p010c;

import java.net.URI;
import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0243ae;
import org.p004a.p005a.p007b.p008a.C0249a;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p033i.C0533l;

/* renamed from: org.a.a.b.c.k */
public abstract class C0264k extends C0255b implements C0259f, C0265l {

    /* renamed from: c */
    private C0241ac f85c;

    /* renamed from: d */
    private URI f86d;

    /* renamed from: e */
    private C0249a f87e;

    /* renamed from: a */
    public final void mo4898a(URI uri) {
        this.f86d = uri;
    }

    /* renamed from: a */
    public final void mo4899a(C0241ac acVar) {
        this.f85c = acVar;
    }

    /* renamed from: a */
    public final void mo4900a(C0249a aVar) {
        this.f87e = aVar;
    }

    /* renamed from: a_ */
    public abstract String mo4897a_();

    /* renamed from: b_ */
    public final C0249a mo4893b_() {
        return this.f87e;
    }

    /* renamed from: c */
    public final C0241ac mo4901c() {
        return this.f85c != null ? this.f85c : C0250b.m113f(mo5331f());
    }

    /* renamed from: g */
    public final C0243ae mo4902g() {
        String a_ = mo4897a_();
        C0241ac c = mo4901c();
        URI uri = this.f86d;
        String str = null;
        if (uri != null) {
            str = uri.toASCIIString();
        }
        if (str == null || str.length() == 0) {
            str = "/";
        }
        return new C0533l(a_, str, c);
    }

    /* renamed from: i */
    public final URI mo4903i() {
        return this.f86d;
    }

    public String toString() {
        return mo4897a_() + " " + this.f86d + " " + mo4901c();
    }
}
