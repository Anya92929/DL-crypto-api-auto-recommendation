package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;

/* renamed from: com.google.a.b.a.aa */
final class C0368aa extends C0363al<Class> {
    C0368aa() {
    }

    /* renamed from: a */
    public Class mo6310b(C0470a aVar) {
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Class cls) {
        if (cls == null) {
            dVar.mo6405f();
            return;
        }
        throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
    }
}
