package com.google.p008a.p010b.p011a;

import com.google.p008a.C0356ae;
import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.math.BigDecimal;

/* renamed from: com.google.a.b.a.af */
final class C0373af extends C0363al<BigDecimal> {
    C0373af() {
    }

    /* renamed from: a */
    public BigDecimal mo6310b(C0470a aVar) {
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        try {
            return new BigDecimal(aVar.mo6383h());
        } catch (NumberFormatException e) {
            throw new C0356ae((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, BigDecimal bigDecimal) {
        dVar.mo6395a((Number) bigDecimal);
    }
}
