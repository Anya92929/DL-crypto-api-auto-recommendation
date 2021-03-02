package org.p004a.p005a.p036l;

import org.p004a.p005a.C0240ab;
import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0548l;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.C0573v;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.l.i */
public final class C0557i implements C0569r {

    /* renamed from: a */
    private final boolean f628a;

    public C0557i() {
        this(false);
    }

    private C0557i(boolean z) {
        this.f628a = false;
    }

    /* renamed from: a */
    public final void mo4917a(C0568q qVar, C0553e eVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        if (qVar instanceof C0548l) {
            if (this.f628a) {
                qVar.mo5327d("Transfer-Encoding");
                qVar.mo5327d("Content-Length");
            } else if (qVar.mo5323a("Transfer-Encoding")) {
                throw new C0240ab("Transfer-encoding header already present");
            } else if (qVar.mo5323a("Content-Length")) {
                throw new C0240ab("Content-Length header already present");
            }
            C0241ac b = qVar.mo4902g().mo4864b();
            C0546k b2 = ((C0548l) qVar).mo4896b();
            if (b2 == null) {
                qVar.mo5319a("Content-Length", "0");
                return;
            }
            if (!b2.mo5090b() && b2.mo5116c() >= 0) {
                qVar.mo5319a("Content-Length", Long.toString(b2.mo5116c()));
            } else if (b.mo4856a(C0573v.f644a)) {
                throw new C0240ab("Chunked transfer encoding not allowed for " + b);
            } else {
                qVar.mo5319a("Transfer-Encoding", "chunked");
            }
            if (b2.mo5091d() != null && !qVar.mo5323a("Content-Type")) {
                qVar.mo5320a(b2.mo5091d());
            }
            if (b2.mo5092e() != null && !qVar.mo5323a("Content-Encoding")) {
                qVar.mo5320a(b2.mo5092e());
            }
        }
    }
}
