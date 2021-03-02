package org.p004a.p005a.p025g.p031f;

import org.p004a.p005a.C0567p;
import org.p004a.p005a.C0571t;
import org.p004a.p005a.C0577z;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p032h.C0519f;
import org.p004a.p005a.p033i.C0540s;
import org.p004a.p005a.p033i.C0541t;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.f.i */
public final class C0507i extends C0499a {

    /* renamed from: b */
    private final C0571t f554b;

    /* renamed from: c */
    private final C0563b f555c = new C0563b(128);

    public C0507i(C0519f fVar, C0540s sVar, C0571t tVar, C0544b bVar) {
        super(fVar, (C0540s) null, bVar);
        this.f554b = (C0571t) C0250b.m84a((Object) tVar, "Response factory");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ C0567p mo5227a(C0519f fVar) {
        this.f555c.mo5426a();
        if (fVar.mo5234a(this.f555c) == -1) {
            throw new C0577z("The target server failed to respond");
        }
        return this.f554b.mo5218a(this.f500a.mo5354b(this.f555c, new C0541t(0, this.f555c.mo5435c())));
    }
}
