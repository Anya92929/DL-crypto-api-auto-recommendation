package com.google.p008a;

import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;

/* renamed from: com.google.a.o */
class C0485o extends C0363al<Number> {

    /* renamed from: a */
    final /* synthetic */ C0481k f3631a;

    C0485o(C0481k kVar) {
        this.f3631a = kVar;
    }

    /* renamed from: a */
    public Float mo6310b(C0470a aVar) {
        if (aVar.mo6381f() != C0472c.NULL) {
            return Float.valueOf((float) aVar.mo6386k());
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
        this.f3631a.m2882a((double) number.floatValue());
        dVar.mo6395a(number);
    }
}
