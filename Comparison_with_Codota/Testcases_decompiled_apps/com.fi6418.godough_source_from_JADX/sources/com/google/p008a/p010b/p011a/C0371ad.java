package com.google.p008a.p010b.p011a;

import com.google.p008a.C0356ae;
import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;

/* renamed from: com.google.a.b.a.ad */
final class C0371ad extends C0363al<Character> {
    C0371ad() {
    }

    /* renamed from: a */
    public Character mo6310b(C0470a aVar) {
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        String h = aVar.mo6383h();
        if (h.length() == 1) {
            return Character.valueOf(h.charAt(0));
        }
        throw new C0356ae("Expecting character, got: " + h);
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Character ch) {
        dVar.mo6400b(ch == null ? null : String.valueOf(ch));
    }
}
