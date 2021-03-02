package org.p004a.p005a.p007b.p011d;

import org.p004a.p005a.p006a.C0228i;
import org.p004a.p005a.p007b.C0248a;
import org.p004a.p005a.p007b.C0286f;
import org.p004a.p005a.p007b.C0287g;
import org.p004a.p005a.p007b.p008a.C0249a;
import org.p004a.p005a.p013c.C0298a;
import org.p004a.p005a.p014d.p016b.C0306b;
import org.p004a.p005a.p014d.p016b.C0309e;
import org.p004a.p005a.p036l.C0553e;
import org.p004a.p005a.p036l.C0554f;

/* renamed from: org.a.a.b.d.a */
public final class C0270a extends C0554f {
    public C0270a() {
    }

    private C0270a(C0553e eVar) {
        super(eVar);
    }

    /* renamed from: a */
    public static C0270a m151a(C0553e eVar) {
        return eVar instanceof C0270a ? (C0270a) eVar : new C0270a(eVar);
    }

    /* renamed from: b */
    private C0298a m152b(String str) {
        return (C0298a) mo5408a(str, C0298a.class);
    }

    /* renamed from: a */
    public final C0309e mo4908a() {
        return (C0309e) mo5408a("http.route", C0306b.class);
    }

    /* renamed from: b */
    public final C0286f mo4909b() {
        return (C0286f) mo5408a("http.cookie-store", C0286f.class);
    }

    /* renamed from: c */
    public final C0298a mo4910c() {
        return m152b("http.cookiespec-registry");
    }

    /* renamed from: d */
    public final C0298a mo4911d() {
        return m152b("http.authscheme-registry");
    }

    /* renamed from: e */
    public final C0287g mo4912e() {
        return (C0287g) mo5408a("http.auth.credentials-provider", C0287g.class);
    }

    /* renamed from: f */
    public final C0248a mo4913f() {
        return (C0248a) mo5408a("http.auth.auth-cache", C0248a.class);
    }

    /* renamed from: g */
    public final C0228i mo4914g() {
        return (C0228i) mo5408a("http.auth.target-scope", C0228i.class);
    }

    /* renamed from: h */
    public final C0228i mo4915h() {
        return (C0228i) mo5408a("http.auth.proxy-scope", C0228i.class);
    }

    /* renamed from: i */
    public final C0249a mo4916i() {
        C0249a aVar = (C0249a) mo5408a("http.request-config", C0249a.class);
        return aVar != null ? aVar : C0249a.f50a;
    }
}
