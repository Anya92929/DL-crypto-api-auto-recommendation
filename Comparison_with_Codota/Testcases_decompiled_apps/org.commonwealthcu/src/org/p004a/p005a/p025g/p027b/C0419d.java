package org.p004a.p005a.p025g.p027b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import org.p004a.p005a.p007b.C0286f;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0348d;

/* renamed from: org.a.a.g.b.d */
public final class C0419d implements Serializable, C0286f {

    /* renamed from: a */
    private final TreeSet f362a = new TreeSet(new C0348d());

    /* renamed from: a */
    public final synchronized List mo4932a() {
        return new ArrayList(this.f362a);
    }

    /* renamed from: a */
    public final synchronized void mo4933a(C0346b bVar) {
        if (bVar != null) {
            this.f362a.remove(bVar);
            if (!bVar.mo5046a(new Date())) {
                this.f362a.add(bVar);
            }
        }
    }

    public final synchronized String toString() {
        return this.f362a.toString();
    }
}
