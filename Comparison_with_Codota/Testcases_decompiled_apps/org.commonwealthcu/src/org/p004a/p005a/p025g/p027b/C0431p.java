package org.p004a.p005a.p025g.p027b;

import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0548l;

/* renamed from: org.a.a.g.b.p */
public final class C0431p extends C0437v implements C0548l {

    /* renamed from: c */
    private C0546k f396c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f397d;

    public C0431p(C0548l lVar) {
        super(lVar);
        C0546k b = lVar.mo4896b();
        this.f396c = b != null ? new C0432q(this, b) : null;
        this.f397d = false;
    }

    /* renamed from: a */
    public final boolean mo4895a() {
        C0344e c = mo5326c("Expect");
        return c != null && "100-continue".equalsIgnoreCase(c.mo5041d());
    }

    /* renamed from: b */
    public final C0546k mo4896b() {
        return this.f396c;
    }

    /* renamed from: j */
    public final boolean mo5200j() {
        return this.f396c == null || this.f396c.mo4952a() || !this.f397d;
    }
}
