package org.p004a.p005a.p025g.p027b;

import java.io.IOException;
import org.apache.commons.logging.Log;
import org.p004a.p005a.C0247b;
import org.p004a.p005a.C0521i;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0548l;
import org.p004a.p005a.C0561m;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.p006a.C0228i;
import org.p004a.p005a.p007b.C0253c;
import org.p004a.p005a.p007b.C0289i;
import org.p004a.p005a.p007b.C0291k;
import org.p004a.p005a.p007b.C0293m;
import org.p004a.p005a.p007b.C0294n;
import org.p004a.p005a.p007b.C0296p;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p014d.C0304b;
import org.p004a.p005a.p014d.C0331f;
import org.p004a.p005a.p014d.C0339m;
import org.p004a.p005a.p014d.p016b.C0305a;
import org.p004a.p005a.p014d.p016b.C0306b;
import org.p004a.p005a.p014d.p016b.C0308d;
import org.p004a.p005a.p022f.C0378c;
import org.p004a.p005a.p033i.C0527f;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p036l.C0553e;
import org.p004a.p005a.p036l.C0555g;

/* renamed from: org.a.a.g.b.n */
public final class C0429n implements C0294n {

    /* renamed from: a */
    private final Log f375a;

    /* renamed from: b */
    private C0304b f376b;

    /* renamed from: c */
    private C0308d f377c;

    /* renamed from: d */
    private C0247b f378d;

    /* renamed from: e */
    private C0331f f379e;

    /* renamed from: f */
    private C0555g f380f;

    /* renamed from: g */
    private C0569r f381g;

    /* renamed from: h */
    private C0289i f382h;

    /* renamed from: i */
    private C0293m f383i;

    /* renamed from: j */
    private C0253c f384j;

    /* renamed from: k */
    private C0253c f385k;

    /* renamed from: l */
    private C0296p f386l;

    /* renamed from: m */
    private C0544b f387m;

    /* renamed from: n */
    private C0339m f388n = null;

    /* renamed from: o */
    private C0228i f389o = new C0228i();

    /* renamed from: p */
    private C0228i f390p = new C0228i();

    /* renamed from: q */
    private final C0433r f391q;

    /* renamed from: r */
    private int f392r = 0;

    /* renamed from: s */
    private int f393s = 0;

    /* renamed from: t */
    private final int f394t = this.f387m.mo5389a("http.protocol.max-redirects", 100);

    /* renamed from: u */
    private C0565n f395u;

    public C0429n(Log log, C0555g gVar, C0304b bVar, C0247b bVar2, C0331f fVar, C0308d dVar, C0569r rVar, C0289i iVar, C0293m mVar, C0253c cVar, C0253c cVar2, C0296p pVar, C0544b bVar3) {
        C0250b.m84a((Object) log, "Log");
        C0250b.m84a((Object) gVar, "Request executor");
        C0250b.m84a((Object) bVar, "Client connection manager");
        C0250b.m84a((Object) bVar2, "Connection reuse strategy");
        C0250b.m84a((Object) fVar, "Connection keep alive strategy");
        C0250b.m84a((Object) dVar, "Route planner");
        C0250b.m84a((Object) rVar, "HTTP protocol processor");
        C0250b.m84a((Object) iVar, "HTTP request retry handler");
        C0250b.m84a((Object) mVar, "Redirect strategy");
        C0250b.m84a((Object) cVar, "Target authentication strategy");
        C0250b.m84a((Object) cVar2, "Proxy authentication strategy");
        C0250b.m84a((Object) pVar, "User token handler");
        C0250b.m84a((Object) bVar3, "HTTP parameters");
        this.f375a = log;
        this.f391q = new C0433r(log);
        this.f380f = gVar;
        this.f376b = bVar;
        this.f378d = bVar2;
        this.f379e = fVar;
        this.f377c = dVar;
        this.f381g = rVar;
        this.f382h = iVar;
        this.f383i = mVar;
        this.f384j = cVar;
        this.f385k = cVar2;
        this.f386l = pVar;
        this.f387m = bVar3;
    }

    /* renamed from: a */
    private static C0437v m689a(C0568q qVar) {
        return qVar instanceof C0548l ? new C0431p((C0548l) qVar) : new C0437v(qVar);
    }

    /* renamed from: a */
    private void m690a() {
        try {
            this.f388n.mo4956h();
        } catch (IOException e) {
            this.f375a.debug("IOException releasing connection", e);
        }
        this.f388n = null;
    }

    /* renamed from: a */
    private void m691a(C0438w wVar, C0553e eVar) {
        int a;
        C0570s a2;
        int i = 0;
        C0306b b = wVar.mo5216b();
        C0437v a3 = wVar.mo5215a();
        while (true) {
            eVar.mo5223a("http.request", a3);
            int i2 = i + 1;
            try {
                if (this.f388n.mo5246c()) {
                    this.f388n.mo5245b(C0250b.m108c(this.f387m));
                    break;
                } else {
                    this.f388n.mo5028a(b, eVar, this.f387m);
                    break;
                }
            } catch (IOException e) {
                try {
                    this.f388n.close();
                } catch (IOException e2) {
                }
                if (!this.f382h.mo4936a(e, i2, eVar)) {
                    throw e;
                } else if (this.f375a.isInfoEnabled()) {
                    this.f375a.info("I/O exception (" + e.getClass().getName() + ") caught when connecting to the target host: " + e.getMessage());
                    if (this.f375a.isDebugEnabled()) {
                        this.f375a.debug(e.getMessage(), e);
                    }
                    this.f375a.info("Retrying connect");
                    i = i2;
                } else {
                    i = i2;
                }
            }
        }
        C0305a aVar = new C0305a();
        do {
            C0306b j = this.f388n.mo5025j();
            a = aVar.mo4963a(b, j);
            switch (a) {
                case -1:
                    throw new C0561m("Unable to establish route: planned = " + b + "; current = " + j);
                case 0:
                    break;
                case 1:
                case 2:
                    this.f388n.mo5028a(b, eVar, this.f387m);
                    continue;
                case 3:
                    C0565n d = b.mo4969d();
                    C0565n a4 = b.mo4964a();
                    while (true) {
                        if (!this.f388n.mo5246c()) {
                            this.f388n.mo5028a(b, eVar, this.f387m);
                        }
                        C0565n a5 = b.mo4964a();
                        String a6 = a5.mo5441a();
                        int b2 = a5.mo5442b();
                        if (b2 < 0) {
                            b2 = this.f376b.mo4959a().mo5004a(a5.mo5443c()).mo4995a();
                        }
                        StringBuilder sb = new StringBuilder(a6.length() + 6);
                        sb.append(a6);
                        sb.append(':');
                        sb.append(Integer.toString(b2));
                        C0527f fVar = new C0527f("CONNECT", sb.toString(), C0250b.m113f(this.f387m));
                        fVar.mo5321a(this.f387m);
                        eVar.mo5223a("http.target_host", a4);
                        eVar.mo5223a("http.proxy_host", d);
                        eVar.mo5223a("http.connection", this.f388n);
                        eVar.mo5223a("http.request", fVar);
                        C0555g.m1160a((C0568q) fVar, this.f381g, eVar);
                        a2 = this.f380f.mo5411a((C0568q) fVar, (C0521i) this.f388n, eVar);
                        a2.mo5321a(this.f387m);
                        C0555g.m1161a(a2, this.f381g, eVar);
                        if (a2.mo5345a().mo4867b() < 200) {
                            throw new C0561m("Unexpected response to CONNECT request: " + a2.mo5345a());
                        } else if (C0250b.m106b(this.f387m)) {
                            if (this.f391q.mo5148a(d, a2, this.f385k, this.f390p, eVar) && this.f391q.mo5201c(d, a2, this.f385k, this.f390p, eVar)) {
                                if (this.f378d.mo4871a(a2, eVar)) {
                                    this.f375a.debug("Connection kept alive");
                                    C0250b.m94a(a2.mo5347b());
                                } else {
                                    this.f388n.close();
                                }
                            }
                        }
                    }
                    if (a2.mo5345a().mo4867b() > 299) {
                        C0546k b3 = a2.mo5347b();
                        if (b3 != null) {
                            a2.mo5346a(new C0378c(b3));
                        }
                        this.f388n.close();
                        throw new C0440y("CONNECT refused by proxy: " + a2.mo5345a(), a2);
                    }
                    this.f388n.mo5031k();
                    this.f375a.debug("Tunnel to target created.");
                    this.f388n.mo5030a(false, this.f387m);
                    continue;
                case 4:
                    int c = j.mo4967c() - 1;
                    throw new C0561m("Proxy chains are not supported.");
                case 5:
                    this.f388n.mo5029a(eVar, this.f387m);
                    continue;
                default:
                    throw new IllegalStateException("Unknown step indicator " + a + " from RouteDirector.");
            }
        } while (a > 0);
    }

    /* renamed from: b */
    private C0306b m692b(C0565n nVar, C0568q qVar, C0553e eVar) {
        C0308d dVar = this.f377c;
        if (nVar == null) {
            nVar = (C0565n) qVar.mo5331f().mo5196a("http.default-host");
        }
        return dVar.mo4976a(nVar, qVar);
    }

    /* renamed from: b */
    private C0570s m693b(C0438w wVar, C0553e eVar) {
        C0437v a = wVar.mo5215a();
        C0306b b = wVar.mo5216b();
        IOException e = null;
        while (true) {
            this.f392r++;
            a.mo5214n();
            if (!a.mo5200j()) {
                this.f375a.debug("Cannot retry non-repeatable request");
                if (e != null) {
                    throw new C0291k("Cannot retry request with a non-repeatable request entity.  The cause lists the reason the original request failed.", e);
                }
                throw new C0291k("Cannot retry request with a non-repeatable request entity.");
            }
            try {
                if (!this.f388n.mo5246c()) {
                    if (!b.mo4970e()) {
                        this.f375a.debug("Reopening the direct connection.");
                        this.f388n.mo5028a(b, eVar, this.f387m);
                    } else {
                        this.f375a.debug("Proxied connection. Need to start over.");
                        return null;
                    }
                }
                if (this.f375a.isDebugEnabled()) {
                    this.f375a.debug("Attempt " + this.f392r + " to execute request");
                }
                return this.f380f.mo5411a((C0568q) a, (C0521i) this.f388n, eVar);
            } catch (IOException e2) {
                e = e2;
                this.f375a.debug("Closing the connection.");
                try {
                    this.f388n.close();
                } catch (IOException e3) {
                }
                if (this.f382h.mo4936a(e, a.mo5213m(), eVar)) {
                    if (this.f375a.isInfoEnabled()) {
                        this.f375a.info("I/O exception (" + e.getClass().getName() + ") caught when processing request: " + e.getMessage());
                    }
                    if (this.f375a.isDebugEnabled()) {
                        this.f375a.debug(e.getMessage(), e);
                    }
                    this.f375a.info("Retrying request");
                } else {
                    throw e;
                }
            }
        }
    }

    /* renamed from: b */
    private void m694b() {
        C0339m mVar = this.f388n;
        if (mVar != null) {
            this.f388n = null;
            try {
                mVar.mo4957i();
            } catch (IOException e) {
                if (this.f375a.isDebugEnabled()) {
                    this.f375a.debug(e.getMessage(), e);
                }
            }
            try {
                mVar.mo4956h();
            } catch (IOException e2) {
                this.f375a.debug("Error releasing connection", e2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0410 A[Catch:{ URISyntaxException -> 0x02d3, InterruptedException -> 0x025c, c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x022a A[Catch:{ URISyntaxException -> 0x02d3, InterruptedException -> 0x025c, c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0231 A[Catch:{ URISyntaxException -> 0x02d3, InterruptedException -> 0x025c, c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.p004a.p005a.C0570s mo4939a(org.p004a.p005a.C0565n r16, org.p004a.p005a.C0568q r17, org.p004a.p005a.p036l.C0553e r18) {
        /*
            r15 = this;
            java.lang.String r2 = "http.auth.target-scope"
            org.a.a.a.i r3 = r15.f389o
            r0 = r18
            r0.mo5223a(r2, r3)
            java.lang.String r2 = "http.auth.proxy-scope"
            org.a.a.a.i r3 = r15.f390p
            r0 = r18
            r0.mo5223a(r2, r3)
            org.a.a.g.b.v r3 = m689a(r17)
            org.a.a.j.b r2 = r15.f387m
            r3.mo5321a((org.p004a.p005a.p034j.C0544b) r2)
            r0 = r16
            r1 = r18
            org.a.a.d.b.b r4 = r15.m692b(r0, r3, r1)
            org.a.a.j.b r2 = r3.mo5331f()
            java.lang.String r5 = "http.virtual-host"
            java.lang.Object r2 = r2.mo5196a(r5)
            org.a.a.n r2 = (org.p004a.p005a.C0565n) r2
            r15.f395u = r2
            org.a.a.n r2 = r15.f395u
            if (r2 == 0) goto L_0x005c
            org.a.a.n r2 = r15.f395u
            int r2 = r2.mo5442b()
            r5 = -1
            if (r2 != r5) goto L_0x005c
            if (r16 == 0) goto L_0x024f
            r2 = r16
        L_0x0042:
            int r2 = r2.mo5442b()
            r5 = -1
            if (r2 == r5) goto L_0x005c
            org.a.a.n r5 = new org.a.a.n
            org.a.a.n r6 = r15.f395u
            java.lang.String r6 = r6.mo5441a()
            org.a.a.n r7 = r15.f395u
            java.lang.String r7 = r7.mo5443c()
            r5.<init>(r6, r2, r7)
            r15.f395u = r5
        L_0x005c:
            org.a.a.g.b.w r9 = new org.a.a.g.b.w
            r9.<init>(r3, r4)
            r2 = 0
            r10 = 0
            r4 = 0
            r3 = r2
            r2 = r4
        L_0x0066:
            if (r10 != 0) goto L_0x028c
            org.a.a.g.b.v r4 = r9.mo5215a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.d.b.b r5 = r9.mo5216b()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r2 = "http.user-token"
            r0 = r18
            java.lang.Object r8 = r0.mo5221a(r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.d.m r2 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 != 0) goto L_0x00df
            org.a.a.d.b r2 = r15.f376b     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.d.d r6 = r2.mo4960a(r5, r8)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r0 = r17
            boolean r2 = r0 instanceof org.p004a.p005a.p007b.p010c.C0254a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x0090
            r0 = r17
            org.a.a.b.c.a r0 = (org.p004a.p005a.p007b.p010c.C0254a) r0     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2 = r0
            r2.mo4889a((org.p004a.p005a.p014d.C0321d) r6)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x0090:
            org.a.a.j.b r7 = r15.f387m     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r2 = "HTTP parameters"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r7, (java.lang.String) r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r2 = "http.conn-manager.timeout"
            java.lang.Object r2 = r7.mo5196a(r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x0255
            r2.longValue()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x00a4:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x025c }
            org.a.a.d.m r2 = r6.mo5007a()     // Catch:{ InterruptedException -> 0x025c }
            r15.f388n = r2     // Catch:{ InterruptedException -> 0x025c }
            org.a.a.j.b r2 = r15.f387m     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r6 = "HTTP parameters"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r2, (java.lang.String) r6)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r6 = "http.connection.stalecheck"
            r7 = 1
            boolean r2 = r2.mo5390a((java.lang.String) r6, (boolean) r7)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x00df
            org.a.a.d.m r2 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            boolean r2 = r2.mo5246c()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x00df
            org.apache.commons.logging.Log r2 = r15.f375a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r6 = "Stale connection check"
            r2.debug(r6)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.d.m r2 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            boolean r2 = r2.mo5137d()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x00df
            org.apache.commons.logging.Log r2 = r15.f375a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r6 = "Stale connection detected"
            r2.debug(r6)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.d.m r2 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2.close()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x00df:
            r0 = r17
            boolean r2 = r0 instanceof org.p004a.p005a.p007b.p010c.C0254a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x00ef
            r0 = r17
            org.a.a.b.c.a r0 = (org.p004a.p005a.p007b.p010c.C0254a) r0     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2 = r0
            org.a.a.d.m r6 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2.mo4890a((org.p004a.p005a.p014d.C0333g) r6)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x00ef:
            r0 = r18
            r15.m691a(r9, r0)     // Catch:{ y -> 0x0276 }
            java.net.URI r2 = r4.mo4903i()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r2 = r2.getUserInfo()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x010d
            org.a.a.a.i r6 = r15.f389o     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.g.a.b r7 = new org.a.a.g.a.b     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r7.<init>()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.s r11 = new org.a.a.a.s     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r11.<init>(r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r6.mo4826a(r7, r11)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x010d:
            org.a.a.n r2 = r15.f395u     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x02a9
            org.a.a.n r0 = r15.f395u     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r16 = r0
        L_0x0115:
            if (r16 != 0) goto L_0x011b
            org.a.a.n r16 = r5.mo4964a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x011b:
            r4.mo5211k()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.net.URI r2 = r4.mo4903i()     // Catch:{ URISyntaxException -> 0x02d3 }
            org.a.a.n r6 = r5.mo4969d()     // Catch:{ URISyntaxException -> 0x02d3 }
            if (r6 == 0) goto L_0x02bf
            boolean r6 = r5.mo4970e()     // Catch:{ URISyntaxException -> 0x02d3 }
            if (r6 != 0) goto L_0x02bf
            boolean r6 = r2.isAbsolute()     // Catch:{ URISyntaxException -> 0x02d3 }
            if (r6 != 0) goto L_0x02b9
            org.a.a.n r6 = r5.mo4964a()     // Catch:{ URISyntaxException -> 0x02d3 }
            r7 = 1
            java.net.URI r2 = org.p004a.p005a.p007b.p008a.C0250b.m89a((java.net.URI) r2, (org.p004a.p005a.C0565n) r6, (boolean) r7)     // Catch:{ URISyntaxException -> 0x02d3 }
        L_0x013d:
            r4.mo5210a(r2)     // Catch:{ URISyntaxException -> 0x02d3 }
            java.lang.String r2 = "http.target_host"
            r0 = r18
            r1 = r16
            r0.mo5223a(r2, r1)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r2 = "http.route"
            r0 = r18
            r0.mo5223a(r2, r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r2 = "http.connection"
            org.a.a.d.m r5 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r0 = r18
            r0.mo5223a(r2, r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.r r2 = r15.f381g     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r0 = r18
            org.p004a.p005a.p036l.C0555g.m1160a((org.p004a.p005a.C0568q) r4, (org.p004a.p005a.C0569r) r2, (org.p004a.p005a.p036l.C0553e) r0)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r0 = r18
            org.a.a.s r4 = r15.m693b(r9, r0)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r4 == 0) goto L_0x04ab
            org.a.a.j.b r2 = r15.f387m     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r4.mo5321a((org.p004a.p005a.p034j.C0544b) r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.r r2 = r15.f381g     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r0 = r18
            org.p004a.p005a.p036l.C0555g.m1161a((org.p004a.p005a.C0570s) r4, (org.p004a.p005a.C0569r) r2, (org.p004a.p005a.p036l.C0553e) r0)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.b r2 = r15.f378d     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r0 = r18
            boolean r11 = r2.mo4871a(r4, r0)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r11 == 0) goto L_0x01c8
            org.a.a.d.f r2 = r15.f379e     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            long r6 = r2.mo5016a(r4)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.apache.commons.logging.Log r2 = r15.f375a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            boolean r2 = r2.isDebugEnabled()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x01c1
            r2 = 0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x02f6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r3 = "for "
            r2.<init>(r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r3 = " "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r2 = r2.toString()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x01ad:
            org.apache.commons.logging.Log r3 = r15.f375a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r12 = "Connection can be kept alive "
            r5.<init>(r12)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r2 = r2.toString()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r3.debug(r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x01c1:
            org.a.a.d.m r2 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2.mo5026a((long) r6, (java.util.concurrent.TimeUnit) r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x01c8:
            org.a.a.d.b.b r12 = r9.mo5216b()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.g.b.v r13 = r9.mo5215a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.j.b r14 = r13.mo5331f()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            boolean r2 = org.p004a.p005a.p007b.p008a.C0250b.m106b((org.p004a.p005a.p034j.C0544b) r14)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x0323
            java.lang.String r2 = "http.target_host"
            r0 = r18
            java.lang.Object r2 = r0.mo5221a(r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.n r2 = (org.p004a.p005a.C0565n) r2     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 != 0) goto L_0x01ea
            org.a.a.n r2 = r12.mo4964a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x01ea:
            int r3 = r2.mo5442b()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r3 >= 0) goto L_0x04a8
            org.a.a.d.b r3 = r15.f376b     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.d.c.f r3 = r3.mo4959a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.d.c.c r5 = r3.mo5006a((org.p004a.p005a.C0565n) r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.n r3 = new org.a.a.n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r6 = r2.mo5441a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            int r5 = r5.mo4995a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r2 = r2.mo5443c()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r3.<init>(r6, r5, r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x020b:
            org.a.a.g.b.r r2 = r15.f391q     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.b.c r5 = r15.f384j     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.i r6 = r15.f389o     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r7 = r18
            boolean r2 = r2.mo5148a(r3, r4, r5, r6, r7)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x02fa
            org.a.a.g.b.r r2 = r15.f391q     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.b.c r5 = r15.f384j     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.i r6 = r15.f389o     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r7 = r18
            boolean r2 = r2.mo5201c(r3, r4, r5, r6, r7)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x02fa
            r2 = r9
        L_0x0228:
            if (r2 != 0) goto L_0x0410
            r2 = 1
            r3 = r9
            r5 = r2
        L_0x022d:
            org.a.a.d.m r2 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x0249
            if (r8 != 0) goto L_0x04a5
            org.a.a.b.p r2 = r15.f386l     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r0 = r18
            java.lang.Object r2 = r2.mo4941a(r0)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r6 = "http.user-token"
            r0 = r18
            r0.mo5223a(r6, r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x0242:
            if (r2 == 0) goto L_0x0249
            org.a.a.d.m r6 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r6.mo5027a(r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x0249:
            r9 = r3
            r2 = r4
            r10 = r5
            r3 = r11
            goto L_0x0066
        L_0x024f:
            org.a.a.n r2 = r4.mo4964a()
            goto L_0x0042
        L_0x0255:
            int r2 = org.p004a.p005a.p007b.p008a.C0250b.m111d(r7)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            long r12 = (long) r2     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            goto L_0x00a4
        L_0x025c:
            r2 = move-exception
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2.interrupt()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.io.InterruptedIOException r2 = new java.io.InterruptedIOException     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2.<init>()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            throw r2     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x026a:
            r2 = move-exception
            java.io.InterruptedIOException r3 = new java.io.InterruptedIOException
            java.lang.String r4 = "Connection has been shut down"
            r3.<init>(r4)
            r3.initCause(r2)
            throw r3
        L_0x0276:
            r2 = move-exception
            org.apache.commons.logging.Log r4 = r15.f375a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            boolean r4 = r4.isDebugEnabled()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r4 == 0) goto L_0x0288
            org.apache.commons.logging.Log r4 = r15.f375a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r5 = r2.getMessage()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r4.debug(r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x0288:
            org.a.a.s r2 = r2.mo5217a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x028c:
            if (r2 == 0) goto L_0x029e
            org.a.a.k r4 = r2.mo5347b()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r4 == 0) goto L_0x029e
            org.a.a.k r4 = r2.mo5347b()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            boolean r4 = r4.mo5117g()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r4 != 0) goto L_0x0495
        L_0x029e:
            if (r3 == 0) goto L_0x02a5
            org.a.a.d.m r3 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r3.mo5031k()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x02a5:
            r15.m690a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x02a8:
            return r2
        L_0x02a9:
            java.net.URI r2 = r4.mo4903i()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            boolean r6 = r2.isAbsolute()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r6 == 0) goto L_0x0115
            org.a.a.n r16 = org.p004a.p005a.p007b.p008a.C0250b.m103b((java.net.URI) r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            goto L_0x0115
        L_0x02b9:
            java.net.URI r2 = org.p004a.p005a.p007b.p008a.C0250b.m87a((java.net.URI) r2)     // Catch:{ URISyntaxException -> 0x02d3 }
            goto L_0x013d
        L_0x02bf:
            boolean r6 = r2.isAbsolute()     // Catch:{ URISyntaxException -> 0x02d3 }
            if (r6 == 0) goto L_0x02cd
            r6 = 0
            r7 = 1
            java.net.URI r2 = org.p004a.p005a.p007b.p008a.C0250b.m89a((java.net.URI) r2, (org.p004a.p005a.C0565n) r6, (boolean) r7)     // Catch:{ URISyntaxException -> 0x02d3 }
            goto L_0x013d
        L_0x02cd:
            java.net.URI r2 = org.p004a.p005a.p007b.p008a.C0250b.m87a((java.net.URI) r2)     // Catch:{ URISyntaxException -> 0x02d3 }
            goto L_0x013d
        L_0x02d3:
            r2 = move-exception
            org.a.a.ab r3 = new org.a.a.ab     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r6 = "Invalid URI: "
            r5.<init>(r6)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.ae r4 = r4.mo4902g()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r4 = r4.mo4865c()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r4 = r4.toString()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r3.<init>(r4, r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            throw r3     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x02f1:
            r2 = move-exception
            r15.m694b()
            throw r2
        L_0x02f6:
            java.lang.String r2 = "indefinitely"
            goto L_0x01ad
        L_0x02fa:
            org.a.a.n r3 = r12.mo4969d()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.g.b.r r2 = r15.f391q     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.b.c r5 = r15.f385k     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.i r6 = r15.f390p     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r7 = r18
            boolean r2 = r2.mo5148a(r3, r4, r5, r6, r7)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x0323
            if (r3 != 0) goto L_0x0312
            org.a.a.n r3 = r12.mo4964a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x0312:
            org.a.a.g.b.r r2 = r15.f391q     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.b.c r5 = r15.f385k     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.i r6 = r15.f390p     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r7 = r18
            boolean r2 = r2.mo5201c(r3, r4, r5, r6, r7)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x0323
            r2 = r9
            goto L_0x0228
        L_0x0323:
            java.lang.String r2 = "HTTP parameters"
            org.p004a.p005a.p007b.p008a.C0250b.m84a((java.lang.Object) r14, (java.lang.String) r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r2 = "http.protocol.handle-redirects"
            r3 = 1
            boolean r2 = r14.mo5390a((java.lang.String) r2, (boolean) r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x040d
            org.a.a.b.m r2 = r15.f383i     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r0 = r18
            boolean r2 = r2.mo4937a(r13, r4, r0)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 == 0) goto L_0x040d
            int r2 = r15.f393s     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            int r3 = r15.f394t     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r2 < r3) goto L_0x0363
            org.a.a.b.l r2 = new org.a.a.b.l     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r4 = "Maximum redirects ("
            r3.<init>(r4)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            int r4 = r15.f394t     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r4 = ") exceeded"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r3 = r3.toString()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2.<init>(r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            throw r2     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x035e:
            r2 = move-exception
            r15.m694b()
            throw r2
        L_0x0363:
            int r2 = r15.f393s     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            int r2 = r2 + 1
            r15.f393s = r2     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2 = 0
            r15.f395u = r2     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.b.m r2 = r15.f383i     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r0 = r18
            org.a.a.b.c.l r2 = r2.mo4938b(r13, r4, r0)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.q r3 = r13.mo5212l()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.e[] r3 = r3.mo5328d()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2.mo5322a((org.p004a.p005a.C0344e[]) r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.net.URI r3 = r2.mo4903i()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.n r5 = org.p004a.p005a.p007b.p008a.C0250b.m103b((java.net.URI) r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r5 != 0) goto L_0x03a3
            org.a.a.ab r2 = new org.a.a.ab     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r5 = "Redirect URI does not specify a valid host name: "
            r4.<init>(r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r3 = r3.toString()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2.<init>(r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            throw r2     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x039e:
            r2 = move-exception
            r15.m694b()
            throw r2
        L_0x03a3:
            org.a.a.n r6 = r12.mo4964a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            boolean r6 = r6.equals(r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r6 != 0) goto L_0x03d3
            org.apache.commons.logging.Log r6 = r15.f375a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r7 = "Resetting target auth state"
            r6.debug(r7)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.i r6 = r15.f389o     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r6.mo4823a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.i r6 = r15.f390p     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.c r6 = r6.mo4828c()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r6 == 0) goto L_0x03d3
            boolean r6 = r6.mo4812c()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r6 == 0) goto L_0x03d3
            org.apache.commons.logging.Log r6 = r15.f375a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r7 = "Resetting proxy auth state"
            r6.debug(r7)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.i r6 = r15.f390p     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r6.mo4823a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x03d3:
            org.a.a.g.b.v r6 = m689a(r2)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r6.mo5321a((org.p004a.p005a.p034j.C0544b) r14)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r0 = r18
            org.a.a.d.b.b r5 = r15.m692b(r5, r6, r0)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.g.b.w r2 = new org.a.a.g.b.w     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2.<init>(r6, r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.apache.commons.logging.Log r6 = r15.f375a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            boolean r6 = r6.isDebugEnabled()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r6 == 0) goto L_0x0228
            org.apache.commons.logging.Log r6 = r15.f375a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r12 = "Redirecting to '"
            r7.<init>(r12)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r3 = r7.append(r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r7 = "' via "
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r3 = r3.toString()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r6.debug(r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            goto L_0x0228
        L_0x040d:
            r2 = 0
            goto L_0x0228
        L_0x0410:
            if (r11 == 0) goto L_0x0433
            org.a.a.k r3 = r4.mo5347b()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.p004a.p005a.p007b.p008a.C0250b.m94a((org.p004a.p005a.C0546k) r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.d.m r3 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r3.mo5031k()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x041e:
            org.a.a.d.b.b r3 = r2.mo5216b()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.d.b.b r5 = r9.mo5216b()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            boolean r3 = r3.equals(r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r3 != 0) goto L_0x042f
            r15.m690a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x042f:
            r3 = r2
            r5 = r10
            goto L_0x022d
        L_0x0433:
            org.a.a.d.m r3 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r3.close()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.i r3 = r15.f390p     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.b r3 = r3.mo4827b()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.b r5 = org.p004a.p005a.p006a.C0221b.CHALLENGED     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            int r3 = r3.compareTo(r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r3 <= 0) goto L_0x0466
            org.a.a.a.i r3 = r15.f390p     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.c r3 = r3.mo4828c()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r3 == 0) goto L_0x0466
            org.a.a.a.i r3 = r15.f390p     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.c r3 = r3.mo4828c()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            boolean r3 = r3.mo4812c()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r3 == 0) goto L_0x0466
            org.apache.commons.logging.Log r3 = r15.f375a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r5 = "Resetting proxy auth state"
            r3.debug(r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.i r3 = r15.f390p     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r3.mo4823a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
        L_0x0466:
            org.a.a.a.i r3 = r15.f389o     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.b r3 = r3.mo4827b()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.b r5 = org.p004a.p005a.p006a.C0221b.CHALLENGED     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            int r3 = r3.compareTo(r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r3 <= 0) goto L_0x041e
            org.a.a.a.i r3 = r15.f389o     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.c r3 = r3.mo4828c()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r3 == 0) goto L_0x041e
            org.a.a.a.i r3 = r15.f389o     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.c r3 = r3.mo4828c()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            boolean r3 = r3.mo4812c()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            if (r3 == 0) goto L_0x041e
            org.apache.commons.logging.Log r3 = r15.f375a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            java.lang.String r5 = "Resetting target auth state"
            r3.debug(r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.a.i r3 = r15.f389o     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r3.mo4823a()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            goto L_0x041e
        L_0x0495:
            org.a.a.k r4 = r2.mo5347b()     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.d.a r5 = new org.a.a.d.a     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            org.a.a.d.m r6 = r15.f388n     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r5.<init>(r4, r6, r3)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            r2.mo5346a(r5)     // Catch:{ c -> 0x026a, m -> 0x02f1, IOException -> 0x035e, RuntimeException -> 0x039e }
            goto L_0x02a8
        L_0x04a5:
            r2 = r8
            goto L_0x0242
        L_0x04a8:
            r3 = r2
            goto L_0x020b
        L_0x04ab:
            r2 = r4
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p004a.p005a.p025g.p027b.C0429n.mo4939a(org.a.a.n, org.a.a.q, org.a.a.l.e):org.a.a.s");
    }
}
