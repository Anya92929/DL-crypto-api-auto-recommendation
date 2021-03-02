package org.p004a.p005a.p025g;

import java.io.IOException;
import java.net.SocketTimeoutException;
import org.p004a.p005a.C0521i;
import org.p004a.p005a.C0548l;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.C0571t;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p025g.p030e.C0494a;
import org.p004a.p005a.p025g.p030e.C0495b;
import org.p004a.p005a.p025g.p030e.C0496c;
import org.p004a.p005a.p025g.p030e.C0497d;
import org.p004a.p005a.p025g.p031f.C0507i;
import org.p004a.p005a.p025g.p031f.C0508j;
import org.p004a.p005a.p032h.C0515b;
import org.p004a.p005a.p032h.C0516c;
import org.p004a.p005a.p032h.C0517d;
import org.p004a.p005a.p032h.C0519f;
import org.p004a.p005a.p032h.C0520g;
import org.p004a.p005a.p033i.C0539r;
import org.p004a.p005a.p033i.C0540s;
import org.p004a.p005a.p034j.C0544b;

/* renamed from: org.a.a.g.a */
public abstract class C0384a implements C0521i {

    /* renamed from: a */
    private final C0495b f240a = new C0495b(new C0497d());

    /* renamed from: b */
    private final C0494a f241b = new C0494a(new C0496c());

    /* renamed from: c */
    private C0519f f242c = null;

    /* renamed from: d */
    private C0520g f243d = null;

    /* renamed from: e */
    private C0515b f244e = null;

    /* renamed from: f */
    private C0516c f245f = null;

    /* renamed from: g */
    private C0517d f246g = null;

    /* renamed from: h */
    private C0493e f247h = null;

    /* renamed from: f */
    private boolean mo5247f() {
        return this.f244e != null && this.f244e.mo5238c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0516c mo5129a(C0519f fVar, C0571t tVar, C0544b bVar) {
        return new C0507i(fVar, (C0540s) null, tVar, bVar);
    }

    /* renamed from: a */
    public C0570s mo5130a() {
        mo5138j();
        C0570s sVar = (C0570s) this.f245f.mo5278a();
        if (sVar.mo5345a().mo4867b() >= 200) {
            this.f247h.mo5272b();
        }
        return sVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5131a(C0519f fVar, C0520g gVar, C0544b bVar) {
        this.f242c = (C0519f) C0250b.m84a((Object) fVar, "Input session buffer");
        this.f243d = (C0520g) C0250b.m84a((Object) gVar, "Output session buffer");
        if (fVar instanceof C0515b) {
            this.f244e = (C0515b) fVar;
        }
        this.f245f = mo5129a(fVar, (C0571t) C0441c.f410a, bVar);
        this.f246g = new C0508j(gVar, (C0539r) null, bVar);
        this.f247h = new C0493e(fVar.mo5237b(), gVar.mo5244b());
    }

    /* renamed from: a */
    public final void mo5132a(C0548l lVar) {
        C0250b.m84a((Object) lVar, "HTTP request");
        mo5138j();
        if (lVar.mo4896b() != null) {
            this.f240a.mo5274a(this.f243d, lVar, lVar.mo4896b());
        }
    }

    /* renamed from: a */
    public void mo5133a(C0568q qVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        mo5138j();
        this.f246g.mo5280b(qVar);
        this.f247h.mo5271a();
    }

    /* renamed from: a */
    public final void mo5134a(C0570s sVar) {
        C0250b.m84a((Object) sVar, "HTTP response");
        mo5138j();
        sVar.mo5346a(this.f241b.mo5273a(this.f242c, sVar));
    }

    /* renamed from: a */
    public final boolean mo5135a(int i) {
        mo5138j();
        try {
            return this.f242c.mo5236a(i);
        } catch (SocketTimeoutException e) {
            return false;
        }
    }

    /* renamed from: b */
    public final void mo5136b() {
        mo5138j();
        mo5139k();
    }

    /* renamed from: d */
    public final boolean mo5137d() {
        if (!mo5246c() || mo5247f()) {
            return true;
        }
        try {
            this.f242c.mo5236a(1);
            return mo5247f();
        } catch (SocketTimeoutException e) {
            return false;
        } catch (IOException e2) {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public abstract void mo5138j();

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final void mo5139k() {
        this.f243d.mo5239a();
    }
}
