package org.p004a.p005a.p025g.p027b;

import java.security.Principal;
import javax.net.ssl.SSLSession;
import org.p004a.p005a.C0542j;
import org.p004a.p005a.p006a.C0222c;
import org.p004a.p005a.p006a.C0228i;
import org.p004a.p005a.p006a.C0233n;
import org.p004a.p005a.p007b.C0296p;
import org.p004a.p005a.p007b.p011d.C0270a;
import org.p004a.p005a.p014d.C0340n;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.b.o */
public final class C0430o implements C0296p {
    static {
        new C0430o();
    }

    /* renamed from: a */
    private static Principal m696a(C0228i iVar) {
        C0233n d;
        C0222c c = iVar.mo4828c();
        if (c == null || !c.mo4813d() || !c.mo4812c() || (d = iVar.mo4829d()) == null) {
            return null;
        }
        return d.mo4837a();
    }

    /* renamed from: a */
    public final Object mo4941a(C0553e eVar) {
        SSLSession m;
        C0270a a = C0270a.m151a(eVar);
        Principal principal = null;
        C0228i g = a.mo4914g();
        if (g != null && (principal = m696a(g)) == null) {
            principal = m696a(a.mo4915h());
        }
        if (principal == null) {
            C0542j j = a.mo5409j();
            if (j.mo5246c() && (j instanceof C0340n) && (m = ((C0340n) j).mo5033m()) != null) {
                return m.getLocalPrincipal();
            }
        }
        return principal;
    }
}
