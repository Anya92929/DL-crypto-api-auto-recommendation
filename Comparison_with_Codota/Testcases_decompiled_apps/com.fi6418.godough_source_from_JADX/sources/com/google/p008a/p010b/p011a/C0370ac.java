package com.google.p008a.p010b.p011a;

import com.google.p008a.C0356ae;
import com.google.p008a.C0363al;
import com.google.p008a.p010b.C0462v;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;

/* renamed from: com.google.a.b.a.ac */
final class C0370ac extends C0363al<Number> {
    C0370ac() {
    }

    /* renamed from: a */
    public Number mo6310b(C0470a aVar) {
        C0472c f = aVar.mo6381f();
        switch (C0395ba.f3398a[f.ordinal()]) {
            case 1:
                return new C0462v(aVar.mo6383h());
            case 4:
                aVar.mo6385j();
                return null;
            default:
                throw new C0356ae("Expecting number, got: " + f);
        }
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Number number) {
        dVar.mo6395a(number);
    }
}
