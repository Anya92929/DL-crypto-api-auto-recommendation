package com.google.p008a;

import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;

/* renamed from: com.google.a.n */
class C0484n extends C0363al<Number> {

    /* renamed from: a */
    final /* synthetic */ C0481k f3630a;

    C0484n(C0481k kVar) {
        this.f3630a = kVar;
    }

    /* renamed from: a */
    public Double mo6310b(C0470a aVar) {
        if (aVar.mo6381f() != C0472c.NULL) {
            return Double.valueOf(aVar.mo6386k());
        }
        aVar.mo6385j();
        return null;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Number number) {
        if (number == null) {
            dVar.mo6405f();
            return;
        }
        this.f3630a.m2882a(number.doubleValue());
        dVar.mo6395a(number);
    }
}
