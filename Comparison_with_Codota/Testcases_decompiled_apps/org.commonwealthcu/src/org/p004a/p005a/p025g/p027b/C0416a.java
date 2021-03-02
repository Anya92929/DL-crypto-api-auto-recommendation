package org.p004a.p005a.p025g.p027b;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0247b;
import org.p004a.p005a.C0561m;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.C0572u;
import org.p004a.p005a.p006a.C0223d;
import org.p004a.p005a.p006a.C0225f;
import org.p004a.p005a.p007b.C0251b;
import org.p004a.p005a.p007b.C0253c;
import org.p004a.p005a.p007b.C0280e;
import org.p004a.p005a.p007b.C0286f;
import org.p004a.p005a.p007b.C0287g;
import org.p004a.p005a.p007b.C0289i;
import org.p004a.p005a.p007b.C0293m;
import org.p004a.p005a.p007b.C0296p;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0258e;
import org.p004a.p005a.p014d.C0304b;
import org.p004a.p005a.p014d.C0331f;
import org.p004a.p005a.p014d.p016b.C0308d;
import org.p004a.p005a.p021e.C0353i;
import org.p004a.p005a.p021e.C0355k;
import org.p004a.p005a.p025g.C0415b;
import org.p004a.p005a.p025g.p026a.C0388ac;
import org.p004a.p005a.p025g.p026a.C0391c;
import org.p004a.p005a.p025g.p026a.C0393e;
import org.p004a.p005a.p025g.p026a.C0401m;
import org.p004a.p005a.p025g.p026a.C0414z;
import org.p004a.p005a.p025g.p028c.C0448g;
import org.p004a.p005a.p025g.p029d.C0459ab;
import org.p004a.p005a.p025g.p029d.C0466ai;
import org.p004a.p005a.p025g.p029d.C0478l;
import org.p004a.p005a.p025g.p029d.C0482p;
import org.p004a.p005a.p025g.p029d.C0487u;
import org.p004a.p005a.p025g.p029d.C0491y;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p036l.C0549a;
import org.p004a.p005a.p036l.C0550b;
import org.p004a.p005a.p036l.C0551c;
import org.p004a.p005a.p036l.C0553e;
import org.p004a.p005a.p036l.C0555g;
import org.p004a.p005a.p036l.C0556h;

/* renamed from: org.a.a.g.b.a */
public abstract class C0416a extends C0423h {

    /* renamed from: a */
    private final Log f338a = LogFactory.getLog(getClass());

    /* renamed from: b */
    private C0544b f339b;

    /* renamed from: c */
    private C0555g f340c;

    /* renamed from: d */
    private C0304b f341d;

    /* renamed from: e */
    private C0247b f342e;

    /* renamed from: f */
    private C0331f f343f;

    /* renamed from: g */
    private C0355k f344g;

    /* renamed from: h */
    private C0225f f345h;

    /* renamed from: i */
    private C0550b f346i;

    /* renamed from: j */
    private C0556h f347j;

    /* renamed from: k */
    private C0289i f348k;

    /* renamed from: l */
    private C0293m f349l;

    /* renamed from: m */
    private C0253c f350m;

    /* renamed from: n */
    private C0253c f351n;

    /* renamed from: o */
    private C0286f f352o;

    /* renamed from: p */
    private C0287g f353p;

    /* renamed from: q */
    private C0308d f354q;

    /* renamed from: r */
    private C0296p f355r;

    protected C0416a(C0304b bVar, C0544b bVar2) {
        this.f339b = bVar2;
        this.f341d = null;
    }

    /* renamed from: a */
    private C0544b m633a(C0568q qVar) {
        return new C0422g((C0544b) null, mo5189c(), qVar.mo5331f(), (C0544b) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: org.a.a.b.b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.p004a.p005a.p014d.C0304b m634e() {
        /*
            r5 = this;
            org.a.a.d.c.f r3 = org.p004a.p005a.p007b.p008a.C0250b.m110c()
            org.a.a.j.b r1 = r5.mo5189c()
            r2 = 0
            java.lang.String r4 = "http.connection-manager.factory-class-name"
            java.lang.Object r1 = r1.mo5196a(r4)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0058
            java.lang.Class r2 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0026, IllegalAccessException -> 0x003c, InstantiationException -> 0x0047 }
            java.lang.Object r2 = r2.newInstance()     // Catch:{ ClassNotFoundException -> 0x0026, IllegalAccessException -> 0x003c, InstantiationException -> 0x0047 }
            r0 = r2
            org.a.a.b.b r0 = (org.p004a.p005a.p007b.C0251b) r0     // Catch:{ ClassNotFoundException -> 0x0026, IllegalAccessException -> 0x003c, InstantiationException -> 0x0047 }
            r1 = r0
        L_0x001f:
            if (r1 == 0) goto L_0x0052
            org.a.a.d.b r1 = r1.mo4883a()
        L_0x0025:
            return r1
        L_0x0026:
            r2 = move-exception
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Invalid class name: "
            r3.<init>(r4)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x003c:
            r1 = move-exception
            java.lang.IllegalAccessError r2 = new java.lang.IllegalAccessError
            java.lang.String r1 = r1.getMessage()
            r2.<init>(r1)
            throw r2
        L_0x0047:
            r1 = move-exception
            java.lang.InstantiationError r2 = new java.lang.InstantiationError
            java.lang.String r1 = r1.getMessage()
            r2.<init>(r1)
            throw r2
        L_0x0052:
            org.a.a.g.c.a r1 = new org.a.a.g.c.a
            r1.<init>(r3)
            goto L_0x0025
        L_0x0058:
            r1 = r2
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p004a.p005a.p025g.p027b.C0416a.m634e():org.a.a.d.b");
    }

    /* renamed from: f */
    private synchronized C0304b m635f() {
        if (this.f341d == null) {
            this.f341d = m634e();
        }
        return this.f341d;
    }

    /* renamed from: g */
    private synchronized C0555g m636g() {
        if (this.f340c == null) {
            this.f340c = new C0555g();
        }
        return this.f340c;
    }

    /* renamed from: h */
    private synchronized C0225f m637h() {
        if (this.f345h == null) {
            C0225f fVar = new C0225f();
            fVar.mo4818a("Basic", (C0223d) new C0391c());
            fVar.mo4818a("Digest", (C0223d) new C0393e());
            fVar.mo4818a("NTLM", (C0223d) new C0414z());
            fVar.mo4818a("negotiate", (C0223d) new C0388ac());
            fVar.mo4818a("Kerberos", (C0223d) new C0401m());
            this.f345h = fVar;
        }
        return this.f345h;
    }

    /* renamed from: i */
    private synchronized C0251b m638i() {
        return null;
    }

    /* renamed from: j */
    private synchronized C0355k m639j() {
        if (this.f344g == null) {
            C0355k kVar = new C0355k();
            kVar.mo5072a("best-match", (C0353i) new C0478l());
            kVar.mo5072a("compatibility", (C0353i) new C0482p());
            kVar.mo5072a("netscape", (C0353i) new C0491y());
            kVar.mo5072a("rfc2109", (C0353i) new C0459ab());
            kVar.mo5072a("rfc2965", (C0353i) new C0466ai());
            kVar.mo5072a("ignoreCookies", (C0353i) new C0487u());
            this.f344g = kVar;
        }
        return this.f344g;
    }

    /* renamed from: k */
    private synchronized C0251b m640k() {
        return null;
    }

    /* renamed from: l */
    private synchronized C0247b m641l() {
        if (this.f342e == null) {
            this.f342e = new C0415b();
        }
        return this.f342e;
    }

    /* renamed from: m */
    private synchronized C0331f m642m() {
        if (this.f343f == null) {
            this.f343f = new C0425j();
        }
        return this.f343f;
    }

    /* renamed from: n */
    private synchronized C0289i m643n() {
        if (this.f348k == null) {
            this.f348k = new C0427l();
        }
        return this.f348k;
    }

    /* renamed from: o */
    private synchronized C0293m m644o() {
        if (this.f349l == null) {
            this.f349l = new C0428m();
        }
        return this.f349l;
    }

    /* renamed from: p */
    private synchronized C0253c m645p() {
        if (this.f350m == null) {
            this.f350m = new C0439x();
        }
        return this.f350m;
    }

    /* renamed from: q */
    private synchronized C0253c m646q() {
        if (this.f351n == null) {
            this.f351n = new C0435t();
        }
        return this.f351n;
    }

    /* renamed from: r */
    private synchronized C0287g m647r() {
        if (this.f353p == null) {
            this.f353p = new C0420e();
        }
        return this.f353p;
    }

    /* renamed from: s */
    private synchronized C0308d m648s() {
        if (this.f354q == null) {
            this.f354q = new C0448g(m635f().mo4959a());
        }
        return this.f354q;
    }

    /* renamed from: t */
    private synchronized C0296p m649t() {
        if (this.f355r == null) {
            this.f355r = new C0430o();
        }
        return this.f355r;
    }

    /* renamed from: u */
    private synchronized C0550b m650u() {
        if (this.f346i == null) {
            this.f346i = mo5188b();
        }
        return this.f346i;
    }

    /* renamed from: v */
    private synchronized C0569r m651v() {
        C0556h hVar;
        synchronized (this) {
            if (this.f347j == null) {
                C0550b u = m650u();
                int a = u.mo5400a();
                C0569r[] rVarArr = new C0569r[a];
                for (int i = 0; i < a; i++) {
                    rVarArr[i] = u.mo5401a(i);
                }
                int b = u.mo5404b();
                C0572u[] uVarArr = new C0572u[b];
                for (int i2 = 0; i2 < b; i2++) {
                    uVarArr[i2] = u.mo5405b(i2);
                }
                this.f347j = new C0556h(rVarArr, uVarArr);
            }
            hVar = this.f347j;
        }
        return hVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C0258e mo5185a(C0565n nVar, C0568q qVar, C0553e eVar) {
        C0553e cVar;
        C0429n nVar2;
        C0308d s;
        C0251b i;
        C0251b k;
        C0250b.m84a((Object) qVar, "HTTP request");
        synchronized (this) {
            C0553e aVar = new C0549a();
            aVar.mo5223a("http.scheme-registry", m635f().mo4959a());
            aVar.mo5223a("http.authscheme-registry", m637h());
            aVar.mo5223a("http.cookiespec-registry", m639j());
            aVar.mo5223a("http.cookie-store", mo5191d());
            aVar.mo5223a("http.auth.credentials-provider", m647r());
            cVar = eVar == null ? aVar : new C0551c(eVar, aVar);
            C0544b a = m633a(qVar);
            cVar.mo5223a("http.request-config", C0250b.m91a(a));
            nVar2 = new C0429n(this.f338a, m636g(), m635f(), m641l(), m642m(), m648s(), m651v(), m643n(), m644o(), m645p(), m646q(), m649t(), a);
            s = m648s();
            i = m638i();
            k = m640k();
        }
        if (i == null || k == null) {
            return C0424i.m679a(nVar2.mo4939a(nVar, qVar, cVar));
        }
        try {
            s.mo4976a(nVar != null ? nVar : (C0565n) m633a(qVar).mo5196a("http.default-host"), qVar);
            return C0424i.m679a(nVar2.mo4939a(nVar, qVar, cVar));
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            if (e2 instanceof C0561m) {
                throw ((C0561m) e2);
            } else if (e2 instanceof IOException) {
                throw ((IOException) e2);
            } else {
                throw new UndeclaredThrowableException(e2);
            }
        } catch (C0561m e3) {
            throw new C0280e((Throwable) e3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C0544b mo5186a();

    /* renamed from: a */
    public final synchronized void mo5187a(C0286f fVar) {
        this.f352o = fVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract C0550b mo5188b();

    /* renamed from: c */
    public final synchronized C0544b mo5189c() {
        if (this.f339b == null) {
            this.f339b = mo5186a();
        }
        return this.f339b;
    }

    public void close() {
        m635f().mo4962b();
    }

    /* renamed from: d */
    public final synchronized C0286f mo5191d() {
        if (this.f352o == null) {
            this.f352o = new C0419d();
        }
        return this.f352o;
    }
}
