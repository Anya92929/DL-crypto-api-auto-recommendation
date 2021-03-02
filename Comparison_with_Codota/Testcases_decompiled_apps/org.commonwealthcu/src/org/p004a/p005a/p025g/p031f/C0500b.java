package org.p004a.p005a.p025g.p031f;

import org.p004a.p005a.C0513h;
import org.p004a.p005a.C0567p;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p032h.C0517d;
import org.p004a.p005a.p032h.C0520g;
import org.p004a.p005a.p033i.C0529h;
import org.p004a.p005a.p033i.C0539r;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.f.b */
public abstract class C0500b implements C0517d {

    /* renamed from: a */
    protected final C0520g f506a;

    /* renamed from: b */
    protected final C0563b f507b = new C0563b(128);

    /* renamed from: c */
    protected final C0539r f508c;

    public C0500b(C0520g gVar, C0539r rVar) {
        C0250b.m84a((Object) gVar, "Session input buffer");
        this.f506a = gVar;
        this.f508c = rVar == null ? C0529h.f581a : rVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo5279a(C0567p pVar);

    /* renamed from: b */
    public final void mo5280b(C0567p pVar) {
        C0250b.m84a((Object) pVar, "HTTP message");
        mo5279a(pVar);
        C0513h e = pVar.mo5329e();
        while (e.hasNext()) {
            this.f506a.mo5242a(this.f508c.mo5351a(this.f507b, e.mo5316a()));
        }
        this.f507b.mo5426a();
        this.f506a.mo5242a(this.f507b);
    }
}
