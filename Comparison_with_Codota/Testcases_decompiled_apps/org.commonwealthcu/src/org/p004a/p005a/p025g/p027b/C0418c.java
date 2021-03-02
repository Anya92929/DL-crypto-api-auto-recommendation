package org.p004a.p005a.p025g.p027b;

import java.util.HashMap;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.p006a.C0222c;
import org.p004a.p005a.p007b.C0248a;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p014d.C0342p;
import org.p004a.p005a.p014d.C0343q;
import org.p004a.p005a.p025g.p028c.C0449h;

/* renamed from: org.a.a.g.b.c */
public final class C0418c implements C0248a {

    /* renamed from: a */
    private final HashMap f360a;

    /* renamed from: b */
    private final C0342p f361b;

    public C0418c() {
        this((C0342p) null);
    }

    private C0418c(C0342p pVar) {
        this.f360a = new HashMap();
        this.f361b = C0449h.f435a;
    }

    /* renamed from: c */
    private C0565n m664c(C0565n nVar) {
        if (nVar.mo5442b() > 0) {
            return nVar;
        }
        try {
            return new C0565n(nVar.mo5441a(), this.f361b.mo5039a(nVar), nVar.mo5443c());
        } catch (C0343q e) {
            return nVar;
        }
    }

    /* renamed from: a */
    public final C0222c mo4872a(C0565n nVar) {
        C0250b.m84a((Object) nVar, "HTTP host");
        return (C0222c) this.f360a.get(m664c(nVar));
    }

    /* renamed from: a */
    public final void mo4873a(C0565n nVar, C0222c cVar) {
        C0250b.m84a((Object) nVar, "HTTP host");
        this.f360a.put(m664c(nVar), cVar);
    }

    /* renamed from: b */
    public final void mo4874b(C0565n nVar) {
        C0250b.m84a((Object) nVar, "HTTP host");
        this.f360a.remove(m664c(nVar));
    }

    public final String toString() {
        return this.f360a.toString();
    }
}
