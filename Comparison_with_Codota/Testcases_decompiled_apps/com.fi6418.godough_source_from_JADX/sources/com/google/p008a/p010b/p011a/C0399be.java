package com.google.p008a.p010b.p011a;

import com.google.p008a.C0356ae;
import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;

/* renamed from: com.google.a.b.a.be */
final class C0399be extends C0363al<Number> {
    C0399be() {
    }

    /* renamed from: a */
    public Number mo6310b(C0470a aVar) {
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        try {
            return Integer.valueOf(aVar.mo6388m());
        } catch (NumberFormatException e) {
            throw new C0356ae((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Number number) {
        dVar.mo6395a(number);
    }
}
