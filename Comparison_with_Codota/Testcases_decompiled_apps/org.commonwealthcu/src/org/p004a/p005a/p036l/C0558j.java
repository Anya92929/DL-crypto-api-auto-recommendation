package org.p004a.p005a.p036l;

import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0548l;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.C0573v;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.l.j */
public final class C0558j implements C0569r {

    /* renamed from: a */
    private final boolean f629a;

    public C0558j() {
        this(false);
    }

    private C0558j(boolean z) {
        this.f629a = false;
    }

    /* renamed from: a */
    public final void mo4917a(C0568q qVar, C0553e eVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        if (!qVar.mo5323a("Expect") && (qVar instanceof C0548l)) {
            C0241ac b = qVar.mo4902g().mo4864b();
            C0546k b2 = ((C0548l) qVar).mo4896b();
            if (b2 != null && b2.mo5116c() != 0 && !b.mo4856a(C0573v.f644a) && qVar.mo5331f().mo5390a("http.protocol.expect-continue", this.f629a)) {
                qVar.mo5319a("Expect", "100-continue");
            }
        }
    }
}
