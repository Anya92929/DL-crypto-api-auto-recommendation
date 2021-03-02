package org.p004a.p005a.p007b.p011d;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p014d.p016b.C0309e;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.b.d.f */
public final class C0275f implements C0569r {

    /* renamed from: a */
    private final Log f101a = LogFactory.getLog(getClass());

    /* renamed from: a */
    public final void mo4917a(C0568q qVar, C0553e eVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        if (qVar.mo4902g().mo4863a().equalsIgnoreCase("CONNECT")) {
            qVar.mo5324b("Proxy-Connection", "Keep-Alive");
            return;
        }
        C0309e a = C0270a.m151a(eVar).mo4908a();
        if (a == null) {
            this.f101a.debug("Connection route not set in the context");
            return;
        }
        if ((a.mo4967c() == 1 || a.mo4970e()) && !qVar.mo5323a("Connection")) {
            qVar.mo5319a("Connection", "Keep-Alive");
        }
        if (a.mo4967c() == 2 && !a.mo4970e() && !qVar.mo5323a("Proxy-Connection")) {
            qVar.mo5319a("Proxy-Connection", "Keep-Alive");
        }
    }
}
