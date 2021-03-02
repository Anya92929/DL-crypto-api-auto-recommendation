package org.p004a.p005a.p025g.p028c;

import java.net.InetAddress;
import org.p004a.p005a.C0561m;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0266m;
import org.p004a.p005a.p014d.p015a.C0303a;
import org.p004a.p005a.p014d.p016b.C0306b;
import org.p004a.p005a.p014d.p016b.C0308d;
import org.p004a.p005a.p014d.p017c.C0319f;

/* renamed from: org.a.a.g.c.g */
public final class C0448g implements C0308d {

    /* renamed from: a */
    private C0319f f434a;

    public C0448g(C0319f fVar) {
        C0250b.m84a((Object) fVar, "Scheme registry");
        this.f434a = fVar;
    }

    /* renamed from: a */
    public final C0306b mo4976a(C0565n nVar, C0568q qVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        C0306b b = C0303a.m227b(qVar.mo5331f());
        if (b != null) {
            return b;
        }
        C0266m.m145a((Object) nVar, "Target host");
        InetAddress c = C0303a.m228c(qVar.mo5331f());
        C0565n a = C0303a.m226a(qVar.mo5331f());
        try {
            boolean d = this.f434a.mo5004a(nVar.mo5443c()).mo4999d();
            return a == null ? new C0306b(nVar, c, d) : new C0306b(nVar, c, a, d);
        } catch (IllegalStateException e) {
            throw new C0561m(e.getMessage());
        }
    }
}
