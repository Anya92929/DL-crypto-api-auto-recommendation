package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.net.URL;

/* renamed from: com.google.a.b.a.aj */
final class C0377aj extends C0363al<URL> {
    C0377aj() {
    }

    /* renamed from: a */
    public URL mo6310b(C0470a aVar) {
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        String h = aVar.mo6383h();
        if (!"null".equals(h)) {
            return new URL(h);
        }
        return null;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, URL url) {
        dVar.mo6400b(url == null ? null : url.toExternalForm());
    }
}
