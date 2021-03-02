package com.google.p008a.p013d;

import com.google.p008a.p010b.C0461u;
import com.google.p008a.p010b.p011a.C0408h;

/* renamed from: com.google.a.d.b */
final class C0471b extends C0461u {
    C0471b() {
    }

    /* renamed from: a */
    public void mo6466a(C0470a aVar) {
        if (aVar instanceof C0408h) {
            ((C0408h) aVar).mo6390o();
            return;
        }
        int a = aVar.f3588i;
        if (a == 0) {
            a = aVar.mo6390o();
        }
        if (a == 13) {
            int unused = aVar.f3588i = 9;
        } else if (a == 12) {
            int unused2 = aVar.f3588i = 8;
        } else if (a == 14) {
            int unused3 = aVar.f3588i = 10;
        } else {
            throw new IllegalStateException("Expected a name but was " + aVar.mo6381f() + " " + " at line " + aVar.m2823v() + " column " + aVar.m2824w() + " path " + aVar.mo6501q());
        }
    }
}
