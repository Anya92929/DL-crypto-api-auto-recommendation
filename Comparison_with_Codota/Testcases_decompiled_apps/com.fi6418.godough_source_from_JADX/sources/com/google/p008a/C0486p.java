package com.google.p008a;

import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;

/* renamed from: com.google.a.p */
class C0486p extends C0363al<Number> {

    /* renamed from: a */
    final /* synthetic */ C0481k f3632a;

    C0486p(C0481k kVar) {
        this.f3632a = kVar;
    }

    /* renamed from: a */
    public Number mo6310b(C0470a aVar) {
        if (aVar.mo6381f() != C0472c.NULL) {
            return Long.valueOf(aVar.mo6387l());
        }
        aVar.mo6385j();
        return null;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Number number) {
        if (number == null) {
            dVar.mo6405f();
        } else {
            dVar.mo6400b(number.toString());
        }
    }
}
