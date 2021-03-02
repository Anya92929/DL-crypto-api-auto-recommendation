package org.p004a.p005a.p025g.p027b;

import org.p004a.p005a.C0360f;
import org.p004a.p005a.C0383g;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p014d.C0331f;

/* renamed from: org.a.a.g.b.j */
public final class C0425j implements C0331f {
    static {
        new C0425j();
    }

    /* renamed from: a */
    public final long mo5016a(C0570s sVar) {
        C0250b.m84a((Object) sVar, "HTTP response");
        C0383g gVar = new C0383g(sVar.mo5330e("Keep-Alive"));
        while (gVar.hasNext()) {
            C0360f a = gVar.mo5125a();
            String a2 = a.mo5080a();
            String b = a.mo5083b();
            if (b != null && a2.equalsIgnoreCase("timeout")) {
                try {
                    return Long.parseLong(b) * 1000;
                } catch (NumberFormatException e) {
                }
            }
        }
        return -1;
    }
}
