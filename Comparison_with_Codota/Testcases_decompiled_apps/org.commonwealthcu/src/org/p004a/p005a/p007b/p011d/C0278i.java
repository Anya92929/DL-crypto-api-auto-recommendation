package org.p004a.p005a.p007b.p011d;

import org.p004a.p005a.C0568q;
import org.p004a.p005a.p006a.C0228i;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.b.d.i */
public final class C0278i extends C0273d {
    /* renamed from: a */
    public final void mo4917a(C0568q qVar, C0553e eVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        C0250b.m84a((Object) eVar, "HTTP context");
        if (!qVar.mo4902g().mo4863a().equalsIgnoreCase("CONNECT") && !qVar.mo5323a("Authorization")) {
            C0228i iVar = (C0228i) eVar.mo5221a("http.auth.target-scope");
            if (iVar == null) {
                this.f99a.debug("Target auth state not set in the context");
                return;
            }
            if (this.f99a.isDebugEnabled()) {
                this.f99a.debug("Target auth state: " + iVar.mo4827b());
            }
            mo4918a(iVar, qVar, eVar);
        }
    }
}
