package org.p004a.p005a.p007b.p010c;

import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0548l;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.b.c.g */
public abstract class C0260g extends C0264k implements C0548l {

    /* renamed from: c */
    private C0546k f84c;

    /* renamed from: a */
    public final void mo4894a(C0546k kVar) {
        this.f84c = kVar;
    }

    /* renamed from: a */
    public final boolean mo4895a() {
        C0344e c = mo5326c("Expect");
        return c != null && "100-continue".equalsIgnoreCase(c.mo5041d());
    }

    /* renamed from: b */
    public final C0546k mo4896b() {
        return this.f84c;
    }

    public Object clone() {
        C0260g gVar = (C0260g) super.clone();
        if (this.f84c != null) {
            gVar.f84c = (C0546k) C0250b.m83a((Object) this.f84c);
        }
        return gVar;
    }
}
