package org.p004a.p005a.p025g.p028c;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.p004a.p005a.C0240ab;
import org.p004a.p005a.C0567p;
import org.p004a.p005a.C0571t;
import org.p004a.p005a.C0577z;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p025g.p031f.C0499a;
import org.p004a.p005a.p032h.C0519f;
import org.p004a.p005a.p033i.C0540s;
import org.p004a.p005a.p033i.C0541t;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.c.f */
public final class C0447f extends C0499a {

    /* renamed from: b */
    private final Log f431b = LogFactory.getLog(getClass());

    /* renamed from: c */
    private final C0571t f432c;

    /* renamed from: d */
    private final C0563b f433d;

    public C0447f(C0519f fVar, C0540s sVar, C0571t tVar, C0544b bVar) {
        super(fVar, (C0540s) null, bVar);
        C0250b.m84a((Object) tVar, "Response factory");
        this.f432c = tVar;
        this.f433d = new C0563b(128);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final /* synthetic */ C0567p mo5227a(C0519f fVar) {
        int i = 0;
        while (true) {
            this.f433d.mo5426a();
            int a = fVar.mo5234a(this.f433d);
            if (a == -1 && i == 0) {
                throw new C0577z("The target server failed to respond");
            }
            C0541t tVar = new C0541t(0, this.f433d.mo5435c());
            if (this.f500a.mo5353a(this.f433d, tVar)) {
                return this.f432c.mo5218a(this.f500a.mo5354b(this.f433d, tVar));
            } else if (a == -1) {
                throw new C0240ab("The server failed to respond with a valid HTTP response");
            } else {
                if (this.f431b.isDebugEnabled()) {
                    this.f431b.debug("Garbage in response: " + this.f433d.toString());
                }
                i++;
            }
        }
    }
}
