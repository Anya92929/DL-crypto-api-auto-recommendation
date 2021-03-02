package org.p004a.p005a.p007b.p011d;

import org.p004a.p005a.C0568q;
import org.p004a.p005a.p006a.C0228i;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p014d.C0338l;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.b.d.h */
public final class C0277h extends C0273d {
    /* renamed from: a */
    public final void mo4917a(C0568q qVar, C0553e eVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        C0250b.m84a((Object) eVar, "HTTP context");
        if (!qVar.mo5323a("Proxy-Authorization")) {
            C0338l lVar = (C0338l) eVar.mo5221a("http.connection");
            if (lVar == null) {
                this.f99a.debug("HTTP connection not set in the context");
            } else if (!lVar.mo5025j().mo4970e()) {
                C0228i iVar = (C0228i) eVar.mo5221a("http.auth.proxy-scope");
                if (iVar == null) {
                    this.f99a.debug("Proxy auth state not set in the context");
                    return;
                }
                if (this.f99a.isDebugEnabled()) {
                    this.f99a.debug("Proxy auth state: " + iVar.mo4827b());
                }
                mo4918a(iVar, qVar, eVar);
            }
        }
    }
}
