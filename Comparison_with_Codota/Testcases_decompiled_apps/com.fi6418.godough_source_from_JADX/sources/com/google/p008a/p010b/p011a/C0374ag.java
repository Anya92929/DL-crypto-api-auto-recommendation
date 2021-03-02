package com.google.p008a.p010b.p011a;

import com.google.p008a.C0356ae;
import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.math.BigInteger;

/* renamed from: com.google.a.b.a.ag */
final class C0374ag extends C0363al<BigInteger> {
    C0374ag() {
    }

    /* renamed from: a */
    public BigInteger mo6310b(C0470a aVar) {
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        try {
            return new BigInteger(aVar.mo6383h());
        } catch (NumberFormatException e) {
            throw new C0356ae((Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, BigInteger bigInteger) {
        dVar.mo6395a((Number) bigInteger);
    }
}
