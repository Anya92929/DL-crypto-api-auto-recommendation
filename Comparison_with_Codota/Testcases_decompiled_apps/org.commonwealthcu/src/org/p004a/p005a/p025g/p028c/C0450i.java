package org.p004a.p005a.p025g.p028c;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.p004a.p005a.p014d.C0341o;
import org.p004a.p005a.p014d.p016b.C0306b;
import org.p004a.p005a.p014d.p016b.C0312h;
import org.p004a.p005a.p035k.C0547a;

/* renamed from: org.a.a.g.c.i */
final class C0450i extends C0547a {

    /* renamed from: a */
    private final Log f436a;

    /* renamed from: b */
    private final C0312h f437b;

    public C0450i(Log log, String str, C0306b bVar, C0341o oVar, long j, TimeUnit timeUnit) {
        super(str, bVar, oVar, 0, timeUnit);
        this.f436a = log;
        this.f437b = new C0312h(bVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C0312h mo5228a() {
        return this.f437b;
    }

    /* renamed from: a */
    public final boolean mo5229a(long j) {
        boolean a = super.mo5229a(j);
        if (a && this.f436a.isDebugEnabled()) {
            this.f436a.debug("Connection " + this + " expired @ " + new Date(mo5397g()));
        }
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final C0306b mo5230b() {
        return this.f437b.mo4986j();
    }

    /* renamed from: c */
    public final boolean mo5231c() {
        return !((C0341o) mo5396f()).mo5246c();
    }

    /* renamed from: d */
    public final void mo5232d() {
        try {
            ((C0341o) mo5396f()).close();
        } catch (IOException e) {
            this.f436a.debug("I/O error closing connection", e);
        }
    }
}
