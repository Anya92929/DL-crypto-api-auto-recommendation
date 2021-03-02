package org.p004a.p005a.p025g.p027b;

import java.nio.charset.Charset;
import org.p004a.p005a.C0244af;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.p007b.C0290j;
import org.p004a.p005a.p007b.C0295o;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.g.b.f */
public final class C0421f implements C0295o {
    /* renamed from: a */
    public final /* synthetic */ Object mo4940a(C0570s sVar) {
        C0244af a = sVar.mo5345a();
        C0546k b = sVar.mo5347b();
        if (a.mo4867b() >= 300) {
            C0250b.m94a(b);
            throw new C0290j(a.mo4867b(), a.mo4868c());
        } else if (b == null) {
            return null;
        } else {
            return C0250b.m85a(b, (Charset) null);
        }
    }
}
