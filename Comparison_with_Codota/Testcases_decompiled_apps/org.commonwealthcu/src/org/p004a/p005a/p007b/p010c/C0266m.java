package org.p004a.p005a.p007b.p010c;

import java.net.URI;
import java.util.LinkedList;
import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0548l;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.p007b.p008a.C0249a;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p033i.C0537p;

/* renamed from: org.a.a.b.c.m */
public class C0266m {

    /* renamed from: a */
    private String f88a;

    /* renamed from: b */
    private C0241ac f89b;

    /* renamed from: c */
    private URI f90c;

    /* renamed from: d */
    private C0537p f91d;

    /* renamed from: e */
    private C0546k f92e;

    /* renamed from: f */
    private LinkedList f93f;

    /* renamed from: g */
    private C0249a f94g;

    C0266m() {
        this((String) null);
    }

    private C0266m(String str) {
        this.f88a = null;
    }

    /* renamed from: a */
    public static C0266m m144a(C0568q qVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        C0266m mVar = new C0266m();
        if (qVar == null) {
            return mVar;
        }
        mVar.f88a = qVar.mo4902g().mo4863a();
        mVar.f89b = qVar.mo4902g().mo4864b();
        if (qVar instanceof C0265l) {
            mVar.f90c = ((C0265l) qVar).mo4903i();
        } else {
            mVar.f90c = URI.create(qVar.mo4902g().mo4863a());
        }
        if (mVar.f91d == null) {
            mVar.f91d = new C0537p();
        }
        mVar.f91d.mo5371a();
        mVar.f91d.mo5373a(qVar.mo5328d());
        if (qVar instanceof C0548l) {
            mVar.f92e = ((C0548l) qVar).mo4896b();
        } else {
            mVar.f92e = null;
        }
        if (qVar instanceof C0259f) {
            mVar.f94g = ((C0259f) qVar).mo4893b_();
        } else {
            mVar.f94g = null;
        }
        mVar.f93f = null;
        return mVar;
    }

    /* renamed from: a */
    public static void m145a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalStateException(str + " is null");
        }
    }

    /* renamed from: a */
    public static void m146a(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: a */
    public final C0265l mo4906a() {
        C0264k kVar;
        URI create = this.f90c != null ? this.f90c : URI.create("/");
        C0546k kVar2 = this.f92e;
        if (kVar2 == null) {
            kVar = new C0268o(this.f88a);
        } else {
            C0267n nVar = new C0267n(this.f88a);
            nVar.mo4894a(kVar2);
            kVar = nVar;
        }
        kVar.mo4899a(this.f89b);
        kVar.mo4898a(create);
        if (this.f91d != null) {
            kVar.mo5322a(this.f91d.mo5377b());
        }
        kVar.mo4900a(this.f94g);
        return kVar;
    }

    /* renamed from: a */
    public final C0266m mo4907a(URI uri) {
        this.f90c = uri;
        return this;
    }
}
