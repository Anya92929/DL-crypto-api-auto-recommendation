package org.p004a.p005a.p007b.p011d;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0513h;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.C0572u;
import org.p004a.p005a.p007b.C0286f;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0352h;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.b.d.j */
public final class C0279j implements C0572u {

    /* renamed from: a */
    private final Log f103a = LogFactory.getLog(getClass());

    /* renamed from: a */
    private void m171a(C0513h hVar, C0352h hVar2, C0349e eVar, C0286f fVar) {
        while (hVar.hasNext()) {
            C0344e a = hVar.mo5316a();
            try {
                for (C0346b bVar : hVar2.mo5065a(a, eVar)) {
                    try {
                        hVar2.mo5066a(bVar, eVar);
                        fVar.mo4933a(bVar);
                        if (this.f103a.isDebugEnabled()) {
                            this.f103a.debug("Cookie accepted: \"" + bVar + "\". ");
                        }
                    } catch (C0357m e) {
                        if (this.f103a.isWarnEnabled()) {
                            this.f103a.warn("Cookie rejected: \"" + bVar + "\". " + e.getMessage());
                        }
                    }
                }
            } catch (C0357m e2) {
                if (this.f103a.isWarnEnabled()) {
                    this.f103a.warn("Invalid cookie header: \"" + a + "\". " + e2.getMessage());
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo4919a(C0570s sVar, C0553e eVar) {
        C0250b.m84a((Object) sVar, "HTTP request");
        C0250b.m84a((Object) eVar, "HTTP context");
        C0270a a = C0270a.m151a(eVar);
        C0352h hVar = (C0352h) a.mo5408a("http.cookie-spec", C0352h.class);
        if (hVar == null) {
            this.f103a.debug("Cookie spec not specified in HTTP context");
            return;
        }
        C0286f b = a.mo4909b();
        if (b == null) {
            this.f103a.debug("Cookie store not specified in HTTP context");
            return;
        }
        C0349e eVar2 = (C0349e) a.mo5408a("http.cookie-origin", C0349e.class);
        if (eVar2 == null) {
            this.f103a.debug("Cookie origin not specified in HTTP context");
            return;
        }
        m171a(sVar.mo5330e("Set-Cookie"), hVar, eVar2, b);
        if (hVar.mo5063a() > 0) {
            m171a(sVar.mo5330e("Set-Cookie2"), hVar, eVar2, b);
        }
    }
}
