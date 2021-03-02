package org.p004a.p005a.p025g.p030e;

import java.io.OutputStream;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0567p;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p022f.C0379d;
import org.p004a.p005a.p025g.p031f.C0504f;
import org.p004a.p005a.p025g.p031f.C0506h;
import org.p004a.p005a.p025g.p031f.C0510l;
import org.p004a.p005a.p032h.C0520g;

/* renamed from: org.a.a.g.e.b */
public final class C0495b {

    /* renamed from: a */
    private final C0379d f495a;

    public C0495b(C0379d dVar) {
        this.f495a = (C0379d) C0250b.m84a((Object) dVar, "Content length strategy");
    }

    /* renamed from: a */
    public final void mo5274a(C0520g gVar, C0567p pVar, C0546k kVar) {
        C0250b.m84a((Object) gVar, "Session output buffer");
        C0250b.m84a((Object) pVar, "HTTP message");
        C0250b.m84a((Object) kVar, "HTTP entity");
        long a = this.f495a.mo5120a(pVar);
        OutputStream fVar = a == -2 ? new C0504f(gVar) : a == -1 ? new C0510l(gVar) : new C0506h(gVar, a);
        kVar.mo4951a(fVar);
        fVar.close();
    }
}
