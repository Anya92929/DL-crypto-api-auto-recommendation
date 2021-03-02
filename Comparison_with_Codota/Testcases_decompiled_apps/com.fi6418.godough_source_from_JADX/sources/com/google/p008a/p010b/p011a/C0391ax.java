package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;

/* renamed from: com.google.a.b.a.ax */
final class C0391ax extends C0363al<Boolean> {
    C0391ax() {
    }

    /* renamed from: a */
    public Boolean mo6310b(C0470a aVar) {
        if (aVar.mo6381f() != C0472c.NULL) {
            return aVar.mo6381f() == C0472c.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.mo6383h())) : Boolean.valueOf(aVar.mo6384i());
        }
        aVar.mo6385j();
        return null;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Boolean bool) {
        if (bool == null) {
            dVar.mo6405f();
        } else {
            dVar.mo6397a(bool.booleanValue());
        }
    }
}
