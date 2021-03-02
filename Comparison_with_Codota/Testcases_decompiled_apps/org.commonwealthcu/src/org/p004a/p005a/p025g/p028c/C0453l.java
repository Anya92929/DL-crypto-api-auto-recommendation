package org.p004a.p005a.p025g.p028c;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.p004a.p005a.C0548l;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0266m;
import org.p004a.p005a.p014d.C0304b;
import org.p004a.p005a.p014d.C0313c;
import org.p004a.p005a.p014d.C0339m;
import org.p004a.p005a.p014d.C0341o;
import org.p004a.p005a.p014d.p016b.C0306b;
import org.p004a.p005a.p014d.p016b.C0312h;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.c.l */
final class C0453l implements C0339m {

    /* renamed from: a */
    private final C0304b f445a;

    /* renamed from: b */
    private final C0313c f446b;

    /* renamed from: c */
    private volatile C0450i f447c;

    /* renamed from: d */
    private volatile boolean f448d = false;

    /* renamed from: e */
    private volatile long f449e = Long.MAX_VALUE;

    C0453l(C0304b bVar, C0313c cVar, C0450i iVar) {
        C0250b.m84a((Object) bVar, "Connection manager");
        C0250b.m84a((Object) cVar, "Connection operator");
        C0250b.m84a((Object) iVar, "HTTP pool entry");
        this.f445a = bVar;
        this.f446b = cVar;
        this.f447c = iVar;
    }

    /* renamed from: r */
    private C0341o m780r() {
        C0450i iVar = this.f447c;
        if (iVar == null) {
            return null;
        }
        return (C0341o) iVar.mo5396f();
    }

    /* renamed from: s */
    private C0341o m781s() {
        C0450i iVar = this.f447c;
        if (iVar != null) {
            return (C0341o) iVar.mo5396f();
        }
        throw new C0444c();
    }

    /* renamed from: t */
    private C0450i m782t() {
        C0450i iVar = this.f447c;
        if (iVar != null) {
            return iVar;
        }
        throw new C0444c();
    }

    /* renamed from: a */
    public final C0570s mo5130a() {
        return m781s().mo5130a();
    }

    /* renamed from: a */
    public final void mo5026a(long j, TimeUnit timeUnit) {
        if (j > 0) {
            this.f449e = timeUnit.toMillis(j);
        } else {
            this.f449e = -1;
        }
    }

    /* renamed from: a */
    public final void mo5027a(Object obj) {
        m782t().mo5394a(obj);
    }

    /* renamed from: a */
    public final void mo5028a(C0306b bVar, C0553e eVar, C0544b bVar2) {
        C0341o oVar;
        C0250b.m84a((Object) bVar, "Route");
        C0250b.m84a((Object) bVar2, "HTTP parameters");
        synchronized (this) {
            if (this.f447c == null) {
                throw new C0444c();
            }
            C0312h a = this.f447c.mo5228a();
            C0266m.m145a((Object) a, "Route tracker");
            C0266m.m146a(!a.mo4985i(), "Connection already open");
            oVar = (C0341o) this.f447c.mo5396f();
        }
        C0565n d = bVar.mo4969d();
        this.f446b.mo4989a(oVar, d != null ? d : bVar.mo4964a(), bVar.mo4966b(), eVar, bVar2);
        synchronized (this) {
            if (this.f447c == null) {
                throw new InterruptedIOException();
            }
            C0312h a2 = this.f447c.mo5228a();
            if (d == null) {
                a2.mo4978a(oVar.mo5037h());
            } else {
                a2.mo4977a(d, oVar.mo5037h());
            }
        }
    }

    /* renamed from: a */
    public final void mo5029a(C0553e eVar, C0544b bVar) {
        C0565n a;
        C0341o oVar;
        C0250b.m84a((Object) bVar, "HTTP parameters");
        synchronized (this) {
            if (this.f447c == null) {
                throw new C0444c();
            }
            C0312h a2 = this.f447c.mo5228a();
            C0266m.m145a((Object) a2, "Route tracker");
            C0266m.m146a(a2.mo4985i(), "Connection not open");
            C0266m.m146a(a2.mo4970e(), "Protocol layering without a tunnel not supported");
            C0266m.m146a(!a2.mo4972f(), "Multiple protocol layering not supported");
            a = a2.mo4964a();
            oVar = (C0341o) this.f447c.mo5396f();
        }
        this.f446b.mo4990a(oVar, a, eVar, bVar);
        synchronized (this) {
            if (this.f447c == null) {
                throw new InterruptedIOException();
            }
            this.f447c.mo5228a().mo4980c(oVar.mo5037h());
        }
    }

    /* renamed from: a */
    public final void mo5132a(C0548l lVar) {
        m781s().mo5132a(lVar);
    }

    /* renamed from: a */
    public final void mo5133a(C0568q qVar) {
        m781s().mo5133a(qVar);
    }

    /* renamed from: a */
    public final void mo5134a(C0570s sVar) {
        m781s().mo5134a(sVar);
    }

    /* renamed from: a */
    public final void mo5030a(boolean z, C0544b bVar) {
        C0565n a;
        C0341o oVar;
        C0250b.m84a((Object) bVar, "HTTP parameters");
        synchronized (this) {
            if (this.f447c == null) {
                throw new C0444c();
            }
            C0312h a2 = this.f447c.mo5228a();
            C0266m.m145a((Object) a2, "Route tracker");
            C0266m.m146a(a2.mo4985i(), "Connection not open");
            C0266m.m146a(!a2.mo4970e(), "Connection is already tunnelled");
            a = a2.mo4964a();
            oVar = (C0341o) this.f447c.mo5396f();
        }
        oVar.mo5035a((Socket) null, a, z, bVar);
        synchronized (this) {
            if (this.f447c == null) {
                throw new InterruptedIOException();
            }
            this.f447c.mo5228a().mo4979b(z);
        }
    }

    /* renamed from: a */
    public final boolean mo5135a(int i) {
        return m781s().mo5135a(i);
    }

    /* renamed from: b */
    public final void mo5136b() {
        m781s().mo5136b();
    }

    /* renamed from: b */
    public final void mo5245b(int i) {
        m781s().mo5245b(i);
    }

    /* renamed from: c */
    public final boolean mo5246c() {
        C0341o r = m780r();
        if (r != null) {
            return r.mo5246c();
        }
        return false;
    }

    public final void close() {
        C0450i iVar = this.f447c;
        if (iVar != null) {
            iVar.mo5228a().mo4983h();
            ((C0341o) iVar.mo5396f()).close();
        }
    }

    /* renamed from: d */
    public final boolean mo5137d() {
        C0341o r = m780r();
        if (r != null) {
            return r.mo5137d();
        }
        return true;
    }

    /* renamed from: e */
    public final void mo5226e() {
        C0450i iVar = this.f447c;
        if (iVar != null) {
            iVar.mo5228a().mo4983h();
            ((C0341o) iVar.mo5396f()).mo5226e();
        }
    }

    /* renamed from: f */
    public final InetAddress mo5247f() {
        return m781s().mo5247f();
    }

    /* renamed from: g */
    public final int mo5248g() {
        return m781s().mo5248g();
    }

    /* renamed from: h */
    public final void mo4956h() {
        synchronized (this) {
            if (this.f447c != null) {
                this.f445a.mo4961a(this, this.f449e, TimeUnit.MILLISECONDS);
                this.f447c = null;
            }
        }
    }

    /* renamed from: i */
    public final void mo4957i() {
        synchronized (this) {
            if (this.f447c != null) {
                this.f448d = false;
                try {
                    ((C0341o) this.f447c.mo5396f()).mo5226e();
                } catch (IOException e) {
                }
                this.f445a.mo4961a(this, this.f449e, TimeUnit.MILLISECONDS);
                this.f447c = null;
            }
        }
    }

    /* renamed from: j */
    public final C0306b mo5025j() {
        return m782t().mo5230b();
    }

    /* renamed from: k */
    public final void mo5031k() {
        this.f448d = true;
    }

    /* renamed from: l */
    public final void mo5032l() {
        this.f448d = false;
    }

    /* renamed from: m */
    public final SSLSession mo5033m() {
        Socket i = m781s().mo5038i();
        if (i instanceof SSLSocket) {
            return ((SSLSocket) i).getSession();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final C0450i mo5249n() {
        return this.f447c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final C0450i mo5250o() {
        C0450i iVar = this.f447c;
        this.f447c = null;
        return iVar;
    }

    /* renamed from: p */
    public final C0304b mo5251p() {
        return this.f445a;
    }

    /* renamed from: q */
    public final boolean mo5252q() {
        return this.f448d;
    }
}
