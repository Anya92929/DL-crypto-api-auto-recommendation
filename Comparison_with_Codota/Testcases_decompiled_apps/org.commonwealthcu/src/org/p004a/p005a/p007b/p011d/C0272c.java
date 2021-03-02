package org.p004a.p005a.p007b.p011d;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.p006a.C0221b;
import org.p004a.p005a.p006a.C0222c;
import org.p004a.p005a.p006a.C0227h;
import org.p004a.p005a.p006a.C0228i;
import org.p004a.p005a.p006a.C0233n;
import org.p004a.p005a.p007b.C0248a;
import org.p004a.p005a.p007b.C0287g;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p014d.p016b.C0309e;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.b.d.c */
public final class C0272c implements C0569r {

    /* renamed from: a */
    private final Log f98a = LogFactory.getLog(getClass());

    /* renamed from: a */
    private void m163a(C0565n nVar, C0222c cVar, C0228i iVar, C0287g gVar) {
        String a = cVar.mo4808a();
        if (this.f98a.isDebugEnabled()) {
            this.f98a.debug("Re-using cached '" + a + "' auth scheme for " + nVar);
        }
        C0233n a2 = gVar.mo4934a(new C0227h(nVar, C0227h.f25a, a));
        if (a2 != null) {
            if ("BASIC".equalsIgnoreCase(cVar.mo4808a())) {
                iVar.mo4825a(C0221b.CHALLENGED);
            } else {
                iVar.mo4825a(C0221b.SUCCESS);
            }
            iVar.mo4826a(cVar, a2);
            return;
        }
        this.f98a.debug("No credentials for preemptive authentication");
    }

    /* renamed from: a */
    public final void mo4917a(C0568q qVar, C0553e eVar) {
        C0222c a;
        C0222c a2;
        C0250b.m84a((Object) qVar, "HTTP request");
        C0250b.m84a((Object) eVar, "HTTP context");
        C0270a a3 = C0270a.m151a(eVar);
        C0248a f = a3.mo4913f();
        if (f == null) {
            this.f98a.debug("Auth cache not set in the context");
            return;
        }
        C0287g e = a3.mo4912e();
        if (e == null) {
            this.f98a.debug("Credentials provider not set in the context");
            return;
        }
        C0309e a4 = a3.mo4908a();
        C0565n k = a3.mo5410k();
        C0565n nVar = k.mo5442b() < 0 ? new C0565n(k.mo5441a(), a4.mo4964a().mo5442b(), k.mo5443c()) : k;
        C0228i g = a3.mo4914g();
        if (!(g == null || g.mo4827b() != C0221b.UNCHALLENGED || (a2 = f.mo4872a(nVar)) == null)) {
            m163a(nVar, a2, g, e);
        }
        C0565n d = a4.mo4969d();
        C0228i h = a3.mo4915h();
        if (d != null && h != null && h.mo4827b() == C0221b.UNCHALLENGED && (a = f.mo4872a(d)) != null) {
            m163a(d, a, h, e);
        }
    }
}
