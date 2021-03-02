package org.p004a.p005a.p036l;

import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.a.a.l.l */
public final class C0560l implements C0569r {

    /* renamed from: a */
    private final String f630a;

    public C0560l() {
        this((String) null);
    }

    private C0560l(String str) {
        this.f630a = null;
    }

    /* renamed from: a */
    public final void mo4917a(C0568q qVar, C0553e eVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        if (!qVar.mo5323a("User-Agent")) {
            String str = null;
            C0544b f = qVar.mo5331f();
            if (f != null) {
                str = (String) f.mo5196a("http.useragent");
            }
            if (str == null) {
                str = this.f630a;
            }
            if (str != null) {
                qVar.mo5319a("User-Agent", str);
            }
        }
    }
}
